<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="js/bootstrap/other/favicon.ico">
	<base href="<%= request.getContextPath()+"/"%>">
	 <script type="text/javascript" src="js/jquery.min.js"></script>
    <title></title>

    <!-- Bootstrap core CSS -->
    <link href="js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="js/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
 
	
	<script type="text/javascript">
			$(function(){
				
		    	$(".iframeTarget").click(function(){
		    		$(".nav nav-sidebar li").removeClass(".active");
		    		$(this).addClass(".active");
		        	var title = $(this).attr("title");
		           	$("#page-header").html(title);
		           	
		           	var url = $(this).attr("url");
		           	$("#iframe").attr("src",url);
		            $("#iframe").height($(window).height()); 
		      	});
			})

	</script>
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand iframeTarget" href="javascript:void(0);" url="background/welcome" title="welcome">商品后台管理</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">暂无</a></li>
            <li><a href="javascript:void(0);" url="sysUser/tologin" class="iframeTarget">登录 </a></li>
            <li><a href="#">暂无</a></li>
            <li><a href="#">暂无</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <!-- 左边连接 -->
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="javascript:void(0);" url="background/welcome" class="iframeTarget" title="welcome">首页 <span class="sr-only">首页</span></a></li>
            <li><a href="javascript:void(0);" url="product/list/1" class="iframeTarget" title="商品展示">商品展示</a></li>
            <li><a href="javascript:void(0);" url="adv/adv/1" class="iframeTarget" title="广告管理">广告管理</a></li>
         
          </ul>
    
        </div>
        <!-- 显示界面 -->
        <div class=" col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
         <h1 class="page-header" id="page-header">welcome</h1>
				<iframe id="iframe" style="border: 0; width: 100%; height:100%; background-color: #FFF;"
										frameborder="0" src="background/welcome" scrolling="no"> 
					</iframe>
		  
      </div>
    </div>

  </body>
</html>