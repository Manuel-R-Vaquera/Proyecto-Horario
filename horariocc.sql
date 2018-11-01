-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Nov 01, 2018 at 12:24 AM
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
-- Table structure for table `Jueves`
--

CREATE TABLE `Jueves` (
  `ID_Clase` int(10) NOT NULL,
  `Maestro` varchar(50) NOT NULL,
  `Aula` varchar(50) NOT NULL,
  `Materia` varchar(100) NOT NULL,
  `Hora` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Lunes`
--

CREATE TABLE `Lunes` (
  `ID_Clase` int(10) NOT NULL,
  `Maestro` varchar(50) NOT NULL,
  `Aula` varchar(50) NOT NULL,
  `Materia` varchar(100) NOT NULL,
  `Hora` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Lunes`
--

INSERT INTO `Lunes` (`ID_Clase`, `Maestro`, `Aula`, `Materia`, `Hora`) VALUES
(1, 'Daniel Arredondo', 'MAC', 'Ingles', 7),
(2, 'Jairo', 'LABSOL', 'Circuitos', 7),
(3, 'Daniel Arredondo', 'Lab1', 'Ingles', 7),
(4, 'Daniel Arredondo', 'Lab2', 'Ingles', 7),
(8, 'Abraham Esquivel', 'MAC', 'Ingles', 8),
(9, 'Antonia Mireles', 'LABSOL', 'Ingles', 8),
(20, 'Antonia Mireles', 'Lab2', 'Lenguajes de Interfaz', 8),
(27, 'Ignacio Salas', 'LABSOL', 'Ingles', 11);

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
(2, 'Ignacio Salas'),
(3, 'Abraham Esquivel'),
(4, 'Antonia Mireles'),
(5, 'Jairo');

-- --------------------------------------------------------

--
-- Table structure for table `Martes`
--

CREATE TABLE `Martes` (
  `ID_Clase` int(10) NOT NULL,
  `Maestro` varchar(50) NOT NULL,
  `Aula` varchar(50) NOT NULL,
  `Materia` varchar(100) NOT NULL,
  `Hora` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `materia`
--

CREATE TABLE `materia` (
  `ID_Materia` int(10) NOT NULL,
  `Nombre_Materia` varchar(50) DEFAULT NULL,
  `Grado` int(2) DEFAULT NULL,
  `Carrera` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `materia`
--

INSERT INTO `materia` (`ID_Materia`, `Nombre_Materia`, `Grado`, `Carrera`) VALUES
(3, 'Ingles', 4, 'ISC'),
(6, 'Circuitos', 4, 'ISC'),
(7, 'Lenguajes de Interfaz', 6, 'ISC');

-- --------------------------------------------------------

--
-- Table structure for table `Miercoles`
--

CREATE TABLE `Miercoles` (
  `ID_Clase` int(10) NOT NULL,
  `Maestro` varchar(50) NOT NULL,
  `Aula` varchar(50) NOT NULL,
  `Materia` varchar(100) NOT NULL,
  `Hora` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Viernes`
--

CREATE TABLE `Viernes` (
  `ID_Clase` int(10) NOT NULL,
  `Maestro` varchar(50) NOT NULL,
  `Aula` varchar(50) NOT NULL,
  `Materia` varchar(100) NOT NULL,
  `Hora` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Indexes for table `Jueves`
--
ALTER TABLE `Jueves`
  ADD PRIMARY KEY (`ID_Clase`);

--
-- Indexes for table `Lunes`
--
ALTER TABLE `Lunes`
  ADD PRIMARY KEY (`ID_Clase`),
  ADD UNIQUE KEY `unico` (`Hora`,`Aula`);

--
-- Indexes for table `maestros`
--
ALTER TABLE `maestros`
  ADD PRIMARY KEY (`ID_Maestro`),
  ADD UNIQUE KEY `ID_Maestro` (`ID_Maestro`),
  ADD KEY `ID_Maestro_2` (`ID_Maestro`);

--
-- Indexes for table `Martes`
--
ALTER TABLE `Martes`
  ADD PRIMARY KEY (`ID_Clase`);

--
-- Indexes for table `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`ID_Materia`),
  ADD UNIQUE KEY `ID_Materia` (`ID_Materia`),
  ADD KEY `ID_Materia_2` (`ID_Materia`);

--
-- Indexes for table `Miercoles`
--
ALTER TABLE `Miercoles`
  ADD PRIMARY KEY (`ID_Clase`);

--
-- Indexes for table `Viernes`
--
ALTER TABLE `Viernes`
  ADD PRIMARY KEY (`ID_Clase`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aula`
--
ALTER TABLE `aula`
  MODIFY `ID_Aula` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `Jueves`
--
ALTER TABLE `Jueves`
  MODIFY `ID_Clase` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Lunes`
--
ALTER TABLE `Lunes`
  MODIFY `ID_Clase` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `maestros`
--
ALTER TABLE `maestros`
  MODIFY `ID_Maestro` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `Martes`
--
ALTER TABLE `Martes`
  MODIFY `ID_Clase` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `materia`
--
ALTER TABLE `materia`
  MODIFY `ID_Materia` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `Miercoles`
--
ALTER TABLE `Miercoles`
  MODIFY `ID_Clase` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Viernes`
--
ALTER TABLE `Viernes`
  MODIFY `ID_Clase` int(10) NOT NULL AUTO_INCREMENT;

