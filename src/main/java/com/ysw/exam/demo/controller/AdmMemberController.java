package com.ysw.exam.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ysw.exam.demo.service.MemberService;
import com.ysw.exam.demo.vo.Member;

@Controller
public class AdmMemberController {
	
	private MemberService memberService;
	
	public AdmMemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/adm/member/list")
	public String showList(Model model) {
		List<Member> members = MemberService.getMembers();
		
		model.addAttribute("members", members);
		
		return "adm/member/list";
	}
}
