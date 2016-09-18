<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<center>
		<div style="margin-top: 50px;"></div>
		<a id="add" href="javascript:void(0)">增加</a>
		&nbsp;&nbsp;
		<a id="delBatch" href="javascript:void(0)">删除</a>
		<table>
			<tr>
				<td><input type="checkbox" name="mid"/></td>
				<td style="width: 200px;">人员ID</td>
				<td>人员姓名</td>
				<td>人员年龄</td>
			</tr>
			<c:forEach var="person" items="${page.data.content}" >
		     	<tr>
		     		<td><input type="checkbox" name="ids" value="${person.id}"/></td>
		     		<td>${person.id}</td>
		     		<td>${person.name}</td>
		     		<td>${person.age}</td>
		     		<td><a href="javascript:void(0)" id="${person.id}">删除</a>
		     	<tr>
			</c:forEach>
		</table>
	</center>
	<div class = "pageDiv">
		<div id="page"></div>
	</div>
	<script type="text/javascript">
		$(function(){
			$('input[name="mid"]').change(function(){
				$('input[name="ids"]').prop('checked', $('input[name="mid"]').prop('checked'));
			});
			
			$('#delBatch').click(function(){
				if($('input[name="ids"]:checked').length == 0) {
					alert("未选中元素");
					return;
				}
				var data = {
					ids: [],
				};
				$('input[name="ids"]:checked').each(function(index, checkbox){
					data.ids.push(checkbox.value);
				});
				/* alert(JSON.stringify(data)); */
				$.ajax({
					 type: "POST",
		             url: "person/delBatch",
		             data: $.param(data, true),
		             dataType: "json",
		             success: function(data){
		            	 window.location.reload();
		            	 alert(data.msg);
		             },
		             error: function(data){
		            	 alert("内部错误");
		             }
				});
			});
			
			$("table td a").click(function(){
				var id = $(this).attr("id");
				$.ajax({
					 type: "GET",
		             url: "person/del",
		             data: {"id": id},
		             dataType: "json",
		             success: function(data){
		            	 window.location.reload();
		            	 alert(data.msg);
		             },
		             error: function(data){
		            	 alert("内部错误");
		             }
				});
			});
			
			$("#page").paginate({
				count 		: parseInt("${page.data.pageCount}"),
				start 		: parseInt("${page.data.pageNumber}"),
				display     : 6,
				border					: true,
				border_color			: '#BEF8B8',
				text_color  			: '#68BA64',
				background_color    	: '#E3F2E1',	
				border_hover_color		: '#68BA64',
				text_hover_color  		: 'black',
				background_hover_color	: '#CAE6C6', 
				rotate      : false,
				images		: false,
				mouse		: 'press',
				onChange    : function(page){
					getPage(page);
				}
			});
		});
	</script>
</body>
</html>