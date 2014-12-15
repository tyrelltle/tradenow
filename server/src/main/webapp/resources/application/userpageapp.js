
//non route driven router, due to Spring controller
AppRouter=Backbone.Router.extend({
	initialize:function(){	

	},
	routes:{
		"":"user",
		"proddetail:prod_id":"prodDetail"},

	user:function(){
		app.profile = new Profile();
		var uid=$('#userid').val();
		app.profile.set({"userid":uid});
		app.profileView = new ProfileView({model:app.profile});
		
		app.profile.fetch({
			success:function(model){
				$('#profile_detail').html(app.profileView.render().el);
                //render header username
                headertmp=_.template($('#headertmp').html());
                $('.main-header').html(headertmp(app.profile.toJSON()));
			}
		});
		
		
		//init product list
		app.productList = new ProductList();
		app.productList.makeprivate($('#userid').val());
		app.productListView = new ProductListView({model:app.productList});
		app.productList.fetch({

			success:function(productList){
				$('#prodlist').html(app.productListView.render().el);
				$('#loadmore').click(function(e){
					app.productList.addstart();	
					app.productList.makeprivate($('#userid').val());
					app.productList.fetch({remove:false});
					
				});
				iwait.showPleaseWait();
				app.container = document.querySelector('.masonrycontainer');
				app.msnry= new Masonry( app.container,{itemSelector: '.masonryitem'});
				imagesLoaded( app.container, function() {
					iwait.hidePleaseWait();
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
		$('#btn_trade').click(function(){document.location.href = ctx+'tradepage/toprod/'+prod_id;});
		app.product=app.productList.get(prod_id);
		app.productView=new ProductView({model:app.product});
		$('.modal-bodyy').html(app.productView.render().el);
		
	},

	
});

var app=new AppRouter();
Backbone.history.start();


