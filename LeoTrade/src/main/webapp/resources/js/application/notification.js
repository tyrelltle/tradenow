Notification=Backbone.Model.extend({
	defaults:{id:0,"message":"","url":"","date":""},
	urlRoot:ctx+"api/notification",
		
});

NotificationList=Backbone.Collection.extend({
	model:Notification,
	url:ctx+"api/notification"	
});

 
NotificationListView=Backbone.View.extend({
	initialize:function(){},
	
	render:function(){
		var self=this;
		if(this.model.length>0)
			$('.notibell').attr("style","color:red");
		else
			$('.notiflis').html("No new notification");
		_.each(this.model.models,function(m){
			$('.notiflis').append(new NotificationListItemView({model:m}).render().el);
		});
		
		return this;
	}
	
});


NotificationListItemView=Backbone.View.extend({
	tagName:"li",
	className:"notiflisitem list-group-item",
	events:{"click":"clicked"},
	render:function(){
		$(this.el).append("<a href='#''>"+this.model.get('message')+"</a>");
		return this;
	},
	clicked:function(){
		var url=this.model.get("url");
		this.model.destroy({wait:true});
		window.location.replace(ctx+url);
	}
	
});