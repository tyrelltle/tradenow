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

	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/landingpage_assets/img/favicon.png">

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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/landingpage_assets/css/styles.css" type="text/css" />

	<!-- Main CSS Style (in less) delete in real project-->
	<link rel="stylesheet/less" type="text/css" href="${pageContext.request.contextPath}/resources/landingpage_assets/css/styles.less">
	<!-- Less -->
	<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/less.js" type="text/javascript"></script>

	<!-- Bootstrap Grid Framework -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/landingpage_assets/css/bootstrap.css" />

	<!-- Google Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Oswald:300,400' rel='stylesheet' type='${pageContext.request.contextPath}/resources/landingpage_assets/text/css'>
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='${pageContext.request.contextPath}/resources/landingpage_assets/text/css'>
	
	<!-- Font Awesome -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/landingpage_assets/css/font-awesome.css">

	<!-- Dropdown menu -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/landingpage_assets/css/slicknav.css">

    <!-- Owl Carousel Assets -->
    <link href="${pageContext.request.contextPath}/resources/landingpage_assets/css/owl.carousel.css" rel="stylesheet">
	<!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/landingpage_assets/css/settings.css" media="screen" />
    <!-- Animate css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/landingpage_assets/css/animate.css">
	
	<!-- Scripts that is required -->
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/landingpage_assets/js/spin.min.js"></script>
	<script>var ctx = "${pageContext.request.contextPath}/"</script>
	<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/underscore.js"></script>
	<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/backbone.js"></script>
	<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/application/notification.js"></script>
	<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/application/iwait.js"></script>
	<!--Preaty Photo-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/landingpage_assets/css/prettyPhoto.css" type="text/css"/>
	<!--Internationalization-->
    <script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/i18next-1.7.4.js"></script>
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


                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <!-- Your logo -->
                                <div class="logo">
                                    <a href="${pageContext.request.contextPath}/home">
                                        <%-- 										<img src="${pageContext.request.contextPath}/resources/landingpage_assets/img/logo.png" alt="All in 1"> --%>
                                        <h1 style="float:left">Barbarian</h1>

                                    </a>
                                    <img alt="" src="${pageContext.request.contextPath}/resources/landingpage_assets/img/logo/logo.png" style="
                                        width: 107px;
                                        float: right;
                                        top:0;
                                        position: fixed;">
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
														<span class="translatee" id="fb_signon" data-i18n="signin.fb_login">Sing in with Facebook</span></a>
											</form>
											
									    </li>
									    
									    <li>
									    <form action="<c:url value="/nativelogon" />" method="GET">
														<a style="font-size:12px" class="c-pointer social social-tradenow" onclick="$(this).closest('form').submit()">
															<i class="fa fa fa-sign-in"></i>
																<span class="translatee" id="normal_signon" data-i18n="signin.bar_login"> Normal Signin</span></a>

										</form>
									    
									    
									    </li>
									    
  
									</ul>
									<!-- and Menu nav bar -->
									</div>
							
						</div> <!-- and row -->
					</div> <!-- and container -->
				</div> <!-- and header -->
            </div>
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

    <!--Langurage selection modal-->
    <div id="lngModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 id="myModalLabel">Choose Your Langurage | &#35831;&#36873;&#25321;&#26174;&#31034;&#35821;&#35328;</h3>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-6">
                            <button id="btn_en" data-lng="en" class="lngbtn btn">English</button>

                        </div>
                        <div class="col-md-6">
                            <button id="btn_ch" data-lng="zh" class="lngbtn btn">&#20013;&#25991;</button>


                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
	
  	<!-- Modernizr -->
	<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/modernizr.js"></script>



	<!-- Owl carousel -->
    <script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/owl.carousel.min.js"></script>

	<!-- Bootstrap Plagins -->
	<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/bootstrap.min.js"></script>

	<!-- Dropdown menu if screen < 650px -->
	<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/jquery.slicknav.min.js"></script>
	
	<!-- Fixed Dropdown menu if scroll -->
	<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/jquery-scrolltofixed-min.js" type="text/javascript"></script>

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/jquery-1.7.2.min.js"></script>

	<!-- Animation offset -->
	<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/wow.js"></script>

	<!-- Layout Style -->
	<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/layout.js"></script>
	

	<!-- Other scripts -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/landingpage_assets/js/script.js"></script>
  	<!-- SLIDER REVOLUTION 4.x SCRIPTS  -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/landingpage_assets/js/jquery.themepunch.plugins.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/landingpage_assets/js/jquery.themepunch.revolution.min.js"></script>

    <!--Translation-->
    <script type="text/javascript">
        if(document.URL.indexOf('nativelogon')==-1) {
            $('#lngModal').modal('show');


            $('.lngbtn').click(
                    function () {
                        i18n.init({
                                    lng: $(this).attr('data-lng'),
                                    fallbackLng: false,
                                    load: 'unspecific',
                                    resGetPath: "${pageContext.request.contextPath}/resources/landingpage_assets/locale/__ns__-__lng__.json",
                                    ns: {
                                        namespaces: ['translation'],
                                        defaultNs: 'translation'
                                    }
                                }, function () {
                                    $('.translatee').each(function () {
                                                $(this).i18n();
                                            }
                                    );
                                }
                        );
                        $('#lngModal').modal('hide');

                    }
            );
        }else{
            i18n.init({
                        fallbackLng: false,
                        load: 'unspecific',
                        resGetPath: "${pageContext.request.contextPath}/resources/landingpage_assets/locale/__ns__-__lng__.json",
                        ns: {
                            namespaces: ['translation'],
                            defaultNs: 'translation'
                        }
                    }, function () {
                        $('.translatee').each(function () {
                                    $(this).i18n();
                                }
                        );
                    }
            );
        }






    </script>
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
					fullWidth:"on"
				});

		});	//ready
	</script>
	<!-- END REVOLUTION SLIDER -->

</body>
</html>