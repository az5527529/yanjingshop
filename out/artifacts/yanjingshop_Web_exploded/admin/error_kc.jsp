<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="top.jsp"></jsp:include>
    <div class="" align="center" style="    margin: 0 auto; width: 480px;">
    
    <h1>对不起！库存不足！</h1>
    
    <div class="reindex"><a href="index.action" target="_parent">返回</a></div>
    
    </div>
    <jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
