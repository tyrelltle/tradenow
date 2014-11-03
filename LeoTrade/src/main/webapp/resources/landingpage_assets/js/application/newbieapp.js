
//non route driven router, due to Spring controller
AppRouter=Backbone.Router.extend({

	routes:{
		"":"user"
	},
		
	user:function(){
		app.profile = new Profile();
		app.profileView = new ProfileView({model:app.profile});
		
		app.profile.fetch({
			success:function(model){
				$('#profile_detail').html(app.profileView.render().el);
				 initializeAutocomplete();
				 
				 $('#continue').click(function(){
					 	var origtxt=$('#continuetxt').text();
					 	$('#continuetxt').text('Validating');
					 	if( $('#autocomplete').val().trim()==""|| 
				 			$('#fn').val().trim()==""|| 
				 			$('#ln').val().trim()==""||
					 		$('#email').val().trim()==""){
									alert('address, firstname and lastname have to be filled!');
									$('#continuetxt').text(origtxt);
									return false;
					 	}			
						$.ajax({
							  type: "POST",
							  url: ctx+"unnewbie",
							}).done(function( msg ) {
								  if(msg="succ"){
										window.location.replace(ctx+"home");
								  }else{
									   alert(msg);
									   $('#continuetxt').text(origtxt);
								  }  
						 });	
						 
				 });
			}
		});
		
		
	},
	
	
});
	    
var app=new AppRouter();
Backbone.history.start();
