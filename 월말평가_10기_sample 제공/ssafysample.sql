CREATE DATABASE  IF NOT EXISTS `ssafysample`;
USE `ssafysample`;

  -- -----------------------------------------------------
-- Table `ssafysample`.`members`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ssafysample`.`members` ;

CREATE TABLE IF NOT EXISTS `ssafysample`.`members` (
  `id` VARCHAR(16) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `password` VARCHAR(16) NOT NULL,
  `join_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

insert into `ssafysample`.`members` (id, name, password, join_date)
values 	('ssafy', '김싸피', '1234', now()), 
		('admin', '관리자', '1234', now());

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product`(
  `code` varchar(20) primary key,
  `model` varchar(20) NOT NULL,
  `price` int NOT NULL,
`id` VARCHAR(16) NOT NULL,
  constraint fk_user_product foreign key(id) references members(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `product` WRITE;
INSERT INTO `product` VALUES ('1234','2021',1234,'ssafy'),('16ZD95P-GX50K','2022 그램16',1475900,'admin'),('NT550XDZ-AD5A','노트북 플러스2',729000,'admin');
UNLOCK TABLES;



