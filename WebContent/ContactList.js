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

var checkSearch = function(){
	if($(".CL-ContactList--Search-Input").val() == ""){
		$(".CL-ContactList--Search-Input").toggleClass("CL-ContactList--Search-Input-Extended");
		
	}else{
		$('#CL-ContactList--Search-Form')[0].submit(function(){
			console.log("submitting");
		});
		
	}	
}