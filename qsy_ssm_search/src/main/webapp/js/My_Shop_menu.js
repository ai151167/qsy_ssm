$(function() {
	$.ajax({
		type : "GET",
		dataType : "jsonp",
		url : "http://localhost:8080/productCategory/listJsonp/0",
		jsonpCallback : "call"
	});

	
});
function call(data) {
	console.log(data);
	
	var htmlStr = "";
	for (var i = 0; i < data.length; i++) {
		htmlStr += "<li id='cat_1' class=''>";
		htmlStr += "<h3><a href='' title=" + data[i].name + ">"+ data[i].name + "</a></h3>";
		
			if(data[i].children.length !=0){
				htmlStr += "<div id='cat_1_menu' class='cat_menu clearfix' style=''>";
				for (var j = 0; j < data[i].children.length; j++) {
					
					htmlStr += "<dl class='clearfix'>";
					htmlStr += "<dt><a href='" + data[i].children[j].name + "' href=''>" + data[i].children[j].name+ "</a></dt>";
					
					if(data[i].children[j].children !=null){
						htmlStr += "<dd>";	
							for (var z = 0; z < data[i].children[j].children.length; z++) {
								htmlStr += "<a href='"+data[i].children[j].children[z].name +"'>" + data[i].children[j].children[z].name + "</a>";
							}
							htmlStr += "</dd>";	
						}
					
					htmlStr += "</dl>";
					
				}
				htmlStr += "</div>";
			}
			
			htmlStr += "</li>";
		}

	$("#shop_menu").html(htmlStr);
	
	$(".shop_hd_menu_all_category_hd_menu li").hover(function() {
		$(this).addClass("hover");
	}, function() {
		$(this).removeClass("hover");
	});
	
}

