CREATE DATABASE  IF NOT EXISTS `parts_directory`;
USE `parts_directory`;

DROP TABLE IF EXISTS `parts`;
CREATE TABLE `parts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `part_name` varchar(45) DEFAULT NULL, 
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;