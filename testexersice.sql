-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3307
-- Время создания: Янв 27 2022 г., 18:00
-- Версия сервера: 10.3.22-MariaDB
-- Версия PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `testexersice`
--

-- --------------------------------------------------------

--
-- Структура таблицы `admin`
--

CREATE TABLE `admin` (
  `ID` int(11) NOT NULL,
  `username` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `admin`
--

INSERT INTO `admin` (`ID`, `username`, `password`) VALUES
(3, 'glebomelchenko911@gmail.com', '12345'),
(4, 'alex@gmail.com', '12412');

-- --------------------------------------------------------

--
-- Структура таблицы `day`
--

CREATE TABLE `day` (
  `ID` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `day`
--

INSERT INTO `day` (`ID`, `name`) VALUES
(3, 'Понедельник'),
(4, 'Вторник'),
(5, 'Среда'),
(6, 'Четверг'),
(7, 'Пятница'),
(9, 'Суббота');

-- --------------------------------------------------------

--
-- Структура таблицы `grouup`
--

CREATE TABLE `grouup` (
  `ID` int(11) NOT NULL,
  `name` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `grouup`
--

INSERT INTO `grouup` (`ID`, `name`) VALUES
(2, 'TV-11'),
(3, 'TV-01'),
(5, 'TI-91'),
(6, 'TI-11');

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(10);

-- --------------------------------------------------------

--
-- Структура таблицы `lessons`
--

CREATE TABLE `lessons` (
  `ID` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `lessons`
--

INSERT INTO `lessons` (`ID`, `name`) VALUES
(1, 'Математика'),
(3, 'История'),
(5, 'Химия'),
(6, 'Биология'),
(15, 'Программирование'),
(16, 'Алгоритмы '),
(17, 'Английский'),
(18, 'Линал'),
(19, 'Дизайн');

-- --------------------------------------------------------

--
-- Структура таблицы `list`
--

CREATE TABLE `list` (
  `ID` int(11) NOT NULL,
  `students_id` int(11) NOT NULL,
  `grouup_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `list`
--

INSERT INTO `list` (`ID`, `students_id`, `grouup_id`) VALUES
(9, 7, 6),
(10, 5, 6),
(11, 12, 3),
(12, 3, 3),
(13, 10, 5),
(14, 9, 5),
(15, 11, 2),
(16, 6, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `pair`
--

CREATE TABLE `pair` (
  `ID` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `start` time NOT NULL,
  `finish` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `pair`
--

INSERT INTO `pair` (`ID`, `number`, `start`, `finish`) VALUES
(1, 1, '08:30:00', '10:10:00'),
(2, 2, '10:20:00', '11:50:00');

-- --------------------------------------------------------

--
-- Структура таблицы `room`
--

CREATE TABLE `room` (
  `ID` int(11) NOT NULL,
  `number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `room`
--

INSERT INTO `room` (`ID`, `number`) VALUES
(2, 753),
(3, 10),
(8, 11),
(9, 12),
(10, 17),
(11, 18),
(12, 115),
(13, 710),
(14, 354),
(15, 210);

-- --------------------------------------------------------

--
-- Структура таблицы `students`
--

CREATE TABLE `students` (
  `ID` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `surname` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `students`
--

INSERT INTO `students` (`ID`, `name`, `surname`) VALUES
(3, 'Глеб', 'Самко'),
(4, 'Вова', 'Керри'),
(5, 'Анна', 'Крючковская'),
(6, 'Людмила', 'Дудченко'),
(7, 'Андрей ', 'Онищик'),
(8, 'Илья', 'Горбач'),
(9, 'Денис', 'Мирошниченко '),
(10, 'Зина ', 'Ида'),
(11, 'Леонид', 'Омельченко'),
(12, 'Вова', 'Воеводин ');

-- --------------------------------------------------------

--
-- Структура таблицы `timetable`
--

CREATE TABLE `timetable` (
  `ID` int(11) NOT NULL,
  `grouup_id` int(10) NOT NULL,
  `day_id` int(10) NOT NULL,
  `lessons_id` int(10) NOT NULL,
  `pair_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `timetable`
--

INSERT INTO `timetable` (`ID`, `grouup_id`, `day_id`, `lessons_id`, `pair_id`, `room_id`) VALUES
(19, 6, 3, 16, 1, 3),
(21, 6, 3, 17, 2, 2),
(22, 6, 4, 1, 1, 8),
(23, 6, 4, 15, 2, 9),
(24, 6, 5, 6, 1, 14),
(25, 6, 5, 19, 1, 12),
(26, 6, 6, 18, 1, 15),
(27, 6, 6, 5, 2, 10),
(28, 6, 7, 1, 1, 9),
(29, 6, 7, 18, 2, 10),
(30, 5, 3, 17, 1, 10),
(31, 5, 4, 19, 2, 12),
(32, 5, 5, 19, 1, 8),
(33, 5, 5, 16, 2, 13),
(34, 5, 6, 19, 2, 10),
(35, 5, 6, 5, 1, 14),
(36, 5, 6, 15, 2, 8),
(37, 5, 7, 18, 1, 15),
(38, 5, 9, 18, 1, 9),
(39, 5, 9, 5, 2, 11),
(40, 3, 9, 3, 2, 8),
(41, 3, 7, 5, 1, 12),
(42, 2, 3, 6, 2, 10),
(43, 2, 6, 19, 1, 11);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `day`
--
ALTER TABLE `day`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `grouup`
--
ALTER TABLE `grouup`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `lessons`
--
ALTER TABLE `lessons`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `list`
--
ALTER TABLE `list`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `students_id` (`students_id`),
  ADD KEY `grouup_id` (`grouup_id`);

--
-- Индексы таблицы `pair`
--
ALTER TABLE `pair`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `timetable`
--
ALTER TABLE `timetable`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `timetable_ibfk_1` (`day_id`),
  ADD KEY `lessons_id` (`lessons_id`),
  ADD KEY `grouup_id` (`grouup_id`),
  ADD KEY `pair_id` (`pair_id`),
  ADD KEY `room_id` (`room_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `admin`
--
ALTER TABLE `admin`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `day`
--
ALTER TABLE `day`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT для таблицы `grouup`
--
ALTER TABLE `grouup`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT для таблицы `lessons`
--
ALTER TABLE `lessons`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT для таблицы `list`
--
ALTER TABLE `list`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT для таблицы `pair`
--
ALTER TABLE `pair`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `room`
--
ALTER TABLE `room`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT для таблицы `students`
--
ALTER TABLE `students`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT для таблицы `timetable`
--
ALTER TABLE `timetable`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `list`
--
ALTER TABLE `list`
  ADD CONSTRAINT `list_ibfk_1` FOREIGN KEY (`students_id`) REFERENCES `students` (`ID`),
  ADD CONSTRAINT `list_ibfk_2` FOREIGN KEY (`grouup_id`) REFERENCES `grouup` (`ID`);

--
-- Ограничения внешнего ключа таблицы `timetable`
--
ALTER TABLE `timetable`
  ADD CONSTRAINT `timetable_ibfk_1` FOREIGN KEY (`day_id`) REFERENCES `day` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `timetable_ibfk_2` FOREIGN KEY (`lessons_id`) REFERENCES `lessons` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `timetable_ibfk_3` FOREIGN KEY (`grouup_id`) REFERENCES `grouup` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `timetable_ibfk_4` FOREIGN KEY (`pair_id`) REFERENCES `pair` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `timetable_ibfk_5` FOREIGN KEY (`room_id`) REFERENCES `room` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
