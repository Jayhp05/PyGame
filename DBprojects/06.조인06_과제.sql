-- #####################################################################
-- ### 조인06_과제
-- #####################################################################



-- 1. emp, dept 테이블에서 부서 번호가 30인 직원의 사번, 이름, 직급, 부서번호, 
-- 부서 위치를 출력 하시오
select * from emp;
select * from dept;

select e.empno 사번, e.ename 이름, e.job 직급, e.deptno 부서번호, d.loc 위치 from emp e, dept d
where e.deptno = d.deptno;


-- 2. emp, dept 테이블에서 서울에서 근무하는 직원의 이름, 직급, 부서번호, 
-- 부서 이름을 출력 하시오
select e.ename 이름, e.job 직급, e.deptno 부서번호, d.dname 부서이름 from emp e, dept d
where e.deptno = d.deptno and loc = '서울';


-- 3. emp, dept 테이블에서 성이 김씨인 직원의 사번, 이름, 직급, 급여, 
-- 부서명을 출력 하시오
select * from emp;

select e.empno 사번, e.ename 이름, e.job 직급, e.sal 급여, d.dname 부서명 from emp e, dept d
where e.deptno = d.deptno and ename like '김%';


-- 4. 학생 테이블(STUDENT)과 교수 테이블(PROFESSOR)을 조인하여 학생의 이름과
-- 지도교수 번호(PROFNO), 지도교수 이름을 출력 하시오
select * from student;
select * from professor;

select s.name 학생이름, p.profno 지도교수번호, p.name 지도교수이름 from student s, professor p
where s.profno = p.profno;


-- 5. 학생 테이블(STUDENT)과 학과 테이블(DEPARTMENT), 
-- 교수 테이블(PROFESSOR)을 조인하여 학생의 이름과 학과명 지도교수를 출력 하시오
select * from department;

select s.name 학생이름, d.dname 학과명, p.name 지도교수이름 from student s, professor p, department d
where s.profno = p.profno and s.deptno1 = d.deptno;


-- 6. STUDENT, EXAM_01, HAKJUM 테이블에서 학생들의 이름과 점수 
-- 그리고 학점을 출력 하시오
select * from student;
select * from exam_01;
select * from hakjum;

select s.name 학생이름, e.total 점수, h.grade 학점 from student s, exam_01 e, hakjum h
where s.studno = e.studno and e.total
        BETWEEN h.min_point AND h.max_point;


-- 7. 위의 예제에서 학과명을 추가하고 학점이 제일 높은 학생부터 출력되게 하시오.
select d.dname , s.name, e.total, h.grade from student s, exam_01 e, hakjum h, department d
where s.studno = e.studno and s.deptno1 = d.deptno 
    and e.total BETWEEN h.min_point AND h.max_point
order by grade;



-- 8.  GUEST, GIFT 테이블에서 고객의 마일리지 포인트 보다 낮은 포인트의 상품을 직접
-- 선택할 수 있다고 할 때 노트북을 선택할 수 있는 고객명과 마일리지, 사은품을 출력 하시오
-- 단, 마일리지가 제일 많은 고객부터 출력되게 하시오.
select * from guest;
select * from gift;

select g.gname 고객명, g.point 마일리지, gf.gname 사은품 from guest g, gift gf
where g.point > gf.g_end and g.point > 600000 and gf.gname = '노트북'
order by g.point desc;


-- 9. STUDENT, PROFESSOR 테이블에서 학생이름, 지도교수 이름을 출력 하시오.
-- 이때 지도교수가 없는 학생의 명단도 같이 출력되도록 하시오.
select * from student;
select * from professor;

select s.name 학생이름, p.name 지도교수명 from student s
left join professor p ON s.profno = p.profno; -- null 값도 포함하기 위해 outer join 사용



-- 10. PROFESSOR 테이블에서 교수 번호, 이름, 입사일과 자신보다 입사일이 빠른 교수가
-- 몇명인지 출력 하시오. 단, 인원수를 오름차순 정렬하시오.
select * from professor
order by hiredate;

SELECT p.profno 교수번호, p.name 이름, p.hiredate 입사일, 
       (SELECT COUNT(*) FROM professor p2
        WHERE p2.hiredate < p.hiredate) AS EARLIER_COUNT
FROM professor p
ORDER BY EARLIER_COUNT;




