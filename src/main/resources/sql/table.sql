CREATE TABLE if not exists `tb_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255)   DEFAULT NULL,
  `group_authority` varchar(255)   DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;


CREATE TABLE if not exists `tb_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(255)   DEFAULT NULL,
  `task_keys` text  ,
  `task_create_user_id` varchar(255)   DEFAULT NULL,
  `task_authority` varchar(255)   DEFAULT NULL,
  `task_file_url` varchar(255)   DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `task_tag` varchar(255)   DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;


CREATE TABLE if not exists `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255)   DEFAULT NULL,
  `user_account` varchar(255)   DEFAULT NULL,
  `user_password` varchar(255)   DEFAULT NULL,
  `user_name` varchar(255)   DEFAULT NULL,
  `user_authority` varchar(255)   DEFAULT NULL,
  `is_group_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

