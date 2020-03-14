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
	document.getElementById("changePassword").style.display = 'none';
	document.getElementById("createUser").style.display = 'none';
	document.getElementById("listOfUsers").style.display = 'none';		
}

function enableProfile(){
	document.getElementById("editUser").style.display = 'block';
	document.getElementById("changePassword").style.display = 'none';
	document.getElementById("createUser").style.display = 'none';
	document.getElementById("listOfUsers").style.display = 'none';	
}

function enableChangePassword(){
	document.getElementById("editUser").style.display = 'none';
	document.getElementById("changePassword").style.display = 'block';
	document.getElementById("createUser").style.display = 'none';
	document.getElementById("listOfUsers").style.display = 'none';	
}

function enableUsers(){
	document.getElementById("editUser").style.display = 'none';
	document.getElementById("changePassword").style.display = 'none';
	document.getElementById("createUser").style.display = 'none';
	document.getElementById("listOfUsers").style.display = 'block';	
}

function enableCreateUsers(){
	document.getElementById("editUser").style.display = 'none';
	document.getElementById("changePassword").style.display = 'none';
	document.getElementById("createUser").style.display = 'block';
	document.getElementById("listOfUsers").style.display = 'none';	
}