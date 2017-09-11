var id;
var setId = function(input){
	id = input;
}

var deleteById = function(){
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

var editById = function(id){	
	$.ajax({
		type: "Get",
		url: "/ContactList/GetById",
		data:{
			id : id
		}
	}).done(function(){
		window.location.href="/ContactList/EditContact.jsp";
	});
}