

Product=Backbone.Model.extend({
	defaults:{"prod_id":null,"userid":0,"catid":0,"title":"no title",
			  "detail":"", "price":0,"quantity":0,"status":"","tradefor":"","thumurl":""},
	urlRoot:"api/product",
	idAttribute: "prod_id"
		
});

ProductList=Backbone.Collection.extend({
	model:Product,
	url:"api/product"	
});

Imagee = Backbone.Model.extend({
	defaults:{"img_Id":0,"url":"","fuckyou":"fuckyou"},
	urlRoot:"api/product/img/",
	//idAttribute:"img_id",

});
ImageList = Backbone.Collection.extend({
	model:Imagee,
	prod_id:0,
	url:"api/product/prod_id/img/",
	init:function(){
		this.url="api/product/"+this.prod_id+"/img/";
	}
});

ProductView=Backbone.View.extend({
	everChanged:0,
	template: _.template($('#proddetailtmp').html()),
	
	initialize:function(){
		_.bindAll(this, "onGallerySubmit","onformsuccess");
		//this.model.bind("change",this.close,this);
		//this.model.bind("destroy",this.close,this);
		$('#prod_save').click(this.sav);
		$('#prod_del').click(this.del);
	},



	render: function(){
		
		
		$(this.el).html(this.template(this.model.toJSON()));

		//configure and show the category dropdown list	
		this.categoryList=new CategoryList();
		this.categorySelection = new CategorySelection({model:this.categoryList});
		this.categorySelection.default_catid=this.model.get('catid');
		var self=this;
		this.categoryList.fetch({
			async:false, 
			success:function(lis){
				$(self.el).find('#catlistholder').html(self.categorySelection.render().el);
			}
		});

		//image upload form initialize
		$(this.el).find('#imgsubmit').submit(this.onGallerySubmit);
		this.renderGallery(true);
		return this;
	},


	sav: function(event){
		
		
		
		app.productView.model.set({
			title:$('#titletxt').val(),
			price:$('#price').val(),
			detail:$('#detail').val(),
			quantity:$('#quantity').val(),
			tradefor:$('#tradefor').val(),
			catid:$('.'+app.productView.categorySelection.classnm).val()
		});
		if(app.productView.model.isNew()){
			app.productList.create(app.productView.model,
					              {success :app.productView.succ, 
				 							error: app.productView.err});
			
		}else{
			app.productView.model.save(null,{success :app.productView.succ, 
							 error: app.productView.err});
		}
		app.productView.close();
	},
	
	del:function(){
		app.productView.model.destroy({success :app.productView.succ, 
			   						   error: app.productView.err});
		app.productView.close();	
	},

	
	succ: function(){
		alert("successed!");
		app.navigate("prodlis",true);
	},
	
	err: function(){
		alert("failed!");
		app.navigate("prodlis",true);
		
	},
	
	close: function(){
		$(this.el).unbind();
		$(this.el).remove();
		//important: when bind to non-template dom element, unbind this element after close the view, or multiple events will present later
		$('#prod_save').unbind();
		$('#prod_del').unbind();
		
	},
	
	renderGallery:function(useel){
		//render product image list
		if(useel)
			$(this.el).find('#imglis').empty();
		else
			$('#imglis').empty();
		var self=this;
		var imglis=new ImageList();
		imglis.prod_id=this.model.get("prod_id");
		imglis.init();
		imglis.fetch({
			async:false, 
			success:function(lis){
				_.each(lis.models,function(m){
					if(useel)
						$(self.el).find('#imglis').append("<img style='width:300px' src='"+m.get('url')+"'></img>");
					else
						$('#imglis').append("<img style='width:300px' src='"+m.get('url')+"'></img>");

				});			
			}
		});
		
	},
	onGallerySubmit: function(e){
		if(this.model.isNew()){
			//model has to exist before uploading image to it
			app.productView.model.set({
				title:$('#titletxt').val(),
				price:$('#price').val(),
				detail:$('#detail').val(),
				quantity:$('#quantity').val(),
				tradefor:$('#tradefor').val(),
				catid:$('.'+this.categorySelection.classnm).val()
			});
			app.productList.create(this.model,
					              {async:false});
			
		}
		 var oMyForm = new FormData();
		  oMyForm.append("file", $('#prod_img_input').prop("files")[0]);
		  var self=this;
		  $.ajax({
			url: 'http://localhost:8080/cuige/api/product/img/upload/'+this.model.get("prod_id"),
		    data: oMyForm,
		    dataType: 'text',
		    processData: false,
		    contentType: false,
		    type: 'POST',
		    success: function(data){
		    	alert("success!");
		    	//app.navigate("prodDetail",true);
		    	
				self.onformsuccess();
			},
		    error: function(jqXHR, textStatus, errorThrown){
		    	alert("Failed!"+errorThrown);
	            console.log("FETCH FAILED: " + errorThrown);
	        }
		  });

		  e.preventDefault();
		
	},
	onformsuccess:function(e){
		this.renderGallery(false);
		  //fetch model to get the new 
		  this.model.fetch({async:false});
		
	}
		
	

	
});

