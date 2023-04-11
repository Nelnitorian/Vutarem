DROP TABLE IF EXISTS votantes;
CREATE TABLE votantes (dni VARCHAR(9) PRIMARY KEY, nombre VARCHAR(50) NOT NULL, ha_votado BOOLEAN NOT NULL, contrasenia VARCHAR(20) NOT NULL);

INSERT INTO votantes (dni, nombre, ha_votado, contrasenia) VALUES 
    ('12345678A', 'Juan Pérez', true, 'juanpi14'),
    ('87654321B', 'María Gómez', false, 'magodefuego291'),
    ('11111111C', 'Pedro García', true, '11st1ke11'),
    ('22222222D', 'Ana Martínez', false, 'bluewisdomb4g'),
    ('33333333E', 'Luisa Sánchez', true, 'luismi142');

DROP TABLE IF EXISTS candidatos;
CREATE TABLE candidatos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    partido VARCHAR(50) NOT NULL,
    votos INT NOT NULL
);

INSERT INTO candidatos (nombre, partido, votos) VALUES
    ('Antonio García', 'Pablemos', 0),
    ('María Rodríguez', 'Pablemos', 0),
    ('Juan González', 'Pablemos', 0),
    ('Carmen López', 'Gaviota', 0),
    ('Francisco Pérez', 'Gaviota', 0),
    ('Ana Sánchez', 'Gaviota', 0),
    ('José Martínez', 'Imparapla', 0),
    ('Isabel Gómez', 'Imparapla', 0),
    ('Manuel Fernández', 'Talante', 0);