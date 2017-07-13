select * from login where account like '%2%';
select * from login;
SELECT * FROM login  ORDER BY account ASC LIMIT 1,2;
select count(*) as total from login ;
select * from login where name like '%2%' limit 1,2
select * from dormitory;
insert into dormitory values ("¿∂‘√‘∞");
insert into dormitory values ("¿∂æ≤‘∞");
insert into dormitory values ("¿∂∑º‘∞");
delete from dormitory where name=;

create table login(
account varchar(20) primary key,
password varchar(20),
name varchar(20),
gender varchar(10),
tele varchar(20),
dormitory_name varchar(20) references dormitory(name)

)character set = utf8;


create table dormitory(
name varchar(20) primary key
)character set = utf8;

