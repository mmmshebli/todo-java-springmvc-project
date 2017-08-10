<%@ include file="common/header.jspf" %>
<div class="container">
	<form:form method="post" commandName="todo">
		<fieldset class="form-group">
			<legend>Todo</legend>
			
			
			<form:hidden path="id"/>
			<form:label path="name">Name</form:label>
			<form:input path="name" type="text" class="form-control"/>
			<form:label path="desc">Description</form:label>
			<form:input path="desc" type="text" class="form-control"/>
			<form:errors path="desc" cssClass="text-warning"/>
			<form:label path="targetDate">Target date</form:label>
			<form:input path="targetDate" type="date" class="form-control"/> 
			<form:errors path="targetDate" cssClass="text-warning"/>
			<form:label path="isDone">Done</form:label>
			<form:input path="isDone" type="text" class="form-control"/>
			
		</fieldset>
		<input type="submit" value="Add" class="btn btn-success"/>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>