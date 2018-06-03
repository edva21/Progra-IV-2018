-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema empleosdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empleosdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empleosdb` DEFAULT CHARACTER SET utf8 ;
USE `empleosdb`;

-- -----------------------------------------------------
-- Table `empleosdb`.`Empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empleosdb`.`Empresa` ;

CREATE TABLE IF NOT EXISTS `empleosdb`.`Empresa` (
  `EmpresaEmail` VARCHAR(45) NOT NULL,
  `EmpresaNombre` VARCHAR(45) NOT NULL,
  `EmpresaLocalizacion` VARCHAR(100) NOT NULL,
  `EmpresaTelefono` VARCHAR(45) NOT NULL,
  `EmpresaDescripcion` VARCHAR(100) NOT NULL,
  `EmpresaClave` VARCHAR(45) NOT NULL,
  `EmpresaEstadoDeCuenta` VARCHAR(45) NOT NULL DEFAULT 'ESPERA',
  `EmpresaUsername` VARCHAR(45) NULL,
  `EmpresaLongitud` DOUBLE NOT NULL,
  `EmpresaLatitud` DOUBLE NOT NULL,
  PRIMARY KEY (`EmpresaEmail`),
  UNIQUE INDEX `EmpresaUsername_UNIQUE` (`EmpresaUsername` ASC))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `empleosdb`.`Nacionalidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empleosdb`.`Nacionalidad` ;

CREATE TABLE IF NOT EXISTS `empleosdb`.`Nacionalidad` (
  `NacionalidadNombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`NacionalidadNombre`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `empleosdb`.`Oferente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empleosdb`.`Oferente` ;

