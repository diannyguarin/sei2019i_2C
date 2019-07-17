-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 17, 2019 at 09:40 PM
-- Server version: 8.0.13-4
-- PHP Version: 7.2.19-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pwEIUN4GpK`
--

-- --------------------------------------------------------

--
-- Table structure for table `Administrator`
--

CREATE TABLE `Administrator` (
  `id` int(11) NOT NULL,
  `username` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Administrator`
--

INSERT INTO `Administrator` (`id`, `username`, `password`) VALUES
(1, 'qwerty', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `Matchups`
--

CREATE TABLE `Matchups` (
  `id` int(11) NOT NULL,
  `localTeam` int(11) NOT NULL,
  `visitorTeam` int(11) NOT NULL,
  `phase` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `bracket` int(11) NOT NULL,
  `winner` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Sports`
--

CREATE TABLE `Sports` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Sports`
--

INSERT INTO `Sports` (`id`, `name`) VALUES
(1, 'football');

-- --------------------------------------------------------

--
-- Table structure for table `Teams`
--

CREATE TABLE `Teams` (
  `id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Tournaments`
--

CREATE TABLE `Tournaments` (
  `id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `admin` int(11) NOT NULL,
  `sport` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `numberOfTeams` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Tournaments`
--

INSERT INTO `Tournaments` (`id`, `name`, `admin`, `sport`, `type`, `numberOfTeams`) VALUES
(1, 'prueba', 1, 1, 1, 16),
(2, 'letsgodude', 1, 1, 1, 16),
(3, 'imonfire', 1, 1, 1, 8),
(4, 'wtfisgoingon', 1, 1, 1, 4),
(5, 'pruebatorneo', 1, 1, 1, 4),
(6, 'hmmmmmm', 1, 1, 1, 2),
(7, 'Ingesoft', 1, 1, 1, 4),
(8, 'torn', 1, 1, 1, 4),
(9, 'try', 1, 1, 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `Tournament_types`
--

CREATE TABLE `Tournament_types` (
  `id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Tournament_types`
--

INSERT INTO `Tournament_types` (`id`, `name`) VALUES
(1, 'knockout');

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`id`, `name`, `username`, `password`) VALUES
(2, 'diana', 'dianny', '123'),
(3, 'valeria', 'val', '1234'),
(4, 'hell', 'yeah', 'bro'),
(5, 'liseth', 'liseth1', 'hellyeahdude'),
(7, 'Jeisson', 'javergarav', '123'),
(11, 'liseth arevalo', 'lyarevalo', 'lichisita'),
(14, 'liseth', 'liseth123', '1212'),
(15, 'usuario', 'user', 'prueba'),
(16, 'User1', 'user1', 'pass'),
(18, 'vahudu', 'vahudu', '000'),
(19, 'prueba', 'prueba2', 'prueba'),
(20, 'diana', 'whatever', '1234'),
(21, 'diana', 'd', '123'),
(22, 'prueba', 'prueba', 'prueba'),
(23, 'funciona', 'funciona', '1234'),
(24, 'gggg', 'abc', '123'),
(25, 'tres', 'tres', 'tres'),
(26, 'ff', 'felipe', '12345'),
(27, 'DiegoVelasquez', 'Diego12', '12345'),
(28, 'qhsjdbr', 'Y2', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `Users_tournaments_teams`
--

CREATE TABLE `Users_tournaments_teams` (
  `id` int(11) NOT NULL,
  `team` int(11) NOT NULL,
  `user_tournament` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `User_tournaments`
--

CREATE TABLE `User_tournaments` (
  `id` int(11) NOT NULL,
  `name` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `user` int(11) NOT NULL,
  `tournament` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Administrator`
--
ALTER TABLE `Administrator`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_admin_user` (`username`);

--
-- Indexes for table `Matchups`
--
ALTER TABLE `Matchups`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_matchups_local` (`localTeam`),
  ADD KEY `fk_matchups_visitor` (`visitorTeam`);

--
-- Indexes for table `Sports`
--
ALTER TABLE `Sports`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_sport_name` (`name`);

--
-- Indexes for table `Teams`
--
ALTER TABLE `Teams`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_teams_user` (`user`);

--
-- Indexes for table `Tournaments`
--
ALTER TABLE `Tournaments`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_tournament_name` (`name`),
  ADD KEY `fk_tour_admin` (`admin`),
  ADD KEY `fk_tour_sport` (`sport`),
  ADD KEY `fk_tour_type` (`type`);

--
-- Indexes for table `Tournament_types`
--
ALTER TABLE `Tournament_types`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_type_name` (`name`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_username` (`username`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `Users_tournaments_teams`
--
ALTER TABLE `Users_tournaments_teams`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user_tour_team_team` (`team`),
  ADD KEY `fk_users_tour_team_tour` (`user_tournament`);

--
-- Indexes for table `User_tournaments`
--
ALTER TABLE `User_tournaments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_users_tour_user` (`user`),
  ADD KEY `fk_users_tour_tour` (`tournament`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Administrator`
--
ALTER TABLE `Administrator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Matchups`
--
ALTER TABLE `Matchups`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Sports`
--
ALTER TABLE `Sports`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Teams`
--
ALTER TABLE `Teams`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Tournaments`
--
ALTER TABLE `Tournaments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `Tournament_types`
--
ALTER TABLE `Tournament_types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `Users_tournaments_teams`
--
ALTER TABLE `Users_tournaments_teams`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `User_tournaments`
--
ALTER TABLE `User_tournaments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Matchups`
--
ALTER TABLE `Matchups`
  ADD CONSTRAINT `fk_matchups_local` FOREIGN KEY (`localTeam`) REFERENCES `Users_tournaments_teams` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_matchups_visitor` FOREIGN KEY (`visitorTeam`) REFERENCES `Users_tournaments_teams` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `Teams`
--
ALTER TABLE `Teams`
  ADD CONSTRAINT `fk_teams_user` FOREIGN KEY (`user`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Tournaments`
--
ALTER TABLE `Tournaments`
  ADD CONSTRAINT `fk_tour_admin` FOREIGN KEY (`admin`) REFERENCES `Administrator` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_tour_sport` FOREIGN KEY (`sport`) REFERENCES `Sports` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_tour_type` FOREIGN KEY (`type`) REFERENCES `Tournament_types` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Users_tournaments_teams`
--
ALTER TABLE `Users_tournaments_teams`
  ADD CONSTRAINT `fk_user_tour_team_team` FOREIGN KEY (`team`) REFERENCES `Teams` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_users_tour_team_tour` FOREIGN KEY (`user_tournament`) REFERENCES `User_tournaments` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `User_tournaments`
--
ALTER TABLE `User_tournaments`
  ADD CONSTRAINT `fk_users_tour_tour` FOREIGN KEY (`tournament`) REFERENCES `Tournaments` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_users_tour_user` FOREIGN KEY (`user`) REFERENCES `Users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
