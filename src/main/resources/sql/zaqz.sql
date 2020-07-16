/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : zaqz

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2020-07-17 00:40:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `agent`
-- ----------------------------
DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent` (
  `user_id2` int(11) NOT NULL,
  `agent_id2` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `Use_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id2`,`agent_id2`),
  KEY `FK_Relationship_12` (`user_id`),
  KEY `FK_Relationship_13` (`Use_user_id`),
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_Relationship_13` FOREIGN KEY (`Use_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agent
-- ----------------------------

-- ----------------------------
-- Table structure for `boardroom`
-- ----------------------------
DROP TABLE IF EXISTS `boardroom`;
CREATE TABLE `boardroom` (
  `boardroom_id` int(11) NOT NULL,
  `boardroom_name` varchar(20) DEFAULT NULL,
  `boardroom_url` varchar(255) DEFAULT NULL,
  `space` int(11) DEFAULT NULL,
  `air_condition` datetime DEFAULT NULL,
  PRIMARY KEY (`boardroom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boardroom
-- ----------------------------
INSERT INTO `boardroom` VALUES ('100', '会议室100', null, null, null);

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `department_id` int(11) NOT NULL,
  `depatment_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('10', '董事会');

-- ----------------------------
-- Table structure for `file`
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `Use_user_id` int(11) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_url` varchar(255) DEFAULT NULL,
  `file_size` int(11) DEFAULT NULL,
  `file_share` int(2) NOT NULL,
  PRIMARY KEY (`file_id`),
  KEY `FK_Relationship_18` (`Use_user_id`),
  KEY `FK_Relationship_3` (`user_id`),
  CONSTRAINT `FK_Relationship_18` FOREIGN KEY (`Use_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('3', null, null, 'Administrator.contact', 'C:\\Users\\Administrator\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\EmployeeManagementSystem\\upload\\20200716104121633Administrator.contact', null, '1');
INSERT INTO `file` VALUES ('4', null, null, 'Administrator.contact', 'C:\\Users\\Administrator\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\EmployeeManagementSystem\\upload\\20200716105026750Administrator.contact', null, '1');
INSERT INTO `file` VALUES ('5', null, null, 'Administrator.contact', 'C:\\Users\\Administrator\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\EmployeeManagementSystem\\upload\\20200716114702589Administrator.contact', null, '0');
INSERT INTO `file` VALUES ('6', null, null, '00.workstation.rar', 'C:\\Users\\Administrator\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\EmployeeManagementSystem\\upload\\2020071614013849400.workstation.rar', null, '0');
INSERT INTO `file` VALUES ('7', null, null, 'apache-maven-3.5.0.rar', 'C:\\Users\\Administrator\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\EmployeeManagementSystem\\upload\\20200716142009032apache-maven-3.5.0.rar', null, '0');

-- ----------------------------
-- Table structure for `information`
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `information_id` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `message` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`information_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of information
-- ----------------------------

-- ----------------------------
-- Table structure for `meeting`
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting` (
  `meeting_id` int(11) NOT NULL,
  `boardroom_id` int(11) DEFAULT NULL,
  `meeting_name` varchar(20) DEFAULT NULL,
  `meeting_date` date DEFAULT NULL,
  `meeting_man` varchar(20) DEFAULT NULL,
  `meeting_theme` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`meeting_id`),
  KEY `FK_Relationship_9` (`boardroom_id`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`boardroom_id`) REFERENCES `boardroom` (`boardroom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meeting
-- ----------------------------

-- ----------------------------
-- Table structure for `m_u`
-- ----------------------------
DROP TABLE IF EXISTS `m_u`;
CREATE TABLE `m_u` (
  `user_id` int(11) NOT NULL,
  `meeting_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`meeting_id`),
  KEY `FK_Relationship_8` (`meeting_id`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`meeting_id`) REFERENCES `meeting` (`meeting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_u
-- ----------------------------

-- ----------------------------
-- Table structure for `name_card`
-- ----------------------------
DROP TABLE IF EXISTS `name_card`;
CREATE TABLE `name_card` (
  `name_cardid` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `file_id` int(11) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `department_name` varchar(20) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `post` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`name_cardid`),
  KEY `FK_Relationship_19` (`file_id`),
  KEY `FK_Relationship_20` (`user_id`),
  CONSTRAINT `FK_Relationship_19` FOREIGN KEY (`file_id`) REFERENCES `file` (`file_id`),
  CONSTRAINT `FK_Relationship_20` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of name_card
-- ----------------------------

-- ----------------------------
-- Table structure for `reader`
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `user_id1` int(11) NOT NULL,
  `read_id1` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `Use_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id1`,`read_id1`),
  KEY `FK_Relationship_10` (`user_id`),
  KEY `FK_Relationship_11` (`Use_user_id`),
  CONSTRAINT `FK_Relationship_10` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_Relationship_11` FOREIGN KEY (`Use_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader
-- ----------------------------

-- ----------------------------
-- Table structure for `relationship_5`
-- ----------------------------
DROP TABLE IF EXISTS `relationship_5`;
CREATE TABLE `relationship_5` (
  `information_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`information_id`,`user_id`),
  KEY `FK_Relationship_6` (`user_id`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`information_id`) REFERENCES `information` (`information_id`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of relationship_5
-- ----------------------------

-- ----------------------------
-- Table structure for `reserve`
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve` (
  `reserve_id` int(11) NOT NULL,
  `boardroom_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `reserve_state` varchar(20) DEFAULT NULL,
  `boardroom_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`reserve_id`),
  KEY `FK_Relationship_16` (`user_id`),
  KEY `FK_Relationship_17` (`boardroom_id`),
  CONSTRAINT `FK_Relationship_16` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_Relationship_17` FOREIGN KEY (`boardroom_id`) REFERENCES `boardroom` (`boardroom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reserve
-- ----------------------------

-- ----------------------------
-- Table structure for `scheduling_program`
-- ----------------------------
DROP TABLE IF EXISTS `scheduling_program`;
CREATE TABLE `scheduling_program` (
  `sp_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sp_id`),
  KEY `FK_Relationship_4` (`user_id`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scheduling_program
-- ----------------------------

-- ----------------------------
-- Table structure for `state`
-- ----------------------------
DROP TABLE IF EXISTS `state`;
CREATE TABLE `state` (
  `State_id` int(11) NOT NULL,
  `information_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `sddresser_t` varchar(20) DEFAULT NULL,
  `sddresser_a` varchar(20) DEFAULT NULL,
  `consignee_t` varchar(20) DEFAULT NULL,
  `consignee_a` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`State_id`),
  KEY `FK_Relationship_14` (`user_id`),
  KEY `FK_Relationship_15` (`information_id`),
  CONSTRAINT `FK_Relationship_14` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_Relationship_15` FOREIGN KEY (`information_id`) REFERENCES `information` (`information_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of state
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `boardroom_id` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_sex` varchar(20) DEFAULT NULL,
  `user_age` varchar(10) DEFAULT NULL,
  `post` varchar(20) DEFAULT NULL,
  `self` varchar(20) DEFAULT NULL,
  `hobbies` varchar(20) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `MSN` int(11) DEFAULT NULL,
  `system_role` int(11) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_Relationship_1` (`department_id`),
  KEY `FK_Relationship_2` (`boardroom_id`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`boardroom_id`) REFERENCES `boardroom` (`boardroom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '100', '10', '张三', '男', '1', null, null, null, null, null, null, '1', '123');
