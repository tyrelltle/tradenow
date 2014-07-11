


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
	initialize:function(){},
	
	render:function(){
		var self=this;
		_.each(this.model.models,function(m){
			$(self.el).append(new CategoryListItemView({model:m}).render().el);
		});
		return this;
	}
	
});


CategoryListItemView=Backbone.View.extend({
	events:{"click":"clicked"},
	className:"list-group-item",
	tagName:"a",
	render:function(){
		$(this.el).append(this.model.get("name"));
		return this;
	},
	clicked:function(){
		window.location.replace(ctx+"catid"+this.model.get("catid"));
	}
	
});