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
<script charset="utf-8" src="/yanjingshop/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="/yanjingshop/kindeditor/lang/zh-CN.js"></script>
<script>
	        KindEditor.ready(function(K) {
	                window.editor = K.create('#editor_id');
	        });
	</script>
	<script>

KindEditor.ready(function(K) {

K.create('textarea[name="note"]', {

                uploadJson : '/yanjingshop/kindeditor/jsp/upload_json.jsp',

                fileManagerJson : '/yanjingshop/kindeditor/jsp/file_manager_json.jsp',

                allowFileManager : true,

                allowImageUpload : true, 

autoHeightMode : true,

afterCreate : function() {this.loadPlugin('autoheight');},

afterBlur : function(){ this.sync(); }  //Kindeditor下获取文本框信息

});

});

</script>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="addGoods.action" enctype="multipart/form-data">  
      <div class="form-group">
        <div class="label">
          <label>名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" size="18" name="goods.name" data-validate="required:请输入产品名称" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>图片：</label>
        </div>
        <div class="field">
          <input type="file" id="url1" name="files" class="input tips" style="width:25%; float:left;"  value="图片上传"  data-toggle="hover" data-place="right" data-image="" />
          <div class="tipss">图片尺寸：500*500</div>
        </div>
      </div>     
        <div class="form-group">
          <div class="label">
            <label>分类：</label>
          </div>
          <div class="field">
            <select name="goods.ftype.fid" class="input w50">
              <option value="">请选择分类</option>
              <s:iterator value="ftlist">
              <option value="<s:property value="fid" />"><s:property value="ftype" /></option>
             </s:iterator>
             </select>
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>是否为促销：</label>
          </div>
          <div class="field" style="padding-top:8px;"> 
          <select name="goods.isshow" class="input w50">
          <option value="是">是</option>
          <option value="否">否</option>
          </select>
          </div>
        </div>
      <div class="form-group">
        <div class="label">
          <label>价格：</label>
        </div>
        <div class="field" >
          <input type="text" class="input w50"  name="goods.price" size="15" style="height:45px;"/>元
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>库存数量：</label>
        </div>
        <div class="field" >
        <input type="hidden" name="goods.xnum" value="0">
          <input type="text" class="input w50"  name="goods.kcnum" size="15" style="height:45px;"/>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>描述：</label>
        </div>
        <div class="field">
        <textarea id="editor_id"  name="note" style="width:800px;height:200px;" ></textarea>
        </div>
      </div>
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