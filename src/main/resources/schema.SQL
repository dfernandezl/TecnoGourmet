DROP TABLE if EXISTS Usuari;
CREATE TABLE Usuari
(
  userName VARCHAR (55) PRIMARY KEY,
  password VARCHAR(255),
  punts INT,
  reserves_no_presentades INT
);

DROP TABLE if EXISTS Reserva;
CREATE TABLE Reserva(
  id_reserva INT PRIMARY KEY,
  userName VARCHAR(55),
  data_reserva VARCHAR(255),
  comensals INT,
  presentat INT,
  FOREIGN KEY (userName) REFERENCES Usuari(userName)
);

