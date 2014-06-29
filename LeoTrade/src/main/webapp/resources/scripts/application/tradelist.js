

Trade=Backbone.Model.extend({
	defaults:{"tradeid":-1,"tradeurl":"","status":"","img1url":"",
			  "img2url":"", "title1":"","title2":""},
	urlRoot:"api/trade",
	idAttribute: "trade_id"
		
});

TradeList=Backbone.Collection.extend({
	model: Trade,
	url:"api/trade"	
});



TradeListView=Backbone.View.extend({
	initialize:function(){
		
		this.template=_.template($("#tradelisttmp").html());
	},
	
	render:function(){
		var self=this;
		$(this.el).html(this.template());
		_.each(this.model.models,function(m){
			$(self.el).find('.tradelis').append(new TradeListItemView({model:m}).render().el);
		});
		
		return this;
		
	},
	close: function(){
		$(this.el).unbind();
		$(this.el).remove();
	}
	
});


TradeListItemView=Backbone.View.extend({
	initialize:function(){
		this.template=_.template($("#tradelistitemtmp").html());
	},
	
	className:"list-group-item",
	tagName:"li",
	render:function(){
		$(this.el).html(this.template(this.model.toJSON()));
		if(this.model.get('status')=='DONE')
			$(this.el).find('#span_status').attr('class','badge label label-success');
		else
			$(this.el).find('#span_status').attr('class','badge label label-warning');

		return this;
	},
	close:function(){
		$(this.el).unbind();
		$(this.el).remove();
	}
	
});


