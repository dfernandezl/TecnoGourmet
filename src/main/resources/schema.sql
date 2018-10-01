DROP TABLE if EXISTS classroom;
CREATE TABLE classroom
(
  name VARCHAR (55) PRIMARY KEY,
  capacity INT,
  orientation VARCHAR (255),
  plugs BIT
);
