package com.tianshao.cuige;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianshao.cuige.models.Product;
import com.tianshao.cuige.services.ProductService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class test {
	@Autowired
	ProductService p;
	
	@Test
	public void hellworld(){
		List<Product> l=p.getProducts();
		l.clear();
	}
}
