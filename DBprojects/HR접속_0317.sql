-- 2025.03.17 월

select * from emp;

-- 함수 반올림 해주는 round 함수
select round(30.257, 1) from dual;

-- round ( , ) => 콤마 뒤 숫자 표시하지 않을 시, default값이 0.
select round(30.257) from dual;
select round(30.557) from dual;

select round(7.123456789), round(7.123456789, 0) from dual;

-- 소수점을 나타내는 개수를 출력해줌
select round(7.123456789, 2), round(7.123456789, 5) from dual;

select round(77777.123456789, -2) from dual;

select trunc(7.123456789), trunc(7.123456789, 0) from dual;
select trunc(7.123456789, 2), trunc(7.123456789, 5) from dual;

select trunc(77777.123456789, -2) from dual;

-- 소수점 이하는 다 잘라내는 역할 => floor 함수 (양수에서는 소수점 잘라냄, 음수에서는 작거나 같은 수를 출력)
-- FLOOR 함수는 소수점 첫째 자리에서 버림하는 함수로, 주어진 숫자와 가장 근접한 작은 정수를 출력한다. 
select floor(7.12345), floor(-7.12345), floor(7), floor(0.12345) from dual;

-- 나머지 구하는 함수
select mod(7, 0), mod(7, 2), mod(7, -2) from dual;

-- 제곱 구하는 함수
select power(7, 0), power(7, 1) from dual;
select power(7, 2.1) from dual;
select power(-7, 2.1) from dual; -- 음수는 수행범위 벗어난 오류로 실행 x

-- 절대값 구하는 함수
select abs(-7) 음수, abs(7) 양수 from dual;

-- 문자함수
-- 대소문자 변환 함수
select upper('Hello ORACLE'), lower('HELLO Oracle') from dual;

-- 문자열의 일부만 추출해주는 함수
SELECT SUBSTR('Oracle Database Express Edition', 8, 8) FROM dual; -- 8번째부터 8글자 출력
SELECT SUBSTR('오라클 데이터베이스 익스프레스 에디션', 5, 6) FROM dual; -- 5번째부터 6글자 출력

SELECT SUBSTRB('Oracle Database Express Edition', 8, 8) FROM dual; -- SUBSTRB = byte 단위로 구하는 함수
SELECT SUBSTRB('오라클 데이터베이스 익스프레스 에디션', 5, 6) FROM dual;

-- 참고자료
select * from nls_database_parameters;

-- 일부만 다른 문자로 대체하는 함수
SELECT REPLACE('Oralce is difficult', 'difficult', 'easy') FROM dual;
SELECT position, REPLACE(position, '전임', '시간') FROM professor;

select * from professor;

-- 끝에 있는 문자열을 제거하는 함수
select position, ltrim(position, '전임') from professor;
select dname, rtrim(dname, '부') from dept;

-- 양 끝(앞, 뒤)에 있는 문자열을 제거하는 함수
SELECT '"   Hello Oracle   "', TRIM(BOTH FROM '   Hello Oracle   ') 
FROM dual; -- 공백 삭제
SELECT 'AABBCCDDAA', TRIM('A' FROM 'AABBCCDDAA') FROM dual; -- 'A' 문자 삭제

-- 문자열을 연결하여 반환하는 함수
select concat('Oracle', 'Database') from dual;

-- 문자열 길이 반환 함수
select id, length(id) "char", lengthb(id) "byte" from professor;

select job, length(job) "char", lengthb(job) "byte" from emp;
select length('홍길도 a#1') "char", lengthb('홍길도 a#1') "byte" from dual;

-- 날짜함수
-- 현재 시간을 반환하는 함수
select sysdate, current_date from dual;

SELECT SYSTIMESTAMP(0), CURRENT_TIMESTAMP(9) FROM dual;

SELECT ROUND(SYSDATE, 'CC') CENTURY, 
      ROUND(systimestamp, 'YYYY') YEAR,
      ROUND(SYSDATE, 'Q') QUARTER,
      ROUND(SYSDATE, 'MONTH') MONTH,
      ROUND(SYSDATE, 'DAY') WEEK,
      ROUND(SYSDATE, 'DD') DAY,
      ROUND(SYSDATE, 'HH24') H,
      ROUND(SYSDATE, 'MI') M
 FROM dual;

