-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2017 at 09:57 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `from_eshan`
--

-- --------------------------------------------------------

--
-- Table structure for table `connction__bridge`
--

CREATE TABLE `connction__bridge` (
  `id` int(11) NOT NULL,
  `s_id` int(11) NOT NULL,
  `m_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `connction__bridge`
--

INSERT INTO `connction__bridge` (`id`, `s_id`, `m_id`) VALUES
(1, 1, 2),
(2, 1, 9),
(3, 1, 10),
(4, 2, 1),
(5, 2, 2),
(6, 2, 3),
(7, 2, 4),
(8, 3, 11),
(9, 3, 12),
(10, 3, 13),
(11, 4, 14),
(12, 4, 15),
(13, 5, 16),
(14, 5, 17),
(15, 5, 19),
(16, 6, 5),
(17, 6, 7),
(18, 6, 6),
(19, 7, 18),
(20, 8, 20);

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `ID` int(5) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Designation` varchar(255) NOT NULL,
  `Phone` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`ID`, `Name`, `Designation`, `Phone`) VALUES
(1, 'Dr.Barkat Ullah', 'ENT', '+8801712546975'),
(2, 'Dr.Nusrat Jahan', 'Medicine', '+8801521346478'),
(3, 'Dr.Abdul Gaffar', 'Medicine', '+8801521245879'),
(4, 'Dr. Ruhul Amin', 'Neurologist', '+8801715235698'),
(5, 'Dr. Nur Nabi', 'Urology', '+8801521331018'),
(6, 'Dr. Esmail Hossen', 'Medicine', '+8801521307868');

-- --------------------------------------------------------

--
-- Table structure for table `medicines`
--

CREATE TABLE `medicines` (
  `m_id` int(11) NOT NULL,
  `m_name` varchar(600) NOT NULL,
  `m_provider` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicines`
--

INSERT INTO `medicines` (`m_id`, `m_name`, `m_provider`) VALUES
(1, 'Medicine:Ace \r\nParacetamol', 'Provider:Square'),
(2, 'Medicine:Adovas \r\nAdhatoda vasica', 'Provider:Square'),
(3, 'Medicine:XPa XR ( 665mg )\r\nParacetamol', 'Provider:Aristopharma'),
(4, 'Medicine:Cefixime', 'Provider:Acme'),
(5, 'Medicine:Xeldrin ( 20mg )\r\nOmeprazole', 'Provider:ACI'),
(6, 'Medicine:Seclo ( 40mg )\r\nomeprazole', 'Provider:Square'),
(7, 'Medicine:Pantonix ( 20mg )\r\nPantoprazole', 'Provider:Incepta'),
(9, 'Medicine:TOMEPHEN \r\nSyrup', 'Provider:Incepta '),
(10, 'Medicine:DEXTROMETHORPHAN', 'Provider:Beximco '),
(11, 'Medicine:Omidon', 'Provider:Incepta'),
(12, 'Medicine:Vertina Plus', 'Provider:Square'),
(13, 'Medicine:Avomine(25 mg)\r\nPromethazine Theoclate', 'Provider:Sanofi Aventise BD'),
(14, 'Medicine:Rifamax', 'Provider:Incepta'),
(15, 'Medicine:Probio\r\nProbiotic combination', 'Provider:Square'),
(16, 'Medicine:Burnsil', 'Provider:Beximco'),
(17, 'Medicine:Afun', 'Provider:Square'),
(18, 'Suggestion(s):1.Gargling often with warm salt water if your child is age 8 or older. You can make your own salt water by mixing 1 tsp (5 g) salt with 8 fl oz (240 mL) warm water.\r\n2-Drinking warm or cool liquids (whichever feels better). These include tea, soup, juice, and rehydration drinks.\r\nEating flavored ice pops, such as Popsicles.', 'Source:WebMD'),
(19, 'Suggestion(s):1- Hold the burned area under cool (not cold) running water for 10 to 15 minutes or until the pain eases.\r\n2-Apply moisturizer or aloe vera lotion or gel, which may provide relief in some cases.\r\n3-If needed, take an over-the-counter pain reliever, such as ibuprofen (Advil, Motrin IB, others), naproxen sodium (Aleve) or acetaminophen (Tylenol, others).\r\n**See your doctor if you develop large blisters**', 'Source:MAYO CLINIC'),
(20, 'Suggestion(s):1-Assist the casualty into a cool, shaded place\r\n2-Encourage them to sit down and stop any physical activity\r\n3-Provide plenty of water or Oral Rehydration Solution (ORS) to drink\r\n4-If the patient is suffering from cramp, stretch and massage the affected muscles\r\n5-Monitor and record vital signs (eg: pulse / respiratory rate) if trained\r\n6-Give children over 1 year old sips of clear fluids such as an oral electrolyte solution, ice chips, flat non-caffeinated soda, clear broth, or ice pops.Give 2 tablespoons every 15.', 'Source:KidsHealth');

-- --------------------------------------------------------

--
-- Table structure for table `symptoms`
--

CREATE TABLE `symptoms` (
  `s_id` int(4) NOT NULL,
  `Symptoms` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `symptoms`
--

INSERT INTO `symptoms` (`s_id`, `Symptoms`) VALUES
(1, 'Cough'),
(2, 'Fever'),
(3, 'Vomiting'),
(4, 'Diarrhoea'),
(5, 'Burn'),
(6, 'Acidity'),
(7, 'Tonsillitis'),
(8, 'Dehydration'),
(9, 'Test');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `connction__bridge`
--
ALTER TABLE `connction__bridge`
  ADD PRIMARY KEY (`id`),
  ADD KEY `s_id` (`s_id`),
  ADD KEY `m_id` (`m_id`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `medicines`
--
ALTER TABLE `medicines`
  ADD PRIMARY KEY (`m_id`),
  ADD KEY `m_id` (`m_id`);

--
-- Indexes for table `symptoms`
--
ALTER TABLE `symptoms`
  ADD PRIMARY KEY (`s_id`),
  ADD KEY `s_id` (`s_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `connction__bridge`
--
ALTER TABLE `connction__bridge`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `medicines`
--
ALTER TABLE `medicines`
  MODIFY `m_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `symptoms`
--
ALTER TABLE `symptoms`
  MODIFY `s_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `connction__bridge`
--
ALTER TABLE `connction__bridge`
  ADD CONSTRAINT `connction__bridge_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `symptoms` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `connction__bridge_ibfk_2` FOREIGN KEY (`m_id`) REFERENCES `medicines` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
