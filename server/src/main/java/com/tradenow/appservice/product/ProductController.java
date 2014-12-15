package com.tradenow.appservice.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tradenow.domains.product.Category;
import com.tradenow.domains.product.Image;
import com.tradenow.domains.product.Product;
import com.tradenow.domains.product.ProductDTO;
import com.tradenow.domains.product.ProductImageUrlDTP;
import com.tradenow.domains.user.User;
import com.tradenow.repository.product.IProductRepository;
import com.tradenow.services.product.IProductService;
import com.tradenow.services.user.IUserService;
import com.tradenow.shared.googlegeo.AddressConverter;
import com.tradenow.shared.googlegeo.GoogleResponse;
import com.tradenow.shared.googlegeo.Location;




/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/api/product")
public class ProductController {
	    @Autowired
	    private IProductService productService;
	   
	    @Autowired
	    private IUserService userService;
	    
	    @Autowired
	    private IProductRepository productRepository;
	  
	    
		@RequestMapping(value="likes",method = RequestMethod.GET, produces="application/json")
		public @ResponseBody List<ProductDTO> getfavlis(HttpServletRequest req) throws IOException {
			User u=userService.loadUserWithLikes();
			List<Product> likes=new ArrayList<Product>(u.getFavorites());
			List<ProductDTO> ret=new ArrayList<ProductDTO>();
			toRodListDTO_like(null,ret, likes);
			return ret;
	    }	 
	    
