USE BD_MAOMAKIS_BT;

-- ============================================
-- EMPLEADOS (96 registros)
-- 3 empleados por cada uno de los 32 distritos
-- ============================================
INSERT INTO empleado (codigo, nombre, apellido, id_distrito, dni, id_cargo, telefono, estado) VALUES
-- Distrito 1
('EMP001', 'Luis', 'García', 1, '20000001', 1, '910000001', 1),
('EMP002', 'Sofía', 'Martínez', 1, '20000002', 2, '910000002', 1),
('EMP003', 'Andrés', 'Rojas', 1, '20000003', 3, '910000003', 1),

-- Distrito 2
('EMP004', 'Diego', 'Ramírez', 2, '20000004', 1, '910000004', 1),
('EMP005', 'Camila', 'Flores', 2, '20000005', 2, '910000005', 1),
('EMP006', 'Martín', 'Reyes', 2, '20000006', 3, '910000006', 1),

-- Distrito 3
('EMP007', 'Jorge', 'Mendoza', 3, '20000007', 1, '910000007', 1),
('EMP008', 'Elena', 'Quispe', 3, '20000008', 2, '910000008', 1),
('EMP009', 'Ricardo', 'Huamán', 3, '20000009', 3, '910000009', 1),

-- Distrito 4
('EMP010', 'Fernando', 'Chávez', 4, '20000010', 1, '910000010', 1),
('EMP011', 'Marta', 'Ayala', 4, '20000011', 2, '910000011', 1),
('EMP012', 'Hugo', 'Santos', 4, '20000012', 3, '910000012', 1),

-- Distrito 5
('EMP013', 'Pablo', 'Salazar', 5, '20000013', 1, '910000013', 1),
('EMP014', 'Carla', 'Mamani', 5, '20000014', 2, '910000014', 1),
('EMP015', 'Iván', 'Cáceres', 5, '20000015', 3, '910000015', 1),

-- Distrito 6
('EMP016', 'Sebastián', 'López', 6, '20000016', 1, '910000016', 1),
('EMP017', 'Natalia', 'Díaz', 6, '20000017', 2, '910000017', 1),
('EMP018', 'Rodrigo', 'Mejía', 6, '20000018', 3, '910000018', 1),

-- Distrito 7
('EMP019', 'Tomás', 'Silva', 7, '20000019', 1, '910000019', 1),
('EMP020', 'Patricia', 'Ramos', 7, '20000020', 2, '910000020', 1),
('EMP021', 'César', 'Guzmán', 7, '20000021', 3, '910000021', 1),

-- Distrito 8
('EMP022', 'Enrique', 'Campos', 8, '20000022', 1, '910000022', 1),
('EMP023', 'Rosa', 'Aguilar', 8, '20000023', 2, '910000023', 1),
('EMP024', 'Óscar', 'Morales', 8, '20000024', 3, '910000024', 1),

-- Distrito 9
('EMP025', 'Isabel', 'Peña', 9, '20000025', 1, '910000025', 1),
('EMP026', 'Cristian', 'Loayza', 9, '20000026', 2, '910000026', 1),
('EMP027', 'Fiorella', 'Zambrano', 9, '20000027', 3, '910000027', 1),

-- Distrito 10
('EMP028', 'Gustavo', 'Caballero', 10, '20000028', 1, '910000028', 1),
('EMP029', 'Milagros', 'Espinoza', 10, '20000029', 2, '910000029', 1),
('EMP030', 'Raúl', 'Valdez', 10, '20000030', 3, '910000030', 1),

-- Distrito 11
('EMP031', 'Claudia', 'Paredes', 11, '20000031', 1, '910000031', 1),
('EMP032', 'David', 'Huerta', 11, '20000032', 2, '910000032', 1),
('EMP033', 'Esteban', 'Rosales', 11, '20000033', 3, '910000033', 1),

-- Distrito 12
('EMP034', 'Silvia', 'Vega', 12, '20000034', 1, '910000034', 1),
('EMP035', 'Andrés', 'Luna', 12, '20000035', 2, '910000035', 1),
('EMP036', 'Beatriz', 'Mora', 12, '20000036', 3, '910000036', 1),

