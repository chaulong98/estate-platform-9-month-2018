set search_path to estate;

INSERT INTO role(code, name) VALUES ('ADMIN','admin');
INSERT INTO role(code, name) VALUES ('USER','user');

INSERT INTO users(fullname, password, status, username) VALUES ('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'admin');
INSERT INTO users(fullname, password, status, username) VALUES ('Nguyễn Văn A','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'user');

INSERT INTO user_role(user_id, role_id) VALUES (1,1);
INSERT INTO user_role(user_id, role_id) VALUES (2,2);

INSERT INTO district(code,name) values('1', 'Quận Thủ Đức');
INSERT INTO district(code,name) values('2', 'Quận 12');
INSERT INTO district(code,name) values('3', 'Quận 9');

