package com.banca.cuentas.service;

import com.banca.cuentas.dto.CuentaRequest;
import com.banca.cuentas.dto.CuentaResponse;
import com.banca.cuentas.exception.InvalidDataException;
import com.banca.cuentas.exception.ResourceNotFoundException;
import com.banca.cuentas.model.Cuenta;
import com.banca.cuentas.repository.CuentaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CuentaService {

    private static final String ESTADO_ACTIVA = "ACTIVA";
    private static final String ESTADO_INACTIVA = "INACTIVA";
    private static final String ESTADO_CERRADA = "CERRADA";

    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public CuentaResponse crearCuenta(CuentaRequest request) {
        validarRequest(request);
        validarNumeroCuentaUnico(request.numeroCuenta());
        validarClienteExistente(request.clienteId());

        Cuenta cuenta = new Cuenta();
        cuenta.setId(UUID.randomUUID());
        cuenta.setNumeroCuenta(request.numeroCuenta());
        cuenta.setClienteId(request.clienteId());
        cuenta.setTipoCuenta(request.tipoCuenta());
        cuenta.setSaldo(request.saldoInicial() != null ? request.saldoInicial() : BigDecimal.ZERO);
        cuenta.setFechaApertura(LocalDateTime.now());
        cuenta.setEstado(determinarEstadoInicial(request.estado()));
        cuenta.setSucursal(request.sucursal());
        cuenta.setVersion(0);

        Cuenta cuentaGuardada = cuentaRepository.save(cuenta);
        return mapearAResponse(cuentaGuardada);
    }

    @Transactional(readOnly = true)
    public List<CuentaResponse> listarCuentas() {
        return cuentaRepository.findAll().stream()
                .map(this::mapearAResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CuentaResponse buscarCuentaPorId(UUID id) {
        Cuenta cuenta = cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Cuenta no encontrada con ID: " + id));
        return mapearAResponse(cuenta);
    }

    @Transactional(readOnly = true)
    public CuentaResponse buscarCuentaPorNumero(String numeroCuenta) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Cuenta no encontrada con número: " + numeroCuenta));
        return mapearAResponse(cuenta);
    }

    @Transactional(readOnly = true)
    public List<CuentaResponse> buscarCuentasPorCliente(UUID clienteId) {
        if (!cuentaRepository.existsByClienteId(clienteId)) {
            throw new ResourceNotFoundException(
                    "No se encontraron cuentas para el cliente con ID: " + clienteId);
        }
        return cuentaRepository.findByClienteId(clienteId).stream()
                .map(this::mapearAResponse)
                .collect(Collectors.toList());
    }

    public CuentaResponse actualizarCuenta(UUID id, CuentaRequest request) {
        validarRequest(request);

        Cuenta cuenta = cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Cuenta no encontrada con ID: " + id));

        if (!cuenta.getNumeroCuenta().equals(request.numeroCuenta())) {
            validarNumeroCuentaUnico(request.numeroCuenta());
        }

        cuenta.setNumeroCuenta(request.numeroCuenta());
        cuenta.setTipoCuenta(request.tipoCuenta());
        cuenta.setSucursal(request.sucursal());
        cuenta.setEstado(determinarEstadoInicial(request.estado()));

        Cuenta cuentaActualizada = cuentaRepository.save(cuenta);
        return mapearAResponse(cuentaActualizada);
    }

    public void eliminarCuenta(UUID id) {
        if (!cuentaRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Cuenta no encontrada con ID: " + id);
        }
        cuentaRepository.deleteById(id);
    }

    private void validarRequest(CuentaRequest request) {
        if (request == null) {
            throw new InvalidDataException("Los datos de la cuenta son requeridos");
        }
        if (request.numeroCuenta() == null || request.numeroCuenta().trim().isEmpty()) {
            throw new InvalidDataException("El número de cuenta es requerido");
        }
        if (request.clienteId() == null) {
            throw new InvalidDataException("El cliente es requerido");
        }
        if (request.tipoCuenta() == null || request.tipoCuenta().trim().isEmpty()) {
            throw new InvalidDataException("El tipo de cuenta es requerido");
        }
    }

    private void validarNumeroCuentaUnico(String numeroCuenta) {
        if (cuentaRepository.existsByNumeroCuenta(numeroCuenta)) {
            throw new InvalidDataException(
                    "Ya existe una cuenta con el número: " + numeroCuenta);
        }
    }

    private void validarClienteExistente(UUID clienteId) {
        if (!cuentaRepository.existsByClienteId(clienteId)) {
            throw new InvalidDataException(
                    "No existe un cliente con ID: " + clienteId);
        }
    }

    private String determinarEstadoInicial(String estado) {
        if (estado == null || estado.trim().isEmpty()) {
            return ESTADO_ACTIVA;
        }
        String estadoUpper = estado.toUpperCase();
        if (ESTADO_ACTIVA.equals(estadoUpper) || 
            ESTADO_INACTIVA.equals(estadoUpper) || 
            ESTADO_CERRADA.equals(estadoUpper)) {
            return estadoUpper;
        }
        return ESTADO_ACTIVA;
    }

    private CuentaResponse mapearAResponse(Cuenta cuenta) {
        return new CuentaResponse(
                cuenta.getId(),
                cuenta.getNumeroCuenta(),
                cuenta.getClienteId(),
                cuenta.getTipoCuenta(),
                cuenta.getSaldo(),
                cuenta.getFechaApertura(),
                cuenta.getEstado(),
                cuenta.getSucursal()
        );
    }
}