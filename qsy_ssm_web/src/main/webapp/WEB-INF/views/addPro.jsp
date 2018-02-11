<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.contextPath}/">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/uploadify/jquery.uploadifive.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/uploadify/uploadifive.css" />
<script type="text/javascript">
	$(function() {
		$("#proimage").uploadifive({
			removeCompleted : true,
			buttonText : '选择图片',
			height : 30,
			uploadScript : '/images/upload',
			width : 120,
			fileObjName : 'file',
			onUploadComplete : function(file, data) {
				$("#showImage").attr("src", data);
				$("#showImage").show();
				$("#saveImage").val(data);
			}
		});
		
			$.getJSON("productCategory/list/0",function(data){
				
				$.each(data,function(key,items){
					$("#choose").append("<option value='"+items.id+"'>"+items.name+"</option>");
				})	
				$("#categoryName").val(data[0].name)
			});
			
			
			$("#choose").bind("click", function(){
				  $("#categoryName").val($("select option:selected").text())
				});
		});
		
</script>
</head>
<body>

	<form action="product/addPro" method="post">
		<a id="proimage">添加图片</a>
		<img alt="选择图片" src="" id="showImage" style="height: 300px; width: 500px; display: none"/>
	 	 	<input type="hidden" id="saveImage" name="product.images" values=""/> <br /> 
			产品名:<input type="text" name="product.name"/> <br /> 
			产品价格:<input type="text" name="product.price"/> <br />
		          卖点:<input type="text" name="product.salePoint"/> <br /> 
			产品类型:<select name="product.categoryId" id="choose">
		    	 </select><br />  
		     <input type="hidden" name="product.categoryName" id="categoryName" value=""/><br/>
		产品详情: <br />
		<textarea rows="10" cols="33" name="productDesc"></textarea>
		<br/> 
		<input type="submit" value="提交"/>
	</form>

</body>
</html>