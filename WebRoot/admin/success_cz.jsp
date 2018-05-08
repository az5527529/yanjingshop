<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="top.jsp"></jsp:include>
<div align="center" style="    margin: 0 auto; width: 480px;">
  <h1> 恭喜您充值成功！余额为：<s:property value="u.money" /> </h1>
   <div class="reindex"><a href="index.action" target="_parent">返回首页</a></div>
  </div>
  <!--底部-->
<jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>
