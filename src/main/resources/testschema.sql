DROP TABLE IF EXISTS `movies`;

CREATE TABLE `movies` (
	`id` BIGINT AUTO_INCREMENT,
	`title` VARCHAR(255) NOT NULL,
	`genre` VARCHAR(255) NOT NULL,
	`release_year` INT NOT NULL,
	`user_rating` FLOAT NOT NULL,
	PRIMARY KEY(`ID`)
);