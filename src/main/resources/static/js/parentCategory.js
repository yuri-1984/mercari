/**
 * 
 */
$(function() {
	$('#parentCategory').change(function() {
		var id = $('#parentCategory').val();
		console.log(id);
		$.ajax({
			type : "post",
			url : "http://localhost:8080/category",
			dataType : "json",
			data : {
						id : id
					}
		}).done(function(data) {
			var len = data.length;
			$("#childCategory").empty();
			for (var i = 0; i < len; i++) {
				childId = data[i].id;
				childName = data[i].name;
				$("#childCategory").append("<option value="+data[i].id+">"+data[i].name +"</option>");
				console.log(childId); 
				console.log(childName);
			}
		});
	});
});
