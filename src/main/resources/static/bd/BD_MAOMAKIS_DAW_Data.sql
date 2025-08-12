USE BD_MAOMAKIS_BT;

-- 1. Crear un rol
INSERT INTO rol (descripcion) VALUES ('admin');
INSERT INTO rol (descripcion) VALUES ('user');
INSERT INTO rol (descripcion) VALUES ('cliente');


-- ============================================
-- 1. Departamentos
-- ============================================
INSERT INTO departamento (descripcion) VALUES 
('Lima'),
('Arequipa'),
('Cusco'),
('Piura'),
('La Libertad');


-- ============================================
-- 2. Provincias (2 por cada departamento → 10 en total)
-- ============================================
INSERT INTO provincia (descripcion, id_departamento) VALUES
-- Lima
('Lima', 1),
('Huaral', 1),
-- Arequipa
('Arequipa', 2),
('Camana', 2),
-- Cusco
('Cusco', 3),
('Urubamba', 3),
-- Piura
('Piura', 4),
('Sullana', 4),
-- La Libertad
('Trujillo', 5),
('Pacasmayo', 5);

-- ============================================
-- 3. Distritos (2 por cada provincia → 20 en total)
-- ============================================
INSERT INTO distrito (descripcion, id_provincia) VALUES
-- Lima
('Miraflores', 1),
('San Isidro', 1),
('Chancay', 2),
('Aucallama', 2),
-- Arequipa
('Cercado de Arequipa', 3),
('Yanahuara', 3),
('Camana', 4),
('Quilca', 4),
-- Cusco
('San Blas', 5),
('Santiago', 5),
('Ollantaytambo', 6),
('Machu Picchu', 6),
-- Piura
('Catacaos', 7),
('Castilla', 7),
('Bellavista', 8),
('Marcavelica', 8),
-- La Libertad
('Víctor Larco Herrera', 9),
('El Porvenir', 9),
('San Pedro de Lloc', 10),
('Guadalupe', 10);


-- ============================================
-- 4. Cargos de empleados
-- ============================================
INSERT INTO cargo_empleado (descripcion) VALUES
('Gerente General'),
('Administrador'),
('Cajero'),
('Mozo'),
('Chef');

-- ============================================
-- 5. Empleados (10 registros)
-- ============================================
INSERT INTO empleado (codigo, nombre, apellido, id_distrito, dni, id_cargo, telefono, estado) VALUES
('EMP00001', 'Daniel', 'BT', 1, '12345678', 1, '999888777', 1),
('EMP00002', 'María', 'Lopez', 1, '22345678', 2, '999111222', 1),
('EMP00003', 'Carlos', 'Perez', 2, '32345678', 3, '988777666', 1),
('EMP00004', 'Ana', 'Gomez', 2, '42345678', 4, '977888555', 1),
('EMP00005', 'Luis', 'Ramos', 3, '52345678', 5, '966555444', 1),
('EMP00006', 'Sofia', 'Fernandez', 3, '62345678', 4, '955444333', 1),
('EMP00007', 'Jorge', 'Castillo', 4, '72345678', 3, '944333222', 1),
('EMP00008', 'Carmen', 'Diaz', 4, '82345678', 2, '933222111', 1),
('EMP00009', 'Pedro', 'Martinez', 5, '92345678', 5, '922111000', 1),
('EMP00010', 'Lucia', 'Vega', 5, '98345678', 4, '911000999', 1);

-- 5. Crear el usuario DKBT con contraseña encriptada
INSERT INTO usuario (id_empleado, id_rol, correo, username, password, restablecer, estado)
VALUES (1, 1, 'dkbt@example.com', 'DKBT', '$2a$12$HclG2HBzLVRLAJl1Foj2BeO5nujLVwWkPp2HhFBX1vQwWK7bUra.W', 0, 1);
SELECT * FROM usuario;