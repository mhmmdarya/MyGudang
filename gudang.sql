-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2023 at 07:00 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gudang`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `id_supplier` int(11) NOT NULL
) ;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama`, `jumlah`, `id_supplier`) VALUES
(119, 'Sabun Lifeboy', 55, 1),
(120, 'Gembok', 7, 4);

-- --------------------------------------------------------

--
-- Table structure for table `barang_keluar`
--

CREATE TABLE `barang_keluar` (
  `id_transaksi` int(11) NOT NULL,
  `tanggal_keluar` date NOT NULL,
  `jumlah` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `id_petugas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang_keluar`
--

INSERT INTO `barang_keluar` (`id_transaksi`, `tanggal_keluar`, `jumlah`, `id_barang`, `id_petugas`) VALUES
(2, '2023-05-15', 2, 119, 1),
(3, '2023-05-01', 20, 119, 1),
(7, '2023-05-01', 19, 120, 1),
(8, '2023-05-24', 100, 119, 1);

--
-- Triggers `barang_keluar`
--
DELIMITER $$
CREATE TRIGGER `kurangi_stok` AFTER INSERT ON `barang_keluar` FOR EACH ROW UPDATE barang SET jumlah = jumlah - NEW.jumlah
WHERE barang.id_barang = NEW.id_barang
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `barang_masuk`
--

CREATE TABLE `barang_masuk` (
  `id_transaksi` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tanggal_masuk` date NOT NULL,
  `id_supplier` int(11) NOT NULL,
  `id_petugas` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang_masuk`
--

INSERT INTO `barang_masuk` (`id_transaksi`, `jumlah`, `tanggal_masuk`, `id_supplier`, `id_petugas`, `id_barang`) VALUES
(3, 5, '2023-05-01', 1, 1, 119),
(4, 3, '2023-05-17', 1, 1, 119),
(5, 10, '2023-05-01', 1, 1, 119),
(6, 17, '2023-01-20', 6, 1, 119),
(8, 11, '2023-01-30', 10, 2, 119),
(10, 26, '2023-05-02', 15, 1, 119),
(12, 23, '2023-03-10', 1, 2, 120),
(14, 30, '2023-03-03', 3, 1, 119),
(16, 22, '2023-04-07', 4, 1, 119),
(17, 12, '2023-01-11', 13, 2, 119),
(19, 20, '2023-05-02', 16, 1, 120),
(20, 19, '2023-01-21', 20, 2, 119),
(22, 6, '2023-05-24', 4, 1, 120),
(23, 10, '2023-05-24', 1, 1, 119);

--
-- Triggers `barang_masuk`
--
DELIMITER $$
CREATE TRIGGER `tambah_stok` AFTER INSERT ON `barang_masuk` FOR EACH ROW UPDATE barang SET jumlah = jumlah + NEW.jumlah
WHERE barang.id_barang = NEW.id_barang
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `id_petugas` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jenis_kelamin` enum('Pria','Wanita') NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('Admin','Petugas') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `nama`, `jenis_kelamin`, `email`, `username`, `password`, `role`) VALUES
(1, 'Muhammad Arya', 'Pria', 'muhammad@gmail.com', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'Admin'),
(2, 'Muhammad Imam', 'Pria', 'imam@gmail.com', 'imam', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'Petugas'),
(13, 'Yahya', 'Pria', 'yahya@gmail.com', 'yahya', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `no_telp` char(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `nama`, `alamat`, `no_telp`) VALUES
(1, 'Rita Telecommunication Inc.', '572 Fifth Avenue', '248792022974'),
(2, 'West Brothers LLC', '97 Diplomacy Drive', '992920667481'),
(3, 'Kim Electronic Inc.', '823 Lark Street', '765247922354'),
(4, 'Guzman\'s Pharmaceutical Inc.', '31 Maddox Street', '141010825624'),
(5, 'Owens\'s Electronic Inc.', '559 Central Avenue', '077545119178'),
(6, 'Walter Software LLC', '315 Tremont Road', '473530766230'),
(7, 'Gloria Inc.', '248 Edward Ave, Braunstone Town', '506540617633'),
(8, 'Patel Network Systems LLC', '29 Pollen Street', '689574539283'),
(9, 'Daniel Logistic Inc.', '800 Grape Street', '276383482659'),
(10, 'Donald LLC', '813 Central Avenue', '332561435548'),
(11, 'Anderson Brothers Electronic Inc.', '196 Flatbush Ave', '354183728018'),
(12, 'Connie LLC', '673 Papworth Rd, Trumpington', '979586115459'),
(13, 'Palmer Brothers Pharmaceutical Inc.', '197 Riverview Road', '459078872633'),
(14, 'Jimmy Technology Inc.', '3 New Street', '090819003259'),
(15, 'Butler Inc.', '972 Wooster Street', '045497068851'),
(16, 'Chad Consultants LLC', '593 East Alley', '763123320150'),
(17, 'Hall Communications LLC', '991 Wooster Street', '377743238440'),
(18, 'Herrera\'s Inc.', '166 Sky Way', '690728983332'),
(19, 'Frances Technology LLC', '985 New Street', '388033219650'),
(20, 'Thomas Telecommunication LLC', '540 Abingdon Rd, Cumnor', '225767028215');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`),
  ADD KEY `barang_supp` (`id_supplier`);

--
-- Indexes for table `barang_keluar`
--
ALTER TABLE `barang_keluar`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_barang` (`id_barang`,`id_petugas`),
  ADD KEY `barang_keluar_ibfk_1` (`id_petugas`);

--
-- Indexes for table `barang_masuk`
--
ALTER TABLE `barang_masuk`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_supplier` (`id_supplier`,`id_petugas`,`id_barang`),
  ADD KEY `barang_masuk_ibfk_2` (`id_barang`),
  ADD KEY `barang_masuk_ibfk_1` (`id_petugas`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id_petugas`) USING BTREE;

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `barang_keluar`
--
ALTER TABLE `barang_keluar`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `barang_masuk`
--
ALTER TABLE `barang_masuk`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `petugas`
--
ALTER TABLE `petugas`
  MODIFY `id_petugas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id_supplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_supp` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `barang_keluar`
--
ALTER TABLE `barang_keluar`
  ADD CONSTRAINT `barang_keluar_ibfk_1` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `barang_keluar_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `barang_masuk`
--
ALTER TABLE `barang_masuk`
  ADD CONSTRAINT `barang_masuk_ibfk_1` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `barang_masuk_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `barang_masuk_ibfk_3` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
