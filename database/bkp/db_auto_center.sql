-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: db_auto_center
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `tbl_acao_nivel_usuario`
--

DROP TABLE IF EXISTS `tbl_acao_nivel_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_acao_nivel_usuario` (
  `id_acoes_nivel` int(11) NOT NULL AUTO_INCREMENT,
  `id_nivel_usuario` int(11) NOT NULL,
  `id_acao_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_acoes_nivel`),
  KEY `fk_tbl_acao_nivel_usuario_id_nivel_usuario_idx` (`id_nivel_usuario`),
  KEY `fk_tbl_acao_nivel_usuario_id_acao_usuario_idx` (`id_acao_usuario`),
  CONSTRAINT `fk_tbl_acao_nivel_usuario_id_acao_usuario` FOREIGN KEY (`id_acao_usuario`) REFERENCES `tbl_acao_usuario` (`id_acao_usuario`),
  CONSTRAINT `fk_tbl_acao_nivel_usuario_id_nivel_usuario` FOREIGN KEY (`id_nivel_usuario`) REFERENCES `tbl_nivel_usuario` (`id_nivel_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_acao_nivel_usuario`
--

LOCK TABLES `tbl_acao_nivel_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_acao_nivel_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_acao_nivel_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_acao_usuario`
--

DROP TABLE IF EXISTS `tbl_acao_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_acao_usuario` (
  `id_acao_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `acao` varchar(120) NOT NULL,
  PRIMARY KEY (`id_acao_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_acao_usuario`
--

LOCK TABLES `tbl_acao_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_acao_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_acao_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_anuncio_parceiro`
--

DROP TABLE IF EXISTS `tbl_anuncio_parceiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_anuncio_parceiro` (
  `id_anuncio_parceiro` int(11) NOT NULL AUTO_INCREMENT,
  `id_parceiro` int(11) NOT NULL,
  `foto` varchar(420) NOT NULL,
  `link_redirecionamento` varchar(580) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '0',
  `log_anuncio_parceiro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_anuncio_parceiro`),
  KEY `fk_tbl_anuncio_parceiro_id_parceiro_idx` (`id_parceiro`),
  CONSTRAINT `fk_tbl_anuncio_parceiro_id_parceiro` FOREIGN KEY (`id_parceiro`) REFERENCES `tbl_parceiro` (`id_parceiro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_anuncio_parceiro`
--

LOCK TABLES `tbl_anuncio_parceiro` WRITE;
/*!40000 ALTER TABLE `tbl_anuncio_parceiro` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_anuncio_parceiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_anuncio_produto_parceiro`
--

DROP TABLE IF EXISTS `tbl_anuncio_produto_parceiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_anuncio_produto_parceiro` (
  `id_anuncio_produto` int(11) NOT NULL AUTO_INCREMENT,
  `id_produto` int(11) NOT NULL,
  `preco` decimal(8,2) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_anuncio_produto`),
  KEY `fk_tbl_anuncio_produto_parceiro_id_produto_idx` (`id_produto`),
  CONSTRAINT `fk_tbl_anuncio_produto_parceiro_id_produto` FOREIGN KEY (`id_produto`) REFERENCES `tbl_produto` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_anuncio_produto_parceiro`
--

LOCK TABLES `tbl_anuncio_produto_parceiro` WRITE;
/*!40000 ALTER TABLE `tbl_anuncio_produto_parceiro` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_anuncio_produto_parceiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_anuncio_veiculo_parceiro`
--

DROP TABLE IF EXISTS `tbl_anuncio_veiculo_parceiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_anuncio_veiculo_parceiro` (
  `id_anuncio_veiculo_parceiro` int(11) NOT NULL AUTO_INCREMENT,
  `id_veiculo_parceiro` int(11) NOT NULL,
  `preco` decimal(15,2) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_anuncio_veiculo_parceiro`),
  KEY `fk_tbl_anuncio_veiculo_parceirotbl_anuncio_veiculo_parceiro_idx` (`id_veiculo_parceiro`),
  CONSTRAINT `fk_anunc_v_par_id_veiculo_parceiro` FOREIGN KEY (`id_veiculo_parceiro`) REFERENCES `tbl_veiculo_parceiro` (`id_veiculo_parceiro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_anuncio_veiculo_parceiro`
--

LOCK TABLES `tbl_anuncio_veiculo_parceiro` WRITE;
/*!40000 ALTER TABLE `tbl_anuncio_veiculo_parceiro` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_anuncio_veiculo_parceiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_cargo_funcionario_pac`
--

DROP TABLE IF EXISTS `tbl_cargo_funcionario_pac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_cargo_funcionario_pac` (
  `id_cargo_funcionario_pac` int(11) NOT NULL AUTO_INCREMENT,
  `cargo` varchar(280) NOT NULL,
  PRIMARY KEY (`id_cargo_funcionario_pac`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cargo_funcionario_pac`
--

LOCK TABLES `tbl_cargo_funcionario_pac` WRITE;
/*!40000 ALTER TABLE `tbl_cargo_funcionario_pac` DISABLE KEYS */;
INSERT INTO `tbl_cargo_funcionario_pac` VALUES (1,'Tester');
/*!40000 ALTER TABLE `tbl_cargo_funcionario_pac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_categoria_conta_pac`
--

DROP TABLE IF EXISTS `tbl_categoria_conta_pac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_categoria_conta_pac` (
  `id_categoria_conta_pac` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(180) NOT NULL,
  PRIMARY KEY (`id_categoria_conta_pac`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_categoria_conta_pac`
--

LOCK TABLES `tbl_categoria_conta_pac` WRITE;
/*!40000 ALTER TABLE `tbl_categoria_conta_pac` DISABLE KEYS */;
INSERT INTO `tbl_categoria_conta_pac` VALUES (1,'Luz'),(2,'Internet');
/*!40000 ALTER TABLE `tbl_categoria_conta_pac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_categoria_produto`
--

DROP TABLE IF EXISTS `tbl_categoria_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_categoria_produto` (
  `id_categoria_produto` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(380) NOT NULL,
  PRIMARY KEY (`id_categoria_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_categoria_produto`
--

LOCK TABLES `tbl_categoria_produto` WRITE;
/*!40000 ALTER TABLE `tbl_categoria_produto` DISABLE KEYS */;
INSERT INTO `tbl_categoria_produto` VALUES (1,'Produto'),(2,'Serviço');
/*!40000 ALTER TABLE `tbl_categoria_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_categoria_topico_forum`
--

DROP TABLE IF EXISTS `tbl_categoria_topico_forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_categoria_topico_forum` (
  `id_categoria_topico_forum` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(80) NOT NULL,
  PRIMARY KEY (`id_categoria_topico_forum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_categoria_topico_forum`
--

LOCK TABLES `tbl_categoria_topico_forum` WRITE;
/*!40000 ALTER TABLE `tbl_categoria_topico_forum` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_categoria_topico_forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_click_anuncio_parceiro`
--

DROP TABLE IF EXISTS `tbl_click_anuncio_parceiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_click_anuncio_parceiro` (
  `id_click_anuncio_parceiro` int(11) NOT NULL AUTO_INCREMENT,
  `id_anuncio_parceiro` int(11) NOT NULL,
  `clicado` int(11) NOT NULL,
  `log_click_anuncio_parceiro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_click_anuncio_parceiro`),
  KEY `fk_tbl_click_anuncio_parceiro_id_anuncio_parceiro_idx` (`id_anuncio_parceiro`),
  CONSTRAINT `fk_tbl_click_anuncio_parceiro_id_anuncio_parceiro` FOREIGN KEY (`id_anuncio_parceiro`) REFERENCES `tbl_anuncio_parceiro` (`id_anuncio_parceiro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_click_anuncio_parceiro`
--

LOCK TABLES `tbl_click_anuncio_parceiro` WRITE;
/*!40000 ALTER TABLE `tbl_click_anuncio_parceiro` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_click_anuncio_parceiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_cliente`
--

DROP TABLE IF EXISTS `tbl_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(250) NOT NULL,
  `dtNasc` date NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `email` varchar(280) NOT NULL,
  `celular` varchar(12) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  `sexo` char(1) NOT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  `foto_perfil` varchar(350) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `fk_tbl_cliente_id_usuario_idx` (`id_usuario`),
  CONSTRAINT `fk_tbl_cliente_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `tbl_usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cliente`
--

LOCK TABLES `tbl_cliente` WRITE;
/*!40000 ALTER TABLE `tbl_cliente` DISABLE KEYS */;
INSERT INTO `tbl_cliente` VALUES (1,'tester','2018-03-21','4521544','emai@ll.com','116',1,'M','',1,'https://images.unsplash.com/photo-1511996706594-d6ca1d3e1c64?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=cf9fea778b21b76d06986fa63fbb4763&dpr=1&auto=format&fit=crop&w=1000&q=80&cs=tinysrgb');
/*!40000 ALTER TABLE `tbl_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_comentario_post`
--

DROP TABLE IF EXISTS `tbl_comentario_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_comentario_post` (
  `id_comentario_post` int(11) NOT NULL AUTO_INCREMENT,
  `id_post_rede_social` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `comentario` varchar(2000) NOT NULL,
  `log_comentario_post` datetime NOT NULL,
  PRIMARY KEY (`id_comentario_post`),
  KEY `fk_tbl_comentario_post_id_post_rede_social_idx` (`id_post_rede_social`),
  KEY `fk_tbl_comentario_post_id_usuario_idx` (`id_usuario`),
  CONSTRAINT `fk_tbl_comentario_post_id_post_rede_social` FOREIGN KEY (`id_post_rede_social`) REFERENCES `tbl_post_rede_social` (`id_post_rede_social`),
  CONSTRAINT `fk_tbl_comentario_post_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `tbl_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_comentario_post`
--

LOCK TABLES `tbl_comentario_post` WRITE;
/*!40000 ALTER TABLE `tbl_comentario_post` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_comentario_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_comentario_topico_forum`
--

DROP TABLE IF EXISTS `tbl_comentario_topico_forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_comentario_topico_forum` (
  `id_comentario_forum` int(11) NOT NULL AUTO_INCREMENT,
  `id_topico_forum` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `mensagem` varchar(5500) NOT NULL,
  `foto` varchar(350) DEFAULT NULL,
  `log` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_comentario_forum`),
  KEY `fk_tbl_comentario_topico_forum_idx` (`id_topico_forum`),
  KEY `fk_tbl_situacao_pedido_id_cliente_idx` (`id_cliente`),
  CONSTRAINT `fk_tbl_comentario_topico_forum` FOREIGN KEY (`id_topico_forum`) REFERENCES `tbl_topico_forum` (`id_topico_forum`),
  CONSTRAINT `fk_tbl_situacao_pedido_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `tbl_cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_comentario_topico_forum`
--

LOCK TABLES `tbl_comentario_topico_forum` WRITE;
/*!40000 ALTER TABLE `tbl_comentario_topico_forum` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_comentario_topico_forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_compatibilidade_produto_veiculo`
--

DROP TABLE IF EXISTS `tbl_compatibilidade_produto_veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_compatibilidade_produto_veiculo` (
  `id_compatibilidade_produto_veiculo` int(11) NOT NULL AUTO_INCREMENT,
  `id_veiculo` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  PRIMARY KEY (`id_compatibilidade_produto_veiculo`),
  KEY `fk_tbl_compatibilidade_produto_veiculo_id_veiculo_idx` (`id_veiculo`),
  KEY `fk_tbl_compatibilidade_produto_veiculo_id_produto_idx` (`id_produto`),
  CONSTRAINT `fk_tbl_compatibilidade_produto_veiculo_id_produto` FOREIGN KEY (`id_produto`) REFERENCES `tbl_produto` (`id_produto`),
  CONSTRAINT `fk_tbl_compatibilidade_produto_veiculo_id_veiculo` FOREIGN KEY (`id_veiculo`) REFERENCES `tbl_veiculo` (`id_veiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_compatibilidade_produto_veiculo`
--

LOCK TABLES `tbl_compatibilidade_produto_veiculo` WRITE;
/*!40000 ALTER TABLE `tbl_compatibilidade_produto_veiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_compatibilidade_produto_veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_conta_pac`
--

DROP TABLE IF EXISTS `tbl_conta_pac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_conta_pac` (
  `id_conta_pac` int(11) NOT NULL AUTO_INCREMENT,
  `id_categoria_conta_pac` int(11) NOT NULL,
  `valor` decimal(9,2) NOT NULL,
  `vencimento` date NOT NULL,
  `paga` tinyint(1) NOT NULL DEFAULT '0',
  `log_conta_pac` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_conta_pac`),
  KEY `fk_tbl_conta_pac_id_categoria_conta_idx` (`id_categoria_conta_pac`),
  CONSTRAINT `fk_tbl_conta_pac_id_categoria_conta` FOREIGN KEY (`id_categoria_conta_pac`) REFERENCES `tbl_categoria_conta_pac` (`id_categoria_conta_pac`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_conta_pac`
--

LOCK TABLES `tbl_conta_pac` WRITE;
/*!40000 ALTER TABLE `tbl_conta_pac` DISABLE KEYS */;
INSERT INTO `tbl_conta_pac` VALUES (1,1,3740.00,'2018-05-29',0,'2018-05-10 07:51:18'),(2,2,480.00,'2018-05-19',1,'2018-05-10 07:51:18'),(3,2,854.00,'2018-05-19',1,'2018-05-10 07:51:18');
/*!40000 ALTER TABLE `tbl_conta_pac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_controle_abastecimento`
--

DROP TABLE IF EXISTS `tbl_controle_abastecimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_controle_abastecimento` (
  `id_controle_abastecimento` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_combustivel` int(11) NOT NULL,
  `id_veiculo_cliente` int(11) NOT NULL,
  `valor_abastecimento` decimal(6,2) NOT NULL,
  `latitute` double NOT NULL,
  `longitude` double NOT NULL,
  `log_controle_abastecimento` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_controle_abastecimento`),
  KEY `fk_tbl_controle_abastecimento_id_veiculo_cliente_id_tipo_co_idx` (`id_tipo_combustivel`),
  KEY `fk_tbl_controle_abastecimento_id_veiculo_cliente_idx` (`id_veiculo_cliente`),
  CONSTRAINT `fk_cont_abat_id_veiculo_clint` FOREIGN KEY (`id_tipo_combustivel`) REFERENCES `tbl_tipo_combustivel` (`id_tipo_combustivel`),
  CONSTRAINT `fk_tbl_cont_abast_id_veiculo_cliente` FOREIGN KEY (`id_veiculo_cliente`) REFERENCES `tbl_veiculo_cliente` (`id_veiculo_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_controle_abastecimento`
--

LOCK TABLES `tbl_controle_abastecimento` WRITE;
/*!40000 ALTER TABLE `tbl_controle_abastecimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_controle_abastecimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_cor`
--

DROP TABLE IF EXISTS `tbl_cor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_cor` (
  `id_cor` int(11) NOT NULL AUTO_INCREMENT,
  `cor` varchar(80) NOT NULL,
  PRIMARY KEY (`id_cor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cor`
--

LOCK TABLES `tbl_cor` WRITE;
/*!40000 ALTER TABLE `tbl_cor` DISABLE KEYS */;
INSERT INTO `tbl_cor` VALUES (1,'Preto');
/*!40000 ALTER TABLE `tbl_cor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_curtir_post`
--

DROP TABLE IF EXISTS `tbl_curtir_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_curtir_post` (
  `id_curtir_post` int(11) NOT NULL AUTO_INCREMENT,
  `id_post_rede_social` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `log_curtir_post` datetime NOT NULL,
  PRIMARY KEY (`id_curtir_post`),
  KEY `fk_tbl_curtir_post_id_post_rede_social_idx` (`id_post_rede_social`),
  KEY `fk_tbl_curtir_post_id_usuario_idx` (`id_usuario`),
  CONSTRAINT `fk_tbl_curtir_post_id_post_rede_social` FOREIGN KEY (`id_post_rede_social`) REFERENCES `tbl_post_rede_social` (`id_post_rede_social`),
  CONSTRAINT `fk_tbl_curtir_post_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `tbl_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_curtir_post`
--

LOCK TABLES `tbl_curtir_post` WRITE;
/*!40000 ALTER TABLE `tbl_curtir_post` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_curtir_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_endereco`
--

DROP TABLE IF EXISTS `tbl_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_endereco` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(210) NOT NULL,
  `numero` varchar(80) NOT NULL,
  `cidade` varchar(120) NOT NULL,
  `id_estado` int(11) NOT NULL,
  `cep` varchar(8) NOT NULL,
  `bairro` varchar(120) NOT NULL,
  `complemento` varchar(250) NOT NULL,
  PRIMARY KEY (`id_endereco`),
  KEY `fk_tbl_endereco_id_estado_idx` (`id_estado`),
  CONSTRAINT `fk_tbl_endereco_id_estado` FOREIGN KEY (`id_estado`) REFERENCES `tbl_estado` (`id_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_endereco`
--

LOCK TABLES `tbl_endereco` WRITE;
/*!40000 ALTER TABLE `tbl_endereco` DISABLE KEYS */;
INSERT INTO `tbl_endereco` VALUES (1,'Rua Flamingo','8452','São Paulo',1,'01000452','Jardim Paulista',''),(96,'aaaaa','000','Osasco',1,'06286180','Mutinga','aaaa'),(97,'aaaaa','000','Osasco',1,'06286180','Mutinga','aaaa'),(98,'aaaaa','000','Osasco',1,'06286180','Mutinga','aaaa'),(99,'aaaaa','000','Osasco',1,'06286180','Mutinga','aaaa'),(100,'aaaaa','000','Osasco',1,'06286180','Mutinga','aaaa'),(101,'aaaaa','000','Osasco',1,'06286180','Mutinga','aaaa'),(102,'aaaaa','000','Osasco',1,'06286180','Mutinga','aaaa'),(103,'aaaaa','000','Osasco',1,'06286180','Mutinga','aaaa'),(104,'aaaaa','000','Osasco',1,'06286180','Mutinga','aaaa'),(105,'aaaaa','000','Osasco',1,'06286180','Mutinga','aaaa'),(106,'aaaaa','000','Osasco',3,'06286180','Mutinga','aaaa'),(107,'aaaaa','000','Osasco',5,'06286180','Mutinga','aaaa'),(108,'aaaaa','000','Osasco',2,'06286180','Mutinga','aaaa'),(109,'asddasd','56156','Osasco',2,'06286120','Mutinga','sdasa'),(110,'asd','56156','Osasco',1,'06286120','Mutinga','asdas'),(111,'sadasdas','561561','Osasco',1,'06286120','asdas','dasda'),(112,'asdas','1561','Osasco',1,'06286120','Mutinga','asdasd'),(113,'as','561','Osasco',1,'06286120','Mutinga',''),(114,'t','1','Osasco',1,'06286120','Mutinga','t'),(115,'asd','56.12','Osasco',1,'06286120','Mutinga','asdd'),(116,'fdas','45616','Osasco',1,'06286120','Mutinga','sdf'),(117,'dasfd','56.1','Osasco',1,'06286120','Mutinga',''),(118,'asdf','5616','Osasco',2,'06286120','Mutinga','asdf'),(119,'aqf','561','Osasco',1,'06286120','Mutinga','asdf'),(120,'asdfas','56165','Osasco',1,'06286120','Mutinga',''),(121,'asdfad','56156','Osasco',1,'06286120','Mutinga','adfdas'),(122,'asfdasd','58185','Osasco',1,'06286120','Mutinga','ascdsa'),(123,'asfdasd','58185','Osasco',1,'06286120','Mutinga','ascdsa'),(124,'Rua Castro Alves','245','São Paulo',1,'14521452','Jardim Vitápolis','Casa 03');
/*!40000 ALTER TABLE `tbl_endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_estado`
--

DROP TABLE IF EXISTS `tbl_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_estado` (
  `id_estado` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(180) NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_estado`
--

LOCK TABLES `tbl_estado` WRITE;
/*!40000 ALTER TABLE `tbl_estado` DISABLE KEYS */;
INSERT INTO `tbl_estado` VALUES (1,'São Paulo'),(2,'Minas Gerais'),(3,'Pernambuco'),(4,'Bahia'),(5,'Alagoas');
/*!40000 ALTER TABLE `tbl_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_fabricante`
--

DROP TABLE IF EXISTS `tbl_fabricante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_fabricante` (
  `id_fabricante` int(11) NOT NULL AUTO_INCREMENT,
  `fabricante` varchar(180) NOT NULL,
  PRIMARY KEY (`id_fabricante`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_fabricante`
--

LOCK TABLES `tbl_fabricante` WRITE;
/*!40000 ALTER TABLE `tbl_fabricante` DISABLE KEYS */;
INSERT INTO `tbl_fabricante` VALUES (1,'BMW');
/*!40000 ALTER TABLE `tbl_fabricante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_fabricante_produto`
--

DROP TABLE IF EXISTS `tbl_fabricante_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_fabricante_produto` (
  `id_fabricante_produto` int(11) NOT NULL AUTO_INCREMENT,
  `fabricante` varchar(320) NOT NULL,
  PRIMARY KEY (`id_fabricante_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_fabricante_produto`
--

LOCK TABLES `tbl_fabricante_produto` WRITE;
/*!40000 ALTER TABLE `tbl_fabricante_produto` DISABLE KEYS */;
INSERT INTO `tbl_fabricante_produto` VALUES (1,'Porsch');
/*!40000 ALTER TABLE `tbl_fabricante_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_fale_conosco`
--

DROP TABLE IF EXISTS `tbl_fale_conosco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_fale_conosco` (
  `id_fale_conosco` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(280) NOT NULL,
  `email` varchar(320) NOT NULL,
  `pergunta_sugestao_critica` varchar(1800) NOT NULL,
  PRIMARY KEY (`id_fale_conosco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_fale_conosco`
--

LOCK TABLES `tbl_fale_conosco` WRITE;
/*!40000 ALTER TABLE `tbl_fale_conosco` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_fale_conosco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_feedback_cliente`
--

DROP TABLE IF EXISTS `tbl_feedback_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_feedback_cliente` (
  `id_feedback_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `id_pedido` int(11) NOT NULL,
  `feedback` varchar(2500) NOT NULL,
  `log_feedback` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_feedback_cliente`),
  KEY `fk_tbl_feedback_cliente_id_pedido_idx` (`id_pedido`),
  CONSTRAINT `fk_tbl_feedback_cliente_id_pedido` FOREIGN KEY (`id_pedido`) REFERENCES `tbl_pedido` (`id_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_feedback_cliente`
--

LOCK TABLES `tbl_feedback_cliente` WRITE;
/*!40000 ALTER TABLE `tbl_feedback_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_feedback_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_funcionario_pac`
--

DROP TABLE IF EXISTS `tbl_funcionario_pac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_funcionario_pac` (
  `id_funcionario_pac` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(210) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `rg` varchar(9) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  `dt_nascimento` date NOT NULL,
  `id_cargo_funcionario_pac` int(11) NOT NULL,
  `salario` decimal(8,2) NOT NULL,
  `sexo` char(1) NOT NULL,
  `celular` varchar(12) NOT NULL,
  `email` varchar(280) NOT NULL,
  `foto` varchar(320) NOT NULL,
  `cnh` varchar(11) DEFAULT NULL,
  `pis` varchar(13) DEFAULT NULL,
  `certificado_reservista` varchar(10) DEFAULT NULL,
  `log_funcionario_pac` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_funcionario_pac`),
  KEY `fk_tbl_funcionario_pac_id_endereco_idx` (`id_endereco`),
  KEY `fk_tbl_funcionario_pac_id_cargo_funcionario_pac_idx` (`id_cargo_funcionario_pac`),
  KEY `tbl_funcionario_pac` (`id_usuario`),
  CONSTRAINT `fk_tbl_funcionario_pac_id_cargo_funcionario_pac` FOREIGN KEY (`id_cargo_funcionario_pac`) REFERENCES `tbl_cargo_funcionario_pac` (`id_cargo_funcionario_pac`),
  CONSTRAINT `fk_tbl_funcionario_pac_id_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `tbl_endereco` (`id_endereco`),
  CONSTRAINT `tbl_funcionario_pac` FOREIGN KEY (`id_usuario`) REFERENCES `tbl_usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_funcionario_pac`
--

LOCK TABLES `tbl_funcionario_pac` WRITE;
/*!40000 ALTER TABLE `tbl_funcionario_pac` DISABLE KEYS */;
INSERT INTO `tbl_funcionario_pac` VALUES (1,'Letícia Santos','5489489','54654',1,'1998-02-24',1,4800.00,'F','56165','leticia@pac.com.br','path','456165','45164',NULL,'2018-05-10 07:50:10',1);
/*!40000 ALTER TABLE `tbl_funcionario_pac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_imagem_produto_parceiro`
--

DROP TABLE IF EXISTS `tbl_imagem_produto_parceiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_imagem_produto_parceiro` (
  `id_imagem_produto_parceiro` int(11) NOT NULL AUTO_INCREMENT,
  `id_produto` int(11) NOT NULL,
  `imagem` varchar(800) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_imagem_produto_parceiro`),
  KEY `fk_tbl_imagem_produto_parceiro_id_produto_idx` (`id_produto`),
  CONSTRAINT `fk_tbl_imagem_produto_parceiro_id_produto` FOREIGN KEY (`id_produto`) REFERENCES `tbl_produto` (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_imagem_produto_parceiro`
--

LOCK TABLES `tbl_imagem_produto_parceiro` WRITE;
/*!40000 ALTER TABLE `tbl_imagem_produto_parceiro` DISABLE KEYS */;
INSERT INTO `tbl_imagem_produto_parceiro` VALUES (2,3,'../pictures/galeria/auto_eletrica.jpg',1),(3,4,'../pictures/galeria/pintura_carro.jpg',1),(5,5,'../pictures/galeria/farol.jpg',1);
/*!40000 ALTER TABLE `tbl_imagem_produto_parceiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_imagem_veiculo_cliente`
--

DROP TABLE IF EXISTS `tbl_imagem_veiculo_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_imagem_veiculo_cliente` (
  `id_imagem_veiculo_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `id_veiculo_cliente` int(11) NOT NULL,
  `imagem` varchar(800) NOT NULL,
  PRIMARY KEY (`id_imagem_veiculo_cliente`),
  KEY `fk_tbl_imagem_veiculo_cliente_id_veiculo_cliente_idx` (`id_veiculo_cliente`),
  CONSTRAINT `fk_tbl_imagem_veiculo_cliente_id_veiculo_cliente` FOREIGN KEY (`id_veiculo_cliente`) REFERENCES `tbl_veiculo_cliente` (`id_veiculo_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_imagem_veiculo_cliente`
--

LOCK TABLES `tbl_imagem_veiculo_cliente` WRITE;
/*!40000 ALTER TABLE `tbl_imagem_veiculo_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_imagem_veiculo_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_imagem_veiculo_parceiro`
--

DROP TABLE IF EXISTS `tbl_imagem_veiculo_parceiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_imagem_veiculo_parceiro` (
  `id_imagem_veiculo_parceiro` int(11) NOT NULL AUTO_INCREMENT,
  `id_veiculo_parceiro` int(11) NOT NULL,
  `imagem` varchar(800) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_imagem_veiculo_parceiro`),
  KEY `fk_tbl_imagem_veiculo_parceiro_id_veiculo_parceiro_idx` (`id_veiculo_parceiro`),
  CONSTRAINT `fk_tbl_imagem_veiculo_parceiro_id_veiculo_parceiro` FOREIGN KEY (`id_veiculo_parceiro`) REFERENCES `tbl_veiculo_parceiro` (`id_veiculo_parceiro`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_imagem_veiculo_parceiro`
--

LOCK TABLES `tbl_imagem_veiculo_parceiro` WRITE;
/*!40000 ALTER TABLE `tbl_imagem_veiculo_parceiro` DISABLE KEYS */;
INSERT INTO `tbl_imagem_veiculo_parceiro` VALUES (3,1,'../pictures/galeria/blue.jpg',1),(4,2,'../pictures/galeria/moto_dois.jpg',1);
/*!40000 ALTER TABLE `tbl_imagem_veiculo_parceiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_modelo_produto`
--

DROP TABLE IF EXISTS `tbl_modelo_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_modelo_produto` (
  `id_modelo_produto` int(11) NOT NULL AUTO_INCREMENT,
  `modelo` varchar(380) NOT NULL,
  `id_fabricante_produto` int(11) NOT NULL,
  `peso` float NOT NULL,
  `altura` float NOT NULL,
  `comprimento` float NOT NULL,
  PRIMARY KEY (`id_modelo_produto`),
  KEY `fk_tbl_modelo_produto_id_fabricante_produto__idx` (`id_fabricante_produto`),
  CONSTRAINT `fk_tbl_modelo_produto_id_fabricante_produto_` FOREIGN KEY (`id_fabricante_produto`) REFERENCES `tbl_fabricante_produto` (`id_fabricante_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_modelo_produto`
--

LOCK TABLES `tbl_modelo_produto` WRITE;
/*!40000 ALTER TABLE `tbl_modelo_produto` DISABLE KEYS */;
INSERT INTO `tbl_modelo_produto` VALUES (1,'41A-52FD',1,0.452,0.28,0.69);
/*!40000 ALTER TABLE `tbl_modelo_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_modelo_veiculo`
--

DROP TABLE IF EXISTS `tbl_modelo_veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_modelo_veiculo` (
  `id_modelo_veiculo` int(11) NOT NULL AUTO_INCREMENT,
  `id_fabricante` int(11) NOT NULL,
  `modelo` varchar(180) NOT NULL,
  PRIMARY KEY (`id_modelo_veiculo`),
  KEY `fk_tbl_modelo_veiculo_idx` (`id_fabricante`),
  CONSTRAINT `fk_tbl_modelo_veiculo_id_fabricante` FOREIGN KEY (`id_fabricante`) REFERENCES `tbl_fabricante` (`id_fabricante`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_modelo_veiculo`
--

LOCK TABLES `tbl_modelo_veiculo` WRITE;
/*!40000 ALTER TABLE `tbl_modelo_veiculo` DISABLE KEYS */;
INSERT INTO `tbl_modelo_veiculo` VALUES (1,1,'FGM-25K');
/*!40000 ALTER TABLE `tbl_modelo_veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_modo_pagamento`
--

DROP TABLE IF EXISTS `tbl_modo_pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_modo_pagamento` (
  `id_modo_pagamento` int(11) NOT NULL AUTO_INCREMENT,
  `modo` varchar(180) NOT NULL,
  PRIMARY KEY (`id_modo_pagamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_modo_pagamento`
--

LOCK TABLES `tbl_modo_pagamento` WRITE;
/*!40000 ALTER TABLE `tbl_modo_pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_modo_pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_nivel_usuario`
--

DROP TABLE IF EXISTS `tbl_nivel_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_nivel_usuario` (
  `id_nivel_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nivel` varchar(45) NOT NULL,
  PRIMARY KEY (`id_nivel_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_nivel_usuario`
--

LOCK TABLES `tbl_nivel_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_nivel_usuario` DISABLE KEYS */;
INSERT INTO `tbl_nivel_usuario` VALUES (1,'Administrador'),(2,'Parceiro'),(3,'Cliente');
/*!40000 ALTER TABLE `tbl_nivel_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pagamento_funcionario_pac`
--

DROP TABLE IF EXISTS `tbl_pagamento_funcionario_pac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_pagamento_funcionario_pac` (
  `id_pagamento_funcionario_pac` int(11) NOT NULL AUTO_INCREMENT,
  `id_funcionario_pac` int(11) NOT NULL,
  `pago` tinyint(1) NOT NULL DEFAULT '0',
  `log_pagamento_funcionario_pac` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_pagamento_funcionario_pac`),
  KEY `fk_tbl_pagamento_funcionario_pac_id_funcionario_pac_idx` (`id_funcionario_pac`),
  CONSTRAINT `fk_tbl_pagamento_funcionario_pac_id_funcionario_pac` FOREIGN KEY (`id_funcionario_pac`) REFERENCES `tbl_funcionario_pac` (`id_funcionario_pac`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pagamento_funcionario_pac`
--

LOCK TABLES `tbl_pagamento_funcionario_pac` WRITE;
/*!40000 ALTER TABLE `tbl_pagamento_funcionario_pac` DISABLE KEYS */;
INSERT INTO `tbl_pagamento_funcionario_pac` VALUES (1,1,0,'2018-05-10 07:50:23');
/*!40000 ALTER TABLE `tbl_pagamento_funcionario_pac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_parceiro`
--

DROP TABLE IF EXISTS `tbl_parceiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_parceiro` (
  `id_parceiro` int(11) NOT NULL AUTO_INCREMENT,
  `nome_fantasia` varchar(280) NOT NULL,
  `razao_social` varchar(280) NOT NULL,
  `cnpj` varchar(14) NOT NULL,
  `id_endereco` int(1) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '0',
  `socorrista` tinyint(1) NOT NULL,
  `email` varchar(280) NOT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `foto_perfil` varchar(350) NOT NULL,
  `celular` varchar(12) DEFAULT NULL,
  `log_parceiro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_usuario` int(11) NOT NULL,
  `id_plano_contratacao` int(11) NOT NULL,
  PRIMARY KEY (`id_parceiro`),
  KEY `fk_tbl_parceiro_id_plano_contratacao_idx` (`id_plano_contratacao`),
  KEY `fk_tbl_parceiro_id_usuario_idx` (`id_usuario`),
  KEY `fk_tbl_parceiro_id_endereco_idx` (`id_endereco`),
  CONSTRAINT `fk_tbl_parceiro_id_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `tbl_endereco` (`id_endereco`),
  CONSTRAINT `fk_tbl_parceiro_id_plano_contratacao` FOREIGN KEY (`id_plano_contratacao`) REFERENCES `tbl_plano_contratacao` (`id_plano_contratacao`),
  CONSTRAINT `fk_tbl_parceiro_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `tbl_usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='			';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_parceiro`
--

LOCK TABLES `tbl_parceiro` WRITE;
/*!40000 ALTER TABLE `tbl_parceiro` DISABLE KEYS */;
INSERT INTO `tbl_parceiro` VALUES (1,'Fast & Run','Fast & Run Importados LTDA','4656516565',1,0,1,'fast&run@fastrun.com.br','1145228475','','1142158745','2018-04-12 09:47:39',1,1),(15,'asdas','asdasd','12561265',96,1,1,'asdasd','5156','','4561','2018-04-21 03:56:44',33,1),(16,'asdas','asdasd','56165',97,0,1,'asdas','156156','','561256.','2018-04-21 03:57:19',34,1),(17,'sadasd','asdf','4514561',99,0,1,'asdd','156165','','56165','2018-04-21 03:59:00',35,1),(18,'sadasd','asdf','4514561',101,0,1,'asdd','156165','','56165','2018-04-21 03:59:09',36,1),(19,'asdasd','asdasd','56156',102,0,1,'asd','15665','','56165','2018-04-21 04:00:43',37,1),(20,'asdas','asds','56156',103,0,1,'xdaf','51656','','56.1256','2018-04-21 04:01:06',38,1),(21,'asdas','asd','561256',104,0,1,'asd','156165','','56156','2018-04-21 04:01:38',39,1),(22,'asdas','asd','564156',105,0,1,'asd','156156','','5616','2018-04-21 04:08:22',40,1),(23,'sadas','asdfas','1556',106,0,1,'asd','5616','','561','2018-04-21 14:17:06',41,1),(24,'adfasdas','asdas','1456156',107,0,1,'asdas','56165','','51561','2018-04-21 14:18:01',42,1),(25,'dfsdf','sdafasd','561456',108,0,1,'asd','15656','','5616','2018-04-21 14:19:59',43,1),(26,'asdas','asd','651256',113,0,0,'as','56.1256.','','26.','2018-04-21 17:10:28',48,2),(27,'t','t','1',114,0,0,'t','1','','1','2018-04-21 17:11:49',49,2),(28,'asdas','dasd','456165',120,0,0,'asds','56156','view/pictures/parceiro/cb8dd5855b1f2a8d0f1ecab00063da9f.png','561','2018-04-21 20:18:27',55,1),(29,'','','',123,0,0,'','','view/pictures/parceiro/9ff4d4e3c57397dea7bac86d1f9bad42.png','','2018-04-22 11:36:45',56,2),(33,'Great Speed','Great Speed Importados LTDA','4986598498',99,0,1,'greatspeed@gspeed.com.br','1152145785','path','11124536528','2018-05-10 10:46:13',33,2);
/*!40000 ALTER TABLE `tbl_parceiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pedido`
--

DROP TABLE IF EXISTS `tbl_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_pedido` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `data_agendada` datetime DEFAULT NULL,
  `log_pedido` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_pedido`),
  KEY `fk_tbl_pedido_id_cliente_idx` (`id_cliente`),
  KEY `fk_tbl_pedido_id_produto_idx` (`id_produto`),
  CONSTRAINT `fk_tbl_pedido_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `tbl_cliente` (`id_cliente`),
  CONSTRAINT `fk_tbl_pedido_id_produto` FOREIGN KEY (`id_produto`) REFERENCES `tbl_produto` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pedido`
--

LOCK TABLES `tbl_pedido` WRITE;
/*!40000 ALTER TABLE `tbl_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pergunta_chatbot`
--

DROP TABLE IF EXISTS `tbl_pergunta_chatbot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_pergunta_chatbot` (
  `id_pergunta_chatbot` int(11) NOT NULL AUTO_INCREMENT,
  `pergunta` varchar(800) NOT NULL,
  PRIMARY KEY (`id_pergunta_chatbot`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pergunta_chatbot`
--

LOCK TABLES `tbl_pergunta_chatbot` WRITE;
/*!40000 ALTER TABLE `tbl_pergunta_chatbot` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_pergunta_chatbot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pergunta_resposta_chatbot`
--

DROP TABLE IF EXISTS `tbl_pergunta_resposta_chatbot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_pergunta_resposta_chatbot` (
  `id_pergunta_resposta_chatbot` int(11) NOT NULL AUTO_INCREMENT,
  `id_pergunta` int(11) NOT NULL,
  `id_resposta` int(11) NOT NULL,
  PRIMARY KEY (`id_pergunta_resposta_chatbot`),
  KEY `fk_tbl_pergunta_resposta_chatbot_id_pergunta_idx` (`id_pergunta`),
  KEY `fk_tbl_pergunta_resposta_chatbot_id_resposta_idx` (`id_resposta`),
  CONSTRAINT `fk_tbl_pergunta_resposta_chatbot_id_pergunta` FOREIGN KEY (`id_pergunta`) REFERENCES `tbl_pergunta_chatbot` (`id_pergunta_chatbot`),
  CONSTRAINT `fk_tbl_pergunta_resposta_chatbot_id_resposta` FOREIGN KEY (`id_resposta`) REFERENCES `tbl_resposta_chatbot` (`id_resposta_chatbot`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pergunta_resposta_chatbot`
--

LOCK TABLES `tbl_pergunta_resposta_chatbot` WRITE;
/*!40000 ALTER TABLE `tbl_pergunta_resposta_chatbot` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_pergunta_resposta_chatbot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_plano_contratacao`
--

DROP TABLE IF EXISTS `tbl_plano_contratacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_plano_contratacao` (
  `id_plano_contratacao` int(11) NOT NULL AUTO_INCREMENT,
  `plano` varchar(120) NOT NULL,
  `valor` decimal(8,2) NOT NULL,
  `descricao` varchar(2400) NOT NULL,
  PRIMARY KEY (`id_plano_contratacao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_plano_contratacao`
--

LOCK TABLES `tbl_plano_contratacao` WRITE;
/*!40000 ALTER TABLE `tbl_plano_contratacao` DISABLE KEYS */;
INSERT INTO `tbl_plano_contratacao` VALUES (1,'Premium',580.00,'O melhor plano da PAC'),(2,'Medium',350.00,'Test');
/*!40000 ALTER TABLE `tbl_plano_contratacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_post_rede_social`
--

DROP TABLE IF EXISTS `tbl_post_rede_social`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_post_rede_social` (
  `id_post_rede_social` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `post` varchar(1500) DEFAULT NULL,
  `foto` varchar(350) DEFAULT NULL,
  `log_post_rede_social` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_post_rede_social`),
  KEY `fk_tbl_post_rede_social_id_usuario_idx` (`id_usuario`),
  CONSTRAINT `fk_tbl_post_rede_social_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `tbl_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_post_rede_social`
--

LOCK TABLES `tbl_post_rede_social` WRITE;
/*!40000 ALTER TABLE `tbl_post_rede_social` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_post_rede_social` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_produto`
--

DROP TABLE IF EXISTS `tbl_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_produto` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `id_modelo_produto` int(11) NOT NULL,
  `id_parceiro` int(11) NOT NULL,
  `id_cor` int(11) NOT NULL,
  `id_categoria_produto` int(11) NOT NULL,
  `nome` varchar(180) NOT NULL,
  `preco` decimal(8,2) NOT NULL,
  `conteudo_embalagem` varchar(4000) NOT NULL,
  `garantia` varchar(1500) NOT NULL,
  `descricao` varchar(5500) NOT NULL,
  `observacao` varchar(5500) DEFAULT NULL,
  PRIMARY KEY (`id_produto`),
  KEY `fk_tbl_produto_id_modelo_produto_idx` (`id_modelo_produto`),
  KEY `fk_tbl_produto_id_parceiro_idx` (`id_parceiro`),
  KEY `fk_tbl_produto_id_cor_idx` (`id_cor`),
  KEY `fk_tbl_produto_id_categoria_idx` (`id_categoria_produto`),
  CONSTRAINT `fk_tbl_produto_id_categoria` FOREIGN KEY (`id_categoria_produto`) REFERENCES `tbl_categoria_produto` (`id_categoria_produto`),
  CONSTRAINT `fk_tbl_produto_id_cor` FOREIGN KEY (`id_cor`) REFERENCES `tbl_cor` (`id_cor`),
  CONSTRAINT `fk_tbl_produto_id_modelo_produto` FOREIGN KEY (`id_modelo_produto`) REFERENCES `tbl_modelo_produto` (`id_modelo_produto`),
  CONSTRAINT `fk_tbl_produto_id_parceiro` FOREIGN KEY (`id_parceiro`) REFERENCES `tbl_parceiro` (`id_parceiro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_produto`
--

LOCK TABLES `tbl_produto` WRITE;
/*!40000 ALTER TABLE `tbl_produto` DISABLE KEYS */;
INSERT INTO `tbl_produto` VALUES (3,1,1,1,2,'Farol',875.00,'1 farol','5 meses','test',NULL),(4,1,1,1,2,'Pneu',300.00,'1 pneu','12 meses','',NULL),(5,1,1,1,1,'Pneu',300.00,'1 pneu','12 meses','',NULL);
/*!40000 ALTER TABLE `tbl_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_resposta_chatbot`
--

DROP TABLE IF EXISTS `tbl_resposta_chatbot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_resposta_chatbot` (
  `id_resposta_chatbot` int(11) NOT NULL AUTO_INCREMENT,
  `resposta` varchar(1500) NOT NULL,
  PRIMARY KEY (`id_resposta_chatbot`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_resposta_chatbot`
--

LOCK TABLES `tbl_resposta_chatbot` WRITE;
/*!40000 ALTER TABLE `tbl_resposta_chatbot` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_resposta_chatbot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_seguir_rede_social`
--

DROP TABLE IF EXISTS `tbl_seguir_rede_social`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_seguir_rede_social` (
  `id_seguir_rede_social` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_seguidor` int(11) NOT NULL,
  `usuario_seguido` int(11) NOT NULL,
  `log_seguir_rede_social` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_seguir_rede_social`),
  KEY `fk_tbl_seguir_rede_social_usuario_seguidor_idx` (`usuario_seguidor`),
  KEY `fk_tbl_seguir_rede_social_usuario_seguido_idx` (`usuario_seguido`),
  CONSTRAINT `fk_tbl_seguir_rede_social_usuario_seguido` FOREIGN KEY (`usuario_seguido`) REFERENCES `tbl_usuario` (`id_usuario`),
  CONSTRAINT `fk_tbl_seguir_rede_social_usuario_seguidor` FOREIGN KEY (`usuario_seguidor`) REFERENCES `tbl_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_seguir_rede_social`
--

LOCK TABLES `tbl_seguir_rede_social` WRITE;
/*!40000 ALTER TABLE `tbl_seguir_rede_social` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_seguir_rede_social` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_situacao_pedido`
--

DROP TABLE IF EXISTS `tbl_situacao_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_situacao_pedido` (
  `id_situacao_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `id_pedido` int(11) NOT NULL,
  `id_tipo_situacao_pedido` int(11) NOT NULL,
  `log_situacao_pedido` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_situacao_pedido`),
  KEY `fk_tbl_situacao_pedido_id_pedido_idx` (`id_pedido`),
  KEY `fk_tbl_situacao_pedido_id_tipo_situacao_pedido_idx` (`id_tipo_situacao_pedido`),
  CONSTRAINT `fk_tbl_situacao_pedido_id_pedido` FOREIGN KEY (`id_pedido`) REFERENCES `tbl_pedido` (`id_pedido`),
  CONSTRAINT `fk_tbl_situacao_pedido_id_tipo_situacao_pedido` FOREIGN KEY (`id_tipo_situacao_pedido`) REFERENCES `tbl_tipo_situacao_pedido` (`id_tipo_situacao_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_situacao_pedido`
--

LOCK TABLES `tbl_situacao_pedido` WRITE;
/*!40000 ALTER TABLE `tbl_situacao_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_situacao_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sobre_cliente_parceiro`
--

DROP TABLE IF EXISTS `tbl_sobre_cliente_parceiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_sobre_cliente_parceiro` (
  `id_sobre_cliente_parceiro` int(11) NOT NULL AUTO_INCREMENT,
  `imagem` varchar(300) NOT NULL,
  `descricao` varchar(1800) NOT NULL,
  `id_tipo_descricao` int(11) NOT NULL,
  `log_sobre_cliente_parceiro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_sobre_cliente_parceiro`),
  KEY `fk_tbl_sobre_cliente_parceiro_id_tipo_descricao_idx` (`id_tipo_descricao`),
  CONSTRAINT `fk_tbl_sobre_cliente_parceiro_id_tipo_descricao` FOREIGN KEY (`id_tipo_descricao`) REFERENCES `tbl_tipo_descricao` (`id_tipo_descricao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sobre_cliente_parceiro`
--

LOCK TABLES `tbl_sobre_cliente_parceiro` WRITE;
/*!40000 ALTER TABLE `tbl_sobre_cliente_parceiro` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_sobre_cliente_parceiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sobre_empresa`
--

DROP TABLE IF EXISTS `tbl_sobre_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_sobre_empresa` (
  `id_sobre_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `imagem` varchar(480) NOT NULL,
  `texto` varchar(2800) NOT NULL,
  `id_topico_sobre_empresa` int(11) NOT NULL,
  PRIMARY KEY (`id_sobre_empresa`),
  KEY `fk_tbl_topico_sobre_empresa_id_topico_sobre_empresa` (`id_topico_sobre_empresa`),
  CONSTRAINT `fk_tbl_topico_sobre_empresa_id_topico_sobre_empresa` FOREIGN KEY (`id_topico_sobre_empresa`) REFERENCES `tbl_topico_sobre_empresa` (`id_topico_sobre_empresa`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sobre_empresa`
--

LOCK TABLES `tbl_sobre_empresa` WRITE;
/*!40000 ALTER TABLE `tbl_sobre_empresa` DISABLE KEYS */;
INSERT INTO `tbl_sobre_empresa` VALUES (1,'/pictures/sobre_empresa/9ff4d4e3c57397dea7bac86d1f9bad42.png','aaaaaa',1),(2,'/pictures/sobre_empresa/9ff4d4e3c57397dea7bac86d1f9bad42.png','bbbbbbbbbbbb',2),(3,'/pictures/sobre_empresa/d83099a767497a258e01b12e67f84057.png','ccccccccccc',3),(4,'/pictures/sobre_empresa/1a2a250bcd25e124bb8096874936ed41.jpg','dddddddddddddd',4);
/*!40000 ALTER TABLE `tbl_sobre_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_socorrista_socorro_ja`
--

DROP TABLE IF EXISTS `tbl_socorrista_socorro_ja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_socorrista_socorro_ja` (
  `id_socorrista_socorro_ja` int(11) NOT NULL AUTO_INCREMENT,
  `id_parceiro` int(11) NOT NULL,
  `id_socorro_ja` int(11) NOT NULL,
  `log_socorrista_socorro_ja` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_socorrista_socorro_ja`),
  KEY `fk_tbl_socorrista_socorro_ja_id_parceiro_idx` (`id_parceiro`),
  KEY `fk_tbl_socorrista_socorro_ja_id_socorro_ja_idx` (`id_socorro_ja`),
  CONSTRAINT `fk_tbl_socorrista_socorro_ja_id_parceiro` FOREIGN KEY (`id_parceiro`) REFERENCES `tbl_parceiro` (`id_parceiro`),
  CONSTRAINT `fk_tbl_socorrista_socorro_ja_id_socorro_ja` FOREIGN KEY (`id_socorro_ja`) REFERENCES `tbl_socorro_ja` (`id_socorro_ja`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_socorrista_socorro_ja`
--

LOCK TABLES `tbl_socorrista_socorro_ja` WRITE;
/*!40000 ALTER TABLE `tbl_socorrista_socorro_ja` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_socorrista_socorro_ja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_socorro_ja`
--

DROP TABLE IF EXISTS `tbl_socorro_ja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_socorro_ja` (
  `id_socorro_ja` int(11) NOT NULL AUTO_INCREMENT,
  `problema` varchar(6800) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `atendido` tinyint(1) NOT NULL,
  `log_socorro_ja` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_socorro_ja`),
  KEY `fk_tbl_socorro_ja_id_endereco_idx` (`id_endereco`),
  KEY `fk_tbl_socorro_ja_id_cliente_idx` (`id_cliente`),
  CONSTRAINT `fk_tbl_socorro_ja_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `tbl_cliente` (`id_cliente`),
  CONSTRAINT `fk_tbl_socorro_ja_id_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `tbl_endereco` (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_socorro_ja`
--

LOCK TABLES `tbl_socorro_ja` WRITE;
/*!40000 ALTER TABLE `tbl_socorro_ja` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_socorro_ja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tipo_combustivel`
--

DROP TABLE IF EXISTS `tbl_tipo_combustivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_tipo_combustivel` (
  `id_tipo_combustivel` int(11) NOT NULL AUTO_INCREMENT,
  `combustivel` varchar(120) NOT NULL,
  PRIMARY KEY (`id_tipo_combustivel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tipo_combustivel`
--

LOCK TABLES `tbl_tipo_combustivel` WRITE;
/*!40000 ALTER TABLE `tbl_tipo_combustivel` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_tipo_combustivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tipo_descricao`
--

DROP TABLE IF EXISTS `tbl_tipo_descricao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_tipo_descricao` (
  `id_tipo_descricao` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(180) NOT NULL,
  PRIMARY KEY (`id_tipo_descricao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tipo_descricao`
--

LOCK TABLES `tbl_tipo_descricao` WRITE;
/*!40000 ALTER TABLE `tbl_tipo_descricao` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_tipo_descricao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tipo_situacao_pedido`
--

DROP TABLE IF EXISTS `tbl_tipo_situacao_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_tipo_situacao_pedido` (
  `id_tipo_situacao_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `situacao` varchar(120) NOT NULL,
  PRIMARY KEY (`id_tipo_situacao_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tipo_situacao_pedido`
--

LOCK TABLES `tbl_tipo_situacao_pedido` WRITE;
/*!40000 ALTER TABLE `tbl_tipo_situacao_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_tipo_situacao_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tipo_veiculo`
--

DROP TABLE IF EXISTS `tbl_tipo_veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_tipo_veiculo` (
  `id_tipo_veiculo` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(120) NOT NULL,
  PRIMARY KEY (`id_tipo_veiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tipo_veiculo`
--

LOCK TABLES `tbl_tipo_veiculo` WRITE;
/*!40000 ALTER TABLE `tbl_tipo_veiculo` DISABLE KEYS */;
INSERT INTO `tbl_tipo_veiculo` VALUES (1,'Carro'),(2,'Moto');
/*!40000 ALTER TABLE `tbl_tipo_veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_topico_forum`
--

DROP TABLE IF EXISTS `tbl_topico_forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_topico_forum` (
  `id_topico_forum` int(11) NOT NULL,
  `foto` varchar(350) DEFAULT NULL,
  `mensagem` varchar(5500) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `log_topico_forum` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_categoria_topico_forum` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `finalizado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_topico_forum`),
  KEY `fk_tbl_topico_forum_id_categoria_topico_forum_idx` (`id_categoria_topico_forum`),
  KEY `fk_tbl_topico_forum_id_cliente_idx` (`id_cliente`),
  CONSTRAINT `fk_tbl_topico_forum_id_categoria_topico_forum` FOREIGN KEY (`id_categoria_topico_forum`) REFERENCES `tbl_categoria_topico_forum` (`id_categoria_topico_forum`),
  CONSTRAINT `fk_tbl_topico_forum_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `tbl_cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_topico_forum`
--

LOCK TABLES `tbl_topico_forum` WRITE;
/*!40000 ALTER TABLE `tbl_topico_forum` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_topico_forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_topico_sobre_empresa`
--

DROP TABLE IF EXISTS `tbl_topico_sobre_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_topico_sobre_empresa` (
  `id_topico_sobre_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `topico_sobre_empresa` varchar(120) NOT NULL,
  PRIMARY KEY (`id_topico_sobre_empresa`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_topico_sobre_empresa`
--

LOCK TABLES `tbl_topico_sobre_empresa` WRITE;
/*!40000 ALTER TABLE `tbl_topico_sobre_empresa` DISABLE KEYS */;
INSERT INTO `tbl_topico_sobre_empresa` VALUES (1,'Missão'),(2,'Visão'),(3,'Valores'),(4,'Empresa');
/*!40000 ALTER TABLE `tbl_topico_sobre_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario`
--

DROP TABLE IF EXISTS `tbl_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(160) NOT NULL,
  `senha` varchar(280) NOT NULL,
  `log` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_nivel_usuario` int(11) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_usuario`),
  KEY `fk_tbl_usuario_id_nivel_usuario_idx` (`id_nivel_usuario`),
  CONSTRAINT `fk_tbl_usuario_id_nivel_usuario` FOREIGN KEY (`id_nivel_usuario`) REFERENCES `tbl_nivel_usuario` (`id_nivel_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario`
--

LOCK TABLES `tbl_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_usuario` DISABLE KEYS */;
INSERT INTO `tbl_usuario` VALUES (1,'leticia','lele','2018-04-12 09:45:06',1,1),(33,'gspeed','runrun','2018-04-21 03:56:44',2,1),(34,'aaaaaass','aaaaaaa','2018-04-21 03:57:19',2,1),(35,'aaaaaassDSDD','aaaaaaa','2018-04-21 03:59:00',2,1),(36,'aaaaaassDSDDsss','aaaaaaa','2018-04-21 03:59:09',2,1),(37,'aaaaaasadasdasdasdas','aaaaaaa','2018-04-21 04:00:43',2,1),(38,'aaaaaa\\xd\\sdsadasds','aaaaaaa','2018-04-21 04:01:06',2,1),(39,'aaaaaacdasdfasdasdas','aaaaaaa','2018-04-21 04:01:38',2,1),(40,'aaaaaaadcasdas','aaaaaaa','2018-04-21 04:08:22',2,1),(41,'aaaaaaasdasdsad','aaaaaaa','2018-04-21 14:17:06',2,1),(42,'aaaaaaczxcvdacaxdca','aaaaaaa','2018-04-21 14:18:01',2,1),(43,'aaaaaa\\xc\\szxd\\s','aaaaaaa','2018-04-21 14:19:59',2,1),(44,'aaaasasa','asdasd','2018-04-21 16:07:22',2,1),(45,'nAdm','1','2018-04-21 16:10:04',2,1),(46,'asd','asdas','2018-04-21 16:13:21',2,1),(47,'ssssdd','sadas','2018-04-21 17:07:37',2,1),(48,'das','dsad','2018-04-21 17:10:28',2,1),(49,'t','t','2018-04-21 17:11:49',2,1),(50,'asddfas','sdvsd','2018-04-21 17:47:15',2,1),(51,'sdfgsdfg','asdas','2018-04-21 17:48:26',2,1),(52,'sd','sdfvsd','2018-04-21 17:49:03',2,1),(53,'sdvgfsda','asdfawe','2018-04-21 17:49:48',2,1),(54,'dsad','fdsf','2018-04-21 17:51:40',2,1),(55,'sddff','sdffae','2018-04-21 20:18:27',2,1),(56,'afasddfas','dvfda','2018-04-22 11:36:45',2,1);
/*!40000 ALTER TABLE `tbl_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_veiculo`
--

DROP TABLE IF EXISTS `tbl_veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_veiculo` (
  `id_veiculo` int(11) NOT NULL AUTO_INCREMENT,
  `ano_fabricacao` year(4) NOT NULL,
  `placa` varchar(15) NOT NULL,
  `id_cor` int(11) NOT NULL,
  `id_modelo` int(11) NOT NULL,
  `qtd_porta` int(11) NOT NULL,
  `quilometro_rodado` int(11) NOT NULL,
  `id_tipo_veiculo` int(11) NOT NULL,
  `id_modelo_veiculo` int(11) NOT NULL,
  PRIMARY KEY (`id_veiculo`),
  KEY `fk_tbl_veiculo_id_cor_idx` (`id_cor`),
  KEY `fk_tbl_veiculo_id_modelo_veiculo_idx` (`id_modelo_veiculo`),
  CONSTRAINT `fk_tbl_veiculo_id_cor` FOREIGN KEY (`id_cor`) REFERENCES `tbl_cor` (`id_cor`),
  CONSTRAINT `fk_tbl_veiculo_id_modelo_veiculo` FOREIGN KEY (`id_modelo_veiculo`) REFERENCES `tbl_modelo_veiculo` (`id_modelo_veiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_veiculo`
--

LOCK TABLES `tbl_veiculo` WRITE;
/*!40000 ALTER TABLE `tbl_veiculo` DISABLE KEYS */;
INSERT INTO `tbl_veiculo` VALUES (1,2018,'DFR-2154',1,1,4,0,1,1),(2,2018,'RFT-2541',1,1,0,0,2,1);
/*!40000 ALTER TABLE `tbl_veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_veiculo_cliente`
--

DROP TABLE IF EXISTS `tbl_veiculo_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_veiculo_cliente` (
  `id_veiculo_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `id_veiculo` int(11) NOT NULL,
  PRIMARY KEY (`id_veiculo_cliente`),
  KEY `fk_veiculo_cliente_id_veiculo_idx` (`id_veiculo`),
  KEY `fk_veiculo_cliente_id_cliente_idx` (`id_cliente`),
  CONSTRAINT `fk_veiculo_cliente_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `tbl_cliente` (`id_cliente`),
  CONSTRAINT `fk_veiculo_cliente_id_veiculo` FOREIGN KEY (`id_veiculo`) REFERENCES `tbl_veiculo` (`id_veiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_veiculo_cliente`
--

LOCK TABLES `tbl_veiculo_cliente` WRITE;
/*!40000 ALTER TABLE `tbl_veiculo_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_veiculo_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_veiculo_parceiro`
--

DROP TABLE IF EXISTS `tbl_veiculo_parceiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_veiculo_parceiro` (
  `id_veiculo_parceiro` int(11) NOT NULL AUTO_INCREMENT,
  `id_parceiro` int(11) NOT NULL,
  `id_veiculo` int(11) NOT NULL,
  PRIMARY KEY (`id_veiculo_parceiro`),
  KEY `fk_tbl_veiculo_parceiro_id_parceiro_idx` (`id_parceiro`),
  KEY `fk_tbl_veiculo_parceiro_id_veiculo_idx` (`id_veiculo`),
  CONSTRAINT `fk_tbl_veiculo_parceiro_id_parceiro` FOREIGN KEY (`id_parceiro`) REFERENCES `tbl_parceiro` (`id_parceiro`),
  CONSTRAINT `fk_tbl_veiculo_parceiro_id_veiculo` FOREIGN KEY (`id_veiculo`) REFERENCES `tbl_veiculo` (`id_veiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_veiculo_parceiro`
--

LOCK TABLES `tbl_veiculo_parceiro` WRITE;
/*!40000 ALTER TABLE `tbl_veiculo_parceiro` DISABLE KEYS */;
INSERT INTO `tbl_veiculo_parceiro` VALUES (1,1,1),(2,1,2);
/*!40000 ALTER TABLE `tbl_veiculo_parceiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_veiculo_tipo_combustivel`
--

DROP TABLE IF EXISTS `tbl_veiculo_tipo_combustivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_veiculo_tipo_combustivel` (
  `id_veiculo_tipo_combustivel` int(11) NOT NULL AUTO_INCREMENT,
  `id_veiculo` int(11) NOT NULL,
  `id_tipo_combustivel` int(11) NOT NULL,
  PRIMARY KEY (`id_veiculo_tipo_combustivel`),
  KEY `fk_tbl_veiculo_tipo_combustivel_id_veiculo_idx` (`id_veiculo`),
  KEY `fk_tbl_veiculo_tipo_combustivel_id_tipo_combustivel_idx` (`id_tipo_combustivel`),
  CONSTRAINT `fk_tbl_veiculo_tipo_combustivel_id_tipo_combustivel` FOREIGN KEY (`id_tipo_combustivel`) REFERENCES `tbl_tipo_combustivel` (`id_tipo_combustivel`),
  CONSTRAINT `fk_tbl_veiculo_tipo_combustivel_id_veiculo` FOREIGN KEY (`id_veiculo`) REFERENCES `tbl_veiculo` (`id_veiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_veiculo_tipo_combustivel`
--

LOCK TABLES `tbl_veiculo_tipo_combustivel` WRITE;
/*!40000 ALTER TABLE `tbl_veiculo_tipo_combustivel` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_veiculo_tipo_combustivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_cliente`
--

DROP TABLE IF EXISTS `view_cliente`;
/*!50001 DROP VIEW IF EXISTS `view_cliente`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_cliente` AS SELECT 
 1 AS `id_cliente`,
 1 AS `nome`,
 1 AS `dtNasc`,
 1 AS `cpf`,
 1 AS `email`,
 1 AS `celular`,
 1 AS `id_endereco`,
 1 AS `sexo`,
 1 AS `telefone`,
 1 AS `id_usuario`,
 1 AS `foto_perfil`,
 1 AS `usuario`,
 1 AS `senha`,
 1 AS `log`,
 1 AS `ativo`,
 1 AS `id_nivel_usuario`,
 1 AS `nivel`,
 1 AS `logradouro`,
 1 AS `numero`,
 1 AS `cidade`,
 1 AS `id_estado`,
 1 AS `cep`,
 1 AS `bairro`,
 1 AS `complemento`,
 1 AS `estado`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_imagem_produto_parceiro`
--

DROP TABLE IF EXISTS `view_imagem_produto_parceiro`;
/*!50001 DROP VIEW IF EXISTS `view_imagem_produto_parceiro`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_imagem_produto_parceiro` AS SELECT 
 1 AS `id_imagem_produto_parceiro`,
 1 AS `id_produto`,
 1 AS `imagem`,
 1 AS `ativo`,
 1 AS `categoria`,
 1 AS `id_categoria_produto`,
 1 AS `razao_social`,
 1 AS `nome_fantasia`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_imagem_veiculo_parceiro`
--

DROP TABLE IF EXISTS `view_imagem_veiculo_parceiro`;
/*!50001 DROP VIEW IF EXISTS `view_imagem_veiculo_parceiro`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_imagem_veiculo_parceiro` AS SELECT 
 1 AS `id_imagem_veiculo_parceiro`,
 1 AS `id_veiculo_parceiro`,
 1 AS `imagem`,
 1 AS `ativo`,
 1 AS `id_parceiro`,
 1 AS `tipo`,
 1 AS `id_tipo_veiculo`,
 1 AS `nome_fantasia`,
 1 AS `razao_social`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_parceiro`
--

DROP TABLE IF EXISTS `view_parceiro`;
/*!50001 DROP VIEW IF EXISTS `view_parceiro`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_parceiro` AS SELECT 
 1 AS `id_parceiro`,
 1 AS `nome_fantasia`,
 1 AS `cnpj`,
 1 AS `razao_social`,
 1 AS `id_endereco`,
 1 AS `parceiro_ativo`,
 1 AS `foto_perfil`,
 1 AS `email`,
 1 AS `socorrista`,
 1 AS `telefone`,
 1 AS `celular`,
 1 AS `log_parceiro`,
 1 AS `id_usuario`,
 1 AS `id_plano_contratacao`,
 1 AS `usuario`,
 1 AS `senha`,
 1 AS `log`,
 1 AS `ativo`,
 1 AS `id_nivel_usuario`,
 1 AS `nivel`,
 1 AS `logradouro`,
 1 AS `numero`,
 1 AS `cidade`,
 1 AS `id_estado`,
 1 AS `cep`,
 1 AS `bairro`,
 1 AS `complemento`,
 1 AS `estado`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_produto`
--

DROP TABLE IF EXISTS `view_produto`;
/*!50001 DROP VIEW IF EXISTS `view_produto`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_produto` AS SELECT 
 1 AS `id_produto`,
 1 AS `nome`,
 1 AS `conteudo_embalagem`,
 1 AS `garantia`,
 1 AS `observacao`,
 1 AS `preco`,
 1 AS `descricao`,
 1 AS `imagem`,
 1 AS `modelo`,
 1 AS `id_parceiro`,
 1 AS `nome_fantasia`,
 1 AS `id_endereco`,
 1 AS `telefone`,
 1 AS `celular`,
 1 AS `logradouro`,
 1 AS `numero`,
 1 AS `cidade`,
 1 AS `id_estado`,
 1 AS `cep`,
 1 AS `bairro`,
 1 AS `complemento`,
 1 AS `estado`,
 1 AS `categoria`,
 1 AS `id_categoria_produto`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_produto_detalhado`
--

DROP TABLE IF EXISTS `view_produto_detalhado`;
/*!50001 DROP VIEW IF EXISTS `view_produto_detalhado`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_produto_detalhado` AS SELECT 
 1 AS `id_produto`,
 1 AS `id_modelo_produto`,
 1 AS `id_parceiro`,
 1 AS `id_cor`,
 1 AS `id_categoria_produto`,
 1 AS `nome`,
 1 AS `preco`,
 1 AS `conteudo_embalagem`,
 1 AS `garantia`,
 1 AS `descricao`,
 1 AS `observacao`,
 1 AS `modelo`,
 1 AS `id_fabricante_produto`,
 1 AS `peso`,
 1 AS `altura`,
 1 AS `comprimento`,
 1 AS `fabricante`,
 1 AS `nome_fantasia`,
 1 AS `razao_social`,
 1 AS `cnpj`,
 1 AS `id_endereco`,
 1 AS `ativo`,
 1 AS `socorrista`,
 1 AS `email`,
 1 AS `telefone`,
 1 AS `foto_perfil`,
 1 AS `celular`,
 1 AS `log_parceiro`,
 1 AS `logradouro`,
 1 AS `numero`,
 1 AS `cidade`,
 1 AS `id_estado`,
 1 AS `cep`,
 1 AS `bairro`,
 1 AS `complemento`,
 1 AS `estado`,
 1 AS `cor`,
 1 AS `categoria`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_receita_plano_contratacao`
--

DROP TABLE IF EXISTS `view_receita_plano_contratacao`;
/*!50001 DROP VIEW IF EXISTS `view_receita_plano_contratacao`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_receita_plano_contratacao` AS SELECT 
 1 AS `receita`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_total_despesas_internas`
--

DROP TABLE IF EXISTS `view_total_despesas_internas`;
/*!50001 DROP VIEW IF EXISTS `view_total_despesas_internas`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_total_despesas_internas` AS SELECT 
 1 AS `total_despesa`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_cliente`
--

/*!50001 DROP VIEW IF EXISTS `view_cliente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_cliente` AS select `cln`.`id_cliente` AS `id_cliente`,`cln`.`nome` AS `nome`,`cln`.`dtNasc` AS `dtNasc`,`cln`.`cpf` AS `cpf`,`cln`.`email` AS `email`,`cln`.`celular` AS `celular`,`cln`.`id_endereco` AS `id_endereco`,`cln`.`sexo` AS `sexo`,`cln`.`telefone` AS `telefone`,`cln`.`id_usuario` AS `id_usuario`,`cln`.`foto_perfil` AS `foto_perfil`,`usr`.`usuario` AS `usuario`,`usr`.`senha` AS `senha`,`usr`.`log` AS `log`,`usr`.`ativo` AS `ativo`,`usr`.`id_nivel_usuario` AS `id_nivel_usuario`,`nvl`.`nivel` AS `nivel`,`endrc`.`logradouro` AS `logradouro`,`endrc`.`numero` AS `numero`,`endrc`.`cidade` AS `cidade`,`endrc`.`id_estado` AS `id_estado`,`endrc`.`cep` AS `cep`,`endrc`.`bairro` AS `bairro`,`endrc`.`complemento` AS `complemento`,`estd`.`estado` AS `estado` from ((((`tbl_cliente` `cln` join `tbl_usuario` `usr` on((`usr`.`id_usuario` = `cln`.`id_usuario`))) join `tbl_nivel_usuario` `nvl` on((`nvl`.`id_nivel_usuario` = `usr`.`id_nivel_usuario`))) join `tbl_endereco` `endrc` on((`endrc`.`id_endereco` = `cln`.`id_endereco`))) join `tbl_estado` `estd` on((`estd`.`id_estado` = `endrc`.`id_estado`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_imagem_produto_parceiro`
--

/*!50001 DROP VIEW IF EXISTS `view_imagem_produto_parceiro`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_imagem_produto_parceiro` AS select `img_prdt_parc`.`id_imagem_produto_parceiro` AS `id_imagem_produto_parceiro`,`img_prdt_parc`.`id_produto` AS `id_produto`,`img_prdt_parc`.`imagem` AS `imagem`,`img_prdt_parc`.`ativo` AS `ativo`,`ctg_prdt`.`categoria` AS `categoria`,`prdt`.`id_categoria_produto` AS `id_categoria_produto`,`parc`.`razao_social` AS `razao_social`,`parc`.`nome_fantasia` AS `nome_fantasia` from (((`tbl_imagem_produto_parceiro` `img_prdt_parc` join `tbl_produto` `prdt` on((`prdt`.`id_produto` = `img_prdt_parc`.`id_produto`))) join `tbl_parceiro` `parc` on((`parc`.`id_parceiro` = `prdt`.`id_parceiro`))) join `tbl_categoria_produto` `ctg_prdt` on((`ctg_prdt`.`id_categoria_produto` = `prdt`.`id_categoria_produto`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_imagem_veiculo_parceiro`
--

/*!50001 DROP VIEW IF EXISTS `view_imagem_veiculo_parceiro`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_imagem_veiculo_parceiro` AS select `img_vei_parc`.`id_imagem_veiculo_parceiro` AS `id_imagem_veiculo_parceiro`,`img_vei_parc`.`id_veiculo_parceiro` AS `id_veiculo_parceiro`,`img_vei_parc`.`imagem` AS `imagem`,`img_vei_parc`.`ativo` AS `ativo`,`vei_parc`.`id_parceiro` AS `id_parceiro`,`tp_veic`.`tipo` AS `tipo`,`tp_veic`.`id_tipo_veiculo` AS `id_tipo_veiculo`,`parc`.`nome_fantasia` AS `nome_fantasia`,`parc`.`razao_social` AS `razao_social` from ((((`tbl_imagem_veiculo_parceiro` `img_vei_parc` join `tbl_veiculo_parceiro` `vei_parc` on((`vei_parc`.`id_veiculo_parceiro` = `img_vei_parc`.`id_veiculo_parceiro`))) join `tbl_parceiro` `parc` on((`parc`.`id_parceiro` = `vei_parc`.`id_parceiro`))) join `tbl_veiculo` `veic` on((`veic`.`id_veiculo` = `vei_parc`.`id_veiculo`))) join `tbl_tipo_veiculo` `tp_veic` on((`tp_veic`.`id_tipo_veiculo` = `veic`.`id_tipo_veiculo`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_parceiro`
--

/*!50001 DROP VIEW IF EXISTS `view_parceiro`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_parceiro` AS select `prc`.`id_parceiro` AS `id_parceiro`,`prc`.`nome_fantasia` AS `nome_fantasia`,`prc`.`cnpj` AS `cnpj`,`prc`.`razao_social` AS `razao_social`,`prc`.`id_endereco` AS `id_endereco`,`prc`.`ativo` AS `parceiro_ativo`,`prc`.`foto_perfil` AS `foto_perfil`,`prc`.`email` AS `email`,`prc`.`socorrista` AS `socorrista`,`prc`.`telefone` AS `telefone`,`prc`.`celular` AS `celular`,`prc`.`log_parceiro` AS `log_parceiro`,`prc`.`id_usuario` AS `id_usuario`,`prc`.`id_plano_contratacao` AS `id_plano_contratacao`,`usr`.`usuario` AS `usuario`,`usr`.`senha` AS `senha`,`usr`.`log` AS `log`,`usr`.`ativo` AS `ativo`,`usr`.`id_nivel_usuario` AS `id_nivel_usuario`,`nvl`.`nivel` AS `nivel`,`endrc`.`logradouro` AS `logradouro`,`endrc`.`numero` AS `numero`,`endrc`.`cidade` AS `cidade`,`endrc`.`id_estado` AS `id_estado`,`endrc`.`cep` AS `cep`,`endrc`.`bairro` AS `bairro`,`endrc`.`complemento` AS `complemento`,`estd`.`estado` AS `estado` from ((((`tbl_parceiro` `prc` join `tbl_usuario` `usr` on((`usr`.`id_usuario` = `prc`.`id_usuario`))) join `tbl_nivel_usuario` `nvl` on((`nvl`.`id_nivel_usuario` = `usr`.`id_nivel_usuario`))) join `tbl_endereco` `endrc` on((`endrc`.`id_endereco` = `prc`.`id_endereco`))) join `tbl_estado` `estd` on((`estd`.`id_estado` = `endrc`.`id_estado`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_produto`
--

/*!50001 DROP VIEW IF EXISTS `view_produto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_produto` AS select 1 AS `id_produto`,1 AS `nome`,1 AS `conteudo_embalagem`,1 AS `garantia`,1 AS `observacao`,1 AS `preco`,1 AS `descricao`,1 AS `imagem`,1 AS `modelo`,1 AS `id_parceiro`,1 AS `nome_fantasia`,1 AS `id_endereco`,1 AS `telefone`,1 AS `celular`,1 AS `logradouro`,1 AS `numero`,1 AS `cidade`,1 AS `id_estado`,1 AS `cep`,1 AS `bairro`,1 AS `complemento`,1 AS `estado`,1 AS `categoria`,1 AS `id_categoria_produto` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_produto_detalhado`
--

/*!50001 DROP VIEW IF EXISTS `view_produto_detalhado`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_produto_detalhado` AS select 1 AS `id_produto`,1 AS `id_modelo_produto`,1 AS `id_parceiro`,1 AS `id_cor`,1 AS `id_categoria_produto`,1 AS `nome`,1 AS `preco`,1 AS `conteudo_embalagem`,1 AS `garantia`,1 AS `descricao`,1 AS `observacao`,1 AS `modelo`,1 AS `id_fabricante_produto`,1 AS `peso`,1 AS `altura`,1 AS `comprimento`,1 AS `fabricante`,1 AS `nome_fantasia`,1 AS `razao_social`,1 AS `cnpj`,1 AS `id_endereco`,1 AS `ativo`,1 AS `socorrista`,1 AS `email`,1 AS `telefone`,1 AS `foto_perfil`,1 AS `celular`,1 AS `log_parceiro`,1 AS `logradouro`,1 AS `numero`,1 AS `cidade`,1 AS `id_estado`,1 AS `cep`,1 AS `bairro`,1 AS `complemento`,1 AS `estado`,1 AS `cor`,1 AS `categoria` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_receita_plano_contratacao`
--

/*!50001 DROP VIEW IF EXISTS `view_receita_plano_contratacao`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_receita_plano_contratacao` AS select sum(`pln_contr`.`valor`) AS `receita` from (`tbl_plano_contratacao` `pln_contr` join `tbl_parceiro` `parc` on((`parc`.`id_plano_contratacao` = `pln_contr`.`id_plano_contratacao`))) where (`parc`.`ativo` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_total_despesas_internas`
--

/*!50001 DROP VIEW IF EXISTS `view_total_despesas_internas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_total_despesas_internas` AS select (sum(`contas`.`valor`) + sum(`func`.`salario`)) AS `total_despesa` from (`tbl_conta_pac` `contas` join `tbl_funcionario_pac` `func`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-10 11:26:18
