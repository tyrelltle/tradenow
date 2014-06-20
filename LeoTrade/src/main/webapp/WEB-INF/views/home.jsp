<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


	
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="header">
				<script>var ctx = "${pageContext.request.contextPath}/"</script>
	
		<script type="text/javascript" language="javascript" src="resources/scripts/jquery-1.10.2.js"></script>
	    <script type="text/javascript" language="javascript" src="resources/scripts/underscore.js"></script>
	    <script type="text/javascript" language="javascript" src="resources/scripts/backbone.js"></script>
	    <script type="text/javascript" language="javascript" src="resources/scripts/masonry.pkgd.js"></script>
	    <script type="text/javascript" language="javascript" src="resources/scripts/imagesloaded.pkgd.js"></script>
	    <style type="text/css">	
			.masconryitem{
				width: 200px;
				margin: 10px;
			}
			#catlistpanel{
				float:left;
			}
		
	    </style>
	</tiles:putAttribute>
	<tiles:putAttribute name="left">
	
			<div class="list-group" style="width:200px">
			  <a href="#" class="list-group-item active">
			    Categories
			  </a>
			  <div class="catlist">
				  <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
				  <a href="#" class="list-group-item">Morbi leo risus</a>
				  <a href="#" class="list-group-item">Porta ac consectetur ac</a>
				  <a href="#" class="list-group-item">Vestibulum at eros</a>
			  </div>
			</div>
	
	</tiles:putAttribute>
    <tiles:putAttribute name="main">
   
   			<div>
				
			      <div id="prodlispanel" class="panel panel-default">
			      		<div  class="panel-body">
							<div id="prodlist" >
								
							</div>
						</div>
				 </div>
			 </div>
		 	<!-- product detail Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-lg modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
			      </div>
			      <div class="modal-body">
			      
			      </div>
			      <div class="modal-footer">
			       
			        <button type="button" id="btn_trade" class="btn btn-primary">Trade!</button>
			      </div>
			    </div>
			  </div>
			</div>
	<!--start bootstrap templates-->		 
			
	 		
	 		<script type="text/template" id="prodlisttmp">
				<div class = "masconrycontainer"   style="margin-top: 60px;">
				</div>
				<center>
				<button type="button" id="loadmore" class="btn btn-default">Load More</button>
				</center>

			</script>
	 		<script type="text/template" id="prodlistitemtmp">
				      <div class="masconryitem">			      
				      	<div class="panel panel-default">
				          <div class="panel-thumbnail"><img src="{{thumurl}}" class="img-responsive"></div>
				          <div class="panel-body">
				            <p class="lead">{{title}}</p>
				          <!-- Button trigger modal -->
								<button id="modalbtn" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
  									Launch demo modal
								</button>
				          </div>
				        </div>		        
				      </div>																	     
			</script>
			
			<script type="text/template" id="proddetailtmp">
			      
			   
				<div style="height:500px;">
				<div class="col-md-6">
					<div class="input-group input-group-md">
  							<span class="input-group-addon">Title</span>
 						 	<label class="form-control"  > {{title}} </label>
					</div>
					</br>

					</br>
					<div class="input-group input-group-md">
  							<span class="input-group-addon">Description</span>
 						 	<textarea id="detail" rows=6 class="form-control" placeholder="Detailed description of the item" readonly> {{detail}}</textarea>
					</div>
					</br>
					
					<div class="input-group input-group-md">
  							<span class="input-group-addon">Quantity</span>
 						 	<label class="form-control"  > {{quantity}}</label>
					</div>
					</br>
					<div class="input-group input-group-md">
  							<span class="input-group-addon">Price</span>
						 	<label class="form-control"  > {{price}}</label>
					</div>
					</br>
					<div class="input-group input-group-md">
  							<span class="input-group-addon">Status</span>
 						 	<label class="form-control"  > {{status}}</label>
					</div>
					</br>
					<div class="input-group input-group-md">
  							<span class="input-group-addon">Trade For</span>
 						 	<textarea id="tradefor" rows=6 class="form-control"  placeholder="Trade for what" readonly>{{tradefor}}</textarea>
					</div>
			   </div> <!-- property holder-->
			   <div class="col-md-6">
			  	 	<!--img viewer and uploader -->
			   		<center>Photos</center>
					
					<div id="imglis" style="overflow:scroll;height:500px"></div>
				
			   </div> <!-- img holder-->
			 </div><!-- main content holder-->
			      

			     



			  
	 		</script>
	<!--end bootstrap templates--> 	
	
	
	
						
	
	
		
	<!--start bootstrap dependencies-->	
			 <script type="text/javascript" id="tmp" src="resources/scripts/application/browseproduct.js"></script>
			 <script type="text/javascript"  id="tmp2" src="resources/scripts/application/category.js"></script>
			 
			 <script type="text/javascript"  id="tmp2" src="resources/scripts/application/homeapp.js"></script>
			 
	<!--end bootstrap dependencies-->

	</tiles:putAttribute>
</tiles:insertDefinition>

