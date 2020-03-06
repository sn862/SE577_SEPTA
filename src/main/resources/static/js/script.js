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
function onload() {
	var x = document.getElementById("oneway").value;
	if (x == "OneWay") {
		document.getElementById("arrivalDate").disabled = true;
	}
}

function enableReturnDate() {
	document.getElementById("arrivalDate").disabled = false;
}

function disableReturnDate() {
	document.getElementById("arrivalDate").disabled = true;
}


function oneverykey(val) {
	//alert(val);
	var result=[];
	var url1 = "http://localhost:8080/search/getStops/"+val;
	 $.ajax({
	        url: url1
	    }).then(function(data) {
	    	 var myArr = JSON.parse(data);
	    	 for (i = 0; i < myArr.length; i++) {
	    		 var x= myArr[i].name+" ("+myArr[i].id+")";
	    		 result.push(x);
	    		}
	    	alert(result); 
	    });
	 
}



