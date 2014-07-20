package com.tianshao.cuige.domains.user;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Latitude;
import org.hibernate.search.annotations.Longitude;
import org.hibernate.search.annotations.Spatial;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.Reference;

import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.product.Product;
import com.tianshao.cuige.domains.trade.Trade;
@Spatial(name="location") @Indexed @Entity
@Table(name="user")
public class User implements IEntity{

	@Id
    @Column(name="userid")
    @GeneratedValue
	private int userid=-1;
	
	@Column(name="socialuid")
	private String socialuid;
	
	@OneToMany(mappedBy = "user")
	Set<UserRole> userRoles;
	
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	
	@Column(name="password")
	private String password;

	@Column(name="firstname")
	private String firstname="";
	
	@Column(name="lastname")
	private String lastname="";

	@Column(name="email")
	private String email="";
	
	@Column(name="aboutme")
	private String aboutme="";
	
	@Column(name="location")
	private String location="";
	
	@Column(name="image")
	private byte[] image;
	
	@Column(name="latitude")
	@Latitude(of="location")
	Double latitude=0.0;
	
	@Column(name="longitude")
    @Longitude(of="location")
    Double longitude=0.0;
	
//	
//	public User(String a, String b, boolean c, boolean d, boolean e, boolean f, Object g){
//		super(a, b, c, d, e, f, (Collection<? extends GrantedAuthority>) g);
//	}
	public User(int userid){
		this.userid=userid;
	}

	public User(){
	}

	public User(UserRegistrationDTO dto){
		
		
		this.email=dto.getEmail();
		this.firstname=dto.getFirstname();
		this.lastname=dto.getLastname();
		this.password=dto.getPassword();
		
	}
	


	public User(Facebook api) {
		FacebookProfile prof=api.userOperations().getUserProfile();
		this.setFirstname(prof.getFirstName());
		this.setLastname(prof.getLastName());
		this.setEmail(prof.getEmail());
		this.setEnabled(true);
		this.setImage(api.userOperations().getUserProfileImage());
		this.setLocation(prof.getLocation().getName());
		this.setPassword("Dummy Social Password");
		
	}

	public String getSocialuid() {
		return socialuid;
	}

	public void setSocialuid(String socialuid) {
		this.socialuid = socialuid;
	}

	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isSocialUserAndNeedImage() {
		// TODO Auto-generated method stub
		return false;
	}
	


	
}