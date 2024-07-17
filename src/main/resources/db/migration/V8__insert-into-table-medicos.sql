-- Archivo: V8__insert-into-table-medicos.sql

-- Eliminar todos los registros existentes en la tabla medicos
DELETE FROM `vollmed_api`.`medicos`;

-- Insertar nuevos registros en la tabla medicos
INSERT INTO `vollmed_api`.`medicos`
    (`id`, `nombre`, `email`, `documento`, `especialidad`, `calle`, `distrito`, `complemento`, `numero`, `ciudad`, `telefono`, `activo`)
VALUES
    ('1', 'antonio', 'aa@mail.com', '121212', 'ORTOPEDIA', 'b', 'b', 'b', 'b', 'b', 'b', '1'),
    ('2', 'bernardo', 'bb@mail.com', '212121', 'ORTOPEDIA', 'b', 'b', 'b', 'b', 'b', 'b', '1'),
    ('3', 'carlos', 'cc@mail.com', '232323', 'CARDIOLOGIA', 'b', 'b', 'b', 'b', 'b', 'b', '0'),
    ('4', 'diego', 'dd@mail.com', '323232', 'CARDIOLOGIA', 'b', 'b', 'b', 'b', 'b', 'b', '1'),
    ('5', 'eduardo', 'ee@mail.com', '343434', 'GINECOLOGIA', 'b', 'b', 'b', 'b', 'b', 'b', '1'),
    ('6', 'fernando', 'ff@mail.com', '434343', 'PEDIATRIA', 'b', 'b', 'b', 'b', 'b', 'b', '1');
