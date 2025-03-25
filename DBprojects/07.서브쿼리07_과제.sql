-- #####################################################################
-- ### 서브쿼리07 과제
-- #####################################################################


-- 01. employees, jobs 테이블에서 평균 급여보다 적게 급여를 받는 직원의
-- 이름, 직급, 급여를 출력 하시오
select * from jobs;
select * from employees;

select e.first_name 이름, j.job_title 직급, e.salary 급여 from employees e, jobs j
where e.job_id = j.job_id and 
                         salary < (select avg(salary) from employees);


-- 02. employees, departments, jobs 테이블을 조인하고
-- 최저 급여 부터 평균 급여를 받는 직원의 이름, 급여, 부서명, 직급을 출력 하시오
select * from departments;
select * from jobs;
select * from employees;

select e.first_name 이름, e.salary 급여, d.department_name 부서명, j.job_title 직급 from employees e, jobs j, departments d
where e.job_id = j.job_id and e.department_id = d.department_id and
                         salary >= (select min(salary) from employees)
                         and salary <= (select avg(salary) from employees);


-- 03. PROFESSOR, DEPARTMENT 테이블에서 바비 교수보다 입사일이 빠른 교수 중에서  
-- 김도형 교수보다 급여가 많은 교수의 이름, 급여, 입사일, 학과명을 출력 하시오
select * from professor;
select * from department;

SELECT p.name 이름, p.pay 급여, p.hiredate 입사일, d.dname 학과명 FROM professor p
        JOIN department d ON p.deptno = d.deptno
WHERE p.hiredate < (SELECT hiredate FROM professor 
                    WHERE name = '바비') AND p.pay > (SELECT pay FROM professor 
                                                      WHERE name = '김도형');



-- 04. EMP, DEPT 테이블에서 감우성 차장에게 보고하는 직원들의 사번, 이름, 직급, 
-- 급여, 입사일, 부서명 출력, 단 가장 오래 근무한 직원부터 출력되게 하시오.
select * from emp;
select * from dept;

SELECT e.empno 사번, e.ename 이름, e.job 직급, e.sal 급여, e.hiredate 입사일, d.dname 부서명 FROM emp e
        JOIN dept d ON e.deptno = d.deptno
WHERE e.mgr = (SELECT empno FROM emp 
                      WHERE ename = '감우성' AND job = '차장')
ORDER BY e.hiredate;



-- 05. EMP2, DEPT2 테이블에서 과장 직급의 최소급여보다 같거나 적게 받는 직원의 이름, 
-- 급여, 직급과 부서명을 출력 하시오 
-- 단, 숫자는 3자리마다 콤마로 표시하고 급여를 적게 받는 직원부터 출력하시오.
select * from emp2;
select * from dept2;

SELECT e.name 이름, TO_CHAR(e.pay, 'L999,999,999') 급여, e.position 직급, d.dname 부서명 FROM emp2 e
    JOIN dept2 d ON e.deptno = d.dcode
WHERE e.pay <= (SELECT MIN(pay) FROM emp2 
                WHERE position = '과장')
ORDER BY e.pay; -- 다시



-- 06. PROFESSOR, DEPARTMENT 테이블에서 학과별로 입사일이 가장 빠른 교수의 학과명, 
-- 이름, 입사일, 급여를 출력 하시오. 단, 학과번호로 오름차순 정렬하여 출력 하시오
select * from professor;
select * from department;

SELECT d.dname 학과명, p.name 이름, p.hiredate 입사일, p.pay 급여 FROM professor p
    JOIN department d ON p.deptno = d.deptno
WHERE p.hiredate = (SELECT MIN(p2.hiredate) FROM professor p2 
                     WHERE p2.deptno = p.deptno)
ORDER BY p.deptno;



-- 07. emp, dept 테이블에서 자신의 직급 평균 급여보다 급여가 적은 직원의 이름, 
-- 부서명, 직급, 급여를 출력하시오.
select * from emp;
select * from dept;

SELECT e.ename, d.dname, e.job, e.sal FROM emp e
    JOIN dept d ON e.deptno = d.deptno
WHERE e.sal < (SELECT AVG(e2.sal) FROM emp e2 
                  WHERE e2.job = e.job);



-- 08. PROFESSOR, DEPARTMENT 테이블에서 평균 급여보다 급여가 많은 교수의 이름, 급여, 
-- 부서명을 출력 하시오 단, 부서명은 조인이 아닌 스칼라 서브 쿼리를 이용해 조회하고
-- 급여가 많은 교수부터 출력하시오.
select * from professor;
select * from department;

SELECT p.name, p.pay, 
    (SELECT d.dname FROM department d 
     WHERE d.deptno = p.deptno)
FROM professor p
WHERE p.pay > (SELECT AVG(pay) FROM professor)
ORDER BY p.pay DESC;



-- 09. STUDENT, DEPARTMENT 테이블에서 학과번호, 학과명, 학과 별 최저 몸무게, 
-- 평균 몸무게, 최고 몸무게를 출력 하시오
select * from student;
select * from department;

SELECT s.deptno1, d.dname, MIN(s.weight), AVG(s.weight), MAX(s.weight) FROM student s
        JOIN department d ON s.deptno1 = d.deptno
GROUP BY s.deptno1, d.dname; -- 학과별로 몸무게 계산하려면 동일한 조건으로 그룹을 묶어야 출력 가능



-- 10. STUDENT, DEPARTMENT 테이블에서 학생의 학번, 이름, 나이, 학과명을 출력하시오.
-- 단, 나이순으로 오름차순 정렬하고 한 페이지에 5명씩 출력되게 하여 2 페이지에 해당하는
-- 데이터를 출력하시오.
select * from student;
select * from department;

select * from
            (SELECT rownum num, s.studno, s.name, s.birthday, d.dname FROM student s
                    JOIN department d ON s.deptno1 = d.deptno
             ORDER BY s.birthday) sub
where num >= 6 and num <= 10;

-- 풀이
select * from
    (select rownum no, sd.* from 
        (select rownum, s.studno 학번, s.name 이름, round((sysdate - s.birthday) / 365) 나이 
            from student s, department d
            where s.deptno1 = d.deptno
            order by 나이) sd)
where no between 6 and 10;


-- 11. orders, customers 테이블에서 년도별 고객의 주문금액 주문년도, 고객아이디, 
-- 고객이름을 출력하시오.
-- 단, 년도로 오른차순, 주문금액으로 내림차순 정렬하고 한 페이지에 10명씩 출력되게 하여 
-- 3페이지에 해당하는 페이지를 출력하시오.
select * from orders;
select * from customers;

select * from (SELECT rownum num, o.order_date, c.customer_id, c.customer_name, o.order_amount from orders o
                    join customers c on o.customer_id = c.customer_id
                order by o.order_date, o.order_amount desc) sub
where num >= 31 and num <= 40;

-- 풀이
select * from
    (select rownum num, sub.* from
        (select to_char(o.order_date, 'YYYY') order_year,
                o.customer_id, c.customer_name, sum(o.order_amount) sum
        from orders o, customers c
        where o.customer_id = c.customer_id
        group by to_char(o.order_date, 'YYYY'), o.customer_id, c.customer_name
        order by order_year asc, sum desc)sub)
where num between 21 and 30;