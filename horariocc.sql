-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 11-10-2018 a las 05:50:52
-- Versión del servidor: 5.6.38-log
-- Versión de PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de datos: `horariocc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula`
--

CREATE TABLE `aula` (
  `ID_Aula` int(10) NOT NULL,
  `Nombre_Aula` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aula`
--

INSERT INTO `aula` (`ID_Aula`, `Nombre_Aula`) VALUES
(1, 'Centro 1'),
(2, 'Aula 3'),
(4, 'LABSOL'),
(6, 'CC2'),
(7, 'Itxcalli'),
(8, 'cc4'),
(9, 'cc5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Clase`
--

CREATE TABLE `Clase` (
  `ID_Clase` int(11) NOT NULL,
  `ID_Aula` int(11) NOT NULL,
  `ID_Materia` int(11) NOT NULL,
  `ID_Maestro` int(11) NOT NULL,
  `Dia` int(2) NOT NULL,
  `Hora` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maestros`
--

CREATE TABLE `maestros` (
  `ID_Maestro` int(10) NOT NULL,
  `Nombre_Maestro` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `maestros`
--

INSERT INTO `maestros` (`ID_Maestro`, `Nombre_Maestro`) VALUES
(1, 'Daniel Arredondo'),
(2, 'Ignacio Salas'),
(3, 'Abraham Esquivel'),
(4, 'Antonia Mireles');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `ID_Materia` int(10) NOT NULL,
  `Nombre_Materia` varchar(50) DEFAULT NULL,
  `Grado` int(2) DEFAULT NULL,
  `Carrera` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`ID_Materia`, `Nombre_Materia`, `Grado`, `Carrera`) VALUES
(3, 'Ingles', 4, 'ISC'),
(6, 'Circuitos', 4, 'ISC');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aula`
--
ALTER TABLE `aula`
  ADD PRIMARY KEY (`ID_Aula`),
  ADD UNIQUE KEY `ID_Aula` (`ID_Aula`),
  ADD KEY `ID_Aula_2` (`ID_Aula`);

--
-- Indices de la tabla `Clase`
--
ALTER TABLE `Clase`
  ADD PRIMARY KEY (`ID_Clase`,`ID_Aula`,`ID_Materia`,`ID_Maestro`),
  ADD KEY `ID_Aula` (`ID_Aula`),
  ADD KEY `ID_Materia` (`ID_Materia`),
  ADD KEY `ID_Maestro` (`ID_Maestro`);

--
-- Indices de la tabla `maestros`
--
ALTER TABLE `maestros`
  ADD PRIMARY KEY (`ID_Maestro`),
  ADD UNIQUE KEY `ID_Maestro` (`ID_Maestro`),
  ADD KEY `ID_Maestro_2` (`ID_Maestro`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`ID_Materia`),
  ADD UNIQUE KEY `ID_Materia` (`ID_Materia`),
  ADD KEY `ID_Materia_2` (`ID_Materia`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aula`
--
ALTER TABLE `aula`
  MODIFY `ID_Aula` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `maestros`
--
ALTER TABLE `maestros`
  MODIFY `ID_Maestro` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `ID_Materia` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Clase`
--
ALTER TABLE `Clase`
  ADD CONSTRAINT `clase_ibfk_1` FOREIGN KEY (`ID_Aula`) REFERENCES `aula` (`ID_Aula`),
  ADD CONSTRAINT `clase_ibfk_2` FOREIGN KEY (`ID_Materia`) REFERENCES `materia` (`ID_Materia`),
  ADD CONSTRAINT `clase_ibfk_3` FOREIGN KEY (`ID_Maestro`) REFERENCES `maestros` (`ID_Maestro`);
