/**
 * 
 */
$(function() {
	$('#childCategory').change(function() {
		var id = $('#childCategory').val();
		console.log(id);
		$.ajax({
			type : "post",
			url : "http://localhost:8080/category2",
			dataType : "json",
			data : {
						id : id
					}
		}).done(function(data) {
			console.log(data);
			var len = data.length;
			$("#grandChildCategory").empty();
		for (var i = 0; i < len; i++) {
			grandChildId = data[i].id;
			grandChildName = data[i].name;
			$("#grandChildCategory").append("<option value="+data[i].id+">"+data[i].name +"</option>");
			console.log(grandChildId);
			console.log(grandChildName);
		}
			
		});
	});
});
