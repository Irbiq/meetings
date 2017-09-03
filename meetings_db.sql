-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.16-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных meetings
CREATE DATABASE IF NOT EXISTS `meetings` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `meetings`;

-- Дамп структуры для таблица meetings.booking_requests
CREATE TABLE IF NOT EXISTS `booking_requests` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee` varchar(50) DEFAULT NULL,
  `request_time` datetime DEFAULT NULL,
  `meeting_time` datetime DEFAULT NULL,
  `meeting_duration` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы meetings.booking_requests: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `booking_requests` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking_requests` ENABLE KEYS */;

-- Дамп структуры для таблица meetings.meetings
CREATE TABLE IF NOT EXISTS `meetings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee` varchar(50) DEFAULT NULL,
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы meetings.meetings: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `meetings` DISABLE KEYS */;
/*!40000 ALTER TABLE `meetings` ENABLE KEYS */;

-- Дамп структуры для таблица meetings.work_time
CREATE TABLE IF NOT EXISTS `work_time` (
  `id` int(11) NOT NULL,
  `start` time DEFAULT NULL,
  `end` time DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы meetings.work_time: ~7 rows (приблизительно)
/*!40000 ALTER TABLE `work_time` DISABLE KEYS */;
INSERT INTO `work_time` (`id`, `start`, `end`) VALUES
	(1, '09:00:00', '20:00:00'),
	(2, '08:00:00', '20:00:00'),
	(3, '09:00:00', '20:00:00'),
	(4, '08:00:00', '20:00:00'),
	(5, '08:00:00', '20:00:00'),
	(6, '12:00:00', '20:00:00'),
	(7, '00:00:01', '23:55:55');
/*!40000 ALTER TABLE `work_time` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
