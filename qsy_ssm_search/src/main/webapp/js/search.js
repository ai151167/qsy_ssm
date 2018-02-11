$(function() {
	$(".pageUpdate").live("click",
					function() {
						var uri = $(this).attr("url");
						var content = $(this).attr("content");
						var pageNum = $(this).attr("pageNum");
						var total = $(this).attr("total");
						if (pageNum != null) {
							if (pageNum <= 0) {
								pageNum = 1;
								uri = "/search/searchSelect_ajax/" + pageNum
										+ "?search_content=" + content + "'";
							}
							if (pageNum > total) {
								pageNum = total;
								uri = "/search/searchSelect_ajax/" + total
										+ "?search_content=" + content + "'";
							}
						}
						$.ajax({
									async : true,
									url : uri,
									type : "get",
									success : function(data) {
										console.log(data);
										var htmlStr = "";
										for (var i = 0; i < data.list.length; i++) {
											htmlStr += "<li>";
											htmlStr += "<dl>";
											htmlStr += "<dt><a href='http://localhost:8085/goods/"
													+ data.list[i].id
													+ ".html'><img src="
													+ data.list[i].images
													+ " /></a></dt>";
											htmlStr += "<dd class='title'><a href='http://localhost:8085/goods/"
													+ data.list[i].id
													+ ".html'>"
													+ data.list[i].name
													+ "</a></dd>";
											htmlStr += "<dd class='content'>";
											htmlStr += "<span class='goods_jiage'>￥<strong>"
													+ data.list[i].price
													+ "</strong></span>";
											htmlStr += "<span class='goods_chengjiao'>最近成交5笔</span>";
											htmlStr += "</dd>";
											htmlStr += "</dl>";
											htmlStr += "</li>";

										}
										$("#images").html(htmlStr);
										var HtmlPage = "";
										HtmlPage += "<ul >";
										HtmlPage += "<a class='pageUpdate' href='javascript:void(0);' url='http://localhost:8087/search/searchSelect_ajax/1?search_content="
												+ content
												+ "' content='"
												+ content
												+ "' total='"
												+ data.pages
												+ "' ><li><span>首页</span></li></a>";
										HtmlPage += "<a class='pageUpdate' href='javascript:void(0);' url='http://localhost:8087/search/searchSelect_ajax/"
												+ (data.pageNum - 1)
												+ "?search_content="
												+ content
												+ "' pageNum='"
												+ (data.pageNum - 1)
												+ "' content='"
												+ content
												+ "' total='"
												+ data.pages
												+ "'><li><span>上一页</span></li></a>";
										for (var j = 0; j < data.navigatepageNums.length; j++) {
											if (data.navigatepageNums[j] == data.pageNum) {
												HtmlPage += "<a class='pageUpdate' href='javascript:void(0);' url='http://localhost:8087/search/searchSelect_ajax/"
														+ data.navigatepageNums[j]
														+ "?search_content="
														+ content
														+ "' content='"
														+ content
														+ "'> <li><span class='currentpage'>"
														+ data.navigatepageNums[j]
														+ "</span></li></a>";
											} else {
												HtmlPage += "<a class='pageUpdate' href='javascript:void(0);' url='http://localhost:8087/search/searchSelect_ajax/"
														+ data.navigatepageNums[j]
														+ "?search_content="
														+ content
														+ "' content='"
														+ content
														+ "'> <li><span>"
														+ data.navigatepageNums[j]
														+ "</span></li></a>";
											}
										}
										HtmlPage += "<a class='pageUpdate' href='javascript:void(0);' url='http://localhost:8087/search/searchSelect_ajax/"
												+ (data.pageNum + 1)
												+ "?search_content="
												+ content
												+ "' content='"
												+ content
												+ "' pageNum='"
												+ (data.pageNum + 1)
												+ "' total='"
												+ data.pages
												+ "' ><li><span>下一页</span></li></a>";
										HtmlPage += "<a class='pageUpdate' href='javascript:void(0);' url='http://localhost:8087/search/searchSelect_ajax/"
												+ data.pages
												+ "?search_content="
												+ content
												+ "' content='"
												+ content
												+ "' total='"
												+ data.pages
												+ "'><li><span>末页</span></li></a>";
										HtmlPage += "</ul >";
										HtmlPage += "<div class='col-md-5 col-md-offset-1' style='font-size: medium;'>";
										HtmlPage += "当前第" + data.pageNum
												+ "页，共" + data.total + "条记录，共有"
												+ data.pages + "页";
										HtmlPage += "</div>";
										$("#pageChange").html(HtmlPage);
									}
								});
					});
});
