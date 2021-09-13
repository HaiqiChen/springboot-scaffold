
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `creator` bigint NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `modifier` bigint NOT NULL COMMENT '更新人',
  `modified_time` datetime NOT NULL COMMENT '更新时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `role_name` varchar(64) NOT NULL COMMENT '角色名称',
  `role_code` varchar(64) NOT NULL COMMENT '角色编码',
  `remark` varchar(255) DEFAULT NULL,
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态，1.正常 2.冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='sys_role角色表';
