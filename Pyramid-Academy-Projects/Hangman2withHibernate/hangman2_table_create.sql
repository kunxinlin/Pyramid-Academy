CREATE DATABASE  IF NOT EXISTS `hb_hangman`;
USE `hb_hangman`;

DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `player_name` varchar(45) DEFAULT NULL, 
  `score` int(9) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;