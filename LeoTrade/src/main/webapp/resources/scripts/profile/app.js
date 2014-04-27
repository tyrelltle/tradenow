
//non route driven router, due to Spring controller
AppRouter=Backbone.Router.extend({
	guid: "",
	//routes:{"profile":"user"},

	initialize:function(){

		
		$('#tab_prof').click(this.user);

	},
	initTab:function(){		$('#tab_prof').click();},

	user:function(productid){

		app.profile = new Profile();
		app.profileView = new ProfileView({model:app.profile});
		
		app.profile.fetch({
			success:function(model){
				
				$('#profile_detail').html(app.profileView.render().el);
				
			}
		});
	},
	
	
});

$(document).ready(function ()
	    { 

			_.templateSettings = {
				    interpolate: /\{\{(.+?)\}\}/gim,
				    evaluate: /\{\{(.+?)\}\}/gim,
				    escape: /\{\{\-(.+?)\}\}/gim
				};
	    });

	    
var app=new AppRouter();
Backbone.history.start();
app.initTab();
app.initTab();


//TODO make iframe a template of a new view. append the view into EventDetailView, meanwhile, pass EventDetailView to the new view which then
//$(ifram).load(eventDetailView.deleteNewView())

