CREATE DATABASE  IF NOT EXISTS `full_stack_student_catalog`;
USE `full_stack_student_catalog`;

DROP TABLE IF EXISTS `students`;

CREATE TABLE `students` (
                `id` INT(11) NOT NULL AUTO_INCREMENT,
                `first_name` VARCHAR(100) NOT NULL,
                `last_name` VARCHAR(100) NOT NULL,
                `ssn` INT(10) NOT NULL,
                PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `userlogin`;

CREATE TABLE `userlogin` (
                `id` INT(11) NOT NULL AUTO_INCREMENT,
                `email` VARCHAR(45) UNIQUE NULL,
                `password` VARCHAR(45) NOT NULL,
                `is_professor` BOOLEAN NOT NULL,
                PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;