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
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tianshao.cuige.config.SecurityContext;
import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.Image;
import com.tianshao.cuige.models.Product;
import com.tianshao.cuige.models.User;
import com.tianshao.cuige.models.DTO.ProductDTO;
import com.tianshao.cuige.models.DTO.ProductImageUrlDTP;
import com.tianshao.cuige.repository.IProductRepository;
import com.tianshao.cuige.repository.IUserRepository;
import com.tianshao.cuige.services.IProductService;
import com.tianshao.cuige.services.UserService;




/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/api/product")
public class ProductController {
	    @Autowired
	    private IProductService productService;
	   
	    @Autowired
	    private IUserRepository userRepository;
	    @Autowired
	    private IProductRepository productRepository;
	  
		@RequestMapping(value={"start/{st}/count/{ct}"},method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<ProductDTO> get(@PathVariable int st, @PathVariable int ct, HttpServletResponse resp) throws Exception {
			//st and ct are used in LIMIT st,ct
			List<ProductDTO> ret=new ArrayList<ProductDTO>();
	    	
	    	List<Product> prods=productRepository.getAllButMe(SecurityContext.getCurrentUser().getUserid(),st,ct);
	    	
	    	Iterator<Product> i=prods.iterator();
	    
	    	while(i.hasNext()){
	    		Product prod=i.next();
	    		ProductDTO dto = new ProductDTO();
	    		PROD_TO_DTO(prod, dto);
	    		ret.add(dto);
	    	}
	    	return ret;
	    	
		}
	    
		@RequestMapping(method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<ProductDTO> get( HttpServletResponse resp) throws IOException {
			
			List<ProductDTO> ret=new ArrayList<ProductDTO>();
	    	
	    	List<Product> prods=productRepository.getByUserId(SecurityContext.getCurrentUser().getUserid());
	    	if(null==prods)
	    		return ret;
	    	
	    	Iterator<Product> i=prods.iterator();
	    
	    	while(i.hasNext()){
	    		Product prod=i.next();
	    		ProductDTO dto = new ProductDTO();
	    		PROD_TO_DTO(prod, dto);
	    		ret.add(dto);
	    	}
	    	return ret;
	    	
		}
	    
		@RequestMapping(value="{prod_id}",method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody ProductDTO get(@PathVariable int prod_id, HttpServletResponse resp) throws IOException {
			
			Product prod=(Product) productRepository.getByProductId(prod_id);
			ProductDTO dto=new ProductDTO();
	    	if(null==prod){
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Item not exist");
	    		return null;
	    	}
	    	
	    		PROD_TO_DTO(prod, dto);
	    		
	    	return dto;
	    	
		}



	    
		@RequestMapping(method = RequestMethod.POST,headers="Accept=application/json", produces="application/json")
		public @ResponseBody ProductDTO post(@RequestBody ProductDTO dto,HttpServletResponse resp) throws IOException {
			

			try {
				
				if(SecurityContext.getCurrentUser().getUserid()!=dto.getUserid())
				{
					throw new Exception("you are not authorized!");
				}
				
				User owner = userRepository.getByUserid(dto.getUserid());
				Category cat=productRepository.getCategory(dto.getCatid());
				Product prod=new Product();
				prod.setCategory(cat);
				prod.setOwner(owner);				
				DTO_to_PROD(dto, prod);
				productRepository.addNew(prod);
				dto.setUserid(prod.getOwner().getUserid());
				dto.setProd_id(prod.getProd_id());
				return dto;
			} catch (Exception e) {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		        return null;
			}
			
		}

		
		@RequestMapping(value="{prod_id}",method = RequestMethod.PUT,headers="Accept=application/json", produces="application/json")
		public @ResponseBody ProductDTO put(@RequestBody ProductDTO dto, @PathVariable int prod_id, HttpServletResponse resp) throws IOException {
			
			if(SecurityContext.getCurrentUser().getUserid()!=dto.getUserid()){
				 resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "you are not the owner of this Item, please sign in first!");
		         return null;
			}
			
			try {
				Product prod=productRepository.getByProductId(prod_id);
				DTO_to_PROD(dto, prod);
				productRepository.update(prod);
				dto.setProd_id(prod.getProd_id());
				return dto;
			} catch (Exception e) {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		        return null;
			}

		}

		@RequestMapping(value="{prod_id}",method = RequestMethod.DELETE, produces="application/json")
		public @ResponseBody ProductDTO del( @PathVariable int prod_id, HttpServletResponse resp) throws IOException {
			
			
			Product prod=productRepository.getByProductId(prod_id);
			ProductDTO ret=new ProductDTO();
	    	if(prod==null){
				 resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "No such Item!");
				 return null;
	    	}
			if(SecurityContext.getCurrentUser().getUserid()!= prod_id){
				 resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "you are not the owner of this Item, please sign in first!");
		         return null;
			}
			
			try {
				productRepository.remove(prod);
				PROD_TO_DTO(prod,ret);
				return ret;
			} catch (Exception e) {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
				return null;
			}

		}
		
