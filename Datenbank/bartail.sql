-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 05. Dez 2014 um 16:12
-- Server Version: 5.6.21
-- PHP-Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `bartail`
--
CREATE DATABASE IF NOT EXISTS `bartail` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bartail`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bar`
--

DROP TABLE IF EXISTS `bar`;
CREATE TABLE IF NOT EXISTS `bar` (
`Bar-ID` int(10) unsigned NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Adresse` varchar(30) NOT NULL,
  `PLZ` varchar(5) NOT NULL,
  `Ort` varchar(30) NOT NULL,
  `Beschreibung` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bar-bewertung`
--

DROP TABLE IF EXISTS `bar-bewertung`;
CREATE TABLE IF NOT EXISTS `bar-bewertung` (
  `User-ID` int(11) NOT NULL,
  `Bar-ID` int(11) NOT NULL,
  `Preis` int(3) NOT NULL,
  `Service` int(3) NOT NULL,
  `Gesamt` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
`User-ID` int(10) unsigned NOT NULL,
  `User-Name` varchar(50) NOT NULL,
  `E-Mail` varchar(50) NOT NULL,
  `Password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `bar`
--
ALTER TABLE `bar`
 ADD PRIMARY KEY (`Bar-ID`);

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`User-ID`), ADD UNIQUE KEY `User-Name` (`User-Name`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `bar`
--
ALTER TABLE `bar`
MODIFY `Bar-ID` int(10) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT für Tabelle `user`
--
ALTER TABLE `user`
MODIFY `User-ID` int(10) unsigned NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