ProductListView=Backbone.View.extend({
	columnnum: 3,
	initialize:function(){
		_.templateSettings = {
			    interpolate: /\{\{(.+?)\}\}/gim,
			    evaluate: /\{\{(.+?)\}\}/gim,
			    escape: /\{\{\-(.+?)\}\}/gim
			};
		//this.template=_.template($('#prodListTmp').html());
		var self=this;
		this.model.bind("create",function(e){
			$(self.el).append(new ProductListItemView({model:e}).render().el)
			
		});
		this.template=_.template($("#prodlisttmp").html());
	},
	
	render:function(){

		var self=this;
		$(this.el).html(this.template());
		_.each(this.model.models,function(m){
			$(self.el).find('.masconrycontainer').append(new ProductListItemView({model:m}).render().el);
		});
		
		return this;
		
	},
	close: function(){
		$(this.el).unbind();
		$(this.el).remove();
	}
	
});


ProductListItemView=Backbone.View.extend({
	initialize:function(){
		_.templateSettings = {
			    interpolate: /\{\{(.+?)\}\}/gim,
			    evaluate: /\{\{(.+?)\}\}/gim,
			    escape: /\{\{\-(.+?)\}\}/gim
			};
		this.template=_.template($("#prodlistitemtmp").html());
	},
	
	className:"list-group-item",
	events:{"click #modalbtn":"clicked"},
	
	clicked:function(){
		app.navigate("proddetail"+this.model.get("prod_id"),true);
		
	},
	render:function(){
		var tit = this.model.get("title");
		if(tit == "")
			tit = "title not provided";
		var json={title:tit,
				  thumurl:this.model.get("thumurl")};
		$(this.el).html(this.template(json));
		return this;
	},
	close:function(){
		$(this.el).unbind();
		$(this.el).remove();
	}
	
});


CategorySelection=Backbone.View.extend({
	default_catid:0,
	classnm:"dropdownlist",
	render:function(){
		
		if(this.items == "")
			return this;
		$(this.el).append("<select class='"+this.classnm+" form-control'>");
		//default first
		if(this.default_catid >=0 && this.default_catid!=null){
			var cat= this.model.where({ catid: this.default_catid })[0];
			if(cat != null)
				$(this.el).find('.'+this.classnm).append("<option value='"+cat.get('catid')+"'>"+cat.get('name')+"</option>");
		}
		_.each(this.model.models, function (m) {
			if(this.default_catid!= m.get('catid')){
				$(this.el).find('.'+this.classnm).append("<option value='"+m.get('catid')+"'>"+m.get('name')+"</option>");
			}
		}, this);
		
		$(this.el).append("</select>");
		return this;
	}
	
});

Category=Backbone.Model.extend({
	defaults:{"catid":1,"name":""},
	urlRoot:"api/category",
	idAttribute: "catid"
		
});

CategoryList=Backbone.Collection.extend({
	model:Product,
	url:"api/category"	
});
