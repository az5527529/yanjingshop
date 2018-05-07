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
<div class="jindck-meun">名称：<s:property value="goods.name" /><img src="images/fk.jpg" width="40" height="40" /></div>
<div class="jin2">
<div class="jin2-left">
<ul>
<li>
<a href="" title="">
<img src="upload/<s:property value="goods.img" />" width="400" height="250" />
</a>
</li>
<li class="pics"><a href="upload/<s:property value="goods.img" />" class="zoom" title="<s:property value="goods.img" />" ><img src="upload/<s:property value="goods.img" />" width="100" height="63" /></a></li>

</div>
<div class="jin2-right">
<ul>
<li>价格：<span class="colorc"><s:property value="goods.price" />元</span></li>
<li>是否促销：<s:property value="goods.isshow" /></li>
<li>库存数量：<s:property value="goods.kcnum" /></li>
<li>销量：<s:property value="goods.xnum" /></li>
<li>分类：<s:property value="goods.ftype.ftype" /></li>

<li><s:if test="#session.user!=null"><a href="addkeep.action?keep.uid=<s:property value="#session.user.uid" />&keep.goods.id=<s:property value="goods.id" />" >收藏</a></s:if></li>

<s:if test="goods.kcnum==0">
<li>库存不足！</li>
</s:if>
<s:if test="#session.user==null">
<li>请登录后操作！<h1><a href="fore_login.jsp">登录</a></h1></li>
</s:if>
<s:if test="#session.user!=null">
<s:if test="goods.kcnum!=0">
<li><a href="addshop.action?shop.goods.id=<s:property value="goods.id" />"><img src="images/jgwc.jpg" width="122" height="42" /></a>&nbsp;&nbsp;&nbsp;&nbsp;
</li>
</s:if>
</s:if>
</ul>
</div>
</div>
<div class="tuijian">
<div class="tuijian-m">详情</div>
<div class="tuijian-inf">
<ul>
<li><textarea  id="note" name="goods.miaoshu" style="width:850px;height:300px;"  readonly="readonly"><s:property value="goods.miaoshu" /></textarea></li>
</ul>
</div>
</div>
</div>
<!--主体内容第一部分结束-->
<!--底部-->
<!--底部-->
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
