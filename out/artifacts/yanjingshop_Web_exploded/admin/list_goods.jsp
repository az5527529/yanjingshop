<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<form method="post" action="search1.action" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="doAddGoods.action"> 添加内容</a> </li>
        <li> <input type="text" name="f1.name" class="input"  placeholder="请输入搜索的名称"></li>
        <li >
        <select name="f1.ftype.fid" class="input"  style="width:100px; line-height:25px;display:inline-block" >
        <option value="" >请选择种类</option>
       <s:iterator value="ftlist">
        <option value="<s:property value="fid" />"><s:property value="ftype" /></option>
        </s:iterator>
         </select></li><li>
         <input type="submit"  class="button border-main icon-search" value="搜索" ></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th>名称</th>
        <th>图片</th>
        <th>价格(元)</th>
        <th>是否促销</th>
        <th>库存</th>
        <th>销量</th>
        <th>目前状态</th>
        <th width="300">操作</th>
      </tr>
       <s:iterator value="page.pageList" >
        <tr>
          <td><s:property value="name" /></td>
          <td><img src="./upload/<s:property value="img" />" alt="" width="50" height="50" /></td>
          <td><s:property value="price" /></td>
          <td><s:property value="isshow" /></td>
          <td><s:property value="kcnum" /></td>
          <td><s:property value="xnum" /></td>
          <td><s:property value="isdel" /></td>
          <td><div class="button-group"> 
          <s:if test="#session.cuser.level==3">
          <s:if test="isdel=='待审核'">
          <a class="button border-main" href="tongGuo.action?id=<s:property value="id" />"><span class="icon-edit"></span> 通过</a> 
          </s:if>
          </s:if>
          <a class="button border-main" href="doUpdateGoods.action?id=<s:property value="id" />"><span class="icon-edit"></span> 修改</a> 
          <a class="button border-red" href="deleteGoods.action?id=<s:property value="id" />" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> 
          </div></td>
        </tr>
        </s:iterator>
   		 
      <tr>
     <s:if test="#session.p!=3">
       <td colspan="2">当前显示第
			<s:property value="page.pageIndex" />
			页
			</td><td colspan="1">共
			<s:property value="page.totalpages" />
			页</td>
			<td colspan="6">
			<div align="center">
				<a href="queryGoods.action?page.pageIndex=1"> 首页</a>
				<s:property value="totalpages" />
				<a <s:if test="page.pageIndex<=1"> href="javascript:false;"</s:if>
					<s:else>href="queryGoods.action?page.pageIndex=<s:property value='page.pageIndex-1' />"</s:else>>上一页</a>
				<a
					<s:if test="page.pageIndex>=page.totalpages" > href="javascript:false;"</s:if>
					<s:else>href="queryGoods.action?page.pageIndex=<s:property value='page.pageIndex+1' />"</s:else>>下一页</a>
				<a
					href="queryGoods.action?page.pageIndex=<s:property value="page.totalpages" />">末页</a>


			</div></td>  
			</s:if>  <s:elseif test="#session.p==3">
			 <td colspan="2">当前显示第
			<s:property value="page.pageIndex" />
			页
			</td><td colspan="1">共
			<s:property value="page.totalpages" />
			页</td>
			<td colspan="6">
			<div align="center">
				<a href="search1.action?page.pageIndex=1"> 首页</a>
				<s:property value="totalpages" />
				<a <s:if test="page.pageIndex<=1"> href="javascript:false;"</s:if>
					<s:else>href="search1.action?page.pageIndex=<s:property value='page.pageIndex-1' />"</s:else>>上一页</a>
				<a
					<s:if test="page.pageIndex>=page.totalpages" > href="javascript:false;"</s:if>
					<s:else>href="search1.action?page.pageIndex=<s:property value='page.pageIndex+1' />"</s:else>>下一页</a>
				<a
					href="search1.action?page.pageIndex=<s:property value="page.totalpages" />">末页</a>


			</div></td>
			
			</s:elseif>  
			</tr>
    </table>
  </div>
</form>
<script type="text/javascript">

//搜索
function changesearch(){	
		
}

//单个删除
function del(id,mid,iscid){
	if(confirm("您确定要删除吗?")){
		return true;
	}else{
		return false;
	}
}

</script>
</body>
</html>