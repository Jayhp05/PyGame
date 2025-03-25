drop table emp2 cascade constraints;

CREATE TABLE EMP2 (
 EMPNO       NUMBER  PRIMARY KEY,
 NAME        VARCHAR2(10) NOT NULL,
 BIRTHDAY    DATE,
 DEPTNO      VARCHAR2(6) NOT NULL,
 EMP_TYPE    VARCHAR2(8 CHAR),
 TEL         VARCHAR2(15),
 HOBBY       VARCHAR2(30),
 PAY         NUMBER,
 POSITION    VARCHAR2(8 CHAR),
 PEMPNO      NUMBER
);

INSERT INTO EMP2 VALUES (19900101,'나사장',TO_DATE('19640125','YYYYMMDD'),'0001','정규직','054)223-0001','음악감상',100000000,'대표이사',null);
INSERT INTO EMP2 VALUES (19960101,'전부장',TO_DATE('19730322','YYYYMMDD'),'1000','정규직','02)6255-8000','독서',72000000,'부장',19900101);
INSERT INTO EMP2 VALUES (19970201,'최일도',TO_DATE('19750415','YYYYMMDD'),'1000','정규직','02)6255-8005','운동',50000000,'과장',19960101);
INSERT INTO EMP2 VALUES (19930331,'백원만',TO_DATE('19760525','YYYYMMDD'),'1001','정규직','02)6255-8010','자전거타기',60000000,'차장',19960101);
INSERT INTO EMP2 VALUES (19950303,'천만득',TO_DATE('19730615','YYYYMMDD'),'1002','정규직','02)6255-8020','마라톤',56000000,'과장',19960101);
INSERT INTO EMP2 VALUES (19966102,'일지매',TO_DATE('19720705','YYYYMMDD'),'1003','정규직','052)223-4000','음악감상',75000000,'부장',19900101);
INSERT INTO EMP2 VALUES (19930402,'유관순',TO_DATE('19720815','YYYYMMDD'),'1004','정규직','042)998-7005','등산',51000000,'과장',19966102);
INSERT INTO EMP2 VALUES (19960303,'김문호',TO_DATE('19710925','YYYYMMDD'),'1005','정규직','031)564-3340','등산',35000000,'대리',19966102);
INSERT INTO EMP2 VALUES (19970112,'노정호',TO_DATE('19761105','YYYYMMDD'),'1006','정규직','054)223-4500','수영',68000000,'부장',19900101);
INSERT INTO EMP2 VALUES (19960212,'이윤나',TO_DATE('19721215','YYYYMMDD'),'1007','정규직','054)223-4600',null,49000000,'과장',19970112);
INSERT INTO EMP2 VALUES (20000101,'이태백',TO_DATE('19850125','YYYYMMDD'),'1008','계약직','051)123-4567','등산', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000102,'김설악',TO_DATE('19830322','YYYYMMDD'),'1009','계약직','031)234-5678','낚시', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000203,'최오대',TO_DATE('19820415','YYYYMMDD'),'1010','계약직','02)2345-6789','바둑', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000334,'박지리',TO_DATE('19810525','YYYYMMDD'),'1011','계약직','053)456-7890','노래', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000305,'정북악',TO_DATE('19800615','YYYYMMDD'),'1008','수습직','051)567-8901','독서', 22000000,'',19960212);
INSERT INTO EMP2 VALUES (20006106,'유도봉',TO_DATE('19800705','YYYYMMDD'),'1009','수습직','031)678-9012','술',   22000000,'',19960212);
INSERT INTO EMP2 VALUES (20000407,'윤주왕',TO_DATE('19800815','YYYYMMDD'),'1010','수습직','02)2789-0123','오락', 22000000,'',19960212);
INSERT INTO EMP2 VALUES (20000308,'강월악',TO_DATE('19800925','YYYYMMDD'),'1011','인턴직','053)890-1234','골프', 20000000,'',19960212);
INSERT INTO EMP2 VALUES (20000119,'장금강',TO_DATE('19801105','YYYYMMDD'),'1004','인턴직','042)901-2345','술',   20000000,'',19930402);
INSERT INTO EMP2 VALUES (20000210,'나한라',TO_DATE('19801215','YYYYMMDD'),'1005','인턴직','031)345-3456','독서', 20000000,'',19960303);
COMMIT;

drop table dept2 cascade constraint;

CREATE TABLE DEPT2 (
 DCODE   VARCHAR2(6)  PRIMARY KEY,
 DNAME   VARCHAR2(20) NOT NULL,
 PDEPT VARCHAR2(06) ,
 AREA        VARCHAR2(16)
);

