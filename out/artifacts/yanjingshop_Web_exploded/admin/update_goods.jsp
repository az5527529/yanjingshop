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

K.create('textarea[id="note"]', {

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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="updateGoods.action" enctype="multipart/form-data">  
      <div class="form-group">
        <div class="label">
          <label>名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<s:property value="goods.name"/>" name="goods.name" data-validate="required:请输入标题" />
          <div class="tips"> </div>
          <input type="hidden"  value="<s:property value="goods.id"/>" name="goods.id"  />
          <input type="hidden"  value="<s:property value="goods.isdel"/>" name="goods.isdel"  />
          <input type="hidden"  value="<s:property value="goods.uid"/>" name="goods.uid"  />
          <input type="hidden"  value="<s:property value="goods.xnum"/>" name="goods.xnum"  />
          <input type="hidden"  value="<s:property value="goods.gid"/>" name="goods.gid"  />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>图片：</label>
        </div>
        <div class="field">
          <div><img src="upload/<s:property value="goods.img" />" alt="" width="70" height="50" /></div>
          <input type="file" class="button bg-blue margin-left" id="image1" value="+ 浏览上传" name="files" style="float:left;">
          <div class="tipss">图片尺寸：500*500</div>
        </div>
      </div>     
     <div class="form-group">
          <div class="label">
            <label>分类：</label>
          </div>
          <div class="field">
            <select name="goods.ftype.fid" class="input w50">
              <option value="<s:property value="goods.ftype.fid" />"><s:property value="goods.ftype.ftype" /></option>
              <s:iterator value="ftlist">
              <option value="<s:property value="fid" />"><s:property value="ftype" /></option>
             </s:iterator>
             </select>
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>是否促销：</label>
          </div>
          <div class="field" style="padding-top:8px;"> 
          <select name="goods.isshow" class="input w50">
          <option value=" <s:property value="goods.isshow" />"><s:property value="goods.isshow" /></option>
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
          <input type="text" class="input w50"  name="goods.price" size="15" style="height:45px;" value="<s:property value="goods.price" />"/>元
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>库存数量：</label>
        </div>
        <div class="field" >
          <input type="text" class="input w50"  name="goods.kcnum" size="15" style="height:45px;" value="<s:property value="goods.kcnum" />"/>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>描述：</label>
        </div>
        <div class="field">
          <textarea  class="input" id="note" name="goods.miaoshu" style="height:80px;width:800px;"><s:property value="goods.miaoshu" /></textarea>
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