<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
	String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/backstyle.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>添加用户信息</span></div>
    <form action="back/UserServlet?action=add" method="post">
    	<ul class="forminfo">
	    <li><label>用户名</label><input name="username" type="text" class="dfinput" /></li>
	    <li><label>密码</label><input name="password" type="text" class="dfinput"/></li>
	    <li><label>昵称</label><input name="nickname" type="text" class="dfinput" /></li>
	  	<li><label>角色</label><select name="role" class="dfinput">
	  		<option value="null">请选择</option>
	    	<option value="Y">管理员</option>
	    	<option value="N">普通用户</option>
	    </select>
	    </li>
	    <li><label>性别</label><select name="sex" class="dfinput">
	  		<option value="null">请选择</option>
	    	<option value="男">男</option>
	    	<option value="女">女</option>
	    </select>
	    </li>
	    <li><label>出生日期</label><input name="birthday" type="text" class="dfinput" /></li>
	    <li><label>电子邮箱</label><input type="text" name="email" class="dfinput"/></li>
	    <li><label>电话号码</label><input name="phone" type="text" class="dfinput" /></li>
	    <li><label>地址</label><input type="text" name="address"class="dfinput" /></li>
	    <li><label>邮编</label><input name="code" type="text" class="dfinput" /></li>
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    </div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

