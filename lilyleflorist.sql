/*
Navicat MySQL Data Transfer

Source Server         : Local MySQL Server
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : lilyleflorist

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-06-17 20:30:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `customerId` bigint(20) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `phoneNumber` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT '0',
  `goldmember` int(1) NOT NULL,
  `password` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `buyingNumber` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of customers
-- ----------------------------
INSERT INTO `customers` VALUES ('1', '1', '1', '1', null, '0', '$2a$11$KbehwEvs.6DdUpxUqUUXYOmOpTHgsgfiWJMa.q92lkVyPCNm/.5BC', '1');
INSERT INTO `customers` VALUES ('2', 'thanh', '0905360032', '123', null, '1', '$2a$11$06bPfSqyF15YwBMmGRKJnuBCqthJYO2DmjgZHeZ3SOfBAqxMEuGZe', '100');

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `productId` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `productName` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `productPrice` decimal(10,0) NOT NULL,
  `productDescription` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of products
-- ----------------------------

-- ----------------------------
-- Table structure for stocks
-- ----------------------------
DROP TABLE IF EXISTS `stocks`;
CREATE TABLE `stocks` (
  `stockId` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `productId` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `numberInStock` int(11) DEFAULT NULL,
  PRIMARY KEY (`stockId`,`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stocks
-- ----------------------------
