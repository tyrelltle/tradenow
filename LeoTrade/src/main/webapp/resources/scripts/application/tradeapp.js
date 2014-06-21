
//non route driven router, due to Spring controller
AppRouter=Backbone.Router.extend({
	initialize:function(){	
		$('#choosebtn').click(function(){
			app.navigate("prodlis",true);
			
		});
	},
	routes:{
		"":"tradepage",
		"prodlis":"prodlis",
		"proddetail:prod_id":"prodDetail"},
	itemselected:0,
		
	tradepage:function(){
		if(this.itemselected!=undefined && this.itemselected == 1){
			this.itemselected=0;
			$('#leftprodpic').attr("src", "http://img0.bdstatic.com/img/image/shouye/dengni37.jpg");
		}
	},
	prodlis:function(){		
		
		//init product list
		app.productList = new ProductList();
		app.productListView = new ProductListView({model:this.productList});
		app.productList.melize();
		app.productList.fetch({
			
			success:function(productList){
				if(productList.length>0){
					
					$('#prodlist').html(app.productListView.render().el);
					$('#loadmore').click(function(e){
						app.productList.addstart();
						app.productList.melize();
						app.productList.fetch({remove:false});
						
					});
					$('#modelchoosebtn').click(function(e){
						app.itemselected=1;
						$('#prodlismodel').modal('hide');						
					
					});
					$('#prodlismodel').on('shown.bs.modal', function (e) {
						var container = document.querySelector('.masconrycontainer');
						var msnry;
						this.msnry= new Masonry( container,{isInitLayout: true});
						imagesLoaded( container, function() {
							

							msnry= new Masonry( container,{isInitLayout: true});
						});
					});
					$('#prodlismodel').on('hide.bs.modal', function (e) {
						app.navigate("",true);
					});
					$('#prodlismodel').modal({show:true});
					
				}else{
					$('#prodlist').append("Please add some item to your inventory!");
				}
				
			}
		});
	},

	prodDetail:function(prod_id){
		//display productView in popup modal
		//$('#btn_trade').click(function(){document.location.href = 'tradepage/toprod/'+prod_id;});
		app.product=this.productList.get(prod_id);
		app.productView=new ProductView({model:this.product});
		$('.proddetailcontent').html(app.productView.render().el);
	},
});

	    
var app=new AppRouter();
Backbone.history.start();

