//selection list view, pass in "abc;bcd"



Product=Backbone.Model.extend({
	defaults:{"id":0,"name":"","catid":0},
	urlRoot:"../product"
});

ProductList=Backbone.Collection.extend({
	model:Product,
	catid:0,
	initialize:function(args){
		this.catid=args.catid;
		this.url="../product/catid/"+this.catid;
	}
	
});

ProductListView=Backbone.View.extend({
	
	initialize: function(){
		var self=this;
		$(this.el).html('<div class="header">Select a Product</div>');
		this.model.bind("add",function(e){
			$(self.el).append(new ProductListItemView({model:e}).render().el)
		});
	},
	
	render: function(){
		var self=this;
		
		_.each(this.model.models,function(m){
			$(this.el).append(new ProductListItemView({model:m}).render().el)
		});

		return this;
	},
	close: function(){
		$(this.el).unbind();
		$(this.el).remove();
	}
});

ProductListItemView=Backbone.View.extend({
	className:"item",
	events: {"click":"clicked"},
	clicked: function(){
		app.navigate("newcustprod"+this.model.get("id"),true);

	},
	render: function(){
		var jsn={name:this.model.get("name"),
				 color: "blue"};
		//above, assign random index to colors array
		var template=_.template($("#listcatitemtemp").html(),jsn);
		$(this.el).html(template).transition('scale');
		return this;
	},
	close: function(){
		$(this.el).unbind();
		$(this.el).remove();
	}
	
});




Category=Backbone.Model.extend({
	defaults:{"catid":"","name":""},
	urlRoot:"../category",
	idAttribute:"catid"
	
});

CategoryList=Backbone.Collection.extend({
	model:Category,
	initialize:function(){
		this.url="../category";
	}
});

CategoryListView=Backbone.View.extend({
	
	initialize: function(){
		var self=this;
		$(this.el).html('<div class="header">Select a Category</div>');
		this.model.bind("add",function(e){
			$(self.el).append(new CategoryListItemView({model:e}).render().el)
		});
	},
	
	render: function(){
		var self=this;
		
		_.each(this.model.models,function(m){
			$(this.el).append(new CategoryListItemView({model:m}).render().el)
		});

		return this;
	},
	close: function(){
		$(this.el).unbind();
		$(this.el).remove();
	}
});

CategoryListItemView=Backbone.View.extend({
	className:"item",
	events: {"click":"clicked"},
	clicked: function(){
		app.navigate("catid"+this.model.get("catid"),true);

	},
	render: function(){
		var jsn={name:this.model.get("name"),
				 color: "blue"};
		//above, assign random index to colors array
		var template=_.template($("#listcatitemtemp").html(),jsn);
		$(this.el).html(template).transition('scale');
		return this;
	},
	close: function(){
		$(this.el).unbind();
		$(this.el).remove();
	}
	
});



TotalPrice=Backbone.View.extend({
//view to display total cost, sum of all custproducts	
//model: CustProductList

	curcost:0, /*cost of currently viewed custproduct. */
	curid:-1, /*id of currently viewd custproduct. 
	 			if >=0, render() will calculate all but current
	 			custprod cost. otherwise it calculates all*/
	totalCost:0,
	firsttime:true,

	render:function(){
		this.totalCost=0;
		var that = this;
		_.each(this.model.models,function(m){
			if(m.get("custprodid")!=that.curid)
				that.totalCost+=m.get("prodPrice")*m.get("len")*m.get("quantity");
		});
		//if(this.curid>=0){
			this.totalCost+=this.curcost;
		//}
		var jsn={cost:this.totalCost};
		//above, assign random index to colors array
		var template=_.template($("#totalpricetmp").html(),jsn);
		
		if(this.firsttime){
			$(this.el).html(template).transition('scale');
			this.firsttime=false;
		}else{
			$(this.el).html(template);
		}
		
		$('.totalprice').html(this.el);
		
	},
	close:function(){
		$(this.el).unbind();
		$(this.el).remove();
		
	}
});

