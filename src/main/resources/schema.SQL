DROP TABLE if EXISTS Usuari;
CREATE TABLE Usuari(
  userName VARCHAR (55) PRIMARY KEY,
  password VARCHAR(255),
  punts INT,
  reserves_no_presentades INT
);

DROP TABLE if EXISTS Restaurant;
CREATE TABLE Restaurant(
    nom varchar(255) PRIMARY KEY,
    password varchar (255),
    direccio VARCHAR(255),
    poblacio VARCHAR(255),
    puntuacio DOUBLE,
    descripcio varchar(255),
    telefon INT,
    capacitat INT,
    foto varchar(255),
    nVots INT
);


DROP TABLE if EXISTS Reserva;
CREATE TABLE Reserva(
  id_reserva INT PRIMARY KEY,
  userName VARCHAR(55),
  restaurant VARCHAR(255),
  data_reserva VARCHAR(255),
  comensals INT,
  presentat INT,
  torn INT,
  CONSTRAINT FK_USUARI FOREIGN KEY (userName) REFERENCES Usuari(userName),
  CONSTRAINT FK_RESTAURANT FOREIGN KEY (restaurant) REFERENCES Restaurant(nom)
);
