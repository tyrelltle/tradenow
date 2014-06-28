
//non route driven router, due to Spring controller
AppRouter=Backbone.Router.extend({
	initialize:function(){	
		$('#choosebtn').click(function(){
			app.navigate("prodlis",true);
			
		});
		
		$('#btnpropose').click(function(){
			app.proposed();
		});
		
		if($('#side').val()=='FROM')
			$('.fromusernm').html('YOU');
		else if($('#side').val()=='TO')
			$('.tousernm').html('YOU');

		if($('#srvrmsg').length>0){
			
			alert($('#srvrmsg').val());
		}
		
	},
	routes:{
		"prodlis":"prodlis",
		"proddetail:prod_id":"prodDetail",
		"prodselected:prod_id":"prodsel"},
		
	prodlis:function(){		
		
		//init product list
		app.productList = new ProductList();
		app.productListView = new ProductListView({model:this.productList});
		app.productList.makeprivate($('#hide_fromuserid').val());
		app.productList.fetch({
			
			success:function(productList){
				if(productList.length>0){
					
					$('#prodlist').html(app.productListView.render().el);
					$('#loadmore').click(function(e){
						app.productList.addstart();
						app.productList.makeprivate($('#hide_fromuserid').val());
						app.productList.fetch({remove:false});
						
					});

					$('#prodlismodel').on('shown.bs.modal', function (e) {
						var container = document.querySelector('.masconrycontainer');
						var msnry;
						this.msnry= new Masonry( container,{isInitLayout: true});
						imagesLoaded( container, function() {
							

							msnry= new Masonry( container,{isInitLayout: true});
						});
					});
					$('#prodlismodel').on('hide.bs.modal', function (e) {
						app.navigate("",true);
					});
					$('#prodlismodel').modal({show:true});
					
				}else{
					$('#prodlist').append("Please add some item to your inventory!");
				}
				
			}
		});
	},

	prodDetail:function(prod_id){
		//display productView in popup modal
		//$('#btn_trade').click(function(){document.location.href = 'tradepage/toprod/'+prod_id;});
		app.product=this.productList.get(prod_id);
		app.productView=new ProductView({model:this.product});
		$('.proddetailcontent').html(app.productView.render().el);
	},
	prodsel:function(prod_id){
		var prod=this.productList.get(prod_id);
		$('#leftprodpic').attr("src", prod.get("thumurl"));
		$('#prod1id').val(prod_id);
		$('#prodlismodel').modal('hide');
		app.navigate("",true);

	},
	
	proposed:function(){
		$.ajax({
			  type: "POST",
		      contentType: "application/json",
		      dataType: "json",
			  url: ctx+"api/trade/propose",
			  data: JSON.stringify({ tradeid: $('#tradeid').val(), 
				  	  prod1id: $('#prod1id').val(), 
				  	  prod2id: $('#prod2id').val(),
				  	  side:$('#side').val(),
				  	  method: "", 
				  	  msg: "", 
				  	  msgtype: ""})
			})
			  .done(function( msg ) {
					var jstr=JSON.stringify(msg);
					var jsn=jQuery.parseJSON(jstr);
					if(jsn.msgtype=="suc"){
						$('#msgholder').attr("class","alert alert-success");
						$('#msg').html(jsn.msg);
						$('.msgdismiss').click(function(){
							$('#msgholder').attr("class","hid");
						});
					}else if(jsn.msgtype=="err"){
						$('#msgholder').attr("class","alert alert-danger");
						$('#msg').html(jsn.msg);
						$('.msgdismiss').click(function(){
							$('#msgholder').attr("class","hid");
						});
					}					
				   
		 });	
	}
});

	    
var app=new AppRouter();
Backbone.history.start();

