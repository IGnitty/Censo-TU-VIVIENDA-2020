-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 20-11-2020 a las 14:23:14
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `censadodb`
--
CREATE DATABASE `censadodb` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `censadodb`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `censado`
--

CREATE TABLE IF NOT EXISTS `censado` (
  `cedula` varchar(10) COLLATE utf8_spanish_ci NOT NULL DEFAULT '',
  `nombre` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `sexo` varchar(1) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `aporte_economico` varchar(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipo_vivienda` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `detalle_vivienda` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `luz` varchar(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `agua_potable` varchar(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `agua_servida` varchar(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `censado`
--

INSERT INTO `censado` (`cedula`, `nombre`, `sexo`, `fecha_nacimiento`, `aporte_economico`, `tipo_vivienda`, `detalle_vivienda`, `luz`, `agua_potable`, `agua_servida`, `direccion`) VALUES
('14666329', 'Karina Vega', 'F', '1980-08-05', '1', 'de un familiar', 'Arcilla y bambu', 'SI', 'NO', 'NO', 'lejos'),
('23712612', 'Plinio Lemus', 'M', '1977-05-19', '1', 'propia', 'Ladrillo', 'SI', 'SI', 'SI', 'Aun mas lejos que los de abajo'),
('26576457', 'Eliecer Lemus', 'M', '1997-09-27', '4', 'propia', 'Ladrillo', 'SI', 'SI', 'SI', 'Zona colonial de petare'),
('29935658', 'Marquez Sebastian', 'M', '2002-05-17', '2', 'de un familiar', 'Ladrillo', 'SI', 'SI', 'SI', 'Guatire a lo lejos');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
