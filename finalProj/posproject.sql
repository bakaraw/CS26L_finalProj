-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 26, 2023 at 11:41 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

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

-- --------------------------------------------------------

--
-- Table structure for table `catcomparison`
--

CREATE TABLE `catcomparison` (
  `Date` date NOT NULL,
  `Peripherals` int(11) NOT NULL,
  `CPU` int(11) NOT NULL,
  `GPU` int(11) NOT NULL,
  `Motherboard` int(11) NOT NULL,
  `RAM` int(11) NOT NULL,
  `StorageDevice` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `clientrecords`
--

CREATE TABLE `clientrecords` (
  `Date` date NOT NULL,
  `Items` varchar(500) NOT NULL,
  `TotalSales` varchar(255) NOT NULL,
  `Amount Payed` varchar(255) NOT NULL,
  `Change_` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clientrecords`
--

INSERT INTO `clientrecords` (`Date`, `Items`, `TotalSales`, `Amount Payed`, `Change_`) VALUES
('2023-09-21', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||', '11000.0', '12000', '1000.0'),
('2023-09-21', 'damns (price: 4500.0) (qty: 3) ||', '13500.0', '13500', '0.0'),
('2023-09-23', 'shoroy (price: 8000.0) (qty: 1) ||', '8000.0', '8000', '0.0'),
('2023-09-23', 'shempoy (price: 5000.0) (qty: 1) ||', '5000.0', '5000', '0.0'),
('2023-09-23', 'shempoy (price: 5000.0) (qty: 1) ||', '5000.0', '5000', '0.0'),
('2023-09-23', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||', '11000.0', '11000', '0.0'),
('2023-09-23', 'shoroy (price: 8000.0) (qty: 1) ||', '8000.0', '8000', '0.0');

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
(7, 'jean jean jean', 'January 1, 2023', 'jean', '123'),
(8, 'jan jana jan', 'January 1, 2023', 'jan', '123');

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
('1000', 'Ryzen 5 4600G', 'CPU', 80, 11000),
('1001', 'shoroy', 'CPU', 20, 8000),
('1002', 'shempoy', 'Peripherals', 100, 5000),
('1234', 'kusgan nga graphics card', 'GPU', 20, 8000),
('9102', 'Mousers', 'Peripherals', 50, 300),
('9231', 'mouse', 'Peripherals', 20, 300),
('9321', 'Keyboard', 'Peripherals', 10, 500),
('9322', 'ssd', 'Storage device', 10, 4500),
('9333', 'fan', 'Peripherals', 80, 8000);

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
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
