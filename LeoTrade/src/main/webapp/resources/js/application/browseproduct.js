

Product=Backbone.Model.extend({
	defaults:{"prod_id":null,"userid":0,"catid":0,"title":"",
			  "detail":"", "price":0,"quantity":0,"status":"",
			  "tradefor":"","thumurl":"","ownerimgurl":"",
			  "ownernm":"","owneraddr":"","liked":0},
	urlRoot:"api/product",
	idAttribute: "prod_id"
		
});

ProductList=Backbone.Collection.extend({
	model:Product,
	start: 0,
	offset:20,
	initialize:function(){
		
		this.url=ctx+"api/product/start/0/count/"+this.offset;
	},
	
	addstart:function(){
		this.start+=this.offset;
		this.url=ctx+"api/product/start/"+this.start+"/count/"+this.offset;

	},
	makeprivate:function(userid){
		//make the model fetch only my products
		this.url=this.url+"/ownerid/"+userid;
	},
	makecategorize:function(catid){
		this.url=this.url+"/catid/"+catid;
	},
	addsearch:function(key){
		this.url=this.url+"/search/"+key;
	},
	addlocsearch:function(key){
		this.url=this.url+"/location/"+key;
	},
	favorilize:function(){
		this.url=ctx+"api/product/likes";
	}
});

Imagee = Backbone.Model.extend({
	defaults:{"img_Id":0,"url":"","fuckyou":"fuckyou"},
	urlRoot:"api/product/img/",
	//idAttribute:"img_id",

});
ImageList = Backbone.Collection.extend({
	model:Imagee,
	prod_id:0,
	url:ctx+"api/product/prod_id/img/",
	init:function(){
		this.url=ctx+"api/product/"+this.prod_id+"/img/";
	}
});

ProductView=Backbone.View.extend({
	everChanged:0,
	template: _.template($('#proddetailtmp').html()),
	
	initialize:function(){
//		$('#prod_save').click(this.sav);
	},

	render: function(){
		
		
		$(this.el).html(this.template(this.model.toJSON()));
		this.renderGallery(true);
		return this;
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
			$(this.el).find('.carousel-inner').empty();
		else
			$('.carousel-inner').empty();
		var self=this;
		var imglis=new ImageList();
		imglis.prod_id=this.model.get("prod_id");
		imglis.init();
		imglis.fetch({
			async:false, 
			success:function(lis){
				var i=0;
				_.each(lis.models,function(m){
					if(i==0){
						var imgtmp=_.template($("#imglistitemtmp").html());
						$(self.el).find('.carousel-indicators').append('<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>');
					}
					else{
						var imgtmp=_.template($("#imglistitemtmp2").html());
						$(self.el).find('.carousel-indicators').append('<li data-target="#carousel-example-generic" data-slide-to="'+i+'" class="active"></li>');
					}
					i++;
					if(useel)
						$(self.el).find('.carousel-inner').append(imgtmp(m.toJSON()));
					else
						$('.carousel-inner').append(imgtmp(m.toJSON()));

				});			
				

			}
		});
		
	},

		
	

	
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
			$(self.el).append(new ProductListItemView({model:e}).render().el);
			
		});
		this.model.bind("add",function(e){
			
			var newelm=new ProductListItemView({model:e}).render().el;
			$(self.el).find('.masonrycontainer').append(newelm);
			if($('.masonrycontainer').length>0){
				var container = document.querySelector('.masonrycontainer');
				var msnry;
				//msnry= new Masonry(container);
				app.msnry.appended([newelm]);
				//msnry.layout();
				imagesLoaded( container, function() {
					app.msnry.layout();
					
				});
			}
		});
		this.template=_.template($("#prodlisttmp").html());
	},
	
	render:function(){
		var self=this;
		$(this.el).html(this.template());
		_.each(this.model.models,function(m){
			$(self.el).find('.masonrycontainer').append(new ProductListItemView({model:m}).render().el);
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
	
	className:"masonryitem col-md-3",
	events:{"click .btn_detail":"clicked",
			"click .btn_select":"selected",
			"click .btnunlike":"like",
			"click .btnlike":"unlike"},
	like:function(){
		var self=this;
		$.ajax({
			  type: "POST",
			  url: ctx+"api/product/like/"+this.model.get("prod_id")
			})
			  .done(function( msg ) {
                $(self.el).find('.btnunlike').attr("class","glyphicon glyphicon-heart btnlike");

                var clonedheart=$(self.el).find('.btnlike').clone();
                clonedheart.offset({top:$(self.el).find('.btnlike').offset().top,
                                    left:$(self.el).find('.btnlike').offset().left});
                clonedheart.css({'position':'absolute',
                                 'font-size':'50px'});
                clonedheart.appendTo($('body'));

                clonedheart.animate({
                        left:$('#tolikesbtn .likesbtn i').offset().left,
                        top:$('#tolikesbtn .likesbtn i').offset().top
                    });
                clonedheart.animate({
                    fontSize:'0px',
                    opacity:0.5
                },function(){
                    $(this).detach();
                });

            });
	},
	unlike:function(){
		var self=this;
		$.ajax({
			  type: "POST",
			  url: ctx+"api/product/unlike/"+this.model.get("prod_id")
			})
			  .done(function( msg ) {
					$(self.el).find('.btnlike').attr("class","glyphicon glyphicon-heart btnunlike"); 
			  });	
	},
	selected:function(){
		app.navigate("prodselected"+this.model.get("prod_id"),true);
	},
	clicked:function(){
		//app.navigate("proddetail"+this.model.get("prod_id"),true);
		app.prodDetail(this.model.get("prod_id"));
	},
	render:function(){
		$(this.el).html(this.template(this.model.toJSON()));
		if(this.model.get("liked")==1){
			$(this.el).find('.btnunlike').attr("class","glyphicon glyphicon-heart btnlike"); 
		}
		return this;
	},
	close:function(){
		$(this.el).unbind();
		$(this.el).remove();
	}
	
});


