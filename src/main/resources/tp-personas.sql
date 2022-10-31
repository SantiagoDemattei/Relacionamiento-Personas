-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-10-2022 a las 00:51:42
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tp-personas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `delegacion`
--

CREATE TABLE `delegacion` (
  `delegacion_id` int(11) NOT NULL,
  `delegacion_delegado` int(11) DEFAULT NULL,
  `delegacion_delegador` int(11) DEFAULT NULL,
  `delegacion_estado` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `persona_id` int(11) NOT NULL,
  `persona_dni` int(11) NOT NULL,
  `persona_nombre` varchar(50) NOT NULL,
  `persona_apellido` varchar(50) NOT NULL,
  `persona_fecha_nacimiento` date DEFAULT NULL,
  `persona_ciudad` varchar(50) DEFAULT NULL,
  `persona_localidad` varchar(50) DEFAULT NULL,
  `persona_foto` longblob DEFAULT NULL,
  `persona_id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`persona_id`, `persona_dni`, `persona_nombre`, `persona_apellido`, `persona_fecha_nacimiento`, `persona_ciudad`, `persona_localidad`, `persona_foto`, `persona_id_usuario`) VALUES
(10, 43990925, 'Santiago', 'Demattei', NULL, NULL, NULL, NULL, 19),
(11, 1, 'Graciela', 'Valls', NULL, NULL, NULL, NULL, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usuario_id` int(11) NOT NULL,
  `usuario_nombre` varchar(50) NOT NULL,
  `usuario_password` varchar(50) NOT NULL,
  `usuario_is_admin` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuario_id`, `usuario_nombre`, `usuario_password`, `usuario_is_admin`) VALUES
(19, 'santijav@hotmail.com.ar', 'hola1234', 1),
(20, 'hola@hola.com', 'hola1234', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `delegacion`
--
ALTER TABLE `delegacion`
  ADD PRIMARY KEY (`delegacion_id`),
  ADD KEY `delegacion_delegado` (`delegacion_delegado`),
  ADD KEY `delegacion_delegador` (`delegacion_delegador`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`persona_id`),
  ADD KEY `persona_id_usuario` (`persona_id_usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuario_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `delegacion`
--
ALTER TABLE `delegacion`
  MODIFY `delegacion_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `persona_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `usuario_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `delegacion`
--
ALTER TABLE `delegacion`
  ADD CONSTRAINT `delegacion_ibfk_1` FOREIGN KEY (`delegacion_delegado`) REFERENCES `persona` (`persona_id`),
  ADD CONSTRAINT `delegacion_ibfk_2` FOREIGN KEY (`delegacion_delegador`) REFERENCES `persona` (`persona_id`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`persona_id_usuario`) REFERENCES `usuario` (`usuario_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