SelectionList=Backbone.View.extend({
	items:"",
	defaultoption:"",
	classnm:"dropdownlist",
	render:function(){
		if(this.items == "")
			return this;
		$(this.el).append("<select class='"+this.classnm+"'>");
		//default first
		if(this.defaultoption != "" && this.defaultoption!=null)
			$(this.el).find('.'+this.classnm).append("<option value='"+this.defaultoption+"'>"+this.defaultoption+"</option>");
		var lis=this.items.split(";");
		for(var i=0;i<lis.length;i++){
			if(this.defaultoption!= lis[i])
				$(this.el).find('.'+this.classnm).append("<option value='"+lis[i]+"'>"+lis[i]+"</option>");
		}
		$(this.el).append("</select>");
		return this;
	}
	
}); 

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
CustProduct=Backbone.Model.extend({
	defaults:{"prodNm":"","prodColors":"","prodPrice":0,"guid":"","id":0,"quantity":"","len":0,"color":""},
	urlRoot:"../custproduct",
	idAttribute:"custprodid"
	
});


CustProductList=Backbone.Collection.extend({
	model:CustProduct,
	initialize:function(){
		this.url="../custproduct/"+app.guid;
	}

	
});




CustProductView=Backbone.View.extend({
	
	template:_.template($('#eventdetailtemp').html()),
	initialize:function(){
		this.model.bind("change",this.close,this);
		this.model.bind("destroy",this.close,this);


	},

	events:{
		"click .save":"save",
		"click .del":"del",
		"change #len":"calculate",
		"change #quantity":"calculate"
	},

	calculate:function(){
		/*refresh total cost view
		 * first calculate this custproduct's custom costs, then rely on TotalCost obj to add to other models*/
		var len=$(this.el).find('#len').val();
		var quantity=$(this.el).find('#quantity').val();

		this.totalcost.curcost=len*quantity*this.model.get("prodPrice");
		this.totalcost.curid=this.model.get("custprodid");
		this.totalcost.render();
	},
	render: function(){

		$(this.el).html(this.template(this.model.toJSON())).transition('scale');
		var sellist=new SelectionList();
		sellist.items=this.model.get('prodColors');
		sellist.defaultoption=this.model.get('color');
		$(this.el).find('.dropdown_placeholder').html(sellist.render().el);
		
		if(this.totalcost==null){
			this.totalcost= new TotalPrice({model:app.custProductList});
			this.totalcost.render();
		}
		return this;
	},

	save:function(){
		this.model.set({
			len:$(this.el).find('#len').val(),
			quantity:$(this.el).find('#quantity').val(),
			color:$(this.el).find('.dropdownlist').val(),
			guid:app.guid
		});
		if(this.model.isNew()){
			app.custProductList.create(this.model);
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
		this.totalcost.close();
		$(this.el).unbind();
		$(this.el).remove();
	}
	
});


CustProductListView=Backbone.View.extend({
	
	initialize: function(){
		this.model.bind("reset",this.render,this);
		this.model.bind("save",this.render,this);

		var self=this;
		this.model.bind("add",function(e){
			$(self.el).append(new CustProductListItemView({model:e}).render().el)
		});
	},
	
	render: function(){
		_.each(this.model.models,function(m){
			$(this.el).append(new CustProductListItemView({model:m}).render().el)
		});
		return this;
	}
});

CustProductListItemView=Backbone.View.extend({
	className:"item",
	initialize: function(){
		this.model.bind("remove",this.close,this);
		this.model.bind("change",this.render,this);
	},
	events: {"click":"clicked"},
	clicked: function(){
		app.navigate("eventid"+this.model.get("custprodid"),true);

	},
	render: function(){
		var jsn={prodNm:this.model.get("prodNm"),
				 color: this.model.get("color")};//colormgr.nextColor()};
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
		app.navigate("showCategories",true);


	}
	
});


AppRouter=Backbone.Router.extend({
	guid: "",
	routes:{"":"list",
			"eventid:id":"detail",
			"showCategories":"showcat",
			"catid:id":"productlis",
			"newcustprod:productid":"newcustproduct"},

	initialize:function(){
		if(this.guid=="")
			this.initGuid();
		$('.guidtxt').val(this.guid);
		$('.guidtxt').keydown(function(e){
			 if(e.keyCode == 13){
				 app.guid=$('.guidtxt').val();
				 app.navigate("",true);
			 }
		});
	},
	initGuid:function(){
		this.guid=(this.S4() + this.S4() + "-" + this.S4() + "-4" + this.S4().substr(0,3) + "-" + this.S4() + "-" + this.S4() + this.S4() + this.S4()).toLowerCase();
		//alert(this.guid);
		
	},
	S4:function S4() {
	    return (((1+Math.random())*0x10000)|0).toString(16).substring(1); 
	},
	newcustproduct:function(productid){
		$('.cat_prod_list').hide();
		var prod=this.productList.get(productid);
		this.custProduct=new CustProduct({
			prodNm: prod.get("name"),
			prodColors: prod.get("colorbag"),
			prodPrice: prod.get("unitprice"),
			color: "",
			quantity:0,
			len:1
		});
		this.custProduct.set({"id":	prod.get("id"),});
		
		if(this.productListView){
			this.productListView.close();
		}
		
		this.custProductView=new CustProductView({model:this.custProduct});
		$(".eventdetail").html(this.custProductView.render().el);
	},
	productlis:function(id){
		if(this.categoryListView){
			this.categoryListView.close();
		}
		this.productList=new ProductList({catid:id});
		this.productListView=new ProductListView({model:this.productList});
		this.productList.fetch({
			success:function(productList){
				$('.cat_prod_list').html(app.productListView.render().el);
			}
			
		});
	},
	showcat:function(){
		if(this.custProductView)
			this.custProductView.close();
		$('.cat_prod_list').show();
		this.categoryList=new CategoryList();
		this.categoryListView=new CategoryListView({model:this.categoryList});
		this.categoryList.fetch({
			success:function(categoryList){
				
				$('.cat_prod_list').html(app.categoryListView.render().el);
				
			}
		});
	},
	list:function(){		
		$('.cat_prod_list').hide();
		if(this.categoryListView){
			this.categoryListView.close();
		}
		this.custProductList=new CustProductList();
		this.custProductListView=new CustProductListView({model:this.custProductList});
		this.custProductList.fetch({
			success:function(custProductList){
				$('.custprodlist').html(app.custProductListView.render().el);
				if(app.viewid){
					_.each(app.custProductList.models,function(m){
						if(m.get("id")==app.viewid){
							app.custProductView=new CustProductView({model:m});
							$(".eventdetail").html(app.custProductView.render().el);
						}
					});					
					
					//this.event=this.eventList.get(app.viewid);
					
					delete app.viewid;
				}
			}
		});
	},
			
	detail:function(id){
		$('.cat_prod_list').hide();
		if(this.categoryListView){
			this.categoryListView.close();
		}
		if(this.custProductList){
			this.custProduct=this.custProductList.get(id);
			this.custProductView=new CustProductView({model:this.custProduct});
			$(".eventdetail").html(this.custProductView.render().el);

		}else{
			this.viewid=id;
			this.list();
			
		}
		
//		this.photolismodel = new PhotoList();
//		this.photolis = new GalleryViewPhoto({model:this.photolismodel});		
//		this.photolis.model.fetch({
//			success: function(){
//				app.photolis.render();
//			}
//			});
		
	}
});

var app=new AppRouter();
Backbone.history.start();

var newpanel=new NewPanel();

//TODO make iframe a template of a new view. append the view into EventDetailView, meanwhile, pass EventDetailView to the new view which then
//$(ifram).load(eventDetailView.deleteNewView())

