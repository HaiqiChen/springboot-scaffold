
DROP TABLE IF EXISTS `sys_user_application`;
CREATE TABLE `sys_user_application` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `app_id` bigint NOT NULL COMMENT '应用ID',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '1.启用 2.停用',
  `creator` bigint DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `modifier` bigint DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_idx_id` (`user_id`,`app_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='sys_user_application 用户应用关联表';
