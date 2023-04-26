-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: hattmakdb
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
--  Create database
--
CREATE DATABASE hattdb CHARACTER SET utf8mb4 COLLATE utf8mb4_sv_0900_ai_ci;
USE hattdb;
/*This code is to create the database to enable the creation of a user for connecting to the database and the creation of the tables and example data*/
--
-- Create user for connecting to the database
--
CREATE USER hatta@localhost IDENTIFIED BY 'hattkey';
GRANT ALL PRIVILEGES ON hattdb.* TO hatta@localhost;
/*This code is to enable a connection to the database hattdb*/

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Employee` (
  `EmployeeID` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) NOT NULL,
  `Password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_sv_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (1,'Otto','panda'),(2,'Judith','tiger1'),(3,'Barnbarn','fernet');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Customer` (
  `CustomerID` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_sv_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES (1,'Kurt Lupton');
INSERT INTO `Customer` VALUES
(2,'Elin Bergqvist'),
(3,'Oscar Lindström'),
(4,'Hanna Nilsson'),
(5,'Lars Andersson'),
(6,'Ida Johansson'),
(7,'Erik Svensson'),
(8,'Anna Karlsson'),
(9,'Peter Gustafsson'),
(10,'Sara Lundgren'),
(11,'Johan Persson'),
(12,'Emma Ahlström');
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Email`
--

