var text = document.getElementById(text);

$.ajax({
	url: '/ContactAccessor',
	data:{
		postVariableName: id
	},
	type: 'GET'
}).done(function(data){
	alert(data);
})