-- 0. ���̺� ����
drop table person;

-- 0.������ ����
drop sequence seq_person_id;

-- 1. person ���̺� �����
create table PERSON (
    person_id   number(5),
    name        varchar2(30)    not null,
    hp          varchar2(20),
    company     varchar2(20)
);

-- 2. ������ ����
create Sequence seq_person_id
increment by 1
start with 1;

-- 3.INSERT ��
insert into person
values (seq_person_id.nextval,'��ȿ��', '010-1111-1111', '02-1111-1111');

insert into person
values (seq_person_id.nextval,'���켺', '010-2222-2222', '02-2222-2222');

insert into person
values (seq_person_id.nextval,'���缮', '010-3333-3333', '02-3333-3333');

insert into person
values (seq_person_id.nextval,'������', '010-4444-4444', '02-4444-4444');

insert into person
values (seq_person_id.nextval,'������', '010-5555-5555', '02-5555-5555');



-- 4.SELECT ��
SELECT *
FROM 
person;

-- 5.UPDATE ��
update person
set hp = '010-1111-1111'
where person_id = 1;

-- 6.DELETE ��
delete from person
where person_id = 5;