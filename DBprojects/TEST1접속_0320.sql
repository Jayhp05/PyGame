-- 2025.03.20
-- TEST1 접속

create table member(
    no number, 
    name varchar2(10)
);

INSERT INTO member VALUES(1001, '오라클');
INSERT INTO member VALUES(1002, '어머나');
INSERT INTO member VALUES(1003, '홍길동');

commit;

select * from member;

-- TEST1에서 TEST2 계정을 생성
create user test2 IDENTIFIED BY 12345678;

-- TEST2에서 세션 생성과 테이블 생성 권한 부여
grant create session, create table to test2;

select * from user_tables;

-- TEST1에서 TEST2에게 MEMBER 테이블에 접근할 수 있는 권한 부여
grant select, insert, update, delete on member to test2;

-- TEST1에서 TEST2에게 MEMBER 테이블에 접근할 수 있는 권한 회수
revoke select, insert, update, delete on member from test2;


-- 권한 회수 후, 다시 테이블 생성 안됨.
create table member(
    no number, 
    name varchar2(10)
);
