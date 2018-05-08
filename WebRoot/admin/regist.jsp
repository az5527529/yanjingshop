<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新用户注册</title>
<style type="text/css">
.txtInit {
	border: 1px #cecece solid;
}
.txtFocus {
	border: 1px solid #009;
}
.spanInit {
	width: 275px;
	height: 22px;
	display: block;
	float: right;
	background-repeat: no-repeat;
	background-position: left;
	color: red;
}
/*邮箱输入正确，设置打勾的背景图片*/
.spanBlurOk{
	
	background-image:url(images/right.jpg);
}
</style>
<jsp:include page="top.jsp"></jsp:include>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<script type="text/javascript">
	function checkuname() {
		var name = $("#username").val();
		if(name==""||(name.length<3||name.length>12)){
			 $("#checku").html("用户账号不能为空且长度在3～12位之间！");
			 $("input[id=username]").focus();
		} else {
			$("#checku").html("");
			$.ajax({
				url : "checku.action",
				type : "post",
				data : "uname=" + name,
				
				dataType : "json",
				success:function(result){
				if(result.info=="ok"){
				$("#checku").html("用户名存在，请更换！");
				$("input[id=username]").focus();
				return false;
				}else{
				$("#checku").html("可以用");
				return true;
				}
				},
				error:function(){
				alert("请求失败！");
				return false;
				}

			});
		}

	}
	 function checkpwd(){
		  var pwd=$("#txtPwd").val();
		  if(pwd==""||pwd.length<6||pwd.length>12){
		 $("#prompt_pwd").html("密码不能为空且长度在6～12位之间！");
		 $("input[id=txtPwd]").html("");
		  $("input[id=txtPwd]").focus();
		 return false;
		}else {
		 $("#prompt_pwd").html("密码格式正确！");
		return true;}

		}

		function checkpwdc(){
		var pwd=$("#txtPwd").val();
		var pwdc=$("#txtConfirmPwd").val();
		if(pwdc==""||pwdc!=pwd){
		  $("#prompt_confirmpwd").html("两次密码要一致 ！");
		  $("input[id=txtConfirmPwd]");
		   // $("input[name=passwordc]").focus();
		  return false;
		  }else{
		  $("#prompt_confirmpwd").html("密码一致 ！");
		  return true;}

		}

		 function checktel(){
		 var tel=$("#txtPhone").val();
		 var regtel=/^(13|15|18|)\d{9}$/;
		 if(tel==""||!regtel.test(tel)){
		  $("#prompt_phone").html("电话号码不能为空，且以13，15，17，18开头的11位");
		  $("input[id=txtPhone]").html("");
		   $("input[id=txtPhone]").focus();
		  return false;
		  }else{
		   $("#prompt_phone").html("电话号码格式正确！");
		  return true;
		  }

		 }
		 function checkname1(){ 
			  var uname=$("#txtName1").val();
			  if(uname==""||uname.length<2){
			  $("#prompt_name1").html("不能为空且长度在2位以上！");
			  $("input[id=txtName1]").html("");
			   $("input[id=txtName1]").focus();
			  return false;
			  }else{
			  
			  $("#prompt_name1").html("ok");
			  return true;
			  }} 
		  
		 function checkname2(){ 
			  var uname=$("#txtName2").val();
			  if(uname==""||uname.length<2){
			  $("#prompt_name1").html("不能为空且长度在2位以上！");
			  $("input[id=txtName2]").html("");
			   $("input[id=txtName2]").focus();
			  return false;
			  }else{
			  
			  $("#prompt_name2").html("ok");
			  return true;
			  }} 
		  
		  
	function check(){
		var flag= checkuname() 
		      &&checkpwd()
			  &&checkpwdc()
			  &&checktel()
			  && checkname1() && checkname2();
		//alert(flag);
		return flag;
	}
	function checkAll(){
		//alert("kkkkk");
		var flag=false;
		var aa = $("#username").val();
		var pwd=$("#txtPwd").val();
		var pwdc=$("#txtConfirmPwd").val();
		var tel=$("#txtPhone").val();
		var name1=$("#txtName1").val();
		var name2=$("#txtName2").val();
		 var regtel=/^(13|15|18|)\d{9}$/;
		 if(aa!=""&&(tel!=""||regtel.test(tel))&&(name1!=""||name1.length>2)&&(name2!=""||name2.length>2)&&
				 (pwd!=""||pwd.length>6||pwd.length<12)&&(pwdc!=""||pwdc==pwd)){
			 flag=true;
		 }else{
			 alert("注册信息不完整或不合规范！");
		 }
		/*  if (aa== "") {
				$("#checku").html("用户名不能为空！");
			}else{
				flag=true;
			}
		 if(tel==""||!regtel.test(tel)){
		  $("#prompt_phone").html("电话号码不能为空，且以13，15，17，18开头的11位");
		  
		  }else{
			  flag=true;
		  } */
		
		return flag;
		
	}
