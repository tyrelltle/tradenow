<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="template">
	<tiles:putAttribute name="header">
	
			<script>var ctx = "${pageContext.request.contextPath}/"</script>
		    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/masonry.pkgd.js"></script>
		    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/imagesloaded.pkgd.js"></script>
				<style>
				/* CSS used here will be applied after bootstrap.css */
				.btnsubmit{
				margin-left:-12px;
				margin-top:10px;
				border-radius:20px;
				}
				.midblock{
				margin-top:45px;
				}
				div {
				//border: green;
				//border-style: solid;
				}
				 
				.prodpic{
				width:300px !important;
				  
				}
/* 				.midblock{ */
/* 				height:280px; */
/* 				margin-top:50px; */
/* 				} */
				
				#msg_row{
				margin-top:40px;
				}
				.midcontainer {
				width:600px;
				}
				
				.message{
				overflow-wrap: break-word;
				margin-top:10px;
				}
				
				.sidepanel{
				margin-top:50px;
				}
				.modal-lg-cust{
				width:1275px;
				}
				.masonryitem{
				width: 200px;
				margin: 10px;
				}
				#catlistpanel{
					float:left;
				}
				.hid{
					display:none;
				}
				.msgdate{
					margin-left:125px;
				}
				</style>
</tiles:putAttribute>

<tiles:putAttribute name="left">
		  <div></div>	
