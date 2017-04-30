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

CREATE TABLE MonsterInfo(
	monsterId			INT					NOT NULL,
    monsterName			varchar(50)			NOT NULL,
    elementalAttribute	varchar(5)			NOT NULL,
    monsterType			varchar(15)			NOT NULL,
    awakenedMonsterId	int					NULL,
    PRIMARY KEY PK_MonsterInfo (monsterId)
);

CREATE TABLE MonsterBaseStats(
	monsterId		int		NOT NULL,
    monsterGrade	int		NOT NULL,
    minHp			int		NOT NULL,
    maxHp			int		NOT NULL,
    minAtk			int		NOT NULL,
    maxAtk			int		NOT NULL,
    minDef			int		NOT NULL,
    maxDef			int		NOT NULL,
    PRIMARY KEY PK_MonsterBaseStats (monsterId, monsterGrade),
    FOREIGN KEY FK_MonsterBaseStats_MonsterInfo (monsterId) REFERENCES MonsterInfo(monsterId)
);

CREATE TABLE MonsterStaticAttributes(
	monsterId	int		NOT NULL,
    spd			int		NOT NULL,
    cri_rate	int		NOT NULL,
    cri_dmg		int		NOT NULL,
    res			int		NOT NULL,
    acc			int		NOT NULL,
    PRIMARY KEY PK_MonsterStaticAttributes (monsterId),
    FOREIGN KEY FK_MonsterStaticAttributes_MonsterInfo (monsterId) REFERENCES MonsterInfo(monsterId)
);

CREATE TABLE MonsterLevelExpNeeded(
	monsterGrade	int		NOT NULL,
    monsterLevel	int		NOT NULL,
    expNeeded		int		NOT NULL,
    PRIMARY KEY PK_MonsterLevelExpNeeded (monsterGrade, monsterLevel, expNeeded)
);

CREATE TABLE MonstersOfAccount(
    username		VARCHAR(50)	NOT NULL,
    monsterId		int			NOT NULL,
    monsterNr		int			auto_increment,
    monsterGrade	int			NOT NULL,
    monsterLevel	int			NOT NULL,
    monsterExp		int			NOT NULL,
    monsterHp		int			NOT NULL,
    monsterAtk		int			NOT NULL,
    monsterDef		int			NOT NULL,
    monsterSpd		int			NOT NULL,
    monsterCri_rate	int			NOT NULL,
    monsterCri_dmg	int			NOT NULL,
    monsterRes		int			NOT NULL,
    monsterAcc		int			NOT NULL,
    PRIMARY KEY PK_MonstersOfAccount (monsterNr, username, monsterId),
    FOREIGN KEY FK_MonstersOfAccount_Account (username) REFERENCES Account(username),
    FOREIGN KEY FK_MonstersOfAccount_MonsterInfo (monsterId) REFERENCES MonsterInfo(monsterId)
);

DELIMITER $$


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


CREATE PROCEDURE DeleteCharacter(
	IN var_username VARCHAR(50),
	IN var_characterName	VARCHAR(50)
)
BEGIN
	DELETE FROM CharacterOfAccount WHERE username = var_username AND characterName = var_characterName;
	DELETE FROM Characters WHERE characterName = var_characterName;
END $$

DELIMITER ;