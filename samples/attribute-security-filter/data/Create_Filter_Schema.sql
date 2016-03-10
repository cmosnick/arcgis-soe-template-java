DROP TABLE Filter_User_Group
GO

DROP TABLE Filter_Group_Agency
GO

DROP TABLE Filter_User
GO

DROP TABLE Filter_Group
GO

DROP TABLE Agency
GO

CREATE TABLE Filter_Group (
	Group_ID INT,
	Group_Name NVARCHAR(50) NOT NULL
	CONSTRAINT PK_Filter_Group PRIMARY KEY NONCLUSTERED (Group_ID),
	CONSTRAINT UK_Filter_Group_1 UNIQUE (Group_Name),
)
GO

CREATE TABLE Filter_User (
	User_ID INT,
	User_Name NVARCHAR(50) NOT NULL
	CONSTRAINT PK_Filter_User PRIMARY KEY (User_ID),
	CONSTRAINT UK_Filter_User_1 UNIQUE (User_Name)
	
)
GO

CREATE TABLE Filter_User_Group (
	User_ID INT,
	Group_ID INT
	CONSTRAINT PK_Filter_User_Group PRIMARY KEY (User_ID, Group_ID),
	CONSTRAINT FK_Filter_User_Group_Filter_User FOREIGN KEY (User_ID) 
	REFERENCES Filter_User (User_ID),
	CONSTRAINT FK_Filter_User_Group_Filter_Group FOREIGN KEY (Group_ID) 
    REFERENCES Filter_Group (Group_ID)
)
GO

CREATE TABLE Agency (
	Agency_ID INT,
	Agency_Name NVARCHAR(50) NOT NULL
	CONSTRAINT PK_Request_Type PRIMARY KEY (Agency_ID),
	CONSTRAINT UK_Request_Type_1 UNIQUE (Agency_Name)
)
GO

CREATE TABLE Filter_Group_Agency (
	Group_ID INT,
	Agency_ID INT,
	CONSTRAINT PK_Filter_Group_Agency PRIMARY KEY (Group_ID, Agency_ID),
	CONSTRAINT FK_Filter_Group_Agency_Filter_Group FOREIGN KEY (Group_ID) 
    REFERENCES Filter_Group (Group_ID),
	CONSTRAINT FK_Filter_Group_Agency_Agency FOREIGN KEY (Agency_ID) 
	REFERENCES Agency (Agency_ID)
)
GO

ALTER TABlE Incident ADD Responsible_Agency_ID INT
	CONSTRAINT FK_Incident_Agency FOREIGN KEY (Responsible_Agency_ID)
	REFERENCES Agency (Agency_ID)
GO

-- Run this after Insert_Data.sql
--ALTER TABLE Incident DROP COLUMN Responsible_Agency
--GO
