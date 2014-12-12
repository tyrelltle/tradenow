package com.tradenow.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tradenow.shared.googlegeo.AddressConverter;
import com.tradenow.shared.googlegeo.GoogleResponse;
import com.tradenow.shared.googlegeo.Location;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class GeoTest {

	@Test
	public void testFromString() throws IOException{
		AddressConverter a=new AddressConverter();
		GoogleResponse gres=a.convertToLatLong("British Columbia, Canada");
		Location loc=gres.getResults()[0].getGeometry().getLocation();
		double latitude=Double.valueOf(loc.getLat());
		double longitude=Double.valueOf(loc.getLng());
		assert(latitude==53.7266683);
		assert(longitude==-127.6476206);
	}
}
