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

    <tiles:insertAttribute name="header" />
</head>

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
        <div class="container" style="height: 34px;">
            <div class="row">
                <!-- logo -->
                <div class="col-md-2 logo">
                    <a href="index.html"><img src="${pageContext.request.contextPath}/resources/assets/img/kingadmin-logo-white.png" alt="KingAdmin - Admin Dashboard" /></a>
                    <h1 class="sr-only">KingAdmin Admin Dashboard</h1>
                </div>
                <!-- end logo -->
            </div><!-- /row -->
        </div><!-- /container -->
    </div><!-- /top -->


    <!-- BOTTOM: LEFT NAV AND RIGHT MAIN CONTENT -->
    <div class="bottom">
        <div class="container">
            <div class="row">


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
