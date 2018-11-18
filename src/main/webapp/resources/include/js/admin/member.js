/*
 * member.js
 */

$(function() {

	$("input[type=checkbox]").prop("checked",false);
	createMemberDropdown();
	
	$('#memberSearchBtn').click(function(){
		var txt = $('#inlineFormInputGroup').val();
		$('input[name="searchKeyword"]:hidden').val(txt);
		go_page(1);
	});
});


function createMemberDropdown(){
	$('#sortdown').empty();
	var button = "<button type='button' class='dropdown-item' onclick='searchHost(\"B1\")'>승인</button>"
				+"<button type='button' class='dropdown-item' onclick='searchHost(\"B2\")'>미승인</button>"
				+"<button type='button' class='dropdown-item' onclick='searchHost(\"B3\")'>대기</button>";	
				
	$('#sortdown').append(button);
	
	button="";
	
	$('#searchdown').empty();
	button = "<button type='button' class='dropdown-item' onclick='searchMember(\"memberNo\")'>회원번호</button>"
			+"<button type='button' class='dropdown-item' onclick='searchMember(\"memberName\")'>이름</button>"
			+"<button type='button' class='dropdown-item' onclick='searchMember(\"memberNick\")'>닉네임</button>"
			+"<button type='button' class='dropdown-item' onclick='searchMember(\"memberEmail\")'>이메일</button>";
	$('#searchdown').append(button);

	$('.searchBtn').attr("id","memberSearchBtn");
}

function searchMember(condition){
	$('input[name="searchCondition"]:hidden').val(condition);
}

$(document).ready(function(){
	
	$('#memberDeleteSelected').click(function(){
		var checkbox = [];		
		
		$('input[name="_selected_"]:checked').each(function(){
			checkbox.push($(this).val());
		});
		
		var alldata = { "checkbox" : checkbox};
		
		if(checkbox.length == 0) {
			alert("선택 사항이 없습니다.");
			return;
		}
		
		if (confirm(checkbox.length +"건을 삭제하시겠습니까??") == false){
			return;
		}
		
		
	    $.ajax({
	        url:"./deleteMembers.ajax",
	        data : JSON.stringify(checkbox),
	        contentType: 'application/json; charset=utf-8',
	        type: "DELETE",
	        dataType: "json",
			error: function(xhr, status, msg) {
				console.log('상태값 : ' + status + ', Http에러메시지 : ' + msg);
			},
			success: function(xhr) {
				if(xhr.result == true)	alert(checkbox.length+ '건이 삭제되었습니다.');
				else alert("해당 건수가 없습니다.");
				
				var p = $('input[name="page"]:hidden').val();
				go_page(p);
			}	   
	    
	    });
	    
	});

});


function createLodgmentDropdown(){
	$('.dropdown-menu').empty();
	var btn = "";
	btn = "<button type='button' class=''";
	
}	

//페이징 처리
function go_page(p) {

	$('input[name="page"]:hidden').val(p);
	
    $.ajax({
        url:"./member.ajax",
        data :$('#memberPagingForm').serialize(),
        type: "GET",
        dataType: "json",
        success: callbackMember
    });
}
	
function sort(s) {
	document.memberPagingForm.sort.value = s;
	document.memberPagingForm.submit();
}

function callbackMember(datas){
	console.log(datas);
	var list = datas.list;
	var paging = datas.paging;
	var html="";
	
	$.each(list,function(idx,data){
		html += ('<tr class="text-center">'+
				 '<td scope="row">'+
				 '<label class="custom-control custom-checkbox">'+
				 '<input type="checkbox" name="_selected_" value="'+data.memberNo+'" class="custom-control-input">'+
				 '<span class="custom-control-indicator"></span>'+
				 '</label>'+
				 '</td>'+
				 '<td>'+data.memberNo+'</td>'+
				 '<td>'+data.memberName+'</td>'+
				 '<td>'+data.memberNick+'</td>'+
				 '<td>'+data.memberEmail+'</td>'+
				 '<td>'+data.memberPoint+'</td>'+
				 '<td>'+data.signupDate+
				 '</td>'+
				 '<td>'+
				 '<div class="btn-group">'+
				 '<button id="btnEdit" class="btn btn-outline-success btn-sm">수정</button>'+
				 '<button id="btnDelete" class="btn btn-outline-danger btn-sm">삭제</button>'+
				 '</div>'+
				 '</td>'+
				 '</tr>');
	});
	
	
	var temp;
	var page = "<ul class='pagination justify-content-center'>" +
				"<li class='page-item'>이전";
	
	for(var i=paging.startPage; i<=paging.endPage; i++){
		if(i != paging.page){
			temp = "<li class='page-item'><a class='page-link' href='#' onclick='go_page("+i+")'>"+i+"</a>"
		}
		else{
			temp = "<li class='page-item active'><a class='page-link' href='#' onclick='go_page("+i+")'>"+i+"</a>"
		}
		page += temp;
	}
	
	page += "<li class='page-item'>다음";
	page += "</ul>";
	
	$('#memberTbody').empty();
	$('#memberPaging').empty();
	
	$('#memberTbody').append(html);
	$('#memberPaging').append(page);
	
}

/*
 * 멤버 삭제 이벤트
 */
$('body').off().on('click', '#btnDelete', function() {
	var memberNo = $(this).closest('tr').find($('input[type=checkbox]')).val();
	var confirmMember = confirm(memberNo + ' 사용자를 정말 삭제하겠습니까?');
	var p = $('input[name="page"]:hidden').val();
	
	if(confirmMember) {
		$.ajax({
			url: 'member/' + memberNo,
			type: 'DELETE',
			contentType: 'application/json; charset=utf-8',
			dataType: 'json',
			error: function(xhr, status, msg) {
				console.log('상태값 : ' + status + ', Http에러메시지 : ' + msg);
			},
			success: function(xhr) {
				console.log(xhr.result);
				alert(memberNo + ' 회원이 삭제되었습니다.');
				go_page(p);
			}
		})
	}
})