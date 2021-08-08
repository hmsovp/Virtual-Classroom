/*
SQLyog - Free MySQL GUI v5.19
Host - 5.5.10 : Database - virtual_db
*********************************************************************
Server version : 5.5.10
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `virtual_db`;

USE `virtual_db`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `admin_table` */

DROP TABLE IF EXISTS `admin_table`;

CREATE TABLE `admin_table` (
  `admin_id` varchar(50) DEFAULT NULL,
  `passwd` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admin_table` */

insert into `admin_table` (`admin_id`,`passwd`) values ('admin','123');

/*Table structure for table `faculty_table` */

DROP TABLE IF EXISTS `faculty_table`;

CREATE TABLE `faculty_table` (
  `Faculty_id` varchar(100) NOT NULL,
  `Faculty_email_id` varchar(100) DEFAULT NULL,
  `Faculty_passwd` varchar(50) DEFAULT NULL,
  `Faculty_name` varchar(100) DEFAULT NULL,
  `Faculty_dob` date DEFAULT NULL,
  `Faculty_gender` varchar(10) DEFAULT NULL,
  `Faculty_phone` varchar(12) DEFAULT NULL,
  `Faculty_address` varchar(100) DEFAULT NULL,
  `Faculty_joining` date DEFAULT NULL,
  `Faculty_qual` varchar(100) DEFAULT NULL,
  `Faculty_spec` varchar(100) DEFAULT NULL,
  `Faculty_desi` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Faculty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `faculty_table` */

insert into `faculty_table` (`Faculty_id`,`Faculty_email_id`,`Faculty_passwd`,`Faculty_name`,`Faculty_dob`,`Faculty_gender`,`Faculty_phone`,`Faculty_address`,`Faculty_joining`,`Faculty_qual`,`Faculty_spec`,`Faculty_desi`) values ('1','neha','123','Neha Rathore','1990-12-30','Female','8765686925','Kanpur','2010-10-03','B. Tech.','CS','Software Engg.');
insert into `faculty_table` (`Faculty_id`,`Faculty_email_id`,`Faculty_passwd`,`Faculty_name`,`Faculty_dob`,`Faculty_gender`,`Faculty_phone`,`Faculty_address`,`Faculty_joining`,`Faculty_qual`,`Faculty_spec`,`Faculty_desi`) values ('2','nidhi','123','Nidhi Maheswari','1991-01-06','Female','9876583421','15','2011-07-15','B. Tech.','CS','SE');
insert into `faculty_table` (`Faculty_id`,`Faculty_email_id`,`Faculty_passwd`,`Faculty_name`,`Faculty_dob`,`Faculty_gender`,`Faculty_phone`,`Faculty_address`,`Faculty_joining`,`Faculty_qual`,`Faculty_spec`,`Faculty_desi`) values ('3','ashish','123','Ashish Singh','1988-04-13','Male','7685948394','12','2012-07-12','B. tech.','C++','Software field');
insert into `faculty_table` (`Faculty_id`,`Faculty_email_id`,`Faculty_passwd`,`Faculty_name`,`Faculty_dob`,`Faculty_gender`,`Faculty_phone`,`Faculty_address`,`Faculty_joining`,`Faculty_qual`,`Faculty_spec`,`Faculty_desi`) values ('4','deshraj','123','Deshraj Shahu','1987-11-15','Male','9456788534','12','2005-08-12','B. Tech.','Compiler Designer','Teaching');
insert into `faculty_table` (`Faculty_id`,`Faculty_email_id`,`Faculty_passwd`,`Faculty_name`,`Faculty_dob`,`Faculty_gender`,`Faculty_phone`,`Faculty_address`,`Faculty_joining`,`Faculty_qual`,`Faculty_spec`,`Faculty_desi`) values ('5','priya','123','Priya Rathore','1991-10-28','Female','9794912729','25','2011-06-25','B. Tech.','CS','TESTING');

/*Table structure for table `schedule_table` */

DROP TABLE IF EXISTS `schedule_table`;

CREATE TABLE `schedule_table` (
  `Faculty_id` varchar(50) NOT NULL,
  `Faculty_name` varchar(50) DEFAULT NULL,
  `Course` varchar(50) DEFAULT NULL,
  `Branch` varchar(50) DEFAULT NULL,
  `Year` varchar(50) DEFAULT NULL,
  `Semester` varchar(50) DEFAULT NULL,
  `Subject` varchar(200) DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `Duration` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `schedule_table` */

insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('2','Nidhi','B. Tech.','CS','3','5','OS','15:15:00','01:15:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('3','Ashish','B. Tech.','IT','4','7','SE','10:00:00','01:15:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('4','Deshraj','B. Tech.','CS','4','7','DM','10:30:00','01:15:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('3','Ashish','B. Tech','IT','3','5','DS','00:00:00','01:15:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('5','Priya Rathore','B. TECH.','CS','3','5','ITIM','01:20:00','01:15:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('5','Priya Rathore','B. TECH.','CS','3','6','OTT','20:00:00','01:15:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('3','Ashish Singh','B. TECH.','CS','3','5','DAA','14:00:00','01:15:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('3','Ashish Singh','B. TECH.','IT','2','3','DS','15:00:00','01:15:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('3','Ashish Singh','B. TECH.','IT','3','5','OS','16:00:00','01:15:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('3','Ashish Singh','B. TECH.','IT','3','6','CN','03:00:00','01:15:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('3','Ashish Singh','B. TECH.','IT','3','7','CD','22:00:00','01:15:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('2','Nidhi','B. Tech.','IT','2','3','WT','00:00:00','01:15:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('2','Nidhi Maheswari','B. TECH.','EC','3','5','EME','09:00:00','00:45:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('1','Neha Rathore','B. Tech.','CS','3','5','DBMS','15:30:00','00:45:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('1','Neha Rathore','B. Tech.','CS','3','5','CN','16:00:00','00:45:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('1','Neha Rathore','B. Tech.','CS','3','5','CD','17:00:00','00:45:00');
insert into `schedule_table` (`Faculty_id`,`Faculty_name`,`Course`,`Branch`,`Year`,`Semester`,`Subject`,`Time`,`Duration`) values ('1','Neha Rathore','B. Tech.','CS','3','5','DC','18:45:00','00:45:00');

/*Table structure for table `student_table` */

DROP TABLE IF EXISTS `student_table`;

CREATE TABLE `student_table` (
  `Student_id` varchar(100) DEFAULT NULL,
  `Student_email_id` varchar(100) DEFAULT NULL,
  `Student_passwd` varchar(50) DEFAULT NULL,
  `Student_name` varchar(100) DEFAULT NULL,
  `Student_dob` date DEFAULT NULL,
  `Student_gender` varchar(10) DEFAULT NULL,
  `Student_phone` varchar(12) DEFAULT NULL,
  `Student_address` varchar(100) DEFAULT NULL,
  `Student_course` varchar(50) DEFAULT NULL,
  `Student_branch` varchar(50) DEFAULT NULL,
  `Student_year` varchar(50) DEFAULT NULL,
  `Student_sem` varchar(50) DEFAULT NULL,
  `Student_status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student_table` */

insert into `student_table` (`Student_id`,`Student_email_id`,`Student_passwd`,`Student_name`,`Student_dob`,`Student_gender`,`Student_phone`,`Student_address`,`Student_course`,`Student_branch`,`Student_year`,`Student_sem`,`Student_status`) values ('a','manshi','123','Manshi','1992-07-25','Female','1234567890','Kanpur','B. Tech.','CS','3','5','false');
insert into `student_table` (`Student_id`,`Student_email_id`,`Student_passwd`,`Student_name`,`Student_dob`,`Student_gender`,`Student_phone`,`Student_address`,`Student_course`,`Student_branch`,`Student_year`,`Student_sem`,`Student_status`) values ('b','deep','123','Deepshekhar','1992-08-10','Male','5636756787','Lucknow','B. Tech.','CS','3','5','false');
insert into `student_table` (`Student_id`,`Student_email_id`,`Student_passwd`,`Student_name`,`Student_dob`,`Student_gender`,`Student_phone`,`Student_address`,`Student_course`,`Student_branch`,`Student_year`,`Student_sem`,`Student_status`) values ('c','rajat','123','Rajat','1990-04-01','Male','9877665543','Aagra','B. Tech.','CS','3','5','false');
insert into `student_table` (`Student_id`,`Student_email_id`,`Student_passwd`,`Student_name`,`Student_dob`,`Student_gender`,`Student_phone`,`Student_address`,`Student_course`,`Student_branch`,`Student_year`,`Student_sem`,`Student_status`) values ('d','prashant','123','Prashant','1991-05-23','Male','0967655445','Bihar','B. Tech.','CS','3','5','false');
insert into `student_table` (`Student_id`,`Student_email_id`,`Student_passwd`,`Student_name`,`Student_dob`,`Student_gender`,`Student_phone`,`Student_address`,`Student_course`,`Student_branch`,`Student_year`,`Student_sem`,`Student_status`) values ('e','nirja','123','Nirja','1991-08-30','Female','9867564544','Kanpur','B. Tech.','CS','3','5','false');
insert into `student_table` (`Student_id`,`Student_email_id`,`Student_passwd`,`Student_name`,`Student_dob`,`Student_gender`,`Student_phone`,`Student_address`,`Student_course`,`Student_branch`,`Student_year`,`Student_sem`,`Student_status`) values ('f','reema','123','Reema','1992-12-05','Female','9786756544','Basti','B. Tech.','CS','3','5','false');
insert into `student_table` (`Student_id`,`Student_email_id`,`Student_passwd`,`Student_name`,`Student_dob`,`Student_gender`,`Student_phone`,`Student_address`,`Student_course`,`Student_branch`,`Student_year`,`Student_sem`,`Student_status`) values ('e','mansi','123','Mansi','1992-07-26','Female','9877565645','Raibareli','B. Tech.','CS','3','5','false');
insert into `student_table` (`Student_id`,`Student_email_id`,`Student_passwd`,`Student_name`,`Student_dob`,`Student_gender`,`Student_phone`,`Student_address`,`Student_course`,`Student_branch`,`Student_year`,`Student_sem`,`Student_status`) values ('f','rahul','123','Rahul','1991-08-15','Male','8766545344','Kanpur','B. Tech.','CS','3','5','false');
insert into `student_table` (`Student_id`,`Student_email_id`,`Student_passwd`,`Student_name`,`Student_dob`,`Student_gender`,`Student_phone`,`Student_address`,`Student_course`,`Student_branch`,`Student_year`,`Student_sem`,`Student_status`) values ('g','vikas','123','Vikas','1992-07-18','Male','5453434242','Lucknow','B. Tech.','CS','3','5','false');
insert into `student_table` (`Student_id`,`Student_email_id`,`Student_passwd`,`Student_name`,`Student_dob`,`Student_gender`,`Student_phone`,`Student_address`,`Student_course`,`Student_branch`,`Student_year`,`Student_sem`,`Student_status`) values ('h','shubhangi','123','Shubhangi','1992-12-25','Female','7564533443','Kanpur','B. Tech.','CS','3','5','false');
insert into `student_table` (`Student_id`,`Student_email_id`,`Student_passwd`,`Student_name`,`Student_dob`,`Student_gender`,`Student_phone`,`Student_address`,`Student_course`,`Student_branch`,`Student_year`,`Student_sem`,`Student_status`) values ('i','manoj','123','Manoj Kumar','1990-05-13','Male','8767564534','Kanpur','B. Tech.','CS','4','7','true');
insert into `student_table` (`Student_id`,`Student_email_id`,`Student_passwd`,`Student_name`,`Student_dob`,`Student_gender`,`Student_phone`,`Student_address`,`Student_course`,`Student_branch`,`Student_year`,`Student_sem`,`Student_status`) values ('j','divya','123','Divya Yadav','1991-05-14','female','8675474398','Kanpur','B. Tech.','CS','4','7','false');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
