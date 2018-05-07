<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!--导航-->
<jsp:include page="top.jsp"></jsp:include>
<!--主体内容第一部分开始-->
<div id="content1">
  <!--左侧-->
  <div id="con1-left">
    <div class="con1-1">商品查询</div>
    
     <form action="search.action" method="post" >
    <div class="cs">
   
      <ul>
      <li style="display:inline;">名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<input type="text" name="f1.name" > </li>
      </br>
      <li style="display:inline;" >分 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类：
       <select name="f1.ftype.fid">
        <option value="">请选择分类</option>
       <s:iterator value="ftlist">
        <option value="<s:property value="fid" />"><s:property value="ftype" /></option>
        </s:iterator>
         </select>
       </li><br>
      <li align="center" ><input type="submit" name="" value="搜索"/></li>
      </ul>
    </div>
    </form>
  </div> 
  <!--右侧-->
  <div id="con1-right">
    <div id="right-top">
      <div class="banner">
     
        <ul id="imgs">
         <s:iterator value="gpiclist" >
          <li><a href="showoneNews.action?gg.ggid=<s:property value="ggid"/>"><img src="./upload/<s:property value="ggpic" />" width="500" height="240"/></a></li>
            </s:iterator>
        </ul>
        <ul id="numbers">
        <s:iterator value="nlist" >
          <li></li>
          </s:iterator>
        </ul>
    
      </div>
       <s:if test="#session.user==null">
      <div class="zcdl">
        <ul>
          <li style="margin-right:3px;"><a href="fore_login.jsp"><img src="images/dl.jpg" width="85" height="36" /></a></li>
          <li><a href="regist.jsp"><img src="images/zc.jpg" width="85" height="36" /></a></li>
        </ul>
      </div>
      <div class="my">
      </div>
       </s:if> <s:else>
        <div class="zcdl">
        <ul>
        <li style="line-height: 24px;font-size: 14px;text-align: center;">  &nbsp;&nbsp;<s:property value="#session.user.uname"/></li>
       <li style="margin-right:3px;"><a href="exit.action"><img src="images/zhux.jpg" width="85" height="40" /></a></li>
       </ul>
      </div>
      <div class="my">
      <form action="getorder.action" method="post" onsubmit="return checkOid()">
        <ul>
          <li class="cls1"><a href="orderpj.action">我的订单</a></li>
          <li class="cls1"><a href="chongzhi.action">充值记录</a></li>
          <li class="cls1"><a href="showPersion.action">个人信息</a></li>
          <li class="cls1"><a href="getAllKeep.action?keep.uid=<s:property value="#session.user.uid"/>">我的收藏</a></li>
        </ul>
        </form>
      </div>
      </s:else>
      
    </div>
     
    <div id="right-btm">
      <div class="tgj"><a class="zp" style="    background: #5BB400; font-size: 19px;
    color: #fff; margin-left: 25px;">最新商品</a><span><a href="shownew.action">更多商品信息>></a></span></div>
      <div class="tgjlx">
        <ul style="width:1446px">
         <s:iterator value="page.pageList">
       <li><a href="show.action?id=<s:property value="id"/>"><img src="./upload/<s:property value="img"/>" width="160" height="88" /></a><br />
            <span><s:property value="name"/></span><span>￥：<s:property value="price"/>元</span></li>
       </s:iterator>
       
        </ul>
      </div>
    </div>
  </div>
</div>
<!--主体内容第一部分结束--> 
<!--主体内容第二部分开始-->
<div id="con-2"> 
  <!--左侧开始-->
  <div id="con-2left">
    <div id="con-2left1">
     
      <div class="con-23"><h1 style="    margin-left: -200px;
    width: 105px;
    background: #5BB400;
    text-align: center;
    color: #fff;">分类</h1></div>
      <div class="jingdian">
         <ul>
        <s:iterator value="ftlist">
        <li><a href="showtype.action?f3.ftype.fid=<s:property value="fid" /> "><s:property value="ftype" /></a></li>
        </s:iterator>
       </ul>
      </div>
    </div>
  </div>
  <!--左侧结束--> 
  <!--右侧开始-->
  <div id="con-2right">
    <div id="con-2meun">
    
    </div>
    
       <div class="con-2inf"><h3 class="hotzp" style="    width: 100px;
    margin-top: -40px;margin-bottom: 12px; font-size: 17px;background: #5BB400;
    color: #fff;text-align: center;">热销商品</h3>
      <ul>
      <s:iterator value="flist">
      <%-- <s:property value="goods.fid"/> --%>
        <li class="w130"><a href="show.action?id=<s:property value="id"/>&o.goods.id=<s:property value="id"/>"><img src="./upload/<s:property value="img"/>" width="220" height="140" />
        <br /><s:property value="name"/><br />销量：<s:property value="xnum"/></a></li>
       </s:iterator>
      </ul>
  </div>
</div>
<!--主体内容第二部分结束--> 
<!--底部-->
<jsp:include page="foot.jsp"></jsp:include>
