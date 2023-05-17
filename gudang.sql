-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2023 at 12:36 PM
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama`, `jumlah`, `id_supplier`) VALUES
(1, 'Raspberoy pi', 42, 16),
(2, 'Mango', 52, 12),
(3, 'iKiwi', 33, 2),
(4, 'Plqots', 64, 1),
(5, 'Orange', 75, 19),
(6, 'mrape plus', 85, 1),
(7, 'xAppze', 21, 13),
(8, 'Kmwi plus', 68, 16),
(9, 'iRambutxn', 16, 9),
(10, 'xRambutan', 43, 19),
(11, 'Strawberry', 90, 15),
(12, 'Kfwi', 82, 1),
(13, 'Kiwi', 11, 16),
(14, 'iStrawberry', 14, 5),
(15, 'iherry mini', 63, 18),
(16, 'Pluots plus', 60, 2),
(17, 'ambi-Raspberry', 37, 19),
(18, 'Cherry premium', 94, 13),
(19, 'Rambutan mini', 52, 13),
(20, 'Grape', 18, 9);

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
(1, 'Muhammad Arya', 'Pria', 'muhammad@gmail.com', 'admin', 'admin', 'Admin'),
(2, 'Muhammad Imam', 'Pria', 'imam@gmail.com', 'imam', 'admin', 'Petugas');

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
(1, 'Alice Telecommunication Inc.', '19 Diplomacy Drive', '595363132220'),
(2, 'Tucker\'s Toy LLC', '544 Canal Street', '699534090470'),
(3, 'Coleman Brothers Inc.', '817 Rush Street', '140666464455'),
(4, 'Marshall Logistic LLC', '991 Aigburth Rd, Aigburth', '715914707030'),
(5, 'Carlos LLC', '531 Spring Gardens', '812787495196'),
(6, 'Guzman\'s Food LLC', '962 1st Ave', '720252996174'),
(7, 'Nancy Engineering Inc.', '365 East Alley', '208494738501'),
(8, 'Nguyen Brothers Logistic Inc.', '492 Pollen Street', '349805446252'),
(9, 'Mills Brothers Logistic Inc.', '502 Redfern St', '006560826605'),
(10, 'Carl Trading LLC', '453 Trafalgar Square, Charing Cross', '971118271283'),
(11, 'Harris Electronic Inc.', '973 39 William IV St, Charing Cross', '145950792366'),
(12, 'Paul Consultants Inc.', '806 Hinckley Rd', '804584709471'),
(13, 'Wanda Telecommunication Inc.', '784 1st Ave', '950666757186'),
(14, 'Carolyn Technology Inc.', '23 Lower Temple Street', '432025760207'),
(15, 'Christina LLC', '358 Lower Temple Street', '473809418764'),
(16, 'Medina Brothers LLC', '372 Papworth Rd, Trumpington', '027715197963'),
(17, 'Peggy Electronic LLC', '172 Fifth Avenue', '149867818973'),
(18, 'Turner\'s LLC', '306 Osney Mead', '020308877708'),
(19, 'Timothy Inc.', '574 Wooster Street', '642658422831'),
(20, 'Anthony Engineering Inc.', '205 Flatbush Ave', '094079016368');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`),
  ADD KEY `id_supplier` (`id_supplier`);

--
-- Indexes for table `barang_keluar`
--
ALTER TABLE `barang_keluar`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_barang` (`id_barang`,`id_petugas`),
  ADD KEY `id_petugas` (`id_petugas`);

--
-- Indexes for table `barang_masuk`
--
ALTER TABLE `barang_masuk`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_supplier` (`id_supplier`,`id_petugas`,`id_barang`),
  ADD KEY `id_petugas` (`id_petugas`),
  ADD KEY `id_barang` (`id_barang`);

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
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=117;

--
-- AUTO_INCREMENT for table `barang_keluar`
--
ALTER TABLE `barang_keluar`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `barang_masuk`
--
ALTER TABLE `barang_masuk`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `petugas`
--
ALTER TABLE `petugas`
  MODIFY `id_petugas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

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
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`);

--
-- Constraints for table `barang_keluar`
--
ALTER TABLE `barang_keluar`
  ADD CONSTRAINT `barang_keluar_ibfk_1` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`),
  ADD CONSTRAINT `barang_keluar_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`);

--
-- Constraints for table `barang_masuk`
--
ALTER TABLE `barang_masuk`
  ADD CONSTRAINT `barang_masuk_ibfk_1` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`),
  ADD CONSTRAINT `barang_masuk_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `barang_masuk_ibfk_3` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