		 @RequestMapping(value = "/img/upload/{prod_id}", method = RequestMethod.POST)
		   public @ResponseBody String upload(@PathVariable int prod_id, MultipartHttpServletRequest request, HttpServletResponse resp) throws IOException {                 
			
			 Product prod=productRepository.getByProductId(prod_id);
	    	if(prod==null){
				 resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "No such Item!");
				 return null;
	    	}
			if(SecurityContext.getCurrentUser().getUserid()!=prod.getOwner().getUserid()){
				 resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "you are not the owner of this Item, please sign in first!");
		         return null;
			}
			 
		     //0. notice, we have used MultipartHttpServletRequest
		 
		     //1. get the files from the request object
		     Iterator<String> itr =  request.getFileNames();
		 
		     MultipartFile mpf = request.getFile(itr.next());
		     Image prod_img=new Image();
		  
		     try {         
		        prod_img.setImage_size( mpf.getBytes().length);
		        prod_img.setImage( mpf.getBytes());
		        prod_img.setImage_type(mpf.getContentType());
		        prod_img.setImage_name(mpf.getOriginalFilename());
		        prod_img.setProduct(prod);
		        productService.addProductImage(prod_img);
		 
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		        return null;
		    }
		 
		     return "success";
		 
		  }

			@RequestMapping(value="/img/{img_id}",method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
			public @ResponseBody byte[] getimg(@PathVariable int img_id) {
				//serv.get
				return productRepository.getProductImageByImgId(img_id).getImage();
				

		    }
			@RequestMapping(value="{prod_id}/img", method = RequestMethod.GET, headers={ "Accept=application/json" },produces="application/json")
			public @ResponseBody List<ProductImageUrlDTP> geturls(@PathVariable int prod_id) {
				
				@SuppressWarnings("unchecked")
				Product prod=productRepository.getProductWithImages(prod_id);
				
				List<ProductImageUrlDTP> ret=new ArrayList<ProductImageUrlDTP>();
				for(Image i:prod.getImages()){
					ProductImageUrlDTP t=new ProductImageUrlDTP();
					t.setImg_Id(i.getImg_id());
					t.setUrl("http://localhost:8080/cuige/api/product/img/"+i.getImg_id());
					ret.add(t);
				}

		        return  ret;
		    }
		private void DTO_to_PROD(ProductDTO dto, Product prod) {
			prod.setDetail(dto.getDetail());
			prod.setPrice(dto.getPrice());
			prod.setQuantity(dto.getQuantity());
			prod.setStatus(dto.getStatus());
			prod.setTitle(dto.getTitle());
			prod.setTradefor(dto.getTradefor());
			prod.setThumurl(dto.getThumurl());
			prod.setCategory(productRepository.getCategory(dto.getCatid()));
		}		
	
		private void PROD_TO_DTO(Product prod, ProductDTO dto) {
			dto.setDetail(prod.getDetail());
			dto.setPrice(prod.getPrice());
			dto.setProd_id(prod.getProd_id());
			dto.setQuantity(prod.getQuantity());
			dto.setUserid(prod.getOwner().getUserid());
			dto.setStatus(prod.getStatus());
			dto.setCatid(prod.getCategory().getCatid());
			dto.setTitle(prod.getTitle());
			dto.setThumurl(prod.getThumurl());
			dto.setTradefor(prod.getTradefor());
		}
}
