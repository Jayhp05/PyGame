-- 부서 테이블 제거하기 
--DROP TABLE EMP;
-- 사원 테이블 제거하기
--DROP TABLE DEPT;
-- 급여 테이블 제거하기
--DROP TABLE SALGRADE;
-- 부서 테이블 제거하기
--DROP TABLE EMPLOYEE;
-- 사원 테이블 제거하기
--DROP TABLE DEPARTMENT;


-- 부서 테이블 생성하기
CREATE TABLE DEPT(
	 DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY,
	 DNAME VARCHAR2(14),
	 LOC   VARCHAR2(13) ) ;

-- 사원 테이블 생성하기
CREATE TABLE EMP( 
   EMPNO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY,
	 ENAME VARCHAR2(10),
   GENDER VARCHAR(1),
   BIRTHDAY DATE,   
 	 JOB   VARCHAR2(9),
	 MGR  NUMBER(4),
	 HIREDATE DATE,
	 SAL NUMBER(7,2),
	 COMM NUMBER(7,2),   
	 DEPTNO NUMBER(2) CONSTRAINT FK_DEPTNO REFERENCES DEPT);

 -- 급여 테이블 생성하기
CREATE TABLE SALGRADE(
	 GRADE NUMBER,
	 LOSAL NUMBER,
	 HISAL NUMBER );

-- 사원 테이블에 샘플 데이터 추가하기
INSERT INTO DEPT VALUES(10, '경리부', '서울');
INSERT INTO DEPT VALUES(20, '인사부', '인천');
INSERT INTO DEPT VALUES(30, '영업부', '용인'); 
INSERT INTO DEPT VALUES(40, '전산부', '수원');

-- 부서 테이블에 샘플 데이터 추가하기
-- 부서 테이블에 샘플 데이터 추가하기
INSERT INTO EMP VALUES(1001, '김사랑', 'F', '1985-03-25', '사원', 1013, to_date('2007-03-01','yyyy-mm-dd'), 300, NULL, 20);
INSERT INTO EMP VALUES(1002, '한예슬', 'F', '1986-11-05', '대리', 1005, to_date('2007-04-02','yyyy-mm-dd'), 250,   80, 30);
INSERT INTO EMP VALUES(1003, '오지호', 'M', '1979-05-13', '과장', 1005, to_date('2005-02-10','yyyy-mm-dd'), 500,  100, 30);
INSERT INTO EMP VALUES(1004, '이병헌', 'M', '1973-07-11', '부장', 1008, to_date('2003-09-02','yyyy-mm-dd'), 600, NULL, 20);
INSERT INTO EMP VALUES(1005, '신동협', 'M', '1970-01-07', '과장', 1005, to_date('2005-04-07','yyyy-mm-dd'), 450,  200, 30);
INSERT INTO EMP VALUES(1006, '장동건', 'M', '1970-12-19', '부장', 1008, to_date('2003-10-09','yyyy-mm-dd'), 480, NULL, 30);
INSERT INTO EMP VALUES(1007, '이문세', 'M', '1969-08-30', '부장', 1008, to_date('2004-01-08','yyyy-mm-dd'), 520, NULL, 10);
INSERT INTO EMP VALUES(1008, '감우성', 'M', '1972-09-10', '차장', 1003, to_date('2004-03-08','yyyy-mm-dd'), 500,    0, 30);
INSERT INTO EMP VALUES(1009, '안성기', 'M', '1970-09-21', '사장', NULL, to_date('1996-10-04','yyyy-mm-dd'),1000, NULL, 20);
INSERT INTO EMP VALUES(1010, '이병헌', 'M', '1971-05-04', '과장', 1003, to_date('2005-04-07','yyyy-mm-dd'), 500, NULL, 10);
INSERT INTO EMP VALUES(1011, '조향기', 'F', '1986-10-18', '사원', 1007, to_date('2007-03-01','yyyy-mm-dd'), 280, 80, 30);
INSERT INTO EMP VALUES(1012, '강혜정', 'F', '1985-12-31', '사원', 1006, to_date('2007-08-09','yyyy-mm-dd'), 300, NULL, 20);
INSERT INTO EMP VALUES(1013, '박중훈', 'M', '1967-08-08', '부장', 1003, to_date('2002-10-09','yyyy-mm-dd'), 560, NULL, 20);
INSERT INTO EMP VALUES(1014, '조인성', 'M', '1987-08-12', '사원', 1006, to_date('2007-11-09','yyyy-mm-dd'), 250, NULL, 10);
INSERT INTO EMP VALUES(1015, '강감찬', 'M', '1981-02-25', '과장', 1006, to_date('2008-10-21','yyyy-mm-dd'), 510, NULL, 30);
INSERT INTO EMP VALUES(1016, '이순신', 'M', '1989-11-17', '사원', 1003, to_date('2010-03-11','yyyy-mm-dd'), 240, 80, 30);
INSERT INTO EMP VALUES(1017, '홍길동', 'M', '1988-10-03', '사원', 1007, to_date('2009-08-01','yyyy-mm-dd'), 230, NULL, 10);
INSERT INTO EMP VALUES(1018, '임꺽정', 'M', '1985-07-16', '대리', 1006, to_date('2006-09-13','yyyy-mm-dd'), 380, NULL, 10);
INSERT INTO EMP VALUES(1019, '김하나', 'F', '1983-03-21', '과장', 1013, to_date('2007-05-25','yyyy-mm-dd'), 490, 80, 20);
INSERT INTO EMP VALUES(1020, '안성댁', 'F', '1986-09-15', '대리', 1009, to_date('2007-04-17','yyyy-mm-dd'), 350, NULL, 20);
INSERT INTO EMP VALUES(1021, '김사고', 'M', '1989-10-14', '사원', 1006, to_date('2011-12-02','yyyy-mm-dd'), 220, NULL, 10);
INSERT INTO EMP VALUES(1022, '김사연', 'F', '1973-05-09', '차장', 1013, to_date('2006-12-19','yyyy-mm-dd'), 480, NULL, 20);
INSERT INTO EMP VALUES(1023, '안정감', 'F', '1974-01-12', '과장', 1008, to_date('2008-07-22','yyyy-mm-dd'), 380, 100, 30);
INSERT INTO EMP VALUES(1024, '홍인영', 'F', '1970-03-15', '부장', 1009, to_date('2003-10-08','yyyy-mm-dd'), 550, NULL, 40);
INSERT INTO EMP VALUES(1025, '조형기', 'M', '1984-06-27', '대리', 1024, to_date('2010-09-07','yyyy-mm-dd'), 350, 80, 40);


-- 급여 테이블에 샘플 데이터 추가하기
INSERT INTO SALGRADE VALUES (1, 700,1200);
INSERT INTO SALGRADE VALUES (2, 1201,1400);
INSERT INTO SALGRADE VALUES (3, 1401,2000);
INSERT INTO SALGRADE VALUES (4, 2001,3000);
INSERT INTO SALGRADE VALUES (5, 3001,9999);
COMMIT;
