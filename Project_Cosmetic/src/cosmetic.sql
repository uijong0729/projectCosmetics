create table Cosmetic(
	cosNumber number primary key
	, cosName varchar2(50) unique
	, cosPrice number not null
	, cosGrade number(2) 
	, cosBrand varchar2(20) not null
	, cosContent varchar2(2000) 
	, cosSkinType varchar2(9)
	, cosType varchar(15) not null
);

create sequence cos_Seq;


CREATE TABLE customer (

 id varchar2(40) primary key
, pw varchar2(40) not null
, cusAge number not null
, cusGender varchar2(40) not null
, cusSkinType varchar2(40) 
);



create table review(
	reviewNum number primary key
	, cosNum number references cosmetic on delete cascade
	, id varchar2(40) not null 
	, content varchar2(1000) not null 
	, cosGrade number(5 ,2) default 0
	, indate date default sysdate 
);

create sequence review_Seq;

create table Favorite 
(id varchar2(20), 
cosNumber number unique);


//////////////////////////////////////
√ ±‚»≠ sql

delete from cosmetic;
delete from review;

drop sequence review_seq;
create sequence review_Seq;

drop sequence cos_Seq;
create sequence cos_Seq;







