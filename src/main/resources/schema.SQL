DROP TABLE if EXISTS Usuari;
CREATE TABLE Usuari
(
  userName VARCHAR (55) PRIMARY KEY,
  password VARCHAR(255),
  punts INT,
  reserves_no_presentades INT
);

