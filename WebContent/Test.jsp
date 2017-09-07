<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<textarea id="text"></textarea>
	<button id="btn">display</button>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="Test.js"></script>
	<script type="text/javascript">
		function callbackFunction(data){
	        $('#text').html(data);
	    }
	    $('document').ready(function(){
	
	        $('#btn').click(function() {
	          $.get('/ContactAccessor',callbackFunction)
	
	        });
	    });
	</script>
	<%	
		
		String testString = (String) request.getAttribute("testString");
		out.print(testString);
	%>

</body>
</html>