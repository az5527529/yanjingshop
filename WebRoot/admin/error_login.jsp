<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="top.jsp"></jsp:include>
    <div align="center" style="    margin: 0 auto; width: 480px;">
    
    <h1>对不起！操作失败!</h1>
    
    <div class="reindex"><a href="fore_login.jsp" target="_parent">返回登录</a></div>
    
    </div>
    <jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
