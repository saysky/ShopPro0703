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

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="<%=basePath%>"/>
<title>无标题文档</title>
<link href="css/backstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">数据表</a></li>
    <li><a href="#">基本内容</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li><span><a href="back/goodstype/goodsadd.jsp"><img src="images/t01.png" /></span>添加</a></li>
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li>
        </ul>
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>商品类别编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>商品类别名称</th>
        <th>父类编号</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
    	<c:forEach items="${gtList}" var="big">
    		<c:if test="${big.gtype_parentid eq '0'}">
    		
    		
       			<tr>
		        <td>${big.id}</td>
		        <td>${big.gtype_name}</td>
		        <td>${big.gtype_parentid}</td>
		        <td><a href="back/GoodsTypeServlet?action=toUpdate&id=${big.id}" class="tablelink">编辑</a>   
				<a href="javascript:#" onclick="if(confirm('确定要删除吗？')){location.href='back/GoodsTypeServlet?action=delete&id=${big.id}'}" class="tablelink"> 删除</a></td>
		        </tr> 
			   
			  <c:forEach items="${gtList}" var="small">
			  	<c:if test="${big.id eq small.gtype_parentid}">
			     <tr>
			        <td align="center">${small.id}</td>
			        <td align="center">${small.gtype_name}</td>
			        <td align="center">${small.gtype_parentid}</td>
			        <td><a href="back/GoodsTypeServlet?action=toUpdate&id=${small.id}" 
			        class="tablelink">编辑</a>   
					<a href="javascript:#" 
					   onclick="if(confirm('确定要删除吗？')){location.href='back/GoodsTypeServlet?action=delete&id=${small.id}'}"
					class="tablelink"> 删除</a></td>
			        </tr> 
			       	</c:if>
			  </c:forEach>
	      </c:if>
    	</c:forEach>
        </tbody>
    </table>
    
   
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

