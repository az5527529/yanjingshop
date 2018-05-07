<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="top.jsp"></jsp:include>
    <div class="" align="center" style="    margin: 0 auto; width: 480px;">
    
    <h1>对不起！因余额不足，请充值！</h1>
    
    <div class="reindex"><a href="doChongZhi.action" target="_parent">返回充值页面！</a></div>
    <div class="reindex"><a href="index.action" target="_parent">返回首页</a></div>
    
    </div>
</body>
</html>
