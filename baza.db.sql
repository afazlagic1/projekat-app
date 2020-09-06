BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "child" (
	"id"	INTEGER,
	"name"	TEXT,
	"surname"	TEXT,
	"parent1"	INTEGER,
	"yo"	INTEGER,
	"classroom"	INTEGER,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "classroom" (
	"id"	INTEGER,
	"children"	TEXT,
	"teacher"	INTEGER,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "admin" (
	"id"	INTEGER,
	"name"	TEXT,
	"surname"	TEXT,
	"username"	TEXT,
	"password"	TEXT,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "parent" (
	"id"	INTEGER,
	"name"	TEXT,
	"surname"	TEXT,
	"username"	TEXT,
	"password"	TEXT,
	"status"	TEXT,
	"phoneNumber"	INTEGER,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "teacher" (
	"id"	INTEGER,
	"name"	TEXT,
	"surname"	TEXT,
	"phoneNumber"	INTEGER,
	PRIMARY KEY("id")
);
INSERT INTO "child" VALUES (1,'Patrick','West',3,3,1);
INSERT INTO "child" VALUES (2,'Mary','Nielsen',1,5,1);
INSERT INTO "child" VALUES (3,'Sam','Dawson',2,5,1);
INSERT INTO "child" VALUES (4,'Diana','Bailey',4,4,1);
INSERT INTO "classroom" VALUES (1,'1,2,3,4,',1);
INSERT INTO "classroom" VALUES (2, '', 2);
INSERT INTO "admin" VALUES (1,'Anesa','Fazlagić','afazlagic1','123');
INSERT INTO "parent" VALUES (1,'Dominik','Nielsen','dino1921','0000','married',13213);
INSERT INTO "parent" VALUES (2,'Natasha','Dawson','nata15','1111','married',132);
INSERT INTO "parent" VALUES (3,'Anna','West','annaw','2222','divorced',342);
INSERT INTO "parent" VALUES (4,'Theo','Bailey','tb68','3333','married',3123);
INSERT INTO "parent" VALUES (5,'Peter','West','peterw','4444','married',667);
INSERT INTO "teacher" VALUES (1,'Lea','Black',9871);
INSERT INTO "teacher" VALUES (2,'Mark','Wolf',1246);
COMMIT;
