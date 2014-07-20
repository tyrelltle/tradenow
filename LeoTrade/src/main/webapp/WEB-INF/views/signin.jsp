<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <html> -->
<!-- 	<head> -->
<!-- 		<title>Sign In</title> -->
<!-- 	</head> -->
<!-- 	<body> -->
<%-- 		<form action="<c:url value="/signin/facebook" />" method="POST"> --%>
<!-- 		    <button type="submit">Sign in with Facebook</button> -->
<!-- 		    <input type="hidden" name="scope" value="email,publish_stream,offline_access" />		     -->
<!-- 		</form> -->
<!-- 	</body> -->
<!-- </html> -->



<!-- saved from url=(0037)http://www.bootply.com/render/100702# -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><style type="text/css">.gm-style .gm-style-mtc label,.gm-style .gm-style-mtc div{font-weight:400}</style><style type="text/css">.gm-style .gm-style-cc span,.gm-style .gm-style-cc a,.gm-style .gm-style-mtc div{font-size:10px}</style><style type="text/css">@media print {  .gm-style .gmnoprint, .gmnoprint {    display:none  }}@media screen {  .gm-style .gmnoscreen, .gmnoscreen {    display:none  }}</style><style type="text/css">.gm-style .gm-style-iw{font-weight:300;font-size:13px}.gm-style .gm-iw{color:#2c2c2c}.gm-style .gm-iw b{font-weight:400}.gm-style .gm-iw a:link,.gm-style .gm-iw a:visited{color:#4272db;text-decoration:none}.gm-style .gm-iw a:hover{color:#4272db;text-decoration:underline}.gm-style .gm-iw .gm-title{font-weight:400;margin-bottom:1px}.gm-style .gm-iw .gm-basicinfo{line-height:18px;padding-bottom:12px}.gm-style .gm-iw .gm-website{padding-top:6px}.gm-style .gm-iw .gm-photos{padding-bottom:8px;-ms-user-select:none;-moz-user-select:none;-webkit-user-select:none}.gm-style .gm-iw .gm-sv,.gm-style .gm-iw .gm-ph{cursor:pointer;height:50px;width:100px;position:relative;overflow:hidden}.gm-style .gm-iw .gm-sv{padding-right:4px}.gm-style .gm-iw .gm-wsv{cursor:pointer;position:relative;overflow:hidden}.gm-style .gm-iw .gm-sv-label,.gm-style .gm-iw .gm-ph-label{cursor:pointer;position:absolute;bottom:6px;color:#fff;font-weight:400;text-shadow:rgba(0,0,0,0.7) 0 1px 4px;font-size:12px}.gm-style .gm-iw .gm-stars-b,.gm-style .gm-iw .gm-stars-f{height:13px;font-size:0}.gm-style .gm-iw .gm-stars-b{position:relative;background-position:0 0;width:65px;top:3px;margin:0 5px}.gm-style .gm-iw .gm-rev{line-height:20px;-ms-user-select:none;-moz-user-select:none;-webkit-user-select:none}.gm-style .gm-iw .gm-numeric-rev{font-size:16px;color:#dd4b39;font-weight:400}.gm-style .gm-iw.gm-transit{margin-left:15px}.gm-style .gm-iw.gm-transit td{vertical-align:top}.gm-style .gm-iw.gm-transit .gm-time{white-space:nowrap;color:#676767;font-weight:bold}.gm-style .gm-iw.gm-transit img{width:15px;height:15px;margin:1px 5px 0 -20px;float:left}.gm-iw.gm-sm {margin-right:-20px;}.gm-iw {text-align:left;}.gm-iw .gm-title {padding-right:20px;}.gm-iw .gm-numeric-rev {float:left;}.gm-iw .gm-photos,.gm-iw .gm-rev {direction:ltr;}.gm-iw .gm-stars-f, .gm-iw .gm-stars-b {background:url("http://maps.gstatic.com/mapfiles/api-3/images/review_stars.png") no-repeat;background-size: 65px 26px;float:left;}.gm-iw .gm-stars-f {background-position:left -13px;}.gm-iw .gm-sv-label,.gm-iw .gm-ph-label {left: 4px;}</style><link type="text/css" rel="stylesheet" href="resources/themes/frontpage/css"><style type="text/css">.gm-style{font-family:Roboto,Arial,sans-serif;font-size:11px;font-weight:400;text-decoration:none}</style>
         
        <meta charset="utf-8">
        <title>Barter Barter!</title>
        <title>undefined</title>
        <meta name="generator" content="Bootply">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet">
        
        <!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <link rel="shortcut icon" href="http://www.bootply.com/bootstrap/img/favicon.ico">
        <link rel="apple-touch-icon" href="http://www.bootply.com/bootstrap/img/apple-touch-icon.png">
        <link rel="apple-touch-icon" sizes="72x72" href="http://www.bootply.com/bootstrap/img/apple-touch-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="114x114" href="http://www.bootply.com/bootstrap/img/apple-touch-icon-114x114.png">










        <!-- CSS code from Bootply.com editor -->
        
        <style type="text/css">
            @import url(http://fonts.googleapis.com/css?family=Kreon:400,700);

html,
body {
  height: 100%;
  /* The html and body elements cannot have any padding or margin. */
  -webkit-font-smoothing: antialiased;
  font: normal 14px arial,sans-serif;
}

.row {
  margin-left:0px;
  margin-right:0px;
}

/* Wrapper for page content to push down footer */
#wrap {
  min-height: 100%;
  height: auto !important;
  height: 100%;
  /* Negative indent footer by its height */
  margin: 0 auto -60px;
  /* Pad bottom by footer height */
  padding: 0 0 60px;
}

