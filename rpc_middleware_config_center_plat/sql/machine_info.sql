CREATE TABLE `machine_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `machine_id` char(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '机器id',
  `machine_name` char(50) DEFAULT NULL COMMENT '机器名称',
  `ip` char(20) DEFAULT NULL COMMENT 'ip地址',
  `port` int(10) DEFAULT NULL COMMENT '端口号',
  `health_flag` char(5) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '健康标识',
  `app_id` char(50) CHARACTER SET utf8mb4 NOT NULL COMMENT 'app_id',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

