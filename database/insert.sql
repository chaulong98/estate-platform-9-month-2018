set search_path to batdongsan_springmvc;

insert into roles(code,name) values('ADMIN','Quản trị hệ thống');
insert into roles(code,name) values('USER','người dùng');
insert into roles(code,name) values('MANAGER','Quản Trị');


insert into users(username,password,fullname,email,phoneNumber,status)
values('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','admin','nguyenhong31011997@gmail.com','012456',1);
insert into users(username,password,fullname,email,phoneNumber,status)
values('manager','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Manager','ten31011997@gmail.com','012456',1);
insert into users(username,password,fullname,email,phoneNumber,status)
values('nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van a','son31011997@gmail.com','012456',1);



INSERT INTO users_roles(user_id,role_id) VALUES (1,1);
INSERT INTO users_roles(user_id,role_id) VALUES (2,3);
INSERT INTO users_roles(user_id,role_id) VALUES (3,2);
insert into configuration(typeconfiguration,nameconfiguration,codeconfiguration,valueconfiguration)
values('email_template','Template tạo tài khoản người dùng','template.user.create','Xin Chào : ${userName} Mật khẩu của bạn la: ${password} chú ý đăng nhập để thay đổi mật khẩu');