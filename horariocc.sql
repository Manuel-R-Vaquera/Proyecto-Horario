-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-09-2018 a las 23:27:30
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `horariocc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula`
--

CREATE TABLE IF NOT EXISTS `aula` (
  `ID_Aula` int(10) NOT NULL AUTO_INCREMENT,
  `Nombre_Aula` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_Aula`),
  UNIQUE KEY `ID_Aula` (`ID_Aula`),
  KEY `ID_Aula_2` (`ID_Aula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maestros`
--

CREATE TABLE IF NOT EXISTS `maestros` (
  `ID_Maestro` int(10) NOT NULL AUTO_INCREMENT,
  `Nombre_Maestro` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_Maestro`),
  UNIQUE KEY `ID_Maestro` (`ID_Maestro`),
  KEY `ID_Maestro_2` (`ID_Maestro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE IF NOT EXISTS `materia` (
  `ID_Materia` int(10) NOT NULL AUTO_INCREMENT,
  `Nombre_Materia` varchar(50) DEFAULT NULL,
  `Grado` int(2) DEFAULT NULL,
  `Carrera` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_Materia`),
  UNIQUE KEY `ID_Materia` (`ID_Materia`),
  KEY `ID_Materia_2` (`ID_Materia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aula`
--
ALTER TABLE `aula`
  ADD CONSTRAINT `Aula-Materia` FOREIGN KEY (`ID_Aula`) REFERENCES `materia` (`ID_Materia`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `maestros`
--
ALTER TABLE `maestros`
  ADD CONSTRAINT `Maestro-Materia` FOREIGN KEY (`ID_Maestro`) REFERENCES `materia` (`ID_Materia`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `materia`
--
ALTER TABLE `materia`
  ADD CONSTRAINT `Materia-Maestro` FOREIGN KEY (`ID_Materia`) REFERENCES `maestros` (`ID_Maestro`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
