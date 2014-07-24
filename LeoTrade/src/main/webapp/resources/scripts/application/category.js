


Category=Backbone.Model.extend({
	defaults:{"catid":1,"name":""},
	urlRoot:"api/category",
	idAttribute: "catid"
		
});

CategoryList=Backbone.Collection.extend({
	model:Product,
	url:"api/category"	
});

 
CategoryListView=Backbone.View.extend({
	initialize:function(){
		this.template=_.template($("#catlisttmp").html());
	},
	
	render:function(){
		$(this.el).html(this.template());
		var self=this;
		_.each(this.model.models,function(m){
			$(self.el).find('#userMenu').append(new CategoryListItemView({model:m}).render().el);
		});
		return this;
	}
	
});


CategoryListItemView=Backbone.View.extend({
	initialize:function(){
		this.template=_.template($("#catlistitemtmp").html());

	},
	events:{"click .link":"clicked"},
	tagName:"li",
	render:function(){
		$(this.el).html(this.template(this.model.toJSON()));
		return this;
	},
	clicked:function(){
		window.location.replace(ctx+"catid"+this.model.get("catid"));
	}
	
});