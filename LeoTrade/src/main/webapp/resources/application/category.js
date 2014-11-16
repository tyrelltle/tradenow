


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
	render:function(){
		var tr=$('<tr></tr>');
		var i=1;
		var self=this;
		_.each(this.model.models,function(m){
            tr.append(new CategoryListItemView({model:m}).render().el);

            if(i%5==0){
				$('.catmenu').append(tr);
                tr=$('<tr></tr>');
			}
			i++;
		});
		if(i%5!=0){
			$('.catmenu').append(tr);
		}
		return this;
	}
	
});


CategoryListItemView=Backbone.View.extend({
	initialize:function(){
		this.template=_.template($("#catlistitemtmp").html());

	},
	events:{"click":"clicked"},
	tagName:"td",
	render:function(){
        this.model.set("name",i18n.t('category.'+this.model.get("name")));
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