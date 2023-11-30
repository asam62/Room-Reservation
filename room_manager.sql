-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 30, 2023 at 09:48 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `room_manager`
--

-- --------------------------------------------------------

--
-- Table structure for table `reservations`
--

CREATE TABLE `reservations` (
  `reservationsID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `roomID` int(11) NOT NULL,
  `reservationNumber` int(20) NOT NULL,
  `fullName` varchar(50) NOT NULL,
  `email` varchar(80) NOT NULL,
  `phoneNo` varchar(20) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `startDate` varchar(45) NOT NULL,
  `endDate` varchar(45) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservations`
--

INSERT INTO `reservations` (`reservationsID`, `userID`, `roomID`, `reservationNumber`, `fullName`, `email`, `phoneNo`, `gender`, `address`, `startDate`, `endDate`, `status`) VALUES
(14, 1, 28, 6285048, 'ASMAU AMINU', 'asmau.aminu52@yahoo.com', '0695769964', '3', '97 boulevard', '2023-08-30', '2023-08-31', 0),
(15, 1, 28, 7938088, 'ASMAU AMINU', 'asmau.aminu52@yahoo.com', '0695769964', '2', '97 boulevard', '2023-08-22', '2023-08-30', 1),
(16, 1, 28, 7748122, 'ASMAU AMINU', 'asmau.aminu52@yahoo.com', '0695769964', 'Select Gender', '97 boulevard', '2023-08-31', '2023-09-03', 0),
(17, 1, 30, 8302287, 'ASMAU AMINU', 'asmau.aminu52@yahoo.com', '0695769964', 'Select Gender', '97 boulevard', '2023-08-30', '2023-09-01', 0),
(18, 1, 33, 446657, 'ASMAU AMINU', 'asmau.aminu52@yahoo.com', '0695769964', 'Select Gender', '97 boulevard', '2023-08-31', '2023-09-07', 0),
(20, 9, 33, 2039501, 'ASMAU AMINU', 'asmau.aminu52@yahoo.com', '0695769968', '3', '97 boulevard', '2023-08-30', '2023-09-02', 1),
(21, 9, 34, 4701959, 'ASMAU AMINU', 'asmau.aminu52@yahoo.com', '0695769968', 'Select Gender', '97 boulevard', '2023-08-31', '2023-09-03', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `RoomID` int(11) NOT NULL,
  `RoomNumber` varchar(10) NOT NULL,
  `Category` varchar(20) NOT NULL,
  `Status` int(11) NOT NULL,
  `Capacity` int(11) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`RoomID`, `RoomNumber`, `Category`, `Status`, `Capacity`, `description`, `image`) VALUES
(33, '78', '4', 0, 2, 'Indulge in the ultimate comfort and sophistication with our Deluxe Rooms. Each room is a sanctuary of elegance and style, designed to provide you with a luxurious retreat after a day .', 'b7.jfif'),
(34, '345', '3', 0, 2, 'Escape to a world of opulence and refinement in our exquisite Luxury Rooms. These thoughtfully designed spaces are a testament to lavish living, where every detail is curated for your pleasure.', 'b8.jfif'),
(35, '90', '2', 1, 2, ' Sink into the plush king-sized bed and enjoy the modern amenities that cater to your every need. The spacious layout offers a separate seating area where you can unwind with a good book or catch up on your favorite shows.', 'b5.jfif'),
(36, '60', '1', 1, 2, 'Enjoy breath taking views of the surrounding landscapes.\r\nUnwind in a serene environment away from the city\'s hustle and bustle.', 'b4.jfif'),
(37, '54', '3', 0, 3, 'Luxury Suite:\r\n\r\nExquisite luxury suite with a separate living area.\r\nOffers a king-sized bed, elegant decor, and premium services.\r\nEnjoy access to a private balcony and a relaxing spa bath.', 'b2.jfif');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `email`, `password`, `role`) VALUES
(2, 'admin', 'aminuhusnah@gmail.com', '12345', 'admin'),
(9, 'nanaah', 'asmau.aminu52@yahoo.com', '123', 'userh'),
(10, 'nanaah', 'asmau.aminu52@yahoo.com', '123', 'userh');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`reservationsID`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`RoomID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `reservations`
--
ALTER TABLE `reservations`
  MODIFY `reservationsID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `RoomID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
