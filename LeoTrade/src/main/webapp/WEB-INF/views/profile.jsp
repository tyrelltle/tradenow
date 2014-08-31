<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>



<tiles:insertDefinition name="template">
	<tiles:putAttribute name="header">

	    <script type="text/javascript" language="javascript" src="resources/js/masonry.pkgd.js"></script>
	    <script type="text/javascript" language="javascript" src="resources/js/imagesloaded.pkgd.js"></script>
	    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places"></script>	    
	    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/application/autocompleteapi.js"></script>
	    
	    <style type="text/css">	
	    	.tradelis{
			width:700px;
			}
			
			.detailsglyph{
				float:right;
				margin-top:50px;
			}
			.masonryitem{
				margin: 10px;
				width:200px;
			}
			
			.masonrycontainer{
				width: 600px;
				margin: 10px;
			}
		
	    </style>
	</tiles:putAttribute>

	<tiles:putAttribute name="left">
			  <div></div>	
	</tiles:putAttribute>
    <tiles:putAttribute name="main">
   

		      <div class="panel panel-default">
		      		<div  class="panel-body">
						<div class="tabbable tabs-left">
						  <ul class="nav nav-tabs">
						  		
							    <li><a href="#lA" id="tab_prof" data-toggle="tab">My Profile</a></li>
							    <li><a href="#lB" id="tab_prod" data-toggle="tab">My Products</a></li>
							    <li><a href="#lC" id="tab_trade" data-toggle="tab">My Trades</a></li>

						  </ul>
						  <div class="tab-content">
							    <div class="tab-pane active" id="lA">
							    		<div id="profile_detail">
		
						                </div>
						        </div>
						        <div class="tab-pane" id="lB">
						        		<div style="margin-top: 15px;">
						        			<button type="button" id="newbtn" data-toggle="modal" data-target="#myModal" 
						        					class="btn btn-default btn-lg">
						        						<span class="glyphicon glyphicon-plus"></span> 
						        								Add
						        			</button>
						        		</div>
						                <div id="prodlist">
	                
						                
						                </div><!-- end productlist -->
						                <div style="height:300px"></div>
						        </div>
						        
						        <div class="tab-pane" id="lC">
							    		<div id="tradelist">
																	<ul class="tradelis list-group">
																      <li class="list-group-item">
																        <span class="badge">Pending</span>
																            <div class="row">
																                <div class="col-md-4"><center>title1</center></div>
																              	<div class="col-md-4"><center>title1</center></div>
																          	</div>
																        	<div class="row">
																           
																          		<div class="col-md-4"><img alt="pic" class="img-thumbnail" src="http://img.vip.xunlei.com/img/banner/201307291420313509.jpg"></div>
																              <span style="z-index:3;position: absolute;margin-top:80px;left: 230px;" class="glyphicon glyphicon-transfer"> </span>
																              	<div class="col-md-4"><img alt="pic" class="img-thumbnail" src="http://img.vip.xunlei.com/img/banner/201307291420313509.jpg"></div>
																                <div class="col-md-4"> 
																                  <button type="button" class="detailsglyph btn btn-default btn-lg">
																                  	<span class="glyphicon glyphicon-circle-arrow-right"> </span>
																                  </button>              
																                </div>
																          	</div>       
																      </li>
																
																</ul>

		
						                </div>
						        </div>
						  </div>
						</div>
					</div>
			 </div>
			  
		 	<!-- product detail Modal -->
			<div class="modal fade" id="myModal" data-keyboard="false" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-lg modal-dialog">
			    <div class="modal-content">
			      <div class="modalheader modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <div class="modal-title" id="myModalLabel">Item Detail</div>
			      </div>
			      <div class="modal-body">
			      	<div class="modal-bodyy"></div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" id="prod_del" data-dismiss="modal" class="btn btn-default">Delete</button>
			        <button type="button" id="prod_save" data-dismiss="modal" class="btn btn-primary">Save changes</button>
			      </div>
			    </div>
			  </div>
			</div>
	<!--start bootstrap templates-->		 
			 <script type="text/template" id="usertmp">
			 <div class="row">
				<div class="col-md-6">				
					<div class="input-group input-group-md">
  							<span class="input-group-addon">Email</span>
 						 	<input  id="email" class="form-control" value="{{email}}" placeholder="Email"/>
					</div>
					<div class="input-group input-group-md">
  							<span class="input-group-addon">First Name</span>
 						 	<input id="fn" class="form-control"  value="{{firstname}}" placeholder="Firstname"/>
					</div>
					<div class="input-group input-group-md">
  							<span class="input-group-addon">Last Name</span>
 						 	<input id="ln" class="form-control"  placeholder="Lastname" value="{{lastname}}"/>
					</div>
					
		            <div class="input-group input-group-md">
  							<span class="input-group-addon">Your City</span>

		                    <input class="form-control" id="autocomplete" onFocus="geolocate()"  placeholder="Please enter your City,Country" value="{{location}}"/>
		                    <input id="lat" type="hidden" value="{{lat}}" />
		                    <input id="lng" type="hidden" value="{{lng}}"/>
		            </div>


					<div class="input-group input-group-md">
  							<span class="input-group-addon">About you</span>
 						 	<textarea id="txt_aboutme" rows=6 class="form-control"  placeholder="About you">{{aboutme}}</textarea>
					</div>

					<input type="submit" id="submit"/>
				</div>
				<div class="col-md-6">
					<p><img alt="pic" class="img-thumbnail prodpic" style="width:250px" src="${pageContext.request.contextPath}/user/img/userid/{{userid}}"></p>
					<div id="imgform">
		  					<form id="imgsubmit" method="post" enctype="multipart/form-data">  
		     					<td><input type="file" id="img_input" name="file" />     
		     					<td><input type="submit" value="Upload" />   
		  					</form>  
					</div>
				</div>
			</div>
	 		</script>
	 		
	 		<script type="text/template" id="prodlisttmp">
				<div class = "masonrycontainer list-group" >
				</div>
			</script>
	 		<script type="text/template" id="prodlistitemtmp">
				      	<div class="row">
				          <div id="thumbnail" class="col-md-3"  ><img src="{{thumurl}}" class="img-responsive"></div>
				          <div id="title" class="col-md-4" >{{title}}</div>
				          <div id="button" style="float:right">
								<button id="modalbtn" class="btn btn-default btn-lg" data-toggle="modal" data-target="#myModal">
						            <span class="glyphicon glyphicon-circle-arrow-right"> </span>
						        </button>  
						  </div>
				        </div>		       	        
			</script>
			<script type="text/template" id="tradelisttmp">
						<ul class="tradelis list-group">

						</ul>
			</script>
			<script type="text/template" id="tradelistitemtmp">		
						
						        	<span id="span_status" class="badge">{{status}}</span>
						            <div class="row">
						                <div class="col-md-4"><center>{{title1}}</center></div>
						              	<div class="col-md-4"><center>{{title2}}</center></div>
						          	</div>
						        	<div class="row">						           
						          		<div class="col-md-4"><img alt="pic" class="img-thumbnail" src="{{img1url}}"></div>
						              <span style="z-index:3;position: absolute;margin-top:80px;left: 230px;" class="glyphicon glyphicon-transfer"> </span>
						              	<div class="col-md-4"><img alt="pic" class="img-thumbnail" src="{{img2url}}"></div>
						                <div class="col-md-4"> 
											<form action="${pageContext.request.contextPath}/tradepage/{{tradeid}}">
						                  			<button type="submit" class="gototradepg detailsglyph btn btn-default btn-lg">
						                  				<span class="glyphicon glyphicon-circle-arrow-right"> </span>
						                  			</button>  
											</form>            
						                </div>
						          	</div>       
						 
			</script>
			
			<script type="text/template" id="proddetailtmp">
			      
			   
				<div style="height:500px;">
				<div class="col-md-6">
					<div class="input-group input-group-md">
  							<span class="input-group-addon glyphicon glyphicon-pushpin"></span>
 						 	<input type="text" id="titletxt" class="form-control" value="{{title}}" placeholder="Enter Item Title">
					</div>
					</br>
					<div class="input-group input-group-md">
  							<span class="input-group-addon glyphicon glyphicon-pushpin"></span>
 						 	<div id="catlistholder"></div>
					</div>
					

					</br>
					<div class="input-group input-group-md">
  							<span class="input-group-addon glyphicon glyphicon-list-alt"></span>
 						 	<textarea id="detail" rows=6 class="form-control" placeholder="Detailed description of the item"> {{detail}}</textarea>
					</div>
					</br>
					
					<div class="input-group input-group-md">
  							<span class="input-group-addon glyphicon glyphicon-th-list"></span>
 						 	<input type="text" id="quantity" class="form-control" value="{{quantity}}" placeholder="Enter Item Quantity">
					</div>
					</br>
					<div class="input-group input-group-md">
  							<span class="input-group-addon glyphicon glyphicon-usd"></span>
 						 	<input type="text" id="price" class="form-control" value="{{price}}" placeholder="Enter Item Price">
					</div>
					</br>
					<div class="input-group input-group-md">
  							<span class="input-group-addon">Status</span>
 						 	<label class="form-control"  > {{status}}</label>
					</div>
					</br>
					<div class="input-group input-group-md">
  							<span class="input-group-addon">Trade For</span>
 						 	<textarea id="tradefor" rows=6 class="form-control"  placeholder="Trade for what">{{tradefor}}</textarea>
					</div>
			   </div> <!-- property holder-->
			   <div class="col-md-6">
			  	 	<!--img viewer and uploader -->
			   		<center>image content</center>
					<div id="imgform">
		  					<form id="imgsubmit" method="post" enctype="multipart/form-data">  
		     					<td><input type="file" id="prod_img_input" name="file" />     
		     					<td><input type="submit" value="Upload" />   
		  					</form>  
					</div>
					<div id="imglis" style="overflow:scroll;height:500px"></div>
				
			   </div> <!-- img holder-->
			 </div><!-- main content holder-->
			      

			     



			  
	 		</script>
	<!--end bootstrap templates--> 	
	
	
	
						
	
	
		
	<!--start bootstrap dependencies-->	
			 <script type="text/javascript" id="tmp" src="resources/js/application/product.js"></script>
			 <script type="text/javascript" id="tmp" src="resources/js/application/profile.js"></script>
			 <script type="text/javascript"  id="tmp2" src="resources/js/application/app.js"></script>
			 <script type="text/javascript"  id="tmp2" src="resources/js/application/tradelist.js"></script>
	<!--end bootstrap dependencies-->

	</tiles:putAttribute>
</tiles:insertDefinition>
