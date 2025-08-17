USE BD_MAOMAKIS_BT;
-- ============================================
-- ESTADO (ejemplo genérico)
-- ============================================
INSERT INTO estado (descripcion) VALUES
('Activo'),
('Inactivo'),
('Ocupado'),
('Libre'),
('Pendiente');

-- ============================================
-- DEPARTAMENTOS (4 registros)
-- ============================================
INSERT INTO departamento (descripcion) VALUES
('Lima'),
('Cusco'),
('Arequipa'),
('Piura');

-- ============================================
-- PROVINCIAS (2 por departamento → 8 registros)
-- ============================================
INSERT INTO provincia (descripcion, id_departamento) VALUES
('Lima Metropolitana', 1),
('Cañete', 1),
('Cusco Provincia', 2),
('Urubamba', 2),
('Arequipa Provincia', 3),
('Camana', 3),
('Piura Provincia', 4),
('Sullana', 4);

-- ============================================
-- DISTRITOS (4 por provincia → 32 registros)
-- ============================================
INSERT INTO distrito (descripcion, id_provincia) VALUES
-- Lima Metropolitana
('Miraflores', 1),
('San Isidro', 1),
('Surco', 1),
('La Molina', 1),

-- Cañete
('San Vicente', 2),
('Imperial', 2),
('Lunahuaná', 2),
('Asia', 2),

-- Cusco Provincia
('Cusco', 3),
('San Jerónimo', 3),
('Santiago', 3),
('San Sebastián', 3),

-- Urubamba
('Urubamba', 4),
('Ollantaytambo', 4),
('Maras', 4),
('Yucay', 4),

-- Arequipa Provincia
('Arequipa', 5),
('Cayma', 5),
('Cerro Colorado', 5),
('Yanahuara', 5),

-- Camaná
('Camaná', 6),
('Samuel Pastor', 6),
('Mariano Nicolás Valcárcel', 6),
('José María Quimper', 6),

-- Piura Provincia
('Piura', 7),
('Castilla', 7),
('Catacaos', 7),
('Veintiséis de Octubre', 7),

-- Sullana
('Sullana', 8),
('Bellavista', 8),
('Marcavelica', 8),
('Querecotillo', 8);

-- ============================================
-- SUCURSALES (8 registros, distribuidas en distritos distintos)
-- ============================================
INSERT INTO sucursales (codigo, nombre, id_distrito, telefono, pais, id_estado) VALUES
('SUC001', 'Sucursal Miraflores', 1, '014500001', 'Perú', 1),
('SUC002', 'Sucursal San Isidro', 2, '014500002', 'Perú', 1),
('SUC003', 'Sucursal Cusco Centro', 9, '084500003', 'Perú', 1),
('SUC004', 'Sucursal Urubamba', 13, '084500004', 'Perú', 1),
('SUC005', 'Sucursal Arequipa', 17, '054500005', 'Perú', 1),
('SUC006', 'Sucursal Camaná', 21, '054500006', 'Perú', 1),
('SUC007', 'Sucursal Piura', 25, '073500007', 'Perú', 1),
('SUC008', 'Sucursal Sullana', 29, '073500008', 'Perú', 1);

-- ============================================
-- CAJA (1 por sucursal → 8 registros)
-- ============================================
INSERT INTO caja (codigo, id_sucursal, id_estado) VALUES
('CAJ001', 1, 1),
('CAJ002', 2, 1),
('CAJ003', 3, 1),
('CAJ004', 4, 1),
('CAJ005', 5, 1),
('CAJ006', 6, 1),
('CAJ007', 7, 1),
('CAJ008', 8, 1);

-- ============================================
-- CARGO_EMPLEADO (6 registros)
-- ============================================
INSERT INTO cargo_empleado (descripcion) VALUES
('Administrador'),
('Supervisor'),
('Cajero'),
('Mesero'),
('Cocinero'),
('Repartidor'),


-- ============================================
-- CLIENTES (6 registros)
-- ============================================
INSERT INTO cliente (codigo, nombre, apellido, telefono, estado) VALUES
('CLI001', 'Juan', 'Pérez', '999111111', 1),
('CLI002', 'María', 'López', '999222222', 1),
('CLI003', 'Carlos', 'Ramírez', '999333333', 1),
('CLI004', 'Lucía', 'Gómez', '999444444', 1),
('CLI005', 'Pedro', 'Fernández', '999555555', 1),
('CLI006', 'Ana', 'Torres', '999666666', 1);

