<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>宝帛地毯网上销售系统  后台管理中心</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1 style="color:#000;"><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />宝帛地毯网上销售系统后台管理中心</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="http://localhost:8080/yanjingshop/admin/index.action" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<!-- <a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a>  -->&nbsp;&nbsp;<a class="button button-little bg-red" href="hexit.action"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title" style="color:#000;"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>信息管理</h2>
  <ul style="display:block">
  <s:if test="#session.cuser.uname=='admin'">
    <li><a href="upage.action" target="right"><span class="icon-caret-right"></span>用户管理</a></li>
    <li><a href="upage2.action" target="right"><span class="icon-caret-right"></span>供应商管理</a></li>
    </s:if>
     <li><a href="supage.action" target="right"><span class="icon-caret-right"></span>个人信息管理</a></li>
  </ul>  
   <s:if test="#session.cuser.uname=='admin'">
  <h2><span class="icon-pencil-square-o"></span>基础信息</h2>
  <ul>
    <li><a href="showguanggao.action" target="right"><span class="icon-caret-right"></span>新闻管理</a></li>        
  </ul> 
  </s:if>
   <h2><span class="icon-pencil-square-o"></span>商品管理</h2>
  <ul>
    <li><a href="queryGoods.action" target="right"><span class="icon-caret-right"></span>商品管理</a></li>
    <li><a href="ftypelist.action" target="right"><span class="icon-caret-right"></span>商品类别管理</a></li> 
  </ul> 
   <h2><span class="icon-pencil-square-o"></span>订单管理</h2>
  <ul>
    <li><a href="orderlist_wl.action" target="right"><span class="icon-caret-right"></span>订单管理</a></li>
    <%-- <li><a href="tj1.jsp" target="right"><span class="icon-caret-right"></span>销售量统计分析</a></li>         --%>
  </ul>  

 <%--    <h2><span class="icon-pencil-square-o"></span>订单管理</h2>
  <ul>
    <li><a href="orderlist_wl.action" target="right"><span class="icon-caret-right"></span>订单管理</a></li>        
  </ul>  --%> 
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
 
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="info.jsp" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
<!-- <p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p> -->
</div>
</body>
</html>