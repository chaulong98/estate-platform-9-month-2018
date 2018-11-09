set search_path to estate;

INSERT INTO role(code, name) VALUES ('MANAGER','manager');
INSERT INTO role(code, name) VALUES ('USER','user');

INSERT INTO users(fullname, password, status, username) VALUES ('manager','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'manager');
INSERT INTO users(fullname, password, status, username) VALUES ('Nguyễn Văn A','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'user');

INSERT INTO user_role(user_id, role_id) VALUES (1,1);
INSERT INTO user_role(user_id, role_id) VALUES (2,2);

--quan huyen
insert into distric(code, name)
values('ba-dinh','Ba Đình');

insert into distric(code, name)
values('cau-giay','Cầu Giấy');

insert into distric(code, name)
values('dong-da','Đống Đa');

insert into distric(code, name)
values('hai-ba-trung','Hai Bà Trưng');

