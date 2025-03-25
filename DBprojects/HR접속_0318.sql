-- 2025.03.18

-- 표준 내부조인
select * from emp inner join dept
    on emp.deptno = dept.deptno;
    
-- 두 개 조인
select e.employee_id, e.first_name, e.salary, e.hire_date, d.department_id, d.department_name
    from employees e, departments d
where e.department_id = d.department_id;

-- 세개 연결
select * from jobs;

select e.*, d.*, j.*;

select * from jobs
where e.department_id = d.department_id
    and e.job_id = j.job_id;
    
select * from employees;
select * from departments;
select * from jobs;    
select * from countries;
select * from locations;

-- 네개 연결
select e.employee_id, e.first_name, e.salary,
        d.department_name, j.job_title, l.city
from employees e, departments d, jobs j, locations l
where e.department_id = d.department_id
    and e.job_id = j.job_id
    and d.location_id = l.location_id
    and salary >= 9000
order by e.salary desc;

-- 부서별 급여 합계 (having 절로 금액별 나뉘기)
select d.department_name, avg(e.salary) sal_avg, sum(e.salary) sal_sum
from employees e, departments d, jobs j, locations l
where e.department_id = d.department_id
    and e.JOB_ID = j.JOB_ID
    and d.location_id = l.location_id
    and salary >= 9000
group by d.department_name
having avg(e.salary) > 15000
order by e.salary desc;

SELECT d.department_name, 
       AVG(e.salary) AS sal_avg, 
       SUM(e.salary) AS sal_sum
FROM employees e
JOIN departments d ON e.department_id = d.department_id
JOIN jobs j ON e.JOB_ID = j.JOB_ID
JOIN locations l ON d.location_id = l.location_id
WHERE e.salary >= 9000
GROUP BY d.department_name
HAVING AVG(e.salary) > 15000
ORDER BY sal_avg DESC;

-- 비 동등 조인
select gs.gname 고객명, gs.point 마일리지, gf.gname 사은품
from guest gs, gift gf
where gs.point >= gf.g_start and gs.point <= gf.g_end;

-- 셀프조인
select * from emp;

-- 외부조인(outer join)
select e.empno, e.ename, e.mgr, m.empno, m.ename
from emp e, emp m
where e.mgr = m.empno;

select e.empno, e.ename, e.mgr, m.empno, m.ename
from emp e, emp m
where e.mgr = m.empno(+);

select e.empno, e.ename, e.mgr, m.empno, m.ename
from emp e left outer join emp m
    on e.mgr = m.empno(+);
--where e.mgr = m.empno(+);

select count(*) from emp; -- 인원 조회

select e.employee_id, e.first_name,
    e.department_id, d.department_name
from employees e, departments d, locations l
where e.department_id = d.department_id(+)
    and d.location_id = l.location_id;
    
-- 안시조인(Ansi join)
select e.*, d.*
from emp e inner join dept d
    on e.deptno = d.deptno
where sal > 500;
-- where e.deptno = d.deptno;

-- ########################################################################################################
-- ################################################ 중 요 #################################################
-- 서브 쿼리(Sub Query) - 메인 쿼리보다 먼저 실행이 되고, 최종적으로 메인 쿼리가 실행이 될 때, 정보를 메인쿼리로 넘겨줌.
-- ########################################################################################################

-- 사원 테이블에서 평균 급여보다 이상 급여를 받는 사원
-- 사번, 이름 급여정보를 조회
select empno, ename, sal from emp
where sal >= (select avg(sal) avg_sal from emp); -- sub query라는 의미가 select 중복 사용한다는 뜻

-- 단일행 서브쿼리
select empno, ename, sal, d.dname from emp e, dept d
where e.deptno = d.deptno
    and sal >= (select min(sal) avg_sal from emp);

-- 다중행 서브쿼리, 다중열 서브쿼리
-- 530만원 이상 급여를 받는 직원과 같은 부서에 근무하는 사원
select ename, hiredate, sal, deptno from emp
where deptno in(select deptno from emp where sal >= 520);

select * from dept
where loc = '서울';

select * from dept;

-- 긍정
select * from dept
where loc in(select loc from dept where loc = '서울');

select * from dept
where loc < any(select loc from dept where loc = '서울'); -- any 함수는 부등호 사용 가능.

-- 부정
select * from dept
where loc not in(select loc from dept where loc = '서울');

select * from dept
where loc <> any(select loc from dept where loc = '서울');

-- 20번 부서번호 중에서 급여를 많이 받는 사람 출력
select ename, sal from emp
where sal > any(select sal from emp 
                where deptno = 20);

select ename, sal from emp
where sal > (select min(sal) from emp 
             where deptno = 20);

-- 40번 부서 직원의 급여보다 많이 받는 사람
select ename, sal from emp
where sal > all(select sal from emp 
                where deptno = 20);

select ename, sal from emp
where sal > (select max(sal) from emp 
             where deptno = 20);
                
-- 10번, 40번 부서의 직원 정보 출력
select e.ename, e.sal, d.dname from emp e, dept d
where e.deptno = d.deptno
    and e.deptno = any(10, 40);
    
-- 연관성 있는 서브쿼리 => 메인 - 서브 관계 - 조인
-- 자신이 속한 부서의 급여 평균이상 받는 사원
-- 자식이 속한
select e.ename, e.sal, d.dname, 
    round((select avg(sal) from emp se where se.deptno = e.deptno), 2) 평균급여
from emp e, dept d
where e.deptno = d.deptno
    and e.sal >= (select avg(sal) from emp we
                 where we.deptno = e.deptno);

-- 부서명을 포함한 조회
select e.*, d.dname from emp e, dept d
where e.deptno = d.deptno;

select e.*, (select d.dname from dept d where d.deptno = e.deptno)
from emp e;

-- 인라인뷰 (Inline View)
-- From 절에 위치한 서브 쿼리를 인라인뷰라고 함.
-- 사번, 이름, 급여 부서명 최저급여 평균급여
select empno, ename, sal, d.dname 
from emp e, dept d, 
    (select min(sal) min_sal, avg(sal) avg_sal from emp) es
where e.deptno = d.deptno
    and e.sal between es.min_sal and es.avg_sal;




