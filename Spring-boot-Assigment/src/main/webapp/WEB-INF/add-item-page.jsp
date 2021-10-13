<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="/header" />
<main class="container-fluid p-4">

	<div class="col-sm-5 mx-auto">
		<h3 class="text-center mb-2">Add Item</h3>
		
		<form:form class="form bg-primary p-2 mb-2" method="POST" modelAttribute="item">
			<div class="form-group">
				<form:label path="itemName">Item Name</form:label>
				<form:input path="itemName" class="form-control" type="name"/>
			</div>
			<div class="form-group">
				<form:label path="unit">Units</form:label>
				<form:input path="unit" class="form-control" type="name"/>
			</div>
			<div class="form-group">
				<form:label path="rate">Rate</form:label>
				<form:input path="rate" class="form-control" type="number"/>
			</div>
			<div class="form-group">
				<form:label path="category">Category</form:label>
				<form:input path="category" class="form-control" type="name"/>
			</div>
			<button class="btn btn-secondary btn-block">save</button>
		</form:form>
	</div>
	
</main>
<jsp:include page="/footer" />