<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%-- <jsp:include page="top.jsp"></jsp:include> --%>
    <div class="" align="center">
    
    <h1>对不起！操作失败!</h1>
    
    <div class="reindex"><a href="login.jsp" target="_parent">返回登录页面</a></div>
    
    </div>
</body>
</html>
