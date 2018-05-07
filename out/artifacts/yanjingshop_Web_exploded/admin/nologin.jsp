<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="top.jsp"></jsp:include>
    
   
    
     <div style="    margin: 0 auto; width: 480px;" >
     
     <h3>请重新登录后再操作！</h3></div> 
   <div  align="center">
    <div class="reindex"><h2><a href="fore_login.jsp" target="_parent">返回登录页面</a></h2></div>
    <div class="reindex"><h2><a href="regist.jsp" target="_parent">返回注册页面</a></h2></div>
    
    </div>
    <!--底部-->
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
