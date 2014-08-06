<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


	
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="header">
	
	    <script type="text/javascript" language="javascript" src="resources/scripts/masonry.pkgd.js"></script>
	    <script type="text/javascript" language="javascript" src="resources/scripts/imagesloaded.pkgd.js"></script>
	
	    <style type="text/css">	
	    	.galitem{
	    		width:200px;
	    	}
	    	.modallg{
	    		width:1024px;
	    	}
			.masonryitem{
				width: 200px;
				margin: 10px;
			}
			#catlistpanel{
				float:left;
			}
			.panel-thumbnail:hover{
				cursor:pointer;
			}
			.boxshadow:hover{
			box-shadow: 0 0 20px rgb(131, 131, 158) !important;
			}
						
			i {
			  font-size:16px;
			}
			
			/* indent 2nd level */
			.list-unstyled li > ul > li {
			   margin-left:10px;
			   padding:8px;
			}
		.
	    </style>
	</tiles:putAttribute>
	<tiles:putAttribute name="left">
			  <div class="catlist">
							<ul class="list-unstyled" style="margin-left:20px">
							        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#userMenu">
							          <h5>Categories <i class="glyphicon glyphicon-chevron-down"></i></h5>
							          </a>
							            <ul class="list-unstyled collapse in" id="userMenu">
							                <li class="active"> <a href="#"><i class="glyphicon glyphicon-home"></i> Home</a></li>
							                <li><a href="#"><i class="glyphicon glyphicon-envelope"></i> Messages <span class="badge badge-info">4</span></a></li>
							                <li><a href="#"><i class="glyphicon glyphicon-cog"></i> Options</a></li>
							                <li><a href="#"><i class="glyphicon glyphicon-comment"></i> Shoutbox</a></li>
							                <li><a href="#"><i class="glyphicon glyphicon-user"></i> Staff List</a></li>
							                <li><a href="#"><i class="glyphicon glyphicon-flag"></i> Transactions</a></li>
							                <li><a href="#"><i class="glyphicon glyphicon-exclamation-sign"></i> Rules</a></li>
							                <li><a href="#"><i class="glyphicon glyphicon-off"></i> Logout</a></li>
							            </ul>
							        </li> 
							</ul>
			  </div>
	
	</tiles:putAttribute>
    <tiles:putAttribute name="main">
   			<c:if test="${not empty catid}">
      			<input id="catid" type="hidden" value="${catid}"/>
    		</c:if>
   			
   			<div id="prodlist">
		
			      
			 </div>
		 	<!-- product detail Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modallg modal-dialog">
			    <div class="modal-content">
			      <div class="modalheader modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <div class="modal-title" id="myModalLabel">Item Detail</div>
			      </div>
			      <div class="modal-body">
			      	<div class="modal-bodyy"></div>
			      </div>
			      <div class="modal-footer">
			       
			        <button type="button" id="btn_trade" class="btn btn-primary">Trade!</button>
			        <button type="button" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Cancel</button>
			      </div>
			    </div>
			  </div>
			</div>
	<!--start bootstrap templates-->		 
			<script type="text/template" id="imglistitemtmp">
					<a class='galimg' href='{{url}}' rel='prettyPhoto[pp_gal]'  href='{{url}}'>
						<img class='galitem img-thumbnail' src='{{url}}' alt='asd'/>
					</a>
			</script>
			<script type="text/template" id="catlistitemtmp">
					<a class="link" href="#">{{name}}</a>
			</script>
	 		<script type="text/template" id="catlisttmp">
							<ul class="list-unstyled" style="margin-left:20px">
							        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#userMenu">
							          <h5>Settings <i class="glyphicon glyphicon-chevron-down"></i></h5>
							          </a>
							            <ul class="list-unstyled collapse in" id="userMenu">
							            </ul>
							        </li> 
							</ul>

			</script>
	 		<script type="text/template" id="prodlisttmp">
				<div id="prodlispanel" class="panel panel-default">
			      		<div  class="panel-body">
							<blockquote>
  								<p>Discover, Choose, Trade!.</p>
							</blockquote>
							<div class = "masonrycontainer"   >
							</div>
							<center>
								<div  id="loadmore" >Load More</div>
							</center>
						</div>
				</div>
				

			</script>
	 		<script type="text/template" id="prodlistitemtmp">
				      	<div class="boxshadow panel panel-default">
				          <div class="panel-thumbnail"><a><img src="{{thumurl}}" class="btn_detail img-responsive"></a></div>

						  <div class="panel-footer" style="background-color:#FFFFFF">
							<div class="row">
								<div class="col-md-12" style="font-size:15px">{{title}}</div>
							</div>
						    <div class="row"  style="margin-top:8px">
								<div class="col-md-4">
									<a href="user/userid/{{userid}}"><img style="width:50px" src="{{ownerimgurl}}"/></a>
								</div>
								<div class="col-md-8">
									<em style="font-size:12px">{{ownernm}}:</em> 
									<p style="font-size:12px">{{owneraddr}}</p>
								</div>
							</div>
						  </div>
				        </div>		        
			</script>
			
			<script type="text/template" id="proddetailtmp">
			      
			   
				<div style="height:500px;">
				<div class="col-md-5">
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
			   <div class="col-md-7">
			  	 	<!--img viewer and uploader -->
			   		<center>Photos</center>
					
					<div id="imgliscontainer" style="overflow:scroll;height:500px">
						<div id="imglis">
						</div>
					</div>
				
			   </div> <!-- img holder-->
			 </div><!-- main content holder-->
			      

			     



			  
	 		</script>
	<!--end bootstrap templates--> 	
	
	
	
						
	
	
		
	<!--start bootstrap dependencies-->	
			 <script type="text/javascript" id="tmp" src="resources/scripts/application/browseproduct.js"></script>
			 <script type="text/javascript"  id="tmp2" src="resources/scripts/application/category.js"></script>
			 
			 <script type="text/javascript"  id="tmp3" src="resources/scripts/application/homeapp.js"></script>

			 
	<!--end bootstrap dependencies-->

	</tiles:putAttribute>
</tiles:insertDefinition>

