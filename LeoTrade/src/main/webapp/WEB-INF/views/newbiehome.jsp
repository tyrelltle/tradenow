<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>



<tiles:insertDefinition name="newbietemplate">
	<tiles:putAttribute name="header">

	    <script type="text/javascript" language="javascript" src="resources/js/masonry.pkgd.js"></script>
	    <script type="text/javascript" language="javascript" src="resources/js/imagesloaded.pkgd.js"></script>
	    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places"></script>	    
	    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/application/autocompleteapi.js"></script>
	    
	    <style type="text/css">	
			
			.detailsglyph{
				float:right;
				margin-top:50px;
			}
			#profile_detail{
			padding-top: 45px;
			padding-bottom: 45px;
			}
		
	    </style>
	</tiles:putAttribute>

	<tiles:putAttribute name="left">
			  <div></div>	
	</tiles:putAttribute>
    <tiles:putAttribute name="main">
   

		      <div class="container">
		      		<div  class="row">
						
				    		<div id="profile_detail">

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
				<div class="col-md-3">
					<p><img alt="pic" class="img-thumbnail prodpic" style="width:250px" src="${pageContext.request.contextPath}/user/img/userid/{{userid}}"></p>
					<div id="imgform">
		  					<form id="imgsubmit" method="post" enctype="multipart/form-data">  
		     					<td><input type="file" id="img_input" name="file" />     
		     					<td><input type="submit" value="Upload" />   
		  					</form>  
					</div>
				</div>
				<div class="col-md-3">
					<a id="continue" href="#"><h3 style="margin-top:100px"><i class="glyphicon glyphicon-forward"></i><span id="continuetxt">Continue to the site</span></h3></a>
				</div>
			</div>
	 		</script>
	 		
	 	
	<!--end bootstrap templates--> 	
	<!--start bootstrap dependencies-->	
			 <script type="text/javascript" id="tmp" src="resources/js/application/profile.js"></script>
			 <script type="text/javascript"  id="tmp2" src="resources/js/application/newbieapp.js"></script>
	<!--end bootstrap dependencies-->

	</tiles:putAttribute>
</tiles:insertDefinition>
