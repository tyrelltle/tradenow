<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie ie9" lang="en" class="no-js"> <![endif]-->
<!--[if !(IE)]><!--><html lang="en" class="no-js"> <!--<![endif]-->
<head>
    <title>Blank Page | KingAdmin - Admin Dashboard</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="description" content="KingAdmin - Bootstrap Admin Dashboard Theme">
    <meta name="author" content="The Develovers">

    <!-- CSS -->
    <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/assets/css/main.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/assets/css/application.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/assets/css/skins/fullbright.css" rel="stylesheet" type="text/css">
    <!-- CSS for demo style switcher. you can remove this -->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/resources/assets/ico/kingadmin-favicon144x144.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/resources/assets/ico/kingadmin-favicon114x114.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/resources/assets/ico/kingadmin-favicon72x72.png">
    <link rel="apple-touch-icon-precomposed" sizes="57x57" href="${pageContext.request.contextPath}/resources/assets/ico/kingadmin-favicon57x57.png">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/assets/ico/favicon.png">


    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery-2.1.0.min.js"></script>

    <!--Internationalization-->
    <script src="${pageContext.request.contextPath}/resources/assets/js/i18next-1.7.4.js"></script>

    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/assets/js/spin.min.js"></script>
    <script>var ctx = "${pageContext.request.contextPath}/"</script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/underscore.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/backbone.js"></script>
    <script src="${pageContext.request.contextPath}/resources/application/notification.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places"></script>
    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/application/autocompleteapi.js"></script>
    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/application/feedback.js"></script>

    <tiles:insertAttribute name="header" />
</head>
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

<!--category modal-->
<div class="modal" id="catmodal" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-category modal-dialog">
        <div class="modal-content">
            <div class="modalheader modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <div class="modal-title" id="myModalLabel">Choose a cateogory</div>
            </div>
            <div class="modal-body">
                <div class="widget-content">
                    <table class="table">
                        <tbody class="catmenu">

                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
</div>

</div>


<!--feedback modal-->
<div class="modal fade" id="feedbackModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Submit a feedback</h4>
            </div>
            <div class="modal-body">
                <p>Please enter your feedback here:</p>
                <textarea id="feedbacktext" class="form-control" rows="5" cols="30"></textarea>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="feedback(this,'#feedbacktext','${pageContext.request.contextPath}');">Send feedback</button>
            </div>
        </div>
    </div>
</div>



<!--underscore templates -->
<script type="text/template" id="catlistitemtmp">
    <a href="#">{{name}}</a>
</script>
<script type="text/template" id="notifitemtmp">
    <a href="#">
        <i class="fa fa-comment green-font"></i>
        <span class="text">{{message}}</span>
    </a>
</script>

<script src="${pageContext.request.contextPath}/resources/application/iwait.js"></script>
<body class="demo-only-page-blank">
<!-- WRAPPER -->
<div class="wrapper">

<!-- TOP GENERAL ALERT -->
<div class="alert alert-danger top-general-alert">
    <span>If you <strong>can't see the logo</strong> on the top left, please reset the style on right style switcher (for upgraded theme only).</span>
    <a type="button" class="close">&times;</a>
</div>
<!-- END TOP GENERAL ALERT -->

<!-- TOP BAR -->
<div class="top-bar">
<div class="container">
<div class="row">
<!-- logo -->
<div class="col-md-2 logo">
    <a href="index.html"><img src="${pageContext.request.contextPath}/resources/assets/img/kingadmin-logo.png" alt="KingAdmin - Admin Dashboard" /></a>
    <h1 class="sr-only">KingAdmin Admin Dashboard</h1>
</div>
<!-- end logo -->
<div class="col-md-10">
<div class="row">



<div class="col-md-12">

<div class="top-bar-right">
<div class="col-md-3">
    <!-- search box -->
    <div id="tour-searchbox" class="input-group searchbox">

        <c:choose>
            <c:when test="${not empty searchkey}">
                <input type="search" class="searchtxt form-control" value="${searchkey}">
            </c:when>
            <c:otherwise>
                <input type="search" class="searchtxt form-control translatee" data-i18n="[placeholder]menu.searchnm" placeholder="What are you looking for...">
            </c:otherwise>
        </c:choose>

        <!--<span class="input-group-btn">
            <button class="searchbtn btn btn-default" type="button"><i class="fa fa-search"></i></button>
        </span>-->
    </div>
    <!-- end search box -->
</div>
<div class="col-md-3">
    <!-- location search box -->
    <form id="locform" class="searchform input-group searchbox">

        <c:choose>
            <c:when test="${not empty location}">
                <input type="search" class="locsearchtxt form-control" id="autocomplete" onFocus="geolocate()" value="${location}">
            </c:when>
            <c:otherwise>
                <input type="search" class="locsearchtxt form-control translatee" id="autocomplete" onFocus="geolocate()" data-i18n="[placeholder]menu.searchlc" placeholder="Near Vancouver, BC">
            </c:otherwise>
        </c:choose>

        <span class="input-group-btn">
            <button class="loc_srch_btn btn btn-default" type="button"><i class="fa fa-search"></i></button>
        </span>
        <input id="lat" type="hidden"/>
        <input id="lng" type="hidden"/>
    </form>
    <script type="text/javascript">
        initializeAutocomplete();
        $(".searchform").keypress(function(e){
            if (e.which == 13) {
                var tagName = e.target.tagName.toLowerCase();
                if (tagName !== "textarea") {
                    return false;
                }
            }
        });
    </script>
    <!-- end location search box -->
