CREATE USER BOOK IDENTIFIED BY 12345678;


-- 회원 정보 저장 테이블
CREATE TABLE member_table (
    MEMBER_ID NUMBER NOT NULL,
    MEMBER_NAME VARCHAR2(10) NOT NULL,
    RESIDENT_NUMBER NUMBER(13) NOT NULL,
    TEL NUMBER(11),
    PHONE NUMBER(11) NOT NULL,
    ZIP_CODE NUMBER,
    ADDRESS VARCHAR2(100 CHAR) NOT NULL,
    JOIN_DATE DATE NOT NULL,
    CONSTRAINT member_table_pk PRIMARY KEY (MEMBER_ID)
);

-- 주문 테이블
CREATE TABLE order_table (
    ORDER_NO NUMBER NOT NULL,
    ORDER_DATE DATE NOT NULL,
    ORDER_PRICE NUMBER NOT NULL,
    MEMBER_ID NUMBER NOT NULL,
    CONSTRAINT order_table_pk PRIMARY KEY (ORDER_NO),
    CONSTRAINT order_table_fk_01 FOREIGN KEY (MEMBER_ID) REFERENCES member_table (MEMBER_ID)
);

-- 주문 상세 정보 저장 테이블
CREATE TABLE order_detail (
    ORDER_DETAIL_NO NUMBER NOT NULL,
    ORDER_COUNT NUMBER NOT NULL,
    ORDER_NO NUMBER NOT NULL,
    ISBN13_CODE NUMBER NOT NULL,
    CONSTRAINT order_detail_table_pk PRIMARY KEY (ORDER_DETAIL_NO),
    CONSTRAINT order_detail_table_fk_01 FOREIGN KEY (ORDER_NO) REFERENCES order_table (ORDER_NO),
    CONSTRAINT order_detail_table_fk_02 FOREIGN KEY (ISBN13_CODE) REFERENCES BOOK (ISBN13_CODE)
);

-- 도서 정보 테이블
CREATE TABLE book (
    ISBN13_CODE NUMBER NOT NULL,
    TITLE VARCHAR2(50 CHAR) NOT NULL,
    WRITER VARCHAR2(20 CHAR) NOT NULL,
    PUBLISHER VARCHAR2(20 CHAR) NOT NULL,
    PUB_DAY DATE NOT NULL,
    PRICE NUMBER NOT NULL,
    BOOK_INTRO VARCHAR2(1000),
    CONSTRAINT book_table_pk PRIMARY KEY (ISBN13_CODE)
);

-- 도서 테이블에 장르번호를 추가하기 위한 sql문
ALTER TABLE book ADD GENRE_NO NUMBER;

ALTER TABLE book ADD CONSTRAINT book_table_fk_01 
FOREIGN KEY (GENRE_NO) REFERENCES GENRE (GENRE_NO);

ALTER TABLE book MODIFY GENRE_NO NOT NULL;

-- 장르 정보 테이블
CREATE TABLE genre (
    GENRE_NO NUMBER NOT NULL,
    GENRE_NAME VARCHAR2(20 CHAR) NOT NULL,
    ISBN13_CODE NUMBER NOT NULL,
    CONSTRAINT genre_table_pk PRIMARY KEY (GENRE_NO),
    CONSTRAINT genre_table_fk_01 FOREIGN KEY (ISBN13_CODE) REFERENCES BOOK (ISBN13_CODE)
);

-- 재고관리를 위한 테이블
CREATE TABLE stock (
    ISBN13_CODE NUMBER NOT NULL,
    STOCK_LOC VARCHAR2(500) NOT NULL,
    STOCK_COUNT NUMBER NOT NULL,
    CONSTRAINT stock_table_pk PRIMARY KEY (ISBN13_CODE),
    CONSTRAINT stock_table_fk_01 FOREIGN KEY (ISBN13_CODE) REFERENCES BOOK (ISBN13_CODE)
);

-- 배송 정보 테이블
CREATE TABLE delivery (
    DELIVERY_NO NUMBER NOT NULL,
    DELIVERY_SITUATION VARCHAR2(500) NOT NULL,
    ISBN13_CODE NUMBER NOT NULL,
    ORDER_NO NUMBER NOT NULL,
    CONSTRAINT delivery_table_pk PRIMARY KEY (DELIVERY_NO),
    CONSTRAINT delivery_table_fk_01 FOREIGN KEY (ORDER_NO) REFERENCES order_table (ORDER_NO),
    CONSTRAINT delivery_table_fk_02 FOREIGN KEY (ISBN13_CODE) REFERENCES BOOK (ISBN13_CODE)
);

