-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 08. Dez 2014 um 16:45
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
-- Tabellenstruktur für Tabelle `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
`Admin-ID` int(11) unsigned NOT NULL,
  `Adminname` varchar(30) NOT NULL,
  `Passwort` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `admin`
--

INSERT INTO `admin` (`Admin-ID`, `Adminname`, `Passwort`) VALUES
(1, 'René', '12345'),
(2, 'Leon', '67890'),
(3, 'Jonas', '13579');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bar`
--

DROP TABLE IF EXISTS `bar`;
CREATE TABLE IF NOT EXISTS `bar` (
`Bar-ID` int(11) unsigned NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Adresse` varchar(30) NOT NULL,
  `PLZ` varchar(5) NOT NULL,
  `Ort` varchar(30) NOT NULL,
  `Beschreibung` text NOT NULL,
  `Link` varchar(100) NOT NULL,
  `Öffnung` varchar(5) NOT NULL,
  `Schließung` varchar(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `bar`
--

INSERT INTO `bar` (`Bar-ID`, `Name`, `Adresse`, `PLZ`, `Ort`, `Beschreibung`, `Link`, `Öffnung`, `Schließung`) VALUES
(1, 'AllVitalis Cocktailbar', 'Stephanienstraße 38-40', '76133', 'Karlsruhe', '', '', '18:00', '01:00'),
(2, 'Elio´s Bar', 'Ettlinger Starße 23', '76137', 'Karlsruhe', '', '', '17:00', '3:00'),
(3, 'Maresca´s', 'Hebelstraße 15', '76133', 'Karlsruhe', '', '', '13:00', '01:00'),
(4, 'Pendel Bar', 'Blumenstraße 17', '76133', 'Karlsruhe', '', '', '20:00', '01:00'),
(5, 'Santo Bar', 'Karlstraße 67-69', '76137', 'Karlsruhe', '', '', '18:00', '03:00'),
(6, 'Schlossbar', 'Bahnhofsplatz 2', '76137', 'Karlsruhe', '', '', '08:00', '01:00');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bar-bewertung`
--

DROP TABLE IF EXISTS `bar-bewertung`;
CREATE TABLE IF NOT EXISTS `bar-bewertung` (
  `User-ID` int(11) unsigned NOT NULL,
  `Bar-ID` int(11) unsigned NOT NULL,
  `Preis` int(3) unsigned NOT NULL,
  `Service` int(3) unsigned NOT NULL,
  `Einrichtung` int(3) unsigned NOT NULL,
  `Gesamt` int(3) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bartour`
--

DROP TABLE IF EXISTS `bartour`;
CREATE TABLE IF NOT EXISTS `bartour` (
  `User-ID` int(11) unsigned NOT NULL,
  `Bar-ID` int(11) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `musikstil`
--

DROP TABLE IF EXISTS `musikstil`;
CREATE TABLE IF NOT EXISTS `musikstil` (
  `Bar-ID` int(11) unsigned NOT NULL,
  `Musikrichtung` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
`User-ID` int(11) unsigned NOT NULL,
  `User-Name` varchar(50) NOT NULL,
  `E-Mail` varchar(50) NOT NULL,
  `Password` varchar(25) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`User-ID`, `User-Name`, `E-Mail`, `Password`) VALUES
(1, 'Horst', 'Horst@gmx.de', 'qwerty');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `admin`
--
ALTER TABLE `admin`
 ADD PRIMARY KEY (`Admin-ID`);

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
-- AUTO_INCREMENT für Tabelle `admin`
--
ALTER TABLE `admin`
MODIFY `Admin-ID` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT für Tabelle `bar`
--
ALTER TABLE `bar`
MODIFY `Bar-ID` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT für Tabelle `user`
--
ALTER TABLE `user`
MODIFY `User-ID` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
