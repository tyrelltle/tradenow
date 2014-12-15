<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>



<tiles:insertDefinition name="newbietemplate">
    <tiles:putAttribute name="header">

        <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/landingpage_assets/js/masonry.pkgd.js"></script>
        <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/landingpage_assets/js/imagesloaded.pkgd.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places"></script>
        <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/application/autocompleteapi.js"></script>

        <style type="text/css">

            .detailsglyph{
                float:right;
                margin-top:50px;
            }
            #profile_detail{
                padding-top: 45px;
                padding-bottom: 45px;
            }

        </style>
    </tiles:putAttribute>

    <tiles:putAttribute name="left">
        <div></div>
    </tiles:putAttribute>
    <tiles:putAttribute name="main">
        <div class="main-content">
            <div class="main-header" style="margin-bottom: 20px">
                <h2 class="translatee" data-i18n="profile.complete">Complete your profile</h2>
                <em class="translatee" data-i18n="profile.welcome">Wherecome! Please update your profile</em>
            </div>
            <div class="container">
                <div  class="row">

                    <div id="profile_detail">

                    </div>


                </div>
            </div>
        </div>
        <!--start bootstrap templates-->
        <script type="text/template" id="usertmp">
            <div class="row">
                <div class="col-md-3">
                    <div class="user-info-left">
                        <h2 class="translatee" data-i18n="profile.photo">Your Profile Photo</h2>
                            <span id="span_uimg">
                                <img style="max-width: 300px;" class="prodpic" src="${pageContext.request.contextPath}/user/img/userid/{{userid}}" alt="Profile Picture">
                            </span>
                        <div class="contact" id="imgform">
                            <form id="imgsubmit" method="post" enctype="multipart/form-data">
                                <td><input class="btn btn-block" type="file" id="img_input" name="file" />
                                <td><input class="btn btn-block btn-custom-secondary" type="submit" value="Upload" />
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="user-info-right">
                        <form class="form-horizontal" role="form">
                            <fieldset>
                                <legend>User Information</legend>

                                <div class="form-group">
                                    <label class="translatee col-sm-2 control-label" data-i18n="profile.email">Email</label>
                                    <div class="col-sm-9">
                                        <input type="email" class="form-control" id="email" value="{{email}}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label translatee" data-i18n="profile.firstname">First Name</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" id="fn" value="{{firstname}}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label translatee" data-i18n="profile.lastname">Last Name</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" id="ln" value="{{lastname}}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label translatee" data-i18n="profile.city">Your City</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" id="autocomplete" onFocus="geolocate()" placeholder="Please enter your City,Country" value="{{location}}">
                                        <input id="lat" type="hidden" value="{{lat}}" />
                                        <input id="lng" type="hidden" value="{{lng}}"/>
                                    </div>
                                </div>


                                <legend class="translatee" data-i18n="profile.about">About You</legend>

                                <div class="form-group">
                                    <div class="col-sm-9">
                                        <textarea id="txt_aboutme" class="form-control" name="ticket-message" rows="5" cols="30" placeholder="Lets introduce yourself...">{{aboutme}}</textarea>
                                    </div>
                                </div>
                                <input class="btn btn-primary" value="submit" id="submit"/>

                            </fieldset>

                        </form>

                    </div>
                </div>
                <div class="col-md-3">
                    <a id="continue" href="#"><h3 style="margin-top:100px"><i class="glyphicon glyphicon-forward"></i><span id="continuetxt" class="translatee" data-i18n="profile.continue">Continue to the site</span></h3></a>
                </div>
            </div>
        </script>


        <!--end bootstrap templates-->
        <!--start bootstrap dependencies-->
        <script type="text/javascript" id="tmp" src="${pageContext.request.contextPath}/resources/application/profile.js"></script>
        <script type="text/javascript"  id="tmp2" src="${pageContext.request.contextPath}/resources/application/newbieapp.js"></script>
        <!--end bootstrap dependencies-->

    </tiles:putAttribute>
</tiles:insertDefinition>