-- Distrito 13
('EMP037', 'Cristina', 'Ortega', 13, '20000037', 1, '910000037', 1),
('EMP038', 'Julián', 'Poma', 13, '20000038', 2, '910000038', 1),
('EMP039', 'Marisol', 'Yáñez', 13, '20000039', 3, '910000039', 1),

-- Distrito 14
('EMP040', 'Alejandro', 'Torres', 14, '20000040', 1, '910000040', 1),
('EMP041', 'Paola', 'Espino', 14, '20000041', 2, '910000041', 1),
('EMP042', 'Vicente', 'Ríos', 14, '20000042', 3, '910000042', 1),

-- Distrito 15
('EMP043', 'Francisco', 'Cruz', 15, '20000043', 1, '910000043', 1),
('EMP044', 'María', 'Ávila', 15, '20000044', 2, '910000044', 1),
('EMP045', 'Julio', 'Linares', 15, '20000045', 3, '910000045', 1),

-- Distrito 16
('EMP046', 'Gabriela', 'Palacios', 16, '20000046', 1, '910000046', 1),
('EMP047', 'Felipe', 'Castillo', 16, '20000047', 2, '910000047', 1),
('EMP048', 'Arturo', 'Bravo', 16, '20000048', 3, '910000048', 1),

-- Distrito 17
('EMP049', 'Verónica', 'Benítez', 17, '20000049', 1, '910000049', 1),
('EMP050', 'Óscar', 'Lagos', 17, '20000050', 2, '910000050', 1),
('EMP051', 'Daniela', 'Prieto', 17, '20000051', 3, '910000051', 1),

-- Distrito 18
('EMP052', 'Clara', 'Montes', 18, '20000052', 1, '910000052', 1),
('EMP053', 'Javier', 'Solís', 18, '20000053', 2, '910000053', 1),
('EMP054', 'Rocío', 'Delgado', 18, '20000054', 3, '910000054', 1),

-- Distrito 19
('EMP055', 'Ignacio', 'Villanueva', 19, '20000055', 1, '910000055', 1),
('EMP056', 'Valeria', 'Cornejo', 19, '20000056', 2, '910000056', 1),
('EMP057', 'Mauricio', 'Ramos', 19, '20000057', 3, '910000057', 1),

-- Distrito 20
('EMP058', 'Álvaro', 'Hernández', 20, '20000058', 1, '910000058', 1),
('EMP059', 'Teresa', 'Carrillo', 20, '20000059', 2, '910000059', 1),
('EMP060', 'Ramiro', 'Medina', 20, '20000060', 3, '910000060', 1),

-- Distrito 21
('EMP061', 'Yesenia', 'Maldonado', 21, '20000061', 1, '910000061', 1),
('EMP062', 'Orlando', 'Campos', 21, '20000062', 2, '910000062', 1),
('EMP063', 'Claudio', 'Serrano', 21, '20000063', 3, '910000063', 1),

-- Distrito 22
('EMP064', 'Jimena', 'Gallardo', 22, '20000064', 1, '910000064', 1),
('EMP065', 'Ulises', 'Meza', 22, '20000065', 2, '910000065', 1),
('EMP066', 'Patricia', 'Navarro', 22, '20000066', 3, '910000066', 1),

-- Distrito 23
('EMP067', 'Darío', 'Fuentes', 23, '20000067', 1, '910000067', 1),
('EMP068', 'Lorena', 'Córdova', 23, '20000068', 2, '910000068', 1),
('EMP069', 'Hernán', 'Suárez', 23, '20000069', 3, '910000069', 1),

-- Distrito 24
('EMP070', 'Ángel', 'Pizarro', 24, '20000070', 1, '910000070', 1),
('EMP071', 'Cecilia', 'Ramírez', 24, '20000071', 2, '910000071', 1),
('EMP072', 'Roberto', 'Escobar', 24, '20000072', 3, '910000072', 1),

-- Distrito 25
('EMP073', 'Pedro', 'Lozano', 25, '20000073', 1, '910000073', 1),
('EMP074', 'Ruth', 'Mendoza', 25, '20000074', 2, '910000074', 1),
('EMP075', 'Álex', 'Poma', 25, '20000075', 3, '910000075', 1),

