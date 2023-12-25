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
-- Table structure for table `registereduser`
--

DROP TABLE IF EXISTS `registereduser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registereduser` (
  `U_id` int NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(255) DEFAULT NULL,
  `Last_Name` varchar(255) DEFAULT NULL,
  `Username` varchar(255) DEFAULT NULL,
  `U_Password` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Mobile_No` mediumtext,
  PRIMARY KEY (`U_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registereduser`
--

LOCK TABLES `registereduser` WRITE;
/*!40000 ALTER TABLE `registereduser` DISABLE KEYS */;
INSERT INTO `registereduser` VALUES (1,'Punam','Deokar','DeokarPunam','Punam123','Pune','deokarpunam217@gmail.com','9172036205'),(3,'Pavan','Deokar','DeokarPavan','Pavan123','Chandigarh','deokarpavan@gmail.com','7721894551'),(4,'Shrikant','Tembhe','ShriTembhe','Shri123','Amravati','shritembhe@gmail.com','9998877665'),(5,'Shourya','Khirodkar','Shourya2023','shourya123','Jalgao','shouryakhirodkar@gmail.com','9988776655'),(6,'Nilkant','Lokhande','nillokhande','nil123','Pune','nillokhande@gmail.com','9098907766'),(7,'Meet','Patil','PatilMeet','Meet123','Mumbai','meetpatil@gmail.com','9172036205'),(8,'Sham','Patil','patilsham','Sham123','Nagpur','shampatil@gmail.com','9922334414'),(9,'Ganesh','Wankhede','WankhedeGanesh','Ganesh123','Mumbai','ganeshwankhede@gmail.com','9689330056'),(10,'Raju','Deokar','DeokarRaju','Raju123','Malkapur','rajudeokar@gmail.com','7038252617'),(11,'Punam','Deokar','DeokarPunam','Punam123','Pune','deokarpunam217@gmail.com','9172036205'),(12,'Shri','Tembhe','TembheShri','Shri123','Amravati','ShriTembhe123','7709262910'),(13,'Mahi','Patil','PatilMahi','Mahi123','Mumbai','mahipatil@gmail.com','9172036205'),(14,'vani','Nihalani','NihalaniVani','vani123','Pune','vaninihalani@gmail.com','9689330056'),(15,'Rohan','Kale','KaleRohan','Rohan123','Pune','kalerohan@gmail.com','9988776655'),(16,'Punam','Deokar','DeokarPunam','Punam123','Pune','deokarpunam217@gmail.com','9172036205'),(17,'Rani','Patil','PatilRani','Rani123','Pune','Rani@gmail.com','887799669'),(18,'Seema','Tayade','TayadeSeema','Seema123','Malkapur','Seema@gmail.com','9172036407');
/*!40000 ALTER TABLE `registereduser` ENABLE KEYS */;
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
