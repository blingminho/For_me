select * from user_constraints;
select * from tab;
----------------------------------------------------------------
--------------학교 정보 데이터테이블 만들기---------------------
create table stuinfo(
snum char(10) constraint stuinfo_pk primary key,
sname varchar2(12) not null,
sex char(3) check (sex in ('남','여'))
);
select * from stuinfo;

create table subject(
    subjectcode char(10) primary key,
    subjectname char(30) not null );

create table takeclass(
    snum char(10) references stuinfo(snum),
    subjectcode char(10) references subject(subjectcode),
    grade int,
    applydate date check(applydate = default), --check를 이용하여 applydate가 오직 default인 경우만 허용함!!
    --applydate date default sysdate,
    constraint takeclass_pk primary key(snum,subjectcode)
);
--alter table takeclass alter column applydate date;
drop table takeclass;
select * from takeclass;
----------데이터입력----------
insert into stuinfo values('52121813','KIMSANGJUN','남');
insert into stuinfo values('52121892','JOOHYUNGU','남');
insert into stuinfo values('52121802','KANGBUMSIN','남');
insert into stuinfo values('52121824','KANGSINWOO','남');
insert into stuinfo values('42521813','KIMSOYUN','여');

insert into subject values('1021','MATH2');
insert into subject values('1022','MATH3');
insert into subject values('1023','CHINA');
insert into subject values('2201','COMPUTER');
insert into subject values('2221','JAVASTUDY');

insert into takeclass values('52121813','1021',95,default);
insert into takeclass values('52121892','1021',80,default);
insert into takeclass values('52121802','2201',75,default);
insert into takeclass values('52121824','2221',95,default);
insert into takeclass values('42521813','1022',100,default);

select * from stuinfo inner join takeclass
on stuinfo.snum = takeclass.snum;

----------**********07/06 -----------
---join 3개
select * from takeclass inner join subject
on takeclass.subjectcode = subject.subjectcode
inner join stuinfo
on stuinfo.snum = takeclass.snum;

select * from takeclass,subject,stuinfo
where takeclass.subjectcode = subject.subjectcode
and stuinfo.snum = takeclass.snum;
----view만들기 --가상의 논리적인 테이블
create view v_empdept
as
select takeclass.subjectcode,stuinfo.snum -- *하면 오류남 --조인 조건에 맞는 것만을 select하기!!
from takeclass
inner join subject
on takeclass.subjectcode = subject.subjectcode
inner join stuinfo
on stuinfo.snum = takeclass.snum;

select * from v_empdept; -- view 는 select 해오는 용도로 쓰자!!
---insert를 view 객체에 할경우 귀찮아 지기 때문에 select하는 용도로만 사용하자

create view v_emporacle
as
select takeclass.subjectcode,stuinfo.snum -- *하면 오류남 --조인 조건에 맞는 것만을 select하기!!
from takeclass,subject,stuinfo
where takeclass.subjectcode = subject.subjectcode , stuinfo.snum = takeclass.snum;

