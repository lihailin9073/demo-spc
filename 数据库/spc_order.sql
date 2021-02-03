/*
Navicat MySQL Data Transfer

Source Server         : mysql-124
Source Server Version : 80021
Source Host           : 192.168.1.124:3306
Source Database       : spc_order

Target Server Type    : MYSQL
Target Server Version : 80021
File Encoding         : 65001

Date: 2020-12-25 18:51:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `detail_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '当前价格,单位分',
  `product_quantity` int NOT NULL COMMENT '数量',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`detail_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('045cd3af-02fe-4479-acf0-cd6a6eca086f', '553c1078-a5b3-4138-8932-f2de10683891', '157875196366160022', '皮蛋瘦肉粥', '3.50', '2', 'http://www.baidu.com/logo.jpg', '2020-12-17 21:22:35', '2020-12-17 21:22:35');
INSERT INTO `order_detail` VALUES ('1608604937359/319762', '1608604937047/418698', '157875196366160022', '皮蛋粥', '0.01', '5', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2020-12-22 10:42:16', '2020-12-22 10:42:16');
INSERT INTO `order_detail` VALUES ('1608605386679/983714', '1608605386667/418335', '157875196366160022', '皮蛋粥', '1.01', '2', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2020-12-22 10:49:45', '2020-12-22 10:49:45');
INSERT INTO `order_detail` VALUES ('1608605386681/692459', '1608605386667/418335', '157875227953464068', '慕斯蛋糕', '11.01', '3', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2020-12-22 10:49:45', '2020-12-22 10:49:45');
INSERT INTO `order_detail` VALUES ('1608617350848/427082', '1608617350669/189591', '157875196366160022', '皮蛋粥', '1.01', '2', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2020-12-22 14:09:09', '2020-12-22 14:09:09');
INSERT INTO `order_detail` VALUES ('1608617350882/960405', '1608617350669/189591', '157875227953464068', '慕斯蛋糕', '11.01', '3', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2020-12-22 14:09:09', '2020-12-22 14:09:09');
INSERT INTO `order_detail` VALUES ('1608617352684/766495', '1608617352677/456841', '157875196366160022', '皮蛋粥', '1.01', '2', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2020-12-22 14:09:11', '2020-12-22 14:09:11');
INSERT INTO `order_detail` VALUES ('1608617352685/453007', '1608617352677/456841', '157875227953464068', '慕斯蛋糕', '11.01', '3', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2020-12-22 14:09:11', '2020-12-22 14:09:11');
INSERT INTO `order_detail` VALUES ('1608617354379/611344', '1608617354373/819299', '157875196366160022', '皮蛋粥', '1.01', '2', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2020-12-22 14:09:13', '2020-12-22 14:09:13');
INSERT INTO `order_detail` VALUES ('1608617354381/119202', '1608617354373/819299', '157875227953464068', '慕斯蛋糕', '11.01', '3', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2020-12-22 14:09:13', '2020-12-22 14:09:13');
INSERT INTO `order_detail` VALUES ('1608617355400/920364', '1608617355393/815225', '157875196366160022', '皮蛋粥', '1.01', '2', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2020-12-22 14:09:14', '2020-12-22 14:09:14');
INSERT INTO `order_detail` VALUES ('1608617355402/658263', '1608617355393/815225', '157875227953464068', '慕斯蛋糕', '11.01', '3', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2020-12-22 14:09:14', '2020-12-22 14:09:14');
INSERT INTO `order_detail` VALUES ('1608645087495/977107', '1608645087166/782546', '157875196366160022', '皮蛋粥', '1.01', '2', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2020-12-22 21:51:25', '2020-12-22 21:51:25');
INSERT INTO `order_detail` VALUES ('1608645087527/674955', '1608645087166/782546', '157875227953464068', '慕斯蛋糕', '11.01', '3', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2020-12-22 21:51:25', '2020-12-22 21:51:25');
INSERT INTO `order_detail` VALUES ('1608646777913/369043', '1608646777904/185230', '157875196366160022', '皮蛋粥', '1.01', '2', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2020-12-22 22:19:36', '2020-12-22 22:19:36');
INSERT INTO `order_detail` VALUES ('1608646777948/701559', '1608646777904/185230', '157875227953464068', '慕斯蛋糕', '11.01', '3', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2020-12-22 22:19:36', '2020-12-22 22:19:36');
INSERT INTO `order_detail` VALUES ('1608646779217/669515', '1608646779209/366921', '157875196366160022', '皮蛋粥', '1.01', '2', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2020-12-22 22:19:37', '2020-12-22 22:19:37');
INSERT INTO `order_detail` VALUES ('1608646779218/256720', '1608646779209/366921', '157875227953464068', '慕斯蛋糕', '11.01', '3', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2020-12-22 22:19:37', '2020-12-22 22:19:37');
INSERT INTO `order_detail` VALUES ('1608646780104/761937', '1608646780097/301795', '157875196366160022', '皮蛋粥', '1.01', '2', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2020-12-22 22:19:38', '2020-12-22 22:19:38');
INSERT INTO `order_detail` VALUES ('1608646780105/273508', '1608646780097/301795', '157875227953464068', '慕斯蛋糕', '11.01', '3', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2020-12-22 22:19:38', '2020-12-22 22:19:38');
INSERT INTO `order_detail` VALUES ('1608688080417/142706', '1608688080408/726936', '157875196366160022', '皮蛋粥', '1.01', '2', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2020-12-23 09:47:58', '2020-12-23 09:47:58');
INSERT INTO `order_detail` VALUES ('1608688080450/389965', '1608688080408/726936', '157875227953464068', '慕斯蛋糕', '11.01', '3', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2020-12-23 09:47:58', '2020-12-23 09:47:58');
INSERT INTO `order_detail` VALUES ('1608688081467/123344', '1608688081460/850543', '157875196366160022', '皮蛋粥', '1.01', '2', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2020-12-23 09:47:59', '2020-12-23 09:47:59');
INSERT INTO `order_detail` VALUES ('1608688081468/822322', '1608688081460/850543', '157875227953464068', '慕斯蛋糕', '11.01', '3', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2020-12-23 09:47:59', '2020-12-23 09:47:59');
INSERT INTO `order_detail` VALUES ('1608688082287/733038', '1608688082280/375112', '157875196366160022', '皮蛋粥', '1.01', '2', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2020-12-23 09:48:00', '2020-12-23 09:48:00');
INSERT INTO `order_detail` VALUES ('1608688082289/372545', '1608688082280/375112', '157875227953464068', '慕斯蛋糕', '11.01', '3', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2020-12-23 09:48:00', '2020-12-23 09:48:00');
INSERT INTO `order_detail` VALUES ('1608890094633/553717', '1608890094259/110134', '157875196366160022', '皮蛋粥', '1.01', '2', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2020-12-25 17:54:49', '2020-12-25 17:54:49');
INSERT INTO `order_detail` VALUES ('1608890094679/434971', '1608890094259/110134', '157875227953464068', '慕斯蛋糕', '11.01', '3', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2020-12-25 17:54:49', '2020-12-25 17:54:49');
INSERT INTO `order_detail` VALUES ('1608892361623/801706', '1608892361595/887456', '157875196366160022', '皮蛋粥', '1.01', '2', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2020-12-25 18:32:36', '2020-12-25 18:32:36');
INSERT INTO `order_detail` VALUES ('1608892361656/912654', '1608892361595/887456', '157875227953464068', '慕斯蛋糕', '11.01', '3', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2020-12-25 18:32:36', '2020-12-25 18:32:36');
INSERT INTO `order_detail` VALUES ('99217885-b56f-4312-8cad-104046614413', '553c1078-a5b3-4138-8932-f2de10683891', '157875196366160022', '皮蛋瘦肉粥', '3.50', '2', 'http://www.baidu.com/logo.jpg', '2020-12-17 21:22:49', '2020-12-17 21:22:49');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `buyer_name` varchar(32) NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) NOT NULL COMMENT '买家微信openid',
  `order_amount` decimal(8,2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint NOT NULL DEFAULT '0' COMMENT '订单状态, 默认为新下单',
  `pay_status` tinyint NOT NULL DEFAULT '0' COMMENT '支付状态, 默认未支付',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`order_id`),
  KEY `idx_buyer_openid` (`buyer_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1608216501484/919551', '张三', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '9.90', '0', '0', '2020-12-17 22:48:21', '2020-12-17 22:48:21');
INSERT INTO `order_master` VALUES ('1608216586900/187959', '张三', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '9.90', '0', '0', '2020-12-17 22:49:47', '2020-12-17 22:49:47');
INSERT INTO `order_master` VALUES ('1608216588346/326007', '张三', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '9.90', '0', '0', '2020-12-17 22:49:48', '2020-12-17 22:49:48');
INSERT INTO `order_master` VALUES ('1608216589802/579909', '张三', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '9.90', '0', '0', '2020-12-17 22:49:50', '2020-12-17 22:49:50');
INSERT INTO `order_master` VALUES ('1608216590763/700139', '张三', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '9.90', '0', '0', '2020-12-17 22:49:51', '2020-12-17 22:49:51');
INSERT INTO `order_master` VALUES ('1608216591559/934286', '张三', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '9.90', '0', '0', '2020-12-17 22:49:52', '2020-12-17 22:49:52');
INSERT INTO `order_master` VALUES ('1608604937047/418698', '马云', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '0.05', '0', '0', '2020-12-22 10:42:17', '2020-12-22 10:42:17');
INSERT INTO `order_master` VALUES ('1608605386667/418335', '马云', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '35.05', '0', '0', '2020-12-22 10:49:47', '2020-12-22 10:49:47');
INSERT INTO `order_master` VALUES ('1608617350669/189591', '马云', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '35.05', '0', '0', '2020-12-22 14:09:11', '2020-12-22 14:09:11');
INSERT INTO `order_master` VALUES ('1608617352677/456841', '马云', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '35.05', '0', '0', '2020-12-22 14:09:13', '2020-12-22 14:09:13');
INSERT INTO `order_master` VALUES ('1608617354373/819299', '马云', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '35.05', '0', '0', '2020-12-22 14:09:14', '2020-12-22 14:09:14');
INSERT INTO `order_master` VALUES ('1608617355393/815225', '马云', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '35.05', '0', '0', '2020-12-22 14:09:15', '2020-12-22 14:09:15');
INSERT INTO `order_master` VALUES ('1608645087166/782546', '马云', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '35.05', '0', '0', '2020-12-22 21:51:28', '2020-12-22 21:51:28');
INSERT INTO `order_master` VALUES ('1608646777904/185230', '马云', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '35.05', '0', '0', '2020-12-22 22:19:38', '2020-12-22 22:19:38');
INSERT INTO `order_master` VALUES ('1608646779209/366921', '马云', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '35.05', '0', '0', '2020-12-22 22:19:39', '2020-12-22 22:19:39');
INSERT INTO `order_master` VALUES ('1608646780097/301795', '马云', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '35.05', '0', '0', '2020-12-22 22:19:40', '2020-12-22 22:19:40');
INSERT INTO `order_master` VALUES ('1608688080408/726936', '马云', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '35.05', '0', '0', '2020-12-23 09:48:00', '2020-12-23 09:48:00');
INSERT INTO `order_master` VALUES ('1608688081460/850543', '马云', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '35.05', '0', '0', '2020-12-23 09:48:01', '2020-12-23 09:48:01');
INSERT INTO `order_master` VALUES ('1608688082280/375112', '马云', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '35.05', '0', '0', '2020-12-23 09:48:02', '2020-12-23 09:48:02');
INSERT INTO `order_master` VALUES ('1608890094259/110134', '马云', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '35.05', '0', '0', '2020-12-25 17:54:55', '2020-12-25 17:54:55');
INSERT INTO `order_master` VALUES ('1608892361595/887456', '马云', '13802780104', '广东省，广州市，天河区，科韵路8899号', '684579845sd4fsd686', '35.05', '0', '0', '2020-12-25 18:32:42', '2020-12-25 18:32:42');
INSERT INTO `order_master` VALUES ('553c1078-a5b3-4138-8932-f2de10683891', '张三', '13802780104', '广州，天河区', 'wechat-63b5bc24-dd81-40c5-9faf-a06fdede220a', '99.80', '0', '0', '2020-12-17 21:14:37', '2020-12-17 21:14:37');
INSERT INTO `order_master` VALUES ('7f9637d9-76b7-4b04-9c67-ce80919b3e70', '张三', '13802780104', '广州，天河区', 'wechat-21ff4b14-f97a-48bd-b8ec-2b11a759eb69', '99.80', '0', '0', '2020-12-17 21:13:14', '2020-12-17 21:13:14');
