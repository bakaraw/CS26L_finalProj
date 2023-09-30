-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 30, 2023 at 05:58 PM
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
('2023-09-28', 1001, 'Keychron K2 Non-Backlight Wireless Mechanical Keyboard', 'Stock in', 10, 'Laighton', ''),
('2023-09-28', 1002, 'LOGITECH G102 LIGHTSYNC RGB GAMING MOUSE', 'Stock in', 10, 'Laighton', ''),
('2023-09-28', 1003, 'Intel Core i7-870 2.93GHz Quad-Core', 'Stock in', 20, 'Laighton', ''),
('2023-09-28', 1003, 'Intel Core i7-870 2.93GHz Quad-Core', 'Deleted product', 20, 'Laighton', ''),
('2023-09-28', 3211, 'Intel Core i7-870 2.93GHz Quad-Core', 'Stock in', 50, 'Laighton', ''),
('2023-09-28', 3211, 'Intel Core i7-870 2.93GHz Quad-Core', 'Stock in', 30, 'laighton', 'none'),
('2023-09-28', 1001, 'Keychron K2 Non-Backlight Wireless Mechanical Keyboard', 'Stock in', 10, 'laighton', 's'),
('2023-09-28', 1001, 'Keychron K2 Non-Backlight Wireless Mechanical Keyboard', 'Stock in', 10, 'laighton', 'none'),
('2023-09-28', 3211, 'Intel Core i7-870 2.93GHz Quad-Core', 'Stock in', 20, 'Laighton', 'none'),
('2023-09-28', 3211, 'Intel Core i7-870 2.93GHz Quad-Core', 'Stock in', 20, 'Laighton', 'none'),
('2023-09-29', 4321, 'MSI MAG Z790 Tomahawk WiFi', 'Stock in', 5, 'Laighton', 'none'),
('2023-09-29', 4321, 'MSI MAG Z790 Tomahawk WiFi', 'Deleted product', 5, 'Laighton', ''),
('2023-09-29', 4321, 'MSI MAG Z790 Tomahawk WiFi', 'Stock in', 10, 'Laighton', ''),
('2023-09-30', 1003, 'ASUS - NVIDIA Geforce RTX 3060', 'Stock in', 10, 'Laighton', ''),
('2023-09-30', 1004, 'Crucial RAM 4GB DDR4 2400 Mhz ', 'Stock in', 40, 'Laighton', ''),
('2023-09-30', 1005, 'Crucial P3', 'Stock in', 15, 'Laighton', '');

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
  `Storage Device` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `catcomparison`
--

