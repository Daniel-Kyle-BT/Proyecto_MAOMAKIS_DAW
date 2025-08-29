package com.cibertec.security.dto;

public record UsuarioDTO(
    String username,
    Long   id,
    String codigoEmpleado,
    RolDTO rol,
    String nombreEmpleado,
    String apellidoEmpleado
) {}

