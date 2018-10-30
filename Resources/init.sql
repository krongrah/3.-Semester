CREATE TABLE Users (
  Username VARCHAR(100) PRIMARY KEY ,
  IsCompany BOOLEAN,
  Email VARCHAR(100),
  Phonenr INTEGER,
  Address VARCHAR(100),
  Zipcode VARCHAR(100),
  Country VARCHAR(100),
  Region VARCHAR(100)
);

CREATE TABLE PQuestionSet (
  qid INTEGER,
  question TEXT,
  category INTEGER,
  direction CHAR(1)
);