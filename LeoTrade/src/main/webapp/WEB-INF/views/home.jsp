<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!-- <html> -->
<!-- 	<head> -->
<!-- 		<title>Home</title> -->
<!-- 	</head> -->
<!-- 	<body> -->


<tiles:insertDefinition name="template">
    <tiles:putAttribute name="main">
	<ul>
		<li><a href="<c:url value="/signout" />">Sign Out</a></li>
	</ul>
	<h3>Your Facebook Friends</h3>
	<ul>
	<c:forEach items="${friends}" var="friend">
		<li><img src="http://graph.facebook.com/<c:out value="${friend.id}"/>/picture" align="middle"/><c:out value="${friend.name}"/></li>
	</c:forEach>
	</ul>	
	</tiles:putAttribute>
</tiles:insertDefinition>
<!-- 	</body> -->
<!-- </html> -->