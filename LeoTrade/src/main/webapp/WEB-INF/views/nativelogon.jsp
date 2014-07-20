<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<tiles:insertDefinition name="template">
	<tiles:putAttribute name="header">
		<link href="${pageContext.request.contextPath}/resources/themes/bootstrap-3.1.1/css/bootstrap.min.css" rel="stylesheet">  
		<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places"></script>
		<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/scripts/application/autocompleteapi.js"></script>
		
		<style>
		.logincontainer{
		 margin-top:100px; 
		  
		}
		
		</style>

	</tiles:putAttribute>
	<tiles:putAttribute name="left">
			  <div></div>	
	</tiles:putAttribute>
	
	<tiles:putAttribute name="main">
	
		<div class="logincontainer container">
		  <div class="row">
		      <form class="form col-md-6 center-block" method="POST" action="${pageContext.request.contextPath}/j_spring_security_check" >
		                  <div class="form-group">
		                    <input type="text" class="form-control input-lg" name="username" placeholder="Email"/>
		                  </div>
		                  <div class="form-group">
		                    <input type="password" class="form-control input-lg" name="password" placeholder="Password"/>
		                  </div>
		                  <div class="form-group">
		                    <button class="btn btn-primary btn-lg btn-block" type="submit">Sign In</button>
		                   <span><a href="#">${errorlogin}</a></span>
		                  </div>
		                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		      </form>
		      <form:form class="form col-md-6 center-block" id="regform"  method="POST" commandName="userForm" action="nativeregister">
						 
		                  <div class="form-group">
		                    <form:input type="text" class="form-control input-lg" path="email" placeholder="Email"/>
		                  </div>
		                  <div class="form-group">
		                    <form:input type="text" class="form-control input-lg" path="firstname" placeholder="First name"/>
		                  </div>
		        		  <div class="form-group">
		                    <form:input type="text" class="form-control input-lg" path="lastname" placeholder="Last name"/>
		                  </div>
		        		  
		                  <div class="form-group">
		                    <form:input type="password" class="form-control input-lg" path="password" placeholder="Password"/>
		                  </div>
		
		                  <div class="form-group">
		                    <form:input type="text" id="autocomplete" onFocus="geolocate()" class="form-control input-lg" path="location" placeholder="Please enter your City,Country"/>
		                    <form:input id="lat" type="hidden" class="form-control input-lg"  path="lat" />
		                    <form:input id="lng" type="hidden" class="form-control input-lg" path="lng"  />
		
		                  </div>
							<script type="text/javascript">
								initializeAutocomplete();
								$("#regform").keypress(function(e){
								    if (e.which == 13) {
								       var tagName = e.target.tagName.toLowerCase(); 
								       if (tagName !== "textarea") {
								           return false;
								       }
								   }
								});
							</script>
		                  <div class="form-group">
		                    <form:button class="btn btn-primary btn-lg btn-block" type="submit">Register</form:button>
		                    <span class="pull-right">${error}</span>
		                  </div>
		      </form:form>
		
		  </div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>