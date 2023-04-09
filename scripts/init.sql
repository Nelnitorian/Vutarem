DROP TABLE IF EXISTS votantes;
CREATE TABLE votantes (dni VARCHAR(9) PRIMARY KEY, nombre VARCHAR(50) NOT NULL, ha_votado BOOLEAN NOT NULL);

INSERT INTO votantes (dni, nombre, ha_votado) VALUES ('12345678A', 'Juan Pérez', true);
INSERT INTO votantes (dni, nombre, ha_votado) VALUES ('87654321B', 'María Gómez', false);
INSERT INTO votantes (dni, nombre, ha_votado) VALUES ('11111111C', 'Pedro García', true);
INSERT INTO votantes (dni, nombre, ha_votado) VALUES ('22222222D', 'Ana Martínez', false);
INSERT INTO votantes (dni, nombre, ha_votado) VALUES ('33333333E', 'Luisa Sánchez', true);