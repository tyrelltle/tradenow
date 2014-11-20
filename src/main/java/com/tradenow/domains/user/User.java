package com.tradenow.domains.user;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;

import com.tradenow.domains.IEntity;
import com.tradenow.domains.product.Product;
import com.tradenow.shared.googlegeo.AddressConverter;
import com.tradenow.shared.googlegeo.GoogleResponse;
import com.tradenow.shared.googlegeo.Location;
@Entity
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
	
	@Column(name = "isnoob", nullable = false)
	private boolean isnoob;
	
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
	Double latitude=0.0;
	
	@Column(name="longitude")
    Double longitude=0.0;
	
	@OneToMany(fetch = FetchType.LAZY, 
		       cascade = {CascadeType.ALL}, 
		       mappedBy = "owner")
	@Fetch(FetchMode.SELECT)
	Set<Product> products=new HashSet<Product>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="favorite", 
	           joinColumns={@JoinColumn(name="userid")}, 
	           inverseJoinColumns={@JoinColumn(name="prod_id")})
	private Set<Product> favorites = new HashSet<Product>();
	
	@Transient
	private Set<Integer> favorite_lookup_map;
	
//	
//	public User(String a, String b, boolean c, boolean d, boolean e, boolean f, Object g){
//		super(a, b, c, d, e, f, (Collection<? extends GrantedAuthority>) g);
//	}
	public User(int userid){
		this.userid=userid;
	}

	public User(){
	}
	

	public static User newNativeUser(UserRegistrationDTO dto) throws IOException{
		
		User ret=new User();
		ret.email=dto.getEmail();
		ret.firstname=dto.getFirstname();
		ret.lastname=dto.getLastname();
		ret.password=dto.getPassword();
		
		if(dto.getLat()==null || dto.getLng()==null){
			AddressConverter a=new AddressConverter();
			GoogleResponse gres=a.convertToLatLong(dto.getLocation());
			Location loc=gres.getResults()[0].getGeometry().getLocation();
			ret.latitude=Double.valueOf(loc.getLat());
			ret.longitude=Double.valueOf(loc.getLng());
			
		}else{
			ret.latitude=Double.valueOf(dto.getLat());
			ret.longitude=Double.valueOf(dto.getLng());
			
		}
		
		
		ret.location=dto.getLocation();
		/*
		 * new user needs to be enabled by activating with email
		 */
		ret.setEnabled(false);
		return ret;
	}
	


	public static User newFacebookUser(Facebook api) {
		User ret=new User();
		String tmpval;
		FacebookProfile prof=api.userOperations().getUserProfile();
		tmpval=prof.getFirstName();
		ret.setFirstname(tmpval==null?" ":tmpval);
		tmpval=prof.getLastName();
		ret.setLastname(tmpval==null?" ":tmpval);
		tmpval=prof.getEmail();
		ret.setEmail(tmpval==null?" ":tmpval);
		ret.setEnabled(true);
		ret.setImage(api.userOperations().getUserProfileImage());
		try{
			ret.setLocation(prof.getLocation().getName());
		}catch(Exception e){
			//expected to not have location in facebook users profile
		}
		ret.setPassword("Dummy Social Password");
		return ret;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
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

	public String getFullName() {
		return this.firstname.toUpperCase()+" "+this.lastname.toUpperCase();
	}
	
	public void updateLocation(String location,double lat,double lng){
		if(!this.location.equals(location) || this.latitude!=lat||this.longitude!=lng){
			this.location=location;
			this.latitude=lat;
			this.longitude=lng;
			Iterator<Product> i=this.products.iterator();
			while(i.hasNext()){
				Product p=i.next();
				p.setLatitude(lat);
				p.setLongitude(lng);
			}
		}
		this.location=location;
		this.latitude=lat;
		this.longitude=lng;
	}

	public static UserDTO toUserDTO(User user) {
		UserDTO profwrap=new UserDTO();
        profwrap.setEmail(user.getEmail());
        profwrap.setFirstname(user.getFirstname());
        profwrap.setLastname(user.getLastname());
        profwrap.setLocation(user.getLocation());
        profwrap.setUserid(user.getUserid());
        profwrap.setAboutme(user.getAboutme());
        profwrap.setLat(String.valueOf(user.getLatitude()));
        profwrap.setLng(String.valueOf(user.getLongitude()));
        return profwrap;		
	}

	public void updateFromDTO(UserDTO wrap) {
		this.email=wrap.getEmail();
		this.firstname=wrap.getFirstname();
		this.lastname=wrap.getLastname();
		this.aboutme=wrap.getAboutme();
		this.updateLocation(wrap.getLocation(), Double.valueOf(wrap.getLat()), Double.valueOf(wrap.getLng()));
		
	}

	public Set<Product> getFavorites() {
		return favorites;
	}

	public void addFavorite(Product fav) throws Exception {
		if(null != fav)
			this.favorites.add(fav);
		else
			throw new Exception("add new favorite: null passed in");
	}
	
	public void delFavorite(int prod_id){
		Iterator<Product> i=this.favorites.iterator();
		while(i.hasNext()){
			Product p=i.next();
			if(p.getProd_id()==prod_id){
				i.remove();
			}
		}
	}

	public void build_favorite_lookup(){
		favorite_lookup_map=new HashSet<Integer>();
		Iterator<Product> i=this.favorites.iterator();
		while(i.hasNext()){
			Product p=i.next();
			favorite_lookup_map.add(p.getProd_id());
		}
	}
	
	public boolean likes(Product p){
		return favorite_lookup_map.contains(p.getProd_id());
	}

	public boolean isIsnoob() {
		return isnoob;
	}

	public void setIsnoob(boolean isnoob) {
		this.isnoob = isnoob;
	}

	public Set<Integer> getFavorite_lookup_map() {
		return favorite_lookup_map;
	}

	public void setFavorite_lookup_map(Set<Integer> favorite_lookup_map) {
		this.favorite_lookup_map = favorite_lookup_map;
	}

	public void setFavorites(Set<Product> favorites) {
		this.favorites = favorites;
	}

	
}