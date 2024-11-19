# 数据库说明

- ip地址：见群里

- 端口：3306，

- 用户名：姓名首拼

- 密码：123456，

- 数据库名: szulab 

mysql的版本是8.0.26

## 分配权限

#### 分配root权限

```
ALTER  USER  'root'@'localhost'  IDENTIFIED BY 'szulab';
```

```
set global validate_password.policy = 0;
set global validate_password.length = 4;
```

```
create user 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'szulab';
```

```
grant all on *.* to 'root'@'%';
```



#### 分配用户权限

```
set global validate_password.policy = 0;
set global validate_password.length = 6;
```

```
create user 'zsj'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
grant all on *.* to 'zsj'@'%';
```

```
create user 'pwh'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
grant all on *.* to 'pwh'@'%';
```

```
create user 'lbc'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
grant all on *.* to 'lbc'@'%';
```

```
create user 'cyd'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
grant all on *.* to 'cyd'@'%';
```

```
create user 'czk'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
grant all on *.* to 'czk'@'%';
```

```
create user 'yht'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
grant all on *.* to 'yht'@'%';
```

```
create user 'wjj'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
grant all on *.* to 'wjj'@'%';
```

```
create user 'zjy'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
grant all on *.* to 'zjy'@'%';
```

```
create user 'lzl'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
grant all on *.* to 'lzl'@'%';
```

## 数据库表的设计

#### user 用户表

```
-- 用户表
create table if not exists szulab.`user`
(
`user_id` int not null auto_increment comment '用户id' primary key,
`username` varchar(256) not null comment '用户名',
`password` varchar(256) not null comment '密码',
`role` int default 0 not null comment '0-学生 1-老师 2-其他',
`stu_id` varchar(256) not null comment '号码 如学号',
`create_time` datetime default now() not null comment '创建时间',
`update_time` datetime  default now() on update now() not null comment '更新时间'
) comment '用户表';
-- 测试数据
insert into szulab.`user` (`user_id`, `username`, `password`, `role`, `stu_id`, `create_time`) values (1, 'mike', 'u2iosi1o', 0, '2022112626', now());
insert into szulab.`user` (`user_id`, `username`, `password`, `role`, `stu_id`, `create_time`) values (2, 'john', 'L8soeio3', 1, '2024169898', now());
```

#### post 帖子表

```
-- 帖子表
create table if not exists szulab.`post`
(
`post_id` int not null auto_increment comment '帖子id' primary key,
`title` varchar(256) not null comment '帖子标题',
`description` varchar(1000) null comment '帖子描述',
`content` text not null comment '帖子内容',
`user_id` int not null comment '用户id',
`image_url` varchar(356) null comment '图片地址',
`create_time` datetime default now() not null comment '帖子创建时间',
`update_time` datetime default now() on update now() not null comment '帖子更新时间',
`tags` varchar(1000) null comment '标签数组'
) comment '帖子表';

-- 测试数据
insert into szulab.`post` (`post_id`, `title`, `description`, `content`, `user_id`, `image_url`,`tags`) values (1, '蓝桥杯', '算法比赛', '蓝桥杯的测试数据', 1, 'http://172.31.233.204/resource/img/exp9/bg3.png', '比赛,蓝桥杯');
insert into szulab.`post` (`post_id`, `title`, `description`, `content`, `user_id`, `image_url`,`tags`) values (2, 'ACM', '算法比赛', 'ACM的测试数据', 2, 'http://172.31.233.204/resource/img/exp9/bg2.png',  '比赛,ACM');
```

##### 修改帖子表

```
-- 更新表结构
alter table post
    add category varchar(256) null comment '帖子类型';
-- 更新测试数据
UPDATE szulab.post t SET t.category = 'competition' WHERE t.post_id = 2;
UPDATE szulab.post t SET t.category = 'competition' WHERE t.post_id = 1;
UPDATE szulab.post t SET t.category = 'team' WHERE t.post_id = 3;
```

