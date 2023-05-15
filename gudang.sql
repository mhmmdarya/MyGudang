/*
 Navicat Premium Data Transfer

 Source Server         : belajar
 Source Server Type    : MySQL
 Source Server Version : 100427 (10.4.27-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : gudang

 Target Server Type    : MySQL
 Target Server Version : 100427 (10.4.27-MariaDB)
 File Encoding         : 65001

 Date: 15/05/2023 17:46:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for barang
-- ----------------------------
DROP TABLE IF EXISTS `barang`;
CREATE TABLE `barang`  (
  `id_barang` int NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `jumlah` int NOT NULL,
  `id_supplier` int NOT NULL,
  PRIMARY KEY (`id_barang`) USING BTREE,
  INDEX `id_supplier`(`id_supplier` ASC) USING BTREE,
  CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 116 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of barang
-- ----------------------------

-- ----------------------------
-- Table structure for barang_keluar
-- ----------------------------
DROP TABLE IF EXISTS `barang_keluar`;
CREATE TABLE `barang_keluar`  (
  `id_transaksi` int NOT NULL AUTO_INCREMENT,
  `tanggal_keluar` date NOT NULL,
  `jumlah` int NOT NULL,
  `id_barang` int NOT NULL,
  `id_petugas` int NOT NULL,
  PRIMARY KEY (`id_transaksi`) USING BTREE,
  INDEX `id_barang`(`id_barang` ASC, `id_petugas` ASC) USING BTREE,
  INDEX `id_petugas`(`id_petugas` ASC) USING BTREE,
  CONSTRAINT `barang_keluar_ibfk_1` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `barang_keluar_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of barang_keluar
-- ----------------------------

-- ----------------------------
-- Table structure for barang_masuk
-- ----------------------------
DROP TABLE IF EXISTS `barang_masuk`;
CREATE TABLE `barang_masuk`  (
  `id_transaksi` int NOT NULL AUTO_INCREMENT,
  `jumlah` int NOT NULL,
  `tanggal_masuk` date NOT NULL,
  `id_supplier` int NOT NULL,
  `id_petugas` int NOT NULL,
  `id_barang` int NOT NULL,
  PRIMARY KEY (`id_transaksi`) USING BTREE,
  INDEX `id_supplier`(`id_supplier` ASC, `id_petugas` ASC, `id_barang` ASC) USING BTREE,
  INDEX `id_petugas`(`id_petugas` ASC) USING BTREE,
  INDEX `id_barang`(`id_barang` ASC) USING BTREE,
  CONSTRAINT `barang_masuk_ibfk_1` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `barang_masuk_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `barang_masuk_ibfk_3` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of barang_masuk
-- ----------------------------

-- ----------------------------
-- Table structure for petugas
-- ----------------------------
DROP TABLE IF EXISTS `petugas`;
CREATE TABLE `petugas`  (
  `id_petugas` int NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `jenis_kelamin` enum('Pria','Wanita') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role` enum('Admin','Petugas') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_petugas`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of petugas
-- ----------------------------
INSERT INTO `petugas` VALUES (1, 'Muhammad Arya', 'Pria', 'muhammad@gmail.com', 'admin', 'admin', 'Admin');
INSERT INTO `petugas` VALUES (2, 'Muhammad Imam', 'Pria', 'imam@gmail.com', 'imam', 'admin', 'Petugas');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `id_supplier` int NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `alamat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `no_telp` char(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_supplier`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (1, 'Alice Telecommunication Inc.', '19 Diplomacy Drive', '595363132220');
INSERT INTO `supplier` VALUES (2, 'Tucker\'s Toy LLC', '544 Canal Street', '699534090470');
INSERT INTO `supplier` VALUES (3, 'Coleman Brothers Inc.', '817 Rush Street', '140666464455');
INSERT INTO `supplier` VALUES (4, 'Marshall Logistic LLC', '991 Aigburth Rd, Aigburth', '715914707030');
INSERT INTO `supplier` VALUES (5, 'Carlos LLC', '531 Spring Gardens', '812787495196');
INSERT INTO `supplier` VALUES (6, 'Guzman\'s Food LLC', '962 1st Ave', '720252996174');
INSERT INTO `supplier` VALUES (7, 'Nancy Engineering Inc.', '365 East Alley', '208494738501');
INSERT INTO `supplier` VALUES (8, 'Nguyen Brothers Logistic Inc.', '492 Pollen Street', '349805446252');
INSERT INTO `supplier` VALUES (9, 'Mills Brothers Logistic Inc.', '502 Redfern St', '006560826605');
INSERT INTO `supplier` VALUES (10, 'Carl Trading LLC', '453 Trafalgar Square, Charing Cross', '971118271283');
INSERT INTO `supplier` VALUES (11, 'Harris Electronic Inc.', '973 39 William IV St, Charing Cross', '145950792366');
INSERT INTO `supplier` VALUES (12, 'Paul Consultants Inc.', '806 Hinckley Rd', '804584709471');
INSERT INTO `supplier` VALUES (13, 'Wanda Telecommunication Inc.', '784 1st Ave', '950666757186');
INSERT INTO `supplier` VALUES (14, 'Carolyn Technology Inc.', '23 Lower Temple Street', '432025760207');
INSERT INTO `supplier` VALUES (15, 'Christina LLC', '358 Lower Temple Street', '473809418764');
INSERT INTO `supplier` VALUES (16, 'Medina Brothers LLC', '372 Papworth Rd, Trumpington', '027715197963');
INSERT INTO `supplier` VALUES (17, 'Peggy Electronic LLC', '172 Fifth Avenue', '149867818973');
INSERT INTO `supplier` VALUES (18, 'Turner\'s LLC', '306 Osney Mead', '020308877708');
INSERT INTO `supplier` VALUES (19, 'Timothy Inc.', '574 Wooster Street', '642658422831');
INSERT INTO `supplier` VALUES (20, 'Anthony Engineering Inc.', '205 Flatbush Ave', '094079016368');

-- ----------------------------
-- Triggers structure for table barang_keluar
-- ----------------------------
DROP TRIGGER IF EXISTS `kurangi_stok`;
delimiter ;;
CREATE TRIGGER `kurangi_stok` AFTER INSERT ON `barang_keluar` FOR EACH ROW UPDATE barang SET jumlah = jumlah - NEW.jumlah
WHERE barang.id_barang = NEW.id_barang
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table barang_masuk
-- ----------------------------
DROP TRIGGER IF EXISTS `tambah_stok`;
delimiter ;;
CREATE TRIGGER `tambah_stok` AFTER INSERT ON `barang_masuk` FOR EACH ROW UPDATE barang SET jumlah = jumlah + NEW.jumlah
WHERE barang.id_barang = NEW.id_barang
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
