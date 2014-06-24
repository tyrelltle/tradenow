

Product=Backbone.Model.extend({
	defaults:{"prod_id":null,"userid":0,"catid":0,"title":"",
			  "detail":"", "price":0,"quantity":0,"status":"","tradefor":"","thumurl":""},
	urlRoot:"api/product",
	idAttribute: "prod_id"
		
});

ProductList=Backbone.Collection.extend({
	model:Product,
	start: 0,
	offset:5,
	initialize:function(){
		
		this.url=ctx+"api/product/start/0/count/"+this.offset;
	},
	
	addstart:function(){
		this.start+=this.offset;
		this.url=ctx+"api/product/start/"+this.start+"/count/"+this.offset;

	},
	melize:function(){
		//make the model fetch only my products
		this.url=this.url+"/me";
	}
});



ProductListView=Backbone.View.extend({
	columnnum: 3,
	initialize:function(){
		_.templateSettings = {
			    interpolate: /\{\{(.+?)\}\}/gim,
			    evaluate: /\{\{(.+?)\}\}/gim,
			    escape: /\{\{\-(.+?)\}\}/gim
			};
		//this.template=_.template($('#prodListTmp').html());
		var self=this;
		this.model.bind("create",function(e){
			$(self.el).append(new ProductListItemView({model:e}).render().el);
			
		});
		this.model.bind("add",function(e){
			var newelm=new ProductListItemView({model:e}).render().el;
			$(self.el).find('.masconrycontainer').append(newelm);
			if($('.masconrycontainer').length>0){
				var container = document.querySelector('.masconrycontainer');
				var msnry;
				msnry= new Masonry(container);
				msnry.appended([newelm]);
				msnry.layout();
				imagesLoaded( container, function() {
					msnry.layout();
				
				});
			}
		});
		this.template=_.template($("#prodlisttmp").html());
	},
	
	render:function(){
		var self=this;
		$(this.el).html(this.template());
		_.each(this.model.models,function(m){
			$(self.el).find('.masconrycontainer').append(new ProductListItemView({model:m}).render().el);
		});
		
		return this;
		
	},
	close: function(){
		$(this.el).unbind();
		$(this.el).remove();
	}
	
});


ProductListItemView=Backbone.View.extend({
	initialize:function(){
		_.templateSettings = {
			    interpolate: /\{\{(.+?)\}\}/gim,
			    evaluate: /\{\{(.+?)\}\}/gim,
			    escape: /\{\{\-(.+?)\}\}/gim
			};
		this.template=_.template($("#prodlistitemtmp").html());
	},
	
	className:".masconryitem",
	events:{"click .btn_detail":"clicked",
			"click .btn_select":"selected"},
	
	clicked:function(){
		app.navigate("proddetail"+this.model.get("prod_id"),true);
		
	},
	selected:function(){
		app.navigate("prodselected"+this.model.get("prod_id"),true);
	},
	render:function(){
		var json={title:this.model.get("title"),
				  thumurl:this.model.get("thumurl")};
		$(this.el).html(this.template(json));
		return this;
	},
	close:function(){
		$(this.el).unbind();
		$(this.el).remove();
	}
	
});


