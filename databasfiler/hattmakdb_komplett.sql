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
CREATE DATABASE hattmakdb CHARACTER SET utf8mb4 COLLATE utf8mb4_sv_0900_ai_ci;
USE hattmakdb;
/*This code is to create the database to enable the creation of a user for connecting to the database and the creation of the tables and example data*/
--
-- Create user for connecting to the database
--
CREATE USER hattdba@localhost IDENTIFIED BY 'hattkey';
GRANT ALL PRIVILEGES ON hattmakdb.* TO hattdba@localhost;
/*This code is to enable a connection to the database hattmakdb*/

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
  `Picture` blob,
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
INSERT INTO `Order` VALUES (178,1,'','2023-03-31','',0,0,0,1,1);
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
  PRIMARY KEY (`HatID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_sv_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Hat`
--

LOCK TABLES `Hat` WRITE;
/*!40000 ALTER TABLE `Hat` DISABLE KEYS */;
INSERT INTO `Hat` VALUES (331,'41','1200','Red','A large red hat filled with flowers at the top. The hat should also have a white linen band around it.');
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
INSERT INTO `Hat_in_order` VALUES (331,178);
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
