set search_path to estate9month2018;

INSERT INTO role(code, name) VALUES ('MANAGER','quản lý');
INSERT INTO role(code, name) VALUES ('USER','nhân viên');

INSERT INTO users(fullname, password, status, username) VALUES ('quản lý 1','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'quanly1');
INSERT INTO users(fullname, password, status, username) VALUES ('nhân viên 1','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'user1');

INSERT INTO user_role(user_id, role_id) VALUES (1,1);
INSERT INTO user_role(user_id, role_id) VALUES (2,2);