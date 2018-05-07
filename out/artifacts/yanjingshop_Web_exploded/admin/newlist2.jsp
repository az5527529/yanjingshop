<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="top.jsp"></jsp:include>
<!--主体内容第一部分开始-->
<div class="tuangouy">
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<table class="table table-hover text-center">
<tr>
<td>序号</td><td>标题</td><td></td>
</tr>
  <s:iterator value="page.pageList" >
<tr>
<td><s:property value="ggid" /></td>
<td ><a href="showoneNews2.action?gg.ggid=<s:property value="ggid" />"><s:property value="name" /></a></td>
<td><%-- <img src="upload/<s:property value="ggpic" />" width="50" height="50">  --%></td>
</tr>
</s:iterator>
  <tr>
       <td colspan="1">当前显示第
			<s:property value="page.pageIndex" />
			页
			</td><td colspan="1">共
			<s:property value="page.totalpages" />
			页</td>
			<td colspan="1">
			<div align="center">
				<a href="ShowNewList.action?page.pageIndex=1"> 首页</a>
				<s:property value="totalpages" />
				<a <s:if test="page.pageIndex<=1"> href="javascript:false;"</s:if>
					<s:else>href="ShowNewList.action?page.pageIndex=<s:property value='page.pageIndex-1' />"</s:else>>上一页</a>
				<a
					<s:if test="page.pageIndex>=page.totalpages" > href="javascript:false;"</s:if>
					<s:else>href="ShowNewList.action?page.pageIndex=<s:property value='page.pageIndex+1' />"</s:else>>下一页</a>
				<a
					href="ShowNewList.action?page.pageIndex=<s:property value="page.totalpages" />">末页</a>
			</div></td> </tr>


</table>
</div>
<!--主体内容第一部分结束-->
<!--底部-->
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