INSERT INTO DEPT2 VALUES ('0001','사장실','','포항본사');
INSERT INTO DEPT2 VALUES ('1000','경영지원부','0001','서울지사');
INSERT INTO DEPT2 VALUES ('1001','재무관리팀','1000','서울지사');
INSERT INTO DEPT2 VALUES ('1002','총무팀','1000','서울지사');
INSERT INTO DEPT2 VALUES ('1003','기술부','0001','포항본사');
INSERT INTO DEPT2 VALUES ('1004','H/W지원','1003','대전지사');
INSERT INTO DEPT2 VALUES ('1005','S/W지원','1003','경기지사');
INSERT INTO DEPT2 VALUES ('1006','영업부','0001','포항본사');
INSERT INTO DEPT2 VALUES ('1007','영업기획팀','1006','포항본사');
INSERT INTO DEPT2 VALUES ('1008','영업1팀','1007','부산지사');
INSERT INTO DEPT2 VALUES ('1009','영업2팀','1007','경기지사');
INSERT INTO DEPT2 VALUES ('1010','영업3팀','1007','서울지사');
INSERT INTO DEPT2 VALUES ('1011','영업4팀','1007','울산지사');

commit;


DROP TABLE gift purge ;

create table gift
( gno  number ,
  gname varchar2(15 CHAR) ,
  g_start  number ,
  g_end  number );

insert into gift values(1,'참치세트',1,100000);
insert into gift values(2,'샴푸세트',100001,200000);
insert into gift values(3,'세차용품세트',200001,300000);
insert into gift values(4,'주방용품세트',300001,400000);
insert into gift values(5,'산악용자전거',400001,500000);
insert into gift values(6,'LCD모니터',500001,600000);
insert into gift values(7,'노트북',600001,700000);
insert into gift values(8,'벽걸이TV',700001,800000);
insert into gift values(9,'드럼세탁기',800001,900000);
insert into gift values(10,'양쪽문냉장고',900001,1000000);
commit ;

DROP TABLE guest purge;

create table guest
(gno  number(8) ,
 gname varchar2(12) ,
 jumin char(13) ,
 point number) ;

insert into guest values (20010001,'서진수','7510231369824',980000);
insert into guest values (20010002,'서재수','7502241128467',73000);
insert into guest values (20010003,'이미경','7506152123648',320000);
insert into guest values (20010004,'김재수','7512251063421',65000);
insert into guest values (20010005,'박동호','7503031639826',180000);
insert into guest values (20010006,'김신영','7601232186327',153000);
insert into guest values (20010007,'신은경','7604212298371',273000);
insert into guest values (20010008,'오나라','7609112118379',315000);
insert into guest values (20010009,'김설희','7601202378641',542000);
insert into guest values (20010010,'임세현','7610122196482',265000);
insert into guest values (20010011,'최순규','7711291186223',110000);
insert into guest values (20010012,'정현영','7704021358674',99000);
insert into guest values (20010013,'안광훈','7709131276431',470000);
insert into guest values (20010014,'모병환','7702261196365',298000);
insert into guest values (20010015,'노정호','7712141254963',420000);
insert into guest values (20010016,'이윤나','7808192157498',598000);
insert into guest values (20010017,'안은수','7801051776346',625000);
insert into guest values (20010018,'인영민','7808091786954',670000);
insert into guest values (20010019,'김지영','7803242114563',770000);
insert into guest values (20010020,'허우','7802232116784',730000);
commit ;

DROP TABLE hakjum purge ;

create table hakjum
(grade char(3) ,
 min_point  number ,
 max_point  number );

insert into hakjum values ('A+',96,100);
insert into hakjum values ('A0',90,95);
insert into hakjum values ('B+',86,89);
insert into hakjum values ('B0',80,85);
insert into hakjum values ('C+',76,79);
insert into hakjum values ('C0',70,75);
insert into hakjum values ('D',0,69);

commit;


drop table exam_01 purge ;

create table exam_01
(studno  number ,
 total number);

insert into exam_01 values (9411,97);
insert into exam_01 values (9412,78);
insert into exam_01 values (9413,83);
insert into exam_01 values (9414,62);
insert into exam_01 values (9415,88);
insert into exam_01 values (9511,92);
insert into exam_01 values (9512,87);
insert into exam_01 values (9513,81);
insert into exam_01 values (9514,79);
insert into exam_01 values (9515,95);
insert into exam_01 values (9611,89);
insert into exam_01 values (9612,77);
insert into exam_01 values (9613,86);
insert into exam_01 values (9614,82);
insert into exam_01 values (9615,87);
insert into exam_01 values (9711,91);
insert into exam_01 values (9712,88);
insert into exam_01 values (9713,82);
insert into exam_01 values (9714,83);
insert into exam_01 values (9715,84);

commit ;

drop table p_grade purge ;

create table p_grade
( position  varchar2(10) ,
  s_age number ,
  e_age number ,
  s_year number ,
  e_year number ,
  s_pay  number ,
  e_pay  number );

insert into p_grade values ('주임',0,24,1,2,12000000,29990000);
insert into p_grade values ('대리',25,28,3,5,30000000,45000000);
insert into p_grade values ('과장',29,32,6,8,45010000,51000000);
insert into p_grade values ('차장',33,36,9,10,51010000,60000000);
insert into p_grade values ('부장',37,40,11,13,60010000,75000000);
insert into p_grade values ('이사',41,55,14,99,75010000,100000000);

commit ;