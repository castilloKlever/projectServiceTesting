$(function(){
	var nombre, decripcion, cantidad, precio,img;
	$(".btnAction").on('click',function(){
		
		nombre=$(".nombre").val();
		descripcion=$(".cliente").val();
		cantidad=$(".telefono").val();
		precio=$(".cont").val();
	
		if (nombre.length==0 ||descripcion.length==0 ||cantidad.length==0 ||precio.length==0 ){
		 alert("Campos  Inválidos");
			 
			
		}
		
	});
	
	
	
});