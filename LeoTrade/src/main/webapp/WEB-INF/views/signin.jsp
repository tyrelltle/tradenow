<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Flati - Responsive App Landing</title>
    <link href="${pageContext.request.contextPath}/resources/landingpage_assets/css/style.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="doc-loader"></div>
<!--/////////// HEADER SECTION //////////-->
<section id="intro">
    <header>
        <nav class="navbar navbar-default" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="container">

                    <a class="navbar-brand" href="index.html">Flati</a>

                    <div id="main-nav" class="navbar-collapse">
                        <ul class="social-links">
                            <a href="#"><li class="fa fa-twitter"></li></a><!-- Twitter Link -->
                            <a href="#"><li class="fa fa-facebook"></li></a><!-- Facebook Link -->
                            <a href="#"><li class="fa fa-youtube"></li></a><!-- YouTube Link -->
                            <a href="#"><li class="fa fa-instagram"></li></a><!-- Instagram Link -->
                        </ul>
                    </div><!-- /navbar-collapse -->
                </div><!-- /container -->

            </div>
        </nav>
    </header>
    <div class="container">
        <div class="intro-well wow animated bounceIn">
            <div class="col-md-12">
                <h1>Creative & modern landing, designed with love for apps.</h1>
                <h2>Design is not just what it looks like. Design is how it works.</h2>
                <div class="row">
                    <form action="<c:url value="/nativelogon" />" method="GET">
                        <button class="col-md-offset-2 col-sm-offset-2 col-xs-offset-2 col-md-3 col-sm-3 col-xs-3 btn btn-custom-primary btn-lg btn-block btn-login" style="width: 30%;"><i class="fa fa-arrow-circle-o-right"></i> Login</button>
                    </form>
                    <button type="button" class="col-md-3 col-sm-3 col-xs-3 btn btn-login-facebook" style="width: 30%;margin-left: 36px;"><span>Login via Facebook</span></button>
                </div>
            </div>
        </div>
    </div><!-- /container -->

</section>
<!--////////// FEATURES SECTION ////////// -->
<section id="features">
    <div class="container wow fadeIn animated">
        <h1>How It Works?</h1>
        <h2>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam scelerisque faucibus risus non iaculis. Fusce a augue ante, pellentesque pretium erat. Fusce in turpis in velit tempor pretium. Integer a leo libero.</h2>

    </div><!-- /container -->
    <div class="container">
        <div class="row">
            <div class="col-md-4 wow fadeInLeft animated" data-wow-delay="0.1s">
                <div class="iconbox">
                    <a href="#" class="icn-1">Purchase Now</a>
                </div>
                <p class="icntitle">1.Purchase</p>
                <p class="icnp">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eget elit eu velit vehicula feugiat. </p>

            </div><!-- /col-md-4 -->

            <div class="col-md-4 wow fadeInLeft animated" data-wow-delay="0.2s">
                <div class="iconbox">
                    <a href="#" class="icn-2">Responsive</a>
                </div>
                <p class="icntitle">2.Install</p>
                <p class="icnp">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eget elit eu velit vehicula feugiat. </p>
            </div><!-- /col-md-4 -->

            <div class="col-md-4 wow fadeInLeft animated" data-wow-delay="0.3s">
                <div class="iconbox">
                    <a href="#" class="icn-3">App of Year</a>
                </div>
                <p class="icntitle">3.Enjoy</p>
                <p class="icnp">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eget elit eu velit vehicula feugiat. </p>
            </div>
        </div><!-- /col-md-4 -->
    </div><!-- /row -->
    </div><!-- /container -->

    <div class="more-features">

        <div class="container">

            <div class="col-sm-4">
                <div class="features-left wow animated fadeInLeft" data-wow-delay="0.1s">

                    <div class="features-item">
                        <i class="fa fa-desktop icons_right hidden-sm"></i>
                        <div class="text-align-right">
                            <h4>Responsive Layout</h4>
                            <p>Quis autem velis reprehenderit et quis voluptate velit esse quam nihil et illum consequatur.</p>

                        </div><!-- /text-align-right -->

                    </div><!-- /features-item -->

                    <div class="features-item">
                        <i class="fa fa-life-ring icons_right hidden-sm"></i>
                        <div class="text-align-right">
                            <h4>24/7 Support</h4>
                            <p>Quis autem velis reprehenderit et quis voluptate velit esse quam nihil et illum consequatur.</p>

                        </div><!-- /text-align-right -->

                    </div><!-- /features-item -->
                    <div class="features-item">
                        <i class="fa fa-sliders icons_right hidden-sm"></i>
                        <div class="text-align-right">
                            <h4>Easy to Customize</h4>
                            <p>Quis autem velis reprehenderit et quis voluptate velit esse quam nihil et illum consequatur.</p>

                        </div><!-- /text-align-right -->

                    </div><!-- /features-item -->
                </div><!-- /features-left -->
            </div><!-- /col-sm-4 -->

            <div id="iphone" class="col-sm-4 hidden-xs wow animated fadeInUp" data-wow-delay="0.3s">
                <img src="${pageContext.request.contextPath}/resources/landingpage_assets/img/iphone.png" class="img-responsive" alt="iPhone">
            </div><!-- /col-sm-4 -->

            <div class="col-sm-4">

                <div class="features-right wow animated fadeInRight" data-wow-delay="0.2s">

                    <div class="features-item">
                        <i class="fa fa-heart icons_left hidden-sm"></i>
                        <div class="text-align-left">
                            <h4>Crafted with Love</h4>
                            <p>Quis autem velis reprehenderit et quis voluptate velit esse quam nihil et illum consequatur.</p>

                        </div><!-- /text-align-left -->

                    </div><!-- /features-item -->

                    <div class="features-item">
                        <i class="fa fa-rocket icons_left hidden-sm"></i>
                        <div class="text-align-left">
                            <h4>Awsomee Features</h4>
                            <p>Quis autem velis reprehenderit et quis voluptate velit esse quam nihil et illum consequatur.</p>

                        </div><!-- /text-align-left -->

                    </div><!-- /features-item -->
                    <div class="features-item">
                        <i class="fa fa-gift icons_left hidden-sm"></i>
                        <div class="text-align-left">
                            <h4>Lifetime Updates</h4>
                            <p>Quis autem velis reprehenderit et quis voluptate velit esse quam nihil et illum consequatur.</p>

                        </div><!-- /text-align-left -->

                    </div><!-- /features-item -->
                </div><!-- /features-right -->
            </div><!-- /col-sm-4 -->


        </div><!-- /container -->


    </div><!-- /more-features -->

