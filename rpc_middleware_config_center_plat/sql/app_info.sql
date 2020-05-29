CREATE TABLE `app_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `app_id` char(50) CHARACTER SET utf8mb4 NOT NULL COMMENT 'app_id 业务使用',
  `app_name` char(60) CHARACTER SET utf8mb4 DEFAULT '' COMMENT 'app名称',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `config_id` char(50) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '配置id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
