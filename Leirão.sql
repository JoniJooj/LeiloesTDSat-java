DROP DATABASE if EXISTS produtos;


CREATE DATABASE `produtos`;
USE produtos;

CREATE TABLE `produtos` (
  `id` int primary key auto_increment,
  `nome` varchar(150) NOT NULL,
  `valor` int,
  `status` varchar(100) NOT NULL
);