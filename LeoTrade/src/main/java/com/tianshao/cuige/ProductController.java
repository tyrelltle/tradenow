package com.tianshao.cuige;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.Product;
import com.tianshao.cuige.models.Profile;
import com.tianshao.cuige.models.DTO.ProductDTO;
import com.tianshao.cuige.services.ProductService;
import com.tianshao.cuige.services.ProfileService;




/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/api/product")
public class ProductController {
	    @Autowired
	    private ProductService serv;
	   
	   
	    
	    private final Facebook facebook;

	    @Inject
	    public ProductController(Facebook facebook) {
	        this.facebook = facebook;
	    }

//	    @RequestMapping( method=RequestMethod.GET)
//	    public String home(Model model) {
//	    	
//	        return "profile";
//	    }

	    
	    
		@RequestMapping(method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<ProductDTO> get( HttpServletResponse resp) throws IOException {
			
			List<ProductDTO> ret=new ArrayList<ProductDTO>();
	    	FacebookProfile facebookprofile=facebook.userOperations().getUserProfile();
	    	String socialid=facebookprofile.getId();
	    	List<Product> prods=serv.getBySocialId(socialid);
	    	if(null==prods)
	    		return ret;
	    	
	    	Iterator<Product> i=prods.iterator();
	    
	    	while(i.hasNext()){
	    		Product prod=i.next();
	    		ProductDTO dto = new ProductDTO();
	    		dto.setDetail(prod.getDetail());
	    		dto.setPrice(prod.getPrice());
	    		dto.setProd_id(prod.getProd_id());
	    		dto.setQuantity(prod.getQuantity());
	    		dto.setSocial_id(prod.getOwner().getSocial_id());
	    		dto.setStatus(prod.getStatus());
	    		dto.setCatid(prod.getCategory().getCatid());
	    		dto.setTitle(prod.getTitle());
	    		ret.add(dto);
	    	}
	    	return ret;
	    	
		}
	    
		@RequestMapping(method = RequestMethod.POST,headers="Accept=application/json", produces="application/json")
		public @ResponseBody ProductDTO post(@RequestBody ProductDTO dto,HttpServletResponse resp) throws IOException {
			FacebookProfile facebookprofile=facebook.userOperations().getUserProfile();
	    	String socialid=facebookprofile.getId();
	    	
//			if(!socialid.equals(dto.getSocial_id())){
//				 resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "your social id is different from DTO's");
//		         return null;
//			}
			try {
				Product prod=serv.populate(socialid, dto.getCatid());
				prod.setDetail(dto.getDetail());
				prod.setPrice(dto.getPrice());
				prod.setQuantity(dto.getQuantity());
				prod.setStatus(dto.getStatus());
				prod.setTitle(dto.getTitle());
				serv.add(prod);
				
				dto.setProd_id(prod.getProd_id());
				return dto;
			} catch (Exception e) {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		        return null;
			}
			
		}
		
	
}
