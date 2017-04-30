DROP DATABASE ThrillsOfAdventure;

CREATE DATABASE ThrillsOfAdventure;

USE ThrillsOfAdventure;

CREATE TABLE Account(
	username	VARCHAR(50)		NOT NULL,
    password	VARCHAR(50)		NOT NULL,
    PRIMARY KEY PK_Account (username, password)
);

CREATE TABLE Levels(
	level		INT		NOT NULL,
    experience	INT 	NOT NULL,
    PRIMARY KEY PK_Levels (level)
);

CREATE TABLE Characters(
	characterName	VARCHAR(50)		NOT NULL,
    characterLevel	INT				NOT NULL,
    totalExperience	INT				NOT NULL,
    PRIMARY KEY PK_Character (characterName),
    FOREIGN KEY FK_Characters_Levels (characterLevel) REFERENCES Levels(level)
);

CREATE TABLE CharacterOfAccount(
	username		VARCHAR(50)		NOT NULL,
    characterName	VARCHAR(50)		NOT NULL,
	PRIMARY KEY PK_CharacterOfAccount (username, characterName),
    FOREIGN KEY FK_CharacterOfAccount_Account (username) REFERENCES Account(username),
    FOREIGN KEY FK_CharacterOfAccount_Character (characterName) REFERENCES Characters(characterName)
);

CREATE TABLE Statistic(
	statName	VARCHAR(50)		NOT NULL,
	PRIMARY KEY PK_Statistic (statName)
);

CREATE TABLE CharacterStatistic(
	characterName	VARCHAR(50)		NOT NULL,
    statName		VARCHAR(50)		NOT NULL,
    statLevel		INT				NOT NULL,
    PRIMARY KEY PK_CharacterStatistic (characterName, statName),
    FOREIGN KEY FK_CharacterStatistic_Character (characterName) REFERENCES Characters(characterName),
    FOREIGN KEY FK_CharacterStatistic_Statistic (statName) REFERENCES Statistic(statName)
);

DELIMITER $$

DROP PROCEDURE IF EXISTS CreateCharacter $$
CREATE PROCEDURE CreateCharacter(
	IN username VARCHAR(50),
	IN characterName	VARCHAR(50)
)
BEGIN
	INSERT INTO Characters VALUES (characterName, 1, 0);
    INSERT INTO CharacterOfAccount VALUES (username, characterName);
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS DeleteCharacter $$
CREATE PROCEDURE DeleteCharacter(
	IN var_username VARCHAR(50),
	IN var_characterName	VARCHAR(50)
)
BEGIN
	DELETE FROM CharacterOfAccount WHERE username = var_username AND characterName = var_characterName;
	DELETE FROM Characters WHERE characterName = var_characterName;
END $$

DELIMITER ;