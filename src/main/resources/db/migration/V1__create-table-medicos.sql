-- Archivo: V1__create-table-medicos.sql

-- Crear la tabla medicos
CREATE TABLE medicos (
    id BIGINT NOT NULL AUTO_INCREMENT,      -- Identificador único para cada médico
    nombre VARCHAR(255) NOT NULL,           -- Nombre del médico
    email VARCHAR(255) UNIQUE NOT NULL,     -- Correo electrónico del médico
    documento VARCHAR(20) UNIQUE NOT NULL,  -- Documento de identificación del médico
    especialidad VARCHAR(50) NOT NULL,      -- Especialidad del médico (debe ser uno de los valores del enum)
    calle VARCHAR(255) NOT NULL,            -- Calle de la dirección
    distrito VARCHAR(255) NOT NULL,         -- Distrito de la dirección
    ciudad VARCHAR(255) NOT NULL,           -- Ciudad de la dirección
    numero VARCHAR(20) NOT NULL,            -- Número de la dirección
    complemento VARCHAR(255),               -- Complemento de la dirección (opcional)
    PRIMARY KEY(id)                         -- Definir la columna id como la clave primaria
);

-- Comentarios adicionales:
-- Asegúrate de que los valores para la columna especialidad correspondan a los valores válidos en tu aplicación.
