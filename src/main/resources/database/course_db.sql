-- MySQL dump 10.13  Distrib 8.3.0, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: course_db
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_course`
--

DROP TABLE IF EXISTS `t_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_course` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(64) NOT NULL,
  `description` varchar(128) DEFAULT NULL,
  `category` varchar(64) NOT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_data` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_course`
--

LOCK TABLES `t_course` WRITE;
/*!40000 ALTER TABLE `t_course` DISABLE KEYS */;
INSERT INTO `t_course` VALUES (1,'语文','Chinese class','1','2024-02-21 01:06:14','2024-02-21 01:27:50'),(2,'数学','Math class','2','2024-02-21 01:27:50','2024-02-21 01:27:50'),(3,'英语','English class','3','2024-02-21 01:27:50','2024-02-21 01:27:50'),(4,'政治','Political class','4','2024-02-21 01:27:50','2024-02-21 01:27:50'),(5,'历史','History class','5','2024-02-21 01:27:50','2024-02-21 01:27:50'),(6,'地理','Geography class','6','2024-02-21 01:27:50','2024-02-21 01:27:50'),(7,'物理','Physics class','7','2024-02-21 01:27:50','2024-02-21 01:27:50'),(8,'化学','Chemistry class','8','2024-02-21 01:27:50','2024-02-21 01:27:50'),(9,'生物','Biology class','9','2024-02-21 01:27:50','2024-02-21 01:27:50'),(10,'存储过程','store procedure','10','2024-02-22 02:06:07','2024-02-22 02:06:07');
/*!40000 ALTER TABLE `t_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_course_enrollment`
--

DROP TABLE IF EXISTS `t_course_enrollment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_course_enrollment` (
  `enrollment_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL COMMENT 'user_id = course_db.t_user.user_id',
  `course_id` int NOT NULL,
  `enrollment_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`enrollment_id`),
  KEY `t_course_enrollment_t_course_course_id_fk` (`course_id`),
  CONSTRAINT `t_course_enrollment_t_course_course_id_fk` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_course_enrollment`
--

LOCK TABLES `t_course_enrollment` WRITE;
/*!40000 ALTER TABLE `t_course_enrollment` DISABLE KEYS */;
INSERT INTO `t_course_enrollment` VALUES (1,1,1,'2024-02-21 01:29:01'),(2,1,2,'2024-02-21 01:29:01'),(3,1,3,'2024-02-21 01:29:01'),(4,2,1,'2024-02-21 01:29:01'),(5,2,4,'2024-02-21 01:29:01'),(6,3,5,'2024-02-21 01:29:01'),(7,3,1,'2024-02-21 01:29:01'),(8,3,7,'2024-02-21 01:29:01'),(9,4,6,'2024-02-21 01:29:01'),(10,4,8,'2024-02-21 01:29:01'),(11,5,1,'2024-02-21 01:29:01'),(12,5,3,'2024-02-21 22:41:20'),(13,5,6,'2024-02-21 22:41:20'),(14,5,2,'2024-02-21 22:41:20');
/*!40000 ALTER TABLE `t_course_enrollment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-22  2:12:29
