


Profile=Backbone.Model.extend({
	defaults:{"userid":-1,"aboutme":"","location":"",
			  "lastname":"", "firstname":"","email":"","lat":'0',"lng":'0'},
	urlRoot:ctx+"user/api/user",
	idAttribute: "userid"
		
});


ProfileView=Backbone.View.extend({
	
	initialize:function(){
		_.templateSettings = {
			    interpolate: /\{\{(.+?)\}\}/gim,
			    evaluate: /\{\{(.+?)\}\}/gim,
			    escape: /\{\{\-(.+?)\}\}/gim
			};
		//this.model.bind("change",this.render,this);
		this.model.bind("destroy",this.close,this);
		this.template=_.template($('#usertmp').html());
	},

	events:{
		"click #submit":"save"
	},

	
	render: function(){

		$(this.el).html(this.template(this.model.toJSON()));
		$(this.el).find('#imgsubmit').submit(this.uploadimg);
        $(this.el).find('#img_input').change(this.selectimg);
		return this;
	},

	save:function(){
		if($(this.el).find('#autocomplete').val().trim()==""||
		   $(this.el).find('#fn').val().trim()==""||
		   $(this.el).find('#ln').val().trim()==""||
		   $(this.el).find('#email').val().trim()==""){
			alert('email, address, firstname and lastname have to be filled!');
			return false;
		}
		
		this.model.set({
			location:$(this.el).find('#autocomplete').val(),
			lat:$(this.el).find('#lat').val(),
			lng:$(this.el).find('#lng').val(),
			aboutme:$(this.el).find('#txt_aboutme').val(),
			firstname:$(this.el).find('#fn').val(),
			lastname:$(this.el).find('#ln').val(),
			email:$(this.el).find('#email').val()

		});
		
			this.model.save(null,{success :this.succ, 
							 error: this.err});
		
		
	},

	
	succ: function(){
        $.gritter.add({
            title: 'Success!!',
            text: 'Successfully updated profile!'
        });
    },
	error:function(){
        $.gritter.add({
            title: 'Failed!!',
            text: 'Failed to updated profile!'
        });
    },
	close: function(){
		
		$(this.el).unbind();
		$(this.el).remove();
	},
    selectimg:function(){
        var input=this;
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('.prodpic').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    },
	uploadimg:function(e){
		 var oMyForm = new FormData();
		  oMyForm.append("file", $('#img_input').prop("files")[0]);
		  var self=this;
		  $.ajax({
			url: ctx+'user/img/upload',
		    data: oMyForm,
		    dataType: 'text',
		    processData: false,
		    contentType: false,
		    type: 'POST',
		    success: function(data){
                $.gritter.add({
                    title: 'Success!!',
                    text: 'Successfully uploaded!'
                });

			},
		    error: function(jqXHR, textStatus, errorThrown){
                $.gritter.add({
                    title: 'Failed!!',
                    text: 'Sorry, Image upload failed!'
                });
	            console.log("FETCH FAILED: " + errorThrown);
	        }
		  });

		  e.preventDefault();
		
	}
	
});

