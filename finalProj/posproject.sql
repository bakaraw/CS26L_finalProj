-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 09, 2023 at 11:49 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `posproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `activitylogs`
--

CREATE TABLE `activitylogs` (
  `Date` date NOT NULL,
  `SKU` int(15) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Activity` varchar(255) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Changed by` varchar(255) NOT NULL,
  `Remarks` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `activitylogs`
--

INSERT INTO `activitylogs` (`Date`, `SKU`, `Description`, `Activity`, `Qty`, `Changed by`, `Remarks`) VALUES
('2023-03-06', 1, 'Ryzen 5 4600G', 'Stock in', 50, 'Sean', ''),
('2023-03-06', 2, 'NVIDIA GTX 1080i', 'Stock in', 50, 'Sean', ''),
('2023-03-06', 3, 'Gigabyte a320M', 'Stock in', 50, 'Sean', ''),
('2023-03-06', 4, 'Maxsun 4GB M2', 'Stock in', 50, 'Sean', ''),
('2023-03-06', 5, 'Dell M4A1 Mechanical Keyboard', 'Stock in', 50, 'Laighton', ''),
('2023-03-06', 6, 'Samsung 1TB SSD ', 'Stock in', 50, 'Laighton', ''),
('2023-03-06', 1234, '4gb ram', 'Stock in', 10, 'Laighton', ''),
('2023-08-17', 1, 'Ryzen 5 4600G', 'Stock in', 50, 'laighton', '');

-- --------------------------------------------------------

--
-- Table structure for table `clientrecords`
--

CREATE TABLE `clientrecords` (
  `Date` date NOT NULL,
  `Items` varchar(500) NOT NULL,
  `Total Sales` varchar(255) NOT NULL,
  `Amount Payed` varchar(255) NOT NULL,
  `Change_` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clientrecords`
--

INSERT INTO `clientrecords` (`Date`, `Items`, `Total Sales`, `Amount Payed`, `Change_`) VALUES
('2023-03-06', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||NVIDIA GTX 1080i (price: 9000.0) (qty: 1) ||', '20000.0', '25000', '5000.0'),
('2023-08-17', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||NVIDIA GTX 1080i (price: 9000.0) (qty: 5) ||', '56000.0', '60000', '4000.0'),
('2023-08-17', 'Ryzen 5 4600G (price: 11000.0) (qty: 48) ||', '528000.0', '528000.0', '0.0'),
('2023-08-17', 'NVIDIA GTX 1080i (price: 9000.0) (qty: 10) ||NVIDIA GTX 1080i (price: 9000.0) (qty: 4) ||', '126000.0', '126000.0', '0.0');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `ID` int(20) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Birthday` varchar(20) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`ID`, `Name`, `Birthday`, `Username`, `Password`) VALUES
(1, 'Laighton Patagani Bacalso', 'July 25, 2003', 'lai', '123'),
(2, 'Sean Matthew Fronda', 'January 1, 2023', 'sean', '123'),
(4, 'klint y yos', 'January 1, 2023', 'yos', '123'),
(5, 'papapa papap papap', 'January 1, 2023', 'papa', '123'),
(6, 'mama mama mama', 'January 1, 2023', 'mama', '123'),
(7, 'jean jean jean', 'January 1, 2023', 'jean', '123');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `SKU` varchar(11) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Category` varchar(255) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`SKU`, `Description`, `Category`, `Qty`, `Price`) VALUES
('0001', 'Ryzen 5 4600G', 'CPU', 50, 11000),
('0002', 'NVIDIA GTX 1080i', 'GPU', 30, 9000),
('0003', 'Gigabyte a320M', 'Motherboard', 50, 8000),
('0004', 'Maxsun 4GB M2', 'RAM', 50, 7000),
('0005', 'Dell M4A1 Mechanical Keyboard', 'Peripherals', 50, 10000),
('0006', 'Samsung 1TB SSD ', 'Storage device', 50, 5000),
('1234', '4gb ram', 'RAM', 10, 2000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD UNIQUE KEY `sku` (`SKU`),
  ADD UNIQUE KEY `Description` (`Description`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
