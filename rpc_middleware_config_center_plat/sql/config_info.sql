DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `config_id` char(50) DEFAULT NULL COMMENT '配置id',
  `config_content` text COMMENT '配置内容',
  `config_name` char(50) DEFAULT NULL COMMENT '配置名称',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

