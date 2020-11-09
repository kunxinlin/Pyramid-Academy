CREATE DATABASE  IF NOT EXISTS `bankapp`;
USE `bankapp`;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
                `id` INT(11) NOT NULL AUTO_INCREMENT,
                `first_name` VARCHAR(100) NOT NULL,
                `last_name` VARCHAR(100) NOT NULL,
                `balance` DECIMAL(12,2) NOT NULL,
                PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `userlogin`;

CREATE TABLE `userlogin` (
                `id` INT(11) NOT NULL AUTO_INCREMENT,
                `email` VARCHAR(45) UNIQUE NULL,
                `password` VARCHAR(45) NOT NULL,
                PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `transactions`;

CREATE TABLE `transactions` (
                `id` INT(11) NOT NULL AUTO_INCREMENT,
                `name` VARCHAR(100) NOT NULL,
                `date` DATE DEFAULT NULL,
                `amount` DECIMAL(12,2) NOT NULL,
                `userID` INT(11) NOT NULL,	
                PRIMARY KEY (`id`),
                FOREIGN KEY (`userID`) REFERENCES users(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;