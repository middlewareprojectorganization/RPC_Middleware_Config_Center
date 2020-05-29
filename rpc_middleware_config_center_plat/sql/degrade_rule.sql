CREATE TABLE `degrade_rule` (
  `id` bigint(20) NOT NULL,
  `app_id` char(50) DEFAULT NULL,
  `ip` char(20) DEFAULT NULL,
  `port` int(10) DEFAULT NULL,
  `resource` char(50) DEFAULT NULL,
  `limit_app` char(50) DEFAULT NULL,
  `count` double(20,0) DEFAULT NULL,
  `time_window` int(11) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `gmt_Create` date DEFAULT NULL,
  `gmt_modified` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

