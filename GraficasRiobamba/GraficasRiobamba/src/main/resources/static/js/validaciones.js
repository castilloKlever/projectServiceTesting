$(function(){
	var nombre, decripcion, cantidad, precio,img;
	$(".btnAction").on('click',function(){
		
		nombre=$(".nombre").val();
		descripcion=$(".descripcion").val();
		cantidad=$(".cantidad").val();
		precio=$(".precio").val();
		img=$(".img").val();
		if (nombre.length==0 ||descripcion.length==0 ||cantidad.length==0 ||precio.length==0 ||precio.length < 0 ||cantidad.length < 0 || img ==0){
			alert("Campos  Inválidos");
		}
		
	});
	
	
	
});