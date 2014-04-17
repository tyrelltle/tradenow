//array defining colors of list items
var colormgr={
	colors:["black","green","red","blue","orange","purple","teal"],
	nextid:0,
	nextColor:function(){
		if(this.nextid==this.colors.length)
			this.nextid=0;
		var ret= this.colors[this.nextid];
		this.nextid=this.nextid+1;
		return ret;
	}
};

//var colormgr=new ColorMgr();
//window.?
Event=Backbone.Model.extend({
	defaults:{"loc":"none","title":"none","detail":"none"},
	urlRoot:"../event"
	
});


EventList=Backbone.Collection.extend({
	model:Event,
	url:"../event"
	
});




Photo = Backbone.Model.extend({
	//defaults:{"url":"http://www.baidu.com/img/bdlogo.gif"},
	urlRoot:"../gallery/list"
});
PhotoList = Backbone.Collection.extend({
	model:Photo,
	url:"../gallery/list"
});
/*
 * photo list
 * */
GalleryViewPhoto=Backbone.View.extend({
	initialize: function(){		
		_.bindAll(this, "render");
		this.model.on("change",this.render,this);	
		this.model.on("reset",this.render,this);
		this.model.on("add",this.render,this);
	},
	
	template: _.template($('#gallerylist').html()),
	
	render:function(){
		$(this.el).html(this.template);
		_.each(this.model.models,function(m){
			$(app.photolis.el).append("<img src='"+m.get('url')+"'></img>");
			$('.photos').html(app.photolis.el);
			
		});
		return this;
	}
	
});

/*
 * this is only the img upload form. the GaleryViewPhoto is contained within it
 */
GalleryForm=Backbone.View.extend({
	initialize: function(){
		_.bindAll(this, "onGalleryLoad","onGalleryRefresh","render","onUploadSuccess");

	},
	
	template:_.template($('#galery').html()),
	render: function(){
		$(this.el).html(this.template);
		
		$(this.el).find(this.iframeId).load(this.onGalleryLoad);
	  

		return this;
	},
	onGalleryLoad: function(){
		
	
			
			$(this.el).find(this.iframeId).contents().find('form').submit(
					this.onGalleryRefresh
			
			);
	
		
	},
	onGalleryRefresh: function(e){
		
		 var oMyForm = new FormData();
		  oMyForm.append("file", $(this.el).find(this.iframeId).contents().find('#img').prop("files")[0]);
		  var self=this;
		  $.ajax({
		    url: 'http://localhost:8888/gallery/fileUpload',
		    data: oMyForm,
		    dataType: 'text',
		    processData: false,
		    contentType: false,
		    type: 'POST',
		    success: function(data){
		    	self.onUploadSuccess();//app.galleryForm.onUploadSuccess();
		    },
		    error: function(jqXHR, textStatus, errorThrown){
	            console.log("FETCH FAILED: " + errorThrown);
	        }
		  });
		  e.preventDefault();
		
	},
	onUploadSuccess: function(){
    	app.photolismodel.reset({});
		app.photolismodel.fetch();
	},
	iframeId: '#if'
}
);

EventView=Backbone.View.extend({
	
	template:_.template($('#eventdetailtemp').html()),
	initialize:function(){
		this.model.bind("change",this.close,this);
		this.model.bind("destroy",this.close,this);
		

	},

	events:{
		"click .save":"save",
		"click .del":"del"
	},

	render: function(){
		$(this.el).html(this.template(this.model.toJSON())).transition('scale');
		return this;
	},

	save:function(){
		this.model.set({
			title:$('#title').val(),
			loc:$('#loc').val(),
			detail:$('#detail').val()
		});
		if(this.model.isNew()){
			app.eventList.create(this.model);
		}else{
			this.model.save(null,{success :this.succ, 
							 error: this.err});
		}
		
	},
	
	del:function(){
		this.model.destroy({
			success:function(){
				alert("The event is successfully deleted");
				//this.close();
				//window.history.back();
				app.navigate("");
			},
			error:function(){
				alert("error occured");
			}
		});
		
	},

	
	succ: function(){
		$('#status').text("successed");
		
		window.history.back();
		
	},
	
	err: function(){
		$('#status').text("fail");
		window.history.back();
	},
	
	close: function(){
		$(this.el).unbind();
		$(this.el).remove();
	}
	
});


EventListView=Backbone.View.extend({
	
	initialize: function(){
		this.model.bind("reset",this.render,this);
		this.model.bind("save",this.render,this);

		var self=this;
		this.model.bind("add",function(e){
			$(self.el).append(new EventListItemView({model:e}).render().el)
		});
	},
	
	render: function(){
		_.each(this.model.models,function(m){
			$(this.el).append(new EventListItemView({model:m}).render().el)
		});
		return this;
	}
});

EventListItemView=Backbone.View.extend({
	className:"item",
	initialize: function(){
		this.model.bind("remove",this.close,this);
		this.model.bind("change",this.render,this);
	},
	events: {"click":"clicked"},
	clicked: function(){
		app.navigate("eventid"+this.model.get("id"),true);
/*		this.eventView=new EventView({model:this.model});
		$(".eventdetail").html(this.eventView.render().el);*/
	},
	render: function(){
		var jsn={title:this.model.get("title"),
				 loc:  this.model.get("loc"),
				 color: colormgr.nextColor()};
		//above, assign random index to colors array
		var template=_.template($("#listitemtemp").html(),jsn);

		$(this.el).html(template).transition('scale');
		return this;
	},
	close: function(){
		$(this.el).unbind();
		$(this.el).remove();
	}
	
});


NewPanel=Backbone.View.extend({
	el:$('.header'),
	initialize:function(){
		this.render();
	},
	template:_.template($('#newbtntmp').html()),
	render:function(){
		$(this.el).html(this.template());
		return this;
	},
	events: {"click .icon":"newa"},
	newa: function(event){
		if(app.eventView)
			app.eventView.close();
		app.eventView=new EventView({model:new Event()});
		$(".eventdetail").html(app.eventView.render().el);

	}
	
});


AppRouter=Backbone.Router.extend({
	routes:{"":"list",
			"eventid:id":"detail"},
			

	list:function(){
	
		this.eventList=new EventList();
		this.eventListView=new EventListView({model:this.eventList});
		this.eventList.fetch({
			success:function(eventList){
				$('.list').html(app.eventListView.render().el);
				if(app.viewid){
					_.each(app.eventList.models,function(m){
						if(m.get("id")==app.viewid){
							app.eventView=new EventView({model:m});
							$(".eventdetail").html(app.eventView.render().el);
						}
					});					
					
					//this.event=this.eventList.get(app.viewid);
					
					delete app.viewid;
				}
			}
		});
	},
			
	detail:function(id){
		if(this.eventList){
			this.event=this.eventList.get(id);
			this.eventView=new EventView({model:this.event});
			$(".eventdetail").html(this.eventView.render().el);
		}else{
			this.viewid=id;
			this.list();
			
		}
		
		this.photolismodel = new PhotoList();
		this.photolis = new GalleryViewPhoto({model:this.photolismodel});
		
		this.galleryForm=new GalleryForm();
		
		this.photolis.model.fetch({
			success:function(eventList){
				//$('.photos').html(app.photolis.render().el);
				$('.photoform').html(app.galleryForm.render().el);
			}});
		
	}
});

var app=new AppRouter();
Backbone.history.start();

var newpanel=new NewPanel();

//TODO make iframe a template of a new view. append the view into EventDetailView, meanwhile, pass EventDetailView to the new view which then
//$(ifram).load(eventDetailView.deleteNewView())

