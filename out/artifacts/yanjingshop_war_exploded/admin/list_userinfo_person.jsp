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
<title>个人信息</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<form method="post" action="querylist.action" >
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th>用户名</th>
        <th>密码</th>
        <th>性别</th>
        <th>电话</th>
        <th>身份</th>
        <th width="310">操作</th>
      </tr>
  
        <tr>
          <td> <s:property value="user.uname" /></td>
           <th ><s:property value="user.pwd" /></th>
           <s:if test="user.sex==null"><td>无</td></s:if><s:else>
          <td><s:property value="user.sex" /></td></s:else>
          <s:if test="user.tel==null"><td>无</td></s:if><s:else>
          <td><s:property value="user.tel" /></td></s:else>
            <s:if test="user.level==1"><td>普通用户</td></s:if>
          <s:elseif test="user.level==2"><td>供应商</td></s:elseif>
          <s:elseif test="user.level==3"><td>管理员</td></s:elseif><s:else>
          <td><s:property value="user.level" /></td></s:else>
          <td><div class="button-group"><a class="button border-main" href="doUpdatePerson.action?id=<s:property value="user.uid"/>"><span class="icon-edit"></span> 修改</a> </div></td>
        </tr>
    </table>
  </div>
</form>
</body>
</html>