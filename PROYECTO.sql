CREATE TABLE USUARIO(
ID_USUARIO NUMBER(7) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
NOMBRE VARCHAR2(30) NOT NULL,
EMAIL VARCHAR2(30) UNIQUE,
CONSTRASEŅA VARCHAR(30) NOT NULL
);

CREATE TABLE EVENTO(
ID_EVENTO NUMBER(7) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
NOMBRE VARCHAR2(30) NOT NULL,
AFORO NUMBER(5) NOT NULL,
CANTIDAD NUMBER(5) NOT NULL
);

CREATE TABLE ORGANIZADOR(
ID_ORGANIZADOR NUMBER(7) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
NOMBRE VARCHAR2(30) NOT NULL,
EMAIL VARCHAR2(30) UNIQUE,
TELEFONO NUMBER(13) NOT NULL
);

CREATE TABLE CATEGORIA(
TIPO VARCHAR2(30) PRIMARY KEY,
NOMBRE VARCHAR2(30) NOT NULL
);

CREATE TABLE INSCRIPCION(
ID_USUARIO NUMBER(7),
ID_EVENTO NUMBER(7),
PRIMARY KEY(ID_USUARIO,ID_EVENTO),
CONSTRAINT FK_INS_USU FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO),
CONSTRAINT FK_INS_EVENT FOREIGN KEY (ID_EVENTO) REFERENCES EVENTO(ID_EVENTO)
);

CREATE TABLE ASISTENCIA(
ID_USUARIO NUMBER(7),
ID_EVENTO NUMBER(7),
PRIMARY KEY(ID_USUARIO,ID_EVENTO),
ASISTE VARCHAR2(2) CHECK (ASISTE IN ('SI','NO')) NOT NULL, 
CONSTRAINT FK_ASIS_USU FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO),
CONSTRAINT FK_ASIS_EVENT FOREIGN KEY (ID_EVENTO) REFERENCES EVENTO(ID_EVENTO)
);

CREATE TABLE ORGANIZACION(
ID_EVENTO NUMBER(7),
ID_ORGANIZADOR NUMBER(7),
PRIMARY KEY(ID_EVENTO,ID_ORGANIZADOR),
CONSTRAINT FK_ORGANI FOREIGN KEY (ID_ORGANIZADOR) REFERENCES ORGANIZADOR(ID_ORGANIZADOR),
CONSTRAINT FK_ORGANI_EVENT FOREIGN KEY (ID_EVENTO) REFERENCES EVENTO(ID_EVENTO)
);

CREATE TABLE CAT_EVENTO(
ID_EVENTO NUMBER(7),
TIPO VARCHAR2(30),
PRIMARY KEY(ID_EVENTO,TIPO),
CONSTRAINT FK_TIPO FOREIGN KEY (TIPO) REFERENCES CATEGORIA(TIPO),
CONSTRAINT FK_CAT_EVENT FOREIGN KEY (ID_EVENTO) REFERENCES EVENTO(ID_EVENTO)
);