-- ============================================
-- ROLES
-- ============================================
INSERT INTO rol (descripcion) VALUES
('Administrador'),
('Supervisor'),
('Cajero'),
('Mesero');


-- ============================================
-- CATEGORÍAS (6 registros)
-- ============================================
INSERT INTO categoria (descripcion, estado) VALUES
('Entradas', 1),
('Maki Clásico', 1),
('Maki Especial', 1),
('Platos Calientes', 1),
('Postres', 1),
('Bebidas', 1);

-- ============================================
-- MENÚ (8 registros)
-- Campos obligatorios según esquema
-- ============================================
INSERT INTO menu
(codigo, nombre, descripcion, id_categoria, precio, tiempo_preparacion, ruta_imagen, nombre_imagen, estado)
VALUES
-- Entradas
('PLT001', 'Gyozas', 'Empanadillas de cerdo al vapor y plancha', 1, 15.90, 12, '/img/menu', 'gyozas.jpg', 1),
('PLT002', 'Wantán Frito', 'Relleno de pollo con salsa agridulce', 1, 12.50, 10, '/img/menu', 'wantan.jpg', 1),

-- Maki Clásico
('PLT003', 'California Roll 8p', 'Palta, pepino y kanikama', 2, 22.00, 15, '/img/menu', 'california.jpg', 1),
('PLT004', 'Acevichado 8p', 'Topping de salsa acevichada', 2, 26.00, 18, '/img/menu', 'acevichado.jpg', 1),

-- Maki Especial
('PLT005', 'Maomakis Especial 10p', 'Mix de pesca del día y crocante', 3, 34.90, 20, '/img/menu', 'maoesp.jpg', 1),
('PLT006', 'Dragón Roll 10p', 'Langostino furai y palta flameada', 3, 32.00, 20, '/img/menu', 'dragon.jpg', 1),

-- Bebidas / Postres
('PLT007', 'Chicha Morada 500ml', 'Bebida tradicional', 6, 6.50, 2, '/img/menu', 'chicha.jpg', 1),
('PLT008', 'Mazamorra Morada', 'Postre clásico peruano', 5, 7.50, 5, '/img/menu', 'mazamorra.jpg', 1);

-- ============================================
-- MESAS (12 registros distribuidos en 3 sucursales, 4 mesas cada una)
-- ============================================
INSERT INTO mesa (id_sucursal, numero_mesa, capacidad, id_estado) VALUES
(1, 1, 4, 1),
(1, 2, 2, 1),
(1, 3, 6, 1),
(1, 4, 4, 1),

(2, 1, 2, 1),
(2, 2, 4, 1),
(2, 3, 6, 1),
(2, 4, 8, 1),

(3, 1, 2, 1),
(3, 2, 4, 1),
(3, 3, 6, 1),
(3, 4, 4, 1);


-- ============================================
-- DIRECCIONES DE CLIENTES (6 registros)
-- ============================================
INSERT INTO direccion_pedido (id_cliente, id_distrito, direccion_detallada, referencia, etiqueta) VALUES
(1, 1, 'Av. Los Olivos 123', 'Frente al parque principal', 'Casa'),
(2, 2, 'Jr. San Martín 456', 'Cerca a la iglesia', 'Trabajo'),
(3, 3, 'Calle Primavera 789', 'Tercer piso', 'Casa'),
(4, 4, 'Av. Universitaria 101', 'A media cuadra del banco', 'Casa'),
(5, 5, 'Pasaje Los Pinos 202', 'Al costado del colegio', 'Casa'),
(6, 6, 'Jr. Grau 303', 'Edificio rojo', 'Trabajo');

-- ============================================
-- TIPOS DE PEDIDO (3 registros)
-- ============================================
INSERT INTO tipo_pedido (descripcion) VALUES
('En mesa'),
('Para llevar'),
('Delivery');

-- ============================================
-- TIPOS DE COMPROBANTE (3 registros)
-- ============================================
INSERT INTO tipo_comprobante (descripcion) VALUES
('Boleta'),
('Factura'),
('Ticket');

-- ============================================
-- MÉTODOS DE PAGO (3 registros)
-- ============================================
INSERT INTO metodo_pago (descripcion) VALUES
('Efectivo'),
('Tarjeta Crédito'),
('Yape/Plin');