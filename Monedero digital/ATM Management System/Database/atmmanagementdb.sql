CREATE DATABASE  IF NOT EXISTS `atmmanagement` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `atmmanagement`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: atmmanagement
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `amount_transaction`
--

DROP TABLE IF EXISTS `amount_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amount_transaction` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `accountnumber` varchar(200) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `totalbalance` bigint DEFAULT NULL,
  `transaction_amount` bigint DEFAULT NULL,
  `transactiontype` varchar(200) DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amount_transaction`
--

LOCK TABLES `amount_transaction` WRITE;
/*!40000 ALTER TABLE `amount_transaction` DISABLE KEYS */;
INSERT INTO `amount_transaction` VALUES (1,'67789898989','2023-07-01 19:53:39.023000',3000,3000,'Deposit',3,'User02'),(2,'67789898989','2023-07-01 19:54:01.696000',500,2500,'Withdrow',3,'User02'),(4,'67789898989','2023-07-01 19:55:46.087000',700,200,'Deposit',3,'User02'),(5,'67789898989','2023-07-01 19:56:06.373000',12700,12000,'Deposit',3,'User02'),(6,'67789898989','2023-07-01 19:56:18.538000',2700,10000,'Withdrow',3,'User02'),(7,'697779997976','2023-07-01 19:56:36.335000',100,100,'Deposit',2,'User1'),(8,'697779997976','2023-07-01 19:56:44.493000',80,20,'Withdrow',2,'User1'),(9,'697779997976','2023-07-01 19:56:55.249000',50,30,'Withdrow',2,'User1'),(10,'697779997976','2023-07-01 19:57:02.072000',250,200,'Deposit',2,'User1');
/*!40000 ALTER TABLE `amount_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `accountnumber` varchar(255) DEFAULT NULL,
  `address` varchar(3000) DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phoneno` varchar(255) DEFAULT NULL,
  `pin` varchar(4) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'378909850924','Mumbai','1998-10-31 00:00:00.000000','Admin@123gmail.com','Male','Admin@1234','9867493248','9089',1,'ADMIN','Admin'),(2,'697779997976','Ut laboriosam maior','2023-06-21 00:00:00.000000','vopegolyna@mailinator.com','Female','Pa$$w0rd!','+1 (486) 619-5722','1234',2,'User','User1'),(3,'67789898989','Id laudantium place','2023-06-21 00:00:00.000000','hamaranill@mailinator.com','Male','Pa$$w0rd!','+1 (629) 703-6670','4564',2,'User','User02');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-01 19:59:53
