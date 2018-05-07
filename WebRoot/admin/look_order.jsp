<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="top.jsp"></jsp:include>
<div style="    margin: 0 auto; width: 480px;"> <h1 align="center">恭喜您查询成功！</h1></div>
   
         <h1 align="center">订单：<s:property value="order.ostate" /></h1>
     <div class="reindex" align="center"><a href="index.action" target="_parent">返回首页</a></div>
  
  <!--底部-->
<jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>
