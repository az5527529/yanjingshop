<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%-- <jsp:include page="top.jsp"></jsp:include> --%>
<div align="center">
    <h1 >恭喜您操作成功！</h1>
    <!--  <div class="reindex"><a href="http://localhost/yanjingshop/admin/login.jsp" target="_parent">返回首页</a></div> -->
  </div>
  <!--底部-->
<%-- <jsp:include page="foot.jsp"></jsp:include> --%>
  </body>
</html>