</section>
<!--////////// NEWSLETTER SECTION ////////// -->
<section id="newsletter">

    <div class="container wow animated fadeInDown">
        <h3>Sign up today to be notified when we launch the app!</h3>
        <form class="form-inline">
            <input type="email" id="email" name="email" placeholder="Enter your email..." class="input-lg">
            <button type="submit" class="btn btn-primary">Subscribe</button>
        </form>
    </div>

</section>
<!--////////// SCREENSHOTS SECTION ////////// -->
<section id="screenshots">
    <div class="container wow fadeInUp animated">
        <h1>Screenshots</h1>
        <h2>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam scelerisque faucibus risus non iaculis. Fusce a augue ante, pellentesque pretium erat. Fusce in turpis in velit tempor pretium. Integer a leo libero.</h2>
    </div><!-- /container -->
    <div class="container">
        <div class="row">
            <div class="col-sm-4 wow fadeInLeft animated" data-wow-delay="0.1s">
                <a href="${pageContext.request.contextPath}/resources/landingpage_assets/img/screenshots/1.jpg" class="thumbnail" data-lightbox-gallery="gallery1">
                    <img src="${pageContext.request.contextPath}/resources/landingpage_assets/img/screenshots/1.jpg" alt="..." />
                </a>
            </div>
            <div class="col-sm-4 wow fadeInLeft animated" data-wow-delay="0.2s">
                <a href="${pageContext.request.contextPath}/resources/landingpage_assets/img/screenshots/2.jpg" class="thumbnail" data-lightbox-gallery="gallery1">
                    <img src="${pageContext.request.contextPath}/resources/landingpage_assets/img/screenshots/2.jpg" alt="..." />
                </a>
            </div>
            <div class="col-sm-4 wow fadeInLeft animated" data-wow-delay="0.3s">
                <a href="${pageContext.request.contextPath}/resources/landingpage_assets/img/screenshots/3.jpg" class="thumbnail" data-lightbox-gallery="gallery1">
                    <img src="${pageContext.request.contextPath}/resources/landingpage_assets/img/screenshots/3.jpg" alt="..." />
                </a>
            </div>
        </div>

    </div>
</section>
<!--////////// DOWNLOAD SECTION ////////// -->
<section id="download">

    <div class="container wow fadeIn animated">
        <div class="row">

            <div class="col-md-4">
                <h3>Ea eam mollis phaedrum, eam at appareat consetetur repudiandae,</h3>
                <a class="btn btn-primary" href="#"><li class="fa fa-apple fa-lg"></li>&nbsp;&nbsp;Download from Appstore</a>
            </div>

            <div class="col-md-8">
                <img src="${pageContext.request.contextPath}/resources/landingpage_assets/img/iphone2.png" class="img-responsive" alt="picture">
            </div>

        </div><!-- /row -->

    </div><!-- /container -->
</section>
<!--////////// FOOTER SECTION ////////// -->
<footer>
    <p>© Copyright 2014 Flati - Designed with love by Themeberry</p>
</footer>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/wow.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/nivo-lightbox.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/main.js"></script>
</body>
</html>