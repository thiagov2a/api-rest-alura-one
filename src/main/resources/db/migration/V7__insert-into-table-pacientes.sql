-- Archivo: V7__insert-into-table-pacientes.sql

-- Eliminar todos los registros existentes en la tabla pacientes
DELETE FROM `vollmed_api`.`pacientes`;

-- Insertar nuevos registros en la tabla pacientes
INSERT INTO `vollmed_api`.`pacientes`
    (`id`, `nombre`, `email`, `documento`, `calle`, `distrito`, `complemento`, `numero`, `ciudad`, `telefono`, `activo`)
VALUES
    ('1', 'amanda', 'a@mail.com', '1111111', 'ran', 'ran', '900', '900', 'ran', '12334567', '1'),
    ('2', 'bruna', 'b@mail.com', '2222222', 'ran', 'ran', '900', '900', 'ran', '12334567', '1'),
    ('3', 'carla', 'c@mail.com', '3333333', 'ran', 'ran', '900', '900', 'ran', '12334567', '1'),
    ('4', 'debora', 'd@mail.com', '4444444', 'ran', 'ran', '900', '900', 'ran', '12334567', '1'),
    ('5', 'esmeralda', 'e@mail.com', '5555555', 'ran', 'ran', '900', '900', 'ran', '12334567', '1'),
    ('6', 'francis', 'f@mail.com', '6666666', 'ran', 'ran', '900', '900', 'ran', '12334567', '1');
