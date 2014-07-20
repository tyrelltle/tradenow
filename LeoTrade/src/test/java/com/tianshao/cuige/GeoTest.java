package com.tianshao.cuige;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianshao.cuige.domains.product.Category;
import com.tianshao.cuige.domains.product.Image;
import com.tianshao.cuige.domains.product.Product;
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.repository.product.IProductRepository;
import com.tianshao.cuige.repository.product.ProductRepository;
import com.tianshao.cuige.repository.user.IUserRepository;
import com.tianshao.cuige.repository.user.UserRepository;
import com.tianshao.cuige.services.product.IProductService;
import com.tianshao.cuige.services.product.ProductService;
import com.tianshao.cuige.services.user.IUserService;
import com.tianshao.cuige.services.user.UserService;
import com.tianshao.cuige.shared.googlegeo.AddressConverter;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class GeoTest {

	@Test
	public void testFromString() throws IOException{
		AddressConverter a=new AddressConverter();
		a.convertToLatLong("British Columbia, Canada");
		assertEquals(1,1);
	}
}
