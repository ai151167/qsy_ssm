/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-09-22 09:48:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <link rel=\"icon\" href=\"js/bootstrap/other/favicon.ico\">\r\n");
      out.write("\t<base href=\"");
      out.print( request.getContextPath()+"/");
      out.write("\">\r\n");
      out.write("\t <script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\r\n");
      out.write("    <title></title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("    <link href=\"js/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"js/bootstrap/css/bootstrap-theme.min.css\" rel=\"stylesheet\"/>\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"css/dashboard.css\" rel=\"stylesheet\">\r\n");
      out.write(" \r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t$(function(){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t    \t$(\".iframeTarget\").click(function(){\r\n");
      out.write("\t\t    \t\t$(\".nav nav-sidebar li\").removeClass(\".active\");\r\n");
      out.write("\t\t    \t\t$(this).addClass(\".active\");\r\n");
      out.write("\t\t        \tvar title = $(this).attr(\"title\");\r\n");
      out.write("\t\t           \t$(\"#page-header\").html(title);\r\n");
      out.write("\t\t           \t\r\n");
      out.write("\t\t           \tvar url = $(this).attr(\"url\");\r\n");
      out.write("\t\t           \t$(\"#iframe\").attr(\"src\",url);\r\n");
      out.write("\t\t            $(\"#iframe\").height($(window).height()); \r\n");
      out.write("\t\t      \t});\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\r\n");
      out.write("\t</script>\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("\r\n");
      out.write("    <nav class=\"navbar navbar-inverse navbar-fixed-top\">\r\n");
      out.write("      <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("          <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\r\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("          </button>\r\n");
      out.write("          <a class=\"navbar-brand iframeTarget\" href=\"javascript:void(0);\" url=\"background/welcome\" title=\"welcome\">商品后台管理</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"navbar\" class=\"navbar-collapse collapse\">\r\n");
      out.write("          <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("            <li><a href=\"#\">暂无</a></li>\r\n");
      out.write("            <li><a href=\"javascript:void(0);\" url=\"sysUser/tologin\" class=\"iframeTarget\">登录 </a></li>\r\n");
      out.write("            <li><a href=\"#\">暂无</a></li>\r\n");
      out.write("            <li><a href=\"#\">暂无</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("          <form class=\"navbar-form navbar-right\">\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" placeholder=\"Search...\">\r\n");
      out.write("          </form>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("    <!-- 左边连接 -->\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <div class=\"col-sm-3 col-md-2 sidebar\">\r\n");
      out.write("          <ul class=\"nav nav-sidebar\">\r\n");
      out.write("            <li class=\"active\"><a href=\"javascript:void(0);\" url=\"background/welcome\" class=\"iframeTarget\" title=\"welcome\">首页 <span class=\"sr-only\">首页</span></a></li>\r\n");
      out.write("            <li><a href=\"javascript:void(0);\" url=\"product/list/1\" class=\"iframeTarget\" title=\"商品展示\">商品展示</a></li>\r\n");
      out.write("            <li><a href=\"javascript:void(0);\" url=\"adv/adv/1\" class=\"iframeTarget\" title=\"广告管理\">广告管理</a></li>\r\n");
      out.write("         \r\n");
      out.write("          </ul>\r\n");
      out.write("    \r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- 显示界面 -->\r\n");
      out.write("        <div class=\" col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n");
      out.write("         <h1 class=\"page-header\" id=\"page-header\">welcome</h1>\r\n");
      out.write("\t\t\t\t<iframe id=\"iframe\" style=\"border: 0; width: 100%; height:100%; background-color: #FFF;\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tframeborder=\"0\" src=\"background/welcome\" scrolling=\"no\"> \r\n");
      out.write("\t\t\t\t\t</iframe>\r\n");
      out.write("\t\t  \r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
