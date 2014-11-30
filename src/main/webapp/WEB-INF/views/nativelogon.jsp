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
        <div class="main-content">
            <div class="main-header">
                <h2 class="translatee" data-i18n="signin.signup">Signup</h2>
                <em class="translatee" data-i18n="signin.withemail">Logon with your email</em>
            </div>
            <section style="margin-top: 30px;">
                <div class="blog">
                    <div class="container">
                        <div class="row">


                            <div class="col-md-6">
                                <div class="widget">
                                    <div class="widget-header"><h3><i class="fa fa-edit"></i><span class="translatee" data-i18n="signin.existing">Login with existing account</span></h3></div>
                                    <div class="widget-content">
                                        <form  class="form-horizontal" id="regform" method="POST" action="${pageContext.request.contextPath}/j_spring_security_check" >
                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                    <input type="text" class="translatee form-control" name="username" data-i18n="[placeholder]signin.email" placeholder="Email"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                    <input type="password" class="translatee form-control" name="password" data-i18n="[placeholder]signin.password" placeholder="Password"/>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                    <button class="translatee btn btn-primary" type="submit" data-i18n="signin.signin">Sign In</button>
                                                </div>
                                                <span><a href="#">${errorlogin}</a></span>

                                            </div>
                                            <div>
                                                <a href="#" onclick="$('.ps_email').show();"><h4 class="translatee" data-i18n="signin.forgot">Forgot Password</h4></a>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <h5 class="translatee ps_email" style="display:none" data-i18n="signin.sendemail">We will send you an email containing password reset information</h5>

                                                        <input type="text" style="display:none" class="translatee ps_email form-control" id="ps_email" data-i18n="[placeholder]signin.email" placeholder="Enter your email"/>

                                                        <button style="display:none;width:25%" id="btn_send_reset_email" class="ps_email btn btn-primary">Send</button>
                                                    </div>
                                                </div>
                                            </div>

                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                            <c:if test="${not empty loginerror}">
                                                <div class="alert alert-danger" role="alert">${loginerror}</div>
                                            </c:if>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="widget">
                                    <div class="widget-header"><h3><i class="fa fa-edit"></i><span class="translatee" data-i18n="signin.newacc">Register new account</span></h3></div>
                                    <div class="widget-content">
                                        <form:form  class="form-horizontal" id="regform"  method="POST" commandName="userForm" action="nativeregister">

                                        <div class="form-group">
                                            <div class="col-sm-12">
                                                <form:input type="text" class="translatee form-control" data-i18n="[placeholder]signin.email" path="email" placeholder="Email"/>
                                                <form:errors path="email" cssclass="error"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-12">
                                                <form:input type="text" class="translatee form-control" path="firstname" data-i18n="[placeholder]signin.firstname" placeholder="First name"/>
                                                <form:errors path="firstname" cssclass="error"></form:errors>
                                            </div>

                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-12">
                                                <form:input type="text" class="translatee form-control" path="lastname" data-i18n="[placeholder]signin.lastname" placeholder="Last name"/>
                                                <form:errors path="lastname" cssclass="error"></form:errors>
                                            </div>

                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-12">
                                                <form:input type="password" class="translatee form-control" path="password" data-i18n="[placeholder]signin.password" placeholder="Password"/>
                                                <form:errors path="password" cssclass="error"></form:errors>
                                            </div>

                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-12">
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
                                                var btn = $(this);
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

                                        </script>
                                        <div class="form-group">
                                            <div class="col-sm-12">
                                                <form:button class="translatee btn btn-primary" type="submit" data-i18n="signin.register">Register</form:button>
                                                <c:if test="${not empty succ}">
                                                    <div class="alert alert-success" role="alert">${succ}</div>
                                                </c:if>
                                                <c:if test="${not empty error}">
                                                    <div class="alert alert-danger" role="alert">${error}</div>
                                                </c:if>
                                                </form:form>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="logincontainer container">
                                        <div class="row">


                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>