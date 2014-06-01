

Image = Backbone.Model.extend({
	defaults:{"img_Id":0,"url":""},
	urlRoot:"api/product/img/",
	//idAttribute:"img_id",

});
ImageList = Backbone.Collection.extend({
	model:Image,
	prod_id:0,
	url:"api/product/prod_id/img/",
	init:function(){
		this.url="api/product/"+this.prod_id+"/img/";
	}
});

GalleryViewPhoto=Backbone.View.extend({
	initialize: function(){		
		_.bindAll(this, "render","onGallerySubmit","onformsuccess");
	//	this.model.on("change",this.render,this);	
	//	this.model.on("reset",this.render,this);
	//	this.model.on("add",this.render,this);
		//this.model.on('sync', this.render, this);
	},
	
	template: _.template($('#gallerytmp').html()),
	
	render:function(){
		//render product image list
		var self=this;
		var imglis=new ImageList();
		imglis.prod_id=this.model.get("prod_id");
		imglis.init();
		imglis.fetch({
			async:false, 
			success:function(lis){
				_.each(lis.models,function(m){
					if(useel)
						$(self.el).find('#imglis').append("<img src='"+m.get('url')+"'></img>");
					else
						$('#imglis').append("<img src='"+m.get('url')+"'></img>");

				});			
			}
		});
		return this;
	},
	onGallerySubmit: function(e){
		$('#imgform').append('Loading</br>');
		 var oMyForm = new FormData();
		  oMyForm.append("file", $(this.el).find('#img').prop("files")[0]);
		  var self=this;
		  $.ajax({
		    url: 'http://localhost:8888/cuige/api/product/img/upload/',
		    data: oMyForm,
		    dataType: 'text',
		    processData: false,
		    contentType: false,
		    type: 'POST',
		    success: function(data){
		    	//self.model.reset({});
				self.onformsuccess();
			},
		    error: function(jqXHR, textStatus, errorThrown){
	            console.log("FETCH FAILED: " + errorThrown);
	        }
		  });
		  e.preventDefault();
		
	},
	onformsuccess:function(){
		this.model.fetch({
			success:function(){
				app.photolis.render();
			},
			error:function(){
				alert("fail");
			},
		});
		$('#imgform').append('on success</br>');
	}
	
});
