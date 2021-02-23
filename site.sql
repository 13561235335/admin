-- 站点 site

CREATE TABLE `site` (
  `id` bigint(20) unsigned NOT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `del_flag` tinyint(1) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `ip` varchar(255) NOT NULL COMMENT 'IP地址',
  `swith_one` tinyint(1) NOT NULL DEFAULT '0' COMMENT '',
  `swith_two` tinyint(1) NOT NULL DEFAULT '0' COMMENT '',
  `swith_three` tinyint(1) NOT NULL DEFAULT '0' COMMENT '',
  `swith_four` tinyint(1) NOT NULL DEFAULT '0' COMMENT '',
  `swith_five` tinyint(1) NOT NULL DEFAULT '0'COMMENT '',
  `swith_six` tinyint(1) NOT NULL DEFAULT '0' COMMENT '',
  `swith_seven` tinyint(1) NOT NULL DEFAULT '0' COMMENT '',
  `swith_eight` tinyint(1) NOT NULL DEFAULT '0' COMMENT '',
  `swith_nine` tinyint(1) NOT NULL DEFAULT '0' COMMENT '',
  `swith_ten` tinyint(1) NOT NULL DEFAULT '0' COMMENT '',
  `swith_eleven` tinyint(1) NOT NULL DEFAULT '0' COMMENT '',
  `site_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '站点状态', 
  `taobao_store_name` varchar(255) DEFAULT NULL COMMENT '淘宝店名', 
  PRIMARY KEY (`id`),
  KEY `create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 站点帐号 Site account number

CREATE TABLE `site_account_number` (
  `id` bigint(20) unsigned NOT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `del_flag` tinyint(1) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `site_id` bigint(20) NOT NULL COMMENT '',
  `site_account` varchar(255) NOT NULL DEFAULT '0' COMMENT '',
  `password` varchar(255) NOT NULL DEFAULT '0' COMMENT '',
  `cookie` text DEFAULT NULL COMMENT '',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '',
  `total_times` int NOT NULL DEFAULT '0' COMMENT '总的使用次数',
  `usage_times_of_day` int NOT NULL DEFAULT '0' COMMENT '当天使用的次数',
  `price` decimal(5,2) NOT NULL DEFAULT '0.00' COMMENT '价格',
  PRIMARY KEY (`id`),
  KEY `create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 站点帐号权限 Site account permissions

CREATE TABLE `site_account_permissions` (
  `id` bigint(20) unsigned NOT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `del_flag` tinyint(1) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `site_account_id` bigint(20) NOT NULL,
  `type` tinyint NOT NULL DEFAULT '0' COMMENT '',
  `times` int NOT NULL DEFAULT '0' COMMENT '次数',
  `total_times` int NOT NULL DEFAULT '0' COMMENT '总使用次数',
  `usage_times_of_day` int NOT NULL DEFAULT '0' COMMENT '当天使用次数',
   `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 请求用户表 Request user table

CREATE TABLE `request_user` (
  `id` bigint(20) unsigned NOT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `del_flag` tinyint(1) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `account` varchar(255) NOT NULL DEFAULT '0' COMMENT '',
  `password` varchar(255) NOT NULL DEFAULT '0' COMMENT '',
  `salt_value` varchar(255) DEFAULT NULL COMMENT '盐值',
  PRIMARY KEY (`id`),
  KEY `create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 记录 record

CREATE TABLE `record` (
  `id` bigint(20) unsigned NOT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `del_flag` tinyint(1) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `site_id` bigint(20) NOT NULL COMMENT '站点id',
  `site_account_id` bigint(20) NOT NULL COMMENT '站点帐号id',
  `request_user_id` bigint(20) NOT NULL COMMENT '请求用户id',
  `type` tinyint NOT NULL DEFAULT '0' COMMENT '类型',
  `count_time` int NOT NULL DEFAULT '0' COMMENT '耗费时间',
  `request_address` varchar(512) DEFAULT NULL COMMENT '请求地址',
   `file_address` varchar(512) DEFAULT NULL COMMENT '文件地址',
   `analysis_method` tinyint NOT NULL DEFAULT '0' COMMENT '0-直接解析，1-间接解析',
  PRIMARY KEY (`id`),
  KEY `create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
