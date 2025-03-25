-- 2025.03.19 수

-- 8. 데이터 조작과 트랜잭션
-- 자바, 파이썬 DB 데이터를 조작(CRUD)create, read, update, delete
-- select, insert, update, delete
-- ☆★☆★☆★☆★ commit 과 rollback ☆★☆★☆★☆★

-- commit [work] [TO SAVEPOINT savepoint_name]

-- rollback [work] [TO SAVEPOINT savepoint_name]


-- member00 테이블 생성
CREATE TABLE member00(
    no NUMBER,
    id VARCHAR2(15),
    password VARCHAR2(15),
    name VARCHAR2(5 CHAR),
    gender VARCHAR2(2 CHAR),
    email VARCHAR2(20),
    phone VARCHAR2(13),
    reg_date DATE
 ); 
 
-- member00 테이블에 데이터 추가
INSERT INTO member00 VALUES(1, 'oracle', 'oracle1234', 
    '홍길동', '남성', 'oracle@naver.com', '010-1234-5678', SYSDATE);
INSERT INTO member00 VALUES(2, 'javagirl', 'javamania', 
    '김하나', '여성', 'java@oracle.com', '010-4321-9876', SYSDATE);
INSERT INTO member00 VALUES(3, 'database', 'mysql', 
    '최고집', '남성', 'database@gmail.com', '010-1111-7777', SYSDATE);
commit;

select * from member00;

CREATE TABLE member01(
  id VARCHAR2(15),  
  name VARCHAR2(5 CHAR),
  pass VARCHAR2(15), 
  gender VARCHAR2(2 CHAR),
  phone VARCHAR2(13 CHAR),
  email VARCHAR2(20),
  reg_date DATE
);

-- 데이터 추가
-- insert into 테이블이름([컬럼1, ... 컬럼n])
-- values(데이터1, ... 데이터n)
insert into member01 values('Son', '아들', '12345678', '남성', 
                            '012-3456-7890', 'asda@naver.com', '2010-01-05');
                            
select * from member01;

insert into member01 values('Sun', '태양', '12345678', '몰라', 
                            '012-3312-2312', 'asda@gmail.com', sysdate);
insert into member01 (id, name, gender, email, reg_date, pass)
    values('member01', '어머나', '여성', 'member01@daum.net', sysdate, '12345');
    
commit;  -- db 파일 자체에 저장하는 명령어

insert into member01
    select id, name, password, gender, phone, email, reg_date
    from member00 where no <=2;
commit;

-- 데이터 수정
-- update 테이블이름
-- set 컬럼1 = 데이터1, ... 컬럼n=데이터n

update member01
    set name='한국인', gender='여성', phone='010-5555-9999';
    
select * from member01;
rollback; -- db 파일에 commit이 반영되지 않았기 때문에 롤백 가능.
            -- commit하고 rollback할 시, 이미 commit이 되어있기 때문에 롤백 불가.
            
update member01
    set (phone, email) = (select phone, email from member00
                          where id='database')
where id='member01';
commit;
select * from member01;

-- 데이터 삭제
-- delete [from] 테이블이름
-- where 조건
delete from member01
where id='member01';
commit;
select * from member01;

-- 9. 테이블 생성과 제약조건
-- create table hr.member00
-- create table [schema] 이름(
--          컬럼 datatype [default exp] [column_constraint] [, ...]
-- );
-- create table mem(no number not null,
--                  name varchar(10) not null,
--                  reg_date sysdate
-- );

-- 문자형 데이터
-- CHAR, VARCHAR2
select * from nls_database_parameters;

CREATE TABLE char_table01 (
    name1 CHAR(6),
    name2 CHAR(6 CHAR),
    name3 VARCHAR2(6),
    name4 VARCHAR2(6 CHAR)
);

INSERT INTO char_table01 VALUES('ABC', '홍', 'ABC', '홍');
INSERT INTO char_table01 VALUES('ABC', '홍길', 'ABC', '홍길');
INSERT INTO char_table01 VALUES('ABC', '홍길동', 'ABC', '홍길동');
INSERT INTO char_table01 VALUES('ABC', '홍길동홍길동', 'ABC', '홍길동홍길동');

select * from char_table01;

SELECT LENGTHB(name1) name1, LENGTHB(name2) name2, 
    LENGTHB(name3) name3, LENGTHB(name4) name4 FROM char_table01;

