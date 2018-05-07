<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="top.jsp"></jsp:include>
    
     <div class="" align="center" style="margin:0 auto;width:480px;">
    
    <h2>对不起！请先登录、充值后操作！</h2>
    <div class="reindex"><a href="fore_login.jsp" target="_parent">返回登录页面</a></div>
    <div class="reindex"><a href="regist.jsp" target="_parent">返回注册页面</a></div>
    
    </div>
    <!--底部-->
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
