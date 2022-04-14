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

	
	@Select("""
					<script>
					SELECT COUNT(*) AS cnt
					FROM `member` AS M
					WHERE 1
					<if test="searchKeyword != ''">
						<choose>
							<when test="searchKeywordTypeCode == 'name'">
								AND M.name LIKE CONCAT('%', #{searchKeyword}, '%')
							</when>
							<when test="searchKeywordTypeCode == 'cellphoneNo'">
								AND M.cellphoneNo LIKE CONCAT('%', #{searchKeyword}, '%')
							</when>
							<otherwise>
								AND (
									M.name LIKE CONCAT('%', #{searchKeyword}, '%')
									OR 
									M.cellphoneNo LIKE CONCAT('%', #{searchKeyword}, '%')
								)
							</otherwise>
						</choose>
					</if>
					</script>
					""")
	int getMembersCount(String searchKeywordTypeCode, String searchKeyword);


	@Select("""
			<script>
			SELECT M.*
			FROM `member` AS M
			WHERE 1
			<if test="searchKeyword != ''">
				<choose>
					<when test="searchKeywordTypeCode == 'name'">
						AND M.name LIKE CONCAT('%', #{searchKeyword}, '%')
					</when>
					<when test="searchKeywordTypeCode == 'cellphoneNo'">
						AND M.cellphoneNo LIKE CONCAT('%', #{searchKeyword}, '%')
					</when>
					<otherwise>
						AND (
							M.name LIKE CONCAT('%', #{searchKeyword}, '%')
							OR 
							M.cellphoneNo LIKE CONCAT('%', #{searchKeyword}, '%')
						)
					</otherwise>
				</choose>
			</if>
			<if test="limitTake != -1">
				LIMIT #{limitStart}, #{limitTake}
			</if>
			</script>
			""")
	List<Member> getMembers(String searchKeywordTypeCode, String searchKeyword, int limitStart,
			int limitTake);

}
