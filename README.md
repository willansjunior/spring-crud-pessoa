# CRUD PERSON

Linguagem: Java</br>
JDK: 1.8</br>

### Script para gerar o banco

##### Copiando estrutura do banco de dados para spring_pessoa
DROP DATABASE IF EXISTS `spring_pessoa`;
CREATE DATABASE IF NOT EXISTS `spring_pessoa`;
USE `spring_pessoa`;

##### Copiando estrutura para tabela spring_pessoa.person
DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `street` varchar(255) DEFAULT NULL,
  `number` varchar(10) DEFAULT NULL,
  `neighborhood` varchar(150) DEFAULT NULL,
  `city` varchar(150) DEFAULT NULL,
  `state` varchar(4) DEFAULT NULL,
  `cellphone` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

## DOCUMENTAÇÃO

https://localhost:8080/swagger-ui.html


