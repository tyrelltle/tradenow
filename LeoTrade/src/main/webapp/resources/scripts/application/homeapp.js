
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
		if(this.categoryList!=null && this.productList!=null)
			return;
		//init category list
		this.categoryList=new CategoryList();
		this.categoryListView=new CategoryListView({model:this.categoryList});
		this.categoryList.fetch({
			success:function(lis){
				$('.catlist').html(app.categoryListView.render().el);
			}
		});
		
		
		//init product list
		app.productList = new ProductList();
		if($('.searchtxt').val()!="")
			app.productList.addsearch($('.searchtxt').val());
		else if($('#catid').length>0)
			app.productList.makecategorize($('#catid').val());
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
						else if($('#catid').length>0)
							app.productList.makecategorize($('#catid').val());
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
					$('#prodlist').show();
					app.msnry= new Masonry( app.container,{itemSelector: '.masonryitem'});
					app.msnry.layout();
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
		this.product=this.productList.get(prod_id);
		this.productView=new ProductView({model:this.product});
		$('.modal-bodyy').html(this.productView.render().el);
		$('#myModal').on('shown.bs.modal', function(e){
			//load images
			app.container = document.querySelector('#imglis');
			iwait.showPleaseWait();
			app.msnry= new Masonry( app.container,{itemSelector: '.galimg',columnWidth: 200});
			imagesLoaded( app.container, function() {
				iwait.hidePleaseWait();
				app.msnry= new Masonry( app.container,{itemSelector: '.galimg',columnWidth: 200});
				app.msnry.layout();
				$("a[rel^='prettyPhoto']").prettyPhoto();
			});
		});
		
	},
});

	    
var app=new AppRouter();
Backbone.history.start();

