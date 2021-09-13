
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `username` varchar(128) NOT NULL COMMENT '账户名/登录名',
  `password` varchar(512) DEFAULT NULL COMMENT '密码',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(128) DEFAULT NULL COMMENT '手机号码',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态(1.正常/启用 2.冻结/禁用)',
  `account_type` tinyint NOT NULL DEFAULT '1' COMMENT '账户类型(1：OA账号，2：手机号)',
  `name` varchar(32) DEFAULT NULL COMMENT '中文姓名',
  `creator` bigint NOT NULL DEFAULT '1' COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `modifier` bigint DEFAULT '1' COMMENT '更新人',
  `modified_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除(0:否 , 1:是)',
  `is_admin` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_idx_username` (`username`) USING BTREE,
  UNIQUE KEY `uniq_idx_mobile` (`mobile`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='sys_user用户表';