/* Set the fixed height of the footer here */
#footer {
  height: 60px;
  margin-top:50px;
  padding-top:20px;
  padding-bottom:20px;
}


/* Custom page CSS
-------------------------------------------------- */

#wrap > .container {
  padding: 60px 15px 0;
}
.container .credit {
  margin: 20px 0;
}

#footer {
  background-color:#414141;
}

#footer a {
  color:#efefef;
}

h1,h2,h3,h4 {
  font-family: 'Kreon', serif;
  vertical-align:middle;
}

header {
  background: #5F40C0;
  height:550px;
  color:#000000;
}

header h1,header h2,header h3 a,header a,header a:hover {
  color:#101010;
  font-weight:800;
  text-decoration:none;
}

header h3 {
  font-family: 'Kreon', serif;
  background: #ffcc33;
  padding:10px;
  border-radius:3px;
  font-size:34px;
  padding:12px 10px 6px 10px;
}

header .dropdown-menu {
  top:74px;
  background: #ffcc33;
  border-width:0;
}

h1 {
  font-size:50px;
}

#nav {
  width: 100%;
  position:static;
  top:-32px;
}

#nav.affix {
   position: fixed;
   top: 0;
   z-index:10;
   -webkit-transition: all .6s ease-in-out;
}

#footer > .container {
  
}

@media (min-width: 767px) {
  .navbar-nav.nav-justified > li{
      float:none;
  }
}
.navbar-nav {
  margin: 1px 1px; 
}  
  
/* customize nav style */
.navbar-custom {
    background-color: #2e2e2e;
	font-weight:700;
    text-transform:uppercase;
    border-width:0;
}
.navbar-custom  .navbar-nav>li>a {
	color: #ddd;
}
.navbar-custom  .navbar-nav li>a:hover, .navbar-nav li .open, .navbar-custom .navbar-nav .active a  {
	background-color: #000;
}
.navbar-custom .dropdown-menu{
	right:0;
}
.navbar-custom .navbar-nav>.dropdown>a .caret {
	border-top-color: #999;
	border-bottom-color: #999;
}

.navbar-collapse.in { /*3.0.2 bug workaround*/
    overflow-y: visible;
}

.navbar-toggle {
	outline:0;
}

.divider {
	height:100px;
}

.panel {
	border-width:0;
}

@media (max-width: 768px) {
	header {
		height: 95px;
	}
}

#map-canvas {
  	width: 100%; 
  	height: 300px;
	margin: 0;
	padding: 15px;
}

.scroll-top {
   position:fixed;
   bottom:0;
   right:6%;
   z-index:100;
   background: #ffcc33;
   font-size:24px;
   border-top-left-radius:3px;
   border-top-right-radius:3px;
}
.scroll-top a:link,.scroll-top a:visited {
  color:#222;
} 
 