DROP TABLE IF EXISTS `Email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Email` (
  `EmailID` int(20) NOT NULL AUTO_INCREMENT,
  `Email_address` varchar(50) DEFAULT NULL,
  `Customer` int(10) NOT NULL,
  PRIMARY KEY (`EmailID`),
  CONSTRAINT `Email_Customer_fk` FOREIGN KEY (`Customer`) REFERENCES `Customer` (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_sv_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Email`
--

LOCK TABLES `Email` WRITE;
/*!40000 ALTER TABLE `Email` DISABLE KEYS */;
INSERT INTO `Email` VALUES (1,'Kurre.Lupton@gmail.com',1);
/*!40000 ALTER TABLE `Email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Address`
--

DROP TABLE IF EXISTS `Address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Address` (
  `AddressID` int(20) NOT NULL AUTO_INCREMENT,
  `Street` varchar(20) DEFAULT NULL,
  `House_number` varchar(5) DEFAULT NULL,
  `Customer` int(10) DEFAULT NULL,
  PRIMARY KEY (`AddressID`),
  CONSTRAINT `Address_Customer_CustomerID_fk` FOREIGN KEY (`Customer`) REFERENCES `Customer` (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_sv_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Address`
--

LOCK TABLES `Address` WRITE;
/*!40000 ALTER TABLE `Address` DISABLE KEYS */;
INSERT INTO `Address` VALUES (1,'Grusvägen','14E',1);
INSERT INTO `Address` VALUES
(2,'Björkgatan','5A',2),
(3,'Smedjegatan','17C',3),
(4,'Lärkvägen','11B',4),
(5,'Rosenvägen','2',5),
(6,'Parkgatan','8',6),
(7,'Kungsgatan','13D',7),
(8,'Åsgatan','20',8),
(9,'Furuvägen','6',9),
(10,'Storgatan','12B',10),
(11,'Ängsvägen','7',11),
(12,'Vasagatan','3C',12);
/*!40000 ALTER TABLE `Address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Order`
--

DROP TABLE IF EXISTS `Order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Order` (
  `OrderID` int(14) NOT NULL AUTO_INCREMENT,
  `Amount` int(3) DEFAULT NULL,
  `Total_Price` double DEFAULT NULL,
  `Order_date` date NOT NULL,
  `Shipment_date` date DEFAULT NULL,
  `Invoice_sent_status` bit NOT NULL,
  `Payment_status` bit NOT NULL,
  `Order_complete_status` bit NOT NULL,
  `Created_by_employee` int(10) NOT NULL,
  `Customer` int(10) NOT NULL,
  `Picture_exist` varchar(50),
  PRIMARY KEY (`OrderID`),
  CONSTRAINT `Order_Created_by_employee_EmployeeID_fk` FOREIGN KEY (`Created_by_employee`) REFERENCES `Employee` (`EmployeeID`),
  CONSTRAINT `Order_Customer_CustomerID_fk` FOREIGN KEY (`Customer`) REFERENCES `Customer` (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_sv_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Order`
--

LOCK TABLES `Order` WRITE;
/*!40000 ALTER TABLE `Order` DISABLE KEYS */;
INSERT INTO `Order` (`Amount`, `Total_Price`, `Order_date`, `Shipment_date`, `Invoice_sent_status`, `Payment_status`, `Order_complete_status`, `Created_by_employee`, `Customer`, `Picture_exist`)
VALUES
(3, 350, '2020-01-10', '2020-01-14', 1, 0, 0, 2, 7, 'nej'),
(2, 150, '2020-02-15', '2020-02-20', 1, 1, 0, 3, 4, 'ja'),
(3, 500, '2021-03-20', '2021-03-25', 0, 0, 0, 1, 9, 'nej'),
(1, 750., '2021-04-01', '2021-04-05', 1, 1, 1, 1, 2, 'nej'),
(2, 800, '2021-05-07', '2021-05-12', 0, 1, 0, 2, 10, 'ja'),
(2, 2000, '2021-06-14', '2021-06-19', 1, 1, 1, 3, 3, 'nej'),
(1, 450, '2022-07-21', '2022-07-26', 0, 0, 0, 1, 6, 'nej'),
(3, 500, '2022-08-02', '2022-08-07', 1, 0, 0, 2, 1, 'ja'),
(2, 550, '2022-09-18', '2022-09-23', 1, 1, 0, 1, 8, 'ja'),
(2, 1000, '2022-10-25', '2022-10-30', 0, 1, 1, 2, 5, 'nej');

/*!40000 ALTER TABLE `Order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Hat`
--

DROP TABLE IF EXISTS `Hat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Hat` (
  `HatID` int(30) NOT NULL AUTO_INCREMENT,
  `Size` double NOT NULL,
  `Price` double DEFAULT NULL,
  `Color` varchar(20) NOT NULL,
  `Description` varchar(250) NOT NULL,
  `image` varchar(250) NULL,
  `material_cost` int NOT NULL,
  `hour_per_hat` int NOT NULL,
  PRIMARY KEY (`HatID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_sv_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Hat`
--

LOCK TABLES `Hat` WRITE;
/*!40000 ALTER TABLE `Hat` DISABLE KEYS */;
INSERT INTO `Hat` (`Size`, `Price`, `Color`, `Description`, `image`, `material_cost`, `hour_per_hat`)
VALUES
(56.0, 300, 'Röd', 'Detta är en röd hatt', 'Ingen skiss vald', 100, 2),
(60.5, 500, 'Blå', 'Detta är en blå hatt', 'Ingen skiss vald', 120, 3),
(55.0, 250, 'Grön', 'Detta är en grön hatt', 'Ingen skiss vald', 90, 2),
(58.0, 700, 'Gul', 'Detta är en gul hatt', 'Ingen skiss vald', 150, 4),
(57.5, 600, 'Lila', 'Detta är en lila hatt', 'Ingen skiss vald', 130, 3),
(59.0, 1000, 'Rosa', 'Detta är en rosa hatt', 'Ingen skiss vald', 180, 5),
(54.5, 350, 'Svart', 'Detta är en svart hatt', 'Ingen skiss vald', 100, 2),
(61.0, 800, 'Brun', 'Detta är en brun hatt', 'Ingen skiss vald', 140, 3),
(53.5, 200, 'Vit', 'Detta är en vit hatt', 'Ingen skiss vald', 80, 2),
(59.5, 900, 'Beige', 'Detta är en beige hatt', 'Ingen skiss vald', 160, 4);

/*!40000 ALTER TABLE `Hat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Hat_in_order`
--

DROP TABLE IF EXISTS `Hat_in_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Hat_in_order` (
  `HatID` int(30) NOT NULL,
  `OrderID` int(14) NOT NULL,
  PRIMARY KEY (`HatID`,`OrderID`),
  CONSTRAINT `Hat_in_order_ibfk_1` FOREIGN KEY (`HatID`) REFERENCES `Hat` (`HatID`),
  CONSTRAINT `Hat_in_order_ibfk_2` FOREIGN KEY (`OrderID`) REFERENCES `Order` (`OrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_sv_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Hat_in_order`
--

LOCK TABLES `Hat_in_order` WRITE;
/*!40000 ALTER TABLE `Hat_in_order` DISABLE KEYS */;
INSERT INTO Hat_in_order (HatID, OrderID)
VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 2),
(6, 2),
(7, 3),
(9, 3),
(10, 3),
(1, 4),
(5, 5),
(6, 5),
(2, 6),
(3, 6),
(8, 7),
(1, 8),
(4, 8),
(5, 8),
(6, 9),
(8, 9),
(2, 10),
(3, 10);

/*!40000 ALTER TABLE `Hat_in_order` ENABLE KEYS */;
UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Altered by Theo Sohlman
