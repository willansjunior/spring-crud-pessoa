# CRUD PERSON

Linguagem: Java</br>
JDK: 1.8</br>

### Script para gerar o banco

##### Copiando estrutura do banco de dados para spring_pessoa
DROP DATABASE IF EXISTS `spring_pessoa`;</br>
CREATE DATABASE IF NOT EXISTS `spring_pessoa`;</br>
USE `spring_pessoa`;</br>

##### Copiando estrutura para tabela spring_pessoa.person
DROP TABLE IF EXISTS `person`;</br>
CREATE TABLE IF NOT EXISTS `person` (</br>
  `id` int(11) NOT NULL AUTO_INCREMENT,</br>
  `name` varchar(150) NOT NULL,</br>
  `street` varchar(255) DEFAULT NULL,</br>
  `number` varchar(10) DEFAULT NULL,</br>
  `neighborhood` varchar(150) DEFAULT NULL,</br>
  `city` varchar(150) DEFAULT NULL,</br>
  `state` varchar(4) DEFAULT NULL,</br>
  `cellphone` varchar(20) DEFAULT NULL,</br>
  `phone` varchar(20) DEFAULT NULL,</br>
  PRIMARY KEY (`id`)</br>
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;</br>

## DOCUMENTAÇÃO

https://localhost:8080/swagger-ui.html


