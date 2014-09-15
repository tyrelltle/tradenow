//applicat related script

    if (window.location.hash && window.location.hash == '#_=_') {
        window.location.hash = '';
    }
$(document).ready(function() {
                if($('#tourbtn').length>0) {
                    var origtourbtnleft = $('#tourbtn').position().left;
                    $('#tourbtn').hover(
                        function () {
                            $('#tourbtn').animate({
                                left: "0px"
                            }, 500);

                        },
                        function () {
                            $('#tourbtn').animate({
                                left: origtourbtnleft
                            }, 500);

                        }
                    );

                }
				/* toggle layout */
				$('#btnToggle').click(function(){
					if ($(this).hasClass('on')) {
				    	$('#main .col-md-6').addClass('col-md-4').removeClass('col-md-6');
				    	$(this).removeClass('on');
				    }
				  	else {
				    	$('#main .col-md-4').addClass('col-md-6').removeClass('col-md-4');
				      	$(this).addClass('on');
				  	}
				});
				$('.searchbtn').click(function(){
					window.location=ctx+"search"+$('.searchtxt').val();
					return false;
				});
	
				$('.loc_srch_btn').click(function(){
					window.location=ctx+"location"+$('.locsearchtxt').val();
					return false;
				});
				
				
				$('.dropdown-toggle').dropdown();
				
				var notiflis=new NotificationList();
				var notiflisview =new NotificationListView({model:notiflis});
				notiflis.fetch({
					success:function(lis){
						notiflisview.render();

					}
				});
				

				//init category list
				if(typeof(CategoryList) != 'undefined'){
					var categoryList=new CategoryList();
					var categoryListView=new CategoryListView({model:categoryList});
					categoryList.fetch({
						success:function(lis){
							categoryListView.render();
						}
					});
				}
				$('.likesbtn,.likesbtn_cur').click(function(){
					window.location=ctx+"likes";
					return false;
				});
				
	        
    });