</div>
<!-- responsive menu bar icon -->
<a href="#" class="hidden-md hidden-lg main-nav-toggle"><i class="fa fa-bars"></i></a>
<!-- end responsive menu bar icon -->
<button type="button" class="btn btn-link" data-toggle="modal" data-target="#feedbackModal"><i class="fa fa-envelope"></i>Feedback</button>
<button type="button" id="btn_cat" class="btn btn-link"><i class="fa fa-th-list"></i> <span class="translatee" data-i18n="menu.category">Categories</span></button>
<button type="button" id="tolikesbtn" class="likesbtn btn btn-link"><i class="fa fa-heart"></i>  <span class="translatee" data-i18n="menu.fav">Favorites</span></button>
<div class="notifications">
    <ul>
        <!-- notification: general -->
        <li class="notification-item general">
            <div class="btn-group">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="fa fa-bell"></i><span class="count"></span>
                    <span class="circle"></span>
                </a>
                <ul class="notiflis dropdown-menu" role="menu">
                    <li>
                        <a href="#">
                            <i class="fa fa-comment green-font"></i>
                            <span class="text">There is no news</span>
                        </a>
                    </li>
                </ul>
            </div>
        </li>
        <!-- end notification: general -->
    </ul>
</div>

<!-- logged user and the menu -->
<div class="logged-user">
    <div class="btn-group">
        <a href="#" class="btn btn-link dropdown-toggle" data-toggle="dropdown">
            <img src="${pageContext.request.contextPath}/user/img" style="max-height: 30px;max-width: 30px" />
            <span class="caret"></span>
        </a>
        <ul class="dropdown-menu" role="menu">
            <li>
                <a href="${pageContext.request.contextPath}/user">
                    <i class="fa fa-user"></i>
                    <span class="text">Profile</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-cog"></i>
                    <span class="text">Settings</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/signout">
                    <i class="fa fa-power-off"></i>
                    <span class="text">Logout</span>
                </a>
            </li>
        </ul>
    </div>
</div>
<!-- end logged user and the menu -->
</div><!-- /top-bar-right -->
</div>
</div><!-- /row -->
</div>
</div><!-- /row -->
</div><!-- /container -->
</div><!-- /top -->


<!-- BOTTOM: LEFT NAV AND RIGHT MAIN CONTENT -->
<div class="bottom">
    <div class="container">
        <div class="row">
            <!-- left sidebar -->
            <div class="col-md-2 left-sidebar">

                <!-- main-nav -->
                <nav class="main-nav">

                    <ul class="main-menu">
                        <li ><a href="${pageContext.request.contextPath}/home"><i class="fa fa-home fa-fw"></i><span class="text translatee" data-i18n="menu.home">Home</span></a></li>
                        <li ><a href="${pageContext.request.contextPath}/user#prodlis"><i class="fa fa-plus-square fa-fw"></i><span class="text translatee" data-i18n="menu.additem">Add Item</span></a></li>
                        <li ><a href="${pageContext.request.contextPath}/user#tradelis"><i class="fa fa-exchange fa-fw"></i><span class="text translatee" data-i18n="menu.prevtrade">My Previous Trades</span></a></li>
                        <li ><a href="${pageContext.request.contextPath}/user"><i class="fa fa-user fa-fw"></i><span class="text translatee" data-i18n="menu.profile">My Profile</span></a></li>
                        <li ><a href="${pageContext.request.contextPath}/home"><i class="fa fa-question-circle fa-fw"></i><span class="text">FAQ</span></a></li>


                    </ul>
                </nav><!-- /main-nav -->

                <div class="sidebar-minified js-toggle-minified">
                    <i class="fa fa-angle-left"></i>
                </div>


            </div>
            <!-- end left sidebar -->

            <!-- content-wrapper -->
            <div class="col-md-10 content-wrapper expanded" style="margin-top: 20px;">


                <!-- main -->
                <div class="content">
                        <tiles:insertAttribute name="main" />
                </div><!-- /main -->
            </div><!-- /content-wrapper -->
        </div><!-- /row -->
    </div><!-- /container -->
</div>
<!-- END BOTTOM: LEFT NAV AND RIGHT MAIN CONTENT -->
<div class="push-sticky-footer"></div>
</div><!-- /wrapper -->

<!-- FOOTER -->
<footer class="footer">
    &copy; 2014 The Develovers
</footer>
<!-- END FOOTER -->



<!-- END STYLE SWITCHER -->
<div style="display:none">
    <tiles:insertAttribute name="left" />
</div>
<!-- Javascript -->

<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/modernizr.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap-tour.custom.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/king-common.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.gritter.min.js"></script>

<!-- Application Domain scripts -->
<%--<script type="text/javascript"  id="tmp2" src="${pageContext.request.contextPath}/resources/application/category.js"></script>--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/application/category.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/application/appscript.js"></script>

<script src="${pageContext.request.contextPath}/resources/application/tour.js"></script>

</body>
</html>
