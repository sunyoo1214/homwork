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

	public static List<Member> getMembers(int searchAuthLevel, String searchKeywordTypeCode, String searchKeyword) {
		return memberRepository.getMembers(searchAuthLevel, searchKeywordTypeCode, searchKeyword);
	}

	public int getMembersCount(int searchAuthLevel, String searchKeywordTypeCode, String searchKeyword) {
		return memberRepository.getMembersCount(searchAuthLevel, searchKeywordTypeCode, searchKeyword);
	}

	public Member getMember(int id) {
		return memberRepository.getMember(id);
	}

	public void deleteMember(List<Integer> memberIds) {
		for (int id : memberIds) {
			Member member = memberRepository.getMember(id);

			if (member != null) {
				memberRepository.deleteMember(id);
			}
		}
	}
}
