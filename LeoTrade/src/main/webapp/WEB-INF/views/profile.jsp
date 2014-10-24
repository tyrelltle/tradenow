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

    <div class="main-content">
    <div class="main-header">
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

    <!-- ACTIVITY TAB CONTENT -->
    <div class="tab-pane activity" id="lB">
        <ul class="list-unstyled activity-list">
            <li>
                <i class="fa fa-shopping-cart activity-icon pull-left"></i>
                <p>
                    <a href="#">Jonathan</a> commented on <a href="#">Special Deal 2013</a> <span class="timestamp">12 minutes ago</span>
                </p>
            </li>
            <li>
                <i class="fa fa-pencil activity-icon pull-left"></i>
                <p>
                    <a href="#">Jonathan</a> posted <a href="#">a new blog post</a> <span class="timestamp">4 hours ago</span>
                </p>
            </li>
            <li>
                <i class="fa fa-user activity-icon pull-left"></i>
                <p>
                    <a href="#">Jonathan</a> edited his profile <span class="timestamp">11 hours ago</span>
                </p>
            </li>
            <li>
                <i class="fa fa-pencil activity-icon pull-left"></i>
                <p>
                    <a href="#">Jonathan</a> has added review on <a href="#">jQuery Complete Guide</a> book <span class="timestamp">Yesterday</span>
                </p>
            </li>
            <li>
                <i class="fa fa-thumbs-up activity-icon pull-left"></i>
                <p>
                    <a href="#">Jonathan</a> liked <a href="#">a post</a> <span class="timestamp">December 12</span>
                </p>
            </li>
            <li>
                <i class="fa fa-tasks activity-icon pull-left"></i>
                <p>
                    <a href="#">Jonathan</a> has completed one task <span class="timestamp">December 11</span>
                </p>
            </li>
            <li>
                <i class="fa fa-picture-o activity-icon pull-left"></i>
                <p>
                    <a href="#">Jonathan</a> uploaded <a href="#">new photos</a> <span class="timestamp">December 5</span>
                </p>
            </li>
            <li>
                <i class="fa fa-credit-card activity-icon pull-left"></i>
                <p>
                    <a href="#">Jonathan</a> has updated his credit card info <span class="timestamp">September 28</span>
                </p>
            </li>

        </ul>
        <p class="text-center more"><a href="#" class="btn btn-custom-primary">View more <i class="fa fa-long-arrow-right"></i></a></p>
    </div>
    <!-- END ACTIVITY TAB CONTENT -->

    <!-- SETTINGS TAB CONTENT -->
    <div class="tab-pane settings" id="lC">
        <form class="form-horizontal" role="form">
            <fieldset>
                <h3><i class="fa fa-square"></i> Change Password</h3>
                <div class="form-group">
                    <label for="old-password" class="col-sm-3 control-label">Old Password</label>
                    <div class="col-sm-4">
                        <input type="password" id="old-password" name="old-password" class="form-control">
                    </div>
                </div>
                <hr>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">New Password</label>
                    <div class="col-sm-4">
                        <input type="password" id="password" name="password" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password2" class="col-sm-3 control-label">Repeat Password</label>
                    <div class="col-sm-4">
                        <input type="password" id="password2" name="password2" class="form-control">
                    </div>
                </div>
            </fieldset>

            <fieldset>
                <h3><i class="fa fa-square"></i> Privacy</h3>
                <div class="simple-checkbox">
                    <input type="checkbox" id="checkbox">
                    <label for="checkbox">Show my display name</label>
                </div>
                <div class="simple-checkbox">
                    <input type="checkbox" id="checkbox2">
                    <label for="checkbox2">Show my birth date</label>
                </div>
                <div class="simple-checkbox">
                    <input type="checkbox" id="checkbox3">
                    <label for="checkbox3">Show my email</label>
                </div>
                <div class="simple-checkbox">
                    <input type="checkbox" id="checkbox4">
                    <label for="checkbox4">Show my online status on chat</label>
                </div>
            </fieldset>

            <h3><i class="fa fa-square"> </i>Notifications</h3>
            <fieldset>
                <div class="form-group">
                    <label class="col-sm-5 control-label">Receive message from administrator</label>
                    <ul class="col-sm-7 list-inline">
                        <li>
                            <div class="has-switch switch-animate switch-small switch-on" tabindex="0"><div><span class="switch-left"><i class="glyphicon glyphicon-globe"></i></span><label>&nbsp;</label><span class="switch-right switch-default"><i class="glyphicon glyphicon-globe"></i></span><input type="checkbox" checked="" class="bs-switch switch-small" data-off="default" data-on-label="<i class='glyphicon glyphicon-globe'></i>" data-off-label="<i class='glyphicon glyphicon-globe'></i>"></div></div>
                        </li>
                        <li>
                            <div class="has-switch switch-animate switch-small switch-on" tabindex="0"><div><span class="switch-left"><i class="glyphicon glyphicon-phone"></i></span><label>&nbsp;</label><span class="switch-right switch-default"><i class="glyphicon glyphicon-phone"></i></span><input type="checkbox" checked="" class="bs-switch switch-small" data-off="default" data-on-label="<i class='glyphicon glyphicon-phone'></i>" data-off-label="<i class='glyphicon glyphicon-phone'></i>"></div></div>
                        </li>
                        <li>
                            <div class="has-switch switch-animate switch-small switch-on" tabindex="0"><div><span class="switch-left"><i class="glyphicon glyphicon-envelope"></i></span><label>&nbsp;</label><span class="switch-right switch-default"><i class="glyphicon glyphicon-envelope"></i></span><input type="checkbox" checked="" class="bs-switch switch-small" data-off="default" data-on-label="<i class='glyphicon glyphicon-envelope'></i>" data-off-label="<i class='glyphicon glyphicon-envelope'></i>"></div></div>
                        </li>
                    </ul>
                </div>
                <div class="form-group">
                    <label class="col-sm-5 control-label">New product has been added</label>
                    <ul class="col-sm-7 list-inline">
                        <li>
                            <div class="has-switch switch-animate switch-small switch-off" tabindex="0"><div><span class="switch-left"><i class="glyphicon glyphicon-globe"></i></span><label>&nbsp;</label><span class="switch-right switch-default"><i class="glyphicon glyphicon-globe"></i></span><input type="checkbox" class="bs-switch switch-small" data-off="default" data-on-label="<i class='glyphicon glyphicon-globe'></i>" data-off-label="<i class='glyphicon glyphicon-globe'></i>"></div></div>
                        </li>
                        <li>
                            <div class="has-switch switch-animate switch-small switch-on" tabindex="0"><div><span class="switch-left"><i class="glyphicon glyphicon-phone"></i></span><label>&nbsp;</label><span class="switch-right switch-default"><i class="glyphicon glyphicon-phone"></i></span><input type="checkbox" checked="" class="bs-switch switch-small" data-off="default" data-on-label="<i class='glyphicon glyphicon-phone'></i>" data-off-label="<i class='glyphicon glyphicon-phone'></i>"></div></div>
                        </li>
                        <li>
                            <div class="has-switch switch-animate switch-small switch-on" tabindex="0"><div><span class="switch-left"><i class="glyphicon glyphicon-envelope"></i></span><label>&nbsp;</label><span class="switch-right switch-default"><i class="glyphicon glyphicon-envelope"></i></span><input type="checkbox" checked="" class="bs-switch switch-small" data-off="default" data-on-label="<i class='glyphicon glyphicon-envelope'></i>" data-off-label="<i class='glyphicon glyphicon-envelope'></i>"></div></div>
                        </li>
                    </ul>
                </div>
                <div class="form-group">
                    <label class="col-sm-5 control-label">Product review has been approved</label>
                    <ul class="col-sm-7 list-inline">
                        <li>
                            <div class="has-switch switch-animate switch-small switch-on" tabindex="0"><div><span class="switch-left"><i class="glyphicon glyphicon-globe"></i></span><label>&nbsp;</label><span class="switch-right switch-default"><i class="glyphicon glyphicon-globe"></i></span><input type="checkbox" checked="" class="bs-switch switch-small" data-off="default" data-on-label="<i class='glyphicon glyphicon-globe'></i>" data-off-label="<i class='glyphicon glyphicon-globe'></i>"></div></div>
                        </li>
                        <li>
                            <div class="has-switch switch-animate switch-small switch-off" tabindex="0"><div><span class="switch-left"><i class="glyphicon glyphicon-phone"></i></span><label>&nbsp;</label><span class="switch-right switch-default"><i class="glyphicon glyphicon-phone"></i></span><input type="checkbox" class="bs-switch switch-small" data-off="default" data-on-label="<i class='glyphicon glyphicon-phone'></i>" data-off-label="<i class='glyphicon glyphicon-phone'></i>"></div></div>
                        </li>
                        <li>
                            <div class="has-switch switch-animate switch-small switch-on" tabindex="0"><div><span class="switch-left"><i class="glyphicon glyphicon-envelope"></i></span><label>&nbsp;</label><span class="switch-right switch-default"><i class="glyphicon glyphicon-envelope"></i></span><input type="checkbox" checked="" class="bs-switch switch-small" data-off="default" data-on-label="<i class='glyphicon glyphicon-envelope'></i>" data-off-label="<i class='glyphicon glyphicon-envelope'></i>"></div></div>
                        </li>
                    </ul>
                </div>
                <div class="form-group">
                    <label class="col-sm-5 control-label">Others liked your post</label>
                    <ul class="col-sm-7 list-inline">
                        <li>
                            <div class="has-switch switch-animate switch-small switch-off" tabindex="0"><div><span class="switch-left"><i class="glyphicon glyphicon-globe"></i></span><label>&nbsp;</label><span class="switch-right switch-default"><i class="glyphicon glyphicon-globe"></i></span><input type="checkbox" class="bs-switch switch-small" data-off="default" data-on-label="<i class='glyphicon glyphicon-globe'></i>" data-off-label="<i class='glyphicon glyphicon-globe'></i>"></div></div>
                        </li>
                        <li>
                            <div class="has-switch switch-animate switch-small switch-off" tabindex="0"><div><span class="switch-left"><i class="glyphicon glyphicon-phone"></i></span><label>&nbsp;</label><span class="switch-right switch-default"><i class="glyphicon glyphicon-phone"></i></span><input type="checkbox" class="bs-switch switch-small" data-off="default" data-on-label="<i class='glyphicon glyphicon-phone'></i>" data-off-label="<i class='glyphicon glyphicon-phone'></i>"></div></div>
                        </li>
                        <li>
                            <div class="has-switch switch-animate switch-small switch-off" tabindex="0"><div><span class="switch-left"><i class="glyphicon glyphicon-envelope"></i></span><label>&nbsp;</label><span class="switch-right switch-default"><i class="glyphicon glyphicon-envelope"></i></span><input type="checkbox" class="bs-switch switch-small" data-off="default" data-on-label="<i class='glyphicon glyphicon-envelope'></i>" data-off-label="<i class='glyphicon glyphicon-envelope'></i>"></div></div>
                        </li>
                    </ul>
                </div>
            </fieldset>
        </form>

        <p class="text-center"><a href="#" class="btn btn-custom-primary"><i class="fa fa-floppy-o"></i> Save Changes</a></p>

    </div>
    <!-- END SETTINGS TAB CONTENT -->
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
			 <script type="text/javascript" id="tmp" src="resources/application/product.js"></script>
			 <script type="text/javascript" id="tmp" src="resources/application/profile.js"></script>
			 <script type="text/javascript"  id="tmp2" src="resources/application/app.js"></script>
			 <script type="text/javascript"  id="tmp2" src="resources/application/tradelist.js"></script>
	<!--end bootstrap dependencies-->

	</tiles:putAttribute>
</tiles:insertDefinition>
