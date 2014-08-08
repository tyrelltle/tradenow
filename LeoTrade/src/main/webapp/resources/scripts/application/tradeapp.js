
//non route driven router, due to Spring controller
AppRouter=Backbone.Router.extend({
	initialize:function(){	
		$('#choosebtn').click(function(){
			app.navigate("prodlis",true);
			
		});
		
		$('#btnpropose').click(function(){
			app.proposed();
		});
		
		$('#btnaccepted').click(function(){
			app.accepted();
		});
		
		$('#msgbtn').click(function(){
			app.msgsend();
		})
		
		if($('#side').val()=='FROM')
			$('.fromusernm').html('YOU');
		else if($('#side').val()=='TO')
			$('.tousernm').html('YOU');

		if($('#srvrmsg').length>0){
			
			alert($('#srvrmsg').val());
		}
		this.initstatus($('#status1').val(),$('#status2').val());
	},
	start:function(){
		//not put in initialize() because at that time app is not defined yet
		app.messageList=new MessageList();
		app.messageList.setTradeId($('#tradeid').val());
		app.messageListView =new MessageListView({model:app.messageList});
		app.messageList.fetch({
			success:function(lis){
				app.messageListView.render();
			}
		});
	},
	msgsend:function(){
		var message=new Message();
		var side_=0;
		if($('#side').val() == "TO")
			side_=1;
		message.set({
			side:side_,
			message:$('#msgtxt').val(),	
		});
		message.setTradeId($('#tradeid').val());
		app.messageList.create(message,{success:app.start});
	},
	initstatus:function(status1,status2){
		if(status1=="PENDING"){
			$('#label_status1').attr("class","label label-warning");
		}else if(status1=="ACCEPTED"){
			$('#label_status1').attr("class","label label-success");
		}
		$('#label_status1').html(status1);
		if(status2=="PENDING"){
			$('#label_status2').attr("class","label label-warning");
		}else if(status2=="ACCEPTED"){
			$('#label_status2').attr("class","label label-success");
		}
		$('#label_status2').html(status2);
		if(status1==status2 && status1=='ACCEPTED'){
			$('#msgholder').attr("class","alert alert-success");
			$('#msg').html("This trade has been finished, because both of you have accepted the offer!");
			$('.msgdismiss').click(function(){
				$('#msgholder').attr("class","hid");
			});
		}

	},
	routes:{
		"":"start",
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
						var container = document.querySelector('.masonrycontainer');
						
						app.msnry= new Masonry( container,{isInitLayout: true});
						imagesLoaded( container, function() {
							app.msnry= new Masonry( container,{isInitLayout: true});
						});
					});

					
				}else{
					$('#prodlist').html("Please add some item to your inventory! ");
					$('#prodlist').append("<a href='"+ctx+"user#prodlis'><span class='glyphicon glyphicon-forward'></span> Got to Add new item!</a>");
				}
				$('#prodlismodel').on('hide.bs.modal', function (e) {
					app.navigate("",true);
				});

				$('#prodlismodel').modal({show:true});
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
		$('#prod1title').html(prod.get("title"));
		$('#leftprodpic').attr("src", ctx+prod.get("thumurl"));
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
						$('#tradeid').val(jsn.tradeid);

					}else if(jsn.msgtype=="err"){
						$('#msgholder').attr("class","alert alert-danger");
						$('#msg').html(jsn.msg);
						$('.msgdismiss').click(function(){
							$('#msgholder').attr("class","hid");
						});
					}					
				   
		 });	
	},
	accepted:function(){
		var url=ctx+"api/trade/accept/tradeid/"+$('#tradeid').val()+"/side/"+$('#side').val();
		$.ajax({
			  type: "POST",
		      contentType: "application/json",
			  url: url,			
			})
			  .done(function( msg ) {
					var jstr=JSON.stringify(msg);
					var jsn=jQuery.parseJSON(jstr);
					if(jsn.msgtype=="suc"){
						if(jsn.status1==jsn.status2 & jsn.status1=="ACCEPTED"){
							$('#dealdone').modal({show:true});
						}else{
							$('#msgholder').attr("class","alert alert-success");
							$('#msg').html(jsn.msg);
							$('.msgdismiss').click(function(){
								$('#msgholder').attr("class","hid");
							});
						}
						
						$('status1').val(jsn.status1);
						$('status2').val(jsn.status2);
						app.initstatus(jsn.status1,jsn.status2);

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

