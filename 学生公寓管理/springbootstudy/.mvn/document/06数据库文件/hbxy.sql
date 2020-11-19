
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mx_app
-- ----------------------------
DROP TABLE IF EXISTS `mx_app`;
CREATE TABLE `mx_app` (
  `app_id` varchar(63) NOT NULL,
  `app_name` varchar(63) DEFAULT NULL,
  `app_code` varchar(63) DEFAULT NULL,
  `app_icon_url` varchar(255) DEFAULT NULL,
  `app_url` varchar(255) DEFAULT NULL,
  `app_developer` varchar(63) DEFAULT NULL,
  `is_admin` varchar(2) DEFAULT NULL COMMENT '是否管理模块：0-否；1-是',
  `order_index` int(11) DEFAULT NULL,
  `comments` varchar(1023) DEFAULT NULL,
  `current_status` char(1) DEFAULT NULL COMMENT '0-正常；1-禁用',
  `created_time` timestamp NULL DEFAULT NULL,
  `created_user_login_id` varchar(63) DEFAULT NULL,
  `last_updated_time` timestamp NULL DEFAULT NULL,
  `last_updated_user_login_id` varchar(63) DEFAULT NULL,
  PRIMARY KEY (`app_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for mx_module
-- ----------------------------
DROP TABLE IF EXISTS `mx_module`;
CREATE TABLE `mx_module` (
  `module_id` varchar(63) NOT NULL,
  `app_id` varchar(63) DEFAULT NULL,
  `app_name` varchar(63) DEFAULT NULL,
  `module_name` varchar(63) DEFAULT NULL,
  `module_code` varchar(63) DEFAULT NULL,
  `module_icon_url` varchar(255) DEFAULT NULL,
  `module_url` varchar(255) DEFAULT NULL,
  `is_admin` varchar(2) DEFAULT NULL COMMENT '是否管理模块：0-否；1-是',
  `need_right` varchar(2) DEFAULT NULL COMMENT '是否需要权限：0-否；1-是',
  `order_index` int(11) DEFAULT NULL,
  `comments` varchar(1023) DEFAULT NULL,
  `current_status` char(1) DEFAULT NULL COMMENT '0-正常；1-禁用',
  `created_time` timestamp NULL DEFAULT NULL,
  `created_user_login_id` varchar(63) DEFAULT NULL,
  `last_updated_time` timestamp NULL DEFAULT NULL,
  `last_updated_user_login_id` varchar(63) DEFAULT NULL,
  PRIMARY KEY (`module_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for mx_org
-- ----------------------------
DROP TABLE IF EXISTS `mx_org`;
CREATE TABLE `mx_org` (
  `org_id` varchar(63) NOT NULL,
  `user_id` varchar(63) NOT NULL,
  `org_name` varchar(63) DEFAULT NULL,
  `org_short_name` varchar(63) DEFAULT NULL,
  `org_code` varchar(63) DEFAULT NULL,
  `order_index` int(11) DEFAULT NULL,
  `parent_org_id` varchar(63) DEFAULT NULL,
  `manager_id` varchar(63) DEFAULT NULL,
  `contact_address` varchar(1023) DEFAULT NULL,
  `office_address` varchar(1023) DEFAULT NULL,
  `num_employees` int(11) DEFAULT NULL,
  `ticker_symbol` varchar(24) DEFAULT NULL,
  `current_status` varchar(1) DEFAULT NULL,
  `comments` varchar(1023) DEFAULT NULL,
  `created_time` timestamp NULL DEFAULT NULL,
  `created_user_login_id` varchar(63) DEFAULT NULL,
  `last_updated_time` timestamp NULL DEFAULT NULL,
  `last_updated_user_login_id` varchar(63) DEFAULT NULL,
  PRIMARY KEY (`org_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for mx_org_person
-- ----------------------------
DROP TABLE IF EXISTS `mx_org_person`;
CREATE TABLE `mx_org_person` (
  `org_person_id` varchar(63) NOT NULL,
  `org_id` varchar(63) DEFAULT NULL,
  `person_id` varchar(63) DEFAULT NULL,
  `from_date` timestamp NULL DEFAULT NULL,
  `thru_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`org_person_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for mx_person
-- ----------------------------
DROP TABLE IF EXISTS `mx_person`;
CREATE TABLE `mx_person` (
  `person_id` varchar(63) NOT NULL,
  `user_id` varchar(63) DEFAULT NULL,
  `full_name` varchar(63) DEFAULT NULL,
  `salutation` varchar(63) DEFAULT NULL COMMENT 'salutation：0-先生；1-女士；2-小姐；4-太太；8-...',
  `last_name` varchar(63) DEFAULT NULL,
  `first_name` varchar(63) DEFAULT NULL,
  `mid_name` varchar(63) DEFAULT NULL,
  `nickname` varchar(63) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL COMMENT 'gender：0-男；1-女；2-...；4-...',
  `personal_title` varchar(63) DEFAULT NULL COMMENT 'personal_title-头衔、职务、职称',
  `birth_date` timestamp NULL DEFAULT NULL,
  `height` decimal(10,0) DEFAULT NULL,
  `weight` decimal(10,0) DEFAULT NULL,
  `marital_status` varchar(2) DEFAULT NULL COMMENT 'marital_status：0-未婚；1-已婚；2-...；4-...',
  `occupation` varchar(63) DEFAULT NULL,
  `comments` varchar(1023) DEFAULT NULL,
  `card_type` varchar(63) DEFAULT NULL COMMENT '0-身份证、1-护照、2-- 、4-- ',
  `card_id` varchar(1023) DEFAULT NULL,
  `entry_date` timestamp NULL DEFAULT NULL COMMENT '入职时间',
  `current_status` varchar(1) DEFAULT NULL COMMENT '0-正常；1-删除',
  `is_system` char(1) DEFAULT '0',
  `order_index` int(11) DEFAULT NULL,
  `created_time` timestamp NULL DEFAULT NULL,
  `created_user_login_id` varchar(63) DEFAULT NULL,
  `last_updated_time` timestamp NULL DEFAULT NULL,
  `last_updated_user_login_id` varchar(63) DEFAULT NULL,
  PRIMARY KEY (`person_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mx_person
-- ----------------------------
BEGIN;
INSERT INTO `mx_person` VALUES ('278617143325626368', '278617143325626368', 'admin', NULL, 'admin', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '1', NULL, '2020-02-08 20:05:03', 'admin', '2020-02-08 20:05:26', 'admin');
COMMIT;

-- ----------------------------
-- Table structure for mx_role
-- ----------------------------
DROP TABLE IF EXISTS `mx_role`;
CREATE TABLE `mx_role` (
  `role_id` varchar(63) NOT NULL,
  `role_name` varchar(63) DEFAULT NULL,
  `role_code` varchar(63) DEFAULT NULL,
  `role_desc` varchar(127) DEFAULT NULL,
  `order_index` int(11) DEFAULT NULL,
  `comments` varchar(1023) DEFAULT NULL,
  `current_status` char(1) DEFAULT NULL COMMENT '0-正常；1-禁用',
  `created_time` timestamp NULL DEFAULT NULL,
  `created_user_login_id` varchar(63) DEFAULT NULL,
  `last_updated_time` timestamp NULL DEFAULT NULL,
  `last_updated_user_login_id` varchar(63) DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for mx_role_right
-- ----------------------------
DROP TABLE IF EXISTS `mx_role_right`;
CREATE TABLE `mx_role_right` (
  `role_right_id` varchar(63) NOT NULL,
  `resource_id` varchar(63) DEFAULT NULL,
  `role_id` varchar(63) DEFAULT NULL,
  PRIMARY KEY (`role_right_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for mx_role_user
-- ----------------------------
DROP TABLE IF EXISTS `mx_role_user`;
CREATE TABLE `mx_role_user` (
  `role_user_id` varchar(63) NOT NULL,
  `role_id` varchar(63) DEFAULT NULL,
  `role_name` varchar(63) DEFAULT NULL,
  `user_id` varchar(63) DEFAULT NULL,
  PRIMARY KEY (`role_user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for mx_user_login
-- ----------------------------
DROP TABLE IF EXISTS `mx_user_login`;
CREATE TABLE `mx_user_login` (
  `user_id` varchar(63) NOT NULL,
  `user_login_id` varchar(63) DEFAULT NULL,
  `user_type` char(1) DEFAULT NULL COMMENT '0-人员；1-组织',
  `current_password` varchar(255) DEFAULT NULL,
  `password_hint` int(11) DEFAULT NULL,
  `password_require_change` char(1) DEFAULT NULL COMMENT 'require_password_change：0-不需要；1-需要',
  `user_name` varchar(63) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `first_name` varchar(40) DEFAULT NULL,
  `is_internal` char(1) DEFAULT NULL COMMENT '0-否；1-是',
  `email` varchar(63) DEFAULT NULL,
  `mobile` varchar(63) DEFAULT NULL,
  `mobile_country_code` varchar(6) DEFAULT NULL,
  `is_system` char(1) DEFAULT NULL COMMENT 'is_system：0-否；1-是',
  `has_logged_out` char(1) DEFAULT NULL COMMENT 'has_logged_out：0-否；1-是',
  `last_locale` varchar(255) DEFAULT NULL,
  `last_time_zone` varchar(31) DEFAULT NULL,
  `current_status` char(1) DEFAULT NULL COMMENT '0-正常；1-禁用',
  `disabled_time` timestamp NULL DEFAULT NULL,
  `disabled_by` varchar(31) DEFAULT NULL COMMENT 'disabled_by：（user_login_id）',
  `created_time` timestamp NULL DEFAULT NULL,
  `created_user_login_id` varchar(63) DEFAULT NULL,
  `last_updated_time` timestamp NULL DEFAULT NULL,
  `last_updated_user_login_id` varchar(63) DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mx_user_login
-- ----------------------------
BEGIN;
INSERT INTO `mx_user_login` VALUES ('278617143325626368', 'admin', '0', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', NULL, NULL, 'admin', 'admin', '', NULL, 'admin@mixone.com.cn', '18688888888', NULL, '1', NULL, NULL, NULL, '0', NULL, NULL, '2020-02-08 20:05:03', 'admin', '2020-02-08 20:17:25', 'admin');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
