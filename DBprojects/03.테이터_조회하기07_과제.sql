-- #####################################################################
-- ### 데이터 조회하기07_과제
-- #####################################################################

-- 최소 7개 이상을 풀어서 양식에 작성해 제출합니다. 
-- 모든 문제를 풀어서 제출해도 됩니다.

-- 아래 요구사항에 맞게 EMP 테이블에서 데이터를 조회하시오
--#####################################################################

@D:\MyProject\DBprojects\SQL_DATA\EMP_EXAMPLE.sql
@D:\MyProject\DBprojects\SQL_DATA\star.sql
@D:\MyProject\DBprojects\SQL_DATA\UNION_SET.sql
@D:\MyProject\DBprojects\SQL_DATA\EXAMPLE_JOIN.sql
@D:\MyProject\DBprojects\SQL_DATA\SUBQUERY.sql

-- 01. 부서번호가 10번인 직원의 이름, 성별, 직급, 생일, 부서번호를 조회하시오
select * from emp;

select ename, gender, job, birthday, deptno from emp
where deptno = 10;


-- 02. 급여가 400만원 이상인 직원의 이름, 성별, 입사일, 급여, 부서번호 조회
select * from emp;

select ename, gender, hiredate, sal, deptno from emp
where sal >= 400;


-- 03. empno, ename, birthday, sal, deptno 컬럼을 각각 사번, 이름, 생일, 급여, 
-- 부서번호로 별칭을 지정해 조회하시오. 단, 10번 부서에 소속된 직원은 제외하고 조회하시오.
select * from emp;

select empno 사번, ename 이름, birthday 생일, sal 급여, deptno 부서번호 from emp
where deptno != 10;


-- 04. 급여가 300미만이면서 입사일이 2010년 이전에 입사한 직원의 사번, 이름, 직책, 
-- 입사일, 급여, 부서번호 조회하시오.
select * from emp;

select empno, ename, job, hiredate, sal, deptno from emp
where sal < 300 and hiredate < '2010-01-01';


-- 05. 부서가 20, 40이면서 입사일이 2005년 ~ 2010에 입사한 직원의 사번, 이름, 급여, 
-- 입사일 부서번호를 조회하시오.
select * from emp;

select empno, ename, sal, hiredate, deptno from emp
where deptno = 20 and deptno = 40 or hiredate between '2005-01-01' and '2010-12-31';


-- 06. 입사일이 2008년 이전인 직원중에 인사부, 영업부 소속의 직원의 리스트
-- 단, 입사일이 최근인 직원부터 출력
select * from dept; -- 20 인사부, 30 영업부

select * from emp;

select * from emp
where deptno in (20, 30) and hiredate < '2008-01-01'
order by hiredate DESC;

-- 07. 직급이 사원과 대리인 여직원을 출력
-- 단 입사일이 빠른 순으로 정렬
select * from emp;

select * from emp
where gender = 'F' and job in ('사원', '대리')
order by hiredate;


-- 08. 영업부 소속 직원 중에서 급여가 400만원 이상인 직원의 리스트
-- 단, 급여를 많이 받는 직원 부터 출력
select * from emp;

select * from dept; -- 영업부 30

select * from emp
where deptno = 30 and sal >= 400
order by sal desc;

-- 09. 영업부 소속이 아니고 입사일이 2008년 이전과 2010년 이후에 입사한 직원중에서
-- 400 이하의 급여를 받는 직원의 리스트, 단, 급여를 적게 받는 직원 순으로 출력
select * from emp;

select * from emp
where deptno != 30 and hiredate < '2008-01-01' or hiredate > '2010-12-31' and sal <= 400
order by sal;


-- 10. 부서가 경리부, 전산부가 아니고 생일이 80년 1월 1일 이후에 태어난 직원중에서
-- 직급이 과장 이상인 직원의 리스트를 출력 단, 나이가 적은 순으로 출력
select * from emp;

select * from dept; -- 경리부 10, 전산부 40

select * from emp
where deptno in(20, 30) and birthday >= '1980-01-01' and job != '사원' and job != '대리'
order by birthday desc;


