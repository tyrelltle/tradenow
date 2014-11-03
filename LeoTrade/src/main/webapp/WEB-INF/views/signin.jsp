<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<tiles:insertDefinition name="logintemplate">
	<tiles:putAttribute name="header">
		<link href="${pageContext.request.contextPath}/resources/landingpage_assets/semanticui/css/semantic.css" rel="stylesheet">  
		
		<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places"></script>
		<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/landingpage_assets/js/application/autocompleteapi.js"></script>
		
		<style>
		.letestrade{
		width:100%;
		}
		.step{
		margin-top:56px;
		}
		.logincontainer{
		 margin-top:100px; 
		  
		}
		
		</style>

	</tiles:putAttribute>
		<tiles:putAttribute name="pagetitle">
	</tiles:putAttribute>
	<tiles:putAttribute name="left">
			  <div></div>	
	</tiles:putAttribute>
	
	<tiles:putAttribute name="main">
				<!-- Slider -->
		<section class="slider-1">
			
			<div class="tp-banner-container">
				<div class="tp-banner cursor-move" >
					<ul>

						<!-- SLIDE 1 -->
						<li id="pad" data-transition="fade" data-slotamount="3" data-masterspeed="1500" class="slide-1">
							<!-- MAIN IMAGE -->
							<img src="${pageContext.request.contextPath}/resources/landingpage_assets/img/header-bg.jpg"  alt="slider-1"  data-bgfit="cover" data-bgposition="center bottom" data-bgrepeat="no-repeat">
							<!-- LAYERS -->

							
							
							<!-- LAYER 1 -->
							<div class="tp-caption sfl customout layer-1"
								data-x="104"
								data-y="265"
								data-customout="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0.75;scaleY:0.75;skewX:0;skewY:0;opacity:0;transformOrigin:50% 50%;"
								data-speed="2500"
								data-start="250"
								data-easing="Power4.easeOut"
								data-endspeed="900"
								data-endeasing="Power1.easeIn"
								data-captionhidden="on"
								><p class="upp" ><span data-i18n="signin.welcome" class="translatee">Welcome to </span><b data-i18n="signin.barbarian" class="translatee">Barbarian Network!</b></p>
							</div>

							<!-- LAYER 2 -->
							<div class="tp-caption lft customout"
								data-x="104"
								data-y="180"
								data-customout="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0.75;scaleY:0.75;skewX:0;skewY:0;opacity:0;transformOrigin:50% 50%;"
								data-speed="600"
								data-start="1500"
								data-easing="Power4.easeOut"
								data-endspeed="800"
								data-endeasing="Power1.easeIn"
								data-captionhidden="on"
								>
								<img src="${pageContext.request.contextPath}/resources/landingpage_assets/img/rev_slider/ico-s-1.png" alt="">
							</div>

							<!-- LAYER 3 -->
							<div class="tp-caption lft customout"
								data-x="174"
								data-y="180"
								data-customout="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0.75;scaleY:0.75;skewX:0;skewY:0;opacity:0;transformOrigin:50% 50%;"
								data-speed="800"
								data-start="1500"
								data-easing="Power4.easeOut"
								data-endspeed="300"
								data-endeasing="Power1.easeIn"
								data-captionhidden="on"
								>
								<img src="${pageContext.request.contextPath}/resources/landingpage_assets/img/rev_slider/ico-s-2.png" alt="">
							</div>

							<!-- LAYER 4 -->
							<div class="tp-caption lft customout"
								data-x="244"
								data-y="180"
								data-customout="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0.75;scaleY:0.75;skewX:0;skewY:0;opacity:0;transformOrigin:50% 50%;"
								data-speed="1000"
								data-start="1500"
								data-easing="Power4.easeOut"
								data-endspeed="200"
								data-endeasing="Power1.easeIn"
								data-captionhidden="on"
								>
								<img src="${pageContext.request.contextPath}/resources/landingpage_assets/img/rev_slider/ico-s-3.png" alt="">
							</div>

							<!-- LAYER 5 -->
							<div class="tp-caption sfr customout layer-5"
								data-x="104"
								data-y="310"
								data-customout="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0.75;scaleY:0.75;skewX:0;skewY:0;opacity:0;transformOrigin:50% 50%;"
								data-speed="1200"
								data-start="250"
								data-easing="Power4.easeOut"
								data-endspeed="500"
								data-endeasing="Power1.easeIn"
								data-captionhidden="on"
								><p data-i18n="signin.gobackstone" class="translatee slide_text_hide_768" >Wanna go back to the old age when there was no concept of currency?</p>
							</div>

							<!-- LAYER 7 -->
							<div class="tp-caption sfr start"
								data-endspeed="300"
								data-easing="Back.easeOut"
								data-customout="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0.75;scaleY:0.75;skewX:0;skewY:0;opacity:0;transformOrigin:50% 50%;"
								data-start="150"
								data-speed="600"
								data-x="600"
								data-y="0">
							<img src="${pageContext.request.contextPath}/resources/landingpage_assets/img/logo/logo.png" alt="">
							</div>

						</li>





						<!-- SLIDE 3 -->

						
					</ul>
					<div class="tp-bannertimer"></div>
				</div>
			</div>

		</section> <!-- and Slider -->
		
		
		
				<!-- Features tools -->
		<section>
			
	

			<div class="wow fadeIn features-tools-content">
				<div class="container">
					<div class="row">
						<div class="col-md-6 col-sm-6 col-xs-12 col-xs-small">
							<h2 class="translatee wow fadeIn" data-i18n="signin.intro_best">Let us introduce our best bartering app!</h2>
						
							<p class="translatee wow fadeIn" data-wow-delay="0.8s" data-i18n="signin.intro_best_long">Trade-Now.ca is an online bartering system,
							focusing on making it easier for people to exchange their stuffs with other people. Our
							system provide the best user experience for managering your unwanted stuff in your backlog,
							browsing other users' stuffs which are posted on public wall, and user-to-user
							collaboration and transaction management.
							</p>

							<div class="features-list-block">
								<ul class="features-list features-list-left">
									<li class="wow fadeInUp">
										<i class="fa fa-angle-right"></i><span class="translatee"  data-i18n="signin.fb_support">Supports facebook signon</span>
									</li>
									<li class="wow fadeInUp" data-wow-delay=".2s">
										<i class="fa fa-angle-right"></i><span class="translatee" data-i18n="signin.userfriendly">User friendly interface</span>
									</li>
									<li class="wow fadeInUp" data-wow-delay=".4s">
										<i class="fa fa-angle-right"></i><span class="translatee" data-i18n="signin.allinone">All-In-One user collaboration,trading transaction interface</span>
									</li>
									<li class="wow fadeInUp" data-wow-delay=".6s">
										<i class="fa fa-angle-right"></i><span class="translatee" data-i18n="signin.easyneaest">Easy to find the nearest users' posted items</span>
									</li>
								</ul>

								
							</div>

						</div>
						<div class="col-md-6 col-sm-6 col-xs-12 col-xs-small">
							<div class="features-list-img wow fadeInRight" data-wow-delay=".8s">
								<img src="${pageContext.request.contextPath}/resources/landingpage_assets/img/shakehand.jpg" style="width: 441px;" alt="">
							</div>
						</div>
					</div> <!-- and row -->
				</div> <!-- and container -->
			</div> <!-- and features-tools-content -->

		</section> <!-- and Features tools -->
		
		<section><!-- Tutorial -->

				<div class="container" id="section3">
				<!-- Step One -->
				
					<div class="col-md-12 col-sm-12 col-xs-12 col-xs-small">				      
						<h2 class="translatee wow fadeIn" data-i18n="signin.stepone">Step One - Browse on public marketplace, and find out what you want to own </h2>
				      
				      <p class="translatee wow fadeIn" data-i18n="signin.steponee">
						  People has their own public backlog of stuffs that they want to throw away, and other people can view them
				      </p>
				      
							<div class="masonrycontainer" style="position: relative;">
							<div class="masonryitem col-md-3">
								<div class="blog-item">
									<img alt="" class="btn_detail" src="${pageContext.request.contextPath}/resources/landingpage_assets/img/featured-projects/p1.jpg">
									<div class="blog-item-description">
										<h3>Nice XBOX</h3>
										<div class="row">
											<div class="col-md-4">
												<a><img style="width:50px;border-radius: 12px;" src="${pageContext.request.contextPath}/resources/landingpage_assets/img/defaultusericon.png"></a>
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
												<a><img style="width:50px;border-radius: 12px;" src="${pageContext.request.contextPath}/resources/landingpage_assets/img/defaultusericon.png"></a>
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
												<a><img style="width:50px;border-radius: 12px;" src="${pageContext.request.contextPath}/resources/landingpage_assets/img/defaultusericon.png"></a>
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
												<a><img style="width:50px;border-radius: 12px;" src="${pageContext.request.contextPath}/resources/landingpage_assets/img/defaultusericon.png"></a>
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
				<!-- and Step One -->	
				<!-- Step Two -->
				  	<div class="step col-md-12 col-sm-12 col-xs-12 col-xs-small">
				      <h2 class="translatee wow fadeIn" data-i18n="signin.steptwo">Step Two - Find what you can offer, and negotiate with others</h2>
				      
				      <p class="translatee wow fadeIn" data-i18n="signin.steptwoo">
						  Looks like you have choose to own that Xbox One! Now you can choose one of your belongings from your own backlog, and negotiate with the Xbox owner within our site
				      </p>    
				  	</div><!--/col-->
					 <div class="row">
					  <div class="col-lg-10"><img class="letestrade wow fadeInRight" src="${pageContext.request.contextPath}/resources/landingpage_assets/img/tutorial/letstrade.jpg" class="img-responsive"></div>
					</div> 
			     <!-- and Step Two -->
			     <!-- Step Three -->
				  	 <div class="step col-md-12 col-sm-12 col-xs-12 col-xs-small">
				      <h2 class="translatee wow fadeIn" data-i18n="signin.stepthree">Step Three - Negotiation about the delivery method on site</h2>
				      
				      <p class="translatee wow fadeIn" data-i18n="signin.stepthreee">
						 Ok! Now you have had the deal to trade Xbox One with your cool TV. Next, you can choose either delivery in-person or use commertial delivery/mailing services.
						</p>
						<p class="translatee" data-i18n="signin.stepthreeee">
						 Our system will keep track of every trade history and their user-defined delivery methods. Therefore don't worry if you feel been spamed. We have your back covered. 	 
				      </p>    
				  	</div><!--/col-->
					 <div class="row">
					  <div class="col-lg-10"><img class="wow fadeInRight" src="${pageContext.request.contextPath}/resources/landingpage_assets/img/tutorial/mailtype.jpg" class="img-responsive"></div>
					</div>	
										<div style="height:100px"></div>
				<!-- and Step Three -->
					
				</div><!--/container-->
				</div>
		</section><!-- and Tutorial -->
</tiles:putAttribute>
</tiles:insertDefinition>