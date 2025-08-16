DROP DATABASE IF EXISTS BD_MAOMAKIS_BT;
CREATE DATABASE BD_MAOMAKIS_BT;
USE BD_MAOMAKIS_BT;

-- ============================================
-- TABLA DE ESTADOS (NORMALIZADA)
-- ============================================
CREATE TABLE estado (
    id_estado 					INT AUTO_INCREMENT PRIMARY KEY,
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
    codigo 						CHAR(6) NOT NULL,
    nombre 						VARCHAR(100),
    id_distrito 				INT NOT NULL,
    telefono 					VARCHAR(15),
    pais 						VARCHAR(50),
    id_estado 					INT NOT NULL,      
    FOREIGN KEY (id_distrito) REFERENCES distrito(id_distrito),
	FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);

CREATE TABLE caja (
    id_caja						INT PRIMARY KEY AUTO_INCREMENT,
    codigo 						CHAR(6) NOT NULL,
	id_sucursal 				INT NOT NULL,
    id_estado 					INT NOT NULL,   
    FOREIGN KEY (id_sucursal) REFERENCES sucursales(id_sucursal),
	FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);

-- ============================================
-- TABLAS DE CLIENTES Y EMPLEADOS
-- ============================================
CREATE TABLE cliente (
    id_cliente 					BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo 						CHAR(6) NOT NULL,   
    nombre 						VARCHAR(100) NOT NULL,
    apellido 					VARCHAR(100) NOT NULL,
    telefono 					VARCHAR(15) ,
    fecha_registro 				DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado 						TINYINT(1)
);

CREATE TABLE cargo_empleado (
    id_cargo 					INT AUTO_INCREMENT PRIMARY KEY,
    descripcion 				VARCHAR(100) NOT NULL
);

CREATE TABLE empleado (
    id_empleado 				BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo 						CHAR(6) NOT NULL,
    nombre 						VARCHAR(100) NOT NULL,
    apellido 					VARCHAR(100) NOT NULL,
    id_distrito 				INT NOT NULL,
    dni 						VARCHAR(15) UNIQUE,
	id_cargo 					INT NOT NULL,
    telefono 					VARCHAR(15),
    estado 						TINYINT(1),
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
    id_empleado 				BIGINT UNIQUE,
    id_rol						INT NOT NULL,
    correo 						VARCHAR(100) UNIQUE,
    username 					VARCHAR(100) UNIQUE,
    password 					VARCHAR(250) NOT NULL,
    restablecer 				BIT DEFAULT 1,
    fecha_registro				DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado 						TINYINT(1),
    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado),
    FOREIGN KEY (id_rol) REFERENCES rol(id_rol)
);

-- ============================================
-- TABLAS DE CATEGORÍAS Y MENÚ
-- ============================================
CREATE TABLE categoria (
    id_categoria 				INT AUTO_INCREMENT PRIMARY KEY,
    descripcion 				VARCHAR(100) NOT NULL,
    estado 						TINYINT(1)
);

CREATE TABLE menu (
    id_platillo 				BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo 						CHAR(6) NOT NULL,
    nombre 						VARCHAR(100) NOT NULL,
    descripcion 				VARCHAR(250),
    id_categoria 				INT NOT NULL,
    precio 						DECIMAL(10, 2) NOT NULL,
    tiempo_preparacion 			INT,
    ruta_imagen 				VARCHAR(255),
    nombre_imagen 				VARCHAR(100),
    fecha_registro 				DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado 						TINYINT(1),
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

-- ============================================
-- TABLAS DE MESAS
-- ============================================
CREATE TABLE mesa (
    id_mesa 					BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_sucursal 				INT NOT NULL,
    numero_mesa 				INT NOT NULL,
    capacidad 					INT,
    id_estado 					INT NOT NULL,
    FOREIGN KEY (id_sucursal) REFERENCES sucursales(id_sucursal),
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado),
    UNIQUE (id_sucursal, numero_mesa)
);

