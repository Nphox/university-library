CREATE DATABASE `libraryDB`;
USE libraryDB;

DROP TABLE `Books`;
CREATE TABLE `Books` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`bookName` CHAR(100) NOT NULL,
	`publicationYear` CHAR(4) NOT NULL,
    	`publisher` CHAR(100) NOT NULL,
	PRIMARY KEY(`id`)
);

DROP TABLE `Store`;
CREATE TABLE `Store` (
	`id_book` INT(11) NOT NULL,
	`total_number` INT NOT NULL,
    	`current_number` INT NOT NULL,
	PRIMARY KEY(`id_book`)
);

DROP TABLE `Students`;
CREATE TABLE `Students` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`first_name` CHAR(20) NOT NULL,
    	`last_name` CHAR(30) NOT NULL,
	`phone` CHAR(15) NOT NULL,
	`faculty` CHAR(30) NOT NULL,
    	`group` CHAR(10) NOT NULL,
	PRIMARY KEY(`id`)
);

DROP TABLE `Authors`;
CREATE TABLE `Authors` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`first_name` CHAR(20) NOT NULL,
    	`last_name` CHAR(30) NOT NULL,
	PRIMARY KEY(`id`)
);

DROP TABLE `Book_Instances`;
CREATE TABLE `Book_Instances` (
	`instance_id` INT(11) NOT NULL AUTO_INCREMENT,
	`book_id` INT(11) NOT NULL,
    	`student_id` INT(11) NULL,
	PRIMARY KEY(`instance_id`)
);

DROP TABLE `Authorship`;
CREATE TABLE `Authorship` (
	`author_id` INT(11) NOT NULL,
	`book_id` INT(11) NOT NULL
);
