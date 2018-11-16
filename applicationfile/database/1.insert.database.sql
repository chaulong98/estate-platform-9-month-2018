set search_path to estateletuan;

INSERT INTO role(code, name) VALUES ('MANAGER','manager');
INSERT INTO role(code, name) VALUES ('USER','user');

INSERT INTO users(fullname, password, status, username) VALUES ('manager','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'manager');
INSERT INTO users(fullname, password, status, username) VALUES ('Nguyễn Văn A','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'user');

INSERT INTO users(fullname, password, status, username) VALUES ('manager1','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'manager1');
INSERT INTO users(fullname, password, status, username) VALUES ('Nguyễn Văn B','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'user1');
INSERT INTO users(fullname, password, status, username) VALUES ('Nguyễn Văn C','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'user2');

INSERT INTO user_role(user_id, role_id) VALUES (1,1);
INSERT INTO user_role(user_id, role_id) VALUES (2,2);

INSERT INTO user_role(user_id, role_id) VALUES (3,1);
INSERT INTO user_role(user_id, role_id) VALUES (4,2);
INSERT INTO user_role(user_id, role_id) VALUES (5,2);

--quan huyen
insert into district(code, name)
values('ba-dinh','Ba Đình');

insert into district(code, name)
values('cau-giay','Cầu Giấy');

insert into district(code, name)
values('dong-da','Đống Đa');

insert into district(code, name)
values('hai-ba-trung','Hai Bà Trưng');

