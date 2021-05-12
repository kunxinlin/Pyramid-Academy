CREATE DATABASE  IF NOT EXISTS `full_stack_flashcard`;
USE `full_stack_flashcard`;

DROP TABLE IF EXISTS `flashcard`;

CREATE TABLE `flashcard` (
                `id` INT(11) NOT NULL AUTO_INCREMENT,
                `question` VARCHAR(600) NOT NULL,
                `answer` VARCHAR(600) NOT NULL,
                PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `userlogin`;

CREATE TABLE `userlogin` (
                `id` INT(11) NOT NULL AUTO_INCREMENT,
                `email` VARCHAR(45) NOT NULL,
                `password` VARCHAR(45) NOT NULL,
                PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

