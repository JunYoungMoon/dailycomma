<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>

<!-- 예약 내역 -->
<div class="row">
	<div class="col-md-12">
		<table class="table table-hover table-sm">
			<thead class="thead-light">
				<tr class="text-center">
					<th scope="col">예약번호</th>
					<th scope="col">이름</th>
					<th scope="col">이메일</th>
					<th scope="col">연락처</th>
					<th scope="col">예약 날짜</th>
					<th scope="col">예약 인원</th>
					<th scope="col">예약 금액</th>
					<th scope="col">예약 상태</th>
					<th scope="col">체크인</th>
					<th scope="col">체크아웃</th>
					<th scope="col">일수</th>
					<th scope="col">상태변경일</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${list}" var="reservation">
					<!-- checkin 날짜 포맷 변환 -->
					<fmt:parseDate value="${reservation.checkin}" var="checkin_D" pattern="yyyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${checkin_D}" var="checkin_FD" pattern="yyyy.MM.dd"/>
					<fmt:parseNumber value="${checkin_D.time / (1000*60*60*24)}" var="checkinDate" integerOnly="true"/>
					
					<!-- checkout 날짜 포맷 변환 -->
					<fmt:parseDate value="${reservation.checkout}" var="checkout_D" pattern="yyyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${checkout_D}" var="checkout_FD" pattern="yyyy.MM.dd"/>
					<fmt:parseNumber value="${checkout_D.time / (1000*60*60*24)}" var="checkoutDate" integerOnly="true"/>
					
					<!-- checkout-checkin 계산하여 일수 구하기 -->
					<fmt:parseNumber value="${checkoutDate - checkinDate}" var="totalDate" integerOnly="true"/>
					
				<tr class="text-center">
					<td>${reservation.reserveNo}</td>
					<td>${reservation.memberName}</td>
					<td>${reservation.memberEmail}</td>
					<td>(010-0000-0000)</td>
					<td>
						<fmt:parseDate value="${reservation.reserveDate}" var="reserveDate_D" pattern="yyyy-MM-dd HH:mm:ss"/>
						<fmt:formatDate value="${reserveDate_D}" pattern="yyyy.MM.dd"/>
					</td>
					<td>${reservation.reservePeople}</td>
					<td>${reservation.reservePrice}원</td>
					<td>${reservation.reserveState}</td>
					<td>${checkin_FD}</td>
					<td>${checkout_FD}</td>
					<td>${totalDate}박 ${totalDate + 1}일</td>
					<td>(상태변경일)</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<div class="row">
	<div class="col-md-12 d-flex flex-row justify-content-end mb-4">
		<a class="btn btn-outline-danger" href="#">선택 삭제</a>
	</div>
</div>
<!-- 페이징 버튼 -->
<my:paging paging="${paging}" />