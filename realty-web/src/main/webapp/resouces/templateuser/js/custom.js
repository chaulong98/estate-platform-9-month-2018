$(document).ready(function() {
	$( ".menu" ).click(function() {
		$( ".header-menu-right" ).toggle();
	});
	$( ".header-span-1" ).click(function() {
		$(this).parent(".header-list-menu li").find(".header-menu-species-1").toggle();
	});
	$( ".span1" ).click(function() {
		$(this).parent(".list-menu-item li").find(".menu-species1").toggle();
	});
	$( ".sizebar-span1" ).click(function() {
		$(this).parent(".list-menu li").find(".menu-species1").toggle();
	});
	$("#list-slide").owlCarousel({
		items : 3, //3 items above 1000px browser width
		itemsDesktop : [1024,2], //2 items between 1024px and 901px
		itemsDesktopSmall : [900,2], // 2 items betweem 900px and 601px
		itemsTablet: [600,1], //1 items between 600 and 0;
		itemsMobile : [320,1],
		navigation : true,
		navigationText : ["<a class=\"flex-prev fa fa-angle-left\"></a>","<a class=\"flex-next fa fa-angle-right\"></a>"],
		pagination : false
	});
	$("#list-slide-logo").owlCarousel({
		items : 6, //6 items above 1000px browser width
		itemsDesktop : [1024,6], //6 items between 1024px and 901px
		itemsDesktopSmall : [900,4], // 4 items betweem 900px and 601px
		itemsTablet: [600,4], //4 items between 600 and 0;
		itemsMobile : [320,2],
		navigation : true,
		navigationText : ["<a class=\"flex-prev fa fa-angle-left\"></a>","<a class=\"flex-next fa fa-angle-right\"></a>"],
		pagination : false
	});
	$("#list-slide-product").owlCarousel({
		items : 4, //4 items above 1000px browser width
		itemsDesktop : [1024,4], //4 items between 1024px and 901px
		itemsDesktopSmall : [900,2], // 2 items betweem 900px and 601px
		itemsTablet: [600,2], //2 items between 600 and 0;
		itemsMobile : [320,1],
		navigation : true,
		navigationText : ["<a class=\"flex-prev fa fa-angle-left\"></a>","<a class=\"flex-next fa fa-angle-right\"></a>"],
		pagination : false
	});
	$("#slide-section-7").owlCarousel({
		items : 1, //4 items above 1000px browser width
		itemsDesktop : [1024,1], //4 items between 1024px and 901px
		itemsDesktopSmall : [900,1], // 2 items betweem 900px and 601px
		itemsTablet: [600,1], //2 items between 600 and 0;
		itemsMobile : [320,1],
		navigation : true,
		navigationText : ["<a class=\"flex-prev fa fa-angle-left\"></a>","<a class=\"flex-next fa fa-angle-right\"></a>"],
		pagination : false
	});
	$("#slide-section-8").owlCarousel({
		items : 6, //4 items above 1000px browser width
		itemsDesktop : [1024,4], //4 items between 1024px and 901px
		itemsDesktopSmall : [900,3], // 2 items betweem 900px and 601px
		itemsTablet: [600,2], //2 items between 600 and 0;
		itemsMobile : [320,1],
		navigation : true,
		navigationText : ["<a class=\"flex-prev fa fa-angle-left\"></a>","<a class=\"flex-next fa fa-angle-right\"></a>"],
		pagination : false
	});
	$("#slide-all-item").owlCarousel({
		items : 4, //3 items above 1000px browser width
		itemsDesktop : [1024,4], //2 items between 1024px and 901px
		itemsDesktopSmall : [900,3], // 2 items betweem 900px and 601px
		itemsTablet: [600,2], //1 items between 600 and 0;
		itemsMobile : [320,1],
		navigation : true,
		navigationText : ["<a class=\"flex-prev fa fa-angle-left\"></a>","<a class=\"flex-next fa fa-angle-right\"></a>"],
		pagination : false
	});
	$("#list-produce").owlCarousel({
		items : 3, //3 items above 1000px browser width
		itemsDesktop : [1024,3], //2 items between 1024px and 901px
		itemsDesktopSmall : [900,3], // 2 items betweem 900px and 601px
		itemsTablet: [600,1], //1 items between 600 and 0;
		itemsMobile : [320,1],
		navigation : true,
		navigationText : ["<a class=\"flex-prev fa fa-angle-left\"></a>","<a class=\"flex-next fa fa-angle-right\"></a>"],
		pagination : false
	});
	$(window).scroll(function () {
		if ($(window).scrollTop() > 0) {
			$('.back-top').fadeIn();
		} else {

			$('.back-top').fadeOut();
		}
	});
	$('.back-top').click(function () {
		$('html, body').animate({ scrollTop: 0 }, 800);
	});
	$("#zoom_01").elevateZoom({scrollZoom : true});
	$("#zoom_02").elevateZoom({scrollZoom : true});
	$("#zoom_03").elevateZoom({scrollZoom : true});
	$("#zoom_04").elevateZoom({scrollZoom : true});
	$("#zoom_05").elevateZoom({scrollZoom : true});
	$("#zoom_06").elevateZoom({scrollZoom : true});
	$("#zoom_07").elevateZoom({scrollZoom : true});
	$("#zoom_08").elevateZoom({scrollZoom : true});
});