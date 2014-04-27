<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>



<tiles:insertDefinition name="template">
	<tiles:putAttribute name="header">
		<script type="text/javascript" language="javascript" src="resources/scripts/jquery-1.10.2.js"></script>
	    <script type="text/javascript" language="javascript" src="resources/scripts/underscore.js"></script>
	    <script type="text/javascript" language="javascript" src="resources/scripts/backbone.js"></script>
	</tiles:putAttribute>

    <tiles:putAttribute name="main">
   

		      <div class="panel panel-default">
		      		<div  class="panel-body">
						<div class="tabbable tabs-left">
						  <ul class="nav nav-tabs">
						  		
							    <li class="active"><a href="#lA" id="tab_prof" data-toggle="tab">My Profile</a></li>
							    <li><a href="#lB" id="tab_prod" data-toggle="tab">My Products</a></li>
						  </ul>
						  <div class="tab-content">
							    <div class="tab-pane active" id="lA">
							    		<div id="profile_detail">
		
						                </div>
						        </div>
						        <div class="tab-pane" id="lB">
						                  <p>Products</p>
						        </div>
						  </div>
						</div>
					</div>
			 </div>
			 
			 <script type="text/template" id="usertmp">

			<p><label id="fn" >{{firstname}}</label>  <label id="ln">{{lastname}}</label></p>
			<p>{{email}}</p>
			<p>Your City: <input type="text" id="txt_loc" value = "{{location}}"/></p>
			<p>About You: <input type="text" id="txt_aboutme" value ="{{aboutme}}"/> </p>
			<input type="submit" id="submit"/>
	 		</script>
	 		
			 <script type="text/javascript" id="tmp" src="resources/scripts/profile/profile.js"></script>
			 <script type="text/javascript"  id="tmp2" src="resources/scripts/profile/app.js"></script>
	 		<div>testtesttest</div>


	</tiles:putAttribute>
</tiles:insertDefinition>
