<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>게시글제목</th>
				<th>작성자이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="boards" items="${boardsList}">
				<tr>
					<td>${boards.id}</td>
					<td><a href="/boards/${boards.id}">${boards.title}</a></td>
					<td>${boards.username}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>${param.page}</h2>
	<ul class="pagination">
		<!--<c:choose>
			<c:when test="${}">
				<li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="#">Previous</a></li>
			</c:otherwise>
		</c:choose>-->
		<li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
		<c:forEach var="i" begin="1" end="${paging.totalPage}">
			<li class="page-item"><a class="page-link" href="?page=${i-1}"><c:out value="${i}" /></a></li>
		</c:forEach>
		<li class="page-item"><a class="page-link" href="/?page=${param.page + 1}">Next</a></li>
	</ul>

</div>

<%@ include file="../layout/footer.jsp"%>

