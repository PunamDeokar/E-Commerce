-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: estore
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product_list`
--

DROP TABLE IF EXISTS `product_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_list` (
  `id` int NOT NULL AUTO_INCREMENT,
  `prod_name` varchar(255) DEFAULT NULL,
  `prod_Description` varchar(255) DEFAULT NULL,
  `prod_Price` int DEFAULT NULL,
  `prod_Quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_list`
--

LOCK TABLES `product_list` WRITE;
/*!40000 ALTER TABLE `product_list` DISABLE KEYS */;
INSERT INTO `product_list` VALUES (1,'Samsung S23 FE 5G','8GB, 128GB Storage',59999,8),(2,'Apple-ipad','10.9inch, 64GB-Blue',43110,10),(3,'Sony-Bravia LED','4k Ultra HD Smart LED',53990,8),(4,'LG Washing Machine','7KG 5 Star Fully Automatic',26990,12),(5,'EarBuds OnePlus Nord 2','Earbuds with Mic, Upto 25dB ANC 12.4mm',2999,8),(6,'LG-Refrigirator','5 Star Double Door Frost Free Smart Inverter',33990,10),(7,'Smart Watch Boat','Alexa built-in, 1.69HD Display',1999,12),(8,'Laptop Hp-Pavilion 14','11th Gen intel Core i5-1155g7, 14 inch',63800,5),(9,'Safari-Trolley Bag','Polypropylene Hard Sided 4 wheelers 360 Degree Wheeling System',1899,6),(10,'Bluetooth Speaker-Boat','10W RMS Stereo sound',1599,8),(11,'OppoReno-4Pro','8GB/128,64-MP',30000,5),(12,'OppoReno-3','16GB/128,56MP-Camera',27000,6),(13,'Iphone-15','12MP-Camera,SmartHDR-5',75000,4),(14,'Haier_Washing_Machine','5L-Top_Loaded,5Star',25000,6),(15,'LG_Refrigirator','Double-Door,5Star',28000,7),(16,'LG-Refrigirator','Single_Door,4Star',19000,6),(17,'LG-Washing_Machine','6L,Semi_Automatic',16000,7);
/*!40000 ALTER TABLE `product_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-25 16:50:17
