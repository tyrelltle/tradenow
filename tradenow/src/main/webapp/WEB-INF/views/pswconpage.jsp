<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<tiles:insertDefinition name="logintemplate">
	<tiles:putAttribute name="header">

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

<div class="col-md-offset-3 col-md-6 col-md-offset-3">
		  <div class="center aligned column">
		  <h2>Change Your Password</h2>
		  	<c:choose>
			      <c:when test="${not empty succ}">
					<h3>Password reset successful! Please <a style="color:green;font-size:30px" href="${pageContext.request.contextPath}/nativelogon"><span>login</span></a> with your new password!</h3>
			      </c:when>
			
			      <c:otherwise>
		   				 <form:form  id="pswform"  method="POST" commandName="form" action="../pswcon/${uuid}">
						 
		        		  
		                  <div class="form-group">
		                    <form:input type="password" class="form-control input-lg" path="password" placeholder="New Password"/>
		                    <form:errors path="password" cssclass="error"></form:errors>
		                    
		                  </div>
		                  <div class="form-group">
		                    <form:input type="password_" class="form-control input-lg" path="password_" placeholder="Repeat New Password"/>
		                    <form:errors path="password_" cssclass="error"></form:errors>
		                    
		                  </div>		
		                 
		                  <div class="form-group">
		                    <form:button class="btn btn-primary btn-lg btn-block" type="submit">Submit</form:button>
		                    <c:if test="${not empty succ}">
 								<div class="alert alert-success" role="alert">${succ}</div>		 
 			    			</c:if>
		                    <c:if test="${not empty error}">
		                    	<div class="alert alert-danger" role="alert">${error}</div>
 			    			</c:if>		                                      
		     		 	</form:form>
			      </c:otherwise>
			</c:choose>
		  
		  
		
		
		
		  </div>
	</div>


	</div><!--/tiles main-->
		</div></div></div>
		</section>
	
	</tiles:putAttribute>
</tiles:insertDefinition>