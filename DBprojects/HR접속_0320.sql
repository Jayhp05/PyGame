-- 2025.03.20

-- 뷰(View) <보안이나 편의성을 위한 테이블>
-- CREATE [OR REPLACE] VIEW 뷰이름 AS
-- SELECT 문장
-- [ WITH CHECK OPTION [CONSTRAINT 제약조건] ]
-- [ WITH READ ONLY ]
create view emp_view as
select empno, ename, job, hiredate, deptno from emp;

select * from emp_view;

create or replace view emp_view as
select empno 사번, ename 이름, job 직급, birthday 생일, hiredate 입사일 from emp
where deptno in(10, 30);

select * from emp_view;

select 사번, 이름, 생일 from emp_view;

-- 데이터 사전
select * from user_constraints;
select * from user_tables;
select * from user_views;
select * from user_indexes;
select * from user_sequences;

-- 복합부 => 여러 테이블을 조인해 만든 뷰
-- 사장을 제외한 직급별 최저 급여를 받는 직원리스트
-- 1. 직급별 최저 급여
select job, min(sal) from emp
where job != '사장'
group by job;

select job, min(sal) from emp
group by job
having max(sal) not in (select max(sal) from emp);

-------------------------아래 view 테이블에 적용하기------------------------------

create or replace view emp_min_sal as
select e.ename 이름, e.job 직급, e.hiredate 입사일, e.sal 급여, d.dname 부서명 from emp e, dept d
where e.deptno = d.deptno
    and (e.job, e.sal) in (select job, min(sal) from emp
        group by job
        having max(sal) not in (select max(sal) from emp))
order by e.sal desc;

select * from emp_min_sal;

drop view emp_view;

select * from user_views;

-- 시퀀스(SEQUENCE)
create table seq_member(
    no number primary key,
    name varchar2(5 char) not null,
    age number(3) not null
);

create SEQUENCE seq_member_no
    start with 1 -- 처음 시작은 무조건 1부터
    increment by 1 -- 증가되는 개수를 의미
    maxvalue 10000;

select seq_member_no.CURRVAL from dual; -- 오류 발생을 불러오는 코드
-- 오류 해결을 위해 취해야 할 명령: select NEXTVAL from the sequence before selecting CURRVAL;
select seq_member_no.NEXTVAL from dual; -- 1씩 증가되는 시퀀스를 실행 (최초로 1번은 실행해야함)

-- 데이터를 추가해 시퀀스 정의
INSERT INTO seq_member VALUES(seq_member_no.NEXTVAL, '홍길동', 15);
INSERT INTO seq_member VALUES(seq_member_no.NEXTVAL, '임꺽정', 27);
INSERT INTO seq_member VALUES(seq_member_no.NEXTVAL, '장길산', 19);
commit;

-- 위 행을 추가하고 나서 이 쿼리문 실행하면 정상 작동
select seq_member_no.CURRVAL from dual;

select * from seq_member;

-- DDL(Data Definition Language) 데이터 정의어
-- CREATE, DROP, ALTER
alter SEQUENCE seq_member_no
    MAXVALUE 200
    cache 5;
    
drop SEQUENCE seq_member_no;

-- 시퀀스의 대소문자도 구분해서 맞춰야 시퀀스 테이블의 수정과 삭제가 실행이 됨.
-- 처음에 SEQUNCE 라고 정의를 했으면 그 다음 부분도 다 대문자로
-- 만약 소문자로 sequence라고 정의를 했다면 그 이후 다 소문자로

-- 인덱스(INDEX)
create table index_emp(
    empno number,
    ename varchar2(5 char),
    hiredate date,
    sal number,
    deptno number
);

create sequence seq_indexemp_empno;

-- PL/SQL 이용해서 EMP 테이블
begin
    for i in 1.. 200000 loop
        insert into index_emp select seq_indexemp_empno.NEXTVAL,
            ename, hiredate, sal, deptno from emp;
    end loop
    commit;
end;
/
-- PL/SQL 블록으로 250만 행의 데이터가 추가되므로 시스템에 따라서 20초 이상이 소요된다.

select count(*) from index_emp;

insert into index_emp VALUES(
    seq_indexemp_empno.NEXTVAL, '감사봉', '2011-12-01', 350, 40
);
----------------------------------
-- 인덱스와 검색 속도 비교
----------------------------------

-- before : 0.113초
select * from index_emp
where ename = '감사봉';

-- ename 컬럼에 index 생성
create index ind_indexemp_ename
on index_emp(ename);

-- after : 0.005초
select * from index_emp
where ename = '감사봉';

-- 데이터 사전
SELECT * FROM user_tables;
SELECT * FROM user_views;
SELECT * FROM user_indexes;
SELECT * FROM user_sequences;
SELECT * FROM user_constraints;






