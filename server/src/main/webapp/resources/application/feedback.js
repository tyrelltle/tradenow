function feedback(btnelem,msgelem,context){
    if(!$(msgelem) || $(msgelem).val().trim()=='') {
        alert('please enter feedback messages!');
        return;
    }
    $(btnelem).button('loading');
    $.ajax({
        type: "POST",
        url: context+"/api/feedback",
        data: JSON.stringify({ message: $(msgelem).val() }),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(function( msg ) {
        $(btnelem).button('reset');
        if(msg.status=='success') {
            alert('We have recieved your feedback. Thanks very much!');
        }else{
            alert(msg.message);
        }
    });

}