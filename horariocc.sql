-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 20-09-2018 a las 16:47:00
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maestros`
--

CREATE TABLE `maestros` (
  `ID_Maestro` int(10) NOT NULL,
  `Nombre_Maestro` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `ID_Materia` int(10) NOT NULL,
  `Nombre_Materia` varchar(50) DEFAULT NULL,
  `Grado` int(2) DEFAULT NULL,
  `Carrera` varchar(50) DEFAULT NULL,
  `ID_Maestro` int(10) NOT NULL,
  `ID_Aula` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD KEY `ID_Materia_2` (`ID_Materia`),
  ADD KEY `MaestroMateria` (`ID_Maestro`),
  ADD KEY `AulaMateria` (`ID_Aula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aula`
--
ALTER TABLE `aula`
  MODIFY `ID_Aula` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `maestros`
--
ALTER TABLE `maestros`
  MODIFY `ID_Maestro` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `ID_Materia` int(10) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `materia`
--
ALTER TABLE `materia`
  ADD CONSTRAINT `AulaMateria` FOREIGN KEY (`ID_Aula`) REFERENCES `aula` (`ID_Aula`),
  ADD CONSTRAINT `MaestroMateria` FOREIGN KEY (`ID_Maestro`) REFERENCES `maestros` (`ID_Maestro`);
