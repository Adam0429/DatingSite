select * from bbs;
select * from reply;
insert into bbs (bbs_id,bbs_title,bbs_content,login_account) values (3,"233232","edsd","dsd");
insert into bbs (bbs_id,bbs_time) values ("1","2017-08-06 18:16:18 ");
drop table bbs; 
select * from login;
SELECT * FROM login  ORDER BY account ASC LIMIT 1,2;
select count(*) as total from login ;
select * from login where name like '%2%' limit 1,2
select * from dormitory;
insert into dormitory values ("¿∂‘√‘∞");
insert into dormitory values ("¿∂æ≤‘∞");
insert into dormitory values ("¿∂∑º‘∞");
delete from dormitory where name=;
select count(*) from bbs;
create table login(
account varchar(20) primary key,
password varchar(20),
name varchar(20),
gender varchar(10),
tele varchar(20),
dormitory_name varchar(20) references dormitory(name)

)character set = utf8;

select count(*) as bbs_number from bbs;
create table dormitory(
name varchar(20) primary key
)character set = utf8;
drop table bbs;

create table bbs(
bbs_id int primary key,
bbs_content varchar(1000),
bbs_title varchar(50),
bbs_time datetime,
login_account varchar(20) references login(account)
)character set = utf8;
drop table reply;

create table reply(
reply_id int primary key,
reply_content varchar(200),
reply_time datetime,
bbs int references bbs(bbs_id),
login_account varchar(20) references login(account)
)

create table suggest(
sug varchar(200)
)character set = utf8;
select * from suggest;