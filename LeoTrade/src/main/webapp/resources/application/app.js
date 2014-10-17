
//non route driven router, due to Spring controller
AppRouter=Backbone.Router.extend({
	initialize:function(){	
		$('#tab_prof').click(function (e){
			app.navigate("",true);
		});
		$('#tab_prod').click(function (e){
			app.navigate("prodlis",true);	
		});
		$('#tab_trade').click(function (e){
			app.navigate("tradelis",true);
		});
	},
	routes:{
		"":"user",
		"tradelis":"tradelis",
		"prodlis":"prodlis",
		"proddetail:prod_id":"prodDetail",
		"newprod":"newProd"},
		
	initTab:function(){		$('#tab_prof').click();},

//	user:function(productid){
	user:function(productid){
		app.profile = new Profile();
		app.profileView = new ProfileView({model:app.profile});
		
		app.profile.fetch({
			success:function(model){
				$('#profile_detail').html(app.profileView.render().el);
				 initializeAutocomplete();
			}
		});
	},
	tradelis:function(){
		$('#tradelist').empty();
		this.tradeList = new TradeList();
		this.tradeListView = new TradeListView({model:this.tradeList});
		this.tradeList.fetch({
			success:function(tradeList){
				$('#tradelist').html(app.tradeListView.render().el);
			
			}
		});
	},
	prodlis:function(){
		$('#tab_prod').tab('show');
		$('#newbtn').click(function(e){
			app.navigate("newprod",true);
		});
		
		this.productList = new ProductList();
		this.productListView = new ProductListView({model:this.productList});
		this.productList.fetch({
			success:function(productList){
				$('#prodlist').html(app.productListView.render().el);
			
			}
		});
	},
	prodDetail:function(prod_id){
		//display productView in popup modal
		this.product=this.productList.get(prod_id);
		this.productView=new ProductView({model:this.product});
		$('.modal-bodyy').html(this.productView.render().el);
	},
	newProd:function(){
		//display productView in popup modal
		var prod = new Product();
		this.productView=new ProductView({model:prod});
		$('.modal-bodyy').html(this.productView.render().el);
	}
	
	
});
var app=new AppRouter();

$(document).ready(function ()
	    { 

	Backbone.history.start();
	    });

	    

//app.initTab();
//app.initTab();


//TODO make iframe a template of a new view. append the view into EventDetailView, meanwhile, pass EventDetailView to the new view which then
//$(ifram).load(eventDetailView.deleteNewView())

