$
		.ajaxSetup({
			beforeSend : function(xhr, settings) {
				if (settings.type == 'POST' || settings.type == 'PUT'
						|| settings.type == 'DELETE') {
					if (!(/^http:.*/.test(settings.url) || /^https:.*/
							.test(settings.url))) {
						// Only send the token to relative URLs i.e. locally.
						xhr.setRequestHeader("X-XSRF-TOKEN", Cookies
								.get('XSRF-TOKEN'));
					}
				}
			}
		});

$.get("/user", function(data) {
	$("#profile-name").html(data.name);
	$(".unauthenticated").hide();
	$(".authenticated").show();
}).fail(function() {
	$(".unauthenticated").show();
	$(".authenticated").hide();
});

var logout = function() {
	$.post("/logout", function() {
		$("#profile-name").html("");
		$(".unauthenticated").show();
		$(".authenticated").hide();
	})
	return true;
}

function selectedTrip(val){
	 document.getElementById("tripId").value = val;
	
}
function setCartTotal(value){
	var tickets= document.getElementById("numberOfTickets").value;
	document.getElementById("price").value= tickets * value;
	document.getElementById("totalPrice").innerHTML="Select Onward Trip Cart total: $"+ tickets * value;
	
}

function setCartTotalonreturn(value){
	var tickets= document.getElementById("numberOfTickets").value;
	document.getElementById("returnPrice").value= tickets * value;
	var price = document.getElementById("price").value;
	var returnPrice= tickets * value;
	var total = +price + +returnPrice;
	document.getElementById("totalPrice").innerHTML="Select Return Trip Cart total: $"+ total;
	
}


function selectedreturnTrip(val){
	 document.getElementById("returnTripId").value = val;
	
}


function submitForm(event){
    event.preventDefault();


}
function onload() {
	document.getElementById("departureDate").valueAsDate = new Date();
	document.getElementById("oneway").checked;
		document.getElementById("arrivalDate").style.display = 'none';
		
	
}

function enableReturnDate() {
	document.getElementById("arrivalDate").style.display = 'block';
	document.getElementById("arrivalDate").valueAsDate = new Date();
}

function disableReturnDate() {
	document.getElementById("arrivalDate").style.display = 'none';
}

function setMinDate(){
	document.getElementById("departureDate").valueAsDate = new Date();
	
}
function setMinDateForReturn(){
	document.getElementById("arrivalDate").valueAsDate = document.getElementById("departureDate").val;
}
function onloadH3(){
	var price = document.getElementById("price").value;
	var returnPrice = document.getElementById("returnPrice").value;
	if(returnPrice != null){
		var total = +price + +returnPrice;
		document.getElementById("totalprice").innerHTML="Total Cost: $"+ total;
	}else{
		document.getElementById("totalprice").innerHTML="Total Cost: $"+ price;
	}
	
}

function onFromSationKeyPress(val) {
	if(val.length >1){
	var result=[];
	
	var url1 = "/search/getStops/"+val;
	 $.ajax({
	        url: url1
	    }).then(function(data) {
	    	 var myArr = JSON.parse(data);
	    	
	    	var huge_list = document.getElementById('huge_from_list');
	    	huge_list.innerHTML = "";
	    	
	    	 myArr.forEach(function(item) {
                 // Create a new <option> element.
                 var option = document.createElement('option');
                 option.value = item.name+"("+item.id+")";

                 // attach the option to the datalist element
                 huge_list.appendChild(option);
             });
	    });
}

}

function onToSationKeyPress(val) {
	if(val.length >1){
	var result=[];
	
	var url1 = "/search/getStops/"+val;
	 $.ajax({
	        url: url1
	    }).then(function(data) {
	    	 var myArr = JSON.parse(data);
	    	
	    	var huge_list = document.getElementById('huge_to_list');
	    	huge_list.innerHTML = "";
	    	
	    	 myArr.forEach(function(item) {
                 // Create a new <option> element.
                 var option = document.createElement('option');
                 option.value = item.name+"("+item.id+")";

                 // attach the option to the datalist element
                 huge_list.appendChild(option);
             });
	    });
}

}





