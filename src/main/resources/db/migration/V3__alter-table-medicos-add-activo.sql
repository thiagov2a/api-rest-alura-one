-- V3__alter-table-medicos-add-activo.sql

-- Añadir la columna 'activo' de tipo TINYINT con un valor por defecto de 1
ALTER TABLE medicos
ADD COLUMN activo TINYINT(1) DEFAULT 1;

-- (Opcional) Actualizar todos los registros existentes para asegurarte de que el valor de 'activo' sea 1
UPDATE medicos
SET activo = 1;