-- 매출액에 관한 정보 테이블 **(일별, 월별, 연별에 대한 정보 추후 수정 필요)**
CREATE TABLE sales_board (
    SALES_NO NUMBER(15) NOT NULL,
    ISBN13_CODE NUMBER(15) NOT NULL,
    POPULARITY VARCHAR2(20 CHAR),
    SUM_SALES NUMBER NOT NULL,
    ORDER_NO NUMBER(15) NOT NULL,
    CONSTRAINT sales_board_table_pk PRIMARY KEY (SALES_NO),
    CONSTRAINT sales_board_table_fk_01 FOREIGN KEY (ORDER_NO) REFERENCES order_table (ORDER_NO),
    CONSTRAINT sales_board_table_fk_02 FOREIGN KEY (ISBN13_CODE) REFERENCES BOOK (ISBN13_CODE)
);

-- 포인트 정보 테이블
CREATE TABLE point_table (
    MEMBER_ID NUMBER NOT NULL,
    REWARD_POINT NUMBER NOT NULL,
    CONSTRAINT point_table_pk01 PRIMARY KEY (MEMBER_ID),
    CONSTRAINT point_table_fk FOREIGN KEY (MEMBER_ID) REFERENCES member_table (MEMBER_ID)
);

-- 리뷰에 관한 정보 테이블
CREATE TABLE review (
    REVIEW_NO NUMBER NOT NULL,
    REVIEW_DATE DATE NOT NULL,
    REVIEW_CONTENT VARCHAR2(300 CHAR) NOT NULL,
    MEMBER_ID NUMBER NOT NULL,
    ISBN13_CODE NUMBER NOT NULL,
    CONSTRAINT review_table_pk PRIMARY KEY (REVIEW_NO),
    CONSTRAINT review_table_fk_01 FOREIGN KEY (MEMBER_ID) REFERENCES member_table (MEMBER_ID),
    CONSTRAINT review_table_fk_02 FOREIGN KEY (ISBN13_CODE) REFERENCES BOOK (ISBN13_CODE)
);

-- member 테이블에 가상의 데이터 추가
INSERT INTO member_table (MEMBER_ID, MEMBER_NAME, RESIDENT_NUMBER, PHONE, ADDRESS, JOIN_DATE)
VALUES (1, '김철수', '9001011234567', '01098765432', '서울시 강남구', '2018-01-15');

INSERT INTO member_table (MEMBER_ID, MEMBER_NAME, RESIDENT_NUMBER, TEL, PHONE, ZIP_CODE, ADDRESS, JOIN_DATE)
VALUES (2, '이영희', '8805052345678', '023456789', '01023456789', '23456', '서울시 마포구 합정동', TO_DATE('2010-02-20', 'YYYY-MM-DD'));

INSERT INTO member_table (MEMBER_ID, MEMBER_NAME, RESIDENT_NUMBER, TEL, PHONE, ZIP_CODE, ADDRESS, JOIN_DATE)
VALUES (3, '홍길동', '9505053456789', '03134567890', '01034567890', '34567', '경기도', '2023-09-10');

INSERT INTO member_table (MEMBER_ID, MEMBER_NAME, RESIDENT_NUMBER, PHONE, ZIP_CODE, ADDRESS, JOIN_DATE)
VALUES (4, '임민희', '9107074567890', '01045678901', '45678', '인천광역시', '2025-02-02');

INSERT INTO member_table (MEMBER_ID, MEMBER_NAME, RESIDENT_NUMBER, TEL, PHONE, ZIP_CODE, ADDRESS, JOIN_DATE)
VALUES (5, '최희수', '9503035678901', '025679012', '01056789012', '56789', '대전시', '2011-05-12');

-- 주문 테이블 데이터 삽입
INSERT INTO order_table VALUES (101, '2024-03-20', 45000, 1);
INSERT INTO order_table VALUES (102, '2024-03-21', 32000, 2);
INSERT INTO order_table VALUES (103, '2024-03-22', 28000, 3);
INSERT INTO order_table VALUES (104, '2024-03-23', 50000, 4);
INSERT INTO order_table VALUES (105, '2024-03-24', 60000, 5);

-- 주문상세 테이블 데이터 삽입
INSERT INTO order_detail VALUES (1, 2, 101, 9788996991342);
INSERT INTO order_detail VALUES (2, 1, 102, 9788965422781);
INSERT INTO order_detail VALUES (3, 3, 103, 9788994492261);
INSERT INTO order_detail VALUES (4, 2, 104, 9788901234567);
INSERT INTO order_detail VALUES (5, 1, 105, 9788970123456);

-- 도서 테이블 데이터 삽입
INSERT INTO book VALUES (9788996991342, '파이썬 데이터 분석', '이강인', 'IT출판사', '2023-06-15', 25000, '데이터 분석을 위한 파이썬 가이드', 1);
INSERT INTO book VALUES (9788965422781, '자바 웹 개발', '손흥민', '소프트웨어북스', '2022-11-10', 32000, '자바 기반 웹 애플리케이션 개발', 2);
INSERT INTO book VALUES (9788994492261, '머신러닝 실무', '안정환', 'AI출판사', '2021-09-05', 28000, '실전 머신러닝 기법 소개', 3);
INSERT INTO book VALUES (9788901234567, '데이터베이스 설계', '이을용', 'DB전문사', '2020-05-20', 50000, '관계형 데이터베이스 설계 이론', 4);
INSERT INTO book VALUES (9788970123456, '알고리즘 문제 해결', '기성용', 'CS출판', '2019-03-14', 60000, '코딩 테스트를 위한 알고리즘 전략', 5);

