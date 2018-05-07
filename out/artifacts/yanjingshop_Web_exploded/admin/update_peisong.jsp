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
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<%-- <script src="js/pintuer.js"></script> --%>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="updatepeisong.action">  
      <div class="form-group" >
      <div  align="center">
        <div class="label" >
          <label>名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<s:property value="ps.name"/>" name="ps.name" data-validate="required:请输入标题" />
          <div class="tips"><input type="hidden" value="<s:property value="ps.id"/>" name="ps.id"  />
          <input type="hidden" value="<s:property value="ps.mstatus"/>" name="ps.mstatus"  />
          <input type="hidden" value="<s:property value="ps.pubtime"/>" name="ps.pubtime"  />
          <input type="hidden" value="<s:property value="ps.isdel"/>" name="ps.isdel"  />
          </div>
        </div>
        </div>
     </div>
       <div class="form-group" >
      <div  align="center">
        <div class="label" >
          <label>位置：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<s:property value="ps.address"/>" name="ps.address" data-validate="required:请输入标题" />
          <div class="tips">
          </div>
        </div>
        </div>
     </div>
       <div class="form-group" >
      <div  align="center">
        <div class="label" >
          <label>人数：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<s:property value="ps.num"/>" name="ps.num" data-validate="required:请输入人数" />
          <div class="tips">
          </div>
        </div>
        </div>
     </div>
       <div class="form-group" >
        <div class="field" align="center">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body></html>