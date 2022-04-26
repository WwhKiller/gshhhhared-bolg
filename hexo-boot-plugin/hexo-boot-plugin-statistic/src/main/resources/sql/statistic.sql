CREATE TABLE IF NOT EXISTS `t_ext_visit_info` (
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
	`pv` INT NOT NULL DEFAULT '0' COMMENT '页面访问量',
	`uv` INT NOT NULL DEFAULT '0' COMMENT '用户访问量',
	`period` INT NOT NULL DEFAULT '0' COMMENT '当天日期，格式:yyyyMMdd',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
	PRIMARY KEY (`id`),
	INDEX `idx_period` (`period`)
)
COMMENT='访问记录信息-插件'
COLLATE='utf8_general_ci'
;

CREATE TABLE IF NOT EXISTS `t_ext_visit_detail` (
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
	`ip` VARCHAR(64) NOT NULL DEFAULT '' COMMENT 'ip 地址',
	`url` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '请求 url',
	`browser` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '浏览器类型',
	`country` VARCHAR(16) NOT NULL DEFAULT '' COMMENT '国家',
	`province` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '省份',
	`city` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '城市',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
	PRIMARY KEY (`id`),
	INDEX `idx_create_time_ip` (`create_time`, `ip`)
)
COMMENT='访问记录详情-插件'
COLLATE='utf8_general_ci'
;