-- 숫자는 다 number형식으로
-- number(prec | prec, scale), integer
create table num_table01(
    num1 number,
    num2 number(7),
    num3 number(7, 2), -- 최대 7자리에 소수점 2자리까지 표시
    num4 number(5),
    num5 number(6, -1) -- 마이너스(-)라면, 소수점 위부터 자리수 표시
);

INSERT INTO num_table01 VALUES(12345.67, 12345.67, 12345.67, 12345.67, 12345.67);

SELECT * FROM num_table01;

commit;

create table date_table01(
    date1 date,
    date2 timestamp,
    date3 timestamp with time zone
);

INSERT INTO date_table01 VALUES(SYSDATE, SYSDATE, SYSDATE);
INSERT INTO date_table01 VALUES(SYSDATE, SYSTIMESTAMP, SYSTIMESTAMP);
SELECT * FROM date_table01;

commit;

ALTER SESSION SET NLS_DATE_FORMAT='YYYY-MM-DD HH24:MI:SS';
ALTER SESSION SET NLS_TIMESTAMP_FORMAT='YYYY-MM-DD HH24:MI:SS.FF';
ALTER SESSION SET NLS_TIMESTAMP_TZ_FORMAT='YYYY-MM-DD HH24:MI:SS.FF TZR';

select * from date_table01;

-- 무결성 제약조건(Integrity Constraints)
-- 바람직하지 못한 데이터가 저장되는 것을 미연에 방지하기 위해 사용
-- 제약조건 확인
select * from user_constraints
where table_name = 'EMP';

select * from user_tables;
desc EMP;

-- NOT NULL 속성(제약조건) - NULL을 허용하지 않음, (지정하지 않으면 기본값으로 NULL 허용이 됨.)
create table null_table01 (
    name varchar2(5 char) not null,
    age number(3) not null,
    text varchar2(60)
);

INSERT INTO null_table01 VALUES('홍길동', 25, '좋은친구');
INSERT INTO null_table01(name, age) VALUES('홍길동', 30);
INSERT INTO null_table01(name, age) VALUES('임꺽정', 20);

select * from null_table01;

-- 유일키 제약조건(unique constraints)
select * from emp;

select * from user_constraints
where table_name = 'UNIQUE_TABLE';

create table unique_table(
    id varchar2(10) UNIQUE not null,
    name varchar2(5 char) not null,
    phone varchar2(13) not null,
    email varchar2(20) not null,
    text varchar2(100),
    constraint unique_table_uk_test UNIQUE(phone, email)
);

INSERT INTO unique_table(id, name, phone, email, text) VALUES('member', '강감찬', 
                        '010-2222-3333', 'test@naver.com', '유일키는 NULL을 비교 대상에서 제외시킨다.');
INSERT INTO unique_table(id, name, phone, email) VALUES('member1', '김유신', 
                        '010-2222-3333', 'test1@naver.com');
                        
select * from unique_table;

-- CHECK 제약조건
create table mem(
    id varchar2(15),
    name varchar2(5 char) not null,
    gender varchar2(2 char) check(gender in('여성', '남성')),
    sal number not null check(sal between 200 and 500)
);

-- 정상적으로 데이터가 추가됨
INSERT INTO mem VALUES('hostman', '임꺽정', '남성', 300);

-- NULL이 문제없이 추가됨
INSERT INTO mem VALUES('jsphost', '홍길동', NULL, 400); 

-- 남성 또는 여성 두 값 중 하나여야 하므로 에러 발생
INSERT INTO mem VALUES('hostman1', '임꺽정', '중성', 300);

select * from mem;

-- check 제약조건 아웃라인 방식
create table mem01(
    id varchar2(15),
    name varchar2(5 char) not null,
    gender varchar2(2 char) not null,
    sal number not null,
    constraint mem_gender_ck check(gender in('남성', '여성')),
    constraint mem_sal_ck check(sal between 300 and 500)
);

-- 정상적으로 데이터가 추가됨
INSERT INTO mem01 VALUES('hostman01', '이순신', '남성', 300);

-- NOT NULL 오류 발생
INSERT INTO mem01 VALUES('jsphost01', '강감찬', NULL, 400); 

-- 범위를 넘어선 값이 입력되어 오류 발생
INSERT INTO mem01 VALUES('hostman01', '김유신', '남성', 600);

