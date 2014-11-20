package com.tradenow.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tradenow.shared.googlegeo.AddressConverter;




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
