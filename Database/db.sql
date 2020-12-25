CREATE DATABASE  IF NOT EXISTS `globaltech` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `globaltech`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: globaltech
-- ------------------------------------------------------
-- Server version	5.5.5-10.5.4-MariaDB

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
-- Table structure for table `answer_comments`
--

DROP TABLE IF EXISTS `answer_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer_comments` (
  `comment_id` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `ans_id` varchar(255) NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK7g5llc53qwfxtwn9l5llnkftt` (`ans_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer_comments`
--

LOCK TABLES `answer_comments` WRITE;
/*!40000 ALTER TABLE `answer_comments` DISABLE KEYS */;
INSERT INTO `answer_comments` VALUES ('91775b2b-3a8c-4f15-a68f-0a9d18fbc7ca','2020-10-27 20:29:21','2020-10-27 20:29:21','Ok Looks nice. But i would expect more.... Can you provide more info on this topic','23114aa7-e244-4da1-b15b-3f38e44c7919','316a8d0a-9e01-4de7-890e-1695c983ca21');
/*!40000 ALTER TABLE `answer_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer_likes`
--

DROP TABLE IF EXISTS `answer_likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer_likes` (
  `answer_likes_id` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `answer_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`answer_likes_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer_likes`
--

LOCK TABLES `answer_likes` WRITE;
/*!40000 ALTER TABLE `answer_likes` DISABLE KEYS */;
/*!40000 ALTER TABLE `answer_likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answers` (
  `answer_id` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `answer_description` varchar(500) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `question_id` varchar(255) NOT NULL,
  PRIMARY KEY (`answer_id`),
  KEY `FKs4j12sfj254yawphx0k1xrl3f` (`question_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES ('316a8d0a-9e01-4de7-890e-1695c983ca21','2020-10-27 20:27:08','2020-10-27 20:27:08','Lorem ipsum dolor sit amet, consectetuer adipiscin','fcdca8e9-ecbc-4ee1-8935-bc5befd8e61b','0359c7ae-a9b1-4a52-875e-f7e47aa6a6f0');
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_details`
--

DROP TABLE IF EXISTS `company_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_details` (
  `company_id` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `company_representative` varchar(255) DEFAULT NULL,
  `company_location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_details`
--

LOCK TABLES `company_details` WRITE;
/*!40000 ALTER TABLE `company_details` DISABLE KEYS */;
INSERT INTO `company_details` VALUES ('6b1ab30b-a470-4276-989d-02b0051e3cfd','2020-10-27 20:24:50','2020-10-27 20:24:50','Amazon','Amazon Manager','US');
/*!40000 ALTER TABLE `company_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `question_id` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `company_asked` varchar(255) DEFAULT NULL,
  `company_id` varchar(255) DEFAULT NULL,
  `question_description` varchar(500) DEFAULT NULL,
  `question_title` varchar(100) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES ('0359c7ae-a9b1-4a52-875e-f7e47aa6a6f0','2020-10-27 20:25:12','2020-10-27 20:25:12','Amazon','6b1ab30b-a470-4276-989d-02b0051e3cfd','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidun. Cras dapibus','Just Doubt on Linux Network Bonding','fb58a754-5695-4cb2-b9c3-d3922b6be096');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_company_mapping`
--

DROP TABLE IF EXISTS `question_company_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_company_mapping` (
  `question_company_mapping_id` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `qcm_companies_asked` varchar(255) DEFAULT NULL,
  `question_id` varchar(255) NOT NULL,
  PRIMARY KEY (`question_company_mapping_id`),
  KEY `FK9cjk9162fov4wf8eok5wvpccq` (`question_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_company_mapping`
--

LOCK TABLES `question_company_mapping` WRITE;
/*!40000 ALTER TABLE `question_company_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `question_company_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_likes`
--

DROP TABLE IF EXISTS `question_likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_likes` (
  `questionlikes_id` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `question_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`questionlikes_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_likes`
--

LOCK TABLES `question_likes` WRITE;
/*!40000 ALTER TABLE `question_likes` DISABLE KEYS */;
INSERT INTO `question_likes` VALUES ('83bac922-2714-4f36-9ebf-df59096a9b56','2020-10-27 20:25:38','2020-10-27 20:25:38','0359c7ae-a9b1-4a52-875e-f7e47aa6a6f0','fb58a754-5695-4cb2-b9c3-d3922b6be096'),('08ee68b5-2899-489b-af69-c7b8baf1afdf','2020-10-27 20:26:06','2020-10-27 20:26:06','0359c7ae-a9b1-4a52-875e-f7e47aa6a6f0','423a3a9b-f5dc-4942-a471-a06b1f28da16');
/*!40000 ALTER TABLE `question_likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_tags`
--

DROP TABLE IF EXISTS `question_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_tags` (
  `question_tag_id` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `question_id` varchar(255) NOT NULL,
  PRIMARY KEY (`question_tag_id`),
  KEY `FKf76giw3qwi7ooxeims83jp29k` (`question_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_tags`
--

LOCK TABLES `question_tags` WRITE;
/*!40000 ALTER TABLE `question_tags` DISABLE KEYS */;
INSERT INTO `question_tags` VALUES ('c5b9b085-c072-4355-a87a-047c8a77e11a','2020-10-27 20:25:13','2020-10-27 20:25:13','0359c7ae-a9b1-4a52-875e-f7e47aa6a6f0');
/*!40000 ALTER TABLE `question_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_topic`
--

DROP TABLE IF EXISTS `question_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_topic` (
  `topic_id` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `subtopic` varchar(255) DEFAULT NULL,
  `topic_name` varchar(255) DEFAULT NULL,
  `question_id` varchar(255) NOT NULL,
  PRIMARY KEY (`topic_id`),
  KEY `FKqvg2x949cnm9imyodw54fmhlw` (`question_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_topic`
--

LOCK TABLES `question_topic` WRITE;
/*!40000 ALTER TABLE `question_topic` DISABLE KEYS */;
INSERT INTO `question_topic` VALUES ('86e6c4fd-612a-423a-84cc-e02ec3332d75','2020-10-27 20:25:13','2020-10-27 20:25:13','Algorithms','DS','0359c7ae-a9b1-4a52-875e-f7e47aa6a6f0');
/*!40000 ALTER TABLE `question_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tags`
--

DROP TABLE IF EXISTS `tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tags` (
  `tag_id` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `question_tag_id` varchar(255) NOT NULL,
  PRIMARY KEY (`tag_id`),
  KEY `FK17pcjo5puk2pprn96v26mynpe` (`question_tag_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tags`
--

LOCK TABLES `tags` WRITE;
/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
INSERT INTO `tags` VALUES ('023ccee9-8a0f-45c3-9fe9-862d3b67537d','2020-10-27 20:25:13','2020-10-27 20:25:13','Array,Stack,Queue','c5b9b085-c072-4355-a87a-047c8a77e11a');
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_details` (
  `user_id` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT INTO `user_details` VALUES ('fb58a754-5695-4cb2-b9c3-d3922b6be096','2020-10-27 20:24:40','2020-10-27 20:24:40','mmayuresh12@gmail.com','Mayuresh','s4v+IQ648dZNfPxsMaTOaQ==',NULL),('423a3a9b-f5dc-4942-a471-a06b1f28da16','2020-10-27 20:25:56','2020-10-27 20:25:56','dummy@gmail.com','Dummy','s4v+IQ648dZNfPxsMaTOaQ==',NULL),('fcdca8e9-ecbc-4ee1-8935-bc5befd8e61b','2020-10-27 20:26:30','2020-10-27 20:26:30','ans@gmail.com','Answer_Giver','s4v+IQ648dZNfPxsMaTOaQ==',NULL);
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'globaltech'
--

--
-- Dumping routines for database 'globaltech'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-27 21:34:57
