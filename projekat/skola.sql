/*
SQLyog Community v12.4.2 (64 bit)
MySQL - 5.6.17 : Database - skolabaza
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`skolabaza` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `skolabaza`;

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `KlijentID` int(11) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(50) NOT NULL,
  `Prezime` varchar(50) NOT NULL,
  `DatumRodjenja` date NOT NULL,
  `MestoID` int(11) NOT NULL,
  PRIMARY KEY (`KlijentID`),
  KEY `MestoID` (`MestoID`),
  CONSTRAINT `klijent_ibfk_1` FOREIGN KEY (`MestoID`) REFERENCES `mesto` (`MestoID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `klijent` */

insert  into `klijent`(`KlijentID`,`Ime`,`Prezime`,`DatumRodjenja`,`MestoID`) values 
(1,'Ana','Anic','2000-12-20',1),
(2,'Pera','Peric','2000-11-13',1),
(3,'Zika','Zikic','2000-11-12',3),
(6,'Sara','Saric','2000-11-21',2),
(7,'Milica','Plavsic','1994-08-02',4),
(9,'Milka','Milic','1995-08-02',3),
(10,'Naki','Nakic','1996-08-02',1);

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `KorisnikID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`KorisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `korisnik` */

insert  into `korisnik`(`KorisnikID`,`Username`,`Password`) values 
(1,'123','123'),
(2,'456','456'),
(3,'789','789');

/*Table structure for table `kurs` */

DROP TABLE IF EXISTS `kurs`;

CREATE TABLE `kurs` (
  `KursID` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(60) NOT NULL,
  `Nivo` enum('A1','A2','B1','B2','C1','C2') NOT NULL,
  `Cena` double NOT NULL,
  `BrojCasova` int(11) NOT NULL,
  `DatumPocetka` date NOT NULL,
  `DatumZavrsetka` date NOT NULL,
  `MaksimalanBrKlijenata` int(11) NOT NULL,
  PRIMARY KEY (`KursID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `kurs` */

insert  into `kurs`(`KursID`,`Naziv`,`Nivo`,`Cena`,`BrojCasova`,`DatumPocetka`,`DatumZavrsetka`,`MaksimalanBrKlijenata`) values 
(1,'Engleski','A1',15000,36,'2018-12-01','2019-02-28',30),
(2,'Engleski','A2',18000,36,'2018-12-01','2019-02-28',20),
(3,'Francuski','B1',21000,37,'2019-01-01','2019-03-01',25),
(4,'Nemacki','C1',28000,38,'2019-01-01','2019-03-06',30),
(5,'Ruski','A2',18000,35,'2019-02-01','2019-04-11',25),
(6,'Ruski','B1',21000,36,'2019-01-01','2019-03-01',18);

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `MestoID` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(100) NOT NULL,
  `PostanskiBroj` int(11) NOT NULL,
  PRIMARY KEY (`MestoID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `mesto` */

insert  into `mesto`(`MestoID`,`Naziv`,`PostanskiBroj`) values 
(1,'Beograd',11000),
(2,'Nis',18000),
(3,'Kragujevac',34000),
(4,'Novi Sad',21000),
(5,'Kraljevo',36000);

/*Table structure for table `prijava` */

DROP TABLE IF EXISTS `prijava`;

CREATE TABLE `prijava` (
  `PrijavaID` int(11) NOT NULL AUTO_INCREMENT,
  `UkupanIznos` double NOT NULL,
  `KorisnikID` int(11) NOT NULL,
  `KlijentID` int(11) NOT NULL,
  PRIMARY KEY (`PrijavaID`),
  KEY `KorisnikID` (`KorisnikID`),
  KEY `KlijentID` (`KlijentID`),
  CONSTRAINT `prijava_ibfk_1` FOREIGN KEY (`KorisnikID`) REFERENCES `korisnik` (`KorisnikID`),
  CONSTRAINT `prijava_ibfk_2` FOREIGN KEY (`KlijentID`) REFERENCES `klijent` (`KlijentID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `prijava` */

insert  into `prijava`(`PrijavaID`,`UkupanIznos`,`KorisnikID`,`KlijentID`) values 
(1,33000,1,1),
(2,39000,1,2);

/*Table structure for table `stavkaprijave` */

DROP TABLE IF EXISTS `stavkaprijave`;

CREATE TABLE `stavkaprijave` (
  `RBStavke` int(11) NOT NULL,
  `PrijavaID` int(11) NOT NULL,
  `Cena` double NOT NULL,
  `KursID` int(11) NOT NULL,
  PRIMARY KEY (`RBStavke`,`PrijavaID`),
  KEY `KursID` (`KursID`),
  CONSTRAINT `stavkaprijave_ibfk_1` FOREIGN KEY (`KursID`) REFERENCES `kurs` (`KursID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stavkaprijave` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
