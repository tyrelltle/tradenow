<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="resources/themes/bootstrap-3.1.1/css/bootstrap.min.css" rel="stylesheet">  

<style>
/* CSS used here will be applied after bootstrap.css */

div {
//border: green;
//border-style: solid;
}
 
.prodpic{
width:300px !important;
  
}
.midblock{
height:280px;
margin-top:50px;
}

#msg_row{
margin-top:40px;
}
.midcontainer {
width:600px;
}

.message{
overflow-wrap: break-word;
margin-top:10px;
}

.sidepanel{
margin-top:50px;
}



</style>

</head>
<body>
<div class="container">
    <div id="block" class="panel col-md-12">
        <div id="userpanel" class="sidepanel col-md-2">
             <ul class="list-group">
              <li class="list-group-item"><img alt="pic" class="img-thumbnail prodpic" src="http://img.vip.xunlei.com/img/banner/201307291420313509.jpg"></li>
              <li class="list-group-item"><button type="button" class="btn btn-default">Choose Item</button></li>
              <li class="list-group-item">
                Delivery Method
                  <select class="form-control">
                    <option>In Person</option>
                    <option>Mail</option>
                  </select> 
               
              </li>
              
              <li class="list-group-item"><button type="button" class="btn btn-success">Success</button></li>
            </ul>
      	</div>
        <div class="midblock col-md-7">
            <div class="midcontainer container">
                <div id="two_prod_row" class="row">
                    <div id="prod_left" class="col-md-5">
                        <img alt="pic" class="img-thumbnail prodpic" src="http://img.vip.xunlei.com/img/banner/201307291420313509.jpg">
                    </div>
                    <div class="col-md-2" style="margin-top:40px">
                        <button type="button" class="btn btn-default btn-lg"> <span class="glyphicon glyphicon-transfer"></span> 
                        </button>
                    </div>
                    <div id="prod_right" class="col-md-5">
                        <img alt="pic" class="img-thumbnail prodpic" src="http://img.vip.xunlei.com/img/banner/201307291420313509.jpg">
                    </div>
                </div>
                <div id="msg_row" class="row">
                  <div class="panel panel-default">
                    <div class="panel-heading">
                      <h3 class="panel-title">Messages</h3>
                    </div>
                    <div class="panel-body">
                    
                  
                          <div class="midcontainer container">
                                <div id="newmsg_row" class="row">
                                    <div class="col-md-10">
                                      <textarea class="form-control" rows="3"></textarea> 
                                        
                                    </div>
                                    <div class="col-md-1">                              	
                                        <button type="button" class="btn btn-primary">Send</button>
                                    </div>
                                </div>
                                <div id="msglis_row" class="row">
                                    <div class="midcontainer container">
                                        <!--bunch of msg rows -->
                                        <div class="message row">
                                            <div class="col-md-2">
                                              <img alt="pic" class="img-thumbnail prodpic" src="http://img.vip.xunlei.com/img/banner/201307291420313509.jpg">
                                            </div>
                                            <div class="message_body col-md-7 well well-sm">helloworld</div>
                                        </div>
                                        <div class="message row">
                                            
                                            <div class="message_body col-md-offset-2 col-md-7 well well-sm">helloworldddddddddddddddddddddddddddddddddddddddd</div>
                                            <div class="col-md-2">
                                              <img alt="pic" class="img-thumbnail prodpic" src="http://img.vip.xunlei.com/img/banner/201307291420313509.jpg">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                          </div>
                     </div>
                   </div>
                </div>
            </div>
        </div>
    	<div id="userpanel" class="sidepanel upblock col-md-2">
      		<ul class="list-group">
              <li class="list-group-item"><img alt="pic" class="img-thumbnail prodpic" src="http://img.vip.xunlei.com/img/banner/201307291420313509.jpg"></li>
              <li class="list-group-item"><button type="button" class="btn btn-default">Choose Item</button></li>
              <li class="list-group-item">
                Delivery Method
                  <select class="form-control">
                    <option>In Person</option>
                    <option>Mail</option>
                  </select> 
               
              </li>
              
              <li class="list-group-item"><button type="button" class="btn btn-success">Success</button></li>
            </ul>
      
      
        </div>
    </div>
</div>
</body>
</html>