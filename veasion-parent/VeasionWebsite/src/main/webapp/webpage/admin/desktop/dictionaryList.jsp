<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dictionary管理</title>
<link rel="Shortcut Icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico">
<link href="${pageContext.request.contextPath}/resources/js/jquery/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery/ligerUI/js/core/base.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
<style>
a{text-decoration:none}
</style>
<script type="text/javascript">

	var grid = null;
	
	$(function() {
		loadData(null);
	});
	
	function loadData(parms){
		grid = $("#maingrid4").ligerGrid({
			url:"${pageContext.request.contextPath}/admin/desktop/dictionary/dictionarySearch",
			columns : [ {
				display : 'id',
				name : 'id',
				width : 35
			}, {
				display : '类型',
				name : 'type'
			}, {
				display : '值',
				name : 'value'
			}, {
				display : '状态',
				name : 'status'
			}, {
				display : '创建时间',
				name : 'createDate',
				width : 80
			}, {
				display : '编辑',
				name : 'edit'
			}, {
				display : '删除',
				name : 'del'
			} ],
			pageSize : 10,
			width : '100%',
			height : '100%',
			rowAttrRender: function (rowdata, rowid){
				var id=rowdata.id;
				var value=rowdata.value;
				var type=rowdata.type;
				var status=rowdata.status;
				var date=rowdata.createDate;
				var typeName="未命名";
				switch(type){
					case 1:typeName="作者名称";break;
					case 2:typeName="Admin暗码";break;
					case 3:typeName="帅气赞美";break;
				}
				rowdata.type=typeName;
				rowdata.status=status==1 ? "正常" : "不可用";
				rowdata.createDate="<span title='"+date+"'>"+date+"</span>";
				rowdata.edit="<a href=\"javascript:update('"+id+"','"+value+"');\">修改</a>";
				rowdata.del="<a href=\"javascript:del('"+id+"','"+value+"');\" style='color:red;'>删除</a>";
				return null;
			},
			parms : parms
		});
		$("#pageloading").hide();
	}
	
	function add(){
		window.parent.window.f_addTab("addDictionary", "新增Dictionary", "${pageContext.request.contextPath}/admin/desktop/dictionary/goDictionaryModify");
	}
	
	function update(id, value){
		window.parent.window.f_addTab("updateDictionary", value, "${pageContext.request.contextPath}/admin/desktop/dictionary/goDictionaryModify?id="+id);
	}
	
	function del(id, value){
		if(confirm("确定要删除“"+value+"”?")){
			$.ajax({
				url:"${pageContext.request.contextPath}/admin/desktop/dictionary/dictionaryDelete?id="+id,
				type:"post",
				success:function(data){
					if(data!=null && data>0){
						$.ligerDialog.alert("删除成功！");
						window.setTimeout(function(){
							loadData(null);
						}, 800);
					}else{
						$.ligerDialog.alert("删除失败！");
					}
				},
				error:function(e){
					$.ligerDialog.alert('发送错误！');
				}
			});
		}
	}
	
	//查询
	function search() {
		loadData({"value":$("#value").val(), "type":$("#type").val()});
	}
	
</script>
</head>
<body style="padding: 6px; overflow: hidden;">
	<div id="searchbar">
		值：<input id="value" type="text" value=""/>
		类型：
		<select id="type">
			<option value="">全部</option>
			<option value="3">帅气赞美</option>
			<option value="1">作者名称</option>
			<option value="2">Admin暗码</option>
		</select>
		<input id="btnOK" type="button" value="搜索" onclick="search();" />
		<img class="icon" style="float: right;" onclick="add();" src="${pageContext.request.contextPath}/resources/images/icons/add.gif" title="新增" alt="新增">
	</div>
	<div id="maingrid4" style="margin: 0; padding: 0"></div>
	<div style="display: none;"></div>
</body>
</html>