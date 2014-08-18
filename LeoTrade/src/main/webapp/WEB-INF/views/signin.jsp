<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<tiles:insertDefinition name="logintemplate">
	<tiles:putAttribute name="header">
		<link href="${pageContext.request.contextPath}/resources/semanticui/css/semantic.css" rel="stylesheet">  
		
		<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places"></script>
		<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/application/autocompleteapi.js"></script>
		
		<style>
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
							<img src="${pageContext.request.contextPath}/resources/img/header-bg.jpg"  alt="slider-1"  data-bgfit="cover" data-bgposition="center bottom" data-bgrepeat="no-repeat">
							<!-- LAYERS -->

							<!-- LAYER White Line -->
							<div class="tp-caption customout white-line-t"
								data-x="center"
								data-y="top"
								data-speed="25"
								data-start="0"
								data-easing="Power4.easeOut"
								data-captionhidden="on"
								><div class="line"></div>
							</div>
							<!-- LAYER White Line -->
							<div class="tp-caption customout white-line-b"
								data-x="center"
								data-y="bottom"
								data-speed="25"
								data-start="0"
								data-easing="Power4.easeOut"
								data-captionhidden="on"
								><div class="line"></div>
							</div>
							
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
								><p class="upp" >Welcome to <b>TradeNow!</b></p>
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
								<img src="${pageContext.request.contextPath}/resources/img/rev_slider/ico-s-1.png" alt="">
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
								<img src="${pageContext.request.contextPath}/resources/img/rev_slider/ico-s-2.png" alt="">
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
								<img src="${pageContext.request.contextPath}/resources/img/rev_slider/ico-s-3.png" alt="">
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
								><p class="slide_text_hide_768" >Exchange your stuff with people arround world!</p>
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
			
			<div class="features-tools-header">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<h2 class="wow fadeIn">Let us introduce our best bartering app!</h2>
						</div>
					</div> <!-- and row -->
				</div> <!-- and container -->
			</div> <!-- and features-tools-header -->

			<div class="wow fadeIn features-tools-content">
				<div class="container">
					<div class="row">
						<div class="col-md-6 col-sm-6 col-xs-12 col-xs-small">
							<p class="wow fadeIn" data-wow-delay="0.8s">Trade-Now.ca is an online bartering system,
							focusing on making it easier for people to exchange their stuffs with other people. Our
							system provide the best user experience for managering your unwanted stuff in your backlog,
							browsing other users' stuffs which are posted on public wall, and user-to-user
							collaboration and transaction management.
							</p>

							<div class="features-list-block">
								<ul class="features-list features-list-left">
									<li class="wow fadeInUp">
										<i class="fa fa-angle-right"></i>Supports facebook signon
									</li>
									<li class="wow fadeInUp" data-wow-delay=".2s">
										<i class="fa fa-angle-right"></i>User friendly interface
									</li>
									<li class="wow fadeInUp" data-wow-delay=".4s">
										<i class="fa fa-angle-right"></i>All-In-One user collaboration,trading transaction interface
									</li>
									<li class="wow fadeInUp" data-wow-delay=".6s">
										<i class="fa fa-angle-right"></i>Easy to find the nearest users' posted items
									</li>
								</ul>

								
							</div>

						</div>
						<div class="col-md-6 col-sm-6 col-xs-12 col-xs-small">
							<div class="features-list-img wow fadeInRight" data-wow-delay=".8s">
								<img src="${pageContext.request.contextPath}/resources/img/shakehand.jpg" alt="">
							</div>
						</div>
					</div> <!-- and row -->
				</div> <!-- and container -->
			</div> <!-- and features-tools-content -->

		</section> <!-- and Features tools -->
		
		<section><!-- Tutorial -->

				<div class="container" id="section3">
					<div class="col-md-6 col-sm-6 col-xs-12 col-xs-small">				      
						<h2 class="wow fadeIn">Step One - Browse on public marketplace, and find out what you want to own </h2>
				      
				      <p class="wow fadeIn">
						  People has their own public backlog of stuffs that they want to throw away, and other people can view them
				      </p>
				      
				  	</div><!--/col-->
			 		<div class="row">
					  <div class="col-lg-10"><img class="wow fadeInRight" src="${pageContext.request.contextPath}/resources/img/tutorial/masonry.PNG" class="img-responsive"></div>
					</div>
					<div style="height:100px"></div>
				  	<div class="col-md-6 col-sm-6 col-xs-12 col-xs-small">
				      <h2 class="wow fadeIn">Step Two - Find what you can offer, and negotiate with others</h2>
				      
				      <p class="wow fadeIn">
						  Looks like you have choose to own that Xbox One! Now you can choose one of your belongings from your own backlog, and negotiate with the Xbox owner within our site
				      </p>    
				  	</div><!--/col-->
					 <div class="row">
					  <div class="col-lg-10"><img class="wow fadeInRight" src="${pageContext.request.contextPath}/resources/img/tutorial/letstrade.jpg" class="img-responsive"></div>
					</div>
					<div style="height:100px"></div>
					
				  	 <div class="col-md-6 col-sm-6 col-xs-12 col-xs-small">
				      <h2 class="wow fadeIn">Step Three - Negotiation about the delivery method on site</h2>
				      
				      <p class="wow fadeIn">
						 Ok! Now you have had the deal to trade Xbox One with your cool TV. Next, you can choose either delivery in-person or use commertial delivery/mailing services.
						</p>
						<p> 
						 Our system will keep track of every trade history and their user-defined delivery methods. Therefore don't worry if you feel been spamed. We have your back covered. 	 
				      </p>    
				  	</div><!--/col-->
					 <div class="row">
					  <div class="col-lg-10"><img class="wow fadeInRight" src="${pageContext.request.contextPath}/resources/img/tutorial/mailtype.jpg" class="img-responsive"></div>
					</div>	
										<div style="height:100px"></div>
					
				</div><!--/container-->
		</section><!-- and Tutorial -->
	</tiles:putAttribute>
</tiles:insertDefinition>