</tiles:putAttribute>
<tiles:putAttribute name="main">

				

				<div class="container">
			      		<div id="msgholder" class="hid">
			      			<div class="row">
			      				<div id="msg" class="col-md-11"></div>
			      				<div class="col-md-1">
			      					<button type="button" class="msgdismiss btn btn-default btn-sm">
								  		<span class="glyphicon glyphicon-remove"></span>
									</button>
								</div>
			      			</div>
			      		</div>
			      		<c:if test="${not empty msg}">
			      			<input id="srvrmsg" type="hidden" value="${msg}"/>
			    		</c:if>
				    <div id="block" class="panel col-md-12">
				        <div id="userpanel" class="sidepanel col-md-2">
				             <ul class="list-group">
				              <li class="list-group-item">
									<p class="fromusernm">${trade.prod1.owner.firstname} ${trade.prod1.owner.lastname}</p>
									<input type="hidden" id="hide_fromuserid" value="${trade.prod1.owner.userid}"/>
									<a href="${pageContext.request.contextPath}/user/userid/${trade.prod1.owner.userid}">
				              			<img alt="pic" class="img-thumbnail prodpic" src="${pageContext.request.contextPath}/user/img/userid/${trade.prod1.owner.userid}">
				                 	</a>
				             </li>
				             <li class="list-group-item"> Status: <span  id="label_status1" style="color:white"></span></li>
				              <li class="list-group-item">
				              	  <button type="button" id="choosebtn" class="btn btn-default">Choose Item</button>
				              </li>
				              <li class="list-group-item">
				                Delivery Method
				                  <select class="form-control">
				                    <option>In Person</option>
				                  </select> 
				               
				              </li>
				              
				            </ul>
				      	</div>
				        <div class="midblock col-md-7">
				            <div class="midcontainer container">
				                <div id="two_prod_row" class="row">
				                    <div id="prod_left" class="col-md-5">
				                    	<p id="prod1title">${trade.prod1.title}</p>
				                        <img alt="pic" id="leftprodpic" class="img-thumbnail prodpic" src="${pageContext.request.contextPath}/${trade.prod1.thumurl}">
				                    </div>
				                    <div class="col-md-2" style="margin-top:40px">
				                        <button type="button" class="btn btn-default btn-lg"> <span class="glyphicon glyphicon-transfer"></span> 
				                        </button>
		                         		<input type="hidden" id="tradeid" value="${trade.trade_id}" placeholder="Last name"/>
		                         		<input type="hidden" id="prod1id" value="${trade.prod1.prod_id}" placeholder="Last name"/>
		                         		<input type="hidden" id="prod2id" value="${trade.prod2.prod_id}" placeholder="Last name"/>	
		                         		<input type="hidden" id="status1" value="${trade.status1}" placeholder="Last name"/>				                         		
		                         		<input type="hidden" id="status2" value="${trade.status2}" placeholder="Last name"/>				                         		
		                         					                         		
		                         		<input type="hidden" id="side" value="${side}" placeholder="Last name"/>
		                         						                         			
		                       			<button type="submit" id="btnpropose" style="border-radius: 20px" class="btnsubmit btn btn-success">Propose!</button>
				                        <button type="button" id="btnaccepted" style="width:100%;margin-top: 5px;margin-left: -4px;border-radius: 20px" class="btn btn-success">Accept!</button>
				                        
				                    </div>
				                    <div id="prod_right" class="col-md-5">
				                    	<p>${trade.prod2.title}</p>
				                        <img alt="pic" class="img-thumbnail prodpic" src="${pageContext.request.contextPath}/${trade.prod2.thumurl}">
				                    </div>
				                </div>
				                <div id="msg_row" class="row">
				                  <div class="panel panel-default">
				                    <div class="panel-heading">
				                      <h3 class="panel-title">Messages</h3>
				                    </div>
				                    <div class="panel-body">
				                    
				                  
				                          <div class="midcontainer container">
				                                <div id="newmsg_row" class="row">
				                                    <div class="col-md-10">
				                                      <textarea id="msgtxt" class="form-control" rows="3"></textarea> 
				                                        
				                                    </div>
				                                    <div class="col-md-1">                              	
				                                        <button type="button" id="msgbtn" class="btn btn-primary">Send</button>
				                                    </div>
				                                </div>
				                                <div id="msglis_row" class="row">
				                                    <div class="msglis_container midcontainer container">
				                                        <!--bunch of msg rows -->
				                                         <div class="message row">
				                                            <div class="col-md-2">
				                                                <img alt="pic" class="img-thumbnail prodpic" src="http://img.vip.xunlei.com/img/banner/201307291420313509.jpg">
				                                            </div>
															<div class="message_body col-md-7">
				                                              <div class="msgdate">Mon 19, 2014</div>
				                                              <div class="well well-sm">
				                                                  helloworldddddddddddddddddddddddddddddddddddddddd
				
				                                              </div>
				                                            </div>                                        </div>
				                                        <div class="message row">
				                                            <div class="message_body col-md-offset-2 col-md-7">
				                                              <div class="msgdate">Mon 19, 2014</div>
				                                              <div class="well well-sm">
				                                                  helloworldddddddddddddddddddddddddddddddddddddddd
				
				                                              </div>
				                                            </div>
				                                            <div class="col-md-2">
				                                                <img alt="pic" class="img-thumbnail prodpic" src="http://img.vip.xunlei.com/img/banner/201307291420313509.jpg">
				                                            </div>
				                                        </div>
				                                    </div>
				                                </div>
				                          </div>
				                     </div>
				                   </div>
				                </div>
				            </div>
				        </div>
				    	<div id="userpanel" class="sidepanel upblock col-md-2">
				      		<ul class="list-group">
				              <li class="list-group-item">
				              		<p class="tousernm">${trade.prod2.owner.firstname} ${trade.prod2.owner.lastname}</p>
				              		<a href="${pageContext.request.contextPath}/user/userid/${trade.prod2.owner.userid}">
				              			<img alt="pic" class="img-thumbnail prodpic" src="${pageContext.request.contextPath}/user/img/userid/${trade.prod2.owner.userid}">
				              		</a>
				              </li>
				              <li class="list-group-item"> Status: <span id="label_status2" style="color:white"></span></li>
				              
				              <li class="list-group-item">
				                Delivery Method
				                  <select class="form-control">
				                    <option>In Person</option>
				                  </select> 
				               
				              </li>
				              
				            </ul>
				      
				      
				        </div>
				    </div>
				</div>
		



			<!-- Deal done modal -->
			<div class="modal fade" id="dealdone" data-keyboard="false" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-lg-cust modal-dialog">
			    <div class="modal-content">
			      <div class="modalheader modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <div class="modal-title" id="myModalLabel">Congradulations!</div>
			      </div>
			      <div id="div_dealdone" class="modal-body">
			      	 This trade has been finished because both of you have aceepted the offer!
			      </div>
			      <div class="modal-footer">
			        <button type="button" id="prod_save" data-dismiss="modal" class="btn btn-primary">Dismiss</button>
			      </div>
			    </div>
			  </div>
			</div>
			
			<!-- product list Modal -->
			<div class="modal fade" id="prodlismodel" data-keyboard="false" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-lg-cust modal-dialog">
			    <div class="modal-content">
			      <div class="modalheader modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <div class="modal-title" id="myModalLabel">Choose an item from the list!</div>
			      </div>
			      <div id="prodlist" class="modal-body">
			      
			      </div>
			      <div class="modal-footer">
			        <button type="button" id="prod_save" data-dismiss="modal" class="btn btn-primary">Dismiss</button>
			      </div>
			    </div>
			  </div>
			</div>


				
			<!-- product detail Modal -->
			<div class="modal fade" id="proddetail" data-keyboard="false" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-lg modal-dialog">
			    <div class="modal-content">
			      <div class="modalheader modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <div class="modal-title" id="myModalLabel">Item detail</div>
			      </div>
			      <div class="proddetailcontent">
			      
			      </div>
			      <div class="modal-footer">
			        <button type="button" id="prod_save" data-dismiss="modal" class="btn btn-primary">Dismiss</button>
			      </div>
			    </div>
			  </div>
			</div>
		<!--start bootstrap templates-->		 
	 		<script type="text/template" id="imglistitemtmp">
	<div class="item active">
      <img class="galimg" src="${pageContext.request.contextPath}/{{url}}" max-width: 500px;margin: 0 auto;" alt="...">
      <div class="carousel-caption">
        ...
      </div>
    </div>
			</script>
			<script type="text/template" id="imglistitemtmp2">
	<div class="item">
      <img class="galimg" src="${pageContext.request.contextPath}/{{url}}" max-width: 500px;margin: 0 auto;" alt="...">
      <div class="carousel-caption">
        ...
      </div>
    </div>
			</script>
	 		
	 		<script type="text/template" id="prodlisttmp">
				<div class = "masonrycontainer"   style="margin-top: 60px;">
				</div>
				<center>
				<button type="button" id="loadmore" class="btn btn-default">Load More</button>
				</center>

			</script>
			
	 		<script type="text/template" id="msglisitemtmp1">			
				<div class="col-md-2">
	                 <img alt="pic" class="img-thumbnail prodpic" src="${pageContext.request.contextPath}/{{imgurl}}">
	            </div>
				<div class="message_body col-md-7">
		             <div class="msgdate">{{date}}</div>
		             <div class="well well-sm">
		                 {{message}}
		             </div>
	            </div>     
			</script>
			<script type="text/template" id="msglisitemtmp2">			
				<div class="message_body col-md-offset-2 col-md-7">
		             <div class="msgdate">{{date}}</div>
		             <div class="well well-sm">
		                 {{message}}
		             </div>
	            </div> 
				<div class="col-md-2">
	                 <img alt="pic" class="img-thumbnail prodpic" src="${pageContext.request.contextPath}/{{imgurl}}">
	            </div>    
			</script>
	 		<script type="text/template" id="prodlistitemtmp">
				      <div class="masonryitem">			      
				      	<div class="panel panel-default">
				          <div class="panel-thumbnail"><img src="${pageContext.request.contextPath}/{{thumurl}}" class="img-responsive"></div>
				          <div class="panel-body">
				            <p class="lead">{{title}}</p>
				          <!-- Button trigger modal -->
								<button id="select" class="btn_detail btn btn-primary btn-sm" data-toggle="modal" data-target="#proddetail">
  									Detail
								</button>
								<button id="detail" class="btn_select btn btn-primary btn-sm">
  									Select Item!
								</button>
				          </div>
				        </div>		        
				      </div>																	     
			</script>
			
			
			<script type="text/template" id="proddetailtmp">
			      
			   
				<div class="row" >
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
					
					<div id="imgliscontainer" >
						<div id="imgliss">



<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
  <!--   <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>-->
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
   
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
  </a>
</div>

						</div>
					</div>
				
			   </div> <!-- img holder-->
			 </div><!-- main content holder-->
			      
	 		</script>
	<!--end bootstrap templates--> 	
	
	
		
	
	
						
	
	
		
	<!--start bootstrap dependencies-->	
				 <script type="text/javascript"  id="tmp3" src="${pageContext.request.contextPath}/resources/js/application/trademessage.js"></script>
	
			 <script type="text/javascript" id="tmp" src="${pageContext.request.contextPath}/resources/js/application/browseproduct.js"></script>
			 <script type="text/javascript"  id="tmp2" src="${pageContext.request.contextPath}/resources/js/application/tradeapp.js"></script>
			 
	<!--end bootstrap dependencies-->
				
</tiles:putAttribute>
</tiles:insertDefinition>
