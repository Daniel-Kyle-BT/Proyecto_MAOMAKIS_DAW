DROP DATABASE IF EXISTS BD_MAOMAKIS_BT;
CREATE DATABASE BD_MAOMAKIS_BT;
USE BD_MAOMAKIS_BT;

-- ============================================
-- TABLA DE ESTADOS (NORMALIZADA)
-- ============================================
CREATE TABLE estado (
    id_estado 					BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion 				VARCHAR(50) NOT NULL
);

-- ============================================
-- TABLAS DE UBICACIÓN
-- ============================================
CREATE TABLE departamento (
    id_departamento 			INT AUTO_INCREMENT PRIMARY KEY,
    descripcion 				VARCHAR(100) NOT NULL
);

CREATE TABLE provincia (
    id_provincia 				INT AUTO_INCREMENT PRIMARY KEY,
    descripcion					VARCHAR(100) NOT NULL,
    id_departamento 			INT NOT NULL,
    FOREIGN KEY (id_departamento) REFERENCES departamento(id_departamento)
);

CREATE TABLE distrito (
    id_distrito 				INT AUTO_INCREMENT PRIMARY KEY,
    descripcion 				VARCHAR(100) NOT NULL,
    id_provincia 				INT NOT NULL,
    FOREIGN KEY (id_provincia) REFERENCES provincia(id_provincia)
);

CREATE TABLE sucursales (
    id_sucursal 				INT PRIMARY KEY AUTO_INCREMENT,
    nombre 						VARCHAR(100),
    id_distrito 				INT,
    telefono 					VARCHAR(15),
    pais 						VARCHAR(50),
    estado 						BIT DEFAULT 1,    
    FOREIGN KEY (id_distrito) REFERENCES distrito(id_distrito)    
);

CREATE TABLE caja (
    id_caja						INT PRIMARY KEY AUTO_INCREMENT,
    codigo 						VARCHAR(10) NOT NULL,
	id_sucursal 				INT NOT NULL,
    estado 						BIT DEFAULT 1,    
    FOREIGN KEY (id_sucursal) REFERENCES sucursales(id_sucursal)    
);

-- ============================================
-- TABLAS DE CLIENTES Y EMPLEADOS
-- ============================================
CREATE TABLE cliente (
    id_cliente 					BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre 						VARCHAR(100) NOT NULL,
    apellido 					VARCHAR(100) NOT NULL,
    telefono 					VARCHAR(15) ,
    fecha_registro 				DATETIME DEFAULT CURRENT_TIMESTAMP,
    canal_preferencia 			ENUM('WhatsApp', 'Llamada', 'Redes Sociales', 'Tienda') DEFAULT 'Tienda',
    estado 						BIT DEFAULT 1
);

CREATE TABLE cargo_empleado (
    id_cargo INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE empleado (
    id_empleado 				BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo 						CHAR(8) NOT NULL,
    nombre 						VARCHAR(100) NOT NULL,
    apellido 					VARCHAR(100) NOT NULL,
    id_distrito 				INT,
    dni 						VARCHAR(15) UNIQUE,
	id_cargo 					INT NOT NULL,
    telefono 					VARCHAR(15),
    estado 						BIT DEFAULT 1,
    FOREIGN KEY (id_distrito) REFERENCES distrito(id_distrito),
    FOREIGN KEY (id_cargo) REFERENCES cargo_empleado(id_cargo)
);

-- ============================================
-- TABLAS DE USUARIOS
-- ============================================
CREATE TABLE rol (
	id_rol						INT AUTO_INCREMENT PRIMARY KEY,
    descripcion 				VARCHAR(100) NOT NULL
);

CREATE TABLE usuario (
    id_usuario 					BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_cliente 					BIGINT,
    id_empleado 				BIGINT,
    id_rol						INT NOT NULL,
    correo 						VARCHAR(100) UNIQUE,
    username 					VARCHAR(100) UNIQUE,
    password 					VARCHAR(250) NOT NULL,
    restablecer 				BIT DEFAULT 1,
    fecha_registro				DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado 						BIT DEFAULT 1,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado),
    FOREIGN KEY (id_rol) REFERENCES rol(id_rol)
);

-- ============================================
-- TABLAS DE CATEGORÍAS Y MENÚ
-- ============================================
CREATE TABLE categoria (
    id_categoria 				INT AUTO_INCREMENT PRIMARY KEY,
    descripcion 				VARCHAR(100) NOT NULL,
    fecha_registro 				DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado 						BIT DEFAULT 1
);

CREATE TABLE menu (
    id_platillo 				BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo 						CHAR(8) NOT NULL,
    nombre 						VARCHAR(100) NOT NULL,
    descripcion 				TEXT,
    id_categoria 				INT NOT NULL,
    precio 						DECIMAL(10, 2) NOT NULL,
    tiempo_preparacion 			INT,
    ruta_imagen 				VARCHAR(255),
    nombre_imagen 				VARCHAR(100),
    fecha_registro 				DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado 						BIT DEFAULT 1,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

-- ============================================
-- TABLAS DE MESAS
-- ============================================
CREATE TABLE mesa (
    id_mesa 					BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_sucursal 				INT,
    numero_mesa 				INT NOT NULL,
    capacidad 					INT,
    id_estado 					BIGINT DEFAULT 1,
    FOREIGN KEY (id_sucursal) REFERENCES sucursales(id_sucursal),
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado),
    UNIQUE (id_sucursal, numero_mesa)
);

