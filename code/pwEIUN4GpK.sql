-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 03, 2019 at 02:28 AM
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
  `localScore` int(11) NOT NULL,
  `visitorScore` int(11) NOT NULL,
  `localPenaltyGoals` int(11) NOT NULL,
  `visitorPenaltyGoals` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Requests`
--

CREATE TABLE `Requests` (
  `id` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `sport` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `numberOfTeams` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `tournament` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Sports`
--

CREATE TABLE `Sports` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Status`
--

CREATE TABLE `Status` (
  `id` int(11) NOT NULL,
  `name` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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

-- --------------------------------------------------------

--
-- Table structure for table `Tournament_types`
--

CREATE TABLE `Tournament_types` (
  `id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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

-- --------------------------------------------------------

--
-- Table structure for table `Users_tournaments`
--

CREATE TABLE `Users_tournaments` (
  `id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `user` int(11) NOT NULL,
  `tournament` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Users_tournaments_teams`
--

CREATE TABLE `Users_tournaments_teams` (
  `id` int(11) NOT NULL,
  `team` int(11) NOT NULL,
  `user_tournament` int(11) NOT NULL,
  `octavos` bit(1) NOT NULL,
  `cuartos` bit(1) NOT NULL,
  `seminfinal` bit(1) NOT NULL,
  `final` bit(1) NOT NULL,
  `champ` bit(1) NOT NULL,
  `bracket` int(11) NOT NULL
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
-- Indexes for table `Requests`
--
ALTER TABLE `Requests`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_requests_user` (`user`),
  ADD KEY `fk_requests_sport` (`sport`),
  ADD KEY `fk_requests_type` (`type`),
  ADD KEY `fk_requests_status` (`status`),
  ADD KEY `fk_requests_tour` (`tournament`);

--
-- Indexes for table `Sports`
--
ALTER TABLE `Sports`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_sport_name` (`name`);

--
-- Indexes for table `Status`
--
ALTER TABLE `Status`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_status_name` (`name`);

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
  ADD UNIQUE KEY `unique_username` (`username`);

--
-- Indexes for table `Users_tournaments`
--
ALTER TABLE `Users_tournaments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_users_tour_user` (`user`),
  ADD KEY `fk_users_tour_tour` (`tournament`);

--
-- Indexes for table `Users_tournaments_teams`
--
ALTER TABLE `Users_tournaments_teams`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_utt_team` (`team`),
  ADD KEY `fk_utt_user_tour` (`user_tournament`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Administrator`
--
ALTER TABLE `Administrator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Matchups`
--
ALTER TABLE `Matchups`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Requests`
--
ALTER TABLE `Requests`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Sports`
--
ALTER TABLE `Sports`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Status`
--
ALTER TABLE `Status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Teams`
--
ALTER TABLE `Teams`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Tournaments`
--
ALTER TABLE `Tournaments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Tournament_types`
--
ALTER TABLE `Tournament_types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Users_tournaments_teams`
--
ALTER TABLE `Users_tournaments_teams`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Matchups`
--
ALTER TABLE `Matchups`
  ADD CONSTRAINT `fk_matchups_local` FOREIGN KEY (`localTeam`) REFERENCES `Users_tournaments_teams` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_matchups_visitor` FOREIGN KEY (`visitorTeam`) REFERENCES `Users_tournaments_teams` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Constraints for table `Requests`
--
ALTER TABLE `Requests`
  ADD CONSTRAINT `fk_requests_sport` FOREIGN KEY (`sport`) REFERENCES `Sports` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_requests_status` FOREIGN KEY (`status`) REFERENCES `Status` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_requests_tour` FOREIGN KEY (`tournament`) REFERENCES `Tournaments` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_requests_type` FOREIGN KEY (`type`) REFERENCES `Tournament_types` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_requests_user` FOREIGN KEY (`user`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

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
-- Constraints for table `Users_tournaments`
--
ALTER TABLE `Users_tournaments`
  ADD CONSTRAINT `fk_users_tour_tour` FOREIGN KEY (`tournament`) REFERENCES `Tournaments` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_users_tour_user` FOREIGN KEY (`user`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Users_tournaments_teams`
--
ALTER TABLE `Users_tournaments_teams`
  ADD CONSTRAINT `fk_utt_team` FOREIGN KEY (`team`) REFERENCES `Teams` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_utt_user_tour` FOREIGN KEY (`user_tournament`) REFERENCES `Users_tournaments` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
