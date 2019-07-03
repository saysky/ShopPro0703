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
    
    <div class="formtitle"><span>修改商品类别信息</span></div>
    <form action="back/GoodsTypeServlet?action=update" method="post">
    	<ul class="forminfo">
    	<input type="hidden" name="typeid" value="${goodType.id}"></input>
	    <li><label>商品类别名称</label><input name="typename" type="text" class="dfinput" value="${goodType.gtype_name}"/><i>标题不能超过30个字符</i></li>
	    	
	    <li><label>父类别</label>
	    		<select name="fatherid">
	    			<option value="0" >无</option>
	    			<c:forEach items="${gtList}" var="big">
	    				<c:if test="${big.gtype_parentid eq '0'}">
	    					<c:choose>
	    						<c:when test="${big.id eq goodType.gtype_parentid}">
	    							<option value="${big.id}" selected="selected" >${big.gtype_name}</option>
	    						</c:when>
	    						<c:otherwise>
	    							<option value="${big.id}">${big.gtype_name}</option>
	    						</c:otherwise>
	    					</c:choose>
	    						
	    				</c:if>
	    			</c:forEach>   
	    		</select>
	    </i></li>
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    
    </form>
    </div>


<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