section {
  color: #ffffff;
  min-height: 400px;
  height: auto !important;
  height: 100%;
  padding-top:100px;
}

.bg-1 {
	background: url('http://www.bootply.com/assets/example/bg_4.jpg') no-repeat center center fixed; 
    -webkit-background-size: cover;
  	-moz-background-size: cover;
  	-o-background-size: cover;
  	background-size: cover;
}

.bg-2 {
	background: url('http://www.bootply.com/assets/example/bg_5.jpg') no-repeat center center fixed; 
    -webkit-background-size: cover;
  	-moz-background-size: cover;
  	-o-background-size: cover;
  	background-size: cover;
}

.bg-3 {
	background: url('http://www.bootply.com/assets/example/bg_6.jpg') no-repeat center center fixed; 
    -webkit-background-size: cover;
  	-moz-background-size: cover;
  	-o-background-size: cover;
  	background-size: cover;
}

.bg-4 {
	padding-top:30px;
	background-image: -webkit-gradient(linear, left top, left bottom, from(rgba(20,20,20,0.2)),to(rgba(255,255,255,0)), color-stop(1,#000));
}

        </style>
    <script style="">window["_GOOG_TRANS_EXT_VER"] = "1";</script><script type="text/javascript" charset="UTF-8" src="resources/themes/frontpage/{common,map}.js"></script><script type="text/javascript" charset="UTF-8" src="resources/themes/frontpage/{util,onion,infowindow}.js"></script><script type="text/javascript" charset="UTF-8" src="resources/themes/frontpage/{controls,stats}.js"></script><script type="text/javascript" charset="UTF-8" src="resources/themes/frontpage/{marker}.js"></script><script>window["_GOOG_TRANS_EXT_VER"] = "1";</script><script>window["_GOOG_TRANS_EXT_VER"] = "1";</script><script>window["_GOOG_TRANS_EXT_VER"] = "1";</script><script>window["_GOOG_TRANS_EXT_VER"] = "1";</script></head>
    
    <!-- HTML code from Bootply.com editor -->
    
    <body>
        
        <!-- Wrap all page content here -->
<div id="wrap">
  
<header class="masthead">
    <div class="container">
    <div class="row">
      <div class="col-sm-6">
        <h1><a  title="VanTrade">Barter Barter!</a>
          <p class="lead">"Swap with people arround world! "</p></h1>
      </div>
      <div class="col-sm-6">
        <div class="pull-right  hidden-xs">    
			<h>
			<form action="<c:url value="/auth/facebook" />" method="POST">
		    	 <button type="submit">Sign in with Facebook</button>
		   		 <input type="hidden" name="scope" value="email,publish_stream,offline_access" />	
		   		 	    
			</form>
			<form action="<c:url value="/nativelogon" />" method="GET">
		    	 <button type="submit">Regular signon</button>		   		 	    
			</form>
			</h>          
        </div>
      </div>
    </div>
    </div>
</header>
  
  
<!-- Fixed navbar -->
<div class="navbar navbar-custom navbar-inverse navbar-static-top affix" id="nav">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav nav-justified">
          <li><a href="#section1">Introduction</a></li>
          <li class=""><a href="#section2">Example</a></li>
          <li class=""><a href="#section4">Contact</a></li>
        </ul>
      </div><!--/.nav-collapse -->
    </div><!--/.container -->
</div><!--/.navbar -->
  
<!-- Begin page content -->
<div class="divider" id="section1"></div>
  
<div class="container">
  <div class="col-sm-10 col-sm-offset-1">
    <div class="page-header text-center">
      <h1>Let us introduce our best bartering app!</h1>
    </div>
    
    <p class="lead text-center">
      Barter Barter! is an online barter system. Simply post your stuff here, find other people's insteresting stuff and exchange with them!
    </p>
    
  </div>
</div>
    
<div class="divider" id="section2"></div>
  
<section class="bg-1">
  <div class="col-sm-6 col-sm-offset-3 text-center"><h2 style="padding:20px;background-color:rgba(5,5,5,.8)">Have a look at following example!</h2></div>
</section>
  
<div class="divider"></div>
   
<div class="container" id="section3">
  	<div class="col-sm-8 col-sm-offset-2 text-center">
      <h1>Step One - Browse on public marketplace, and find out what you want to own </h1>
      
      <p>
		  People has their own public backlog of stuffs that they want to throw away, and other people can view them
      </p>
      
  	</div><!--/col-->
	<div class="row">
	  <div class="col-md-4"><img src="resources/themes/frontpage/xbox.jpg" class="img-responsive"></div>
	  <div class="col-md-4">.<img src="resources/themes/frontpage/shoe.jpg" class="img-responsive"></div>
	   <div class="col-md-4">.<img src="resources/themes/frontpage/close.jpg" class="img-responsive"></div>
	</div>
	<div class="row">
	  <div class="col-md-3 col-md-offset-1"><img src="resources/themes/frontpage/lv.jpg" class="img-responsive"></div>
	  <div class="col-md-4"><img src="resources/themes/frontpage/computer.jpg" class="img-responsive"></div>
	  <div class="col-md-3"><img src="resources/themes/frontpage/ps4.jpg" class="img-responsive"></div>
	</div>

 <hr><hr><hr> <hr><hr><hr>
  	 <div class="col-sm-8 col-sm-offset-2 text-center">
      <h1>Step Two - Find what you can offer, and negotiate with others</h1>
      
      <p>
		  Looks like you have choose to own that Xbox One! Now you can choose one of your belongings from your own backlog, and negotiate with the Xbox owner within our site
      </p>    
  	</div><!--/col-->
	 <div class="row">
	  <div class="col-lg-10 col-md-offset-2"><img src="resources/themes/frontpage/letstrade.jpg" class="img-responsive"></div>
	</div>
	
 <hr><hr><hr> <hr><hr><hr>
  	 <div class="col-sm-8 col-sm-offset-2 text-center">
      <h1>Step Three - Negotiation about the delivery method on site</h1>
      
      <p>
		 Ok! Now you have had the deal to trade Xbox One with your cool TV. Next, you can choose either delivery in-person or use commertial delivery/mailing services.
		</p>
		<p> 
		 Our system will keep track of every trade history and their user-defined delivery methods. Therefore don't worry if you feel been spamed. We have your back covered. 	 
      </p>    
  	</div><!--/col-->
	 <div class="row">
	  <div class="col-lg-10 col-md-offset-2"><img src="resources/themes/frontpage/mailtype.jpg" class="img-responsive"></div>
	</div>	
	
</div><!--/container-->

<div class="divider"></div>
  
<section class="bg-3" id="section4">
  <div class="col-sm-6 col-sm-offset-3 text-center"><h2 style="padding:20px;background-color:rgba(5,5,5,.8)">Contacts</h2></div>
</section>
  

<div class="divider" id="section5"></div>

<div class="row">

 </div>
  
  <hr>
  
  <div class="col-sm-8">
      
      <div class="row form-group">
        <div class="col-xs-3">
          <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" required="">
        </div>
        <div class="col-xs-3">
          <input type="text" class="form-control" id="middleName" name="firstName" placeholder="Middle Name" required="">
        </div>
        <div class="col-xs-4">
          <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" required="">
        </div>
      </div>
      <div class="row form-group">
          <div class="col-xs-5">
          <input type="email" class="form-control" name="email" placeholder="Email" required="">
          </div>
          <div class="col-xs-5">
          <input type="email" class="form-control" name="phone" placeholder="Phone" required="">
          </div>
      </div>
      <div class="row form-group">
          <div class="col-xs-10">
          <input type="homepage" class="form-control" placeholder="Website URL" required="">
          </div>
      </div>
      <div class="row form-group">
          <div class="col-xs-10">
            <button class="btn btn-default pull-right">Contact Us</button>
          </div>
      </div>
    
  </div>
  <div class="col-sm-3 pull-right">

      <address>
        <strong>Barter Barter! .LLC</strong><br>
        12345 Tyler st, Leo<br>
        P: (123) 456-7890
      </address>
    
      <address>
        <strong>Email Us</strong><br>
        <a href="mailto:#">first.last@example.com</a>
      </address>          
  </div>
  
</div><!--/row-->

<div class="container">
  	<div class="col-sm-8 col-sm-offset-2 text-center">
      <h2>Barter Barter!</h2>
      
      <hr>
      <h4>
        We love Trading!. We love Barter Barter!.
      </h4>
     
      <hr>
      <ul class="list-inline center-block">
        <li><a href="http://facebook.com"><img src="resources/themes/frontpage/soc_fb.png"></a></li>
        <li><a href="http://twitter.com/"><img src="resources/themes/frontpage/soc_tw.png"></a></li>
        <li><a href="http://google.com/"><img src="resources/themes/frontpage/soc_gplus.png"></a></li>
      </ul>
      
  	</div><!--/col-->
</div><!--/container-->
  
</div><!--/wrap-->

<div id="footer">
  <div class="container">
  
  </div>
</div>

<ul class="nav pull-right scroll-top">
  <li><a href="resources/themes/frontpage/Bootply.com - Bootstrap Bold, Bright Bootstrap Template.html" title="Scroll to top"><i class="glyphicon glyphicon-chevron-up"></i></a></li>
</ul>

        
        <script src="resources/themes/frontpage/quant.js" async="" type="text/javascript"></script><script async="" src="resources/themes/frontpage/analytics.js"></script><script type="text/javascript" src="resources/themes/frontpage/jquery.min.js"></script>


        <script type="text/javascript" src="resources/themes/frontpage/bootstrap.min.js"></script>


<script type="text/javascript" src="resources/themes/frontpage/js"></script><script src="resources/themes/frontpage/main.js" type="text/javascript"></script>



        
        <!-- JavaScript jQuery code from Bootply.com editor  -->
        
        <script type="text/javascript">
        
        $(document).ready(function() {
        
            /* affix the navbar after scroll below header */
$('#nav').affix({
      offset: {
        top: $('header').height()-$('#nav').height()
      }
});	

/* highlight the top nav as scrolling occurs */
$('body').scrollspy({ target: '#nav' })

/* smooth scrolling for scroll to top */
$('.scroll-top').click(function(){
  $('body,html').animate({scrollTop:0},1000);
})

/* smooth scrolling for nav sections */
$('#nav .navbar-nav li>a').click(function(){
  var link = $(this).attr('href');
  var posi = $(link).offset().top+20;
  $('body,html').animate({scrollTop:posi},700);
})

/* google maps */

// enable the visual refresh
google.maps.visualRefresh = true;

var map;
function initialize() {
  var mapOptions = {
    zoom: 15,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };
  map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);
  	// try HTML5 geolocation
  if(navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function(position) {
      var pos = new google.maps.LatLng(position.coords.latitude,
                                       position.coords.longitude);

      var infowindow = new google.maps.InfoWindow({
        map: map,
        position: pos,
        content: 'Location found using HTML5.'
      });

      map.setCenter(pos);
    }, function() {
      handleNoGeolocation(true);
    });
  } else {
    // browser doesn't support geolocation
    handleNoGeolocation(false);
  }
}

function handleNoGeolocation(errorFlag) {
  if (errorFlag) {
    var content = 'Error: The Geolocation service failed.';
  } else {
    var content = 'Error: Your browser doesn\'t support geolocation.';
  }

  var options = {
    map: map,
    position: new google.maps.LatLng(60, 105),
    content: content
  };

  var infowindow = new google.maps.InfoWindow(options);
  map.setCenter(options.position);
}
google.maps.event.addDomListener(window, 'load', initialize);


        
        });
        
        </script>
        
        <script>
          (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
          (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
          m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
          })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
          ga('create', 'UA-40413119-1', 'bootply.com');
          ga('send', 'pageview');
        </script>
        <!-- Quantcast Tag -->
        <script type="text/javascript">
        var _qevents = _qevents || [];
        
        (function() {
        var elem = document.createElement('script');
        elem.src = (document.location.protocol == "https:" ? "https://secure" : "http://edge") + ".quantserve.com/quant.js";
        elem.async = true;
        elem.type = "text/javascript";
        var scpt = document.getElementsByTagName('script')[0];
        scpt.parentNode.insertBefore(elem, scpt);
        })();
        
        _qevents.push({
        qacct:"p-0cXb7ATGU9nz5"
        });
        </script>
    
</body></html>
