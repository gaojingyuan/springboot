-- MySQL dump 10.13  Distrib 5.6.31, for osx10.11 (x86_64)
--
-- Host: localhost    Database: springboot
-- ------------------------------------------------------
-- Server version	5.6.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) NOT NULL,
  `map` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Australia','-27.470933, 153.023502','Brisbane','Queensland'),(2,'Australia','-37.813187, 144.96298','Melbourne','Victoria'),(3,'Australia','-33.868901, 151.207091','Sydney','New South Wales'),(4,'Canada','45.508889, -73.554167','Montreal','Quebec'),(5,'Israel','32.066157, 34.777821','Tel Aviv',''),(6,'Japan','35.689488, 139.691706','Tokyo',''),(7,'Spain','41.387917, 2.169919','Barcelona','Catalunya'),(8,'Switzerland','46.992979, 6.931933','Neuchatel',''),(9,'UK','51.381428, -2.357454','Bath','Somerset'),(10,'UK','51.500152, -0.126236','London',''),(11,'UK','50.902571, -1.397238','Southampton','Hampshire'),(12,'USA','33.748995, -84.387982','Atlanta','GA'),(13,'USA','41.878114, -87.629798','Chicago','IL'),(14,'USA','44.811349, -91.498494','Eau Claire','WI'),(15,'USA','26.011201, -80.14949','Hollywood','FL'),(16,'USA','25.788969, -80.226439','Miami','FL'),(17,'USA','28.083627, -80.608109','Melbourne','FL'),(18,'USA','40.714353, -74.005973','New York','NY'),(19,'USA','28.034462, -80.588665','Palm Bay','FL'),(20,'USA','37.77493, -122.419415','San Francisco','CA'),(21,'USA','38.895112, -77.036366','Washington','DC'),(22,'china','map','hhharbin','0'),(23,'china','map','hhharbin','0'),(24,'china','map','hhharbin','0'),(26,'china','map','hhharbin','0'),(27,'china','m','beijing','0'),(29,'china','m','beijing','0'),(30,'china','m','beijing','0'),(34,'china','m','beijing','0'),(35,'china','m','beijing','0'),(36,'china','m','beijing','0'),(37,'china','m','beijing','0'),(38,'china','m','beijing','0'),(39,'china','m','beijing','0'),(40,'china','m','beijing','0'),(41,'china','m','beijing','0'),(42,'china','m','beijing','0'),(43,'china','m','beijing','0'),(45,'china','m','beijing','0'),(46,'china','m','beijing','0'),(48,'china','m','beijing','0'),(49,'china','m','beijing','0'),(54,'china','m','beijing','0'),(55,'china','m','beijing','0'),(56,'china','m','beijing','0'),(57,'china','m','beijing','0'),(58,'china','m','beijing','0'),(59,'china','m','beijing','0'),(60,'china','m','beijing','0'),(61,'china','m','beijing','0'),(64,'china','m','beijing','0'),(66,'china','m','beijing','0'),(67,'china','m','beijing','0'),(68,'china','m','beijing','0'),(69,'china','m','beijing','0'),(70,'china','m','beijing','0'),(71,'china','m','beijing','0'),(72,'china','m','beijing','0'),(73,'china','m','beijing','0'),(74,'china','m','beijing','0');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `zip` varchar(255) NOT NULL,
  `city_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i80qjsl99gene06k3t31y3sv5` (`city_id`,`name`),
  CONSTRAINT `FKf1iabdv6bi2yohh9h48wce42x` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'William & George Streets','Conrad Treasury Place','4001',1),(2,'1 Southgate Ave, Southbank','The Langham','3006',2),(3,'68 Market Street','Swissotel','2000',3),(4,'1228 Sherbrooke St','Ritz Carlton','H3G1H6',4),(5,'Independence Park','Hilton Tel Aviv','63405',5),(6,'Takeshiba Pier','InterContinental Tokyo Bay','105',6),(7,'Passeig del Taulat 262-264','Hilton Diagonal Mar','08019',7),(8,' Esplanade Leopold-Robert 2','Hotel Beaulac','2000',8),(9,'Weston Road','The Bath Priory Hotel','BA1 2XT',9),(10,'Rossiter Road, Widcombe Basin','Bath Travelodge','BA2 4JP',9),(11,'Albany Street','Melia White House','NW1 3UP',10),(12,'The Cottage, Southampton Business Park','Chilworth Manor','SO16 7JF',11),(13,'Tower Place, Buckhead','Marriott Courtyard','30305',12),(14,'Peachtree Rd, Buckhead','Ritz Carlton','30326',12),(15,'Tower Place, Buckhead','Doubletree','30305',12),(16,'171 West Randolph Street','Hotel Allegro','60601',13),(17,'2106 N Clairemont Ave','Sea Horse Inn','54703',14),(18,'1151 W Macarthur Ave','Super 8 Eau Claire Campus Area','54701',14),(19,'3555 S. Ocean Drive','Westin Diplomat','33019',15),(20,'1395 Brickell Ave','Conrad Miami','33131',16),(21,'3101 North Hwy','Radisson Suite Hotel Oceanfront','32903',17),(22,'Union Square, Manhattan','W Union Hotel','10011',18),(23,'Lexington Ave, Manhattan','W Lexington Hotel','10011',18),(24,'70 Park Avenue','70 Park Avenue Hotel','10011',18),(25,'890 Palm Bay Rd NE','Jameson Inn','32905',19),(26,'55 Fourth Street','Marriot Downtown','94103',20),(27,'1315 16th Street NW','Hotel Rouge','20036',21);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `check_in_date` date NOT NULL,
  `details` varchar(5000) NOT NULL,
  `idx` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `trip_type` int(11) NOT NULL,
  `hotel_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi0ly7ivbh8ijdgoi7cwtuoavt` (`hotel_id`),
  CONSTRAINT `FKi0ly7ivbh8ijdgoi7cwtuoavt` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'2005-05-10','I stayed in 2005, the hotel was nice enough but nothing special.',0,2,'Pretty average',4,2),(2,'2006-01-12','This hotel has a fantastic lovely big windows.  The room we stayed in had lots of space.  Recommended.',1,4,'Bright hotel with big rooms',2,2),(3,'2006-05-25','I liked this hotel and would stay again.',2,3,'Pretty good',1,2),(4,'2009-01-20','The rooms are maintained to a high standard and very clean, the bathroom was spotless!!',3,3,'Nice clean rooms',2,2),(5,'2000-01-23','We stayed here after a wedding and it was fantastic.  Recommend to all.',0,4,'A lovely hotel',1,9),(6,'2000-08-04','A very special hotel with lovely staff.',1,3,'Very special',1,9),(7,'2001-01-01','Stayed during the summer heat wave (exceptional for England!) and the room was very hot.  Still recommended.',2,2,'Nice but too hot',4,9),(8,'2002-01-20','Considering how central this hotel is the rooms are a very good size.',3,3,'Big rooms and a great view',1,9),(9,'2002-11-03','A nice hotel but be prepared to pay over the odds for your stay.',4,2,'Good but pricey',1,9),(10,'2003-09-18','Just lovely.',5,4,'Fantastic place',1,9),(11,'2004-03-21','I stayed here in 2004 and found it to be very relaxing, a nice pool and good gym is cherry on the cake.',6,4,'A very special place',3,9),(12,'2004-04-10','I complained after I was told I could not check out after 11pm.  Ridiculous!!!',7,0,'Terrible',0,9),(13,'2004-12-20','Central location makes this a perfect hotel.  Be warned though, it\'s not cheap.',8,4,'A perfect location',4,9),(14,'2005-04-19','Dig deep into your pockets and enjoy this lovely City and fantastic hotel.',9,3,'Expensive but worth it',2,9),(15,'2005-05-21','Top hotel in the area, would not stay anywhere else.',10,4,'The best hotel in the area',1,9),(16,'2005-11-17','The garden upkeep run into thousands (perhaps explaining why the rooms are so much) but so lovely and relaxing.',11,4,'Lovely hotel, fantastic grounds',2,9),(17,'2006-01-04','Top draw stuff.',12,3,'Gorgeous Top Quality Hotel',4,9),(18,'2006-01-21','The food at this hotel is second to none, try the peppered steak!',13,4,'Fabulous Hotel and Restaurant',1,9),(19,'2006-01-29','A lovely home away from home.',14,4,'Feels like home',4,9),(20,'2006-03-21','Overpriced, Overpriced, Overpriced!!',15,1,'Far too expensive',1,9),(21,'2006-05-10','The staff went out of their way to help us after we missed our last train home, organising a Taxi back to Newport even after we had checked out.',16,4,'Excellent Hotel, Wonderful Staff',1,9),(22,'2007-09-11','If you want a relaxing stay, this is the place.',17,3,'The perfect retreat',2,9),(23,'2008-06-01','As other reviews have noted, the staff in this hotel really are the best in Bath.',18,3,'Lovely stay, fantastic staff',3,9),(24,'2009-05-14','We will stay again for sure.',19,4,'Can\'t Wait to go back',2,9),(25,'2010-04-26','We won a trip here after entering a competition.  Not sure we would pay the full price but such a wonderful place.',20,4,'Amazing Hotel',1,9),(26,'2010-10-26','The pool was closed, the chief was ill, the staff were rude my wallet is bruised!',21,2,'Dissapointed',2,9),(27,'2002-08-21','One of the worst hotels that I have ever stayed in.',0,0,'Terrible hotel',2,10),(28,'2003-01-28','The staff refused to help me with any aspect of my stay, I will not stay here again.',1,0,'Rude and unpleasant staff',0,10),(29,'2004-06-17','Don\'t stay here!!',2,1,'Below par',0,10),(30,'2005-07-12','The room was far too small and felt unclean.  Not recommended.',3,0,'Small and Unpleasant',1,10),(31,'2006-01-07','This hotel has some rough edges but I challenge you to find somewhere cheaper.',4,1,'Cheap if you are not fussy',4,10),(32,'2006-01-13','Just terrible!',5,0,'Terrible',2,10),(33,'2006-03-25','My room smelt of damp and I found the socks of the previous occupant under my bed.',6,0,'Smelly and dirty room',0,10),(34,'2006-04-09','Grim.  I would try elsewhere before staying here.',7,0,'Grim',4,10),(35,'2006-08-01','Building work during the day and a disco at night.  Good grief!',8,1,'Very Noisy',3,10),(36,'2009-01-03','This hotel is in serious need of refurbishment, the windows are rotting, the paintwork is tired and the carpets are from the 1970s.',9,1,'Tired and falling down',4,10),(37,'2009-07-20','I would not put my dog up in this hotel.',10,0,'Not suitable for human habitation',0,10),(38,'2010-05-20','Average place but useful if you need to commute',11,1,'Conveient for the railway',0,10),(39,'2010-01-22','Some of the reviews seem a bit harsh, it\'s not too bad for the price.',12,2,'Not as bad as the reviews',2,10),(40,'2011-01-10','Looks like this hotel has had a major facelift.  If you have stayed before 2011 perhaps it\'s time to give this hotel another try.  Very good value for money and pretty nice.',13,3,'Reburished and nice',1,10),(41,'2009-01-20','Most other hotels is this area are a bit ropey, this one is actually pretty good.',0,3,'Better than most',0,13),(42,'2006-01-12','Cheap, no fuss hotel.  Good if you are travelling on business and just need a place to stay.',0,2,'No fuss hotel',3,15),(43,'2009-01-20','The area felt nice and safe but the rooms are a little on the small side',1,2,'Nice area but small rooms',2,15),(44,'2009-12-15','Good value for money, can\'t really fault it.',0,3,'Cheap and Recommended',2,16),(45,'2006-01-11','The hotel has a very bad reputation.  I would avoid it if I were you.',0,0,'Avoid',0,19),(46,'2010-01-09','Fantastic access to all the local attractions mean you won\'t mind the small rooms.',0,3,'Close to the local attractions',2,20),(47,'2010-09-10','Not expensive and very welcoming staff. I would stay again.',1,2,'Good value and friendly',2,20),(48,'2005-06-15','I can\'t fault this hotel and I have stayed here many times.  Always friendly staff and lovely atmosphere.',0,3,'A very nice hotel',3,21),(49,'2006-01-20','To complaints at all.',1,2,'Comfortable and good value',4,21),(50,'2007-08-21','Better than a lot of hotels in the area and not too pricey.',2,3,'Above average',1,21),(51,'2002-01-19','The city never sleeps and neither will you if you say here.  The rooms are small and the sound insulation is poor!',0,0,'Too noisy, too small',1,22),(52,'2004-03-10','Far too much money for such a tiny room!',1,1,'Overpriced',4,22),(53,'2007-04-11','Not brilliant but not too bad either.',2,2,'So so, nothing special',0,22),(54,'2004-07-21','So close to the heart of the city.  Recommended.',0,3,'Excellent location',2,23),(55,'2006-05-20','I can\'t fault this hotel, clean, good location and nice staff.',1,3,'Very nice',1,23),(56,'2003-11-10','I own this hotel and I think it is pretty darn good.',0,4,'Great!!',1,24),(57,'2005-10-20','This is the BEST hotel in Palm Bay, not complaints at all.',0,3,'Fantastical',2,25),(58,'2006-01-12','I rate this hotel 5 stars, the best in the area by miles.',1,4,'Top marks',1,25),(59,'2006-07-02','I stayed in late 2006 with work, the room was very small and the restaurant does not stay open very late.',0,2,'Could be better',3,26),(60,'2008-07-01','My room was freezing cold, I would not recommend this place.',1,1,'Brrrr cold!',4,26),(61,'2009-01-05','You can\'t really go wrong here for the money.  There may be better places to stay but not for this price.',2,3,'Nice for money',2,26),(62,'2000-01-29','I will never ever stay here again!!  They wanted extra cash to get fresh batteries for the TV remote',0,0,'Never again',2,27),(63,'2006-02-20','This place is the pits, they charged us twice for a single night stay.  I only got refunded after contacting my credit card company.',1,0,'Avoid',0,27);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_module`
--

DROP TABLE IF EXISTS `t_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(32) DEFAULT NULL,
  `module_path` varchar(50) DEFAULT NULL,
  `module_type` int(2) DEFAULT NULL COMMENT '1.URL, 2.功能',
  `module_key` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_module`
--

LOCK TABLES `t_module` WRITE;
/*!40000 ALTER TABLE `t_module` DISABLE KEYS */;
INSERT INTO `t_module` VALUES (1,'Overview','/index',1,'IndexUrl','2016-06-01 23:41:39'),(2,'Reports','/reports',1,'Reports','2016-06-02 09:42:17'),(3,'Users','/users',1,'Users','2016-06-03 21:42:17'),(4,'Export','/users/form',1,'Export','2016-06-03 20:38:01'),(5,'Selenium','/selenium/run',1,'Selenium','2016-06-03 20:38:04'),(6,'Velocity','/welcome',1,'Velocity','2016-06-03 20:38:08'),(7,'One more nav',NULL,1,'One_more_nav','2016-06-21 20:38:11'),(8,'Another nav item',NULL,1,'Another_nav_item','2016-05-29 20:38:23'),(9,'More navigation',NULL,1,'More_navigation','2016-06-05 20:38:14'),(10,'Nav item again',NULL,1,'Nav_item_again1','2016-07-01 20:38:28'),(11,'One more nav',NULL,1,'One_more_nav1','2016-05-31 20:38:18'),(12,'Another nav item',NULL,1,'Another_nav_item1','2016-05-29 20:38:31');
/*!40000 ALTER TABLE `t_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'管理员','系统管理员','2016-06-01 23:41:11');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role_module`
--

DROP TABLE IF EXISTS `t_role_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `module_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role_module`
--

LOCK TABLES `t_role_module` WRITE;
/*!40000 ALTER TABLE `t_role_module` DISABLE KEYS */;
INSERT INTO `t_role_module` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,1,10),(11,1,11),(12,1,12);
/*!40000 ALTER TABLE `t_role_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin','e10adc3949ba59abbe56e057f20f883e','Admin1',NULL),(2,'lance','e10adc3949ba59abbe56e057f20f883e','Lance','2016-06-02 23:35:38'),(3,'yuan','e10adc3949ba59abbe56e057f20f883e','yuan1','2016-06-02 23:35:38');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_role`
--

DROP TABLE IF EXISTS `t_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_role`
--

LOCK TABLES `t_user_role` WRITE;
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` VALUES (1,1,1);
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-06 11:38:34
