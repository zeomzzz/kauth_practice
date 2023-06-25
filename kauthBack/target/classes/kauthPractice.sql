
CREATE SCHEMA IF NOT EXISTS `kauthPractice` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE kauthPractice;

SET GLOBAL time_zone='+09:00';
SET time_zone='+09:00';

CREATE TABLE IF NOT EXISTS `kauthPractice`.`USER` (
	`nid` int NOT NULL AUTO_INCREMENT,
    `kakaoId` VARCHAR(45) NOT NULL,
    `kakaoNickname` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`nid`)
)

SELECT * FROM USER;

DESC USER;