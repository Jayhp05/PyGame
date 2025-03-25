-- ######################################################################
-- 집계함수07_과제
-- ######################################################################

-- 최소 4개 이상을 풀어서 양식에 맞게 작성해 제출합니다. 
-- 모든 문제를 풀어서 제출해도 됩니다.
-- ######################################################################

-- 1. professor 테이블에서 가장 오래된 교수의 입사일과 가장 최근에 입사한 교수의 입사일을 조회하시오.
select * from professor;

select hiredate from professor
order by hiredate; -- 입사일 조회

select max(hiredate) "입사일 오래된 교수", min(hiredate) "최근에 입사한 교수" from professor;


-- 2. professor 테이블에서 전임강사의 급여 평균과 보너스 평균을 조회하시오.
select * from professor
where position = '전임강사';

select avg(pay) "급여 평균", avg(NVL(bonus, 0)) "보너스 평균" from professor -- 만약 값이 없을 경우 0으로 대체
where position = '전임강사';


-- 3. emp 테이블에서 부서별 여직원의 수를 조회하시오.
select * from emp;

select * from dept;

select deptno "부서번호", count(gender) "여직원 수" from emp
where gender = 'F'
group by deptno;



-- 4. emp 테이블에서 부서별 직책별 직원의 급여 합계와 급여 평균을 조회하시오.
--   숫자는 잘 정돈되게 세자리마다 콤마(,)를 찍어 출력하시오.
select * from emp;

select * from dept;

select deptno "부서", job "직책",
        to_char(sum(sal), 'L999,999') || '만원' "급여 합계", 
        to_char(avg(sal), 'L999,999') || '만원' "급여 평균" from emp
group by deptno, job;
    

-- 5. 위의 쿼리는 부서별 정렬은 잘되나 부서에서 직책별 정렬이 한글로 되어있어
--   가나다 순으로 정렬된다. 이것을 사원, 대리, ~ 부장, 사장 형태로 정렬되도록 하시오
select deptno, job,
        to_char(sum(sal), 'L999,999') || '만원', 
        to_char(avg(sal), 'L999,999') || '만원' from emp
group by deptno, job
order by decode(job,
        '사원', 1,
        '대리', 2,
        '과장', 3,
        '차장', 4,
        '부장', 5,
        '사장', 6,
        '기타');



-- 6. 급여 합계가 2000이 넘는 부서의 부서번호, 부서명, 인원, 급여 합계, 급여 평균을 조회하고
--   부서번호로 오름차순 정렬하시오.
select * from emp;
select * from dept; -- deptno 으로 조인해야됨.

select d.deptno, d.dname, count(e.sal), sum(e.sal), round(avg(e.sal), 0) from emp e
    join dept d on e.deptno = d.deptno
group by d.deptno, d.dname
having sum(sal) > 2000
order by d.deptno desc;