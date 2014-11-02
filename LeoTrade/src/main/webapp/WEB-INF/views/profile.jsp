<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>



<tiles:insertDefinition name="template">
	<tiles:putAttribute name="header">

	    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/assets/js/masonry.pkgd.js"></script>
	    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/assets/js/imagesloaded.pkgd.js"></script>
	    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/application/autocompleteapi.js"></script>
	    
	    <style type="text/css">	
	    	.tradelis{
			width:700px;
			}
			
			.detailsglyph{
				float:right;
				margin-top:50px;
			}
            .modallg{
                width:60%;
            }
		
	    </style>
	</tiles:putAttribute>

	<tiles:putAttribute name="left">
			  <div></div>	
	</tiles:putAttribute>
    <tiles:putAttribute name="main">

    <div class="main-content">
    <div class="main-header" style="margin-bottom: 20px">
        <h2>Profile</h2>
        <em>User Profile Page</em>
    </div>
    <!-- NAV TABS -->
    <ul class="nav nav-tabs">
        <li class=""><a href="#lA" id="tab_prof" data-toggle="tab"><i class="fa fa-user"></i> Profile</a></li>
        <li class=""><a href="#lB" id="tab_prod" data-toggle="tab"><i class="fa fa-th-large"></i> Item Repository</a></li>
        <li class=""><a href="#lC" id="tab_trade" data-toggle="tab"><i class="fa fa-exchange"></i> Historical Trades</a></li>
    </ul>
    <!-- END NAV TABS -->

    <div class="tab-content profile-page">
    <!-- PROFILE TAB CONTENT -->
    <div class="tab-pane profile active" id="lA">
        <div id="profile_detail">

        </div>
    </div>
    <!-- END PROFILE TAB CONTENT -->

    <!-- PRODUCT TAB CONTENT -->
    <div class="tab-pane activity" id="lB">
        <div class="gallery-buttons bottom-30px">
            <button id="newbtn" data-target="#myModal" data-toggle="modal" type="button" class="btn btn-custom-primary btn-md"><i class="fa fa-upload"></i> Add New Item</button>
        </div>

        <div id="prodlist"></div>

    </div>
    <!-- END PRODUCT TAB CONTENT -->

    <!-- TRADE TAB CONTENT -->
    <div class="tab-pane settings" id="lC">
        <div id="tradelist">
            <ul class="tradelis list-group">
            </ul>
        </div>

    </div>
    <!-- END TRADE TAB CONTENT -->
    </div>

    </div>
			  
		 	<!-- product detail Modal -->
			<div class="modal fade" id="myModal" data-keyboard="false" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modallg  modal-dialog">
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
                    <div class="col-md-3">
                        <div class="user-info-left">
                            <h2>Your Profile Photo</h2>
                            <span id="span_uimg">
                                <img style="max-width: 300px;" class="prodpic" src="${pageContext.request.contextPath}/user/img/userid/{{userid}}" alt="Profile Picture">
                            </span>
                            <div class="contact" id="imgform">
                                <form id="imgsubmit" method="post" enctype="multipart/form-data">
                                    <td><input class="btn btn-block" type="file" id="img_input" name="file" />
                                    <td><input class="btn btn-block btn-custom-secondary" type="submit" value="Upload" />
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="user-info-right">
                            <form class="form-horizontal" role="form">
                                <fieldset>
                                    <legend>User Information</legend>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Email</label>
                                        <div class="col-sm-9">
                                            <input type="email" class="form-control" id="email" value="{{email}}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">First Name</label>
                                        <div class="col-sm-9">
                                            <input class="form-control" id="fn" value="{{firstname}}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Last Name</label>
                                        <div class="col-sm-9">
                                            <input class="form-control" id="ln" value="{{lastname}}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Your City</label>
                                        <div class="col-sm-9">
                                            <input class="form-control" id="autocomplete" onFocus="geolocate()" placeholder="Please enter your City,Country" value="{{location}}">
                                            <input id="lat" type="hidden" value="{{lat}}" />
                                            <input id="lng" type="hidden" value="{{lng}}"/>
                                        </div>
                                    </div>


                                    <legend>About You</legend>

                                    <div class="form-group">
                                        <div class="col-sm-9">
                                            <textarea id="txt_aboutme" class="form-control" name="ticket-message" rows="5" cols="30" placeholder="Lets introduce yourself...">{{aboutme}}</textarea>
                                        </div>
                                    </div>
                                    <input class="btn btn-primary" value="submit" id="submit"/>

                                </fieldset>

                            </form>

                        </div>
                    </div>
                </div>
	 		</script>
	 		
	 		<script type="text/template" id="prodlisttmp">
                <div class="row list-group masonrycontainer king-gallery"></div>
			</script>
	 		<script type="text/template" id="prodlistitemtmp">
                    <div class="thumbnail">
                        <img class="list-group-image" src="{{thumurl}}" alt="">
                        <div class="caption">
                            <h3 class="inner list-group-item-heading">{{title}}</h3>
                            <div class="action-buttons">
                                <a id="modalbtn" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal">
                                    <i class="fa fa-pencil"></i>Edit
                                </a>
                            </div>
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
			 <script type="text/javascript" id="tmp" src="resources/application/product.js"></script>
			 <script type="text/javascript" id="tmp" src="resources/application/profile.js"></script>
			 <script type="text/javascript"  id="tmp2" src="resources/application/app.js"></script>
			 <script type="text/javascript"  id="tmp2" src="resources/application/tradelist.js"></script>
	<!--end bootstrap dependencies-->

	</tiles:putAttribute>
</tiles:insertDefinition>
