CREATE TABLE `user` (
  `user_type` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `school_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `headmaster_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKteg6y4f7orrrdn0unji0wcne` (`headmaster_id`),
  CONSTRAINT `FKteg6y4f7orrrdn0unji0wcne` FOREIGN KEY (`headmaster_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `subject` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `class_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb6jyqgqrown9aqtvovrmt8dxj` (`class_id`),
  CONSTRAINT `FKb6jyqgqrown9aqtvovrmt8dxj` FOREIGN KEY (`class_id`) REFERENCES `school_class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
