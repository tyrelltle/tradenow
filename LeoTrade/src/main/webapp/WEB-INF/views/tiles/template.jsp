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
    <link href="demo-style-switcher/assets/css/style-switcher.css" rel="stylesheet" type="text/css">

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/resources/assets/ico/kingadmin-favicon144x144.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/resources/assets/ico/kingadmin-favicon114x114.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/resources/assets/ico/kingadmin-favicon72x72.png">
    <link rel="apple-touch-icon-precomposed" sizes="57x57" href="${pageContext.request.contextPath}/resources/assets/ico/kingadmin-favicon57x57.png">
    <link rel="shortcut icon" href="assets/ico/favicon.png">


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
    <a href="index.html"><img src="${pageContext.request.contextPath}/resources/assets/img/kingadmin-logo-white.png" alt="KingAdmin - Admin Dashboard" /></a>
    <h1 class="sr-only">KingAdmin Admin Dashboard</h1>
</div>
<!-- end logo -->
<div class="col-md-10">
<div class="row">
<div class="col-md-3">
    <!-- search box -->
    <div id="tour-searchbox" class="input-group searchbox">
        <input type="search" class="form-control" placeholder="enter keyword here...">
									<span class="input-group-btn">
										<button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
									</span>
    </div>
    <!-- end search box -->
