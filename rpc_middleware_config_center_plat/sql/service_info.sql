CREATE TABLE `service_info` (
  `id` int(11) NOT NULL,
  `service_id` char(50) DEFAULT NULL COMMENT '服务id',
  `app_id` char(50) DEFAULT NULL,
  `machine_id` char(50) DEFAULT NULL,
  `param` text,
  `service_name` char(100) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

