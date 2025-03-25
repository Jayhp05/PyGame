-- 사용자 계정과 권한 관리 - DCL (Data Controll Language)

-- 사용자 생성 - 일반사용자 X -> DBA  SYS, SYSTEM
create user test1 identified by 12345678;

select * from dba_users;
-- sys 계정에서 test1 계정에 접속 권한 부여 -> DCL 
grant create session to test1;

-- 테이블 생성권한
grant create table to test1;

-- SYS에서 테이블 스페이스 조회
select * from dba_tablespaces;

-- 용량 제한 없이 test1에 권한 부여
alter user test1 QUOTA unlimited on SYSTEM;

-- SYS에서 여러 시스템 권한 부여
grant create session, create table, create view to test1;

-- 자신이 부여 받은 권한을 다른 사용자에게 부여할 수 있는 옵션 추가
grant create user, create session, create table, create view 
to test1 with admin OPTION;

-- SYS에서 TEST1에게 부여한 권한 회수
revoke create user, create session, create table, create view from test1;



