$(function() {
	var cookies = document.cookie.replace(/[ ]/g, "");
	var split = cookies.split(";");
	var key = '';
	for (var i = 0; i < split.length; i++) {
		if (split[i].split("=")[0] == "token_id") {
			key = split[i].split("=")[1].substring(1,split[i].split("=")[1].length-1);
			break;
		}
	}
	if(key !='' ){
		$.ajax({
			url : "http://localhost:8086/jedis/get/" + key,
			dataType : "jsonp",
			type : "get",
			jsonpCallback : "cache"
		});

		$(".logout").live("click", function() {
			var date = new Date();
			cookie = "token_id=" + key + ";expires=" + date.toGMTString();
			var uri = $(this).attr("url");
			$.ajax({
				type : "get",
				url : uri + key,
				dataType : "jsonp",
				jsonpCallback : "logout"
			});
		});
	}
	
});
function cache(data) {
	if (data != null) {
		var strHtml = "";
		strHtml += "<p>您好，欢迎"
				+ data
				+ "来到<b><a href='http://localhost:8083/front/index'>ShopCZ商城</a></b>";
		strHtml += "[<a class='logout' href='javascript:void(0);' url='http://localhost:8086/jedis/del/'>注销</a>]</p>";
		$(".shop_hd_topNav_all_left").html(strHtml);
	}

}
function logout(data) {
	console.log(data);
	var strHtml = "";
	strHtml += "<p>您好，欢迎来到<b><a href='http://localhost:8083/front/index'>ShopCZ商城</a></b>";
	strHtml += "[<a href='http://localhost:8084/login/tologin'>登录</a>][<a href='http://localhost:8089/register/show'>注册</a>]</p>";
	$(".shop_hd_topNav_all_left").html(strHtml);
}