SELECT ROUND(systimestamp, 'CC') CENTURY, 
      ROUND(systimestamp, 'YYYY') YEAR,
      ROUND(systimestamp, 'Q') QUARTER,
      ROUND(systimestamp, 'MONTH') MONTH,
      ROUND(systimestamp, 'DAY') WEEK,
      ROUND(systimestamp, 'DD') DAY,
      ROUND(systimestamp, 'HH24') H,
      ROUND(systimestamp, 'MI') M
 FROM dual;

select * from nls_database_parameters;
alter session set time_zone = '0:0';
alter session set nls_date_format='YYYY-MM--DD HH24:MI:SS';

-- 두 날짜 사이의 개월 수 계산해주는 함수
select sysdate today, hiredate 입사일,
    round(months_between(sysdate, hiredate)) months from emp;

-- 날짜에 개월 수를 더하는 함수
select sysdate today, add_months(sysdate, 12) from dual;
select sysdate today, add_months(sysdate, -3) from dual;

-- 지정한 요일에 가장 가까운 날짜
select sysdate today, next_day(sysdate, 2) "다음 월요일" from dual;
select sysdate today, next_day(sysdate, '월') "다음 월요일" from dual;

-- 변환함수
-- 문자형 데이터로 변환해 주는 함수
select sysdate, to_char(sysdate) from dual;

select sysdate, to_char(sysdate, 'yyyy/mm/dd hh24:mi:ss dy') from dual;

select hiredate, to_char(hiredate, 'yyyy"년" mm"월" dd"일" hh24"시" mi"분" ss"초("day")"')
from emp;

-- 숫자 -> 문자데이터로 변환
select 12345678, to_char(12345678, 'L99,999,999') from dual;
select 12345.678, to_char(12345.678, '$999,999,999') from dual;

-- 날짜형 데이터로 변환해주는 함수
select to_timestamp('2015-09-09 13:05:37', 'yyyy-mm-dd hh24:mi:ss') from dual;

select * from emp
where hiredate > to_date(20070330);

select * from emp
where hiredate > to_date('20070330');

select * from emp
where hiredate > '2007-03-30';

select * from emp
where hiredate > to_date('2007-03-30', 'yyyy-mm-dd');

-- 숫자형 데이터로 변환해주는 함수
select '5700' + '3000' from dual;
select '$5,700' + '$3,000' from dual;

select to_number('$5,700', '$999,000')
    + to_number('$3,000', '$999,000') from dual;

-- null을 다른 값으로 변환하는 함수
-- NVL(exp1, exp2)
select empno, ename, job, sal, sal+NVL(comm, 0) "급여 합계" from emp
where sal+NVL(comm, 0) >= 400;

-- NVL2(exp1, exp2, exp3)
select empno, ename, job, sal, NVL2(comm, sal + comm, sal) "급여 합계" from emp
where sal+NVL(comm, 0) >= 400;

-- 조건 함수
select name, pay, deptno, decode(deptno,
                                101, '컴퓨터 공학과',
                                102, '멀티미디어 공학과',
                                103, '소프트웨어 공학과',
                                201, '전자공학과',
                                202, '기계공학과',
                                203, '화학공학과',
                                301, '문헝정보학과') 학과
from professor;

-- 사원 테이블에서 15년 근속자와 20년 근속자 조회
select * from emp;

select empno, ename, job, hiredate 입사일, 
decode(round((sysdate - hiredate) / 365),
                15, '15년 근속',
                20, '20년 근속',
                '-')
근속여부 from emp;

-- 기본형 case 함수 => 단순 비교 구할 때 사용
-- case 비교대상 when 비교값1 then 결과값1
--              when 비교값1 then 결과값1
--              when 비교값1 then 결과값1
--              when 비교값1 then 결과값1
--                        ...
--              else 기본 결과값
-- end

-- 검색형 case 함수 => 더 복잡한 식 구현할 때 사용
-- case when 조건1 then 결과1
--      when 조건1 then 결과2
--              ....
--      else 기본 결과값
-- end

select empno, ename, decode(gender, 'F', '여성', 'M', '남성') decode_gener,
                case gender when 'F' then '여성'
                            when 'M' then '남성'
                else ''
                end case_gender 
from emp;


