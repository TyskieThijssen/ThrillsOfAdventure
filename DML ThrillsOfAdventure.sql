USE ThrillsOfAdventure;

INSERT INTO Account VALUES 
	('Tyskie', 'password');

INSERT INTO Levels VALUES
	(1, 0),
    (2, 10),
    (3, 100),
    (4, 1000),
    (5, 10000),
    (6, 100000),
    (7, 1000000),
    (8, 10000000),
    (9, 100000000),
    (10,1000000000);

INSERT INTO Characters VALUES 
	('Darude', 1, 0),
    ('Berserker', 2, 20);

INSERT INTO CharacterOfAccount VALUES 
	('Tyskie', 'Darude'),
    ('Tyskie', 'Berserker');

INSERT INTO Statistic VALUES
	('Attack'),
    ('Strength'),
    ('Defence'),
    ('Hitpoints');

INSERT INTO CharacterStatistic VALUES
	('Darude', 'Attack', 10),
    ('Darude', 'Strength', 10),
    ('Darude', 'Defence', 10),
    ('Darude', 'Hitpoints', 10);
    
INSERT INTO MonsterInfo VALUES
	(1, 'Warbear', 'Wind', 'HP', 2),
    (2, 'Ramagos', 'Wind', 'HP', NULL);
    
INSERT INTO MonsterBaseStats VALUES
	(1, 2, 1290, 2460, 54, 103, 74, 142),
    (1, 3, 1965, 3540, 82, 148, 114, 205),
    (1, 4, 2835, 4815, 119, 202, 164, 279),
    (1, 5, 3855, 6540, 162, 274, 223, 379),
    (1, 6, 5235, 8895, 220, 373, 304, 516),
    (2, 2, 1530, 2910, 56, 106, 81, 155),
    (2, 3, 2325, 4185, 85, 153, 124, 223),
    (2, 4, 3345, 5700, 122, 208, 178, 303),
    (2, 5, 4560, 7755, 166, 283, 242, 412),
    (2, 6, 6195, 10545, 226, 384, 329, 560);
    
INSERT INTO MonsterStaticAttributes VALUES
	(1, 101, 15, 50, 15, 0),
    (2, 102, 15, 50, 15, 0);

-- CREATE TABLE MonsterLevelExpNeeded(
-- 	   monsterGrade	    int		NOT NULL,
--     monsterLevel	    int		NOT NULL,
--     expNeeded		int		NOT NULL,
    
INSERT INTO MonsterLevelExpNeeded VALUES
	(1, 1, 0),
    (1, 2, 460),
    (1, 3, 516),
    (1, 4, 579),
    (1, 5, 650),
    (1, 6, 728),
    (1, 7, 818),
    (1, 8, 918),
    (1, 9, 1029),
    (1, 10, 1155),
    (1, 11, 1296),
    (1, 12, 1455),
    (1, 13, 1631),
    (1, 14, 1831),
    (1, 15, 2054),
    (2, 1, 0),
    (2, 2, 552),
    (2, 3, 619),
    (2, 4, 695),
    (2, 5, 779),
    (2, 6, 875),
    (2, 7, 981),
    (2, 8, 1102),
    (2, 9, 1235),
    (2, 10, 1386),
    (2, 11, 1555),
    (2, 12, 1745),
    (2, 13, 1958),
    (2, 14, 2197),
    (2, 15, 2465),
    (2, 16, 2765),
    (2, 17, 3103),
    (2, 18, 3481),
    (2, 19, 3906),
    (2, 20, 4423),
    (3, 1, 0),
    (3, 2, 662),
    (3, 3, 743),
    (3, 4, 834),
    (3, 5, 936),
    (3, 6, 1049),
    (3, 7, 1178),
    (3, 8, 1321),
    (3, 9, 1483),
    (3, 10, 1663),
    (3, 11, 1866),
    (3, 12, 2094),
    (3, 13, 2350),
    (3, 14, 2636),
    (3, 15, 2957),
    (3, 16, 3319),
    (3, 17, 3723),
    (3, 18, 4178),
    (3, 19, 4687),
    (3, 20, 5307),
    (3, 21, 6009),
    (3, 22, 6802),
    (3, 23, 7703),
    (3, 24, 8720),
    (3, 25, 9962);
    
    
    
    
-- CREATE TABLE MonstersOfAccount(
--     username		    VARCHAR(50)	NOT NULL,
--     monsterId		int			NOT NULL,
--     monsterNr		int			auto_increment,
--     monsterGrade	    int			NOT NULL,
--     monsterLevel	    int			NOT NULL,
--     monsterExp		int			NOT NULL,
--     monsterHp		int			NOT NULL,
--     monsterAtk		int			NOT NULL,
--     monsterDef		int			NOT NULL,
--     monsterSpd		int			NOT NULL,
--     monsterCri_rate	int			NOT NULL,
--     monsterCri_dmg	int			NOT NULL,
--     monsterRes		int			NOT NULL,
--     monsterAcc		int			NOT NULL,