		@RequestMapping(value={"start/{st}/count/{ct}"},method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<ProductDTO> get(@PathVariable int st, @PathVariable int ct, HttpServletResponse resp) throws Exception {
			//st and ct are used in LIMIT st,ct
			User u=userService.loadUserWithLikes();
			u.build_favorite_lookup();
			List<ProductDTO> ret=new ArrayList<ProductDTO>();
	    	List<Product> prods=productRepository.getAllButMe(u,st,ct);
	    	toRodListDTO_like(u,ret, prods);
	    	return ret;
	    	
		}

		

		@RequestMapping(value={"start/{st}/count/{ct}/ownerid/{userid}"},method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<ProductDTO> getmine(@PathVariable int st, @PathVariable int ct, @PathVariable int userid, HttpServletResponse resp) throws Exception {
			//st and ct are used in LIMIT st,ct
			List<ProductDTO> ret=new ArrayList<ProductDTO>();
	    	
	    	List<Product> prods=productRepository.getAllMine(userid,st,ct);
	    	
	    	toRrodListDTO(ret, prods);
	    	return ret;
	    	
		}
		
		@RequestMapping(value={"start/{st}/count/{ct}/catid/{catid}"},method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<ProductDTO> getbycategory(@PathVariable int st, @PathVariable int ct, @PathVariable int catid, HttpServletResponse resp) throws Exception {
			//st and ct are used in LIMIT st,ct
			User u=userService.loadUserWithLikes();
			u.build_favorite_lookup();

			List<ProductDTO> ret=new ArrayList<ProductDTO>();
	    	
	    	List<Product> prods=productRepository.getByCatId(u, catid,st,ct);
	    	
	    	toRodListDTO_like(u,ret, prods);
	    	return ret;
	    	
		}
		
		
		
		@RequestMapping(value={"start/{st}/count/{ct}/location/{key}"},method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<ProductDTO> locationsearch(@PathVariable int st, @PathVariable int ct, @PathVariable String key, HttpServletResponse resp) throws Exception {
			//st and ct are used in LIMIT st,ct
			User u=userService.loadUserWithLikes();
			u.build_favorite_lookup();
			List<ProductDTO> ret=new ArrayList<ProductDTO>();
			//manually set user's location to the one being searched. 
			AddressConverter a=new AddressConverter();
			GoogleResponse gres=a.convertToLatLong(key);
			Location loc=gres.getResults()[0].getGeometry().getLocation();
			
	    	List<Product> prods=productRepository.getAllButMeByAddr(u,Double.valueOf(loc.getLat()),Double.valueOf(loc.getLng()),st,ct);
	    	toRodListDTO_like(u,ret, prods);
	    	return ret;
	    	
		}
		
		@RequestMapping(value={"start/{st}/count/{ct}/search/{key}"},method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<ProductDTO> search(@PathVariable int st, @PathVariable int ct, @PathVariable String key, HttpServletResponse resp) throws Exception {
			//st and ct are used in LIMIT st,ct
			User u=userService.loadUserWithLikes();
			u.build_favorite_lookup();
			List<ProductDTO> ret=new ArrayList<ProductDTO>();
	    	
	    	List<Product> prods=productRepository.searchByTitle(u.getUserid(),key, st, ct);
	    	
	    	toRodListDTO_like(u,ret, prods);
	    	return ret;
	    	
		}
		
		
		
		
		@RequestMapping(method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<ProductDTO> get( HttpServletResponse resp) throws IOException {
			
			List<ProductDTO> ret=new ArrayList<ProductDTO>();
	    	
	    	List<Product> prods=productRepository.getByUserId(userService.currentUser().getUserid());
	    	if(null==prods)
	    		return ret;
	    	
	    	toRrodListDTO(ret, prods);
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

		
		@RequestMapping(value="/like/{prod_id}", method = RequestMethod.POST)
		public @ResponseBody String like(@PathVariable int prod_id, HttpServletResponse resp) throws IOException {			
			try {
				Product p=productRepository.getByProductId(prod_id);
				userService.addFavorite(p);
				return "suc";
			} catch (Exception e) {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());	    
				return "err";
			}		
			
		}

	    @RequestMapping(value="/unlike/{prod_id}", method = RequestMethod.POST)
		public @ResponseBody String unlike(@PathVariable int prod_id, HttpServletResponse resp) throws IOException {			
			try {
				Product p=productRepository.getByProductId(prod_id);
				userService.delFavorite(p.getProd_id());
				return "suc";
			} catch (Exception e) {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());	    
				return "err";
			}		
			
		}
		@RequestMapping(method = RequestMethod.POST,headers="Accept=application/json", produces="application/json")
		public @ResponseBody ProductDTO post(@RequestBody ProductDTO dto,HttpServletResponse resp) throws IOException {
			

			try {
				User owner=userService.currentUser();
			
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
			
			if(userService.currentUser().getUserid()!=dto.getUserid()){
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
			if(userService.currentUser().getUserid()!=prod.getOwner().getUserid()){
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
		        return String.valueOf(productService.addProductImage(prod_img));
		 
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		        return null;
		    }
		 
		 
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
					t.setUrl("api/product/img/"+i.getImg_id());
					ret.add(t);
				}

		        return  ret;
		    }
			//withlike=true when product list contains boolean of if current user liked it
			private void toRrodListDTO(List<ProductDTO> ret, List<Product> prods) {
				Iterator<Product> i=prods.iterator();
		    	while(i.hasNext()){
		    		Product prod=i.next();
		    		ProductDTO dto = new ProductDTO();
					PROD_TO_DTO(prod, dto);
		    		ret.add(dto);
		    	}
			}
			
			/**
			 * initialaize like flag in DTO
			 * if user parameter is not null, flag is 1 if the product is in user's liked list
			 * if user parameter is null, liked flag is always set to 1
			 */
			private void toRodListDTO_like(User u,List<ProductDTO> ret, List<Product> prods){
				Iterator<Product> i=prods.iterator();
		    	while(i.hasNext()){
		    		Product prod=i.next();
		    		ProductDTO dto = new ProductDTO();
		    		
					PROD_TO_DTO(prod, dto);
		    		dto.setLiked(null!=u?(u.likes(prod)?1:0):1);
					ret.add(dto);
		    	}
				
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
				dto.setOwneraddr(prod.getOwner().getLocation());
				dto.setOwnerimgurl("user/img/userid/"+prod.getOwner().getUserid());
				dto.setOwnernm(prod.getOwner().getFullName());
			}
}
