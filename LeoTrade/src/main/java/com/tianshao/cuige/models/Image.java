package com.tianshao.cuige.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * product image
 */
@Entity
@Table(name="image")
public class Image {
	
	@Id
	@Column(name="img_id")
	@GeneratedValue
	int img_id;
	
	@Column(name="image_type")
	String image_type;
	
	@Column(name="image")
	byte[] image;
	
	@Column(name="image_size")
	int image_size;
	
	@Column(name="image_name")
	String image_name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prod_id")
	Product product;

	public int getImg_id() {
		return img_id;
	}

	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}

	public String getImage_type() {
		return image_type;
	}

	public void setImage_type(String image_type) {
		this.image_type = image_type;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getImage_size() {
		return image_size;
	}

	public void setImage_size(int length) {
		this.image_size = length;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
}
