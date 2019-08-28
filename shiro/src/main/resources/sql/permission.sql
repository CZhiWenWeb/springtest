CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(128) DEFAULT NULL COMMENT '资源名称',
  `per_code` varchar(128) NOT NULL COMMENT '权限代码字符串',
  PRIMARY KEY (`id`),
  UNIQUE KEY `per_code` (`per_code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='资源表';
INSERT INTO `permission` VALUES (1, '查看用户', 'user:view');
INSERT INTO `permission` VALUES (2, '操作用户', 'user:edit');