-- 장르 테이블 데이터 삽입
INSERT INTO genre VALUES (1, '프로그래밍', 9788996991342);
INSERT INTO genre VALUES (2, '소프트웨어', 9788965422781);
INSERT INTO genre VALUES (3, 'AI/머신러닝', 9788994492261);
INSERT INTO genre VALUES (4, '데이터베이스', 9788901234567);
INSERT INTO genre VALUES (5, '알고리즘', 9788970123456);

-- 재고 관리 테이블 데이터 삽입
INSERT INTO stock VALUES (9788996991342, '서울 관악점', 10);
INSERT INTO stock VALUES (9788965422781, '서울 강북점', 5);
INSERT INTO stock VALUES (9788994492261, '서울 강남점', 7);
INSERT INTO stock VALUES (9788901234567, '서울 서초점', 3);
INSERT INTO stock VALUES (9788970123456, '서울 중랑점', 6);

-- 배송 테이블 데이터 삽입
INSERT INTO delivery VALUES (1, '배송중', 9788996991342, 101);
INSERT INTO delivery VALUES (2, '배송완료', 9788965422781, 102);
INSERT INTO delivery VALUES (3, '배송중', 9788994492261, 103);
INSERT INTO delivery VALUES (4, '배송대기', 9788901234567, 104);
INSERT INTO delivery VALUES (5, '배송완료', 9788970123456, 105);

-- 매출 테이블 데이터 삽입
INSERT INTO sales_board VALUES (1, 9788996991342, '50', 50000, 101);
INSERT INTO sales_board VALUES (2, 9788965422781, '30', 32000, 102);
INSERT INTO sales_board VALUES (3, 9788994492261, '45', 84000, 103);
INSERT INTO sales_board VALUES (4, 9788901234567, '20', 100000, 104);
INSERT INTO sales_board VALUES (5, 9788970123456, '60', 60000, 105);

-- 포인트 테이블 데이터 삽입
INSERT INTO point_table VALUES (1, 500);
INSERT INTO point_table VALUES (2, 300);
INSERT INTO point_table VALUES (3, 700);
INSERT INTO point_table VALUES (4, 1000);
INSERT INTO point_table VALUES (5, 1200);

-- 회원 리뷰 테이블 데이터 삽입
INSERT INTO review VALUES (1, '2024-03-22', '책의 내용이 매우 알차고 유용했습니다.', 1, 9788996991342);
INSERT INTO review VALUES (2, '2024-03-23', '웹 개발에 대한 설명이 상세하여 좋았습니다.', 2, 9788965422781);
INSERT INTO review VALUES (3, '2024-03-24', '머신러닝 개념을 쉽게 이해할 수 있었습니다.', 3, 9788994492261);
INSERT INTO review VALUES (4, '2024-03-25', '데이터베이스 기본 개념을 배우기에 좋은 책이네요.', 4, 9788901234567);
INSERT INTO review VALUES (5, '2024-03-26', '알고리즘 문제 해결에 많은 도움이 되었습니다.', 5, 9788970123456);


-- 각 테이블 조회
select * from member_table;
select * from order_table;
select * from order_detail;
select * from book;
select * from genre;
select * from stock;
select * from delivery;
select * from sales_board;
select * from point_table;
select * from review;

select * from member_table;

-- 회원 테이블 조회
SELECT member_id 회원번호, member_name 회원이름, resident_number 주민번호, tel 전화번호,
    phone 핸드폰번호, zip_code 우편번호, address 주소, join_date 가입일
FROM member_table;

-- 테이블 조회하며 확인
select * from order_table;
select * from sales_board;
select * from delivery;
select * from member_table;
select * from point_table;
select * from order_detail;
-- 주문 테이블 조회
select o.order_no 주문번호, m.member_name 회원이름, o.order_date 주문일자, s.sum_sales 총주문금액,
        p.reward_point 적립포인트, d.delivery_situation 배송상태
from order_table o, delivery d, member_table m, point_table p, sales_board s
where o.order_no = d.order_no and o.member_id = m.member_id
    and m.member_id = p.member_id and o.order_no = s.order_no;

-- 주문 상세 테이블 조회(출고중인 상세 주문 내역)
select o.order_no 주문번호, b.title 주문도서제목, o.isbn13_code 도서번호, o.order_count 주문수량, b.price 도서단가 
from order_detail o, book b
where o.isbn13_code = b.isbn13_code and order_no = 102;