-- ============================================
-- TABLAS DE DIRECCIONES PARA DELIVERY
-- ============================================
CREATE TABLE direccion_pedido (
    id_direccion 				BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_usuario 					BIGINT NOT NULL,
    id_distrito 				INT NOT NULL,
    direccion_detallada 		VARCHAR(255) NOT NULL,
    referencia 					VARCHAR(255),
    etiqueta 					VARCHAR(100), -- Como casa, trabajo, no se Opcional
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_distrito) REFERENCES distrito(id_distrito)
);

-- ============================================
-- TABLAS DE PEDIDOS Y COMANDAS
-- ============================================
CREATE TABLE pedido (
    id_pedido 					BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_cliente 					BIGINT NOT NULL,
    id_direccion 				BIGINT,
    id_transaccion 				VARCHAR(50),
    fecha_pedido 				DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_fin 					DATETIME,
    modalidad 					ENUM('Delivery', 'Retiro en tienda') NOT NULL, -- Abierto a cambios
    id_estado 					BIGINT NOT NULL,
    total 						DECIMAL(10, 2),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_direccion) REFERENCES direccion_pedido(id_direccion),
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);

CREATE TABLE comanda (
    id_comanda 					BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_emision 				DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_empleado 				BIGINT NOT NULL,
    id_estado 					BIGINT NOT NULL,
    id_mesa 					BIGINT,
    total 						DECIMAL(10, 2),
    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado),
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado),
    FOREIGN KEY (id_mesa) REFERENCES mesa(id_mesa)
);

-- ============================================
-- TABLA DE DETALLES (UNIFICADA)
-- ============================================
CREATE TABLE detalle (
    id_detalle 					BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_pedido 					BIGINT,
    id_comanda 					BIGINT,
    id_platillo 				BIGINT NOT NULL,
    cantidad 					INT NOT NULL,
    precio_unitario 			DECIMAL(10, 2) NOT NULL,
    subtotal 					DECIMAL(10, 2),
    observacion 				VARCHAR(255),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
    FOREIGN KEY (id_comanda) REFERENCES comanda(id_comanda),
    FOREIGN KEY (id_platillo) REFERENCES menu(id_platillo)
);

-- ============================================
-- TABLA DE RESERVAS
-- ============================================
CREATE TABLE reserva (
    id_reserva 					BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_cliente 					BIGINT NOT NULL,
    id_mesa 					BIGINT NOT NULL,
    fecha_reserva 				DATE NOT NULL,
    hora 						TIME NOT NULL,
    cantidad_personas 			INT,
    id_estado 					BIGINT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_mesa) REFERENCES mesa(id_mesa),
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);

-- ============================================
-- TABLA DE CARRITO
-- ============================================
CREATE TABLE carrito (
    id_usuario 					BIGINT,
    id_platillo 				BIGINT,
    cantidad 					INT,
    PRIMARY KEY (id_usuario, id_platillo),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_platillo) REFERENCES menu(id_platillo)
);

-- ============================================
-- TABLAS DE COMPROBANTES Y PAGOS
-- ============================================
CREATE TABLE tipo_comprobante (
    id_tipo_comprobante 		BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo 						VARCHAR(255) NOT NULL
);

CREATE TABLE comprobante (
    id_comprobante 				BIGINT AUTO_INCREMENT PRIMARY KEY,
    descuento_total 			DECIMAL(10,2),
    fecha_emision 				DATETIME DEFAULT CURRENT_TIMESTAMP,
    igv_total 					DECIMAL(10,2),
    precio_total_pedido 		DECIMAL(10,2),
    sub_total 					DECIMAL(10,2),
    id_caja 					INT,
    id_cliente 					BIGINT,
    id_comanda 					BIGINT,
    id_empleado 				BIGINT,
    id_tipo_comprobante 		BIGINT,
    id_estado 					BIGINT DEFAULT 1,
    FOREIGN KEY (id_caja) REFERENCES caja(id_caja),
    FOREIGN KEY (id_comanda) REFERENCES comanda(id_comanda),
    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado),
    FOREIGN KEY (id_tipo_comprobante) REFERENCES tipo_comprobante(id_tipo_comprobante),
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);

CREATE TABLE metodo_pago (
    id_metodo_pago 				BIGINT AUTO_INCREMENT PRIMARY KEY,
    metodo VARCHAR(255) NOT NULL
);

CREATE TABLE detalle_comprobante (
    id_detalle_comprobante 		BIGINT AUTO_INCREMENT PRIMARY KEY,
    monto_pago 					DECIMAL(10,2),
    id_comprobante 				BIGINT,
    id_metodo_pago 				BIGINT,
    FOREIGN KEY (id_comprobante) REFERENCES comprobante(id_comprobante),
    FOREIGN KEY (id_metodo_pago) REFERENCES metodo_pago(id_metodo_pago)
);












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