

DROP TABLE IF EXISTS `sys_application`;
CREATE TABLE `sys_application` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `creator` bigint NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `modifier` bigint NOT NULL COMMENT '更新人',
  `modified_time` datetime NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NOT NULL COMMENT '是否删除',
  `app_name` varchar(64) NOT NULL COMMENT '应用名称',
  `app_status` tinyint NOT NULL COMMENT '使用状态:正常，冻结',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_app_name_idx` (`app_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='sys_application应用信息表';
