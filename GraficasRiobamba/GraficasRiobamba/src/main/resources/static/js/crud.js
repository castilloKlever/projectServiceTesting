var btnAbrirPopup1 = document.getElementById('btn-view-producto'),
	overlay1 = document.getElementById('overlay1'),
	popup1 = document.getElementById('popup1'),
    cerrarScroll = document.getElementsByTagName('html')[0],
	btnCerrarPopup1 = document.getElementById('btn-cerrar-popup1');

btnAbrirPopup1.addEventListener('click', function(){
	overlay1.classList.add('active');
	popup1.classList.add('active');
    cerrarScroll.style.overflow = 'hidden';

});

btnCerrarPopup1.addEventListener('click', function(e){
	e.preventDefault();
	overlay1.classList.remove('active');
	popup1.classList.remove('active');
    cerrarScroll.style.overflow = 'auto';
});
