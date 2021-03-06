
//non route driven router, due to Spring controller
AppRouter=Backbone.Router.extend({
	initialize:function(){	
		
	},
	routes:{
		"#_=_":"gotohome",
		"":"prodlis",
		"proddetail:prod_id":"prodDetail"},
		
	initTab:function(){		$('#tab_prof').click();},
	gotohome:function(){
		app.navigate("",true);
	},
	prodlis:function(){

		
		
		//init product list
		app.productList = new ProductList();
		if($('.searchtxt').length>0 &&$('.searchtxt').val()!=""){
			app.productList.addsearch($('.searchtxt').val());
			$('.searchtxt').attr("class","searchtxt form-control").addClass("likesbtn_cur");
		}
		else if ($('.locsearchtxt').length > 0 && $('.locsearchtxt').val()!=""){
			app.productList.addlocsearch($('.locsearchtxt').val());
			$('.locsearchtxt').attr("class","locsearchtxt form-control").addClass("likesbtn_cur");
		}
		else if($('#catid').length>0){
			app.productList.makecategorize($('#catid').val());
			$('.catmenu-active').attr("class","catmenu-active").addClass("likesbtn_cur");
		}
		else if($('#likes').length>0){
			app.productList.favorilize();
			$('.likesbtn').attr("class","likesbtn_cur");
		}
		app.productListView = new ProductListView({model:app.productList});
		app.productList.fetch({

			success:function(productList){
				$('#prodlist').html(app.productListView.render().el);
				$('#prodlist').hide();
			    $(window).scroll(function () {
			        if ($(document).height() <= $(window).scrollTop() + $(window).height()) {
			        	app.productList.addstart();
						if($('.searchtxt').val()!="")
							app.productList.addsearch($('.searchtxt').val());
						else if ($('.locsearchtxt').val()!="")
							app.productList.addlocsearch($('.locsearchtxt').val());
						else if($('#catid').length>0)
							app.productList.makecategorize($('#catid').val());
						else if($('#likes').length>0)
							return;//likes list is always full list not chuncated into pages
						var loadmore=document.getElementById('loadmore');
						app.spinner = new Spinner(optsloadmore).spin(loadmore);
						app.productList.fetch({remove:false,success:function(){
							$('#loadmore').empty();
							app.spinner.stop();
						}});
						
			        }
			    });
				
				iwait.showPleaseWait();
				app.container = document.querySelector('.masonrycontainer');
				app.msnry= new Masonry( app.container,{itemSelector: '.masonryitem'});
				imagesLoaded( app.container, function() {
					iwait.hidePleaseWait();
					TourManager.startHomeTour(false);
					$('#prodlist').show();
					app.msnry= new Masonry( app.container,{itemSelector: '.masonryitem'});
					app.msnry.layout();
					$('#slide').click();

				});
			
			}
		});
	},

	prodDetail:function(prod_id){
		//display productView in popup modal
		if($('#myModal').modal == undefined)
			app.navigate("",true);
		
		$('#myModal').modal({show:true});
		$('#myModal').on('hide.bs.modal', function (e) {
			app.navigate("",true);
		});
		$('#btn_trade').click(function(){document.location.href = 'tradepage/toprod/'+prod_id;});
		
		//$('#myModal').on('shown.bs.modal', function(e){
			app.product=app.productList.get(prod_id);
			app.productView=new ProductView({model:app.product});
			$('.modal-bodyy').html(app.productView.render().el);

	}
});

	    
var app=new AppRouter();
Backbone.history.start();