select * from mem01;

-- default 속성 (기본값 설정)
create table dafault_dept(
    deptno number,
    deptname varchar2(10 char) not null,
    location varchar2(10 char) default '서울' not null
);

-- 정상적으로 데이터가 추가됨
INSERT INTO default_dept VALUES(1005, '인사부', '대전'); 

-- 기본 값이 입력됨
INSERT INTO default_dept(deptno, deptname) VALUES(1006, '관리부');

-- NOT NULL 오류
INSERT INTO default_dept VALUES(1007, '총무부', NULL);

select * from default_dept;

-- 기본키 제약 조건
create table pri_table01(
    no number primary key,
    name varchar2(5 char) constraint pri_table01_notnull not null,
    adress varchar2(80 char)
);

INSERT INTO pri_table01 VALUES(1, '홍길동', '서울 구로구 구로동');
INSERT INTO pri_table01(no, name) VALUES(2, '강감찬');
INSERT INTO pri_table01(no, name) VALUES(3, '이순신');

select * from pri_table01;

create table pri_table02(
    no number,
    name varchar2(5 char) not null,
    adress varchar2(80 char),
    constraint pri_table02_pk primary key(no)
);

INSERT INTO pri_table02 VALUES(1, '홍길동', '서울 구로구 구로동');
INSERT INTO pri_table02(no, name) VALUES(2, '강감찬');
INSERT INTO pri_table02(no, name) VALUES(3, '이순신');

select * from pri_table02;

-- 외래키(외부키) 제약조건(Foreign Key Constraintadd_job_history)
desc dept;
select * from dept;
select * from emp;

create table dept01 (
    deptno number,
    deptname varchar2(10 char) not null,
    location varchar2(10 char) not null,
    constraint dept01_pk primary key(deptno)
);

INSERT INTO dept01 VALUES(1001, '관리부', '서울');
INSERT INTO dept01 VALUES(1002, '영업부', '대전');
INSERT INTO dept01 VALUES(1003, '전산부', '인천');
INSERT INTO dept01 VALUES(1004, '생산부', '충남');

select * from dept01;

-- 인라인 외부키 제약조건 정의
create table emp01(
    empno number primary key,
    name varchar2(5 char)not null,
    hiredate date not null,
    deptno number not null constraint emp01_fk REFERENCES dept01(deptno)
);

select * from dept01;

insert into emp01 values(100, '홍길동', sysdate, 1001);
insert into emp01 values(101, '홍길동', sysdate, 1002);

select * from emp01;

-- 아웃라인 외부키 제약조건 정의
create table emp02(
    empno number,
    name varchar2(5 char) not null,
    hiredate date not null,
    deptno number not null,
    constraint emp01_pk primary key(empno),
    constraint emp01_fk_01 foreign key(deptno) REFERENCES dept01(deptno)
);

select * from dept01;

insert into emp02 values(100, '홍길동', sysdate, 1001);
insert into emp02 values(101, '홍길동', sysdate, 1002);
insert into emp02 values(102, '홍길동', sysdate, 1004);

select * from emp02;

-- 테이블 생성 후 외래키 제약조건 추가
ALTER TABLE emp01
    ADD CONSTRAINT emp01_pk PRIMARY KEY(empno);

ALTER TABLE emp01
    ADD CONSTRAINT emp01_fk FOREIGN KEY(deptno) 
REFERENCES dept01(deptno);

-- 테이블 복사
create table emp03 as select * from emp02;

select * from emp03;

-- 아래 쿼리를 실행해 제약조건이 제대로 복사되었는지 확인해 보자.
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, SEARCH_CONDITION FROM user_constraints
WHERE table_name='EMP03';

-- 테이블 수정하기
-- 테이블 이름 수정
rename member01 to members;

-- 컬럼 추가
select * from members;
alter table members
    add (age number(3)); -- not null 속성 부여 x, 다른 데이터의 값이 존재하기 때문에 추가 컬럼에선 not null 부여 안됨.
    
-- 컬럼이름 변경
alter table members
    rename COLUMN name TO member_ename;

select * from members;

-- 테이블의 모든 데이터 삭제
delete from members;
select * from members;
rollback; -- commit하지 않은 테이블의 데이터 복구 가능
-- 하지만, TRUNCATE 문을 사용하여 삭제 시, 복구 불가
-- DROP도 마찬가지 복구 불가.




