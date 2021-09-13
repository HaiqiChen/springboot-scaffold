
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `creator` bigint DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `modifier` bigint DEFAULT NULL COMMENT '更新人',
  `modified_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除',
  `parent_id` bigint NOT NULL DEFAULT '0' COMMENT '父级id',
  `menu_name` varchar(128) NOT NULL COMMENT '菜单名称',
  `icon` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜单图标',
  `route_name` varchar(128) DEFAULT NULL COMMENT '路由名称',
  `route_path` varchar(128) DEFAULT NULL COMMENT '路由路径',
  `component` varchar(128) DEFAULT NULL COMMENT '组件',
  `sort` tinyint DEFAULT NULL COMMENT '排序',
  `hidden` tinyint DEFAULT NULL COMMENT '是否可见',
  `redirect` varchar(1024) DEFAULT NULL COMMENT '重定向地址',
  `active_icon` varchar(32) DEFAULT NULL,
  `always_show` tinyint DEFAULT '1' COMMENT '是否显示,1显示,0不显示',
  `app_id` bigint DEFAULT NULL COMMENT 'appId',
  `keep_alive` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='sys_menu菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '1', '2021-09-09 10:23:45', null, null, '0', '0', '基本信息', 'baseInfo.png', 'BaseInfo', '/baseInfo', 'Layout', '1', '0', null, 'baseInfo-o.png', '0', '1', '1');