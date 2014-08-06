<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"> 
        <title>Bootply.com - Bootstrap Google Plus Theme</title>
        <meta name="generator" content="Bootply" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!--         <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet"> -->

		<link href="${pageContext.request.contextPath}/resources/themes/bootstrap-3.1.1/css/bootstrap.min.css" rel="stylesheet">    
		
		<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery-1.10.2.js"></script>
					 	   	<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/themes/bootstrap-3.1.1/js/bootstrap.js" rel="stylesheet"> </script>
		<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/scripts/spin.min.js"></script>		       
		<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/scripts/underscore.js"></script>
		<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/scripts/backbone.js"></script>
	
		
		
        <script>var ctx = "${pageContext.request.contextPath}/"</script>
        
        <!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

		<tiles:insertAttribute name="header" />

        <!-- CSS code from Bootply.com editor -->
        
        <style type="text/css">
            /* custom google plus style theme */
			@import url(http://fonts.googleapis.com/css?family=Roboto:400);
			body {
			  background-color:#ffffff;
			  -webkit-font-smoothing: antialiased;
			  font: normal 14px Roboto,arial,sans-serif;
			}
			.navbar-default {background-color:#f4f4f4;margin-top:50px;border-width:0;z-index:5;}
			.navbar-default .navbar-nav > .active > a,.navbar-default .navbar-nav > li:hover > a {border:0 solid #4285f4;border-bottom-width:2px;font-weight:800;background-color:transparent;}
			.navbar-default .dropdown-menu {background-color:#ffffff;}
			.navbar-default .dropdown-menu li > a {padding-left:30px;}
			.header_glyph {color:white;}
			.header {background-color:#2a6496;border-width:0;}
			.header .navbar-collapse {background-color:#2a6496;}
			.btn,.form-control,.panel,.list-group,.well {border-radius:1px;box-shadow:0 0 0;}
			.form-control {border-color:#d7d7d7;}
			.btn-primary {border-color:transparent;}
			.btn-primary,.label-primary,.list-group-item.active, .list-group-item.active:hover, .list-group-item.active:focus {background-color:#4285f4;}
			.btn-plus {background-color:#ffffff;border-width:1px;border-color:#dddddd;box-shadow:1px 1px 0 #999999;border-radius:3px;color:#666666;text-shadow:0 0 1px #bbbbbb;}
			.well,.panel {border-color:#d2d2d2;box-shadow:0 1px 0 #cfcfcf;border-radius:3px;}
			.btn-success,.label-success,.progress-bar-success{background-color:#65b045;}
			.btn-info,.label-info,.progress-bar-info{background-color:#a0c3ff,border-color:#a0c3ff;}
			.btn-danger,.label-danger,.progress-bar-danger{background-color:#dd4b39;}
			.btn-warning,.label-warning,.progress-bar-warning{background-color:#f4b400;color:#444444;}

			.modalheader{
				
				background-color: #428bca;
			color: white;
			}
			.tooltip {z-index: 2000 !important;}
			hr {border-color:#ececec;}
			button {
				outline: 0;
			}
			textarea {
			  resize: none;
			  outline: 0;
			  
			}
			.panel .btn i,.btn span{
			  color:#666666;
			}
			.panel .panel-heading {
			  background-color:#ffffff;
			  font-weight:700;
			  font-size:16px;
			  color:#262626;
			  border-color:#ffffff;
			}
			.panel .panel-heading a {
			  font-weight:400;
			  font-size:11px;
			}
			.panel .panel-default {
			  border-color:#cccccc;
			}
			.panel .panel-thumbnail {
			  padding:0;
			}
			.panel .img-circle {
			  width:50px;
			  height:50px;
			}
			.list-group-item:first-child,.list-group-item:last-child {
				border-radius:0;
			}
			h3,h4,h5 { 
			  border:0 solid #efefef; 
			  border-bottom-width:1px;
			  padding-bottom:10px;
			}
			
			/* .modal-dialog { */
			/*  width: 450px; */
			/* } */
			
			.modal-footer {
			 border-width:0;
			}
			
			.dropdown-menu {
			   background-color:#f4f4f4;
			   border-color:#f0f0f0;
			   border-radius:0;
			   margin-top:-1px;
			}
			/* end theme */
			
			/* template layout*/
			#subnav {
				position:fixed;
			    width:100%;
			}
			
			@media (max-width: 768px) {
				#subnav {
				padding-top: 6px;
				}
			}
			
			#main {
				padding-top:56px;
			}
			.notiflisitem{
				font-size:11px;
			}
        </style>
    </head>
    
    <!-- HTML code from Bootply.com editor -->
    
    <body>
    
        
        <div class="navbar navbar-fixed-top header">
 	<div class="col-md-12">
        <div class="navbar-header">
          
          <a href="${pageContext.request.contextPath}/home" class="header_glyph navbar-brand">Trade Now!</a>
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse1">
          <i class="glyphicon glyphicon-search"></i>
          </button>
      
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse1">
          <form class="navbar-form pull-left">
              <div class="input-group" style="max-width:470px;">
              
              <c:choose>
			      <c:when test="${not empty searchkey}">
			           <input type="text" class="searchtxt form-control" placeholder="Search By Item Titles" value="${searchkey}">   			
			      </c:when>
			      <c:otherwise>
			           <input type="text" class="searchtxt form-control" placeholder="Search By Item Titles">   			
			      </c:otherwise>
			  </c:choose>
              
              
                <div class="input-group-btn">
                  <button class="searchbtn btn btn-default btn-primary"><i class="glyphicon glyphicon-search"></i></button>
                </div>
              </div>
          </form>
          <ul class="nav navbar-nav navbar-right">
             <li><a href="${pageContext.request.contextPath}/home"><i class="header_glyph glyphicon glyphicon-home"></i></a></li>          
             <li class="linotiflis">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="notibell header_glyph glyphicon glyphicon-bell"></i></a>
                <ul class="notiflis dropdown-menu">

                </ul>
             </li>
             <li><a href="${pageContext.request.contextPath}/user"><i class="header_glyph glyphicon glyphicon-user"></i></a></li>
             <li><a href="${pageContext.request.contextPath}/signout"><i class="header_glyph glyphicon glyphicon-log-out"></i></a></li>
             
           </ul>
        </div>	
	     </div>	
	</div>
	
	<!--wait modal-->
	<div id="waitmodal" class="modal" tabindex="-1" data-backdrop="static" role="dialog" aria-hidden="true">
	  <div class="modal-dialog modal-sm">
	  <div class="modal-content">
	      <div class="modal-body">
				<div style="height:200px">
			      <span id="searching_spinner_center" style="position: absolute;display: block;top: 50%;left: 50%;"></span>
			    </div>
			</div>
	      </div>
	  </div>
	  </div>
	</div>
	<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/scripts/application/iwait.js"></script>

	<!--left -->
	<div id="leftpanel" style="float:left;margin-top:56px">
		<tiles:insertAttribute name="left" />
	</div>
	<!--main-->
	<div class="container" id="main">
	   <tiles:insertAttribute name="main" />
	</div><!--/main-->



	<!--login modal-->
	<div id="loginModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
	  <div class="modal-dialog">
	  <div class="modal-content">
	      <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	          <h2 class="text-center"><img src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100" class="img-circle"><br>Login</h2>
	      </div>
	      <div class="modal-body">
	          <form class="form col-md-12 center-block">
	            <div class="form-group">
	              <input type="text" class="form-control input-lg" placeholder="Email">
	            </div>
	            <div class="form-group">
	              <input type="password" class="form-control input-lg" placeholder="Password">
	            </div>
	            <div class="form-group">
	              <button class="btn btn-primary btn-lg btn-block">Sign In</button>
	              <span class="pull-right"><a href="#">Register</a></span><span><a href="#">Need help?</a></span>
	            </div>
	          </form>
	      </div>
	      <div class="modal-footer">
	          <div class="col-md-12">
	          <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
			  </div>	
	      </div>
	  </div>
	  </div>
	</div>

	
	<!--about modal-->
	<div id="aboutModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
	  <div class="modal-dialog">
	  <div class="modal-content">
	      <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	          <h2 class="text-center">About</h2>
	      </div>
	      <div class="modal-body">
	          <div class="col-md-12 text-center">
	            <a href="http://bootply.com/90113">This Bootstrap Template</a><br>was made with <i class="glyphicon glyphicon-heart"></i> by <a href="http://bootply.com/templates">Bootply</a>
	            <br><br>
	            <a href="https://github.com/iatek/bootstrap-google-plus">GitHub Fork</a>
	          </div>
	      </div>
	      <div class="modal-footer">
	          <button class="btn" data-dismiss="modal" aria-hidden="true">OK</button>
	      </div>
	  </div>
	  </div>
	</div>
        
    <script type='text/javascript' src="${pageContext.request.contextPath}/resources/scripts/jquery-1.10.2.js"></script>


    <script type='text/javascript' src="${pageContext.request.contextPath}/resources/themes/bootstrap-3.1.1/js/bootstrap.min.js"></script>	 

    <!--start bootstrap dependencies-->	
	<script type="text/javascript" id="tmp" src="${pageContext.request.contextPath}/resources/scripts/application/notification.js"></script>
	

	<!--end bootstrap dependencies-->   
    <!-- JavaScript jQuery code from Bootply.com editor -->
        <script type="text/javascript" id="tmp4" language="javascript" src="${pageContext.request.contextPath}/resources/themes/prettyphoto/js/jquery.prettyPhoto.js" rel="stylesheet"> </script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/prettyphoto/css/prettyPhoto.css" type="text/css" media="screen" charset="utf-8" />
	
    <script type='text/javascript'>
    
    if (window.location.hash && window.location.hash == '#_=_') {
        window.location.hash = '';
    }

    
    
    
    $(document).ready(function() {       		  
    	
    	
				/* toggle layout */
				$('#btnToggle').click(function(){
					if ($(this).hasClass('on')) {
				    	$('#main .col-md-6').addClass('col-md-4').removeClass('col-md-6');
				    	$(this).removeClass('on');
				    }
				  	else {
				    	$('#main .col-md-4').addClass('col-md-6').removeClass('col-md-4');
				      	$(this).addClass('on');
				  	}
				});
				$('.searchbtn').click(function(){
					window.location=ctx+"search"+$('.searchtxt').val();
					return false;
				});
					$('.dropdown-toggle').dropdown();
				
				var notiflis=new NotificationList();
				var notiflisview =new NotificationListView({model:notiflis});
				notiflis.fetch({
					success:function(lis){
						notiflisview.render();

					}
				});
	        
    });
       
    </script>
        
    </body>
</html>