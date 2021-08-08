/*
SQLyog - Free MySQL GUI v5.19
Host - 5.5.10 : Database - exam
*********************************************************************
Server version : 5.5.10
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `exam`;

USE `exam`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `adminlogin` */

DROP TABLE IF EXISTS `adminlogin`;

CREATE TABLE `adminlogin` (
  `Id` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `adminlogin` */

insert into `adminlogin` (`Id`,`pass`) values ('saw123','hello123');

/*Table structure for table `exampaperc` */

DROP TABLE IF EXISTS `exampaperc`;

CREATE TABLE `exampaperc` (
  `qusId` int(11) NOT NULL AUTO_INCREMENT,
  `qus` varchar(500) DEFAULT NULL,
  `op1` varchar(500) DEFAULT NULL,
  `op2` varchar(500) DEFAULT NULL,
  `op3` varchar(500) DEFAULT NULL,
  `op4` varchar(500) DEFAULT NULL,
  `ans` int(11) DEFAULT NULL,
  PRIMARY KEY (`qusId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

/*Data for the table `exampaperc` */

insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (1,'Which tab of the display properties windows will you use to change the color quality of your pc?','Screen Saver.','Themes.','Settings.','color.',3);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (2,'hshsh \n hghjs\n sgfusgyhs  hgsjhsg','hgsf','hgsf','hgsf','hgsf',2);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (6,'dfhjegdkjs','hjgsdvfs','hjgsdvfs','hjgsdvfs','hjgsdvfs',3);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (7,'ggggysgkjusgqjhs','jhfgdkjsgfdkjshf','jhfgdkjsgfdkjshf','jhfgdkjsgfdkjshf','jhf',3);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (8,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (9,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (10,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (11,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (12,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (13,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (14,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (15,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (16,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (17,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (18,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (19,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (20,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (21,NULL,NULL,NULL,NULL,NULL,NULL);
insert into `exampaperc` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (22,'kjhvkf','jnfgjds','kfdlkng','nlkfdnl','ndlnb',0);

/*Table structure for table `exampapercpp` */

DROP TABLE IF EXISTS `exampapercpp`;

CREATE TABLE `exampapercpp` (
  `qusId` int(11) NOT NULL AUTO_INCREMENT,
  `qus` varchar(500) DEFAULT NULL,
  `op1` varchar(500) DEFAULT NULL,
  `op2` varchar(500) DEFAULT NULL,
  `op3` varchar(500) DEFAULT NULL,
  `op4` varchar(500) DEFAULT NULL,
  `ans` int(11) DEFAULT NULL,
  PRIMARY KEY (`qusId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `exampapercpp` */

insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (1,'Whicpph tab of the display properties windows will you use to cpphange the cppolor quality of your pcpp?','Scppreen Saver.','Themes.','Settings.','cppolor.',3);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (2,'hshsh \n hghjs\n sgfusgyhs  hgsjhsg','hgsf','hgsf','hgsf','hgsf',2);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (6,'dfhjegdkjs','hjgsdvfs','hjgsdvfs','hjgsdvfs','hjgsdvfs',3);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (7,'ggggysgkjusgqjhs','jhfgdkjsgfdkjshf','jhfgdkjsgfdkjshf','jhfgdkjsgfdkjshf','jhf',3);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (8,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (9,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (10,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (11,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (12,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (13,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (14,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (15,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (16,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (17,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (18,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (19,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapercpp` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (20,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);

/*Table structure for table `exampaperjava` */

DROP TABLE IF EXISTS `exampaperjava`;

CREATE TABLE `exampaperjava` (
  `qusId` int(11) NOT NULL AUTO_INCREMENT,
  `qus` varchar(500) DEFAULT NULL,
  `op1` varchar(500) DEFAULT NULL,
  `op2` varchar(500) DEFAULT NULL,
  `op3` varchar(500) DEFAULT NULL,
  `op4` varchar(500) DEFAULT NULL,
  `ans` int(11) DEFAULT NULL,
  PRIMARY KEY (`qusId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

/*Data for the table `exampaperjava` */

insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (1,'Which tab of the display properties windows will you use to change the color quality of your pc?','Screen Saver.','Themes.','Settings.','color.',3);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (2,'hshsh \n hghjs\n sgfusgyhs  hgsjhsg','hgsf','hgsf','hgsf','hgsf',2);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (6,'dfhjegdkjs','hjgsdvfs','hjgsdvfs','hjgsdvfs','hjgsdvfs',3);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (7,'ggggysgkjusgqjhs','jhfgdkjsgfdkjshf','jhfgdkjsgfdkjshf','jhfgdkjsgfdkjshf','jhf',3);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (8,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (9,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (10,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (11,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (12,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (13,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (14,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (15,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (16,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (17,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (18,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (19,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (20,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampaperjava` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (21,'ghghgh','hgjhj','hghfgnjghjg','jghjgj','jhfkljh',5);

/*Table structure for table `exampapernet` */

DROP TABLE IF EXISTS `exampapernet`;

CREATE TABLE `exampapernet` (
  `qusId` int(11) NOT NULL AUTO_INCREMENT,
  `qus` varchar(500) DEFAULT NULL,
  `op1` varchar(500) DEFAULT NULL,
  `op2` varchar(500) DEFAULT NULL,
  `op3` varchar(500) DEFAULT NULL,
  `op4` varchar(500) DEFAULT NULL,
  `ans` int(11) DEFAULT NULL,
  PRIMARY KEY (`qusId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `exampapernet` */

insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (1,'Whineth tab of the display properties windows will you use to nethange the netolor quality of your pnet?','Snetreen Saver.','Themes.','Settings.','netolor.',3);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (2,'hshsh \n hghjs\n sgfusgyhs  hgsjhsg','hgsf','hgsf','hgsf','hgsf',2);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (6,'dfhjegdkjs','hjgsdvfs','hjgsdvfs','hjgsdvfs','hjgsdvfs',3);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (7,'ggggysgkjusgqjhs','jhfgdkjsgfdkjshf','jhfgdkjsgfdkjshf','jhfgdkjsgfdkjshf','jhf',3);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (8,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (9,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (10,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (11,'fgfdgd','gdfgfdgf','ggdgdgfg','gdgfg','fdgfdg',1);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (12,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (13,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (14,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (15,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (16,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (17,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (18,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (19,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);
insert into `exampapernet` (`qusId`,`qus`,`op1`,`op2`,`op3`,`op4`,`ans`) values (20,'hfghf','fghgfh','gfhgfh','gfhgf','gfh',4);

/*Table structure for table `result` */

DROP TABLE IF EXISTS `result`;

CREATE TABLE `result` (
  `stuId` varchar(50) DEFAULT NULL,
  `StuName` varchar(100) DEFAULT NULL,
  `res` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `result` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `ExamDate` varchar(255) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert into `users` (`userId`,`userName`,`ExamDate`) values (1007,'sawahab','Feb 14, 2014');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
