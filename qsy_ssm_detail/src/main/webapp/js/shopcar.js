$(function(){
	$(".goods_sub").click(function(){
		var count = $("#good_nums").val();
		var pro_id = $(this).attr("pro_id");
			$.ajax({
				type:"get",
				dataType:"jsonp",
				url:"http://localhost:8088/shopcar/add?product_id="+pro_id+"&count="+count,
				jsonpCallback:"shopCar"
			});
	});
});
function shopCar(data){
	alert("已添加到购物车");
	$(".topNavHover b").text(data);
}