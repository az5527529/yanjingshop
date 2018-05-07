<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="top.jsp"></jsp:include>
<div style="    margin: 0 auto; width: 480px;">
    <h1 >恭喜您操作成功！</h1>
  </div>
  <!--底部-->
<jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>