</script>



<!--注册版块-->
<div id="reg">

  <div id="reg-top">&nbsp;&nbsp;&nbsp;&nbsp;会员注册</div>
  <div id="reg-mleft" style="margin-top:10px;">
  <form method="post" action="adduser.action" onsubmit="return check();">
    <ul>
      <li class="m">用户名 </li>
      <li class="r" >
        <input name="user.uname" type="text" class="box txtInit" id="username" onblur="return checkuname()" />
        <span id='checku' class="spanInit" ></span></li>
      <li class="m">设置密码 </li>
      <li class="r">
        <input name="user.pwd" type="password" class="box txtInit" id="txtPwd"  onblur="return checkpwd()"/>
        <span id='prompt_pwd'  class="spanInit" ></span></li>
      <li class="m">确认密码 </li>
      <li class="r">
        <input name="pwdc" type="password" class="box txtInit" id="txtConfirmPwd" onblur="return checkpwdc()"/>
        <span id='prompt_confirmpwd' class="spanInit"  ></span></li>
      
      <li class="m">性 别 </li>
      <li class="r">
        <input name="user.sex" type="radio" id="radio" value="男" checked="checked" />
        男
        <input type="radio" name="user.sex" id="radio2" value="女" />
        女 </li>
      <li class="m">手机号码 </li>
      <li class="r">
        <input name="user.tel" type="text" class="box txtInit" id="txtPhone" onblur="return checktel()"/>
        <span id='prompt_phone' class="spanInit" ></span></li>
      <li class="m">收货地址 </li>
      <li class="r"><input name="user.address" type="text" class="box txtInit" id="" />
        <span id='' class="spanInit"  ></span> </li>
         <li class="m">详细地址 </li>
      <li class="r"><input name="user.addr" type="text" class="box txtInit" id="" />
        <span id='' class="spanInit"  ></span> </li>
    <li class="m">预留问题 </li>
    <li class="r"><input name="user.mbanswer" type="text" class="box txtInit" id="txtName1" onblur="return checkname1()"/>
        <span id='prompt_name1' class="spanInit"  ></span> </li>
   
    <li class="m">问题答案 </li>
      <li class="r"><input name="user.question" type="text" class="box txtInit" id="txtName2" onblur="return checkname2()"/>
        <span id='prompt_name2' class="spanInit"  ></span> </li>
      <input name="user.money" type="hidden" value="0"/>
     <%--<li class="m">充值金额  </li>
      <li class="r"><input name="user.money" type="text" class="box txtInit" id="" />
        <span id='prompt_name' class="spanInit"  ></span> </li>--%>
     <li class="m">QQ  </li>
      <li class="r"><input name="user.qq" type="text" class="box txtInit" id="" />
        <span id='prompt_name3' class="spanInit"  ></span> </li>
        <li class="m">年龄:</li>
      <li class="r"><input name="user.birth" type="text" class="box txtInit" id="" />
        <span id='prompt_name' class="spanInit"  ></span> </li>
      
      <li class="m"> </li>
      <li class="r">
        <input name="button" type="image" id="button" value="提交" src="images/but2.jpg" onclick="return checkAll()" />
      </li>
      
    </ul>
      </form>
  </div>

  <div id="reg-right">
    <div><img src="images/kf.jpg" width="230" height="150" /></div>
    <div id="kf2"><a href="fore_login.jsp">已有账户，请点击登录</a></div>

  </div>
</div>
<!--底部-->
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
