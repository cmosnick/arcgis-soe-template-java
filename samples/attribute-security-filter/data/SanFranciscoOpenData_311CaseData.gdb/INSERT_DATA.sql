-- Create queue entries first
INSERT INTO Queue_Tbl (Queue_ID, Queue_Name) 
SELECT ROW_NUMBER() OVER (ORDER BY Responsible_Agency), Responsible_Agency FROM Case_Tbl
GROUP BY Responsible_Agency;

-- Insert agencies and queues
INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (1, '311 Customer Service Center');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 1, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE '311%';
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 1, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Knowledge Solutions%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (2, 'Adult Probation');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 2, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Adult Probation%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (3, 'Aging and Adult Services');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 3, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Aging and Adult Services%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (4, 'Airport, San Francisco International');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 4, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Airport, San Francisco International%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (5, 'Animal Care and Control');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 5, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Animal Care and Control%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (6, 'Art Commission');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 6, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Art Commission%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (7, 'Asian Art Museum');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 7, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Asian Art Museum%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (8, 'Assessor');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 8, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Assessor%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (9, 'Board of Appeals (BOA)');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 9, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Board of Appeals (BOA)%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (10, 'Board of Supervisors');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 10, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Board of Supervisors%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (12, 'DPH');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 12, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'DPH%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (13, 'DPT');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 13, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'DPT%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (14, 'DPW');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 14, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'DPW%';
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 14, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Graffiti Abatement%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (16, 'Mayors Office');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 16, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Mayors Office%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (17, 'MUNI');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 17, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'MUNI%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (18, 'Recology');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 18, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Recology%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (19, 'PUC');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 19, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'PUC%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (20, 'Housing Authority');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 20, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Housing Authority%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (21, 'PG and E');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 21, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'PG and E%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (22, 'Clear Channel');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 22, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Clear Channel%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (23, 'Treasurer/Tax Collector');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 23, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Treasurer/Tax Collector%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (24, 'SFMTA');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 24, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'SFMTA%';
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 24, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'TAXI%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (25, 'SSP');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 25, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'SSP%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (26, 'RPD');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 26, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'RPD%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (27, 'DBI');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 27, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'DBI%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (28, 'City Attorney');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 28, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'City Attorney%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (29, 'Police');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 29, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Police%';
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 29, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Noise Report%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (30, 'US Postal Service');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 30, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'US Postal Service%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (31, 'County Clerk');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 31, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'County Clerk%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (32, 'Technology');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 32, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Technology%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (33, 'SFFD');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 33, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'SFFD%';
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 33, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Fire Department%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (34, 'Port Authority');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 34, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Port Authority%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (35, 'Planning');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 35, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Planning%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (36, 'Recreation and Parks');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 36, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'RecPark%';
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 36, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Rec and Park%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (37, 'Entertainment Commission');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 37, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Entertainment Commission%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (38, 'District Attorney');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 38, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'District Attorney%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (39, 'Rent Board');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 39, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Rent Board%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (40, 'Environment');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 40, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'Environment%';

INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (41, 'HSA');
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID) SELECT DISTINCT 41, Queue_ID FROM Case_Tbl c JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name) WHERE Responsible_Agency LIKE'HSA%';

-- Assign all queues, including unassigned ones, to 311 Customer Service Department
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID)
SELECT 1, Queue_ID
FROM Case_Tbl c
	JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name)
WHERE Responsible_Agency NOT IN (SELECT DISTINCT q.Queue_Name FROM Agency_Queue_Tbl aq JOIN Queue_Tbl q ON (q.Queue_ID = aq.Queue_ID) WHERE Agency_ID = 1) 
GROUP BY Queue_ID;

-- Assign all queues to Mayors Office
INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID)
SELECT 16, Queue_ID
FROM Case_Tbl c
	JOIN Queue_Tbl q ON (c.Responsible_Agency = q.Queue_Name)
WHERE Responsible_Agency NOT IN (SELECT DISTINCT q.Queue_Name FROM Agency_Queue_Tbl aq JOIN Queue_Tbl q ON (q.Queue_ID = aq.Queue_ID) WHERE Agency_ID = 16) 
GROUP BY Queue_ID;

-- Grant public access to a limited number of cases
INSERT INTO Agency_Tbl (Agency_ID, Agency) VALUES (
	(SELECT MAX(Agency_ID) + 1 FROM Agency_Tbl), 
	'Public'
);

INSERT INTO Agency_Queue_Tbl (Agency_ID, Queue_ID)
SELECT (SELECT Agency_ID FROM Agency_Tbl WHERE Agency = 'Public'), q.Queue_ID
FROM Agency_Tbl a
	JOIN Agency_Queue_Tbl q ON (a.Agency_ID = q.Agency_ID)
WHERE a.Agency IN ('Animal Care and Control', 'DPT', 'DPW', 'MUNI', 'Recology', 'SFMTA', 'Police', 'SFFD', 'Recreation and Parks')
GROUP BY q.Queue_ID;

-- Make DDL changes to Case_Tbl first
--UPDATE c 
--SET c.Queue_ID = q.Queue_ID 
--FROM Case_Tbl c 
--	JOIN Queue_Tbl q ON (q.Queue_Name = c.Responsible_Agency);
