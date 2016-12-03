CREATE TABLE `estudiantes` (
`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
`matricula` int(11) NOT NULL,
`nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
`apellido` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
`calificacion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
PRIMARY KEY (`id`),
UNIQUE KEY `matricula_UNIQUE` (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
