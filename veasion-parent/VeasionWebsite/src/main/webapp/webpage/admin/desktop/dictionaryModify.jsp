<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="Shortcut Icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico">
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/veasion/util.js" type="text/javascript"></script>
</head>
<script type="text/javascript">

	function check(){
		return !hasNull(["type", "value"],true);
	}
	
	$(function(){
		var obj="${dictionary}";
		if(obj!="" && obj!="null"){
			$("#type").val("${dictionary.type}");
		}
	});
	
</script>
<body>
<div style="text-align: center;">
	<form action="${pageContext.request.contextPath}/admin/desktop/dictionary/dictionaryModify" method="post" onsubmit="return check();">
		<c:if test="${dictionary !=null }">
			<input type="hidden" name="id" value="${dictionary.id }"/>
		</c:if>
		<table>
			<tr>
				<th>类型：</th>
				<td>
					<select name="type">
						<option value="3">帅气赞美</option>
						<option value="1">作者名称</option>
						<option value="2">Admin暗码</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>值：</th>
				<td>
					<input id="value" name="value" value="${dictionary.value }" />
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="保存"/>
				</th>
			</tr>
		</table>
	</form>
</div>
</body>
</html>