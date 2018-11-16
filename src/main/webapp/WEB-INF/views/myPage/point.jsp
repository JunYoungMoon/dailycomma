<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>

<style>
#col {
font-weight: bold;
color : #d728ff;
}
.poi{
font-size: xx-large;
}


</style>
<div class="reta">
	<c:forEach items="${point}" var="po" begin="1" end="1">
	<a class="poi">사용가능 포인트</a> <a class="ml-4 poi" id="col">${po.memberPoint}포인트</a>
	</c:forEach>
	<table class="table mt-3">
		<tbody class="lineset">
			<tr>
				<th>내역</th>
				<th>포인트</th>
				<th>날짜</th>
			</tr>
			<c:forEach items="${point}" var="po">
				<tr>
					<td>체크아웃</td>
					<td>+${po.reservePoints} Point</td>
					<td>${po.checkOut}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>