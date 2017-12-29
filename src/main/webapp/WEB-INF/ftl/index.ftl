<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">

	<title>ToDoList</title>
	
	<link rel="stylesheet" type="text/css" href="static/css/main.css" media="screen" />

	<script src="static/js/main.js"></script>
	<!-- Just a popular set of icons (font) -->
	<script src="https://use.fontawesome.com/34f24b36b4.js"></script>

</head>
<body>

	<div id="content">

		<button onclick="showform(null, '')"
			><i class="fa fa-plus-circle" aria-hidden="true"></i></button
		>
		
		<fieldset id="editForm" style="display: none">
			<legend>Add item</legend>
			<form name="todoListItem" action="save" method="post">
				<input type="hidden" id="editId" name="id" value="">
				<label>
					Text: <input type="text" id="editText" name="text">
				</label>
				<input class="button" type="submit" value="   Save   ">
				<button type="button" onclick="hideform()">Cancel</button>
			</form>
		</fieldset>
		
		<table class="datatable">
			<tr>
				<th>#</th>
				<th>ID</th>
				<th>Text</th>
				<th>Is done?</th>
				<th>Actions</th>
			</tr>
			<#list model["todoList"]?reverse as todo>
				<tr class='${todo.done?string("done", "undone")}'>
					<td>${todo?index + 1}</td>
					<td>${todo.id}</td>
					<td>${todo.text}</td>
					<td>
						<a href="/set-done?id=${todo.id}&done=${todo.done?then('0','1')}">
						   <i class="fa fa-toggle-${todo.done?string('on','off')} toggle-button" 
						      aria-hidden="true"></i></a>
					</td>
					<td>
						<a href="#" 
						   onclick="showform('${todo.id}', '${todo.text}');return false;">
						   <i class="fa fa-pencil-square-o edit-button" aria-hidden="true"></i></a>
						<a href="/remove?id=${todo.id}">
						   <i class="fa fa-times remove-button" aria-hidden="true"></i></a>
					</td>
				</tr>
			</#list>
		</table>
		
	</div>
	
</body>
</html>
