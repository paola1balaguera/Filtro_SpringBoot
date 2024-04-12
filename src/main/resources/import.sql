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
INSERT INTO tipo_estancia (nombre) VALUES
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
INSERT INTO inmueble (numero_referencia, nombre_propietario, telefono_propietario, superficie, tipo_inmueble, tamano_parcela, urbanizacion, oficina_id, zona_id, venta, alquiler, valor_venta, valor_alquiler) VALUES
(12345, 'Pedro Pérez', '666777888', 100, 1, 0, 'Centro', 1, 1, 1, 0, 10000, NULL),
(54321, 'Ana Martínez', '666555444', 120, 2, 200, 'Eixample', 2, 2, 0, 1, NULL, 10000),
(98765, 'Laura García', '666333222', 80, 3, 0, 'Ciudad de las Artes y las Ciencias', 3, 3, 1, 1, 100, 1000);

-- Poblar la tabla "tipoEstanciaInmueble"
INSERT INTO tipo_estancia_inmueble (cantidad, inmueble_id, tipo_estancia_id) VALUES
(3, 1, 1),
(2, 2, 2),
(4, 3, 3);

-- Poblar la tabla "visitaInmueble"
INSERT INTO visita_inmueble (fecha, hora, realizada, comentario, oficina_id, cliente_id, inmueble_id) VALUES
('2024-04-11', '10:00:00', 1, 'Todo en buen estado', 1, 1, 1),
('2024-04-12', '15:30:00', 0, 'Necesita reformas', 2, 2, 2),
('2024-04-13', '11:45:00', 1, 'Buena ubicación', 3, 3, 3);