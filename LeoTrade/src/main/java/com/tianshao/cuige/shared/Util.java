package com.tianshao.cuige.shared;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.io.output.ByteArrayOutputStream;

public class Util {

	public static byte[] getimageByUrl(String imgurl) throws IOException{
		ByteArrayOutputStream bais = new ByteArrayOutputStream();
		InputStream is = null;
		byte[] byteChunk=null;
		try {
		  is = new URL(imgurl).openStream ();
		  byteChunk = new byte[4096]; // Or whatever size you want to read in at a time.
		  int n;

		  while ( (n = is.read(byteChunk)) > 0 ) {
		    bais.write(byteChunk, 0, n);
		  }
		}
		catch (IOException e) {
		 
		  e.printStackTrace ();
		  // Perform any other exception handling that's appropriate.
		}
		finally {
		  if (is != null) { is.close(); }
		}
		return bais.toByteArray();
	}
}
