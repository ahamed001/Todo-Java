<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<h2>Your Todos </h2>
	<table class="table">
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a href="deleteTodo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
					<td><a href="updateTodo?id=${todo.id}" class="btn btn-warning">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="addTodo" class="btn btn-success">Add Todo</a>
</div>
<%@ include file="common/footer.jspf" %>