$(function () {
    $('.filter').click(function () {
        $(this).addClass('active').siblings().removeClass('active');
        let valor = $(this).attr('data-nombre');
        if (valor == 'todos') {
            $('.cont-work').show('1000');
        } else {
            $('.cont-work').not('.' + valor).hide('1000');
            $('.cont-work').filter('.' + valor).show('1000');
        }

    });

    let nosotros = $('#nosotros').offset().top,
        servicios = $('#servicios').offset().top,
        catalogo = $('#catalogo').offset().top,
        contacto = $('#contacto').offset().top;
   proyecto = $('#proyecto').offset().top;


    window.addEventListener('resize', function(){
         let nosotros = $('#nosotros').offset().top,
        servicios= $('#servicios').offset().top,
        catalogo = $('#catalogo').offset().top,
        contacto = $('#contacto').offset().top;
         proyecto = $('#proyecto').offset().top;
    });

    $('#enlace-inicio').on('click', function(e){
        e.preventDefault();
        $('html, body').animate({
            scrollTop: 0
        },600);
    });

    $('#enlace-nosotros').on('click', function(e){
        e.preventDefault();
        $('html, body').animate({
            scrollTop: nosotros -80
        },600);
    });
     $('#enlace-nosotros1').on('click', function(e){
        e.preventDefault();
        $('html, body').animate({
            scrollTop: nosotros -80
        },600);
    });

    $('#enlace-servicio').on('click', function(e){
        e.preventDefault();
        $('html, body').animate({
            scrollTop: servicios -60
        },600);
    });
     
       $('#enlace-proyecto').on('click', function(e){
        e.preventDefault();
        $('html, body').animate({
            scrollTop: proyecto -100
        },600);
    });
    $('#enlace-catalogo').on('click', function(e){
        e.preventDefault();
        $('html, body').animate({
            scrollTop: catalogo -100
        },600);
    });

      $('#enlace-contacto').on('click', function(e){
        e.preventDefault();
        $('html, body').animate({
            scrollTop: contacto -100
        },600);
    });
});
