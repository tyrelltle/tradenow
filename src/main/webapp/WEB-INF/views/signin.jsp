<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TradeNow!</title>
    <link href="${pageContext.request.contextPath}/resources/landingpage_assets/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/assets/css/application.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

                    <a class="navbar-brand" href="index.html">TradeNow!</a>

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
                <h1 data-i18n="signin.welcome" class="translatee">Welcome to TradeNow</h1>
                <h2 data-i18n="signin.yetanother" class="translatee">Yet another online bartering platform</h2>
                <div class="row">
                    <form action="<c:url value="/nativelogon" />" method="GET">
                        <button id="normal_signon" data-i18n="signin.bar_login" class="translatee col-md-offset-2 col-sm-offset-2 col-xs-offset-2 col-md-3 col-sm-3 col-xs-3 btn btn-custom-primary btn-lg btn-block btn-login" style="width: 30%;"><i class="fa fa-arrow-circle-o-right"></i> Login</button>
                    </form>

                    <form action="<c:url value="/auth/facebook" />" method="POST">
                        <input type="hidden" name="scope" value="email,user_location" />
                        <button type="button" onclick="$(this).closest('form').submit()" class="col-md-3 col-sm-3 col-xs-3 btn btn-login-facebook" style="width: 30%;margin-left: 36px;">
                            <span class="translatee" id="fb_signon" data-i18n="signin.fb_login">Login via Facebook</span>
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div><!-- /container -->

</section>
<!--////////// FEATURES SECTION ////////// -->
<section id="features">
    <div class="container wow fadeIn animated">
        <h1 data-i18n="signin.waitwho" class="translatee">Wait, Who Are You?</h1>
        <h2 data-i18n="signin.intro" class="translatee">TradeNow is an online bartering system, allowing people to exchange
            their used stuffs with others. Our principle is to enable people to
            get their wanted stuffs without currency, just like ancient store age!
        </h2>

    </div><!-- /container -->
    <div class="container">
        <div class="row">
            <div class="col-md-4 wow fadeInLeft animated" data-wow-delay="0.1s">
                <div class="iconbox">
                    <a href="#" class="icn-1">Purchase Now</a>
                </div>
                <p data-i18n="signin.collection" class="translatee icntitle">1.Collection</p>
                <p class="icnp translatee" data-i18n="signin.collection2" >Upload your own collections of stuffs that you want to trade away </p>

            </div><!-- /col-md-4 -->

            <div class="col-md-4 wow fadeInLeft animated" data-wow-delay="0.2s">
                <div class="iconbox">
                    <a href="#" class="icn-2">Responsive</a>
                </div>
                <p class="icntitle translatee" data-i18n="signin.collaboration" >2.Collaboration</p>
                <p class="icnp translatee" data-i18n="signin.collaboration2">Pick one stuff from other peoples collections, and let them choose from your collection </p>
            </div><!-- /col-md-4 -->

            <div class="col-md-4 wow fadeInLeft animated" data-wow-delay="0.3s">
                <div class="iconbox">
                    <a href="#" class="icn-3">App of Year</a>
                </div>
                <p class="icntitle translatee" data-i18n="signin.exchange" >3.Exchange!</p>
                <p class="icnp translatee" data-i18n="signin.exchange2">Now both of you have choose favorite items from each others, you guys can trade now!</p>
            </div>
        </div><!-- /col-md-4 -->
    </div><!-- /row -->
    </div><!-- /container -->

    <div class="more-features">

        <div class="container">

            <div class="col-sm-4">
                <div class="features-left wow animated fadeInLeft" data-wow-delay="0.1s">

                    <div class="features-item">
                        <i class="fa fa-facebook-square icons_right hidden-sm"></i>
                        <div class="text-align-right">
                            <h4 class="translatee" data-i18n="signin.fb_support">Facebook support</h4>
                            <p class="translatee" data-i18n="signin.fb_support2">We support not only Email registration, but also Facebook logon</p>

                        </div><!-- /text-align-right -->

                    </div><!-- /features-item -->

                    <div class="features-item">
                        <i class="fa fa-life-ring icons_right hidden-sm"></i>
                        <div class="text-align-right">
                            <h4 class="translatee" data-i18n="signin.support">24/7 Support</h4>
                            <p class="translatee" data-i18n="signin.support2">Whenever you need help, we are always here!</p>

                        </div><!-- /text-align-right -->

                    </div><!-- /features-item -->
                    <div class="features-item">
                        <i class="fa fa-location-arrow icons_right hidden-sm"></i>
                        <div class="text-align-right">
                            <h4 class="translatee" data-i18n="signin.locbase">Location Based</h4>
                            <p class="translatee" data-i18n="signin.locbase2">You can always find the nearest people to trade with</p>

                        </div><!-- /text-align-right -->

                    </div><!-- /features-item -->
                </div><!-- /features-left -->
            </div><!-- /col-sm-4 -->

            <div id="iphone" style="margin-top: 160px;" class="col-sm-4 hidden-xs wow animated fadeInUp" data-wow-delay="0.3s">
                <img style="margin-top: 160px;" src="${pageContext.request.contextPath}/resources/landingpage_assets/img/shakehand.jpg" class="img-responsive" alt="iPhone">
            </div><!-- /col-sm-4 -->

            <div class="col-sm-4">

                <div class="features-right wow animated fadeInRight" data-wow-delay="0.2s">

                    <div class="features-item">
                        <i class="fa fa-star icons_left hidden-sm"></i>
                        <div class="text-align-left">
                            <h4 class="translatee" data-i18n="signin.userfriendly">We have lovely user interface</h4>
                            <p class="translatee" data-i18n="signin.userfriendly2">We have been trying to bring you the best user experience </p>

                        </div><!-- /text-align-left -->

                    </div><!-- /features-item -->

                    <div class="features-item">
                        <i class="fa fa-users icons_left hidden-sm"></i>
                        <div class="text-align-left">
                            <h4 class="translatee" data-i18n="signin.allinone">Ease of collaboration</h4>
                            <p class="translatee" data-i18n="signin.allinone2">User collaboration,trading transaction can be done within only one page</p>

                        </div><!-- /text-align-left -->

                    </div><!-- /features-item -->
                    <div class="features-item">
                        <i class="fa fa-cloud icons_left hidden-sm"></i>
                        <div class="text-align-left">
                            <h4 class="translatee" data-i18n="signin.safe">Safety</h4>
                            <p class="translatee" data-i18n="signin.safe2"> We keep your data in the cloud, and we promise they are safe</p>

                        </div><!-- /text-align-left -->

                    </div><!-- /features-item -->
                </div><!-- /features-right -->
            </div><!-- /col-sm-4 -->


        </div><!-- /container -->


    </div><!-- /more-features -->

