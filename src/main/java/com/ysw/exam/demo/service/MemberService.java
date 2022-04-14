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

	public static List<Member> getMembers() {
		return memberRepository.getMembers();
	}

	public int getMembersCount(String searchKeywordTypeCode, String searchKeyword) {
		return memberRepository.getMembersCount(searchKeywordTypeCode, searchKeyword);
	}

	public static List<Member> getMembers(String searchKeywordTypeCode, String searchKeyword, int itemsCountInAPage,
			int page) {
		
		int limitStart = (page - 1) * itemsCountInAPage;
		int limitTake = itemsCountInAPage;

		List<Member> members = memberRepository.getMembers(searchKeywordTypeCode, searchKeyword, limitStart, limitTake);

		return members;
	}

}
