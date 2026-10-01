package com.banca.cuentas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "cuentas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "numero_cuenta", nullable = false, unique = true, length = 20)
    @NotBlank(message = "El número de cuenta no puede estar vacío")
    @Size(min = 10, max = 20, message = "El número de cuenta debe tener entre 10 y 20 caracteres")
    @Pattern(regexp = "^[0-9]+$", message = "El número de cuenta solo puede contener dígitos")
    private String numeroCuenta;

    @Column(name = "cliente_id", nullable = false)
    @NotNull(message = "El ID del cliente no puede ser nulo")
    private UUID clienteId;

    @Column(name = "tipo_cuenta", nullable = false, length = 20)
    @NotBlank(message = "El tipo de cuenta no puede estar vacío")
    @Size(max = 20, message = "El tipo de cuenta no puede exceder 20 caracteres")
    private String tipoCuenta;

    @Column(name = "saldo", nullable = false, precision = 19, scale = 2)
    @NotNull(message = "El saldo no puede ser nulo")
    @DecimalMin(value = "0.00", inclusive = true, message = "El saldo no puede ser negativo")
    @Digits(integer = 17, fraction = 2, message = "El saldo debe tener hasta 17 dígitos enteros y 2 decimales")
    private BigDecimal saldo;

    @Column(name = "fecha_apertura", nullable = false)
    @NotNull(message = "La fecha de apertura no puede ser nula")
    private LocalDateTime fechaApertura;

    @Column(name = "estado", nullable = false, length = 20)
    @NotBlank(message = "El estado de la cuenta no puede estar vacío")
    @Size(max = 20, message = "El estado de la cuenta no puede exceder 20 caracteres")
    private String estado;

    @Column(name = "sucursal", nullable = false, length = 50)
    @NotBlank(message = "La sucursal no puede estar vacía")
    @Size(max = 50, message = "La sucursal no puede exceder 50 caracteres")
    private String sucursal;

    @Version
    private Integer version;
}