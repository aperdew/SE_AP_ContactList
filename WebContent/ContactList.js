var id;
var deleteById = function(id){
	
	$.ajax({
		type: "POST",
		url: "/ContactList/Delete_Search",
		data:{
			id : id
		}
	}).then(function(){
		window.location.href="/ContactList/Contacts";
	});
}