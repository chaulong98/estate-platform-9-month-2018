set search_path to estate9month2018;

INSERT INTO role(code, name) VALUES ('MANAGER','quản lý');
INSERT INTO role(code, name) VALUES ('USER','nhân viên');

INSERT INTO users(fullname, password, status, username) VALUES ('quản lý 1','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'quanly1');
INSERT INTO users(fullname, password, status, username) VALUES ('nhân viên 1','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'user1');

INSERT INTO user_role(user_id, role_id) VALUES (1,1);
INSERT INTO user_role(user_id, role_id) VALUES (2,2);

INSERT INTO building(district, emptyarea, basementarea, buildingname, releasedcost, feeservice, managername, phonenumber) VALUES (1, 170,200,'Coteccon', 200, 40, 'A.Nam', '1232456');
INSERT INTO building(district, emptyarea, basementarea, buildingname, releasedcost, feeservice, managername, phonenumber) VALUES (2, 160,120,'Dong Nhan', 123, 15, 'A.Tam', '4532123');
INSERT INTO building(district, emptyarea, basementarea, buildingname, releasedcost, feeservice, managername, phonenumber) VALUES (3,120, 100,'Tan Minh Nhan', 456, 15, 'A.Tam', '79841231');
INSERT INTO building(district, emptyarea, basementarea, buildingname, releasedcost, feeservice, managername, phonenumber) VALUES (4, 130,150,'Etown', 112, 45, 'A.Thinh/A.Xam', '09042558546544');
INSERT INTO building(district, emptyarea, basementarea, buildingname, releasedcost, feeservice, managername, phonenumber) VALUES (5, 100, 140,'Green', 100, 45, 'A.Tung', '09412325854');