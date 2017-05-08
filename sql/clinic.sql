-- MySQL Script generated by MySQL Workbench
-- Fri May  5 18:10:40 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema clinic
-- -----------------------------------------------------

DROP SCHEMA IF EXISTS `clinic`;

-- -----------------------------------------------------
-- Schema clinic
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clinic` DEFAULT CHARACTER SET utf8 ;
USE `clinic` ;

-- -----------------------------------------------------
-- Table `clinic`.`userEntity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinic`.`userEntity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  `name` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinic`.`patientEntity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinic`.`patientEntity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `cardNumber` VARCHAR(45) NULL,
  `numericalCode` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `address` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinic`.`consultationEntity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinic`.`consultationEntity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `startsAtTime` TIME NULL,
  `endsAtTime` TIME NULL,
  `doctorsName` VARCHAR(255) NULL,
  `userId` INT NOT NULL,
  `patientId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_consultation_user1_idx` (`userId` ASC),
  INDEX `fk_consultation_patient1_idx` (`patientId` ASC),
  CONSTRAINT `fk_consultation_user1`
  FOREIGN KEY (`userId`)
  REFERENCES `clinic`.`userEntity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_consultation_patient1`
  FOREIGN KEY (`patientId`)
  REFERENCES `clinic`.`patientEntity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinic`.`doctor_program`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinic`.`doctorProgramEntity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `startsAtProgram` TIME NULL,
  `endsAtProgram` TIME NULL,
  `userId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_doctor_program_user1_idx` (`userId` ASC),
  CONSTRAINT `fk_doctor_program_user1`
  FOREIGN KEY (`userId`)
  REFERENCES `clinic`.`userEntity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



INSERT INTO `clinic`.`userEntity` (`id`, `role`, `name`) VALUES ('1', 'admin', 'admin');
INSERT INTO `clinic`.`userEntity` (`id`, `role`, `name`) VALUES ('2', 'doctor', 'Dorel');
INSERT INTO `clinic`.`userEntity` (`id`, `role`, `name`) VALUES ('3', 'secretary', 'Petunia');
INSERT INTO `clinic`.`userEntity` (`id`, `role`, `name`) VALUES ('4', 'doctor', 'Gigel');
INSERT INTO `clinic`.`userEntity` (`id`, `role`, `name`) VALUES ('5', 'doctor', 'Vrigin Toader');

INSERT INTO `clinic`.`doctorProgramEntity` (`id`, `startsAtProgram`, `endsAtProgram`, `userId`) VALUES ('1', '08:00:00', '16:00:00', '2');
INSERT INTO `clinic`.`doctorProgramEntity` (`id`, `startsAtProgram`, `endsAtProgram`, `userId`) VALUES ('2', '16:00:00', '20:00:00', '4');

INSERT INTO `clinic`.`patientEntity` (`id`, `name`, `cardNumber`, `numericalCode`, `birthday`, `address`) VALUES ('1','Miorel','23456','19200203030', '1994-02-02','Baritiu 26');
INSERT INTO `clinic`.`patientEntity` (`id`, `name`, `cardNumber`, `numericalCode`, `birthday`, `address`) VALUES ('2','Viorica Tir','3457','123454654657', '1997-05-13', 'pe camp');
INSERT INTO `clinic`.`patientEntity` (`id`, `name`, `cardNumber`, `numericalCode`, `birthday`, `address`) VALUES ('3','Aurica Mica','4674','235465655423', '1999-10-07', 'in cort');
INSERT INTO `clinic`.`patientEntity` (`id`, `name`, `cardNumber`, `numericalCode`, `birthday`, `address`) VALUES ('4','George George','23443','87564365475', '1988-02-03', 'Mihai Eminescu 20');
INSERT INTO `clinic`.`patientEntity` (`id`, `name`, `cardNumber`, `numericalCode`, `birthday`, `address`) VALUES ('5','Buletin Petre','56775','6475323546', '1978-11-27', 'unde vrea el');
INSERT INTO `clinic`.`patientEntity` (`id`, `name`, `cardNumber`, `numericalCode`, `birthday`, `address`) VALUES ('6','Trica Buton','34543','234536475', '2000-05-02', 'in dormitor');

INSERT INTO `clinic`.`consultationEntity` (`id`, `startsAtTime`, `endsAtTime`, `doctorsName`, `userId`, `patientId`) VALUES ('1', '08:00:00', '08:30:00', 'Dorel', '3', '1');
INSERT INTO `clinic`.`consultationEntity` (`id`, `startsAtTime`, `endsAtTime`, `doctorsName`, `userId`, `patientId`) VALUES ('2', '13:45:00', '14:30:00', 'Gigel', '3', '4');



















