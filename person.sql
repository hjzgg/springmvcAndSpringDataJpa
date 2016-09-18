/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : springdata

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-09-19 00:28:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` varchar(36) NOT NULL,
  `creationtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(40) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `lastmodifiedtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `dr` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('123213', '2016-09-18 15:40:52', 'fdsf', '23', '2016-09-18 15:40:52', '0');
INSERT INTO `person` VALUES ('402880e856ad7c9e0156ad7e7d2d0000', '2016-09-18 15:40:52', 'hjz', '234', '2016-09-18 15:40:52', '0');
INSERT INTO `person` VALUES ('402880e856ad7c9e0156ad7e83290001', '2016-09-18 15:40:52', 'hjz', '234', '2016-09-18 15:40:52', '0');
INSERT INTO `person` VALUES ('40289681573324760157332664b70000', '2016-09-18 15:40:52', 'lxkdd', '23', '2016-09-18 15:40:52', '0');
INSERT INTO `person` VALUES ('40289681573324760157332c37f60001', '2016-09-18 15:40:52', 'litao', '23', '2016-09-18 15:40:52', '0');
INSERT INTO `person` VALUES ('40289681573324760157333343da0002', '2016-09-18 15:40:52', 'fdsfds', '45', '2016-09-18 15:40:52', '0');
INSERT INTO `person` VALUES ('402896815733247601573338ff9f0003', '2016-09-19 00:15:58', 'fdsjfl', '90', '2016-09-19 00:15:58', '1');
INSERT INTO `person` VALUES ('40289681573324760157333952800004', '2016-09-19 00:15:58', 'renyuan', '213', '2016-09-19 00:15:58', '1');
INSERT INTO `person` VALUES ('40289681573c3b1101573e14fa700000', '2016-09-19 00:15:58', 'lalala', '43', '2016-09-19 00:15:58', '1');
INSERT INTO `person` VALUES ('432432', '2016-09-18 15:40:52', 'fdafa', '123', '2016-09-18 15:40:52', '0');
INSERT INTO `person` VALUES ('545324', '2016-08-10 16:25:02', 'hjz', '24', null, '0');
