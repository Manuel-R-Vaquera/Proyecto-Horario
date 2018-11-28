-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Nov 28, 2018 at 07:42 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `horariocc`
--

-- --------------------------------------------------------

--
-- Table structure for table `aula`
--

CREATE TABLE `aula` (
  `ID_Aula` int(10) NOT NULL,
  `Nombre_Aula` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aula`
--

INSERT INTO `aula` (`ID_Aula`, `Nombre_Aula`) VALUES
(1, 'MAC'),
(2, 'Lab1'),
(3, 'LABSOL'),
(4, 'Lab2'),
(5, 'Lab3');

-- --------------------------------------------------------

--
-- Table structure for table `Clases`
--

CREATE TABLE `Clases` (
  `ID_Clase` int(10) NOT NULL,
  `ID_Aula` int(10) NOT NULL,
  `ID_Materia` int(10) NOT NULL,
  `ID_Maestro` int(10) NOT NULL,
  `Hora` int(2) NOT NULL,
  `Dia` varchar(10) NOT NULL,
  `Disponible` varchar(2) NOT NULL DEFAULT 'No',
  `Suplente` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Clases`
--

INSERT INTO `Clases` (`ID_Clase`, `ID_Aula`, `ID_Materia`, `ID_Maestro`, `Hora`, `Dia`, `Disponible`, `Suplente`) VALUES
(4, 2, 17, 5, 9, 'Lunes', 'No', ''),
(5, 3, 18, 4, 10, 'Lunes', 'No', ''),
(6, 3, 20, 3, 11, 'Lunes', 'No', ''),
(7, 2, 19, 3, 7, 'Martes', 'No', ''),
(8, 3, 20, 3, 8, 'Martes', 'No', ''),
(9, 3, 20, 3, 9, 'Martes', 'No', ''),
(10, 1, 16, 4, 10, 'Martes', 'No', ''),
(11, 1, 16, 4, 7, 'Miercoles', 'No', ''),
(12, 5, 17, 3, 8, 'Miercoles', 'No', ''),
(13, 5, 17, 3, 9, 'Miercoles', 'No', ''),
(14, 4, 21, 1, 10, 'Miercoles', 'No', ''),
(15, 1, 21, 1, 7, 'Jueves', 'No', ''),
(17, 2, 23, 6, 7, 'Lunes', 'No', '');

-- --------------------------------------------------------

--
-- Table structure for table `maestros`
--

CREATE TABLE `maestros` (
  `ID_Maestro` int(10) NOT NULL,
  `Nombre_Maestro` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maestros`
--

INSERT INTO `maestros` (`ID_Maestro`, `Nombre_Maestro`) VALUES
(1, 'Daniel Arredondo'),
(3, 'Abraham Esquivel'),
(4, 'Antonia Mireles'),
(5, 'Jairo Isaac Lira'),
(6, 'Manuel Ignacio Salas');

-- --------------------------------------------------------

--
-- Table structure for table `materia`
--

CREATE TABLE `materia` (
  `ID_Materia` int(10) NOT NULL,
  `Nombre_Materia` varchar(50) DEFAULT NULL,
  `Grado` int(2) DEFAULT NULL,
  `Carrera` varchar(50) DEFAULT NULL,
  `Grupo` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `materia`
--

INSERT INTO `materia` (`ID_Materia`, `Nombre_Materia`, `Grado`, `Carrera`, `Grupo`) VALUES
(16, 'Inglés', 1, 'IA', 'A'),
(17, 'Ing. de Requerimientos', 9, 'ISC', 'B'),
(18, 'Fundamentos de Investigación', 1, 'ISC', 'A'),
(19, 'Lenguajes de Interfaz', 6, 'ISC', 'A'),
(20, 'Circuitos Integrados', 5, 'ISC', 'C'),
(21, 'TBD', 6, 'ISC', 'A'),
(22, 'Taller de Investigación', 7, 'ISC', 'A'),
(23, 'Taller de Ingeniería de Software', 5, 'ITIC', 'A');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aula`
--
ALTER TABLE `aula`
  ADD PRIMARY KEY (`ID_Aula`),
  ADD UNIQUE KEY `ID_Aula` (`ID_Aula`),
  ADD KEY `ID_Aula_2` (`ID_Aula`);

--
-- Indexes for table `Clases`
--
ALTER TABLE `Clases`
  ADD PRIMARY KEY (`ID_Clase`),
  ADD UNIQUE KEY `U1` (`Dia`,`Hora`,`ID_Aula`) USING BTREE,
  ADD UNIQUE KEY `U2` (`ID_Maestro`,`Hora`,`Dia`),
  ADD KEY `ID_Aula` (`ID_Aula`),
  ADD KEY `ID_Materia` (`ID_Materia`);

--
-- Indexes for table `maestros`
--
ALTER TABLE `maestros`
  ADD PRIMARY KEY (`ID_Maestro`),
  ADD UNIQUE KEY `ID_Maestro` (`ID_Maestro`),
  ADD KEY `ID_Maestro_2` (`ID_Maestro`);

--
-- Indexes for table `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`ID_Materia`),
  ADD UNIQUE KEY `ID_Materia` (`ID_Materia`),
  ADD KEY `ID_Materia_2` (`ID_Materia`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aula`
--
ALTER TABLE `aula`
  MODIFY `ID_Aula` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `Clases`
--
ALTER TABLE `Clases`
  MODIFY `ID_Clase` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `maestros`
--
ALTER TABLE `maestros`
  MODIFY `ID_Maestro` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `materia`
--
ALTER TABLE `materia`
  MODIFY `ID_Materia` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Clases`
--
ALTER TABLE `Clases`
  ADD CONSTRAINT `clases_ibfk_1` FOREIGN KEY (`ID_Aula`) REFERENCES `aula` (`ID_Aula`) ON DELETE CASCADE,
  ADD CONSTRAINT `clases_ibfk_2` FOREIGN KEY (`ID_Materia`) REFERENCES `materia` (`ID_Materia`) ON DELETE CASCADE,
  ADD CONSTRAINT `clases_ibfk_3` FOREIGN KEY (`ID_Maestro`) REFERENCES `maestros` (`ID_Maestro`) ON DELETE CASCADE;

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`root`@`localhost` EVENT `reinicio` ON SCHEDULE EVERY 1 WEEK STARTS '2018-11-27 14:58:53' ON COMPLETION NOT PRESERVE ENABLE DO UPDATE Clases
SET Suplente = "", Disponible = "No"$$

DELIMITER ;