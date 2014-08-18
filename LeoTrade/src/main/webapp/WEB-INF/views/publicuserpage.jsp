<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>



<tiles:insertDefinition name="template">
	<tiles:putAttribute name="header">

	    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/masonry.pkgd.js"></script>
	    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/imagesloaded.pkgd.js"></script>
	    
	    <style type="text/css">	

			.detailsglyph{
				float:right;
				margin-top:50px;
			}
			.masonryitem{
				margin: 10px;
				width:200px;
			}
			
			.masonrycontainer{
				width: 900px;
				margin: 10px;
			}
			#prodlispanel{
				width:940px;
			}
	    </style>
	</tiles:putAttribute>

	<tiles:putAttribute name="left">
			  <div></div>	
	</tiles:putAttribute>
    <tiles:putAttribute name="main">
   
			  <input type="hidden" id="userid" value="${userid}"/>
		      <div class="panel panel-default">
		      		<div  class="panel-body">
							<div id="profile_detail" class="col-md-offset-1">

			                </div>		
			                <div id="prodlist" class="col-md-offset-1">

			                </div>				
					</div>
							
		
				
			 </div>
			<!-- product detail Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modallg modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel"></h4>
			      </div>
			      <div class="modal-body">
			      	<div class="modal-bodyy row"></div>
			      </div>
			      <div class="modal-footer">
			       
			        <button type="button" id="btn_trade" class="btn btn-primary">Trade!</button>
			      </div>
			    </div>
			  </div>
			</div>
	<!--start bootstrap templates-->		 
			 <script type="text/template" id="usertmp">
		<div id="prodlispanel" class="panel panel-default">
			<div  class="panel-body">
			 <div class="row">
				<div class="col-md-offset-1 col-md-6">				
					<address>
  						<strong style="font-size:50px">{{firstname}}, {{lastname}}</strong><br>
  						{{location}}
					</address>
					


					<div class="input-group input-group-md">
  							<span class="input-group-addon">About me</span>
 						 	<textarea id="txt_aboutme" rows=6 class="form-control"  placeholder="About you" readonly>{{aboutme}}</textarea>
					</div>

				</div>
				<div class="col-md-5">
					<p><img alt="pic" class="img-thumbnail prodpic" style="width:250px" src="${pageContext.request.contextPath}/user/img/userid/{{userid}}"></p>

				</div>
			</div>
		</div> 
		</div>
	 		</script>
	 		
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
				<div id="prodlispanel" class="panel panel-default">
			      		<div  class="panel-body">
							<div class = "masonrycontainer"   >
							</div>
							<center>
								<button type="button" id="loadmore" class="btn btn-default">Load More</button>
							</center>
						</div>
				</div>
				

			</script>
	 		<script type="text/template" id="prodlistitemtmp">
				      	<div class="panel panel-default">
				          <div class="panel-thumbnail"><a><img src="${pageContext.request.contextPath}/{{thumurl}}" class="btn_detail img-responsive"></a></div>

						  <div class="panel-footer">
							<div class="row">
								<div class="col-md-12" style="font-size:15px">{{title}}</div>
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
			 <script type="text/javascript" id="tmp" src="${pageContext.request.contextPath}/resources/js/application/browseproduct.js"></script>
			 <script type="text/javascript" id="tmp" src="${pageContext.request.contextPath}/resources/js/application/profile.js"></script>
			 <script type="text/javascript"  id="tmp2" src="${pageContext.request.contextPath}/resources/js/application/userpageapp.js"></script>
	<!--end bootstrap dependencies-->

	</tiles:putAttribute>
</tiles:insertDefinition>
