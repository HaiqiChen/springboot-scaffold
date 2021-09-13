
DROP TABLE IF EXISTS `sys_user_role_app`;
CREATE TABLE `sys_user_role_app` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint DEFAULT NULL COMMENT '角色ID集合',
  `app_id` bigint DEFAULT NULL COMMENT '应用ID',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '1.启用 2.停用（用户与项目关系）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_idx_id` (`user_id`,`role_id`,`app_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='sys_user_role_app 应用用户角色关联表';
