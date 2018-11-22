-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema programacao
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema programacao
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `programacao` DEFAULT CHARACTER SET utf8 ;
USE `programacao` ;

-- -----------------------------------------------------
-- Table `programacao`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `programacao`.`marca` (
  `id_marca` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_marca` VARCHAR(50) NOT NULL,
  `status` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id_marca`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `programacao`.`modelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `programacao`.`modelo` (
  `id_modelo` INT(11) NOT NULL AUTO_INCREMENT,
  `id_marca` INT(11) NULL DEFAULT NULL,
  `nome_modelo` VARCHAR(50) NOT NULL,
  `status` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id_modelo`),
  INDEX `id_marca` (`id_marca` ASC),
  CONSTRAINT `modelo_ibfk_1`
    FOREIGN KEY (`id_marca`)
    REFERENCES `programacao`.`marca` (`id_marca`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `programacao`.`automovel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `programacao`.`automovel` (
  `id_automovel` INT(11) NOT NULL AUTO_INCREMENT,
  `id_modelo` INT(11) NULL DEFAULT NULL,
  `placa` VARCHAR(8) NOT NULL,
  `cor` VARCHAR(30) NOT NULL,
  `tipo_combustivel` VARCHAR(25) NOT NULL,
  `km_atual` DECIMAL(10,1) NOT NULL,
  `renavam` VARCHAR(20) NULL DEFAULT NULL,
  `chassi` VARCHAR(20) NULL DEFAULT NULL,
  `valor_locacao_hora` DECIMAL(10,2) NULL DEFAULT NULL,
  `valor_locacao_km` DECIMAL(10,2) NULL DEFAULT NULL,
  `status` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id_automovel`),
  INDEX `id_modelo` (`id_modelo` ASC),
  CONSTRAINT `automovel_ibfk_1`
    FOREIGN KEY (`id_modelo`)
    REFERENCES `programacao`.`modelo` (`id_modelo`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `programacao`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `programacao`.`cliente` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_cliente` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(14) NULL DEFAULT NULL,
  `status` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `programacao`.`locacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `programacao`.`locacao` (
  `id_locacao` INT(11) NOT NULL AUTO_INCREMENT,
  `id_automovel` INT(11) NULL DEFAULT NULL,
  `id_cliente` INT(11) NULL DEFAULT NULL,
  `hora_inicio` DATETIME NOT NULL,
  `hora_fim` DATETIME NOT NULL,
  `km_inicio` DECIMAL(10,1) NULL DEFAULT NULL,
  `km_fim` DECIMAL(10,1) NULL DEFAULT NULL,
  `km_rodado` DECIMAL(10,1) NULL DEFAULT NULL,
  `tempo_hora` DOUBLE NULL DEFAULT NULL,
  `valor_hora` DECIMAL(10,2) NULL DEFAULT NULL,
  `valor_km` DECIMAL(10,2) NULL DEFAULT NULL,
  `valor_total` DECIMAL(10,2) NULL DEFAULT NULL,
  `status` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id_locacao`),
  INDEX `id_automovel` (`id_automovel` ASC),
  INDEX `id_cliente` (`id_cliente` ASC),
  CONSTRAINT `locacao_ibfk_1`
    FOREIGN KEY (`id_automovel`)
    REFERENCES `programacao`.`automovel` (`id_automovel`),
  CONSTRAINT `locacao_ibfk_2`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `programacao`.`cliente` (`id_cliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `programacao`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `programacao`.`usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `login_user` VARCHAR(25) NOT NULL,
  `senha_user` VARCHAR(64) NOT NULL,
  `nome_user` VARCHAR(120) NULL DEFAULT NULL,
  `email_user` VARCHAR(60) NULL DEFAULT NULL,
  `status` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
