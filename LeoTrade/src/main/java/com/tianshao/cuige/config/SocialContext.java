package com.tianshao.cuige.config;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;

import javax.sql.DataSource;

@Configuration
@EnableSocial
public class SocialContext implements SocialConfigurer {

    @Autowired
    private DataSource dataSource;
    
    private JdbcUsersConnectionRepository repository;
    

    /**
     * Configures the connection factories for Facebook and Twitter.
     * @param cfConfig
     * @param env
     */
    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {

        cfConfig.addConnectionFactory(new FacebookConnectionFactory(
        		"735073026515165",
    	        "e7803872fe0e1ee72b1d7e1860382ad3",
    	        "leotylertrade"
        ));
    }

    /**
     * The UserIdSource determines the account ID of the user. The example application
     * uses the username as the account ID.
     */
    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
    	JdbcUsersConnectionRepository repository= new JdbcUsersConnectionRepository(
                dataSource,
                connectionFactoryLocator,
                /**
                 * The TextEncryptor object encrypts the authorization details of the connection. In
                 * our example, the authorization details are stored as plain text.
                 * DO NOT USE THIS IN PRODUCTION.
                 */
                Encryptors.noOpText()
        );
	    repository.setConnectionSignUp(new SimpleConnectionSignUp());
	    this.repository=repository;
	    return repository;
    }
    
    public void disconnect(String socialuserId){
    	this.repository.createConnectionRepository(socialuserId).removeConnections(SocialUserId.toProviderId(socialuserId));
    }
    public Facebook facebook(String socialuserId) {
	    return repository.createConnectionRepository(socialuserId).getPrimaryConnection(Facebook.class).getApi();
	}
    /**
     * This bean manages the connection flow between the account provider and
     * the example application.
     */
    @Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        return new ConnectController(connectionFactoryLocator, connectionRepository);
    }
    
    public final class SimpleConnectionSignUp implements ConnectionSignUp {

		private final AtomicLong userIdSequence = new AtomicLong();
		@Override
		public String execute(Connection<?> connection) {
			return SocialUserId.fromKey(connection.getKey());
		}

	}
    
    public static class SocialUserId{
        private static final String socialuidSeperator=":";

    	public static String fromKey(ConnectionKey k){
    		return k.getProviderId()+socialuidSeperator+k.getProviderUserId();
    	}
    	public static String toProviderId(String socialuserid){
    		return socialuserid.split(socialuidSeperator)[0];
    	}
    }
}
