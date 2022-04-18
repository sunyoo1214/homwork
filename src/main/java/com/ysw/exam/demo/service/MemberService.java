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
		return memberRepository.getMembers(searchKeywordTypeCode, searchKeyword);
	}

	public int getMembersCount(int authLevel, String searchKeywordTypeCode, String searchKeyword) {
		return memberRepository.getMembersCount(authLevel, searchKeywordTypeCode, searchKeyword);
	}

	public Member getMember(int id) {
		return memberRepository.getMember(id);
	}

	public boolean deleteMember(int id) {
		Member member = getMember(id);

		if (member == null) {
			return false;
		}

		memberRepository.deleteMember(id);

		return true;
	}
}
