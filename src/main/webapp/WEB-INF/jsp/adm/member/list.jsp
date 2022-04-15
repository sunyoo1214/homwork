<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="회원" />

<%@ include file="../common/head.jspf"%>

<section class="mt-5">
    <div class="container mx-auto px-3">
      <div>
        회원 수 : ${membersCount}명
      </div>
    
      <div class="overflow-x-auto">
        <table class="table w-full">
          <colgroup>
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
  </div>
</section>


<%@ include file="../common/foot.jspf"%>