-- 사원의 연령대 10대, 20대, 30대....
SELECT empno 사번, ename 이름, job 직급, birthday 생년월일,
        CASE WHEN ROUND((SYSDATE - birthday) / 365) >= 20
                AND ROUND((SYSDATE - birthday) / 365) <= 29
                THEN '20대'
            WHEN ROUND((SYSDATE - birthday) / 365) >= 30
                AND ROUND((SYSDATE - birthday) / 365) <= 39
                THEN '30대'
            WHEN ROUND((SYSDATE - birthday) / 365) >= 40
                AND ROUND((SYSDATE - birthday) / 365) <= 49
                THEN '40대'
            WHEN ROUND((SYSDATE - birthday) / 365) >= 50
                AND ROUND((SYSDATE - birthday) / 365) <= 59
                THEN '50대'
            ELSE '기타'
        END 연령대      
FROM emp
ORDER BY 생년월일 DESC;

-- between 사용
SELECT empno 사번, ename 이름, job 직급, birthday 생년월일,
  CASE WHEN ROUND((SYSDATE - birthday) / 365) BETWEEN 20 AND 29
        THEN '20대'
      WHEN ROUND((SYSDATE - birthday) / 365) BETWEEN 30 AND 39
        THEN '30대'
      WHEN ROUND((SYSDATE - birthday) / 365) BETWEEN 40 AND 49        
        THEN '40대'
      WHEN ROUND((SYSDATE - birthday) / 365) BETWEEN 50 AND 59        
        THEN '50대'
      ELSE '기타'
  END 연령대      
FROM emp
ORDER BY 생년월일;

-- decode 함수 버전
select birthday, round((sysdate - birthday) / 365) 나이 from emp;

select ename, job, birthday,
        decode(trunc(round((sysdate - birthday) / 365) / 10),
        2, '20대',
        3, '30대',
        4, '40대',
        5, '50대',
        6, '60대',
        '기타') 연령대
    from emp
order by birthday desc;

select * from emp
order by decode(job,
        '사원', 1,
        '대리', 2,
        '과장', 3,
        '차장', 4,
        '부장', 5,
        '사장', 6,
        '기타');
        
-- 그룹 함수
select * from emp;

select count(gender) || '명' 인원수,
        to_char(sum(sal), 'L999,999') || '만원' "급여 합계" from emp; -- 문자열 연결함수 : ||
        
-- 회사의 직급 수 조회
select distinct job from emp;

select count(DISTINCT job) from emp;

select max(sal) 최고급여, min(sal) 최저급여 from emp;

select * from emp;

select sum(comm), count(comm), round(avg(comm), 2) from emp;

-- 그룹을 묶는 명령 GROUP BY 절
select deptno, sum(sal) 급여합계, avg(sal) 급여평균, count(sal) 인원수 from emp
group by deptno
order by deptno;

-- #####################################################################
-- ################################중 요#################################
-- from -> where -> 조건 -> group by -> select -> order by 순으로 식 실행.
-- #####################################################################

-- 영업부의 직급별 급여합계, 평균을 구하시오
select * from dept;

select deptno, job, sum(sal) from emp
where deptno = 30
group by deptno, job
order by decode(job,
        '사원', 1,
        '대리', 2,
        '과장', 3,
        '차장', 4,
        '부장', 5,
        '사장', 6,
        '기타');

-- 남자 직원이 3명 미만인 부서 조회
select deptno 부서번호, count(gender) "남자 직원수" from emp
where gender = 'M'
group by deptno
having count(gender) < 3;

-- 사장을 제외한 직급별 급여합계가 1500이 넘는 직급 조회
-- 직급, 인원, 급여합계를 출력하고 직급순으로 정렬
select job 직책, count(*) 인원, sum(sal) 합계 from emp
where job != '사장'
group by job
having sum(sal) >= 1500
order by decode(job,
        '사원', 1,
        '대리', 2,
        '과장', 3,
        '차장', 4,
        '부장', 5,
        '사장');
        
-- 조인(join)
select * from emp;
select * from dept;

select * from employees;
select * from departments;

-- 내부조인, 동등조인(Equi join)
select * from emp, dept
where emp.deptno = dept.deptno;

-- 표준 내부조인
select * from emp inner join dept
    on emp.deptno = dept.deptno;

