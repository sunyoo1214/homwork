package com.ysw.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ysw.exam.demo.vo.Member;

@Mapper
public interface MemberRepository {

	@Select("""
			<script>
			SELECT M.*
			FROM `member` AS M
			WHERE 1
			<if test="searchAuthLevel != 0">
			  	AND M.authLevel = #{searchAuthLevel}
	  		</if>
	  		<if test="searchAuthLevel != ''">
				<choose>
					<when test="searchAuthLevel == 7">
					 	AND M.authLevel LIKE CONCAT('%', #{searchAuthLevel}, '%')
			 		</when>
			 		<otherwise test="searchAuthLevel == 3">
					 	AND M.authLevel LIKE CONCAT('%', #{searchAuthLevel}, '%')
			 		</otherwise>
				</choose>
			</if>
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
	List<Member> getMembers(int searchAuthLevel, String searchKeywordTypeCode, String searchKeyword);

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
	int getMembersCount(int searchAuthLevel, String searchKeywordTypeCode, String searchKeyword);

	@Select("""
			<script>
			SELECT *
			FROM `member`
			WHERE id = #{id}
			</script>
			""")
	Member getMember(int id);

	@Delete("""
			DELETE FROM `member`
			WHERE id = #{id}
			""")
	void deleteMember(int id);

}
