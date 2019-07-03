<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8">
<title>注册</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet" href="AmazeUI-2.4.2/assets/css/amazeui.min.css" />
<link href="css/dlstyle.css" rel="stylesheet" type="text/css">
<script src="AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
<script src="AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
<script type="text/javascript">
var flag = false;
window.onload = function(){
	var username = document.getElementById("username");	
	var msg = document.getElementById("registerMsg");
	username.onblur = function(){
		
		var xmlHttpRequest = createXmlHttpRequest();
		
		 xmlHttpRequest.onreadystatechange = function(){
			if(xmlHttpRequest.readyState==4&&xmlHttpRequest.status==200){
				if(xmlHttpRequest.responseText=="1"){
					msg.innerHTML = "用户名已经存在!";
				}else{
					msg.innerHTML = "用户名可用!";
				}
				
			}
		} 
		xmlHttpRequest.open("GET","UserServlet?action=checkNameExits&username="+username.value,true);
		xmlHttpRequest.send();
		
	}
}

var xmlHttpRequest;
function createXmlHttpRequest(){
	if(window.XMLHttpRequest){
		xmlHttpRequest = new XMLHttpRequest();
	}else{
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	return xmlHttpRequest;
}

function zhuce(){
	document.getElementById("form").submit();
}


</script>


</head>

<body>

	<div class="login-boxtitle">
		<a href="home/demo.html"><img alt="" src="images/indexlogo.png" /></a>
	</div>

	<div class="res-banner">
		<div class="res-main">
			<div class="login-banner-bg">
				<span></span><img src="images/big.jpg" />
			</div>
			<div class="login-box">

				<div class="am-tabs" id="doc-my-tabs">
					<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
						<li class="am-active"><a href="">注册</a></li>

					</ul>
					<div id="registerMsg" style="font-size: 12px;color: red"></div>
					<div class="am-tabs-bd">
						<div class="am-tab-panel am-active">
							<form action="UserServlet?action=regist" method="post" id="form"
								onsubmit="">
								<div class="user-email">
									<label for="username"><i class="am-icon-envelope-o"></i></label>
									<input type="text" name="username" id="username"
										placeholder="请输入账号">
								</div>
								<div class="user-pass">
									<label for="password"><i class="am-icon-lock"></i></label> <input
										type="password" name="password" id="password"
										placeholder="设置密码">
								</div>
								<div class="user-pass">
									<label for="passwordRepeat"><i class="am-icon-lock"></i></label>
									<input type="password" name="passwordRepeat"
										id="passwordRepeat" placeholder="确认密码">
								</div>

							</form>

							<div class="login-links">
								<label for="reader-me"> <input id="reader-me"
									type="checkbox" checked="checked"> 点击表示您同意商城《服务协议》
								</label>
							</div>
							<div class="am-cf">
								<input type="submit" onclick="zhuce();" value="注册"
									class="am-btn am-btn-primary am-btn-sm am-fl">
							</div>

						</div>


						<script>
							$(function() {
								$('#doc-my-tabs').tabs();
							})
						</script>

					</div>
				</div>

			</div>
		</div>
	</div>
	<div class="footer ">
		<div class="footer-hd ">
			<p>
				<a href="# ">恒望科技</a> <b>|</b> <a href="# ">商城首页</a> <b>|</b> <a
					href="# ">支付宝</a> <b>|</b> <a href="# ">物流</a>
			</p>
		</div>
		<div class="footer-bd ">
			<p>
				<a href="# ">关于恒望</a> <a href="# ">合作伙伴</a> <a href="# ">联系我们</a> <a
					href="# ">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有</em>
			</p>
		</div>
	</div>
</body>

</html>