DROP TABLE Agency_Queue_Tbl;
DROP TABLE Agency_Tbl;
DROP TABLE Queue_Tbl;
DROP TABLE User_Tbl;

CREATE TABLE Agency_Tbl (
	Agency_ID INT, 
	Agency NVARCHAR(255)
	CONSTRAINT PK_Agency_Tbl PRIMARY KEY NONCLUSTERED (Agency_Id)
)
GO

CREATE TABLE Queue_Tbl (
	Queue_ID INT,
	Queue_Name NVARCHAR(255)
	CONSTRAINT PK_Queue_Tbl PRIMARY KEY NONCLUSTERED (Queue_ID),
	CONSTRAINT UK_Queue_Tbl_1 UNIQUE (Queue_Name),
);

CREATE TABLE Agency_Queue_Tbl (
	Agency_ID INT, 
	Queue_ID INT
	CONSTRAINT PK_Agency_Queue_Tbl PRIMARY KEY (Agency_ID, Queue_ID),
	CONSTRAINT FK_Agency_Queue_Tbl_Agency_Tbl FOREIGN KEY (Agency_ID) 
    REFERENCES Agency_Tbl (Agency_ID),
	CONSTRAINT FK_Agency_Queue_Tbl_Queue_Tbl FOREIGN KEY (Queue_ID) 
    REFERENCES Queue_Tbl (Queue_ID)
)
GO

CREATE TABLE User_Tbl (
	Username NVARCHAR(50),
	Agency_ID INT
	CONSTRAINT PK_User_Tbl PRIMARY KEY (Username),
	CONSTRAINT FK_User_Tbl_Agency_Tbl FOREIGN KEY (Agency_ID) 
    REFERENCES Agency_Tbl (Agency_ID)
);

--CREATE INDEX I_Case_Tbl_Responsible_1 ON Case_Tbl (Status, Opened)
--GO

--CREATE INDEX I_Case_Tbl_Responsible_2 ON Case_Tbl (Request_Type)
--GO

--ALTER TABLE Case_Tbl ADD Queue_ID INT
--GO 

--ALTER TABLE Case_Tbl ADD CONSTRAINT FK_Case_Tbl_Queue_Tbl FOREIGN KEY (Queue_ID) 
--    REFERENCES Queue_Tbl (Queue_ID)
--GO

--ALTER TABLE Case_Tbl DROP COLUMN Responsible_Agency
--GO