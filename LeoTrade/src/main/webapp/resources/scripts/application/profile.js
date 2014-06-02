


Profile=Backbone.Model.extend({
	defaults:{"social_id":"","aboutme":"","location":"",
			  "lastname":"", "firstname":"","email":""},
	urlRoot:"profile/api/user",
	idAttribute: "social_id"
		
});


ProfileView=Backbone.View.extend({
	
	initialize:function(){
		_.templateSettings = {
			    interpolate: /\{\{(.+?)\}\}/gim,
			    evaluate: /\{\{(.+?)\}\}/gim,
			    escape: /\{\{\-(.+?)\}\}/gim
			};
		this.model.bind("change",this.render,this);
		this.model.bind("destroy",this.close,this);
		this.template=_.template($('#usertmp').html());
	},

	events:{
		"click #submit":"save"
	},

	
	render: function(){

		$(this.el).html(this.template(this.model.toJSON()));
		return this;
	},

	save:function(){
		this.model.set({
			location:$(this.el).find('#txt_loc').val(),
			aboutme:$(this.el).find('#txt_aboutme').val()
		});
		
			this.model.save(null,{success :this.succ, 
							 error: this.err});
		
		
	},
	
	succ: function(){alert("success");},
	error:function(){alert("fail");},
	close: function(){
		
		$(this.el).unbind();
		$(this.el).remove();
	}
	
});

