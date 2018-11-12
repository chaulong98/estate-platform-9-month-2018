set search_path to estateplatform;

insert into role(code,name) values('ADMIN','Quản trị hệ thống');
insert into role(code,name) values('USER','người dùng');

insert into users(username,password,fullname,status)
values('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','trung anh',1);
insert into users(username,password,fullname,status)
values('trung anh','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','anh trung',1);

INSERT INTO user_role(user_id,role_id) VALUES (1,1);
INSERT INTO user_role(user_id,role_id) VALUES (2,2);

INSERT INTO district(code,name)
values('ba-dinh','Ba Đình');
INSERT INTO district(code,name)
values('hoan-kiem','Hoàn Kiếm');
INSERT INTO district(code,name)
values('hai-ba-trung','Hai Bà Trưng');
INSERT INTO district(code,name)
values('dong-da','Đống Đa');
INSERT INTO district(code,name)
values('tay-ho','Tây Hồ');
