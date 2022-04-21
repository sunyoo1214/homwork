package com.ysw.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysw.exam.demo.service.MemberService;
import com.ysw.exam.demo.vo.Member;

@Controller
public class AdmMemberController {
	
	private MemberService memberService;
	
	public AdmMemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/adm/member/list")
	public String showList(Model model, @RequestParam(defaultValue = "0") int searchAuthLevel, @RequestParam(defaultValue = "name, cellphoneNo") String searchKeywordTypeCode, 
			@RequestParam(defaultValue = "") String searchKeyword) {
		
		
		int membersCount = memberService.getMembersCount(searchAuthLevel, searchKeywordTypeCode, searchKeyword);
		
		List<Member> members = MemberService.getMembers(searchAuthLevel, searchKeywordTypeCode, searchKeyword);
		
		model.addAttribute("searchKeywordTypeCode", searchKeywordTypeCode);
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("members", members);
		model.addAttribute("membersCount", membersCount);
		
		return "adm/member/list";
	}
	
	@RequestMapping("/adm/member/doDelete")
	@ResponseBody
	public String doDelete(@RequestParam(defaultValue = "") String memberId) {
		List<Integer> memberIds = new ArrayList<>();
		
		for (String id : memberId.split(",")) {
			memberIds.add(Integer.parseInt(id));
		}

		memberService.deleteMember(memberIds);
		
		return ("선택한 회원의 정보가 삭제되었습니다.");
		
	}
	
	@RequestMapping("/adm/member/getMember")
	@ResponseBody
	public Object getMember(int id) {
		
		Member member = memberService.getMember(id);
		
		if (member == null) {
			return "존재하는 회원 정보가 없습니다.";
		}
		
		return member;
	}
	
}
