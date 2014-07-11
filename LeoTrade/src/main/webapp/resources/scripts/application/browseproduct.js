

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
	makeprivate:function(userid){
		//make the model fetch only my products
		this.url=this.url+"/ownerid/"+userid;
	},
	makecategorize:function(catid){
		this.url=this.url+"/catid/"+catid;

	}
});

Imagee = Backbone.Model.extend({
	defaults:{"img_Id":0,"url":"","fuckyou":"fuckyou"},
	urlRoot:"api/product/img/",
	//idAttribute:"img_id",

});
ImageList = Backbone.Collection.extend({
	model:Imagee,
	prod_id:0,
	url:ctx+"api/product/prod_id/img/",
	init:function(){
		this.url=ctx+"api/product/"+this.prod_id+"/img/";
	}
});

ProductView=Backbone.View.extend({
	everChanged:0,
	template: _.template($('#proddetailtmp').html()),
	
	initialize:function(){
//		$('#prod_save').click(this.sav);
	},

	render: function(){
		
		
		$(this.el).html(this.template(this.model.toJSON()));
		this.renderGallery(true);
		return this;
	},

	
	close: function(){
		$(this.el).unbind();
		$(this.el).remove();
		//important: when bind to non-template dom element, unbind this element after close the view, or multiple events will present later
		$('#prod_save').unbind();
		$('#prod_del').unbind();
		
	},
	
	renderGallery:function(useel){
		//render product image list
		if(useel)
			$(this.el).find('#imglis').empty();
		else
			$('#imglis').empty();
		var self=this;
		var imglis=new ImageList();
		imglis.prod_id=this.model.get("prod_id");
		imglis.init();
		imglis.fetch({
			async:false, 
			success:function(lis){
				_.each(lis.models,function(m){
					if(useel)
						$(self.el).find('#imglis').append("<img style='width:300px' src='"+m.get('url')+"'></img>");
					else
						$('#imglis').append("<img style='width:300px' src='"+m.get('url')+"'></img>");

				});			
			}
		});
		
	},

		
	

	
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