-- ============================================
-- TABLAS DE DIRECCIONES PARA DELIVERY
-- ============================================
CREATE TABLE direccion_pedido (
    id_direccion 				BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_cliente 					BIGINT NOT NULL,
    id_distrito 				INT NOT NULL,
    direccion_detallada 		VARCHAR(255) NOT NULL,
    referencia 					VARCHAR(255),
    etiqueta 					VARCHAR(100), -- Como casa, trabajo, no se Opcional
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_distrito) REFERENCES distrito(id_distrito)
);

-- ============================================
-- TABLAS DE PEDIDOS 
-- ============================================
CREATE TABLE tipo_pedido (
	id_tipo_pedido				INT AUTO_INCREMENT PRIMARY KEY,
    descripcion 				VARCHAR(100) NOT NULL
);

CREATE TABLE pedido (
    id_pedido 					BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_tipo_pedido				INT NOT NULL,
	id_empleado 				BIGINT NOT NULL,
    id_mesa 					BIGINT,
    id_direccion 				BIGINT,
    fecha_inicio 				DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_fin 					DATETIME,
    fecha_entrega 				DATETIME,
    total						DECIMAL(10,2),
    id_estado 					INT NOT NULL,
    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado),
    FOREIGN KEY (id_tipo_pedido) REFERENCES tipo_pedido(id_tipo_pedido),
    FOREIGN KEY (id_direccion) REFERENCES direccion_pedido(id_direccion),
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado),
	FOREIGN KEY (id_mesa) REFERENCES mesa(id_mesa)   
);

CREATE TABLE detalle_pedido (
    id_pedido 					BIGINT,
    id_platillo 				BIGINT,
    cantidad 					INT NOT NULL,
    precio_unitario 			DECIMAL(10, 2) NOT NULL,
    observacion 				VARCHAR(255),
	PRIMARY KEY (id_pedido, id_platillo),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
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
    id_estado 					INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_mesa) REFERENCES mesa(id_mesa),
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);

-- ============================================
-- TABLAS DE COMPROBANTES Y PAGOS
-- ============================================
CREATE TABLE tipo_comprobante (
    id_tipo_comprobante 		INT AUTO_INCREMENT PRIMARY KEY,
    descripcion					VARCHAR(100) NOT NULL
);

CREATE TABLE comprobante (
    id_comprobante 				BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_emision 				DATETIME DEFAULT CURRENT_TIMESTAMP,
    precio_total_pedido 		DECIMAL(10,2),
    igv_total 					DECIMAL(10,2),
    sub_total 					DECIMAL(10,2),
    id_tipo_comprobante 		INT NOT NULL,    
    id_pedido					BIGINT NOT NULL,
    id_cliente 					BIGINT NOT NULL,
    id_empleado 				BIGINT NOT NULL,  
    id_caja 					INT NOT NULL,
    id_estado 					INT NOT NULL,
    FOREIGN KEY (id_tipo_comprobante) REFERENCES tipo_comprobante(id_tipo_comprobante),
	FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),    
    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado),  
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
    FOREIGN KEY (id_caja) REFERENCES caja(id_caja),  
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);

CREATE TABLE metodo_pago (
    id_metodo_pago 				INT AUTO_INCREMENT PRIMARY KEY,
    descripcion					VARCHAR(100) NOT NULL
);

CREATE TABLE detalle_comprobante (
    id_detalle_comprobante 		BIGINT AUTO_INCREMENT PRIMARY KEY,
    monto_pago					DECIMAL(10,2) NOT NULL,
    id_comprobante 				BIGINT NOT NULL,
    id_metodo_pago 				INT NOT NULL,
    FOREIGN KEY (id_comprobante) REFERENCES comprobante(id_comprobante),
    FOREIGN KEY (id_metodo_pago) REFERENCES metodo_pago(id_metodo_pago)
);
