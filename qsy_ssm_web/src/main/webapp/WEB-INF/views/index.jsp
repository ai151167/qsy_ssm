<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%= request.getContextPath()+"/"%>">
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="js/bootstrap/css/bootstrap.min.css">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="js/bootstrap/js/bootstrap.min.js"></script>

<!-- Custom styles for this template -->
    <link href="/css/signin.css" rel="stylesheet">

<script type="text/javascript" src="js/uploadify/jquery.uploadifive.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/uploadify/uploadifive.css" />

	<script type="text/javascript">

		$(function() {
			
			function limitImage(type){
				$("#"+type+"_proimage").uploadifive({
					removeCompleted : true,
					buttonText : '选择图片',
					height : 30,
					uploadScript : '/images/upload',
					width : 220,
					fileObjName : 'file',
					onUploadComplete : function(file, data) {
						$("#"+type+"_showImage").attr("src", data);
						$("#"+type+"_showImage").show();
						$("#"+type+"_saveImage").val(data);
					}
				});
			}
			
			function limitSelect(type,id){
				//-----下拉框
				$.getJSON("productCategory/list/0", function(data) {
					var options;
					for(var i=0;i<data.length;i++){
						if(data[i].id==id){
							options +=
									"<option value='"+data[i].id+"' selected='selected'>" + data[i].name
									+ "</option>";
						}else{
							options +=
									"<option value='"+data[i].id+"'>" + data[i].name
											+ "</option>";
						}
					}
				
					$("#"+type+"_choose").html(options);
					
					if(type=="add"){
						$("#add_categoryName").val(data[0].name);
					}
					
				});
				$("#"+type+"_choose").change(function() {
					$("#"+type+"_categoryName").val($("#"+type+"_choose option:selected ").text());
				});
			}
			
			//-----添加
			$("#add").click(function() {
				limitImage("add");
				limitSelect("add");
				saves("add");
				$("#addModal").modal({
					backdrop : 'static'					
				})
				
			})
			//-------保存
			function saves(type){
				$("#"+type+"_save").click(function() {

					$.ajax({
						url : "/product/"+type+"Pro",
						type : 'post',// 提交的方式
						data : $("#"+type+"_Form").serialize(),
						success : function(msg) {
							if (msg == "addOk") {
								location.href = "/product/list/" + ${pageInfo.pages+1};
							} else if(msg == "updateOk"){
								location.href = "/product/list/" + ${pageInfo.pageNum};
							} else {
								alert("保存失败!");
							}
						}

					});
				});
			}
					
			//-------单个删除
			$(".btn_del").click(function() {
				if(confirm("是否确认删除")){
					var id = $(this).attr("btn_id");
					$.ajax({
						url : "product/delSinglePro/" + id,
						type : 'post',// 提交的方式
						success : function(msg) {
							if (msg == "delOk") {
								alert("删除成功!");
								location.href = "/product/list/" +1;
							} else {
								alert("删除失败!");
							}
						}
					});
				}	
			});

			//---------修改回显
			$(".btn_update").click(function() {
				var id = $(this).attr("btn_id");
				$.ajax({
					url : "product/SinglePro/"+id,
					type : 'GET',// 提交的方式
					success : function(MSG) {
						
						if (MSG != null) {
							$("#id").val(MSG.product.id);
							$("#name").val(MSG.product.name);
							$("#price").val(MSG.product.price);
							$("#salePoint").val(MSG.product.salePoint);
							$("#update_showImage").show();
							$("#update_showImage").attr("src", MSG.product.images);
							$("#update_saveImage").val(MSG.product.images);
							$("#update_choose").val(MSG.product.categoryId);
							$("#update_categoryName").val(MSG.product.categoryName);
							$("#Desc").text(MSG.productDesc);
							
							limitImage("update");
							limitSelect("update",MSG.product.categoryId);
							saves("update");
							
							$("#updateModal").modal({
								backdrop : 'static'
							})
						}

					}
				});
			})

			//---------删除全选
			$("#btn_id_all").click(function() {
				$(".check_id").prop("checked" ,$("#btn_id_all").prop("checked"));
			});
			
			$(".check_id").click(function(){
				$("#btn_id_all").prop("checked",$(".check_id").length==$(".check_id:checked").length)
			});
			$("#delAll").click(function(){
				if(confirm("是否确认全部删除")){
					var ids  = "";
					var del_ids = $(".check_id:checked");
					for(var i=0;i<del_ids.length;i++){
						ids +=del_ids[i].value+",";
					}
					if(ids!=""){
						$.ajax({
							url:"product/delAllPro/"+ids,
							type:"POST",
							success:function(response){
								if(response=="delAllOk"){
									alert("删除成功!");
									location.href = "/product/list/" + 1;
								}else{
									alert("删除失败!");
								}
							}
						})
					}
				}
			});	
		});
	</script>
