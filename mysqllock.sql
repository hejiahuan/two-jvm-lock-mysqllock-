/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.38 : Database - mysqllock
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mysqllock` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `mysqllock`;

/*Table structure for table `lock_record` */

DROP TABLE IF EXISTS `lock_record`;

CREATE TABLE `lock_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `lock_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '锁名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lock_name` (`lock_name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `lock_record` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
