
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `role_id` bigint DEFAULT NULL COMMENT 'roleId',
  `menu_id` bigint DEFAULT NULL COMMENT 'menuId',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_id_idx` (`role_id`,`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='sys_role_menu角色菜单关联表';
