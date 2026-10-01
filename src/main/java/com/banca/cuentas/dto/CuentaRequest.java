package com.banca.cuentas.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CuentaRequest {
    @NotBlank(message = "El número de cuenta no puede estar vacío")
    @Size(min = 10, max = 20, message = "El número de cuenta debe tener entre 10 y 20 caracteres")
    @Pattern(regexp = "^[0-9]+$", message = "El número de cuenta solo puede contener dígitos")
    private String numeroCuenta;

    @NotNull(message = "El ID del cliente no puede ser nulo")
    private UUID clienteId;

    @NotBlank(message = "El tipo de cuenta no puede estar vacío")
    @Size(max = 20, message = "El tipo de cuenta no puede exceder 20 caracteres")
    private String tipoCuenta;

    @NotNull(message = "El saldo inicial no puede ser nulo")
    @DecimalMin(value = "0.00", inclusive = true, message = "El saldo no puede ser negativo")
    @Digits(integer = 17, fraction = 2, message = "El saldo debe tener hasta 17 dígitos enteros y 2 decimales")
    private BigDecimal saldoInicial;

    @NotBlank(message = "La sucursal no puede estar vacía")
    @Size(max = 50, message = "La sucursal no puede exceder 50 caracteres")
    private String sucursal;

    @NotBlank(message = "El estado de la cuenta no puede estar vacío")
    @Size(max = 20, message = "El estado de la cuenta no puede exceder 20 caracteres")
    private String estado;
}