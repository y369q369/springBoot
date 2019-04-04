create table `test`(
	`test_id` varchar(36) not null comment '唯一id' primary key,
	`test_password` varchar(32) not null comment '密码',
	`test_name` varchar(32) not null comment '名称'
) comment '测试'