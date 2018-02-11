$(function(){
	$.ajax({
		type : "get",
		dataType : "jsonp",
		url : "http://localhost:8080/adv/advJsonp",
		jsonpCallback : "callPic"
	});
	
})
function callPic(data){
	console.log(data)
	var htmlStr = "";
			htmlStr +="<div>";
			htmlStr +="<dl class=''></dl>";
		
		for(var i=0;i<data.length;i++){
			htmlStr +=" <dl class=''>";
			htmlStr +="<dt><a href='"+data[i].images+"' title='' target='_blank'><img src='"+data[i].images+"' alt='"+data[i].title+"'></a></dt>";
			htmlStr +="<dd><h2><a href='"+data[i].images+"' target='_blank'>"+data[i].title+"</a></h2></dd>";
			htmlStr +="</dl>";
		}
		
			htmlStr +="</div>";
		
	$("#xifan_bd1lfimg").html(htmlStr);
	

}