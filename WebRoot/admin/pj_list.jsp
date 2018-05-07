<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的订单</title>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<link href="css/nf.lightbox.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/NFLightBox.js"></script>
<script type="text/javascript" src="js/shop.js"></script>
<style type="text/css">
.mask { /*遮罩层*/
    background-color:gray;
    left:0;
    position:absolute;
    top:0;
    z-index:100;
    filter:alpha(opacity=30);
   opacity:0.3;
}

div.dialog {
	width: 296px;
	height:173px;
	position: absolute;
	z-index: 101;
	display: none;
    background-image:url(images/dialog.png)
}

div.title {
	padding-top: 5px;
	padding-left:270px;
}
div.dialog div.content {

	height: 90px;
	text-align:center;

	font:bold 15px/90px Verdana, Geneva, sans-serif;
}

div.dialog div.bottom {
	text-align: right;
	padding: 10px 10px 10px 0px;
	border-top:1px dashed #999999;

}
div.bottom .btn1 {
	border:none;
	width: 63px;
	height: 29px;
	cursor:pointer;
	
}
div.bottom #btnSure{
	background-image:url(images/delSure.jpg);
}
div.bottom #btnCancel{
	background-image:url(images/delCancel.jpg);
}
</style>
</head>

<body>
<jsp:include page="top.jsp"></jsp:include>

<div id="shop">
  <div id="shop-t">
    <div id="shop-l"><img src="images/sh.jpg" width="74" height="67" /></div>
    <div id="shop-r">我的订单</div>
  </div>
  <div id="shop-inf">
    <ul>
      <li class="lx">订单号</li>
      <li class="xh" style="width:250px;">订单时间</li>
      <li class="dj" style="    width: 160px;">订单总额</li>
      <li class="dj">目前状态</li>
      <li class="cz" style="width:200px;">操作</li>
    </ul>
  </div>
  <%-- <form action="addorder?id=<s:property value="f.id" />" method="post"> --%>
  <div id="shop-xx">
   <s:iterator value="page.pageList"> 
   
    <ul id="shop1">
    
      <li class="lx">
      <s:property value="ono" />
       <%--  <div id="luxian">
        
          <ul>
            <li><a href="images/pic1.jpg" title="<s:property value="goods.name" />"><img src="./upload/<s:property value="goods.img" />" width="87" height="58"  /></a></li>
           
          </ul>
        </div> --%>
      </li>
      <li class="xh" style="width:250px;"><s:date name="date" format="yyyy-MM-dd HH:mm" /></li>
      <li class="dj" style="    width: 160px;"><s:property value="sum" />元</li>
      <li class="dj"><s:property value="ostate" /></li>
     
      <li class="cz" style="width:200px;">
      <s:if test="ostate=='已发货'">
      <a href="ordertuihuo.action?order.oid=<s:property value="oid" />" class="btnDel" ><span style="color:#F60; text-decoration:underline;"></span></a>
      <a href="ordershouhuo.action?id=<s:property value="oid" />" class="btnDel" ><span style="color:#F60; text-decoration:underline;">确认收货</span></a></s:if>
       <s:elseif test="ostate=='已支付'">已支付<%-- <a href="pj.action?id=<s:property value="oid" />" class="btnDel" ><span style="color:#F60; text-decoration:underline;">待评价</span></a> --%></s:elseif>
     <%-- <s:elseif test="ostate=='已支付，待发货'" > <span style="color:#F60; text-decoration:underline;">待发货</span>
      <a href="ordertuihuo.action?order.oid=<s:property value="oid" />" class="btnDel" ><span style="color:#F60; text-decoration:underline;">退货</span></a>
      </s:elseif><s:elseif test="ostate=='退货'">已退货，待回款</s:elseif>
      <s:elseif test="ostate=='已退货'">已回款</s:elseif> --%>
      </li>
    </ul>
    
   </s:iterator>
</div>
<div id="fanye">
<table>
<tr>
       <td colspan="2">当前显示第
			<s:property value="page.pageIndex" />
			页
			</td><td colspan="1">共
			<s:property value="page.totalpages" />
			页</td>
			<td colspan="4">
			<div align="center">
				<a href="orderpj.action?page.pageIndex=1"> 首页</a>
				<s:property value="totalpages" />
				<a <s:if test="page.pageIndex<=1"> href="javascript:false;"</s:if>
					<s:else>href="orderpj.action?page.pageIndex=<s:property value='page.pageIndex-1' />"</s:else>>上一页</a>
				<a
					<s:if test="page.pageIndex>=page.totalpages" > href="javascript:false;"</s:if>
					<s:else>href="orderpj.action?page.pageIndex=<s:property value='page.pageIndex+1' />"</s:else>>下一页</a>
				<a
					href="orderpj.action?page.pageIndex=<s:property value="page.totalpages" />">末页</a>
			</div></td></tr> </table>

<!-- <a href="#">首页</a> <a href="#">上一页</a> <a href="#">下一页</a> <a href="#">尾页</a> --></div>

<!-- </form> -->
</div>

<!--底部-->
<jsp:include page="foot.jsp"></jsp:include>
<div class="mask"></div>


<div class="dialog">
  <div class="title">
    <img src="images/del.png" id="closePic" title="关闭"/> </div>
  <div class="content"> <p>您真的要删除这条记录吗？</p></div>
  <div class="bottom">
    <input type="button" value="" class="btn1"  id="btnSure"/>
    <input type="button" value="" class="btn1" id="btnCancel" />
  </div>
</div>
</body>
</html>