</section>
<!--////////// spliter SECTION ////////// -->
<section id="newsletter">

    <div class="container wow animated fadeInDown">
        <h3 class="translatee" data-i18n="signin.waitstill">Wait, still not sure what we do? Have a look at following tutorial</h3>
    </div>

</section>
<!--////////// tutorial SECTION ////////// -->
<section id="screenshots">
    <!--step 1-->
    <div class="container wow fadeInUp animated">
        <h1 class="translatee" data-i18n="signin.stepone">Step One - Browse on public marketplace, and find out what you want to own</h1>
        <h2 class="translatee" data-i18n="signin.steponee">People has their own public backlog of stuffs that they want to throw away, and other people can view them</h2>
    </div><!-- /container -->
    <div class="row">
        <div class="masonrycontainer" style="position: relative;width:80%;margin-left:10%">
            <div class="masonryitem col-md-3">
                <div class="blog-item">
                    <img alt="" class="btn_detail" src="${pageContext.request.contextPath}/resources/landingpage_assets/img/featured-projects/p1.jpg">
                    <div class="blog-item-description">
                        <h3>Nice XBOX</h3>
                        <div class="row">
                            <div class="col-md-4">
                                <a><img style="width:50px;border-radius: 12px;" src="${pageContext.request.contextPath}/resources/assets/img/defaultusericon.png"></a>
                            </div>
                            <div class="col-md-8">
                                <p class="ownernm">Tian Shao</p>
                                <p>New Westminster, BC, Canada</p>
                            </div>

                        </div>
                        <a class="btn_detail more">Keep reading <i class="fa fa-angle-right"></i></a>
                        <a><i class="glyphicon glyphicon-heart btnunlike"></i></a>
                    </div>
                </div>
                <div class="bottom-border">
                </div>
            </div><div class="masonryitem col-md-3">
            <div class="blog-item">
                <img alt="" class="btn_detail" src="${pageContext.request.contextPath}/resources/landingpage_assets/img/featured-projects/p2.jpg">
                <div class="blog-item-description">
                    <h3>Newest TV!</h3>
                    <div class="row">
                        <div class="col-md-4">
                            <a><img style="width:50px;border-radius: 12px;" src="${pageContext.request.contextPath}/resources/assets/img/defaultusericon.png"></a>
                        </div>
                        <div class="col-md-8">
                            <p class="ownernm">Leo Liu</p>
                            <p>New Westminster, BC, Canada</p>
                        </div>

                    </div>
                    <a class="btn_detail more">Keep reading <i class="fa fa-angle-right"></i></a>
                    <a><i class="glyphicon glyphicon-heart btnunlike"></i></a>
                </div>
            </div>
            <div class="bottom-border">
            </div>
        </div><div class="masonryitem col-md-3">
            <div class="blog-item">
                <img alt="" class="btn_detail" src="${pageContext.request.contextPath}/resources/landingpage_assets/img/featured-projects/p3.jpg">
                <div class="blog-item-description">
                    <h3>Your dream phone</h3>
                    <div class="row">
                        <div class="col-md-4">
                            <a><img style="width:50px;border-radius: 12px;" src="${pageContext.request.contextPath}/resources/assets/img/defaultusericon.png"></a>
                        </div>
                        <div class="col-md-8">
                            <p class="ownernm">Natasha black</p>
                            <p>New Westminster, BC, Canada</p>
                        </div>

                    </div>
                    <a class="btn_detail more">Keep reading <i class="fa fa-angle-right"></i></a>
                    <a><i class="glyphicon glyphicon-heart btnunlike"></i></a>
                </div>
            </div>
            <div class="bottom-border">
            </div>
        </div><div class="masonryitem col-md-3">
            <div class="blog-item">
                <img alt="" class="btn_detail" src="${pageContext.request.contextPath}/resources/landingpage_assets/img/featured-projects/p4.jpg">
                <div class="blog-item-description">
                    <h3>Lovely Sofa</h3>
                    <div class="row">
                        <div class="col-md-4">
                            <a><img style="width:50px;border-radius: 12px;" src="${pageContext.request.contextPath}/resources/assets/img/defaultusericon.png"></a>
                        </div>
                        <div class="col-md-8">
                            <p class="ownernm">Sophia Weng</p>
                            <p>New Westminster, BC, Canada</p>
                        </div>

                    </div>
                    <a class="btn_detail more">Keep reading <i class="fa fa-angle-right"></i></a>
                    <a><i class="glyphicon glyphicon-heart btnunlike"></i></a>
                </div>
            </div>
            <div class="bottom-border">
            </div>
        </div></div>
    </div>
    <div style="height:100px"></div>
    <!--step 2-->
    <div class="container wow fadeInUp animated">
        <h1 class="translatee" data-i18n="signin.steptwo">Step Two - Find what you can offer, and negotiate with others</h1>
        <h2 class="translatee" data-i18n="signin.steptwoo">Looks like you have choose to own that Xbox One! Now you can choose one of your belongings from your own backlog, and negotiate with the Xbox owner within our site</h2>
    </div>
        <img style="width:70%;margin-left:15%" src="${pageContext.request.contextPath}/resources/landingpage_assets/img/featured-projects/letstrade.jpg" class="img-responsive">

    <div style="height:100px"></div>
    <!--step 2-->
    <div class="container wow fadeInUp animated">
        <h1 class="translatee" data-i18n="signin.stepthree">Step Three - Negotiation about the delivery method on site</h1>
        <h2 class="translatee" data-i18n="signin.stepthreee">Ok! Now you have had the deal to trade Xbox One with your cool TV. Next, you can choose either delivery in-person or use commertial delivery/mailing services.
            Our system will keep track of every trade history and their user-defined delivery methods. Therefore don't worry if you feel been spamed. We have your back covered.</h2>

    </div>
    <img style="width:70%;margin-left:15%" src="${pageContext.request.contextPath}/resources/landingpage_assets/img/featured-projects/mailtype.jpg" class="img-responsive">


</section>
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
<!--////////// FOOTER SECTION ////////// -->
<footer>
    <div class="row">
        <div class="col-md-6" style="text-align: right;">
            <p>&copy; 2014 Trade-Now.ca</p>
            <p>Designed with love by Barbarian Network Ltd.</p>
        </div>
        <div class="col-md-6" style="text-align: left;">
            <p>Contact Us</p>
            <p>Email: tyrelltle@gmail.com</p>
        </div>
    </div>
</footer>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/wow.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/nivo-lightbox.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/landingpage_assets/js/main.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/i18next-1.7.4.min.js"></script>

<script type="text/javascript">
    $('#lngModal').modal('show');
    $('.lngbtn').click(
            function () {
                i18n.init({
                            lng: $(this).attr('data-lng'),
                            fallbackLng: false,
                            load: 'unspecific',
                            resGetPath: "${pageContext.request.contextPath}/resources/locale/__ns__-__lng__.json",
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
</script>

</body>
</html>