

$(document).ready(function() {
	
	$("#btndangnhap").click(function() {
		
		$.ajax({
			url:"/test-api",
			type:"GET",
			data:{
				name:"hoanganhtien",
				password:"123",
			},
			success: function(value) {
				alert(value);
			}
		})
	});
	
	$("#btndangki").click(function() {
		$()
	});
	
})