
//non route driven router, due to Spring controller
AppRouter=Backbone.Router.extend({
	initialize:function(){	
		
	},
	routes:{
		"":"prodlis",
		"proddetail:prod_id":"prodDetail"},
		
	initTab:function(){		$('#tab_prof').click();},

	prodlis:function(){
		
		//init category list
		this.categoryList=new CategoryList();
		this.categoryListView=new CategoryListView({model:this.categoryList});
		this.categoryList.fetch({
			success:function(lis){
				$('.catlist').html(app.categoryListView.render().el);
			}
		});
		
		
		//init product list
		this.productList = new ProductList();
		this.productListView = new ProductListView({model:this.productList});
		this.productList.fetch({

			success:function(productList){
				$('#prodlist').html(app.productListView.render().el);
				$('#loadmore').click(function(e){
					app.productList.addstart();
					app.productList.fetch({remove:false});
					
				});
				var container = document.querySelector('.masconrycontainer');
				var msnry;
				this.msnry= new Masonry( container,{isInitLayout: true});
				imagesLoaded( container, function() {
					msnry= new Masonry( container,{isInitLayout: true});
				
				});
			
			}
		});
	},

	prodDetail:function(prod_id){
		//display productView in popup modal
		$('#btn_trade').click(function(){document.location.href = 'tradepage/toprod/'+prod_id;});
		this.product=this.productList.get(prod_id);
		this.productView=new ProductView({model:this.product});
		$('.modal-body').html(this.productView.render().el);
	},
});

	    
var app=new AppRouter();
Backbone.history.start();

