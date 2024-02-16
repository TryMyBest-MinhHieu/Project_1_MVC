-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 23, 2022 at 06:24 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `School`
--
CREATE DATABASE IF NOT EXISTS `School` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `School`;

-- --------------------------------------------------------

--
-- Table structure for table `Course`
--

CREATE TABLE `Course` (
  `CourseID` int(11) NOT NULL,
  `Title` varchar(100) NOT NULL,
  `Credits` int(11) NOT NULL,
  `DepartmentID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Course`
--

INSERT INTO `Course` (`CourseID`, `Title`, `Credits`, `DepartmentID`) VALUES
(1045, 'Calculus', 4, 7),
(1050, 'Chemistry', 4, 1),
(1061, 'Physics', 4, 1),
(2021, 'Composition', 3, 2),
(2030, 'Poetry', 2, 2),
(2042, 'Literature', 4, 2),
(3141, 'Trigonometry', 4, 7),
(4022, 'Microeconomics', 3, 4),
(4041, 'Macroeconomics', 3, 4),
(4061, 'Quantitative', 2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `CourseInstructor`
--

CREATE TABLE `CourseInstructor` (
  `CourseID` int(11) NOT NULL,
  `PersonID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `CourseInstructor`
--

INSERT INTO `CourseInstructor` (`CourseID`, `PersonID`) VALUES
(1045, 5),
(1050, 1),
(1061, 31),
(2021, 27),
(2030, 4),
(2042, 25),
(4022, 18),
(4041, 32),
(4061, 34);

-- --------------------------------------------------------

--
-- Table structure for table `Department`
--

CREATE TABLE `Department` (
  `DepartmentID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Budget` double NOT NULL,
  `StartDate` datetime NOT NULL,
  `Administrator` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Department`
--

INSERT INTO `Department` (`DepartmentID`, `Name`, `Budget`, `StartDate`, `Administrator`) VALUES
(1, 'Engineering', 350000, '2007-09-01 00:00:00', 2),
(2, 'English', 120000, '2007-09-01 00:00:00', 6),
(4, 'Economics', 200000, '2007-09-01 00:00:00', 4),
(7, 'Mathematics', 250000, '2007-09-01 00:00:00', 3);

-- --------------------------------------------------------

--
-- Table structure for table `OfficeAssignment`
--

CREATE TABLE `OfficeAssignment` (
  `InstructorID` int(11) NOT NULL,
  `Location` varchar(50) NOT NULL DEFAULT 'TP.HCM',
  `Timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `OfficeAssignment`
--

INSERT INTO `OfficeAssignment` (`InstructorID`, `Location`, `Timestamp`) VALUES
(1, '17 Smith', '2022-02-23 17:19:21'),
(4, '29 Adams', '2022-02-23 17:19:21'),
(5, '37 Williams', '2022-02-23 17:19:22'),
(18, '143 Smith', '2022-02-23 17:19:22'),
(25, '57 Adams', '2022-02-23 17:19:22'),
(27, '271 Williams', '2022-02-23 17:19:22'),
(31, '131 Smith', '2022-02-23 17:19:22'),
(32, '203 Williams', '2022-02-23 17:19:22'),
(34, '213 Smith', '2022-02-23 17:19:22');

-- --------------------------------------------------------

--
-- Table structure for table `OnlineCourse`
--

CREATE TABLE `OnlineCourse` (
  `CourseID` int(11) NOT NULL,
  `url` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `OnlineCourse`
--

INSERT INTO `OnlineCourse` (`CourseID`, `url`) VALUES
(2021, 'http://www.fineartschool.net/Composition'),
(2030, 'http://www.fineartschool.net/Poetry'),
(3141, 'http://www.fineartschool.net/Trigonometry'),
(4041, 'http://www.fineartschool.net/Macroeconomics');

-- --------------------------------------------------------

--
-- Table structure for table `OnsiteCourse`
--

CREATE TABLE `OnsiteCourse` (
  `CourseID` int(11) NOT NULL,
  `Location` varchar(50) NOT NULL,
  `Days` varchar(50) NOT NULL,
  `Time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `OnsiteCourse`
--

INSERT INTO `OnsiteCourse` (`CourseID`, `Location`, `Days`, `Time`) VALUES
(1045, '121 Smith', 'MWHF', '15:30:00'),
(1050, '123 Smith', 'MTWH', '11:30:00'),
(1061, '234 Smith', 'TWHF', '13:15:00'),
(2042, '225 Adams', 'MTWH', '11:00:00'),
(4022, '23 Williams', 'MWF', '09:00:00'),
(4061, '22 Williams', 'TH', '11:15:00');

-- --------------------------------------------------------

--
-- Table structure for table `Person`
--

CREATE TABLE `Person` (
  `PersonID` int(11) NOT NULL,
  `Lastname` varchar(50) NOT NULL,
  `Firstname` varchar(50) NOT NULL,
  `HireDate` datetime DEFAULT NULL,
  `EnrollmentDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Person`
--

INSERT INTO `Person` (`PersonID`, `Lastname`, `Firstname`, `HireDate`, `EnrollmentDate`) VALUES
(1, 'Abercrombie', 'Kim', '1995-03-11 00:00:00', NULL),
(2, 'Barzdukas', 'Gytis', NULL, '2005-09-01 00:00:00'),
(3, 'Justice', 'Peggy', NULL, '2001-09-01 00:00:00'),
(4, 'Fakhouri', 'Fadi', '2002-08-06 00:00:00', NULL),
(5, 'Harui', 'Roger', '1998-07-01 00:00:00', NULL),
(6, 'Li', 'Yan', NULL, '2002-09-01 00:00:00'),
(7, 'Norman', 'Laura', NULL, '2003-09-01 00:00:00'),
(8, 'Olivotto', 'Nino', NULL, '2005-09-01 00:00:00'),
(9, 'Tang', 'Wayne', NULL, '2005-09-01 00:00:00'),
(10, 'Alonso', 'Meredith', NULL, '2002-09-01 00:00:00'),
(11, 'Lopez', 'Sophia', NULL, '2004-09-01 00:00:00'),
(12, 'Browning', 'Meredith', NULL, '2000-09-01 00:00:00'),
(13, 'Anand', 'Arturo', NULL, '2003-09-01 00:00:00'),
(14, 'Walker', 'Alexandra', NULL, '2000-09-01 00:00:00'),
(15, 'Powell', 'Carson', NULL, '2004-09-01 00:00:00'),
(16, 'Jai', 'Damien', NULL, '2001-09-01 00:00:00'),
(17, 'Carlson', 'Robyn', NULL, '2005-09-01 00:00:00'),
(18, 'Zheng', 'Roger', '2004-02-12 00:00:00', NULL),
(19, 'Bryant', 'Carson', NULL, '2001-09-01 00:00:00'),
(20, 'Suarez', 'Robyn', NULL, '2004-09-01 00:00:00'),
(21, 'Holt', 'Roger', NULL, '2004-09-01 00:00:00'),
(22, 'Alexander', 'Carson', NULL, '2005-09-01 00:00:00'),
(23, 'Morgan', 'Isaiah', NULL, '2001-09-01 00:00:00'),
(24, 'Martin', 'Randall', NULL, '2005-09-01 00:00:00'),
(25, 'Kapoor', 'Candace', '2001-01-15 00:00:00', NULL),
(26, 'Rogers', 'Cody', NULL, '2002-09-01 00:00:00'),
(27, 'Serrano', 'Stacy', '1999-06-01 00:00:00', NULL),
(28, 'White', 'Anthony', NULL, '2001-09-01 00:00:00'),
(29, 'Griffin', 'Rachel', NULL, '2004-09-01 00:00:00'),
(30, 'Shan', 'Alicia', NULL, '2003-09-01 00:00:00'),
(31, 'Stewart', 'Jasmine', '1997-10-12 00:00:00', NULL),
(32, 'Xu', 'Kristen', '2001-07-23 00:00:00', NULL),
(33, 'Gao', 'Erica', NULL, '2003-01-30 00:00:00'),
(34, 'Van Houten', 'Roger', '2000-12-07 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `StudentGrade`
--

CREATE TABLE `StudentGrade` (
  `EnrollmentID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL,
  `StudentID` int(11) NOT NULL,
  `Grade` decimal(3,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `StudentGrade`
--

INSERT INTO `StudentGrade` (`EnrollmentID`, `CourseID`, `StudentID`, `Grade`) VALUES
(1, 2021, 2, '4.00'),
(2, 2030, 2, '3.50'),
(3, 2021, 3, '3.00'),
(4, 2030, 3, '4.00'),
(5, 2021, 6, '2.50'),
(6, 2042, 6, '3.50'),
(7, 2021, 7, '3.50'),
(8, 2042, 7, '4.00'),
(9, 2021, 8, '3.00'),
(10, 2042, 8, '3.00'),
(11, 4041, 9, '3.50'),
(12, 4041, 10, NULL),
(13, 4041, 11, '2.50'),
(14, 4041, 12, NULL),
(15, 4061, 12, NULL),
(16, 4022, 14, '3.00'),
(17, 4022, 13, '4.00'),
(18, 4061, 13, '4.00'),
(19, 4041, 14, '3.00'),
(20, 4022, 15, '2.50'),
(21, 4022, 16, '2.00'),
(22, 4022, 17, NULL),
(23, 4022, 19, '3.50'),
(24, 4061, 20, '4.00'),
(25, 4061, 21, '2.00'),
(26, 4022, 22, '3.00'),
(27, 4041, 22, '3.50'),
(28, 4061, 22, '2.50'),
(29, 4022, 23, '3.00'),
(30, 1045, 23, '1.50'),
(31, 1061, 24, '4.00'),
(32, 1061, 25, '3.00'),
(33, 1050, 26, '3.50'),
(34, 1061, 26, '3.00'),
(35, 1061, 27, '3.00'),
(36, 1045, 28, '2.50'),
(37, 1050, 28, '3.50'),
(38, 1061, 29, '4.00'),
(39, 1050, 30, '3.50'),
(40, 1061, 30, '4.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Course`
--
ALTER TABLE `Course`
  ADD PRIMARY KEY (`CourseID`);

--
-- Indexes for table `CourseInstructor`
--
ALTER TABLE `CourseInstructor`
  ADD PRIMARY KEY (`CourseID`,`PersonID`);

--
-- Indexes for table `Department`
--
ALTER TABLE `Department`
  ADD PRIMARY KEY (`DepartmentID`);

--
-- Indexes for table `OfficeAssignment`
--
ALTER TABLE `OfficeAssignment`
  ADD PRIMARY KEY (`InstructorID`);

--
-- Indexes for table `OnlineCourse`
--
ALTER TABLE `OnlineCourse`
  ADD PRIMARY KEY (`CourseID`);

--
-- Indexes for table `OnsiteCourse`
--
ALTER TABLE `OnsiteCourse`
  ADD PRIMARY KEY (`CourseID`);

--
-- Indexes for table `Person`
--
ALTER TABLE `Person`
  ADD PRIMARY KEY (`PersonID`);

--
-- Indexes for table `StudentGrade`
--
ALTER TABLE `StudentGrade`
  ADD PRIMARY KEY (`EnrollmentID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Course`
--
ALTER TABLE `Course`
  MODIFY `CourseID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4062;

--
-- AUTO_INCREMENT for table `Person`
--
ALTER TABLE `Person`
  MODIFY `PersonID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `StudentGrade`
--
ALTER TABLE `StudentGrade`
  MODIFY `EnrollmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `OnlineCourse`
--
ALTER TABLE `OnlineCourse`
  ADD CONSTRAINT `onlinecourse_ibfk_1` FOREIGN KEY (`CourseID`) REFERENCES `Course` (`CourseID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
