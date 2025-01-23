CREATE TABLE pessoa(
	id		     SERIAL         PRIMARY KEY,
	nome         VARCHAR(150)   NOT NULL,
	email        VARCHAR(100)   NOT NULL,
	criado_em   TIMESTAMP      DEFAULT CURRENT_TIMESTAMP
	
);