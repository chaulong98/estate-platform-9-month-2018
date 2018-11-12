set search_path to estate8month;

insert into role(code,name) values('MANAGER','Quản trị hệ thống');
insert into role(code,name) values('USER','người dùng');

insert into users(username,password,fullname,email,phonenumber,status)
values('manager','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','trương tùng lâm','meoiancom@gmail.com','123456789',1);
insert into users(username,password,fullname,email,phonenumber,status)
values('nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn A','lamjavadev456@gmail.com','123456789',1);

INSERT INTO user_role(user_id,role_id) VALUES (1,1);
INSERT INTO user_role(user_id,role_id) VALUES (2,2);

INSERT INTO district VALUES (1, NULL, NULL, NULL, NULL, '760', 'Quận 1');
INSERT INTO district VALUES (10, NULL, NULL, NULL, NULL, '769', 'Quận 2');
INSERT INTO district VALUES (11, NULL, NULL, NULL, NULL, '770', 'Quận 3');
INSERT INTO district VALUES (14, NULL, NULL, NULL, NULL, '773', 'Quận 4');
INSERT INTO district VALUES (15, NULL, NULL, NULL, NULL, '774', 'Quận 5');
INSERT INTO "estate"."district" VALUES (16, NULL, NULL, NULL, NULL, '775', 'Quận 6');
INSERT INTO "estate"."district" VALUES (19, NULL, NULL, NULL, NULL, '778', 'Quận 7');
INSERT INTO "estate"."district" VALUES (17, NULL, NULL, NULL, NULL, '776', 'Quận 8');
INSERT INTO "estate"."district" VALUES (4, NULL, NULL, NULL, NULL, '763', 'Quận 9');
INSERT INTO "estate"."district" VALUES (12, NULL, NULL, NULL, NULL, '771', 'Quận 10');
INSERT INTO "estate"."district" VALUES (13, NULL, NULL, NULL, NULL, '772', 'Quận 11');
INSERT INTO "estate"."district" VALUES (2, NULL, NULL, NULL, NULL, '761', 'Quận 12');
INSERT INTO "estate"."district" VALUES (3, NULL, NULL, NULL, NULL, '762', 'Quận Thủ Đức');
INSERT INTO "estate"."district" VALUES (5, NULL, NULL, NULL, NULL, '764', 'Quận Gò Vấp');
INSERT INTO "estate"."district" VALUES (6, NULL, NULL, NULL, NULL, '765', 'Quận Bình Thạnh');
INSERT INTO "estate"."district" VALUES (7, NULL, NULL, NULL, NULL, '766', 'Quận Tân Bình');
INSERT INTO "estate"."district" VALUES (8, NULL, NULL, NULL, NULL, '767', 'Quận Tân Phú');
INSERT INTO "estate"."district" VALUES (9, NULL, NULL, NULL, NULL, '768', 'Quận Phú Nhuận');
INSERT INTO "estate"."district" VALUES (18, NULL, NULL, NULL, NULL, '777', 'Quận Bình Tân');
INSERT INTO "estate"."district" VALUES (20, NULL, NULL, NULL, NULL, '783', 'Huyện Củ Chi');
INSERT INTO "estate"."district" VALUES (21, NULL, NULL, NULL, NULL, '784', 'Huyện Hóc Môn');
INSERT INTO "estate"."district" VALUES (22, NULL, NULL, NULL, NULL, '785', 'Huyện Bình Chánh');
INSERT INTO "estate"."district" VALUES (23, NULL, NULL, NULL, NULL, '786', 'Huyện Nhà Bè');
INSERT INTO "estate"."district" VALUES (24, NULL, NULL, NULL, NULL, '787', 'Huyện Cần Giờ');