CREATE TABLE IF NOT EXISTS `empleosdb`.`Oferente` (
  `OferenteEmail` VARCHAR(45) NOT NULL,
  `OferenteCedula` VARCHAR(45) NOT NULL,
  `OferenteNombre` VARCHAR(45) NOT NULL,
  `OferenteApellido` VARCHAR(45) NOT NULL,
  `OferenteTelefono` VARCHAR(45) NOT NULL,
  `OferenteResidencia` VARCHAR(45) NOT NULL,
  `OferenteCurriculum` BLOB,
  `OferenteEstadoDeCuenta` VARCHAR(45) NOT NULL DEFAULT 'ESPERA',
  `OferenteUserName` VARCHAR(45),
  `OferenteClave` VARCHAR(45) NOT NULL,
  `Nacionalidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`OferenteEmail`),
  FOREIGN KEY (`Nacionalidad`)
  REFERENCES `empleosdb`.`Nacionalidad` (`NacionalidadNombre`),
  UNIQUE INDEX `OferenteUserName_UNIQUE` (`OferenteUserName` ASC))
ENGINE = InnoDB;





-- -----------------------------------------------------
-- Table `empleosdb`.`Habilidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empleosdb`.`Habilidad` ;

CREATE TABLE IF NOT EXISTS `empleosdb`.`Habilidad` (
  `HabilidadNombre` VARCHAR(45) NOT NULL,
  `Habilidad_HabilidadNombre` VARCHAR(45) NULL,
  PRIMARY KEY (`HabilidadNombre`),
  INDEX `fk_Habilidad_Habilidad1_idx` (`Habilidad_HabilidadNombre` ASC),
  CONSTRAINT `fk_Habilidad_Habilidad1`
    FOREIGN KEY (`Habilidad_HabilidadNombre`)
    REFERENCES `empleosdb`.`Habilidad` (`HabilidadNombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `empleosdb`.`Administrador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empleosdb`.`Administrador` ;

CREATE TABLE IF NOT EXISTS `empleosdb`.`Administrador` (
  `AdministradorUserName` VARCHAR(45) NOT NULL,
  `AdministradorClave` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`AdministradorUserName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empleosdb`.`Puesto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empleosdb`.`Puesto` ;

CREATE TABLE IF NOT EXISTS `empleosdb`.`Puesto` (
  `idPuesto` INT NOT NULL AUTO_INCREMENT,
  `PuestoNombre` VARCHAR(45) NOT NULL,
  `PuestoDescripcion` VARCHAR(1000) NOT NULL,
  `PuestoSalario` DOUBLE NOT NULL,
  `PuestoActivo` TINYINT(1) NULL DEFAULT 1,
  `Empresa_EmpresaEmail` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPuesto`, `Empresa_EmpresaEmail`),
  INDEX `fk_Puesto_Empresa1_idx` (`Empresa_EmpresaEmail` ASC),
  CONSTRAINT `fk_Puesto_Empresa1`
    FOREIGN KEY (`Empresa_EmpresaEmail`)
    REFERENCES `empleosdb`.`Empresa` (`EmpresaEmail`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empleosdb`.`Oferente_has_Nacionalidad`
-- -----------------------------------------------------
--DROP TABLE IF EXISTS `empleosdb`.`Oferente_has_Nacionalidad` ;

--CREATE TABLE IF NOT EXISTS `empleosdb`.`Oferente_has_Nacionalidad` (
--  `Oferente_OferenteEmail` VARCHAR(45) NOT NULL,
--  `Nacionalidad_NacionalidadNombre` VARCHAR(45) NOT NULL,
--  PRIMARY KEY (`Oferente_OferenteEmail`, `Nacionalidad_NacionalidadNombre`),
--  INDEX `fk_Oferente_has_Nacionalidad_Nacionalidad1_idx` (`Nacionalidad_NacionalidadNombre` ASC),
--  INDEX `fk_Oferente_has_Nacionalidad_Oferente1_idx` (`Oferente_OferenteEmail` ASC),
--  CONSTRAINT `fk_Oferente_has_Nacionalidad_Oferente1`
--    FOREIGN KEY (`Oferente_OferenteEmail`)
--    REFERENCES `empleosdb`.`Oferente` (`OferenteEmail`)
--    ON DELETE NO ACTION
--    ON UPDATE NO ACTION,
--  CONSTRAINT `fk_Oferente_has_Nacionalidad_Nacionalidad1`
--    FOREIGN KEY (`Nacionalidad_NacionalidadNombre`)
--    REFERENCES `empleosdb`.`Nacionalidad` (`NacionalidadNombre`)
--    ON DELETE NO ACTION
--    ON UPDATE NO ACTION)
--ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empleosdb`.`Puesto_Habilidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empleosdb`.`Puesto_Habilidad` ;

CREATE TABLE IF NOT EXISTS `empleosdb`.`Puesto_Habilidad` (
  `Puesto_idPuesto` INT NOT NULL,
  `Puesto_Empresa_EmpresaEmail` VARCHAR(45) NOT NULL,
  `Habilidad_HabilidadNombre` VARCHAR(45) NOT NULL,
  `Puesto_HabilidadPorcentaje` INT NOT NULL,
  PRIMARY KEY (`Puesto_idPuesto`, `Puesto_Empresa_EmpresaEmail`, `Habilidad_HabilidadNombre`),
  INDEX `fk_Puesto_has_Habilidad_Habilidad1_idx` (`Habilidad_HabilidadNombre` ASC),
  INDEX `fk_Puesto_has_Habilidad_Puesto1_idx` (`Puesto_idPuesto` ASC, `Puesto_Empresa_EmpresaEmail` ASC),
  CONSTRAINT `fk_Puesto_has_Habilidad_Puesto1`
    FOREIGN KEY (`Puesto_idPuesto` , `Puesto_Empresa_EmpresaEmail`)
    REFERENCES `empleosdb`.`Puesto` (`idPuesto` , `Empresa_EmpresaEmail`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Puesto_has_Habilidad_Habilidad1`
    FOREIGN KEY (`Habilidad_HabilidadNombre`)
    REFERENCES `empleosdb`.`Habilidad` (`HabilidadNombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empleosdb`.`Oferente_has_Habilidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empleosdb`.`Oferente_has_Habilidad` ;

CREATE TABLE IF NOT EXISTS `empleosdb`.`Oferente_has_Habilidad` (
  `Oferente_OferenteEmail` VARCHAR(45) NOT NULL,
  `Habilidad_HabilidadNombre` VARCHAR(45) NOT NULL,
  `Puesto_HabilidadPorcentaje` INT NOT NULL,
  PRIMARY KEY (`Oferente_OferenteEmail`, `Habilidad_HabilidadNombre`),
  INDEX `fk_Oferente_has_Habilidad_Habilidad1_idx` (`Habilidad_HabilidadNombre` ASC),
  INDEX `fk_Oferente_has_Habilidad_Oferente1_idx` (`Oferente_OferenteEmail` ASC),
  CONSTRAINT `fk_Oferente_has_Habilidad_Oferente1`
    FOREIGN KEY (`Oferente_OferenteEmail`)
    REFERENCES `empleosdb`.`Oferente` (`OferenteEmail`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Oferente_has_Habilidad_Habilidad1`
    FOREIGN KEY (`Habilidad_HabilidadNombre`)
    REFERENCES `empleosdb`.`Habilidad` (`HabilidadNombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


--SET SQL_MODE=@OLD_SQL_MODE;
--SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
--SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;





--INSERTS NACIONALIDADES
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Afgana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Alemana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Árabe');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Argentina');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Australiana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Austriaco');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Belga');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Boliviana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Brasilera');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Camboyana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Canadience');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Chilena');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('China');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Colombina');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Coreana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Costarricence');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Cubana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Danesa');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Dominicana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Ecuatorina');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Egipcia');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Española');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Estadounidence');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Estonia');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Etiope');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Filipina');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Finlandesa');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Francesa');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Galesa');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Griega');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Guatemalteca');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Haitiana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Holandesa');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Hondureña');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Indonesa');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Inglesa');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Irlandesa');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Israelí');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Italiana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Japonesa');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Jordana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Laosiana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Letonesa');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Malaya');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Marroquí');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Mexicana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Neocelandesa');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Nicaraguence');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Noruega');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Panameña');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Paraguaya');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Peruana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Polaca');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Portuguesa');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Puertorriqueño');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Rumana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Rusa');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Salvadoreña');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Sueca');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Suiza');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Tailandesa');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Taiwanesa');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Turca');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Ucraniana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Uruguaya');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Venezolana');
INSERT INTO empleosdb.Nacionalidad (`NacionalidadNombre`)
	VALUES ('Vietnamita');

alter table `empleosdb`.`Habilidad`  add column `HabilidadEsHoja` bool;
alter table `empleosdb`.`Puesto`  add column `PuestoFecha` date;
