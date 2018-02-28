CREATE DATABASE `viagens`;

CREATE TABLE `viagem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ciaaerea` varchar(255) DEFAULT NULL,
  `cidadedestino` varchar(255) DEFAULT NULL,
  `cidadeorigem` varchar(255) DEFAULT NULL,
  `dhchegada` date DEFAULT NULL,
  `dhsaida` date DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

