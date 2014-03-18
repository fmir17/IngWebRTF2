CREATE DATABASE bdPolla;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `bdPolla` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `bdPolla` ;

-- -----------------------------------------------------
-- Table `bdPolla`.`EQ_Equipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdPolla`.`EQ_Equipo` (
  `EQ_Id` INT NOT NULL,
  `EQ_Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`EQ_Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdPolla`.`TO_Torneo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdPolla`.`TO_Torneo` (
  `TO_Id` INT NOT NULL,
  `TO_Nombre` VARCHAR(100) NOT NULL,
  `TO_URIIMAGEN` VARCHAR(200) NULL,
  PRIMARY KEY (`TO_Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdPolla`.`PA_Partido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdPolla`.`PA_Partido` (
  `PA_EQ_IdVisitante` INT NOT NULL,
  `PA_EQ_IdLocal` INT NOT NULL,
  `PA_Fecha` DATE NOT NULL,
  `PA_TO_Id` INT NOT NULL,
  `PA_Hora` TIME NOT NULL,
  `PA_NroGolVis` INT NULL,
  `PA_NroGolLoc` INT NULL,
  PRIMARY KEY (`PA_EQ_IdVisitante`, `PA_EQ_IdLocal`, `PA_Fecha`),
  INDEX `fk_PA_Partido_EQ_Equipo1_idx` (`PA_EQ_IdLocal` ASC),
  INDEX `fk_PA_Partido_TO_Torneo1_idx` (`PA_TO_Id` ASC),
  CONSTRAINT `fk_PA_Partido_EQ_Equipo`
    FOREIGN KEY (`PA_EQ_IdVisitante`)
    REFERENCES `bdPolla`.`EQ_Equipo` (`EQ_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PA_Partido_EQ_Equipo1`
    FOREIGN KEY (`PA_EQ_IdLocal`)
    REFERENCES `bdPolla`.`EQ_Equipo` (`EQ_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PA_Partido_TO_Torneo1`
    FOREIGN KEY (`PA_TO_Id`)
    REFERENCES `bdPolla`.`TO_Torneo` (`TO_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `bdPolla`.`US_USUARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdPolla`.`US_USUARIO` (
  `US_Nombre` VARCHAR(50) NOT NULL,
  `US_Email` VARCHAR(100) NOT NULL,
  `US_Password` VARCHAR(32) NOT NULL,
  `US_Tipo` ENUM('Admo','Jug') NOT NULL,
  PRIMARY KEY (`US_Nombre`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdPolla`.`PR_PRONOSTICO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdPolla`.`PR_PRONOSTICO` (
  `PR_US_Nombre` VARCHAR(50) NOT NULL,
  `PR_PA_EQ_IdVisitante` INT NOT NULL,
  `PR_PA_EQ_IdLocal` INT NOT NULL,
  `PR_PA_Fecha` DATE NOT NULL,
  `PR_NroGolVis` INT NOT NULL,
  `PR_NroGolLoc` INT NOT NULL,
  `PR_FechaHoraPro` TIMESTAMP NOT
NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`PR_US_Nombre`, `PR_PA_EQ_IdVisitante`, `PR_PA_EQ_IdLocal`, `PR_PA_Fecha`),
  INDEX `fk_PR_PRONOSTICO_US_USUARIO1_idx` (`PR_US_Nombre` ASC),
  INDEX `fk_PR_PRONOSTICO_PA_Partido1_idx` (`PR_PA_EQ_IdVisitante` ASC, `PR_PA_EQ_IdLocal` ASC, `PR_PA_Fecha` ASC),
  CONSTRAINT `fk_PR_PRONOSTICO_US_USUARIO1`
    FOREIGN KEY (`PR_US_Nombre`)
    REFERENCES `bdPolla`.`US_USUARIO` (`US_Nombre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PR_PRONOSTICO_PA_Partido1`
    FOREIGN KEY (`PR_PA_EQ_IdVisitante` , `PR_PA_EQ_IdLocal` , `PR_PA_Fecha`)
    REFERENCES `bdPolla`.`PA_Partido` (`PA_EQ_IdVisitante` , `PA_EQ_IdLocal` , `PA_Fecha`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdPolla`.`PM_PuntosMes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdPolla`.`PM_PuntosMes` (
  `US_Nombre` VARCHAR(50) NOT NULL,
  `US_MES` INT(2) NOT NULL,
  `US_AnnO` INT(4) NOT NULL,
  `US_ptos` INT NOT NULL,
  PRIMARY KEY (`US_Nombre`, `US_MES`, `US_AnnO`),
  CONSTRAINT `fk_PM_PuntosMes_US_USUARIO1`
    FOREIGN KEY (`US_Nombre`)
    REFERENCES `bdPolla`.`US_USUARIO` (`US_Nombre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

