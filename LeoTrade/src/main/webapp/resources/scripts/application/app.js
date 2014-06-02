
//non route driven router, due to Spring controller
AppRouter=Backbone.Router.extend({
	initialize:function(){	
		$('#tab_prof').click(this.user);
		$('#tab_prod').click(function (e){
			app.navigate("prodlis",true);
		});
	},
	routes:{
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
			}
		});
	},
	prodlis:function(){
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
		$('.modal-body').html(this.productView.render().el);
	},
	newProd:function(){
		//display productView in popup modal
		var prod = new Product();
		this.productView=new ProductView({model:prod});
		$('.modal-body').html(this.productView.render().el);
	}
	
	
});

$(document).ready(function ()
	    { 

			_.templateSettings = {
				    interpolate: /\{\{(.+?)\}\}/gim,
				    evaluate: /\{\{(.+?)\}\}/gim,
				    escape: /\{\{\-(.+?)\}\}/gim
				};
	    });

	    
var app=new AppRouter();
Backbone.history.start();
//app.initTab();
//app.initTab();


//TODO make iframe a template of a new view. append the view into EventDetailView, meanwhile, pass EventDetailView to the new view which then
//$(ifram).load(eventDetailView.deleteNewView())

