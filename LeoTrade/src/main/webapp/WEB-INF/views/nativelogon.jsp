<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<tiles:insertDefinition name="logintemplate">
	<tiles:putAttribute name="header">
		<link href="${pageContext.request.contextPath}/resources/semanticui/css/semantic.css" rel="stylesheet">  
		
		<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places"></script>
		<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/application/autocompleteapi.js"></script>
		
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
			<section>
		<div class="blog">
				<div class="container">
					<div class="row">
							
						
							<!--tiles main-->
							<div class="container col-md-12" id="main" >

<div class="ui two column middle aligned relaxed grid basic segment">
		  <div class="column">
		   
			      		<form  id="regform" method="POST" action="${pageContext.request.contextPath}/j_spring_security_check" >
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
		                  <div>
		                  	<a href="#" onclick="$('.ps_email').show();"><h4>Forgot Password</h4></a>
		                    <div class="form-group">
		                    	<h5 class="ps_email" style="display:none">We will send you an email containing password reset information</h5>
		                    	<input type="text" style="display:none" class="ps_email form-control input-lg" id="ps_email" placeholder="Enter your email"/>
		                    	<button style="display:none;width:25%" id="btn_send_reset_email" class="ps_email btn btn-primary btn-lg btn-block">Send</button>
		                    
		                    </div>
		                  </div>

		                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		                  <c:if test="${not empty loginerror}">
		                    	<div class="alert alert-danger" role="alert">${loginerror}</div>
 			    		  </c:if>		
		      			</form>
		  
		  </div>
		  <div class="ui vertical divider">
		    Or
		  </div>
		  <div class="center aligned column">
		   				 <form:form  id="regform"  method="POST" commandName="userForm" action="nativeregister">
						 
		                  <div class="form-group">
		                    <form:input type="text" class="form-control input-lg" path="email" placeholder="Email"/>
		                    <form:errors path="email" cssclass="error"></form:errors>
		                  </div>
		                  <div class="form-group">
		                    <form:input type="text" class="form-control input-lg" path="firstname" placeholder="First name"/>
		                    <form:errors path="firstname" cssclass="error"></form:errors>
		                    
		                  </div>
		        		  <div class="form-group">
		                    <form:input type="text" class="form-control input-lg" path="lastname" placeholder="Last name"/>
		                    <form:errors path="lastname" cssclass="error"></form:errors>
		                    
		                  </div>
		        		  
		                  <div class="form-group">
		                    <form:input type="password" class="form-control input-lg" path="password" placeholder="Password"/>
		                    <form:errors path="password" cssclass="error"></form:errors>
		                    
		                  </div>
		
		                  <div class="form-group">
		                    <form:input type="text" id="autocomplete" onFocus="geolocate()" class="form-control input-lg" path="location" placeholder="Please enter your City,Country"/>
		                    <form:errors path="location" cssclass="error"></form:errors>
		                    
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
								
								$('#btn_send_reset_email').click(function(e){
									 var btn = $(this)
									 btn.button('loading');
									$.ajax({
										  type: "POST",
										  url: ctx+"resetpassword/"+$('#ps_email').val()+"/",
										})
										  .done(function( msg ) {
										   btn.button('reset');
										   alert(msg);
									 });	
									e.preventDefault();
									
								});
								
							</script>
		                  <div class="form-group">
		                    <form:button class="btn btn-primary btn-lg btn-block" type="submit">Register</form:button>
		                    <c:if test="${not empty succ}">
 								<div class="alert alert-success" role="alert">${succ}</div>		 
 			    			</c:if>
		                    <c:if test="${not empty error}">
		                    	<div class="alert alert-danger" role="alert">${error}</div>
 			    			</c:if>		                                      
		     		 </form:form>
		
		  </div>
	</div>
		<div class="logincontainer container">
		  <div class="row">
		      
		     
		  </div>
		</div>

							</div><!--/tiles main-->
		</div></div></div>
		</section>
	
	</tiles:putAttribute>
</tiles:insertDefinition>