<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
$(document).ready(function(){
	$('#pointBtn').click(function(){
		var my_point = parseInt($('.my-point').text());		//보유한 포인트
		var use_point =  parseInt($('#point').val());		//사용할 포인트
		var payment_sum = parseInt($('#payment-sum').children("i").attr("data-sum"));	//결제금액
		
		console.log("=========== my-point" + my_point);
		console.log("=========== use-point" + use_point);
		console.log("=========== payment_sum"  + payment_sum);
		
		if(use_point > my_point) {
			alert("포인트가 부족합니다.");
			return;
		}		
		
		if(use_point > payment_sum ){								//사용할 포인트가 결제금액보다 많을경우
			$('#payment-sum').children("i").text("0");		   
			$('#discount-point').children("i").text(use_point);		//차감될 포인트
		}else{
			$('#payment-sum').children("i").text(payment_sum - use_point);
			$('#discount-point').children("i").text(use_point);
		}
	});
});
</script>

<div class="container">
	<div class="row">
		<div role="main" class="col-md-9 mr-auto">
			<div class="row pt-5 pb-3">
				<div class="col-md-5">
					<img class="img-fluid d-block"
						src="https://static.pingendo.com/cover-moon.svg">
				</div>
				<div class="col-md-7 pl-3">
					<h2 class="font-weight-bold">${room.roomName}</h2>
					<h5>
						${lodgment.company}<br>
                           <small class="text-muted">${lodgment.address}</small>
					</h5>
					<p>기준 2명 / 최대 ${room.roomCapa}명</p>
				</div>
			</div>
			
	<hr class="py-2">
			
			<form action="insertReservation.do">
				<div class="row mb-4">
					<div class="col-md-12">
						<h4 class="font-weight-bold mb-3">할인</h4>
						<div class="form-group row">
							<label for="inputReserveName" class="col-2 col-form-label">포인트 할인</label>
							<!-- <div class="col-10 col-md-4">
								<input type="text" class="form-control" id="inputReserveName" placeholder="예약자명을 입력하세요.">
							</div> -->
							<div class="col-md-10">
								<c:if test="${login eq null }">
									<span><a href="#" onclick="setCookie(30)">로그인</a>하면 적립한 포인트를 사용할 수 있어요.</span>
								</c:if>
								
								<c:if test="${login ne null }">
									<span>	
										<input type="text" id="point" value="0"> &nbsp;&nbsp;
										<button type="button" class="btn btn-secondary" id="pointBtn">포인트 적용</button> &nbsp;
																		
										사용( <em class="my-point">${login.memberPoint}</em> 보유)
									</span>
									
								</c:if>
								
							</div>
						</div>
					</div>
				</div>
				
	<hr class="py-2">
				
				<div class="row mb-4">
					<div class="col-md-12">
						<h4 class="font-weight-bold mb-3">필수 입력 사항</h4>
						<div class="form-group row">
							<label for="inputReserveName" class="col-2 col-form-label">예약자명</label>
							<div class="col-10 col-md-4">
								<input type="text" class="form-control" id="inputReserveName"
									placeholder="예약자명을 입력하세요.">
							</div>
							<div class="col-md-5">
								<span>실명을 입력해 주세요.</span>
							</div>
						</div>
						<div class="form-group row">
							<label for="inputReservePhone" class="col-2 col-form-label">휴대전화</label>
							<div class="col-10 col-md-4">
								<input type="text" class="form-control" id="inputReservePhone"
									placeholder="휴대전화 번호를 입력하세요.">
							</div>
							<div class="col-md-5">
								<span>올바른 연락처를 입력해 주세요.</span>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<nav class="col-md-3 d-none d-md-block bg-light sidebar">
			<div class="sidebar-sticky">
				<div class="sidebar-top">
					<div class="info-box">
						<div class="dateRangePicker-top row">
							<span class="col-6 mr-auto">체크인</span>
							<span class="col-6 ml-auto">체크아웃</span>
						</div>
						<div class="dateRangePicker row">
							<span class="col-6 mr-auto" id="startDate">2018-10-20</span>
							<span class="col-6 ml-auto" id="EndDate">2018-10-24</span>
						</div>
						<div class="dateRangePicker-bottom row">
							<span class="col-6 mr-auto">이용 기간</span>
							<span class="col-6 ml-auto">4박 5일</span>
						</div>
					</div>
				</div>
				<div class="sidebar-bottom">
					<div class="info-box">
						<div class="point-discount row">
							<span class="col-6 mr-auto">포인트 할인</span>
							<em class="col-6 ml-auto" id="discount-point"><i> 0</i>P</em>
						</div>
						<div class="point-benefit row">
							<span class="col-6 mr-auto">적립 포인트</span>
							<span><em class="col-6 ml-auto"><i> 0</i>P</em></span>
						</div>
						<div class="txt-tip">
							※ 포인트는 숙박 이용이 완료된 후 적립됩니다.
						</div>
						<div class="total-payment row">
							<span class="col-6 mr-auto">결제 금액</span>
							<span class="col-6 ml-auto" id="payment-sum"><i data-sum="120000"> 120000</i>원</span>
						</div>
					</div>
					<button type="button" class="btn-payment">결제하기</button>
				</div>
			</div>
		</nav>
		
	</div>
</div>
