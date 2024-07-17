-- Archivo: V9__insert-into-table-pacientes-test.sql

-- Eliminar todos los registros existentes en la tabla pacientes en la base de datos de prueba
DELETE FROM `vollmed_api_test`.`pacientes`;

-- Insertar nuevos registros en la tabla pacientes en la base de datos de prueba
INSERT INTO `vollmed_api_test`.`pacientes`
    (`id`, `nombre`, `email`, `documento`, `calle`, `distrito`, `complemento`, `numero`, `ciudad`, `telefono`, `activo`)
VALUES
    ('1', 'amanda', 'xxx@mail.com', '1111111', 'ran', 'ran', '900', '900', 'ran', '12334567', '1');
