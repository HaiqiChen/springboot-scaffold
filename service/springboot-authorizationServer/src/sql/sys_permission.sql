
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `creator` bigint NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `modifier` bigint NOT NULL COMMENT '更新人',
  `modified_time` datetime NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `permission_name` varchar(64) NOT NULL COMMENT '权限名称',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  `url_permission` varchar(255) DEFAULT NULL COMMENT '接口权限标识',
  `btn_permission` varchar(255) DEFAULT NULL COMMENT '按钮权限标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='sys_permission权限标识表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
