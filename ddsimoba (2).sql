-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 23-12-2019 a las 07:00:09
-- Versión del servidor: 8.0.18
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ddsimoba`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentapertenece`
--

CREATE TABLE `cuentapertenece` (
  `nombre` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `idequipo` smallint(6) NOT NULL,
  `contrasena` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `correo` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `fec_nac` date NOT NULL,
  `servidor` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `saldo` smallint(6) DEFAULT '0',
  `karma` smallint(6) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuentapertenece`
--

INSERT INTO `cuentapertenece` (`nombre`, `idequipo`, `contrasena`, `correo`, `fec_nac`, `servidor`, `saldo`, `karma`) VALUES
('domin', 1, 'mipass1', 'domingo@correOO.ugr.es', '2019-08-06', 'EU', 500, 10),
('fibonacci', 2, '0112358', 'fibo@correo.ugr.es', '2016-07-12', 'EU', 356, 22),
('haterxd', 3, 'soyunhaterxd', 'hater@correo.ugr.es', '2018-01-10', 'EU', 1220, 88),
('holhol', 2, 'asdfasf', 'dfesf@idlfij', '2018-07-07', 'EU', 0, 0),
('jesus', 4, 'holaestaesmipass', 'jesus@correo.ugr.es', '2018-07-17', 'EU', 1000, 5),
('jose', 2, 's937492', 'jose@correo.ugr.es', '2018-04-09', 'EU', 3309, 45),
('juan', 3, 'realmadrid666', 'juan@correo.ugr.es', '2019-01-08', 'EU', 178, 1),
('luisito23', 2, 'holasoyluis', 'luis@correo.ugr.es', '2016-06-14', 'EU', 578, 10),
('noelia', 3, 'salkfiehwo', 'noelia@correo.ugr.es', '2018-03-13', 'EU', 0, 0),
('pablo', 1, 'nopuedodecirmipass', 'pablo@correo.ugr.es', '2017-08-09', 'EU', 0, 0),
('pedrion', 2, 'holapedrion', 'pedrion@hola', '2019-06-06', 'EU', 0, 0),
('pepito', 1, '12345556', 'pepito@correo.ugr.es', '2019-12-01', 'EU', 0, 0),
('salchicha', 3, 'salchipapa', 'papa@correo.ugr.es', '1950-11-11', 'LPL', 0, 0),
('xpeke', 4, 'xpekebackdoor', 'xpeke@correo.ugr.es', '2018-03-12', 'EU', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denuncia`
--

CREATE TABLE `denuncia` (
  `nombrec1` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `nombrec2` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `fecha` date NOT NULL,
  `revisada` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `denuncia`
--

INSERT INTO `denuncia` (`nombrec1`, `nombrec2`, `fecha`, `revisada`) VALUES
('domin', 'haterxd', '2019-12-08', 0),
('luisito23', 'haterxd', '2019-12-09', 0),
('noelia', 'haterxd', '2019-12-08', 0),
('noelia', 'xpeke', '2019-12-03', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `idequipo` smallint(6) NOT NULL,
  `nombreequipo` varchar(30) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`idequipo`, `nombreequipo`) VALUES
(1, 'ROGUE'),
(2, 'FNATIC'),
(3, 'ORIGEN'),
(4, 'VITALITY');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `honorifica`
--

CREATE TABLE `honorifica` (
  `nombrec1` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `nombrec2` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `honorifica`
--

INSERT INTO `honorifica` (`nombrec1`, `nombrec2`, `fecha`) VALUES
('pablo', 'haterxd', '2019-12-20'),
('pablo', 'jose', '2019-12-05'),
('xpeke', 'luisito23', '2019-12-01'),
('fibonacci', 'pepito', '2019-12-04'),
('fibonacci', 'pepito', '2019-12-12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juega`
--

CREATE TABLE `juega` (
  `idequipo1` smallint(6) NOT NULL,
  `idequipo2` smallint(6) NOT NULL,
  `fecha` date NOT NULL,
  `danoe1` smallint(6) NOT NULL,
  `danoe2` smallint(6) NOT NULL,
  `muertese1` tinyint(4) NOT NULL,
  `muertese2` tinyint(4) NOT NULL,
  `finalizada` tinyint(1) NOT NULL,
  `idpartida` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `juega`
--

INSERT INTO `juega` (`idequipo1`, `idequipo2`, `fecha`, `danoe1`, `danoe2`, `muertese1`, `muertese2`, `finalizada`, `idpartida`) VALUES
(1, 2, '2019-12-02', 500, 300, 25, 19, 1, 1),
(3, 1, '2019-12-04', 400, 325, 20, 18, 1, 3),
(4, 2, '2019-12-22', 250, 225, 25, 24, 0, 3),
(4, 3, '2019-12-10', 250, 1090, 23, 67, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `objetoscuenta`
--

CREATE TABLE `objetoscuenta` (
  `nombrec` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `idarticulo` smallint(6) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partida`
--

CREATE TABLE `partida` (
  `idpartida` tinyint(4) NOT NULL,
  `tipo` char(15) COLLATE utf8mb4_general_ci NOT NULL,
  `descripcion` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `partida`
--

INSERT INTO `partida` (`idpartida`, `tipo`, `descripcion`) VALUES
(1, 'CLASICA', 'Partida clásica entre dos equipos. 3vs3. Quien consiga más muertes gana. Duración: 20 minutos.'),
(2, 'MUERTE_SUBITA', 'Partida entre dos equipos en la que la primera baja determina quién gana. Duración: 5 minutos.'),
(3, 'BATTLE_ROYALE', 'Partida Clásica salvo por el hecho de que el escenario va menguando a medida que avanza la partida. Duración: 15 minutos.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda`
--

CREATE TABLE `tienda` (
  `idarticulo` smallint(6) NOT NULL,
  `nombre` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `descripcion` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `precio` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tienda`
--

INSERT INTO `tienda` (`idarticulo`, `nombre`, `descripcion`, `precio`) VALUES
(1, 'Lucian', 'Campeón Tirador. Potencia tu puntería.', 975),
(2, 'Annie', 'Campeona Maga tipo Burst. Mucho daño en poco tiempo', 975),
(3, 'Darius', 'Campeón Bruiser. Especializado en cuerpo a cuerpo.', 800),
(4, 'Riven', 'Campeón combatiente. Destaca por su kit de habilidades', 950),
(5, 'Orianna', 'Campeona maga. ¿Dónde está la bola?', 750),
(6, 'Zed', 'Campeón asesino. Maestro de las sombras. ', 975),
(7, 'Nunu', 'Campeón Jungla. Engulle la jungla en un plis.', 958);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cuentapertenece`
--
ALTER TABLE `cuentapertenece`
  ADD PRIMARY KEY (`nombre`),
  ADD KEY `idequipo` (`idequipo`);

--
-- Indices de la tabla `denuncia`
--
ALTER TABLE `denuncia`
  ADD PRIMARY KEY (`nombrec1`,`nombrec2`,`fecha`),
  ADD KEY `nombrec2` (`nombrec2`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`idequipo`);

--
-- Indices de la tabla `honorifica`
--
ALTER TABLE `honorifica`
  ADD PRIMARY KEY (`nombrec1`,`nombrec2`,`fecha`),
  ADD KEY `nombrec2` (`nombrec2`);

--
-- Indices de la tabla `juega`
--
ALTER TABLE `juega`
  ADD PRIMARY KEY (`idequipo1`,`idequipo2`,`fecha`),
  ADD KEY `idpartida` (`idpartida`),
  ADD KEY `idequipo2` (`idequipo2`);

--
-- Indices de la tabla `objetoscuenta`
--
ALTER TABLE `objetoscuenta`
  ADD PRIMARY KEY (`nombrec`,`idarticulo`),
  ADD KEY `idarticulo` (`idarticulo`);

--
-- Indices de la tabla `partida`
--
ALTER TABLE `partida`
  ADD PRIMARY KEY (`idpartida`);

--
-- Indices de la tabla `tienda`
--
ALTER TABLE `tienda`
  ADD PRIMARY KEY (`idarticulo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `equipo`
--
ALTER TABLE `equipo`
  MODIFY `idequipo` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tienda`
--
ALTER TABLE `tienda`
  MODIFY `idarticulo` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuentapertenece`
--
ALTER TABLE `cuentapertenece`
  ADD CONSTRAINT `cuentapertenece_ibfk_1` FOREIGN KEY (`idequipo`) REFERENCES `equipo` (`idequipo`);

--
-- Filtros para la tabla `denuncia`
--
ALTER TABLE `denuncia`
  ADD CONSTRAINT `denuncia_ibfk_1` FOREIGN KEY (`nombrec1`) REFERENCES `cuentapertenece` (`nombre`),
  ADD CONSTRAINT `denuncia_ibfk_2` FOREIGN KEY (`nombrec2`) REFERENCES `cuentapertenece` (`nombre`);

--
-- Filtros para la tabla `honorifica`
--
ALTER TABLE `honorifica`
  ADD CONSTRAINT `honorifica_ibfk_1` FOREIGN KEY (`nombrec1`) REFERENCES `cuentapertenece` (`nombre`),
  ADD CONSTRAINT `honorifica_ibfk_2` FOREIGN KEY (`nombrec2`) REFERENCES `cuentapertenece` (`nombre`);

--
-- Filtros para la tabla `juega`
--
ALTER TABLE `juega`
  ADD CONSTRAINT `juega_ibfk_1` FOREIGN KEY (`idpartida`) REFERENCES `partida` (`idpartida`),
  ADD CONSTRAINT `juega_ibfk_2` FOREIGN KEY (`idequipo1`) REFERENCES `equipo` (`idequipo`),
  ADD CONSTRAINT `juega_ibfk_3` FOREIGN KEY (`idequipo2`) REFERENCES `equipo` (`idequipo`);

--
-- Filtros para la tabla `objetoscuenta`
--
ALTER TABLE `objetoscuenta`
  ADD CONSTRAINT `objetoscuenta_ibfk_1` FOREIGN KEY (`nombrec`) REFERENCES `cuentapertenece` (`nombre`),
  ADD CONSTRAINT `objetoscuenta_ibfk_2` FOREIGN KEY (`idarticulo`) REFERENCES `tienda` (`idarticulo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
