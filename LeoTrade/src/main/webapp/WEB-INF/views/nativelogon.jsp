<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logon</title>
<link href="${pageContext.request.contextPath}/resources/themes/bootstrap-3.1.1/css/bootstrap.min.css" rel="stylesheet">  

<style>
.logincontainer{
 margin-top:100px; 
  
}

</style>

</head>
<body>
<div class="logincontainer container">
  <div class="row">
      <form:form class="form col-md-6 center-block" method="POST" commandName="signinForm" action="nativesignin" >
                  <div class="form-group">
                    <form:input type="text" class="form-control input-lg" path="email" placeholder="Email"/>
                  </div>
                  <div class="form-group">
                    <form:input type="password" class="form-control input-lg" path="password" placeholder="Password"/>
                  </div>
                  <div class="form-group">
                    <form:button class="btn btn-primary btn-lg btn-block" type="submit">Sign In</form:button>
                   <span><a href="#">${errorlogin}</a></span>
                  </div>
      </form:form>
      <form:form class="form col-md-6 center-block"  method="POST" commandName="userForm" action="nativeregister">
				 
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
                    <form:button class="btn btn-primary btn-lg btn-block" type="submit">Register</form:button>
                    <span class="pull-right">${error}</span>
                  </div>
      </form:form>

  </div>
</div>



</body>
</html>