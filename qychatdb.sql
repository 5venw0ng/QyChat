/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : qychatdb

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 29/12/2020 15:02:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_msgcontent
-- ----------------------------
DROP TABLE IF EXISTS `tbl_msgcontent`;
CREATE TABLE `tbl_msgcontent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msgid` varchar(60) CHARACTER SET utf8 DEFAULT NULL,
  `action` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `sender` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `fromView` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `tolist` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `tolistView` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `roomid` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `roomidView` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `msgtime` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `msgtype` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `text` text,
  `image` text CHARACTER SET utf8,
  `weapp` text CHARACTER SET utf8,
  `redpacket` text CHARACTER SET utf8,
  `file` text CHARACTER SET utf8,
  `video` text CHARACTER SET utf8,
  `voice` text CHARACTER SET utf8,
  `chatrecord` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `filename` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=297 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tbl_qychat
-- ----------------------------
DROP TABLE IF EXISTS `tbl_qychat`;
CREATE TABLE `tbl_qychat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seq` int(11) DEFAULT NULL,
  `msgid` varchar(255) DEFAULT NULL,
  `publickey_ver` varchar(255) DEFAULT NULL,
  `encrypt_random_key` varchar(1024) DEFAULT NULL,
  `encrypt_chat_msg` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=319 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `userid` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `classNo` int(11) DEFAULT NULL,
  `loginTime` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
