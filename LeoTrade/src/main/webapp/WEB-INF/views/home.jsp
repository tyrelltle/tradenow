<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


	
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="header">
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
		
	    </style>
	</tiles:putAttribute>

    <tiles:putAttribute name="main">
   

		      <div id="prodlispanel" class="panel panel-default">
		      		<div  class="panel-body">
						<div id="prodlist" >
							
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
			        <button type="button" id="prod_del" data-dismiss="modal" class="btn btn-default">Delete</button>
			        <button type="button" id="prod_save" data-dismiss="modal" class="btn btn-primary">Save changes</button>
			      </div>
			    </div>
			  </div>
			</div>
	<!--start bootstrap templates-->		 
			
	 		
	 		<script type="text/template" id="prodlisttmp">
				<div class = "masconrycontainer"   style="margin-top: 60px;">
				</div>


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
  							<span class="input-group-addon glyphicon glyphicon-pushpin"></span>
 						 	<input type="text" id="title" class="form-control" value="{{title}}" placeholder="Enter Item Title">
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
			 <script type="text/javascript" id="tmp" src="resources/scripts/application/browseproduct.js"></script>
			 <script type="text/javascript"  id="tmp2" src="resources/scripts/application/homeapp.js"></script>
	 		<div>testtesttest</div>
	<!--end bootstrap dependencies-->

	</tiles:putAttribute>
</tiles:insertDefinition>

