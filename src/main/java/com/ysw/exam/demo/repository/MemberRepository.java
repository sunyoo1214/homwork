package com.ysw.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ysw.exam.demo.vo.Member;

@Mapper
public interface MemberRepository {

	@Select("""
					SELECT M.*
					FROM `member` AS M
					ORDER BY M.id DESC
					""")
	List<Member> getMembers();

}
