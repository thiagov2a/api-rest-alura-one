-- Archivo: V5__create-table-pacientes.sql

-- Crear la tabla pacientes
CREATE TABLE pacientes (
    id BIGINT NOT NULL AUTO_INCREMENT,      -- Identificador único para cada paciente
    activo TINYINT(1) NOT NULL,                -- Indicador de si el paciente está activo o no
    nombre VARCHAR(255) NOT NULL,           -- Nombre del paciente
    email VARCHAR(255) UNIQUE NOT NULL,     -- Correo electrónico del paciente
    documento VARCHAR(20) UNIQUE NOT NULL,  -- Documento de identificación del paciente
    telefono VARCHAR(20) NOT NULL,          -- Número de teléfono del paciente
    calle VARCHAR(255) NOT NULL,            -- Calle de la dirección
    distrito VARCHAR(255) NOT NULL,         -- Distrito de la dirección
    ciudad VARCHAR(255) NOT NULL,           -- Ciudad de la dirección
    numero VARCHAR(20) NOT NULL,            -- Número de la dirección
    complemento VARCHAR(255),               -- Complemento de la dirección (opcional)
    PRIMARY KEY(id)                         -- Definir la columna id como la clave primaria
);
