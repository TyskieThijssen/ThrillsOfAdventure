USE ThrillsOfAdventure;

INSERT INTO Account VALUES ('Tyskie', 'password');

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