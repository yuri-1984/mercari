/**
 * 
 */
$(function(){
	$('.require').on('change',function(){
		if($('input.require[type=text],textarea.require').filter(function(){
			return $(this).val=="";
			}.length +
			($('select.require').filter(function(){
				return $(this).prop('selectedIndex')==0;
			}.length > 0)
			$('#submit').prop('disabled', false););
	});
	
});