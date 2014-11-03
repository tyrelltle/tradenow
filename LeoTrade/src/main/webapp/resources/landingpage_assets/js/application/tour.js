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
    //force = true if no cookie validation is needed
    startTradeTour:function(force){
        if(!force && !needcookie())
            return;
        if(!this.tour){

            this.tour = new Tour({
                name: "Tour",

                steps: [
                    {
                        orphan: true,
                        title: "Lets Trade!",
                        content: "Looks like you have decided to trade with somebody. Please go though this" +
                            "tour to guide you to the interface of the trade page. You can exit any time by clicking" +
                            "End Tour button"
                    },
                    {
                        backdrop: true,
                        element: "#two_prod_row",
                        title: "Side by Side",
                        content: "Here you can see, the items of both users are placed side by side. The left side" +
                            "is the trader who initiated this trade activity. The right side user has the right to browse" +
                            "left side user's item backlog, to pick something he/she thinks worth to trade with his item."
                    },
                    {
                        placement:'bottom',
                        backdrop: true,
                        element: "#choosebtn",
                        title: "Choose item",
                        content: "The very first thing you need to do as a left side user, is to select one item from your own" +
                            "item backlog that you want to trade with right user's item"
                    },
                    {
                        placement:'top',
                        backdrop: true,
                        element: "#btnpropose",
                        title: "Propose",
                        content: "After choose one of your items, you can propose this deal to the right side user. The right side" +
                            "user will notice your proposal, possibly browse your backlog to choose something else, and click the propose " +
                            "again to let you review the deal"
                    },
                    {
                        backdrop: true,
                        element: "#btnaccepted",
                        title: "Accept",
                        content: "If left side or right side user accept the deal, he/she can click this button, and a notification will" +
                            "be sent to the other side. Once both side accepted, this trade activity is considered to be DONE"
                    },
                    {
                        backdrop: true,
                        element: "#label_status1",
                        title: "Status",
                        content: "Both side have status indicator to indicate if the user either proposed, accepted or did nothing about this" +
                            "trade activity yet"
                    },
                    {
                        backdrop: true,
                        element: "#msg_row",
                        title: "Message",
                        content: "To ease the collaboration between both side, a handy message feature is necessary :) "
                    },
                    {
                        backdrop: true,
                        element: "#tourbtn",
                        title: "Thank you!",
                        content: "Thats it! You have finished the tour. Whenever you want to " +
                            "do the tour again, just click this button!"
                    }]
            });


        }
        // Initialize the tour
        this.tour.init();

        // Start the tour
        this.tour.restart();


    },	//END startTradeTour
	startHomeTour:function(force){
		if(!force && !needcookie())
			return;
		if(!this.tour){
			
			this.tour = new Tour({
				  name: "Tour",

				  steps: [
				  {
					orphan: true,
				    title: "WELCOME!",
				    content: "We have prepared a nice tour for you to " +
				    		 "get familiar with the user interface. If you " +
				    		 "are interested, please press 'NEXT' button to " +
				    		 "start the tour. Your can press END TOUR button " +
				    		 "to exit at any time!"
				  },
				  {
					placement:'top',
					backdrop: true,
				    element: "#main",
				    title: "Item list",
				    content: "This is a list of items posted by other users, and it is" +
				    		" sorted by upload date by default"
				  },
                  {
                      placement:'bottom',
                      backdrop: true,
                      element: "#additembtn",
                      title: "Add Item",
                      content: "You can add your own item by clicking this button. To add an item," +
                          "at least one photo of the image is required."
                  },
                  {
                      placement:'top',
                      backdrop: true,
                      element: "#btn_detail",
                      title: "Item Detail",
                      content: "This is a list of items posted by other users, and it is" +
                          " sorted by upload date by default"
                  },
                  {
                      backdrop: true,
                      element: "#likebtn",
                      title: "Favorites",
                      content: "You can press this little heart button to LIKE this item"
                  },
                  {
                      backdrop: true,
                      element: "#tolikesbtn",
                      title: "View all favorite items",
                      content: "To view all the items that you have LIKEed, press this little" +
                               "heart"
                  },
				  {
					backdrop: true,
				    element: ".catmenu-active",
				    title: "Category",
				    content: "You can choose a Category here, so that items only in this " +
                             "category will be displayed"
				  },
				  {
					backdrop: true,
					element: "#searchform",
				    title: "Search",
				    content: "You can also search items by their names here"
				  },
                    {
                          backdrop: true,
                          element: "#locform",
                          title: "Search",
                          content: "You can also search items by location"
                      },
                  {
                      backdrop: true,
                      element: "#tourbtn",
                      title: "Thank you!",
                      content: "Thats it! You have finished the tour. Whenever you want to " +
                          "do the tour again, just click this button!"
                  }]
			});


		}
		// Initialize the tour
		this.tour.init();

		// Start the tour
		this.tour.restart();


	}	//END startHomeTour



};