-- Distrito 26
('EMP076', 'Mariano', 'Campos', 26, '20000076', 1, '910000076', 1),
('EMP077', 'Tatiana', 'Reyes', 26, '20000077', 2, '910000077', 1),
('EMP078', 'Fabián', 'Quispe', 26, '20000078', 3, '910000078', 1),

-- Distrito 27
('EMP079', 'Liliana', 'Cáceres', 27, '20000079', 1, '910000079', 1),
('EMP080', 'Héctor', 'Arce', 27, '20000080', 2, '910000080', 1),
('EMP081', 'Marina', 'Tello', 27, '20000081', 3, '910000081', 1),

-- Distrito 28
('EMP082', 'Álvaro', 'Soria', 28, '20000082', 1, '910000082', 1),
('EMP083', 'Verónica', 'Escalante', 28, '20000083', 2, '910000083', 1),
('EMP084', 'Leonardo', 'Matos', 28, '20000084', 3, '910000084', 1),

-- Distrito 29
('EMP085', 'Tatiana', 'Bravo', 29, '20000085', 1, '910000085', 1),
('EMP086', 'Nicolás', 'Acuña', 29, '20000086', 2, '910000086', 1),
('EMP087', 'Carmen', 'Ponce', 29, '20000087', 3, '910000087', 1),

-- Distrito 30
('EMP088', 'Gonzalo', 'Montoya', 30, '20000088', 1, '910000088', 1),
('EMP089', 'Daniela', 'Villalobos', 30, '20000089', 2, '910000089', 1),
('EMP090', 'Jaime', 'Cardozo', 30, '20000090', 3, '910000090', 1),

-- Distrito 31
('EMP091', 'Lucía', 'Carranza', 31, '20000091', 1, '910000091', 1),
('EMP092', 'Felipe', 'Vargas', 31, '20000092', 2, '910000092', 1),
('EMP093', 'Miguel', 'Olivera', 31, '20000093', 3, '910000093', 1),

-- Distrito 32
('EMP094', 'Teresa', 'Acosta', 32, '20000094', 1, '910000094', 1),
('EMP095', 'Felipe', 'Montoya', 32, '20000095', 2, '910000095', 1),
('EMP096', 'Daniela', 'Rivas', 32, '20000096', 3, '910000096', 1);


-- ============================================
-- USUARIOS (8 registros) 
-- id_empleado: 1..8 ya insertados
-- id_rol: 1=Administrador, 2=Supervisor, 3=Cajero, 4=Mesero
-- ============================================
INSERT INTO usuario (id_empleado, id_rol, correo, username, password, restablecer, estado) VALUES
(1, 1, 'admin00@maomakis.pe', 'DKBT', '$2a$12$HclG2HBzLVRLAJl1Foj2BeO5nujLVwWkPp2HhFBX1vQwWK7bUra.W', 0, 1),
(2, 2, 'super01@maomakis.pe', 'ADMIN', '$2a$12$HclG2HBzLVRLAJl1Foj2BeO5nujLVwWkPp2HhFBX1vQwWK7bUra.W', 1, 1),
(3, 3, 'cajero01@maomakis.pe', 'cajero01', '$2a$12$HclG2HBzLVRLAJl1Foj2BeO5nujLVwWkPp2HhFBX1vQwWK7bUra.W', 1, 1),
(4, 4, 'mesero01@maomakis.pe', 'mesero01', '$2a$12$HclG2HBzLVRLAJl1Foj2BeO5nujLVwWkPp2HhFBX1vQwWK7bUra.W', 1, 1),
(5, 3, 'cajero02@maomakis.pe', 'cajero02', '$2a$12$HclG2HBzLVRLAJl1Foj2BeO5nujLVwWkPp2HhFBX1vQwWK7bUra.W', 1, 1),
(6, 4, 'mesero02@maomakis.pe', 'mesero02', '$2a$12$HclG2HBzLVRLAJl1Foj2BeO5nujLVwWkPp2HhFBX1vQwWK7bUra.W', 1, 1),
(7, 2, 'super02@maomakis.pe', 'super02', '$2a$12$HclG2HBzLVRLAJl1Foj2BeO5nujLVwWkPp2HhFBX1vQwWK7bUra.W', 1, 1),
(8, 4, 'mesero03@maomakis.pe', 'mesero03', '$2a$12$HclG2HBzLVRLAJl1Foj2BeO5nujLVwWkPp2HhFBX1vQwWK7bUra.W', 1, 1);


