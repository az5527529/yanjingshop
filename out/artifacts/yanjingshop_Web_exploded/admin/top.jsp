<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="../files/Wq_StranJF.js"></script>

</head>

<body>
<!--头部-->
<div id="top-cont">
  <div id="top-min">
    <div id="min-left"><h1> 宝帛地毯网上销售系统 </h1></div>
    <div id="min-right"></div>
  </div>
</div>
<!--导航-->
<div id="menu">
  <div id="menu-m">
    <ul>
      <li><a href="index.action">首页</a></li>
      <li style="width:8px;"><img src="images/t1.jpg" width="10" height="42" /></li>
      <li><a href="showNews.action">新闻信息</a></li>
      <li style="width:8px;"><img src="images/t1.jpg" width="10" height="42" /></li>
      <li><a href="shownew.action">促销</a></li>
      <li style="width:8px;"><img src="images/t1.jpg" width="10" height="42" /></li>
      <li><a href="shownew2.action">商品</a></li>
      <li style="width:8px;"><img src="images/t1.jpg" width="10" height="42" /></li>
       <li ><a href="login.jsp" target="_blank">管理员登录</a></li>
       <li style="width:8px;"><img src="images/t1.jpg" width="10" height="42" /></li>
      <li><a href="shoplist.action"><img src="images/che.jpg" width="176" height="42" /></a></li>
    </ul>
  </div>
</div>

