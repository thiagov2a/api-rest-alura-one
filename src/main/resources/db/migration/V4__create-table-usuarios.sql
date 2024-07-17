-- Archivo: V4__create-table-usuario.sql

-- Crear la tabla usuario
CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,  -- Identificador único para cada usuario
    login VARCHAR(255) NOT NULL,        -- Login del usuario
    password VARCHAR(255) NOT NULL,     -- Contraseña del usuario
    PRIMARY KEY(id)                     -- Definir la columna id como la clave primaria
);