-- ============================================
-- PEDIDOS (6 registros variados entre tipos y clientes)
-- id_estado: 1 = Activo, 2 = Finalizado, 3 = Anulado
-- ============================================
INSERT INTO pedido (id_tipo_pedido, id_empleado, id_mesa, id_direccion, fecha_inicio, total, id_estado) VALUES
(1, 4, 1, NULL, NOW(), 58.40, 2),   -- en mesa
(1, 5, 2, NULL, NOW(), 72.00, 1),   -- en mesa activo
(2, 3, NULL, NULL, NOW(), 34.90, 2), -- para llevar
(3, 2, NULL, 1, NOW(), 45.50, 1),   -- delivery a cliente 1
(3, 6, NULL, 3, NOW(), 28.00, 2),   -- delivery cliente 3
(3, 7, NULL, 4, NOW(), 64.90, 3);   -- delivery anulado

-- ============================================
-- DETALLE DE PEDIDO (8 registros)
-- ============================================
INSERT INTO detalle_pedido (id_pedido, id_platillo, cantidad, precio_unitario, observacion) VALUES
(1, 1, 2, 15.90, 'Compartir'),
(1, 3, 1, 22.00, NULL),
(2, 4, 2, 26.00, 'Sin cebolla'),
(3, 5, 1, 34.90, 'Extra picante'),
(4, 2, 1, 12.50, NULL),
(4, 7, 2, 6.50, 'Sin hielo'),
(5, 6, 1, 32.00, NULL),
(6, 8, 2, 7.50, 'Con canela');

-- ============================================
-- RESERVAS (6 registros)
-- ============================================
INSERT INTO reserva (id_cliente, id_mesa, fecha_reserva, hora, cantidad_personas, id_estado) VALUES
(1, 5, '2025-08-20', '19:00:00', 4, 1),
(2, 6, '2025-08-20', '20:00:00', 2, 1),
(3, 7, '2025-08-21', '18:30:00', 6, 1),
(4, 8, '2025-08-22', '21:00:00', 3, 2),
(5, 9, '2025-08-23', '13:00:00', 2, 1),
(6, 10, '2025-08-23', '14:30:00', 5, 3);

-- ============================================
-- COMPROBANTES (6 registros)
-- ============================================
INSERT INTO comprobante (fecha_emision, precio_total_pedido, igv_total, sub_total, id_tipo_comprobante, id_pedido, id_cliente, id_empleado, id_caja, id_estado) VALUES
(NOW(), 58.40, 8.40, 50.00, 1, 1, 1, 4, 1, 2),  -- boleta finalizada
(NOW(), 72.00, 11.00, 61.00, 2, 2, 2, 5, 2, 1), -- factura activa
(NOW(), 34.90, 5.30, 29.60, 1, 3, 3, 3, 1, 2),  -- boleta finalizada
(NOW(), 45.50, 6.90, 38.60, 3, 4, 1, 2, 3, 1),  -- ticket activo
(NOW(), 28.00, 4.20, 23.80, 2, 5, 3, 6, 2, 2),  -- factura finalizada
(NOW(), 64.90, 9.90, 55.00, 1, 6, 4, 7, 1, 3);  -- boleta anulada

-- ============================================
-- DETALLE COMPROBANTE (8 registros)
-- ============================================
INSERT INTO detalle_comprobante (monto_pago, id_comprobante, id_metodo_pago) VALUES
(30.00, 1, 1),
(28.40, 1, 2),

(72.00, 2, 2),

(20.00, 3, 1),
(14.90, 3, 3),

(45.50, 4, 2),

(28.00, 5, 1),

(64.90, 6, 3);
