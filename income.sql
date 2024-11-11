-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-10-2024 a las 00:47:07
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `income`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consulta_departamento`
--

CREATE TABLE `consulta_departamento` (
  `id` int(11) NOT NULL,
  `departamento_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consulta_empleado`
--

CREATE TABLE `consulta_empleado` (
  `id` int(11) NOT NULL,
  `empleado_id` int(11) NOT NULL,
  `departamento_id` int(11) NOT NULL,
  `industria_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `seccion` varchar(80) NOT NULL,
  `industria_id` int(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `id_empleado` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `apellido` varchar(80) NOT NULL,
  `cuit` int(20) NOT NULL,
  `telefono` int(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `direccion` varchar(80) NOT NULL,
  `altura` int(80) NOT NULL,
  `codigo_postal` varchar(80) NOT NULL,
  `ingreso` datetime(6) NOT NULL,
  `egreso` datetime(6) NOT NULL,
  `industria_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `industria`
--

CREATE TABLE `industria` (
  `id_industria` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cuit` int(20) NOT NULL,
  `telefono` int(20) NOT NULL,
  `direccion_web` varchar(80) NOT NULL,
  `email` int(255) NOT NULL,
  `direccion` varchar(80) NOT NULL,
  `altura` int(80) NOT NULL,
  `codigo_postal` int(80) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `apellido` varchar(80) NOT NULL,
  `dni` int(20) NOT NULL,
  `cuit` int(20) NOT NULL,
  `telefono` int(30) NOT NULL,
  `email` varchar(255) NOT NULL,
  `direccion` varchar(80) NOT NULL,
  `altura` int(30) NOT NULL,
  `codigo_postal` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellido`, `dni`, `cuit`, `telefono`, `email`, `direccion`, `altura`, `codigo_postal`) VALUES
(1, 'Pablo Daniel', 'PAGANI', 25099559, 200899559, 357645823, 'pablodpagani76@gmail.com', 'Independencia ', 231, '2432');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `consulta_departamento`
--
ALTER TABLE `consulta_departamento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `consulta_departamento_fk` (`departamento_id`);

--
-- Indices de la tabla `consulta_empleado`
--
ALTER TABLE `consulta_empleado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `empleado_horas_fk` (`empleado_id`),
  ADD KEY `empleado_departamento_fk` (`departamento_id`),
  ADD KEY `empleado_industria` (`industria_id`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`id_departamento`),
  ADD KEY `departamento_fk` (`industria_id`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id_empleado`),
  ADD KEY `industria_empleado_fk` (`industria_id`);

--
-- Indices de la tabla `industria`
--
ALTER TABLE `industria`
  ADD PRIMARY KEY (`id_industria`),
  ADD KEY `industria_fk` (`usuario_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `consulta_departamento`
--
ALTER TABLE `consulta_departamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `consulta_empleado`
--
ALTER TABLE `consulta_empleado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `id_departamento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id_empleado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `industria`
--
ALTER TABLE `industria`
  MODIFY `id_industria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `consulta_departamento`
--
ALTER TABLE `consulta_departamento`
  ADD CONSTRAINT `consulta_departamento_fk` FOREIGN KEY (`departamento_id`) REFERENCES `departamento` (`id_departamento`);

--
-- Filtros para la tabla `consulta_empleado`
--
ALTER TABLE `consulta_empleado`
  ADD CONSTRAINT `empleado_departamento_fk` FOREIGN KEY (`departamento_id`) REFERENCES `departamento` (`id_departamento`),
  ADD CONSTRAINT `empleado_horas_fk` FOREIGN KEY (`empleado_id`) REFERENCES `empleado` (`id_empleado`),
  ADD CONSTRAINT `empleado_industria` FOREIGN KEY (`industria_id`) REFERENCES `industria` (`id_industria`);

--
-- Filtros para la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD CONSTRAINT `departamento_fk` FOREIGN KEY (`industria_id`) REFERENCES `industria` (`id_industria`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `industria_empleado_fk` FOREIGN KEY (`industria_id`) REFERENCES `industria` (`id_industria`);

--
-- Filtros para la tabla `industria`
--
ALTER TABLE `industria`
  ADD CONSTRAINT `industria_fk` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