</div>
<div class="col-md-9">
<div class="top-bar-right">
<!-- responsive menu bar icon -->
<a href="#" class="hidden-md hidden-lg main-nav-toggle"><i class="fa fa-bars"></i></a>
<!-- end responsive menu bar icon -->
<button type="button" id="start-tour" class="btn btn-link"><i class="fa fa-refresh"></i> Start Tour</button>
<button type="button" id="global-volume" class="btn btn-link btn-global-volume"><i class="fa"></i> <span class="badge element-bg-color-blue">New</span></button>
<div class="notifications">
    <ul>
        <!-- notification: inbox -->
        <li class="notification-item inbox">
            <div class="btn-group">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="fa fa-envelope"></i><span class="count">2</span>
                    <span class="circle"></span>
                </a>

                <ul class="dropdown-menu" role="menu">
                    <li class="notification-header">
                        <em>You have 2 unread messages</em>
                    </li>
                    <li class="inbox-item clearfix">
                        <a href="#">
                            <div class="media">
                                <div class="pull-left" href="#">
                                    <img class="media-object" src="${pageContext.request.contextPath}/resources/assets/img/user1.png" alt="Antonio">
                                </div>
                                <div class="media-body">
                                    <h5 class="media-heading name">Antonius</h5>
                                    <p class="text">The problem just happened this morning. I can't see ...</p>
                                    <span class="timestamp">4 minutes ago</span>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="inbox-item unread clearfix">
                        <a href="#">
                            <div class="media">
                                <div class="pull-left" href="#">
                                    <img class="media-object" src="${pageContext.request.contextPath}/resources/assets/img/user2.png" alt="Antonio">
                                </div>
                                <div class="media-body">
                                    <h5 class="media-heading name">Michael</h5>
                                    <p class="text">Hey dude, cool theme!</p>
                                    <span class="timestamp">2 hours ago</span>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="inbox-item unread clearfix">
                        <a href="#">
                            <div class="media">
                                <div class="pull-left" href="#">
                                    <img class="media-object" src="${pageContext.request.contextPath}/resources/assets/img/user3.png" alt="Antonio">
                                </div>
                                <div class="media-body">
                                    <h5 class="media-heading name">Stella</h5>
                                    <p class="text">Ok now I can see the status for each item. Thanks! :D</p>
                                    <span class="timestamp">Oct 6</span>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="inbox-item clearfix">
                        <a href="#">
                            <div class="media">
                                <div class="pull-left" href="#">
                                    <img class="media-object" src="${pageContext.request.contextPath}/resources/assets/img/user4.png" alt="Antonio">
                                </div>
                                <div class="media-body">
                                    <h5 class="media-heading name">Jane Doe</h5>
                                    <p class="text"><i class="fa fa-reply"></i> Please check the status of your ...</p>
                                    <span class="timestamp">Oct 2</span>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="inbox-item clearfix">
                        <a href="#">
                            <div class="media">
                                <div class="pull-left" href="#">
                                    <img class="media-object" src="${pageContext.request.contextPath}/resources/assets/img/user5.png" alt="Antonio">
                                </div>
                                <div class="media-body">
                                    <h5 class="media-heading name">John Simmons</h5>
                                    <p class="text"><i class="fa fa-reply"></i> I've fixed the problem :)</p>
                                    <span class="timestamp">Sep 12</span>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="notification-footer">
                        <a href="#">View All Messages</a>
                    </li>
                </ul>
            </div>
        </li>
        <!-- end notification: inbox -->

        <!-- notification: general -->
        <li class="notification-item general">
            <div class="btn-group">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="fa fa-bell"></i><span class="count">8</span>
                    <span class="circle"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li class="notification-header">
                        <em>You have 8 notifications</em>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-comment green-font"></i>
                            <span class="text">New comment on the blog post</span>
                            <span class="timestamp">1 minute ago</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-user green-font"></i>
                            <span class="text">New registered user</span>
                            <span class="timestamp">12 minutes ago</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-comment green-font"></i>
                            <span class="text">New comment on the blog post</span>
                            <span class="timestamp">18 minutes ago</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-shopping-cart red-font"></i>
                            <span class="text">4 new sales order</span>
                            <span class="timestamp">4 hours ago</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-edit yellow-font"></i>
                            <span class="text">3 product reviews awaiting moderation</span>
                            <span class="timestamp">1 day ago</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-comment green-font"></i>
                            <span class="text">New comment on the blog post</span>
                            <span class="timestamp">3 days ago</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-comment green-font"></i>
                            <span class="text">New comment on the blog post</span>
                            <span class="timestamp">Oct 15</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-warning red-font"></i>
                            <span class="text red-font">Low disk space!</span>
                            <span class="timestamp">Oct 11</span>
                        </a>
                    </li>
                    <li class="notification-footer">
                        <a href="#">View All Notifications</a>
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
            <img src="${pageContext.request.contextPath}/resources/assets/img/user-avatar.png" />
            <span class="name">Stacy Rose</span> <span class="caret"></span>
        </a>
        <ul class="dropdown-menu" role="menu">
            <li>
                <a href="#">
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
                <a href="#">
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
                        <li ><a href="${pageContext.request.contextPath}/home"><i class="fa fa-home fa-fw"></i><span class="text">Home</span></a></li>
                        <li ><a href="#" class="js-sub-menu-toggle"><i class="fa fa-clipboard fa-fw"></i><span class="text">Pages</span>
                            <i class="toggle-icon fa fa-angle-left"></i></a>
                            <ul class="sub-menu open">
                                <li ><a href="page-profile.html"><span class="text">Profile</span></a></li>
                                <li ><a href="page-invoice.html"><span class="text">Invoice</span></a></li>
                                <li ><a href="page-knowledgebase.html"><span class="text">Knowledge Base</span></a></li>
                                <li ><a href="page-inbox.html"><span class="text">Inbox</span></a></li>
                                <li ><a href="page-register.html"><span class="text">Register</span></a></li>
                                <li ><a href="page-login.html"><span class="text">Login</span></a></li>
                                <li ><a href="page-404.html"><span class="text">404</span></a></li>
                                <li class="active"><a href="page-blank.html"><span class="text">Blank Page</span></a></li>
                            </ul>
                        </li>
                        <li ><a href="#" class="js-sub-menu-toggle"><i class="fa fa-bar-chart-o fw"></i><span class="text">Charts &amp; Statistics</span>
                            <i class="toggle-icon fa fa-angle-left"></i></a>
                            <ul class="sub-menu ">
                                <li ><a href="charts-statistics.html"><span class="text">Charts</span></a></li>
                                <li ><a href="charts-statistics-interactive.html"><span class="text">Interactive Charts</span></a></li>
                                <li ><a href="charts-statistics-real-time.html"><span class="text">Realtime Charts</span></a></li>
                                <li ><a href="charts-d3charts.html"><span class="text">D3 Charts</span></a></li>
                            </ul>
                        </li>
                        <li ><a href="#" class="js-sub-menu-toggle"><i class="fa fa-edit fw"></i><span class="text">Forms</span>
                            <i class="toggle-icon fa fa-angle-left"></i></a>
                            <ul class="sub-menu ">
                                <li ><a href="form-inplace-editing.html"><span class="text">In-place Editing <span class="badge element-bg-color-blue">New</span></span></a></li>
                                <li ><a href="form-elements.html"><span class="text">Form Elements <span class="badge element-bg-color-blue">Updated</span></span></a></li>
                                <li ><a href="form-layouts.html"><span class="text">Form Layouts <span class="badge element-bg-color-blue">New</span></span></a></li>
                                <li ><a href="form-bootstrap-elements.html"><span class="text">Bootstrap Elements <span class="badge element-bg-color-blue">New</span></span></a></li>
                                <li ><a href="form-validations.html"><span class="text">Validation</span></a></li>
                                <li ><a href="form-file-upload.html"><span class="text">File Upload</span></a></li>
                                <li ><a href="form-text-editor.html"><span class="text">Text Editor <span class="badge element-bg-color-blue">New</span></span></a></li>
                            </ul>
                        </li>
                        <li ><a href="#" class="js-sub-menu-toggle"><i class="fa fa-list-alt fw"></i><span class="text">UI Elements</span>
                            <i class="toggle-icon fa fa-angle-left"></i></a>
                            <ul class="sub-menu ">
                                <li ><a href="ui-elements-general.html"><span class="text">General Elements</span></a></li>
                                <li ><a href="ui-elements-buttons.html"><span class="text">Buttons <span class="badge element-bg-color-blue">Updated</span></span></a></li>
                                <li ><a href="ui-elements-icons.html"><span class="text">Icons</span></a></li>
                                <li ><a href="ui-elements-flash-message.html"><span class="text">Flash Message</span></a></li>
                            </ul>
                        </li>
                        <li ><a href="widgets.html"><i class="fa fa-puzzle-piece fa-fw"></i><span class="text">Widgets</span></a></li>
                        <li ><a href="#" class="js-sub-menu-toggle"><i class="fa fa-gears fw"></i><span class="text">Components</span>
                            <i class="toggle-icon fa fa-angle-left"></i></a>
                            <ul class="sub-menu ">
                                <li ><a href="components-wizard.html"><span class="text">Wizard (with validation)</span></a></li>
                                <li ><a href="components-calendar.html"><span class="text">Calendar</span></a></li>
                                <li ><a href="components-maps.html"><span class="text">Maps</span></a></li>
                                <li ><a href="components-gallery.html"><span class="text">Gallery</span></a></li>
                            </ul>
                        </li>
                        <li ><a href="#" class="js-sub-menu-toggle"><i class="fa fa-table fw"></i><span class="text">Tables</span>
                            <i class="toggle-icon fa fa-angle-left"></i></a>
                            <ul class="sub-menu ">
                                <li ><a href="tables-static-table.html"><span class="text">Static Table</span></a></li>
                                <li ><a href="tables-dynamic-table.html"><span class="text">Dynamic Table</span></a></li>
                            </ul>
                        </li>
                        <li ><a href="typography.html"><i class="fa fa-font fa-fw"></i><span class="text">Typography</span></a></li>
                    </ul>
                </nav><!-- /main-nav -->

                <div class="sidebar-minified js-toggle-minified">
                    <i class="fa fa-angle-left"></i>
                </div>

                <!-- sidebar content -->
                <div class="sidebar-content">
                    <div class="panel panel-default">
                        <div class="panel-heading"><h5><i class="fa fa-lightbulb-o"></i> Tips</h5></div>
                        <div class="panel-body">
                            <p>You can do live search to the widget at search box located at top bar. It's very useful if your dashboard is full of widget.</p>
                        </div>
                    </div>

                    <h5 class="label label-default"><i class="fa fa-info-circle"></i> Server Info</h5>
                    <ul class="list-unstyled list-info-sidebar bottom-30px">
                        <li class="data-row">
                            <span class="data-name">Disk Space Usage</span>
									<span class="data-value">
										274.43 / 2 GB
										<div class="progress progress-xs">
                                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100" style="width: 10%">
                                                <span class="sr-only">10%</span>
                                            </div>
                                        </div>
									</span>
                        </li>
                        <li class="data-row">
                            <span class="data-name">Monthly Bandwidth Transfer</span>
									<span class="data-value">
										230 / 500 GB
										<div class="progress progress-xs">
                                            <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="46" aria-valuemin="0" aria-valuemax="100" style="width: 46%">
                                                <span class="sr-only">46%</span>
                                            </div>
                                        </div>
									</span>
                        </li>
                        <li class="data-row">
                            <span class="data-name">Database Disk Space</span>
                            <span class="data-value">219.45 MB</span>
                        </li>
                        <li class="data-row">
                            <span class="data-name">Operating System</span>
                            <span class="data-value">Linux</span>
                        </li>
                        <li class="data-row">
                            <span class="data-name">Apache Version</span>
                            <span class="data-value">2.4.6</span>
                        </li>
                        <li class="data-row">
                            <span class="data-name">PHP Version</span>
                            <span class="data-value">5.3.27</span>
                        </li>
                        <li class="data-row">
                            <span class="data-name">MySQL Version</span>
                            <span class="data-value">5.5.34-cll</span>
                        </li>
                        <li class="data-row">
                            <span class="data-name">Architecture</span>
                            <span class="data-value">x86_64</span>
                        </li>
                    </ul>
                </div>
                <!-- end sidebar content -->
            </div>
            <!-- end left sidebar -->

            <!-- content-wrapper -->
            <div class="col-md-10 content-wrapper">


                <!-- main -->
                <div class="content">
                    <div class="main-header">
                        <h2>Items</h2>
                        <em>Choose and Trade!</em>
                    </div>

                    <div class="main-content">
                        <tiles:insertAttribute name="main" />
                    </div><!-- /main-content -->
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
<script src="${pageContext.request.contextPath}/resources/demo-style-switcher/assets/js/deliswitch.js"></script>

<!-- Application Domain scripts -->
<%--<script type="text/javascript"  id="tmp2" src="${pageContext.request.contextPath}/resources/application/category.js"></script>--%>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/application/appscript.js"></script>
<script src="${pageContext.request.contextPath}/resources/application/tour.js"></script>

</body>
</html>
