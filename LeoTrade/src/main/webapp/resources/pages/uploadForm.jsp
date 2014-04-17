<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<html>  
<head>  
<script type="text/javascript" src="../scripts/jquery-1.10.2.js"></script>  
<title>Being Java Guys | Hello World</title>  
</head>  
<body>  
  

    
  
  <form:form method="post" enctype="multipart/form-data"  
   modelAttribute="uploadedFile" action="fileUpload.htm">  
 
     <td><input type="file" id="img" name="file" />     
     <td><input type="submit" value="Upload" />   
  </form:form>  
 </center>  
</body>  
</html>  