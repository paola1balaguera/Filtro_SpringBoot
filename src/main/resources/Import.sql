-- Poblar la tabla "caracteristicas"
INSERT INTO caracteristicas (nombre) VALUES
('Jardín'),
('Piscina'),
('Garaje'),
('Terraza'),
('Cocina equipada');

-- Poblar la tabla "ciudad"
INSERT INTO ciudad (nombre) VALUES
('Madrid'),
('Barcelona'),
('Valencia'),
('Sevilla'),
('Bilbao');

-- Poblar la tabla "oficina"
INSERT INTO oficina (direccion) VALUES
('Calle Principal, 123'),
('Avenida Central, 456'),
('Plaza Mayor, 789');

-- Poblar la tabla "tipoEstancia"
INSERT INTO tipoEstancia (nombre) VALUES
('Dormitorio'),
('Baño'),
('Cocina'),
('Sala de estar'),
('Comedor');

-- Poblar la tabla "zona"
INSERT INTO zona (nombre, ciudad_id) VALUES
('Centro', 1),
('Eixample', 2),
('Ciudad de las Artes y las Ciencias', 3),
('Triana', 4),
('Casco Viejo', 5);

-- Poblar la tabla "cliente"
INSERT INTO cliente (nombre, apellido, telefono, cedula, email) VALUES
('Juan', 'García', 123456789, 123456789, 'juan@example.com'),
('María', 'López', 987654321, 987654321, 'maria@example.com'),
('Carlos', 'Martínez', 555555555, 555555555, 'carlos@example.com');

-- Poblar la tabla "inmueble"
INSERT INTO inmueble (numeroReferencia, nombrePropietario, telefonoPropietario, superficie, tipoInmueble, tamanoParcela, urbanizacion, oficina_id, zona_id) VALUES
(12345, 'Pedro Pérez', '666777888', 100, 'Piso', 0, 'Centro', 1, 1),
(54321, 'Ana Martínez', '666555444', 120, 'Casa', 200, 'Eixample', 2, 2),
(98765, 'Laura García', '666333222', 80, 'Piso', 0, 'Ciudad de las Artes y las Ciencias', 3, 3);

-- Poblar la tabla "tipoEstanciaInmueble"
INSERT INTO tipoEstanciaInmueble (cantidad, inmueble_id, tipoEstancia_id) VALUES
(3, 1, 1),
(2, 2, 2),
(4, 3, 3);

-- Poblar la tabla "visitaInmueble"
INSERT INTO visitaInmueble (fecha, hora, realizada, comentario, oficina_id, cliente_id, inmueble_id) VALUES
('2024-04-11', '10:00:00', 1, 'Todo en buen estado', 1, 1, 1),
('2024-04-12', '15:30:00', 0, 'Necesita reformas', 2, 2, 2),
('2024-04-13', '11:45:00', 1, 'Buena ubicación', 3, 3, 3);
