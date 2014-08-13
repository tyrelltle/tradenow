<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


	
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="header">
	
	    <script type="text/javascript" language="javascript" src="resources/scripts/masonry.pkgd.js"></script>
	    <script type="text/javascript" language="javascript" src="resources/scripts/imagesloaded.pkgd.js"></script>
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/sidemenu/assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/sidemenu/assets/css/colors/blue.css">
	
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
	    		width:1024px;
	    	}
			.masonryitem{
				width: 260px;
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
			  <div class="catlist">

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

			<script type="text/template" id="catlistitemtmp">
					<div class="icon">
                        <i class="fa fa-chevron-right"></i>
                    </div>
                    <div class="title">{{name}}</div>
					
			</script>
	 		<script type="text/template" id="catlisttmp">
      <nav id="sidebar">
            <input id="slide" name="slide" type="checkbox">
            <label for="slide" class="icon open">
                <span class="glyphicon glyphicon-list"></span>
            </label>
            <div id="menu">
   			<c:if test="${not empty catid}">
      			<a href="home" class="allcat link">
    		</c:if>
   			<c:if test="${empty catid}">
      			<a href="home" class="allcat link active">
    		</c:if>
                    <div class="icon">
                        <i class="fa fa-home"></i>
                    </div>
                    <div class="title">All Categories</div>
                </a>
               
            </div>
        </nav>
							

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

						  <div class="footer panel-footer" style="background-image: url(resources/img/prodlistitem.png);color:white;background-color: #1E1F20;">
							<!--<div class="row">
								<div class="col-md-12" style="font-size:15px">{{title}}</div>
							</div>-->
						    <div class="row"  style="margin-top:8px">
								<div class="col-md-3">
									<a href="user/userid/{{userid}}"><img style="width:50px;border-radius: 12px;" src="{{ownerimgurl}}"/></a>
								</div>
								<div class="col-md-9">
									<p style="font-size:20px;text-transform:uppercase;">{{title}}:</p> 
									<p style="font-size:10px">{{owneraddr}}</p>
								</div>
							</div>
						  </div>
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
			 <script type="text/javascript" id="tmp" src="resources/scripts/application/browseproduct.js"></script>
			 <script type="text/javascript"  id="tmp2" src="resources/scripts/application/category.js"></script>
			 
			 <script type="text/javascript"  id="tmp3" src="resources/scripts/application/homeapp.js"></script>

			 
	<!--end bootstrap dependencies-->

	</tiles:putAttribute>
</tiles:insertDefinition>

