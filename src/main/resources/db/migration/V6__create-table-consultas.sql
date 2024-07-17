-- Archivo: V6__create-table-consultas.sql

-- Crear la tabla consultas
CREATE TABLE consultas (
    id BIGINT NOT NULL AUTO_INCREMENT,               -- Identificador único para cada consulta
    medico_id BIGINT NOT NULL,                       -- Identificador del médico asociado a la consulta
    paciente_id BIGINT NOT NULL,                     -- Identificador del paciente asociado a la consulta
    fecha DATETIME NOT NULL,                         -- Fecha y hora de la consulta
    motivo_cancelacion VARCHAR(100),                 -- Motivo de cancelación de la consulta (opcional)
    PRIMARY KEY (id),                                -- Definir la columna id como la clave primaria
    CONSTRAINT fk_consultas_medico_id FOREIGN KEY (medico_id) REFERENCES medicos(id),  -- Clave foránea a la tabla medicos
    CONSTRAINT fk_consultas_paciente_id FOREIGN KEY (paciente_id) REFERENCES pacientes(id)  -- Clave foránea a la tabla pacientes
);
