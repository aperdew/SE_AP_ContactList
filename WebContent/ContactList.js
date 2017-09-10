var id;
var deleteById = function(id){
	
	$.ajax({
		type: "POST",
		url: "/ContactList/Delete",
		data:{
			id : id
		}
	}).then(function(){
		window.location.href="/ContactList/Contacts";
	});
}