<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	Hello ${name} </br>
	${todos} </br>
	<table class="table table-striped">
		<caption>Your Todos are</caption>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Desc</th>
				<th>target date</th>
				<th>Completed</th>
				<th></th>
			</tr>
		</thead>
		<c:forEach items="${todos}" var="todo">
			<tr>
				<td>${todo.id}</td>
				<td>${todo.name}</td>
				<td>${todo.desc}</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}"/></td>
				<td>${todo.isDone}</td>
				<td><a href="${pageContext.request.contextPath}/update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
				<td><a href="${pageContext.request.contextPath}/delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
			</tr>
		</c:forEach> 
	</table>
	<div>
		<a class="btn btn-success" href="${pageContext.request.contextPath}/add-todo">Add Todo</a>
	</div>
</div>
<%@ include file="common/footer.jspf" %>