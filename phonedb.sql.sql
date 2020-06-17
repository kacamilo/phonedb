-- 0. 테이블 삭제
drop table person;

-- 0.시퀀스 삭제
drop sequence seq_person_id;

-- 1. person 테이블 만들기
create table PERSON (
    person_id   number(5),
    name        varchar2(30)    not null,
    hp          varchar2(20),
    company     varchar2(20)
);

-- 2. 시퀀스 생성
create Sequence seq_person_id
increment by 1
start with 1;

-- 3.INSERT 문
insert into person
values (seq_person_id.nextval,'이효리', '010-1111-1111', '02-1111-1111');

insert into person
values (seq_person_id.nextval,'정우성', '010-2222-2222', '02-2222-2222');

insert into person
values (seq_person_id.nextval,'유재석', '010-3333-3333', '02-3333-3333');

insert into person
values (seq_person_id.nextval,'이정재', '010-4444-4444', '02-4444-4444');

insert into person
values (seq_person_id.nextval,'서장훈', '010-5555-5555', '02-5555-5555');



-- 4.SELECT 문
SELECT *
FROM 
person;

-- 5.UPDATE 문
update person
set hp = '010-1111-1111'
where person_id = 1;

-- 6.DELETE 문
delete from person
where person_id = 5;