<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<tiles:insertDefinition name="logintemplate">
    <tiles:putAttribute name="header">
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places"></script>
        <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/landingpage_assets/js/application/autocompleteapi.js"></script>

        <style>
            .logincontainer{
                margin-top:100px;

            }

        </style>

    </tiles:putAttribute>

    <tiles:putAttribute name="left">
        <div></div>
    </tiles:putAttribute>
    <tiles:putAttribute name="main">
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="translatee panel-title" data-i18n="signin.Sign In">Sign In</div>
                    <div style="float:right; font-size: 80%; position: relative; top:-10px">
                        <a href="#" onClick="$('#loginbox').hide(); $('#resetpwdbox').show()" class="translatee" data-i18n="signin.forgot">
                            forgot your password?
                        </a>
                    </div>
                </div>
                <div style="padding-top: 30px" class="panel-body">
                    <form  class="form-horizontal" id="regform" method="POST" action="${pageContext.request.contextPath}/j_spring_security_check" >
                        <div class="input-group" style="margin-bottom: 25px">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input type="text" class="translatee form-control" name="username" data-i18n="[placeholder]signin.email" placeholder="Email"/>
                        </div>
                        <div class="input-group" style="margin-bottom: 25px">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input type="password" class="translatee form-control" name="password" data-i18n="[placeholder]signin.password" placeholder="Password"/>
                        </div>
                        <div class="input-group">
                            <div class="checkbox">
                                <label>
                                    <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
                                </label>
                            </div>
                        </div>
                        <div style="margin-top:10px" class="form-group">
                            <div class="col-sm-12 controls">
                                <button class="translatee btn btn-success" type="submit" data-i18n="signin.signin">Sign In</button>
                                <a id="btn-fblogin" href="#" class="btn btn-primary">Login with Facebook</a>
                            </div>
                            <span><a href="#">${errorlogin}</a></span>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <c:if test="${not empty loginerror}">
                            <div class="alert alert-danger" role="alert">${loginerror}</div>
                        </c:if>

                        <div class="form-group">
                            <div class="col-md-12 control">
                                <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                    Don't have an account!
                                    <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                        Sign Up Here
                                    </a>
                                </div>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>

        <div id="resetpwdbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info">

                <div class="panel-heading">
                    <div class="panel-title" data-i18n="signin.forgot">Forgot password</div>
                    <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" class="translatee" data-i18n="signin.signin" onclick="$('#resetpwdbox').hide(); $('#loginbox').show()" >Sign In</a></div>
                </div>

                <div class="panel-body" >
                    <div class="form-group">
                        <div class="col-sm-12">
                            <h5 class="translatee ps_email" data-i18n="signin.sendemail">We will send you an email containing password reset information</h5>
                            <input type="text" class="translatee ps_email form-control" id="ps_email" data-i18n="[placeholder]signin.email" placeholder="Enter your email"/>
                            <button style="width:25%;margin-top:10px" id="btn_send_reset_email" class="ps_email btn btn-info">Send</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">

        <div class="panel-heading">
            <div class="panel-title">Sign Up</div>
            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" class="translatee" data-i18n="signin.signin" onclick="$('#signupbox').hide(); $('#loginbox').show()" >Sign In</a></div>
        </div>

        <div class="panel-body" >
            <form:form  class="form-horizontal" id="regform"  method="POST" commandName="userForm" action="nativeregister">

                <div class="form-group">
                    <label for="email" class="col-md-3 control-label">Email</label>
                    <div class="col-md-9">
                        <form:input type="text" class="translatee form-control" data-i18n="[placeholder]signin.email" path="email" placeholder="Email"/>
                        <form:errors path="email" cssclass="error"></form:errors>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="col-md-3 control-label">Password</label>
                    <div class="col-md-9">
                        <form:input type="password" class="translatee form-control" path="password" data-i18n="[placeholder]signin.password" placeholder="Password"/>
                        <form:errors path="password" cssclass="error"></form:errors>
                    </div>

                </div>

                <div class="form-group">
                    <label for="password" class="col-md-3 control-label">City</label>
                    <div class="col-md-9">
                        <form:input type="text" id="autocomplete" onFocus="geolocate()" class="translatee form-control" data-i18n="[placeholder]signin.loc"  path="location" placeholder="Please enter your City,Country"/>
                        <form:errors path="location" cssclass="error"></form:errors>

                        <form:input id="lat" type="hidden" class="form-control input-lg"  path="lat" />
                        <form:input id="lng" type="hidden" class="form-control input-lg" path="lng"  />
                    </div>

                </div>


                <script type="text/javascript">
                    initializeAutocomplete();
                    $("#regform").keypress(function(e){
                        if (e.which == 13) {
                            var tagName = e.target.tagName.toLowerCase();
                            if (tagName !== "textarea") {
                                return false;
                            }
                        }
                    });

                    $('#btn_send_reset_email').click(function(e){
                        var btn = $(this)
                        btn.button('loading');
                        $.ajax({
                            type: "POST",
                            url: ctx+"resetpassword/"+$('#ps_email').val()+"/"
                        })
                                .done(function( msg ) {
                                    btn.button('reset');
                                    alert(msg);
                                });
                        e.preventDefault();

                    });

                    <c:if test="${not empty forregister}">
                        $('#signupbox').show();
                        $('#loginbox').hide();
                    </c:if>

                </script>

                <div class="form-group">
                    <div class="col-md-offset-3 col-md-9">
                        <form:button class="translatee btn btn-info" type="submit" data-i18n="signin.signup"> Sign Up</form:button>
                        <c:if test="${not empty succ}">
                            <div class="alert alert-success" role="alert">${succ}</div>
                        </c:if>
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger" role="alert">${error}</div>
                        </c:if>

                    </div>
                </div>
            </form:form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>