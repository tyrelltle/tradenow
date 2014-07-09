Message=Backbone.Model.extend({
	defaults:{"side":0,"message":"","imgurl":"","usernm":"","date":""},
	tradeid:-1,
	setTradeId:function(tradeid){
		this.tradeid=tradeid;
		this.urlRoot=this.urlRoot+this.tradeid;
	},
	urlRoot:ctx+"api/trade/message/"
		
});

MessageList=Backbone.Collection.extend({
	model:Message,
	tradeid:-1,
	setTradeId:function(tradeid){
		this.tradeid=tradeid;
		this.url=this.url+this.tradeid;
	},
	url:ctx+"api/trade/message/"
});

 
MessageListView=Backbone.View.extend({
	initialize:function(){


	},
	
	render:function(){
		$('.msglis_container').empty();
		_.each(this.model.models,function(m){
			$('.msglis_container').append(new MessageListItemView({model:m}).render().el);
		});
		
		return this;
	}
	
});


MessageListItemView=Backbone.View.extend({
	tagName:"div",
	className:"message row",
	render:function(){
		if(this.model.get("side")==0)
			this.template=_.template($("#msglisitemtmp1").html());
		else
			this.template=_.template($("#msglisitemtmp2").html());
		$(this.el).html(this.template(this.model.toJSON()));
		return this;
	}
	
});