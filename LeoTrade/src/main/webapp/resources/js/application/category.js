


Category=Backbone.Model.extend({
	defaults:{"catid":1,"name":""},
	urlRoot:ctx+"api/category",
	idAttribute: "catid"
		
});

CategoryList=Backbone.Collection.extend({
	model:Product,
	url:ctx+"api/category"	
});

 
CategoryListView=Backbone.View.extend({
	initialize:function(){
	},
	li_str:"<li class='col-xs-6 col-sm-6 col-md-3 col-lg-3'></li>",
	liul_str:"<ul></ul>",
	
	render:function(){
		var li=$(this.li_str);
		var liul=$(this.liul_str);
		var i=1;
		var self=this;
		_.each(this.model.models,function(m){
			if(i%5!=0){
				liul.append(new CategoryListItemView({model:m}).render().el);
			}else{
				liul.append(new CategoryListItemView({model:m}).render().el);
				li.append(liul);
				$('.catmenu').append(li);
				li=$(self.li_str);
				liul=$(self.liul_str);
			}
			i++;
		});
		if(i%5!=0){
			li.append(liul);
			$('.catmenu').append(li);
		}
		return this;
	}
	
});


CategoryListItemView=Backbone.View.extend({
	initialize:function(){
		this.template=_.template($("#catlistitemtmp").html());

	},
	events:{"click":"clicked"},
	tagName:"li",
	render:function(){
		$(this.el).html(this.template(this.model.toJSON()));
		if($('#catid').length>0){
			if(parseInt($('#catid').val()) == this.model.get("catid")){
				$(this.el).attr('class', 'link').addClass("active");		
			}
		}
		return this;
	},
	clicked:function(e){
		window.location.replace(ctx+"catid"+this.model.get("catid"));
		e.preventDefault();
	}
	
});