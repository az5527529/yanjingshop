<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="top.jsp"></jsp:include>
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
<!--主体内容第一部分开始-->
<div class="jindck">
<div class="jindck-meun">标题：<s:property value="gg.name" /></div>
<div class="tuijian">
<div class="tuijian-m">详情</div>
<div class="tuijian-inf">
<ul>
<li><textarea  id="note" name="gg.note" style="width:850px;height:300px;"  readonly="readonly"><s:property value="gg.note" /></textarea></li>
</ul>
</div>
</div>

<!--主体内容第一部分结束-->
<!--底部-->
<!--底部-->
<jsp:include page="foot.jsp"></jsp:include>

