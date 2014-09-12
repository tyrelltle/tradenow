// Instance the tour

function setCookie(cname,cvalue,exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires=" + d.toGMTString();
    document.cookie = cname+"="+cvalue+"; "+expires;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) != -1) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function needcookie() {
    var cval=getCookie("needtour");
    if (cval != "") {
    	return false;
    } else {
        setCookie("needtour", false, 365);
        return true;
    }
}

var TourManager={
	startHomeTour:function(){
		if(!needcookie())
			return;
		if(!this.hometour){
			
			this.hometour = new Tour({
				  name: "Tour",
				  
				  steps: [
				  {
					orphan: true,
				    title: "WELCOME!",
				    content: "We have prepared a nice tour for you to" +
				    		 "get familiar with the user interface. If you " +
				    		 "are interested, please press 'NEXT' button to " +
				    		 "start the tour. Your can press END TOUR button" +
				    		 "to exit at any time!"
				  },
				  {
					placement:'top',
					backdrop: true,
				    element: "#main",
				    title: "Item list",
				    content: "This is a list of items posted by other user, and it is" +
				    		" sorted by upload date"
				  },
				  {
					backdrop: true,
				    element: ".catmenu-active",
				    title: "Category",
				    content: "You can "
				  },
				  {
					backdrop: true,
					element: ".likesbtn",
				    title: "eaa the fuck",
				    content: "Content of my step"
				  }]
			});
			
			
		}
		// Initialize the tour
		this.hometour.init();

		// Start the tour
		this.hometour.restart();
		
		
	}	//END startHomeTour


		
};

