


Profile=Backbone.Model.extend({
	defaults:{"userid":0,"aboutme":"","location":"",
			  "lastname":"", "firstname":"","email":""},
	urlRoot:"user/api/user",
	idAttribute: "userid"
		
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
		$(this.el).find('#imgsubmit').submit(this.uploadimg);
		return this;
	},

	save:function(){
		this.model.set({
			location:$(this.el).find('#txt_loc').val(),
			aboutme:$(this.el).find('#txt_aboutme').val(),
			firstname:$(this.el).find('#fn').val(),
			lastname:$(this.el).find('#ln').val()
		});
		
			this.model.save(null,{success :this.succ, 
							 error: this.err});
		
		
	},
	
	succ: function(){alert("success");},
	error:function(){alert("fail");},
	close: function(){
		
		$(this.el).unbind();
		$(this.el).remove();
	},
	uploadimg:function(e){
		 var oMyForm = new FormData();
		  oMyForm.append("file", $('#img_input').prop("files")[0]);
		  var self=this;
		  $.ajax({
			url: ctx+'user/img/upload',
		    data: oMyForm,
		    dataType: 'text',
		    processData: false,
		    contentType: false,
		    type: 'POST',
		    success: function(data){
		    	alert("success!");
		    	//refresh img
		    	var tmp=$('.prodpic').attr('src');
		    	$('.prodpic').attr('src','');
		    	$('.prodpic').attr('src',tmp);

			},
		    error: function(jqXHR, textStatus, errorThrown){
		    	alert("Failed!"+errorThrown);
	            console.log("FETCH FAILED: " + errorThrown);
	        }
		  });

		  e.preventDefault();
		
	}
	
});

