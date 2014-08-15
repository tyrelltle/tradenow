


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
			$(self.el).find('#menu').append(new CategoryListItemView({model:m}).render().el);
		});
		return this;
	}
	
});


CategoryListItemView=Backbone.View.extend({
	initialize:function(){
		this.template=_.template($("#catlistitemtmp").html());

	},
	events:{"click":"clicked"},
	tagName:"a",
	className:"link",
	render:function(){
		$(this.el).html(this.template(this.model.toJSON()));
		if($('#catid').length>0){
			if(parseInt($('#catid').val()) == this.model.get("catid")){
				$(this.el).attr('class', 'link').addClass("active");		
			}
		}
		return this;
	},
	clicked:function(){
		window.location.replace(ctx+"catid"+this.model.get("catid"));
	}
	
});