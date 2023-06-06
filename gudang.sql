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

 Date: 06/06/2023 19:35:27
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
  INDEX `barang_supp`(`id_supplier` ASC) USING BTREE,
  CONSTRAINT `barang_supp` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `CONSTRAINT_1` CHECK (`jumlah` >= 0)
) ENGINE = InnoDB AUTO_INCREMENT = 131 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of barang
-- ----------------------------
INSERT INTO `barang` VALUES (125, 'Sabun', 22, 23);
INSERT INTO `barang` VALUES (126, 'Sabun Cuci Piring', 37, 28);
INSERT INTO `barang` VALUES (127, 'Kursi Plastik', 50, 29);
INSERT INTO `barang` VALUES (128, 'Gunting', 200, 26);
INSERT INTO `barang` VALUES (129, 'Sabun Sunlight', 20, 30);
INSERT INTO `barang` VALUES (130, 'Kursi Besi', 15, 26);

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
  INDEX `barang_keluar_ibfk_1`(`id_petugas` ASC) USING BTREE,
  CONSTRAINT `barang_keluar_ibfk_1` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `barang_keluar_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of barang_keluar
-- ----------------------------
INSERT INTO `barang_keluar` VALUES (14, '2023-06-06', 15, 130, 17);

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
  INDEX `barang_masuk_ibfk_2`(`id_barang` ASC) USING BTREE,
  INDEX `barang_masuk_ibfk_1`(`id_petugas` ASC) USING BTREE,
  CONSTRAINT `barang_masuk_ibfk_1` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `barang_masuk_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `barang_masuk_ibfk_3` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of barang_masuk
-- ----------------------------
INSERT INTO `barang_masuk` VALUES (29, 20, '2023-06-06', 26, 17, 130);

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
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of petugas
-- ----------------------------
INSERT INTO `petugas` VALUES (2, 'Muhammad Imam', 'Pria', 'imam@gmail.com', 'imam', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'Petugas');
INSERT INTO `petugas` VALUES (13, 'Yahya', 'Pria', 'yahya@gmail.com', 'yahya', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'Admin');
INSERT INTO `petugas` VALUES (16, 'Rohman', 'Pria', 'rohman@gmail.com', 'rohman', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'Petugas');
INSERT INTO `petugas` VALUES (17, 'Muhammad Arya Kusuma', 'Pria', 'muhammad@gmail.com', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'Admin');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `id_supplier` int NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `alamat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `no_telp` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_supplier`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (22, 'PT.Sumur Abadi', 'Jl. Kecapi Barat', '341225137');
INSERT INTO `supplier` VALUES (23, 'PT.Sabar Subur', 'Jl. Angsana Bara', '435454353');
INSERT INTO `supplier` VALUES (24, 'PT.Cipta Karya', 'Jl.Pinangsia 2', '324353464');
INSERT INTO `supplier` VALUES (25, 'PT.Aman Sentosa', 'Jl.Keabadian 4', '654765887');
INSERT INTO `supplier` VALUES (26, 'PT.Kencana Sumatra', 'Jl.SumurBatu 7', '078886563');
INSERT INTO `supplier` VALUES (27, 'PT.Hifivee', 'Jl.Tambora Raya', '576987544');
INSERT INTO `supplier` VALUES (28, 'PT.Alam Sutra', 'Jl.Bogor Raya ', '230988977');
INSERT INTO `supplier` VALUES (29, 'PT.Angga Dewata', 'Jl.Gunung Sahari Raya', '769586765');
INSERT INTO `supplier` VALUES (30, 'PT.LamongSewu', 'Jl.PemalangKota', '654896564');
INSERT INTO `supplier` VALUES (31, 'PT.AbadiJaya', 'Jl.KemurnianRaya', '965807965');
INSERT INTO `supplier` VALUES (32, 'PT. Murni Jaya', 'JL. Sunter', '08123123');

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
