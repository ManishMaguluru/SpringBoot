<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="/header" />
<main class="container-fluid p-4">

	<h3>Items List</h3>
	
	<c:choose>
		<c:when test="${itemsList ne null and itemsList.size()>0}">
			<table class="table table-border table stripped mt-2">
				<thead>
					<tr>
						<th>Item code</th>
						<th>Item Name</th>
						<th>Units</th>
						<th>Rate</th>
						<th>Category</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${itemsList }" var="i">
						<tr>
							<td>${i.icode }</td>
							<td>${i.itemName}</td>
							<td>${i.unit }</td>
							<td>${i.rate }</td>
							<td>${i.category }</td>
							<td>
								<a href="/editItem/${i.icode }" class="btn btn-primary btn-sm mr-2">
									EDIT
								</a>
								<a href="/deleteItem/${i.icode }" class="btn btn-danger btn-sm mr-2">
									DELETE
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<div class="alet alert-info p-2 mt-2">
				<strong>No Items available.</strong>
			</div>
		</c:otherwise>
	</c:choose>
</main>
<jsp:include page="/footer" />