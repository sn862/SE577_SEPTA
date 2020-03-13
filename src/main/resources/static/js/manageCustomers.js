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
	document.getElementById("createcustomer").style.display = 'none';
}

function enableListOfCustomers(){
	document.getElementById("createcustomer").style.display = 'none';
	document.getElementById("listCustomers").style.display = 'block';
}

function enableCreateCustomer(){
	document.getElementById("createcustomer").style.display = 'block';
	document.getElementById("listCustomers").style.display = 'none';
}