<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="top.jsp"></jsp:include>
<!--登录版块-->
<div id="login-bg">
<div id="login-m">

<form action="cz.action" method="post">
<ul>
<li>用&nbsp;&nbsp;户&nbsp;&nbsp;名
    <input  type="text" class="box" id="txtLoginNo" size="33" value="<s:property value="u.uname" />" readonly="readonly"/>
</li>
<li>用户编号&nbsp;
    <input name="shop.userinfo.uid" type="text" class="box" id="txtPwd" size="33"
     value="<s:property value="u.uid" />" readonly="readonly"/>
</li>
<li>余&nbsp;额&nbsp;为&nbsp;
    <input  type="text" class="box" id="txtPwd" size="33" value="<s:property value="u.money" />" readonly="readonly"/>
</li>
<li>充值金额
    <input name="shop.num" type="text" class="box" id="txtPwd" size="33" />
</li>
  <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input name="button" type="image" id="button" value="提交" src="images/login-c.jpg" />
  </li>
</ul>
</form>

</div>
</div>

<!--底部-->
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
