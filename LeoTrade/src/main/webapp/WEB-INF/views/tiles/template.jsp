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


							<div class="col-md-2 col-sm-2 col-xs-2">
								<!-- Your logo -->
								<div class="logo"><a href="${pageContext.request.contextPath}/home"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="All in 1"></a></div>
								<!-- and Your logo -->
							</div>
							
							<div class="col-md-10 col-sm-10 col-xs-10">
								
								<div class="menu-container">
									
									<!-- Menu nav bar -->
									
									
									<ul id="menu">
									    <li>
									    	<a href="${pageContext.request.contextPath}/home">
									    		Home<i class="header_glyph glyphicon glyphicon-home"></i>
									    	</a>
									    </li>
									    <li class="linotiflis">
									    	<a href="#" >Notification<i class="notibell header_glyph glyphicon glyphicon-bell"></i></a>
										   	<ul class="notiflis sub-menu slideDown">
									            
									        </ul>
									    </li>
									    <li><a href="${pageContext.request.contextPath}/user">
									    			User Detail <i class="glyphicon glyphicon-user"></i>
									    	</a>
									    </li>
									    <li><a href="${pageContext.request.contextPath}/signout">
									    			User Detail <i class="glyphicon glyphicon-log-out"></i>
									    	</a>
									    </li>
									</ul>
									<!-- and Menu nav bar -->
								</div> <!-- and menu-container -->
							</div> <!-- and col-md-10 -->

						</div> <!-- and row -->
					</div> <!-- and container -->
				</div> <!-- and header -->

			</nav> <!-- and Dropdown menu -->
			
		</header> <!-- and header -->


	<div class="top-bar">
					<div class="container">
						<div class="row">
							<div class="col-lg-7 col-md-8 col-sm-7">
								<ul class="top-bar-nav list-inline pull-left">
									<li id="lang">
										<a href="#" class="lang-active"><i class="fa fa-globe"></i> By Categories <i class="fa fa-angle-down"></i></a>
										<ul class="lang" id="catlis" style="display: none;">
										
										</ul>
									</li>
									<li id="lang">
												
												<form class="sidebar-search-form-small">
												  <c:choose>
												      <c:when test="${not empty searchkey}">
												           <input type="text" class="searchtxt" placeholder="Search By Item Titles" value="${searchkey}">   			
												      </c:when>
												      <c:otherwise>
												           <input type="text" class="searchtxt" placeholder="Search By Item Titles">   			
												      </c:otherwise>
												  </c:choose>
														<a class="searchbtn"><i class="fa fa-search"></i></a>
												
													</form>
									</li>
									<li><a class="likesbtn" href="#"><i class="glyphicon glyphicon-heart"></i>Favorites</li></a>
	
								</ul>
							</div>
	
						</div> <!-- and row -->
					</div> <!-- and container -->
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
		<script src="${pageContext.request.contextPath}/resources/js/application/iwait.js"></script>
		

		<!-- main -->
		<section>
		<div class="blog">
				<div class="container">
					<div class="row">
							<!--tiles left -->
							<div id="leftpanel" >
								<tiles:insertAttribute name="left" />
							</div><!-- /tiles left -->
							<!--tiles main-->
							<div class="container col-md-12" id="main" >
							   <tiles:insertAttribute name="main" />
							</div><!--/tiles main-->
		</div></div></div>
		</section>
		<!-- and main -->

		<footer id="footer">
			
			<div class="footer">
				<div class="container">
					<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-6 col-xs-small about">
							<img class="logo-small" src="resources/img/logo_small.png" alt="">
							<p>There are many variations of passages of 
							Lorem Ipsum available, but the majority 
							have suffered alteration in some form. </p>
							<ul class="social-small list-inline left">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							</ul>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-6 col-xs-small latest-posts">
							<h3 class="title">Latest posts</h3>
							<ul>
								<li>
									<a href="blog-1.html" class="c-pointer">Some design blog post</a>
									<span><b>14 May 2013</b></span>
								</li>
								<li>
									<a href="blog-1.html" class="c-pointer">WordPress code for responsive</a>
									<span><b>12 May 2013</b></span>
								</li>
								<li>
									<a href="blog-1.html" class="c-pointer">Creative technologies of our time</a>
									<span><b>7 May 2013</b></span>
								</li>
								<li>
									<a href="blog-1.html" class="c-pointer">Time for your site</a>
									<span><b>21 June 2013</b></span>
								</li>
							</ul>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-6 col-xs-small new-twitt">
							<h3 class="title">News on Twitter</h3>
							<ul>
								<li>
									<i class="fa fa-twitter"></i>
									<p>Check out our new #themeforest 
									item “Energy - responsive WordPress 
									theme” at http://t.co/kfjLLhhfl9348jv</p>
									<span><b>3 days ago</b></span>
								</li>
								<li>
									<i class="fa fa-twitter"></i>
									<p>Check out our new #themeforest 
									item “Multipress - responsive 
									WordPress theme” at 
									http://t.co/kfjLLhhfl9348jv</p>
									<span><b>18 days ago</b></span>
								</li>
							</ul>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-6 col-xs-small footer-contact">
							<h3 class="title">Contact</h3>
							<span>Box 32145 Some Street Str, Lviv city 2314</span>
							<span>Phone: +38 (321) 65498732</span>
							<span>Fax: +38 (321) 65498732</span>
							<h3 class="newsletter">Newsletter</h3>
							<form>
								<input type="text" placeholder="Enter your e-mail address">
								<button>GO</button>
							</form>
							<span>By subscribing you will get the latest news from us.</span>
						</div>
					</div> <!-- and row -->
				</div> <!-- and container -->
			</div> <!-- and footer -->

		</footer> <!-- and footer -->

		<!-- Bottom bar -->
		<section>
			
			<div class="bottom-bar">
				<div class="container">
					<div class="row">
						<div class="col-md-6 col-sm-6 col-xs-12 col-xs-small copyright">
							<p>&#169; All Rights Reserved by <a href="#">Trade-now.ca</a></p>
						</div>						
					</div> <!-- and row -->
				</div> <!-- and container -->
			</div> <!-- and bottom-bar -->

		</section> <!-- and Bottom bar -->

		<a href="#" class="back-to-top"></a>

	</div> <!-- and wrap -->
	
	<!-- _ templates -->
				<script type="text/template" id="catlistitemtmp">
					<a href="#">{{name}}</a>
			</script>
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
	
	<!-- Application Domain scripts -->
	<script type="text/javascript"  id="tmp2" src="${pageContext.request.contextPath}/resources/js/application/category.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/appscript.js"></script>
	
	<!-- Other scripts -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>


</body>
</html>