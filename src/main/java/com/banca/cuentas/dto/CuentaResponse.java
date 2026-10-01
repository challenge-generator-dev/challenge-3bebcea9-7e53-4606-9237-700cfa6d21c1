package com.banca.cuentas.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Respuesta de cuenta bancaria con datos no sensibles")
public record CuentaResponse(
    @Schema(description = "Identificador único de la cuenta", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id,
    
    @Schema(description = "Número de cuenta bancaria", example = "ES1234567890123456789012")
    String numeroCuenta,
    
    @Schema(description = "Identificador del cliente titular", example = "660e8400-e29b-41d4-a716-446655440001")
    UUID clienteId,
    
    @Schema(description = "Tipo de cuenta", example = "AHORRO")
    String tipoCuenta,
    
    @Schema(description = "Saldo actual de la cuenta", example = "1000.00")
    BigDecimal saldo,
    
    @Schema(description = "Fecha de apertura de la cuenta")
    LocalDateTime fechaApertura,
    
    @Schema(description = "Estado de la cuenta", example = "ACTIVA")
    String estado,
    
    @Schema(description = "Sucursal donde se abrió la cuenta", example = "CENTRO")
    String sucursal
) {}