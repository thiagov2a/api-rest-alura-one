-- Archivo: V2__alter-table-medicos-add-telefono.sql

-- Agregar la columna 'telefono' a la tabla 'medicos'
ALTER TABLE medicos
ADD COLUMN telefono VARCHAR(20) NULL;

-- Comentarios adicionales:
-- La columna 'telefono' se ha añadido para almacenar el número de teléfono del médico.
-- La columna permite valores NULL en caso de que no se proporcione un número de teléfono.
