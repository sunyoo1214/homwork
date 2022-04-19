<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="회원" />

<%@ include file="../common/head.jspf"%>

<section class="mt-8">
  <div class="container mx-auto px-3">
    <div>
      회원 수 :
      <span class="badge badge-primary">${membersCount}</span>
      명
    </div>

    <div class="flex mt-8">

      <form>
        <input class="input input-bordered w-72 mr-2" type="text" placeholder="검색어" maxlength="20"
          value="${param.searchKeyword}" name="searchKeyword" />
        <select class="select select-bordered" data-value="${param.searchKeywordTypeCode}" name="searchKeywordTypeCode">
          <option disabled="disabled">검색타입</option>
          <option value="name">이름</option>
          <option value="cellphoneNo">전화번호</option>
          <option value="name, cellphoneNo">이름, 전화번호</option>
        </select>
        <button type="submit" class="ml-2 btn btn-primary">조회</button>
      </form>

      <button class="ml-2 btn btn-primary do-delete-button">삭제</button>

      <form style="display: none;" method="POST" name="do-delete-form" action="../member/doDelete">
        <input type="hidden" name="memberId" value="" />
      </form>

    </div>

    <div class="mt-8">
      <table class="table w-full">
        <colgroup>
          <col width="50" />
          <col width="50" />
          <col width="150" />
          <col width="150" />
          <col width="150" />
          <col width="150" />
          <col width="150" />
          <col width="150" />
          <col />
        </colgroup>
        <thead>
          <tr>
            <th>
              <input type="checkbox" class="checkbox-all-member-id">
            </th>
            <th>번호</th>
            <th>가입날짜</th>
            <th>아이디</th>
            <th>권한레벨</th>
            <th>이름</th>
            <th>별명</th>
            <th>전화번호</th>
            <th>이메일</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="member" items="${members}">
            <tr>
              <td>
                <input type="checkbox" class="checkbox-member-id" value="${member.id}">
              </td>
              <td>${member.id}</td>
              <td>${member.regDate.substring(2, 16)}</td>
              <td>${member.loginId}</td>
              <td>${member.authLevel}</td>
              <td>${member.name}</td>
              <td>${member.nickname}</td>
              <td>${member.cellphoneNo}</td>
              <td>${member.email}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

    <script>
          $('.checkbox-all-member-id').change(function() {
            const all = $(this);
            const allChecked = all.prop('checked');
            
            $('.checkbox-member-id').prop('checked', allChecked);
          });
          
          $('.checkbox-member-id').change(function(){
            const checkboxMemberIdCount = $('.checkbox-member-id').length;
            const checkboxMemberIdCheckedCount = $('.checkbox-member-id:checked').length;
            
            const allChecked = checkboxMemberIdCount == checkboxMemberIdCheckedCount;
            
            $('.checkbox-all-member-id').prop('checked', allChecked);
          });
    </script>
    <script>
      $('.do-delete-button').click(function(){
		
      const values = $('.checkbox-member-id:checked').map((index, el) => el.value).toArray();
      
      if (values.length == 0) {
        alert('삭제할 회원을 선택해주세요.');
        return;
      }
      
      
      if (confirm('정말 삭제하시겠습니까?') == false){
        return;
      }
      
      document['do-delete-form'].memberId.value = values.join(',');
      document['do-delete-form'].submit();
      
      });

      </script>

  </div>
</section>


<%@ include file="../common/foot.jspf"%>