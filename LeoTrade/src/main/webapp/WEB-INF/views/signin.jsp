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
								><p class="upp">Welcome to <b>all in one</b></p>
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
								><p class="slide_text_hide_768">SEO-optimised, valid HTML5 code, WooCommerce, <br>WPML, page builder, fully customizible design</p>
							</div>

							<!-- LAYER 6 -->
							<div class="tp-caption sfl customout hidden-xs layer-6"
								data-x="104"
								data-y="380"
								data-customin="x:-200;y:0;z:;rotationX:0;rotationY:;rotationZ:0;scaleX:1;scaleY:1;skewX:0;skewY:0;opacity:1;transformPerspective:300;transformOrigin:0% 0%;"
								data-customout="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0.75;scaleY:0.75;skewX:0;skewY:0;opacity:0;transformOrigin:50% 50%;"
								data-speed="1200"
								data-start="300"
								data-easing="Power4.easeOut"
								data-endspeed="700"
								data-endeasing="Power1.easeIn"
								data-captionhidden="on"
								><a class="button-green upp">buy now</a>
							</div>

							

						</li>





						<!-- SLIDE 3 -->

						
					</ul>
					<div class="tp-bannertimer"></div>
				</div>
			</div>

		</section> <!-- and Slider -->
	</tiles:putAttribute>
</tiles:insertDefinition>