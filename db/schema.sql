# DB 생성
DROP DATABASE IF EXISTS homework;
CREATE DATABASE homework;
USE homework;

# 회원 테이블 생성 
CREATE TABLE `member` (
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME NOT NULL,
updateDate DATETIME NOT NULL,
loginId CHAR(20) NOT NULL,
loginPw CHAR(60) NOT NULL, 
authLevel SMALLINT(2) UNSIGNED DEFAULT 3 COMMENT '권한레벨(3=일반, 7=관리자)',
`name` CHAR(20) NOT NULL,
nickname CHAR(20) NOT NULL,
cellphoneNo CHAR(20) NOT NULL, 
email CHAR(50) NOT NULL, 
delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '탈퇴여부(0=탈퇴전, 1=탈퇴)',
delDate DATETIME COMMENT '탈퇴날짜'
);

# 회원, 테스트 데이터 생성(관리자 회원) 
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'admin',
loginPw = 'admin',
authLevel = 7,
`name` = '관리자',
nickname = '관리자',
cellphoneNo = '01011111111',
email = 'admin@gmail.com';

# 회원, 테스트 데이터 생성(일반 회원)
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user1',
loginPw = 'user1',
`name` = '양선우',
nickname = '양선우',
cellphoneNo = '01045676093',
email = 'sunyoo1214@gmail.com';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user2',
loginPw = 'user2',
`name` = '이민기',
nickname = '이민기',
cellphoneNo = '01035554302',
email = 'bigi0511@naver.com';

# 회원 정보 가져오기
SELECT *
FROM `member`;


