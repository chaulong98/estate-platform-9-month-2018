set search_path to estate9month2018;

insert into estatetrunganh.role(code,name) values('ADMIN','Quản trị hệ thống');
insert into estatetrunganh.role(code,name) values('USER','người dùng');

insert into estatetrunganh.users(username,password,fullname,status)
values('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','trung anh',1);
insert into estatetrunganh.users(username,password,fullname,status)
values('trunganh','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','anh trung',1);
insert into estatetrunganh.users(username,password,fullname,status)
values('admin2','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','trung anh',1);
insert into estatetrunganh.users(username,password,fullname,status)
values('trunganh2','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','anh trung',1);
insert into estatetrunganh.users(username,password,fullname,status)
values('trunganh3','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','anh trung',1);
insert into estatetrunganh.users(username,password,fullname,status)
values('trunganh4','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','anh trung',1);

INSERT INTO estatetrunganh.user_role(user_id,role_id) VALUES (1,1);
INSERT INTO estatetrunganh.user_role(user_id,role_id) VALUES (2,2);
INSERT INTO estatetrunganh.user_role(user_id,role_id) VALUES (3,1);
INSERT INTO estatetrunganh.user_role(user_id,role_id) VALUES (4,2);
INSERT INTO estatetrunganh.user_role(user_id,role_id) VALUES (5,2);
INSERT INTO estatetrunganh.user_role(user_id,role_id) VALUES (6,2);

INSERT INTO estatetrunganh.district(code,name)
values('ba-dinh','Ba Đình');
INSERT INTO estatetrunganh.district(code,name)
values('hoan-kiem','Hoàn Kiếm');
INSERT INTO estatetrunganh.district(code,name)
values('hai-ba-trung','Hai Bà Trưng');
INSERT INTO estatetrunganh.district(code,name)
values('dong-da','Đống Đa');
INSERT INTO estatetrunganh.district(code,name)
values('tay-ho','Tây Hồ');
