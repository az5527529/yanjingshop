<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="top.jsp"></jsp:include>
    
    <div class="error" align="center" style="    margin: 0 auto; width: 480px;">
    
    <h1>非常遗憾，您访问的页面不存在！确认下你的操作是否有误！</h1>
  
    
    
    </div>
<!--底部-->
<jsp:include page="foot.jsp"></jsp:include>
