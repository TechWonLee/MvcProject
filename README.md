<h1 align="left">👋 Spring MVC 게시판 프로젝트</h1>

<h2 align="left">설명</h2>

###

<p align="left">✨기간<br>2024.06 ~ 2024.09<br><br>🎯목표<br>(1) 프로젝트 초기 생성 및 설정과 CRUD <br>(2)파일업로드<br>(3)소켓통신을 활용한 채팅기능<br><br>🎲세부기능<br>(1) 세션활용 로그인 (2)글 작성 후 작성자만 수정 수정,삭제 기능 부여 (3)파일 업로드 (4)채팅 </p>

###

<h2 align="left">I code with</h2>

###
<div align="left">
 <p>(1) Java (2)Spring (3)JavaScript (4) Jquery (5)Mysql</p>

###

##
<h2>쿼리 내용</h2>

(1) CREATE DATABASE woncoding DEFAULT CHARACTER SET utf8;

(2) GRANT ALL PRIVILEGES ON `woncoding`.* TO 'won'@'localhost';

(3) CREATE TABLE userinfo (
    userid VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50),
    join_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


(4) CREATE TABLE BOARD (
    seq INT AUTO_INCREMENT PRIMARY KEY,
    userid VARCHAR(50) NOT NULL,
    title VARCHAR(50) NOT NULL,
    content VARCHAR(1000) NOT NULL,
    name VARCHAR(50) NOT NULL,
    write_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    view_cnt INT NOT NULL,
    CONSTRAINT fk_userinfo FOREIGN KEY (userid) REFERENCES userinfo(userid)
);

