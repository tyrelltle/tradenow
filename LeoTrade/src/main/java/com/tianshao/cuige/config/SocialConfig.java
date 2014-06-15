package com.tianshao.cuige.config;

import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import com.tianshao.cuige.models.User;

@Configuration
public class SocialConfig {
	@Inject
	private DataSource dataSource;
	
	@Bean
	public ConnectionFactoryLocator connectionFactoryLocator() {
	    ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
	    registry.addConnectionFactory(new FacebookConnectionFactory("735073026515165",
	        "e7803872fe0e1ee72b1d7e1860382ad3"));
	    return registry;
	}
	
	@Bean
	public UsersConnectionRepository usersConnectionRepository() {
	    JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, 
	        connectionFactoryLocator(), Encryptors.noOpText());
	    repository.setConnectionSignUp(new SimpleConnectionSignUp());
	    return repository;
	}
	
	
	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	public ConnectionRepository connectionRepository() {
	    User user = SecurityContext.getCurrentUser();
	    return usersConnectionRepository().createConnectionRepository(String.valueOf(user.getUserid()));
	}
	
	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)   
	public Facebook facebook() {
	    return connectionRepository().getPrimaryConnection(Facebook.class).getApi();
	}
	@Bean
	public ProviderSignInController providerSignInController() {
	    return new ProviderSignInController(connectionFactoryLocator(), usersConnectionRepository(),
	        new SimpleSignInAdapter());
	}
	
	public final class SimpleConnectionSignUp implements ConnectionSignUp {

		private final AtomicLong userIdSequence = new AtomicLong();

		public String execute(Connection<?> connection) {
			return Long.toString(userIdSequence.incrementAndGet());
		}

	}

}
