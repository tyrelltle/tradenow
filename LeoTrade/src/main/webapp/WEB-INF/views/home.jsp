<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


	
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="header">
	
	    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/masonry.pkgd.js"></script>
	    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/imagesloaded.pkgd.js"></script>
		
	    <style type="text/css">	

			.carousel-inner > .item > img, 
			.carousel-inner > .item > a > img{
				width: 100%; /* use this, or not */
				margin: auto;
			}
			.footer{
				border:none;
			}
	    	.galitem{
	    		width:200px;
	    	}
	    	.modallg{
	    		width:60%;
	    	}
			.masonryitem{
				margin: 0px;
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
			#prodlispanel{

			background-color: inherit !important;
			border: none !important;
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
	</tiles:putAttribute>
    <tiles:putAttribute name="main">

        <!-- Tour toggle button  -->
        <div id="tourbtn"><button>Take A Tour<i class="fa fa-question-circle"></i></button></div>
        <script>
            $('#tourbtn').click(function () {
                        TourManager.startHomeTour(true);
                    }
            );
        </script>
   			<c:if test="${not empty catid}">
      			<input id="catid" type="hidden" value="${catid}"/>
    		</c:if>
   			<c:if test="${not empty likes}">
      			<input id="likes" type="hidden" />
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
			      	<div class="row modal-bodyy"></div>
			      </div>
			      <div class="modal-footer">
			       
			        <button type="button" id="btn_trade" class="btn btn-primary">Trade!</button>
			        <button type="button" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Cancel</button>
			      </div>
			    </div>
			  </div>
			</div>
	<!--start bootstrap templates-->		 



	 		<script type="text/template" id="prodlisttmp">


							<div class = "masonrycontainer"   >
							</div>
							<center>
								<div  id="loadmore" >Load More</div>
							</center>
				
				

			</script>
			

			
			
	 		<script type="text/template" id="prodlistitemtmp">
								<div class="blog-item">
									<img alt="" id="btn_detail" class="btn_detail" src="{{thumurl}}">
									<div class="blog-item-description">
										<h3>{{title}}</h3>
										<div class="row">
											<div class="col-md-4">
												<a href="user/userid/{{userid}}"><img style="width:50px;border-radius: 12px;" src="{{ownerimgurl}}"/></a>
											</div>
											<div class="col-md-8">
												<p class="ownernm">{{ownernm}}</p> 
												<p>{{owneraddr}}</p>
											</div>

										</div>
										<a class="btn_detail more">Keep reading <i class="fa fa-angle-right"></i></a>
										<a id="likebtn"><i class="glyphicon glyphicon-heart btnunlike"></i></a>
									</div>
								</div>
								<div class="bottom-border">
								</div>




	        
			</script>
			
			<script type="text/template" id="proddetailtmp">
			      
			   
				<div >
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
	 		
	 		<script type="text/template" id="imglistitemtmp">
	<div class="item active">
      <img class="galimg" src="{{url}}" max-width: 500px;margin: 0 auto;" alt="...">
      <div class="carousel-caption">
        ...
      </div>
    </div>
			</script>
			<script type="text/template" id="imglistitemtmp2">
	<div class="item">
      <img class="galimg" src="{{url}}" max-width: 500px;margin: 0 auto;" alt="...">
      <div class="carousel-caption">
        ...
      </div>
    </div>
			</script>
	<!--end bootstrap templates--> 	
	
	
	
						
	
	
		
	<!--start bootstrap dependencies-->	
			 <script type="text/javascript" id="tmp" src="${pageContext.request.contextPath}/resources/js/application/browseproduct.js"></script>
			 
			 <script type="text/javascript"  id="tmp3" src="${pageContext.request.contextPath}/resources/js/application/homeapp.js"></script>

			 
	<!--end bootstrap dependencies-->

	</tiles:putAttribute>
</tiles:insertDefinition>