</head>
<body>
	 <div class="row">
		  <div class="col-md-11 col-md-offset-1">后台管理</div>
	</div>
	<div class="row">
		  <div class="col-md-8"></div>
			  <div class="col-md-3 col-md-offset-1">
					<button type="button" class="btn btn-primary" id="add">添加</button>
		  		    <button type="button" class="btn btn-danger" id="delAll">删除</button>
	  		  </div>
	</div>
		<!-- 信息展示 -->
		<div class="row">
		  <div class="col-md-1">
		  </div>
			<div class="col-md-10">
		  	<table class="table table-hover">
  				<thead>
  					<tr>
  						<td>
  						<input type="checkbox" id="btn_id_all">
  						</td>
  						<td>商品名称</td>
  						<td>商品价格</td>
  						<td>商品类别</td>
  						<td>商品图片</td>
  						<td>商品卖点</td>
  						<td>操作</td>
  					</tr>
  				</thead>
  				<tbody>
  				<c:forEach items="${pageInfo.list}" var="pro">
  					<tr>
  						<td>
  							<input type="checkbox" class="check_id" value="${pro.id}">
  						</td>
  						<td>${pro.name}</td>
  						<td>${pro.price}</td>
  						<td>${pro.categoryName}</td>
  						<td>
  							<img alt="暂无图片" src="${pro.images}" class="img-rounded" style="width: 200px;height: 100px">
  						</td>
  						<td>${pro.salePoint}</td>
  						<td>
  							<button type="button" class="btn btn-primary btn-sm btn_update" btn_id="${pro.id}">编辑</button>
  							<button type="button" class="btn btn-danger btn-sm btn_del" btn_id="${pro.id}">删除</button>
  						</td>
  					</tr>
  				</c:forEach>	
  				</tbody>
			</table>
		  </div>
		 
		  <div class="col-md-1">
		  </div>
		</div>
			<!-- 分页 -->
			<div class="row">
			  <div class="col-md-5 col-md-offset-1">
			  		当前第${pageInfo.pageNum}页，共${pageInfo.total}条记录，共有${pageInfo.pages}页
			  </div>
			  <div class="col-md-4 col-md-offset-2">
			  		<nav aria-label="Page navigation">
						  <ul class="pagination">
						   <li><a href="/product/list/1">首页</a></li>
						    <li>
						      <a href="/product/list/${pageNum-1}" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
						    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
						    <c:if test="${pageNum==pageInfo.pageNum}">
							    <li class="active"><a href="/product/list/${pageNum}">${pageNum}</a></li>
							 </c:if>
							 <c:if test="${pageNum!=pageInfo.pageNum}">
							    <li><a href="/product/list/${pageNum}">${pageNum}</a></li>
							</c:if>
							</c:forEach>
						    <li>
						      <a href="/product/list/${pageNum+1}" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </li>
						     <li><a href="/product/list/${pageInfo.pages}">尾页</a></li>
						  </ul>
					</nav>
			  </div>
			</div>
	<!-- 添加 -->
		<div class="modal fade" tabindex="-1" role="dialog" id="addModal">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title"><font style="font-weight: bold;">添加商品</font></h4>
		      </div>
		      <div class="modal-body">
		           
		           <div class="form-group">

				      <form class="form-signin from_id" action="/product/addPro" id="add_Form">
					       	<div class="input-group">
							  <span class="input-group-addon" id="basic-addon1">商品名称</span>
							  <input type="text" class="form-control" name="product.name" placeholder="商品名称" aria-describedby="basic-addon1">
							</div> 
					       	<div class="input-group">
							  <span class="input-group-addon" id="basic-addon1">商品价格</span>
							  <input type="text" class="form-control" name="product.price" placeholder="商品价格" aria-describedby="basic-addon1">
							</div> 
					       	<div class="input-group">
							  <span class="input-group-addon" id="basic-addon1"> 商品卖点</span>
							  <input type="text" class="form-control" name="product.salePoint" placeholder="商品卖点" aria-describedby="basic-addon1" >
							</div> 
							<div class="input-group">
							<span class="input-group-addon" id="basic-addon1">商品图片</span>
					       	
					        <img src="选择图片" alt="选择图片" id="add_showImage" class="img-rounded" style="height: 100px; width: 220px; display: none">
					     	  <a id="add_proimage">添加图片</a>
					        <input type="hidden" id="add_saveImage" name="product.images" values=""/>
					       	</div> 
						    <span class="input-group-addon" id="basic-addon1">商品类型</span>
					      	<select class="form-control choose" name="product.categoryId" id="add_choose">
								</select>
								 <input type="hidden" name="product.categoryName" id="add_categoryName" value=""/><br/>
					       	<div class="input-group">
							  <span class="input-group-addon" id="basic-addon1">商品详情</span>
							  <textarea class="form-control" rows="3" name="productDesc" placeholder="商品详情" aria-describedby="basic-addon1"></textarea>
							</div> 
				      </form>
				    </div> <!-- /container -->
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        <button type="button" class="btn btn-primary" id="add_save">保存</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
		<!-- ================修改=================== -->
		<div class="modal fade" tabindex="-1" role="dialog" id="updateModal">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" ><font style="font-weight: bold;">修改商品</font></h4>
		      </div>
		      <div class="modal-body">
		           <div class="form-group">

				      <form class="form-signin from_id" action="/product/updatePro" id="update_Form">
				     		 <input type="hidden" id="id" name="product.id" value=""/>
					       	<div class="input-group" >
							  <span class="input-group-addon" id="basic-addon1">商品名称</span>
							  <input type="text" class="form-control" id="name" name="product.name" value="" placeholder="商品名称" aria-describedby="basic-addon1">
							</div> 
					       	<div class="input-group">
							  <span class="input-group-addon" id="basic-addon1">商品价格</span>
							  <input type="text" class="form-control" id="price" name="product.price" placeholder="商品价格" aria-describedby="basic-addon1">
							</div> 
					       	<div class="input-group">
							  <span class="input-group-addon" id="basic-addon1"> 商品卖点</span>
							  <input type="text" class="form-control" id="salePoint" name="product.salePoint" value="" placeholder="商品卖点" aria-describedby="basic-addon1" >
							</div> 
							<div class="input-group">
							<span class="input-group-addon" id="basic-addon1">商品图片</span>
					       
					        <img src="" alt="选择图片" id="update_showImage" class="img-rounded" style="height: 100px; width: 220px; display: none">
					       	<a id="update_proimage">添加图片</a>
					        <input type="hidden" id="update_saveImage" name="product.images" values=""/>
					       	</div> 
						    <span class="input-group-addon" id="basic-addon1">商品类型</span>
					      	<select class="form-control choose" name="product.categoryId" id="update_choose">
								</select>
								 <input type="hidden" name="product.categoryName" id="update_categoryName" value=""/><br/>
					       	<div class="input-group">
							  <span class="input-group-addon" id="basic-addon1">商品详情</span>
							  <textarea class="form-control" id="Desc" rows="3" name="productDesc" placeholder="商品" aria-describedby="basic-addon1"></textarea>
							</div> 
				      </form>
				    </div> <!-- /container -->
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        <button type="button" class="btn btn-primary" id="update_save">修改</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
</body>
</html>