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
<title>更新用户信息</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<%-- <script src="js/pintuer.js"></script> --%>
</head>

<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>更新内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="updatePersionUser.action" >  
      <div class="form-group">
        <div class="label">
          <label>用户名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<s:property value="#session.cuser.uname"/>" name="user.uname"  readonly="readonly"/>
          <input type="hidden"  value="<s:property value="#session.cuser.uid"/>" name="user.uid" />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<s:property value="#session.cuser.pwd"/>" name="user.pwd"  />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>电话：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="user.tel" class="input w50" value="<s:property value="#session.cuser.tel"/>" />
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>性别：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="user.sex" class="input w50" value="<s:property value="#session.cuser.sex"/>" />
        </div>
      </div>     
      <div class="form-group">
        <div class="label">
          <label>预留问题：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="user.mbanswer" class="input w50" value="<s:property value="#session.cuser.mbanswer"/>" />
        </div>
      </div>   
        <div class="form-group">
        <div class="label">
          <label>问题答案：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="user.question" class="input w50" value="<s:property value="#session.cuser.question"/>" />
        </div>
      </div>     
      
        <div class="form-group">
          <div class="label">
           <!--  <label>身份：</label> -->
          </div>
          <div class="field" style="padding-top:8px;"> 
          <input type="hidden" id="level" name="user.level" class="input w50"  value="<s:property value="#session.cuser.level"/>" />
            <%-- <select name="#session.cuser.level" class="input w50">
          <option  value="<s:property value="user.level"/>"><s:property value="user.level"/></option>
              <option value="3">普通用户</option>
              <option value="2">企业用户</option>
              <option value="1">管理员</option>
             </select> --%>
          </div>
        </div>
      </if>
    
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body></html>