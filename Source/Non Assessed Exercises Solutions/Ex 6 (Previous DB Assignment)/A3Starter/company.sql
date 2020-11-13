CREATE Database IF NOT EXISTS company;
USE company;


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customerNumber` int(11) NOT NULL,
  `customerName` varchar(50) NOT NULL,
  `contactLastName` varchar(50) NOT NULL,
  `contactFirstName` varchar(50) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `creditLimit` double DEFAULT NULL,
  `dateJoined` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customerNumber`, `customerName`, `contactLastName`, `contactFirstName`, `phone`, `city`, `country`, `creditLimit`, `dateJoined`) VALUES
(103, 'Bosanova ', 'Hayden', 'John', '208208', 'Limerick', 'Ireland', 199, '1999-09-30'),
(112, 'Signal Gift Stores', 'King', 'Simon', '7025551838', 'Las Vegas', 'USA', 71800, '1997-10-13'),
(114, 'Australian Collectors, Co.', 'Ferguson', 'Peter', '03 9520 4555', 'Melbourne', 'Australia', 117300, '1998-03-09'),
(119, 'La Rochelle Gifts', 'Labron', 'Janine ', '40.67.8555', 'Nantes', 'France', 118200, '2006-01-30'),
(121, 'Baane Mini Imports', 'Bergulfsen', 'Jonas ', '07-98 9555', 'Stavern', 'Norway', 81700, '2018-09-27'),
(124, 'Mini Gifts Distributors Ltd.', 'Nelson', 'Susan', '4155551450', 'San Rafael', 'USA', 210500, '1993-01-29'),
(125, 'Havel & Zbyszek Co', 'Piestrzeniewicz', 'Zbyszek ', '(26) 642-7555', 'Warszawa', 'Poland', 0, '2005-01-24'),
(128, 'Blauer See Auto, Co.', 'Keitel', 'Roland', '+49 69 66 90 2555', 'Frankfurt', 'Germany', 59700, '1999-11-06'),
(129, 'Mini Wheels Co.', 'Murphy', 'Julie', '6505555787', 'San Francisco', 'USA', 64600, '1992-07-18'),
(131, 'Land of Toys Inc.', 'Lee', 'Kwai', '2125557818', 'NYC', 'USA', 114900, '1999-01-27'),
(141, 'Euro+ Shopping Channel', 'Freyre', 'Diego ', '(91) 555 94 44', 'Madrid', 'Spain', 227600, '1998-11-12'),
(144, 'Volvo Model Replicas, Co', 'Berglund', 'Christina ', '0921-12 3555', 'Luleå', 'Sweden', 53100, '2018-08-10'),
(145, 'Danish Wholesale Imports', 'Petersen', 'Jytte ', '31 12 3555', 'Kobenhavn', 'Denmark', 83400, '2012-07-30'),
(146, 'Saveley & Henriot, Co.', 'Saveley', 'Mary ', '78.32.5555', 'Lyon', 'France', 123900, '1999-10-29'),
(148, 'Dragon Souveniers, Ltd.', 'Natividad', 'Eric', '+65 221 7555', 'Singapore', 'Singapore', 103800, '1997-04-14'),
(151, 'Muscle Machine Inc', 'Young', 'Jeff', '2125557413', 'NYC', 'USA', 138500, '1995-06-14'),
(157, 'Diecast Classics Inc.', 'Leong', 'Kelvin', '2155551555', 'Allentown', 'USA', 100600, '1993-11-29'),
(161, 'Technics Stores Inc.', 'Hashimoto', 'Juri', '6505556809', 'Burlingame', 'USA', 84600, '1991-09-17'),
(166, 'Handji Gifts& Co', 'Victorino', 'Wendy', '+65 224 1555', 'Singapore', 'Singapore', 97900, '2012-09-17'),
(167, 'Herkku Gifts', 'Oeztan', 'Veysel', '+47 2267 3215', 'Bergen', 'Norway  ', 96800, '2014-10-21'),
(168, 'American Souvenirs Inc', 'Franco', 'Keith', '2035557845', 'New Haven', 'USA', 0, '2017-01-06'),
(169, 'Porto Imports Co.', 'de Castro', 'Isabel ', '(1) 356-5555', 'Lisboa', 'Portugal', 0, '1994-06-03'),
(171, 'Daedalus Designs Imports', 'Rancé', 'Martine ', '20.16.1555', 'Lille', 'France', 82900, '2011-09-14'),
(172, 'La Corne D\'abondance, Co.', 'Bertrand', 'Marie', '(1) 42.34.2555', 'Paris', 'France', 84300, '2001-08-13'),
(173, 'Cambridge Collectables Co.', 'Tseng', 'Jerry', '6175555555', 'Cambridge', 'USA', 43400, '2008-11-13'),
(175, 'Gift Depot Inc.', 'King', 'Julie', '2035552570', 'Bridgewater', 'USA', 84300, '1993-04-02'),
(177, 'Osaka Souveniers Co.', 'Kentary', 'Mory', '+81 06 6342 5555', 'Kita-ku', 'Japan', 81200, '2002-11-30'),
(181, 'Vitachrome Inc.', 'Frick', 'Michael', '2125551500', 'NYC', 'USA', 76400, '2015-12-12'),
(186, 'Toys of Finland, Co.', 'Karttunen', 'Matti', '90-224 8555', 'Helsinki', 'Finland', 96500, '1997-05-12'),
(187, 'AV Stores, Co.', 'Ashworth', 'Rachel', '(171) 555-1555', 'Manchester', 'UK', 136800, '2002-03-26'),
(189, 'Clover Collections, Co.', 'Cassidy', 'Dean', '+353 1862 1555', 'Dublin', 'Ireland', 69400, '2000-03-18'),
(198, 'Auto-Moto Classics Inc.', 'Taylor', 'Leslie', '6175558428', 'Brickhaven', 'USA', 23000, '2002-11-16'),
(201, 'UK Collectables, Ltd.', 'Devon', 'Elizabeth', '(171) 555-2282', 'Liverpool', 'UK', 92700, '1994-11-12'),
(202, 'Canadian Gift Exchange Network', 'Tamuri', 'Yoshi ', '(604) 555-3392', 'Vancouver', 'Canada', 90300, '2001-08-04'),
(204, 'Online Mini Collectables', 'Barajas', 'Miguel', '6175557555', 'Brickhaven', 'USA', 68700, '2004-06-30'),
(205, 'Toys4GrownUps.com', 'Young', 'Julie', '6265557265', 'Pasadena', 'USA', 90700, '1998-11-01'),
(206, 'Asian Shopping Network, Co', 'Walker', 'Brydey', '+612 9411 1555', 'Singapore', 'Singapore', 0, '2016-07-26'),
(209, 'Mini Caravy', 'Citeaux', 'Frédérique ', '88.60.1555', 'Strasbourg', 'France', 53800, '2012-09-18'),
(211, 'King Kong Collectables, Co.', 'Gao', 'Mike', '+852 2251 1555', 'Central Hong Kong', 'Hong Kong', 58600, '1995-01-03'),
(216, 'Enaco Distributors', 'Saavedra', 'Eduardo ', '(93) 203 4555', 'Barcelona', 'Spain', 60300, '2000-02-24'),
(219, 'Boards & Toys Co.', 'Young', 'Mary', '3105552373', 'Glendale', 'USA', 11000, '1996-11-09'),
(223, 'Natürlich Autos', 'Kloss', 'Horst ', '0372-555188', 'Cunewalde', 'Germany', 0, '1992-05-09'),
(227, 'Heintze Collectables', 'Ibsen', 'Palle', '86 21 3555', 'Århus', 'Denmark', 120800, '2007-01-29'),
(233, 'Québec Home Shopping Network', 'Fresnière', 'Jean ', '(514) 555-8054', 'Montréal', 'Canada', 48700, '2012-02-03'),
(237, 'ANG Resellers', 'Camino', 'Alejandra ', '(91) 745 6555', 'Madrid', 'Spain', 0, '1992-12-18'),
(239, 'Collectable Mini Designs Co.', 'Thompson', 'Valarie', '7605558146', 'San Diego', 'USA', 105000, '1991-10-26'),
(240, 'giftsbymail.co.uk', 'Bennett', 'Helen ', '(198) 555-8888', 'Cowes', 'UK', 93900, '2016-02-02'),
(242, 'Alpha Cognac', 'Roulet', 'Annette ', '61.77.6555', 'Toulouse', 'France', 61100, '2018-10-26'),
(247, 'Messner Shopping Network', 'Messner', 'Renate ', '069-0555984', 'Frankfurt', 'Germany', 0, '2007-07-18'),
(249, 'Amica Models & Co.', 'Accorti', 'Paolo ', '011-4988555', 'Torino', 'Italy', 113000, '2018-11-15'),
(250, 'Lyon Souveniers', 'Da Silva', 'Daniel', '+33 1 46 62 7555', 'Paris', 'France', 68100, '1992-12-15'),
(256, 'Auto Associés & Cie.', 'Tonini', 'Daniel ', '30.59.8555', 'Versailles', 'France', 77900, '2007-05-19'),
(259, 'Toms Spezialitäten, Ltd', 'Pfalzheim', 'Henriette ', '0221-5554327', 'Köln', 'Germany', 120400, '2011-10-12'),
(260, 'Royal Canadian Collectables, Ltd.', 'Lincoln', 'Elizabeth ', '(604) 555-4555', 'Tsawassen', 'Canada', 89600, '2018-01-22');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customerNumber`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `customerNumber` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12124;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
