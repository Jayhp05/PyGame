-- #####################################################################
-- ### 테이블 만들기 및 제약조건_과제
-- #####################################################################


-- 1. 고객 테이블 : customer -> 회원아이디, 이름, 이메일, 주소를 갖는 테이블을
-- 생성하고 고객 정보 5개 이상을 추가하시오. 단, 아웃라인 방식으로 한 행을 유일하게
-- 구분할 후보키를 선정하여 PRIMARY KEY를 지정하시오.
create table customer(
    customer_id VARCHAR2(15) not null,
    name VARCHAR2(5 CHAR) not null,
    email VARCHAR2(20) not null,
    adress VARCHAR2(100),
    constraint customer_pk primary key(customer_id)
);

insert into customer values('abc', '홍길동', 'asdf@naver.com', '서울시 강남');
insert into customer values('abc2', '철수', 'asdf2@gmail.com', '서울시 서초');
insert into customer values('abc3', '영희', 'asdasd@naver.com', '서울시 성동');
insert into customer values('abc4', '짱구', 'weqx@daum.net', '서울시 종로');
insert into customer values('abc5', '흰둥이', 'czdas@naver.com', '서울시 중랑');

select * from customer;

-- 2. 상품테이블 : product -> 상품코드, 상품명, 가격, 제조사를 갖는 테이블을 
-- 생성하고 상품정보 10개 이상을 추가하시오. 단, 인라인 방식으로 한 행을 유일하게 
-- 구분할 후보키를 선정하여 PRIMARY KEY를 지정하시오.
create table product(
    product_SN VARCHAR2(15 char) not null constraint product_pk primary key,   -- serial number
    product_name VARCHAR2(5 CHAR) not null,
    price number(20) not null,
    manufacture VARCHAR2(100)
);

INSERT INTO product VALUES('SDSczxcw1Wc', '냉장고', 700000, '삼성');
INSERT INTO product VALUES('zxcz1d3312', '세탁기', 1000000, 'LG');
INSERT INTO product VALUES('xcawe123', '드라이기', 50000, '다이슨');
INSERT INTO product VALUES('xzceg34', '모니터', 100000, '한성컴퓨터');
INSERT INTO product VALUES('sa43dfas', '모니터', 200000, '삼성');
INSERT INTO product VALUES('AADc31', '초코과자', 1000, '롯데');
INSERT INTO product VALUES('EDVCE43', '휴대폰', 1000000, '애플');
INSERT INTO product VALUES('dsESds21', '자동차', 30000000, '삼성');
INSERT INTO product VALUES('fqDWge675', '냉장고', 5000000, 'LG');
INSERT INTO product VALUES('dwf23D3', '청소기', 500000, '다이슨');

select * from product;


-- 3. 주문테이블 : order_table -> 주문번호, 회원아이디, 상품코드, 주문일자를 갖는 
-- 테이블을 생성하고 주문정보 5개 이상 추가하시오. 단, 아웃라인 방식으로 한 행을 
-- 유일하게 구분할 후보키를 선정하여 PRIMARY KEY를 지정하시오. 또한 이 테이블은 
-- 주문한 회원의 아이디와 회원에게 주문된 상품 코드를 참조하고 있으므로 customer 
-- 테이블과 product 테이블을 참조하는 참조 무결성(외래키) 제약조건을 적용하여야 합니다.
create table order_table(
    orderNum number(15) not null,
    customer_id VARCHAR2(15) not null,
    product_SN VARCHAR2(15 char) not null,
    order_date date,
    constraint order_table_pk primary key(orderNum),
    constraint order_table_fk_01 foreign key(customer_id) REFERENCES customer(customer_id),
    constraint order_table_fk_02 foreign key(product_SN) REFERENCES product(product_SN)
);

insert into order_table values(10031232, 'abc', 'SDSczxcw1Wc', '2023-01-23');
insert into order_table values(10132312, 'abc2', 'xzceg34', sysdate);
insert into order_table values(10223213, 'abc3', 'AADc31', '2025-03-18');
insert into order_table values(10312321, 'abc4', 'AADc31', '2024-08-27');
insert into order_table values(10451232, 'abc5', 'sa43dfas', sysdate);

select * from order_table;


--update order_table
--    set (customer_id) = (select customer_id from customer
--                          where customer_id='abc')
--where orderNum=3231242;


