package com.banca.cuentas.controller;

import com.banca.cuentas.dto.CuentaRequest;
import com.banca.cuentas.dto.CuentaResponse;
import com.banca.cuentas.service.CuentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cuentas")
@Tag(name = "Cuentas", description = "Operaciones CRUD para gestión de cuentas bancarias")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @PostMapping
    @Operation(summary = "Crear una nueva cuenta", description = "Registra una nueva cuenta bancaria en el sistema")
    public ResponseEntity<CuentaResponse> crearCuenta(@Valid @RequestBody CuentaRequest request) {
        CuentaResponse cuentaCreada = cuentaService.crearCuenta(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(cuentaCreada);
    }

    @GetMapping
    @Operation(summary = "Listar todas las cuentas", description = "Retorna todas las cuentas bancarias registradas")
    public ResponseEntity<List<CuentaResponse>> listarCuentas() {
        List<CuentaResponse> cuentas = cuentaService.listarCuentas();
        return ResponseEntity.ok(cuentas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cuenta por ID", description = "Retorna los datos de una cuenta específica")
    public ResponseEntity<CuentaResponse> buscarCuentaPorId(
            @Parameter(description = "ID de la cuenta a buscar", required = true)
            @PathVariable UUID id) {
        CuentaResponse cuenta = cuentaService.buscarCuentaPorId(id);
        return ResponseEntity.ok(cuenta);
    }

    @GetMapping("/numero/{numeroCuenta}")
    @Operation(summary = "Buscar cuenta por número", description = "Retorna los datos de una cuenta por su número")
    public ResponseEntity<CuentaResponse> buscarCuentaPorNumero(
            @Parameter(description = "Número de cuenta a buscar", required = true)
            @PathVariable String numeroCuenta) {
        CuentaResponse cuenta = cuentaService.buscarCuentaPorNumero(numeroCuenta);
        return ResponseEntity.ok(cuenta);
    }

    @GetMapping("/cliente/{clienteId}")
    @Operation(summary = "Buscar cuentas por cliente", description = "Retorna todas las cuentas de un cliente específico")
    public ResponseEntity<List<CuentaResponse>> buscarCuentasPorCliente(
            @Parameter(description = "ID del cliente", required = true)
            @PathVariable UUID clienteId) {
        List<CuentaResponse> cuentas = cuentaService.buscarCuentasPorCliente(clienteId);
        return ResponseEntity.ok(cuentas);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar cuenta", description = "Actualiza los datos de una cuenta existente")
    public ResponseEntity<CuentaResponse> actualizarCuenta(
            @Parameter(description = "ID de la cuenta a actualizar", required = true)
            @PathVariable UUID id,
            @Valid @RequestBody CuentaRequest request) {
        CuentaResponse cuentaActualizada = cuentaService.actualizarCuenta(id, request);
        return ResponseEntity.ok(cuentaActualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar cuenta", description = "Elimina una cuenta del sistema")
    public ResponseEntity<Void> eliminarCuenta(
            @Parameter(description = "ID de la cuenta a eliminar", required = true)
            @PathVariable UUID id) {
        cuentaService.eliminarCuenta(id);
        return ResponseEntity.noContent().build();
    }
}