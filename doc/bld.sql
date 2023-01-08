/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.40 : Database - bld
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bld` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci */;

USE `bld`;

/*Table structure for table `bld_accept_prize` */

DROP TABLE IF EXISTS `bld_accept_prize`;

CREATE TABLE `bld_accept_prize` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_id` bigint(20) NOT NULL COMMENT '抽奖记录id',
  `phone` varchar(15) COLLATE utf8mb4_german2_ci NOT NULL COMMENT '电话',
  `address` varchar(500) COLLATE utf8mb4_german2_ci NOT NULL COMMENT '地址',
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updater` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `un` (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

/*Table structure for table `bld_activity` */

DROP TABLE IF EXISTS `bld_activity`;

CREATE TABLE `bld_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(100) COLLATE utf8mb4_german2_ci NOT NULL COMMENT '活动名称',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `describe` varchar(500) COLLATE utf8mb4_german2_ci NOT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updater` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

/*Table structure for table `bld_award` */

DROP TABLE IF EXISTS `bld_award`;

CREATE TABLE `bld_award` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prize_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '奖品名称',
  `activity_id` bigint(20) NOT NULL COMMENT '活动id',
  `number` int(11) NOT NULL COMMENT '数量',
  `award_name` varchar(40) COLLATE utf8mb4_german2_ci NOT NULL COMMENT '奖项名称',
  `probability` double NOT NULL COMMENT '概率',
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updater` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

/*Table structure for table `bld_prize` */

DROP TABLE IF EXISTS `bld_prize`;

CREATE TABLE `bld_prize` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prize_name` varchar(20) COLLATE utf8mb4_german2_ci NOT NULL COMMENT '奖品名称',
  `inventory` int(11) NOT NULL COMMENT '库存',
  `money` decimal(10,0) DEFAULT NULL COMMENT '金额',
  `type` int(1) DEFAULT NULL COMMENT '类型（1：商品，2：金钱）',
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updater` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

/*Table structure for table `bld_record` */

DROP TABLE IF EXISTS `bld_record`;

CREATE TABLE `bld_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `activity_id` bigint(20) NOT NULL COMMENT '活动id',
  `activity_name` varchar(100) COLLATE utf8mb4_german2_ci DEFAULT NULL COMMENT '活动名称',
  `award_id` bigint(20) NOT NULL COMMENT '奖项id',
  `is_winning` tinyint(1) DEFAULT '0' COMMENT '是否中奖：0未中奖，1中奖',
  `state` int(11) DEFAULT NULL COMMENT '状态（0，1，2，3）',
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updater` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

/*Table structure for table `bld_rule` */

DROP TABLE IF EXISTS `bld_rule`;

CREATE TABLE `bld_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rule_name` varchar(50) COLLATE utf8mb4_german2_ci NOT NULL COMMENT '规则名称',
  `max_join_number` int(11) NOT NULL COMMENT '最大可参与次数',
  `max_winning_number` int(11) NOT NULL COMMENT '最大可中奖次数',
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updater` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

/*Table structure for table `bld_user` */

DROP TABLE IF EXISTS `bld_user`;

CREATE TABLE `bld_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8mb4_german2_ci NOT NULL COMMENT '账号',
  `password` varchar(100) COLLATE utf8mb4_german2_ci NOT NULL COMMENT '密码',
  `name` varchar(10) COLLATE utf8mb4_german2_ci NOT NULL COMMENT '姓名',
  `phone` varchar(15) COLLATE utf8mb4_german2_ci NOT NULL COMMENT '电话',
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updater` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

/*Table structure for table `bld_user_wallet` */

DROP TABLE IF EXISTS `bld_user_wallet`;

CREATE TABLE `bld_user_wallet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `balance` decimal(20,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updater` varchar(50) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

/*Table structure for table `ld_activity_rule` */

DROP TABLE IF EXISTS `ld_activity_rule`;

CREATE TABLE `ld_activity_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) NOT NULL COMMENT '活动id',
  `rule_id` bigint(20) NOT NULL COMMENT '规则id',
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updater` varchar(10) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `un` (`activity_id`,`rule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
