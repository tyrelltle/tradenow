<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html class="no-js" lang="en-US">

<!--
	HTML with Open Graph attributes
	<html class="no-js" lang="en-US" xmlns="http://www.w3.org/1999/xhtml" xmlns:og="http://ogp.me/ns#" xmlns:fb="https://www.facebook.com/2008/fbml">
-->

<head> 

	<meta charset="UTF-8">
	<title>All in one</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.png">

	<!-- Add some of The Open Graph protocol -->
		<!-- Open Graph meta tags -->
	<!--
	<meta content="Blog" property="og:title">
	<meta content="website" property="og:type">
	<meta content="http://des111gn.com/all-in-1/blog-3.html" property="og:url">
	<meta content="" property="og:image">
	<meta content="All in one" property="og:site_name">
	<meta content="There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable [...]" property="og:description">
	-->

	<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
	<![endif]-->

	<!-- Main CSS Style -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" />

	<!-- Main CSS Style (in less) delete in real project-->
	<link rel="stylesheet/less" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.less">
	<!-- Less -->
	<script src="${pageContext.request.contextPath}/resources/js/less.js" type="text/javascript"></script>

	<!-- Bootstrap Grid Framework -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />

	<!-- Google Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Oswald:300,400' rel='stylesheet' type='${pageContext.request.contextPath}/resources/text/css'>
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='${pageContext.request.contextPath}/resources/text/css'>
	
	<!-- Font Awesome -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.css">

	<!-- Dropdown menu -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/slicknav.css">

    <!-- Owl Carousel Assets -->
    <link href="${pageContext.request.contextPath}/resources/css/owl.carousel.css" rel="stylesheet">
	<!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/settings.css" media="screen" />
    <!-- Animate css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/animate.css">
	
	<!-- Scripts that is required -->
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/spin.min.js"></script>
	<script>var ctx = "${pageContext.request.contextPath}/"</script>
	<script src="${pageContext.request.contextPath}/resources/js/underscore.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/backbone.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/application/notification.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/application/iwait.js"></script>
	<!--Preaty Photo-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/prettyPhoto.css" type="text/css"/>
	
	<tiles:insertAttribute name="header" />

</head>

<body>
	

	<div id="wrap">


		<!-- Top bar -->
			<!-- Top bar -->
		<header>
			<!-- Dropdown menu -->
			<nav>
				
				<div class="header">
					<div class="container">
						<div class="row">


							<div class="col-md-5 col-sm-5 col-xs-5">
								<!-- Your logo -->
								<div class="logo">
									<a href="${pageContext.request.contextPath}/home">
<%-- 										<img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="All in 1"> --%>
										<h1>Barbarian</h1>
									</a>
								</div>
								<!-- and Your logo -->
							</div>
							
							<div class="col-md-7 col-sm-7 col-xs-7">
									<div class="menu-container">
									
									<!-- Menu nav bar -->
									<ul id="menu">

									    <li>
							
											<form action="<c:url value="/auth/facebook" />" method="POST">
														<input type="hidden" name="scope" value="email,user_location" />
														<a style="font-size:12px" class="c-pointer social social-facebook" onclick="$(this).closest('form').submit()">
															<i class="fa fa-facebook"></i>
														Sing in with Facebook</a> 
											</form>
											
									    </li>
									    
									    <li>
									    <form action="<c:url value="/nativelogon" />" method="GET">
														<a style="font-size:12px" class="c-pointer social social-tradenow" onclick="$(this).closest('form').submit()">
															<i class="fa fa fa-sign-in"></i>
																Normal Signin</a>

										</form>
									    
									    
									    </li>
									    
  
									</ul>
									<!-- and Menu nav bar -->
									</div>
							
						</div> <!-- and row -->
					</div> <!-- and container -->
				</div> <!-- and header -->

			</nav> <!-- and Dropdown menu -->
			
		</header> <!-- and header -->



		

		<!-- main -->
		<section>

								<tiles:insertAttribute name="left" />
		
							   <tiles:insertAttribute name="main" />

		<!-- and main -->



		<!-- Bottom bar -->
		<section>
			
			<div class="bottom-bar">
				<div class="container">
					<div class="row">
	
						<div class="col-md-6 col-sm-6 col-xs-12 col-xs-small copyright">
							<p>&#169; All Rights Reserved by <a href="#">Trade-Now.ca</a></p>
						</div>						
					</div> <!-- and row -->
				</div> <!-- and container -->
			</div> <!-- and bottom-bar -->

		</section> <!-- and Bottom bar -->

		<a href="#" class="back-to-top"></a>

	</div> <!-- and wrap -->
	

	
  	<!-- Modernizr -->
	<script src="${pageContext.request.contextPath}/resources/js/modernizr.js"></script>



	<!-- Owl carousel -->
    <script src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>

	<!-- Bootstrap Plagins -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

	<!-- Dropdown menu if screen < 650px -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.slicknav.min.js"></script>
	
	<!-- Fixed Dropdown menu if scroll -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery-scrolltofixed-min.js" type="text/javascript"></script>

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.2.min.js"></script>

	<!-- Animation offset -->
	<script src="${pageContext.request.contextPath}/resources/js/wow.js"></script>

	<!-- Layout Style -->
	<script src="${pageContext.request.contextPath}/resources/js/layout.js"></script>
	

	<!-- Other scripts -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>
  	<!-- SLIDER REVOLUTION 4.x SCRIPTS  -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.themepunch.plugins.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.themepunch.revolution.min.js"></script>

	
    <!-- REVOLUTION SLIDER -->
	<script type="text/javascript">
		var revapi;
		jQuery(document).ready(function() {
			   revapi = jQuery('.tp-banner').revolution(
				{
					delay:9999,
					startwidth:1350,
					startheight:588,
					hideThumbs:10,
					fullWidth:"on",
				});

		});	//ready
	</script>
	<!-- END REVOLUTION SLIDER -->

</body>
</html>