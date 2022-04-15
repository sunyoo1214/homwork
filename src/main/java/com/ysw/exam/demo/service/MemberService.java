package com.ysw.exam.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ysw.exam.demo.repository.MemberRepository;
import com.ysw.exam.demo.vo.Member;

@Service
public class MemberService {

	private static MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}


	public static List<Member> getMembers(String searchKeywordTypeCode, String searchKeyword) {

		List<Member> members = memberRepository.getMembers(searchKeywordTypeCode, searchKeyword);

		return members;
	}

}