INSERT INTO `catcomparison` (`Date`, `Peripherals`, `CPU`, `GPU`, `Motherboard`, `RAM`, `Storage Device`) VALUES
('2023-09-28', 3, 6, 0, 0, 0, 0),
('2023-09-29', 21, 18, 0, 4, 0, 0),
('2023-09-30', 1, 3, 1, 0, 1, 1);

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
('2023-09-28', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 1) ||', '3599.0', '3599', '0.0'),
('2023-09-28', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 1) ||', '3599.0', '3599', '0.0'),
('2023-09-28', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 1) ||', '3599.0', '3599', '0.0'),
('2023-09-28', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 1) ||', '3599.0', '3599', '0.0'),
('2023-09-28', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 1) ||', '3599.0', '3599', '0.0'),
('2023-09-28', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 1) ||', '3599.0', '3599', '0.0'),
('2023-09-28', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 1) ||', '3599.0', '3599', '0.0'),
('2023-09-28', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 1) ||', '3599.0', '3599', '0.0'),
('2023-09-28', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 1) ||', '3599.0', '3599', '0.0'),
('2023-09-28', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||', '11000.0', '11000', '0.0'),
('2023-09-28', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 1) ||', '3599.0', '3599', '0.0'),
('2023-09-28', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 1) ||', '3599.0', '3599', '0.0'),
('2023-09-28', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 1) ||', '3599.0', '3599', '0.0'),
('2023-09-28', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||', '11000.0', '11000', '0.0'),
('2023-09-28', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 1) ||', '3599.0', '3599.0', '0.0'),
('2023-09-28', 'Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 1) ||', '3200.0', '3200.0', '0.0'),
('2023-09-28', 'Ryzen 5 4600G (price: 11000.0) (qty: 3) ||Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 2) ||', '39400.0', '39400.0', '0.0'),
('2023-09-28', 'Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 2) ||Ryzen 5 4600G (price: 11000.0) (qty: 2) ||', '28400.0', '28400.0', '0.0'),
('2023-09-29', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 2) ||LOGITECH G102 LIGHTSYNC RGB GAMING MOUSE (price: 1050.0) (qty: 2) ||', '9298.0', '9298', '0.0'),
('2023-09-29', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 2) ||Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 1) ||', '10398.0', '10398', '0.0'),
('2023-09-29', 'LOGITECH G102 LIGHTSYNC RGB GAMING MOUSE (price: 1050.0) (qty: 3) ||Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 2) ||', '10348.0', '10348', '0.0'),
('2023-09-29', 'Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 2) ||Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 2) ||', '13598.0', '13598', '0.0'),
('2023-09-29', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 1) ||Ryzen 5 4600G (price: 11000.0) (qty: 3) ||', '36599.0', '36599.0', '0.0'),
('2023-09-29', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 1) ||', '14200.0', '14200', '0.0'),
('2023-09-29', 'Ryzen 5 4600G (price: 11000.0) (qty: 2) ||Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 3) ||', '31600.0', '31600', '0.0'),
('2023-09-29', 'Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 1) ||Ryzen 5 4600G (price: 11000.0) (qty: 1) ||', '14200.0', '14200', '0.0'),
('2023-09-29', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 2) ||', '17400.0', '17400', '0.0'),
('2023-09-29', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 2) ||', '17400.0', '17400', '0.0'),
('2023-09-29', 'Intel Core i7-870 2.93GHz Quad-Core (price: 3599.0) (qty: 3) ||LOGITECH G102 LIGHTSYNC RGB GAMING MOUSE (price: 1050.0) (qty: 2) ||', '12897.0', '12897', '0.0'),
('2023-09-29', 'LOGITECH G102 LIGHTSYNC RGB GAMING MOUSE (price: 1050.0) (qty: 2) ||Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 4) ||', '14900.0', '14900', '0.0'),
('2023-09-29', 'Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 4) ||LOGITECH G102 LIGHTSYNC RGB GAMING MOUSE (price: 1050.0) (qty: 3) ||', '15950.0', '15950', '0.0'),
('2023-09-29', 'Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 2) ||Ryzen 5 4600G (price: 11000.0) (qty: 2) ||', '28400.0', '28400', '0.0'),
('2023-09-29', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 1) ||', '14200.0', '14200', '0.0'),
('2023-09-29', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 1) ||', '14200.0', '14200', '0.0'),
('2023-09-29', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 1) ||MSI MAG Z790 Tomahawk WiFi (price: 17450.0) (qty: 2) ||', '49100.0', '49100', '0.0'),
('2023-09-29', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 1) ||MSI MAG Z790 Tomahawk WiFi (price: 17450.0) (qty: 1) ||', '31650.0', '31650', '0.0'),
('2023-09-29', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 1) ||MSI MAG Z790 Tomahawk WiFi (price: 17450.0) (qty: 1) ||', '31650.0', '31650', '0.0'),
('2023-09-30', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||Crucial RAM 4GB DDR4 2400 Mhz  (price: 850.0) (qty: 1) ||', '11850.0', '11850', '0.0'),
('2023-09-30', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||Keychron K2 Non-Backlight Wireless Mechanical Keyboard (price: 3200.0) (qty: 1) ||', '14200.0', '14200', '0.0'),
('2023-09-30', 'Ryzen 5 4600G (price: 11000.0) (qty: 1) ||Crucial P3 (price: 1500.0) (qty: 1) ||', '12500.0', '12500', '0.0'),
('2023-09-30', 'ASUS - NVIDIA Geforce RTX 3060 (price: 23469.66) (qty: 1) ||', '23469.66', '23469.66', '0.0');

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
('1000', 'Ryzen 5 4600G', 'CPU', 60, 11000),
('1001', 'Keychron K2 Non-Backlight Wireless Mechanical Keyboard', 'Peripherals', 12, 3200),
('1002', 'LOGITECH G102 LIGHTSYNC RGB GAMING MOUSE', 'Peripherals', 14, 1050),
('1003', 'ASUS - NVIDIA Geforce RTX 3060', 'GPU', 9, 23469.66),
('1004', 'Crucial RAM 4GB DDR4 2400 Mhz ', 'RAM', 39, 850),
('1005', 'Crucial P3', 'Storage device', 14, 1500),
('3211', 'Intel Core i7-870 2.93GHz Quad-Core', 'CPU', 100, 3599),
('4321', 'MSI MAG Z790 Tomahawk WiFi', 'Motherboard', 6, 17450);

-- --------------------------------------------------------

--
-- Table structure for table `salesdata`
--

CREATE TABLE `salesdata` (
  `Date` date NOT NULL,
  `Sales` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `salesdata`
--

INSERT INTO `salesdata` (`Date`, `Sales`) VALUES
('2023-09-28', 156087),
('2023-09-29', 387988),
('2023-09-30', 62019.7);

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
