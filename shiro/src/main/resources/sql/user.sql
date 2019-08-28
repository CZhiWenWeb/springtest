CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `account` varchar(20) NOT NULL COMMENT '帐号',
  `password` varchar(80) NOT NULL COMMENT '密码',
  `username` varchar(20) NOT NULL COMMENT '昵称',
  `reg_time` datetime NOT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';
INSERT INTO `user` VALUES (1, 'admin', 'QUJBNUYyM0M3OTNEN0I4MUFBOTZBOTkwOEI1NDI0MUE=', 'admin', '2019-08-23 09:50:03');
INSERT INTO `user` VALUES (2, 'wang', 'RTM3MDJENjU0MDg5QURFNUZEQTkxNTNCOEZFQ0MzMkM=', 'wang', '2019-08-23 09:50:03');
INSERT INTO `user` VALUES (3, 'guest', 'QTNCMzMwREY3MkMwQjRGQjNBQzUyOTM0NTFFMzJCNDg=', 'guest', '2019-08-23 09:50:03');
