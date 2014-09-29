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

        //only render the notifications with url that user is not currently viewing

        var dellist=[]
		_.each(this.model.models,function(m){
            if(document.URL.indexOf(m.get('url'))!=-1) {
                dellist.push(m);
            }
            else {
                $('.notiflis').append(new NotificationListItemView({model: m}).render().el);
            }
        });
		//for notifications whose url is currently being viewed by user, remove them just as user clicked them manually
        for(i =0; i < dellist.length;i++){
            dellist[i].destroy({wait:true});
        }

        if(this.model.length>0&&this.model.length!=dellist.length)
            $('.notibell').attr("style","color:red");
        else
            $('.notiflis').html("No new notification");


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