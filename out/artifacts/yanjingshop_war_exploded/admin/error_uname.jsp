<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="top.jsp"></jsp:include>
    <div class="" align="center" style="    margin: 0 auto; width: 480px;">
    
    <h1>对不起！操作失败,您输入的用户名不正确，<br><a href="fore_losspwd0.jsp" target="_parent">请重新输入</a></h1>
    
   
    
    </div>
<!--底部-->
<jsp:include page="foot.jsp"></jsp:include>
