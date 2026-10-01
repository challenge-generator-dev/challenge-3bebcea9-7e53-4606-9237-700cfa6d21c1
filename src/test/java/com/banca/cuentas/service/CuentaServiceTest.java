package com.banca.cuentas.service;

import com.banca.cuentas.dto.CuentaRequest;
import com.banca.cuentas.dto.CuentaResponse;
import com.banca.cuentas.exception.InvalidDataException;
import com.banca.cuentas.exception.ResourceNotFoundException;
import com.banca.cuentas.model.Cuenta;
import com.banca.cuentas.repository.CuentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CuentaServiceTest {

    @Mock
    private CuentaRepository cuentaRepository;

    @InjectMocks
    private CuentaService cuentaService;

    private UUID cuentaId;
    private UUID clienteId;
    private Cuenta cuenta;
    private CuentaRequest cuentaRequest;

    @BeforeEach
    void setUp() {
        cuentaId = UUID.randomUUID();
        clienteId = UUID.randomUUID();
        cuenta = new Cuenta();
        cuenta.setId(cuentaId);
        cuenta.setNumeroCuenta("1234567890");
        cuenta.setClienteId(clienteId);
        cuenta.setTipoCuenta("AHORROS");
        cuenta.setSaldo(new BigDecimal("1000.00"));
        cuenta.setFechaApertura(LocalDateTime.now());
        cuenta.setEstado("ACTIVA");
        cuenta.setSucursal("SUCURSAL_CENTRAL");
        cuenta.setVersion(0);

        cuentaRequest = new CuentaRequest();
        cuentaRequest.setNumeroCuenta("1234567890");
        cuentaRequest.setClienteId(clienteId);
        cuentaRequest.setTipoCuenta("AHORROS");
        cuentaRequest.setSaldoInicial(new BigDecimal("1000.00"));
        cuentaRequest.setSucursal("SUCURSAL_CENTRAL");
        cuentaRequest.setEstado("ACTIVA");
    }

    @Test
    @DisplayName("obtenerTodasLasCuentas - debe retornar lista de cuentas")
    void testObtenerTodasLasCuentas() {
        List<Cuenta> cuentas = Arrays.asList(cuenta);
        when(cuentaRepository.findAll()).thenReturn(cuentas);

        List<CuentaResponse> result = cuentaService.obtenerTodasLasCuentas();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("1234567890", result.get(0).numeroCuenta());
        verify(cuentaRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("obtenerTodasLasCuentas - debe retornar lista vacía cuando no hay cuentas")
    void testObtenerTodasLasCuentasVacia() {
        when(cuentaRepository.findAll()).thenReturn(Arrays.asList());

        List<CuentaResponse> result = cuentaService.obtenerTodasLasCuentas();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(cuentaRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("obtenerCuentaPorId - debe retornar cuenta cuando existe")
    void testObtenerCuentaPorIdExistente() {
        when(cuentaRepository.findById(cuentaId)).thenReturn(Optional.of(cuenta));

        CuentaResponse result = cuentaService.obtenerCuentaPorId(cuentaId);

        assertNotNull(result);
        assertEquals(cuentaId, result.id());
        assertEquals("1234567890", result.numeroCuenta());
        verify(cuentaRepository, times(1)).findById(cuentaId);
    }

    @Test
    @DisplayName("obtenerCuentaPorId - debe lanzar excepción cuando no existe")
    void testObtenerCuentaPorIdNoExistente() {
        UUID idInexistente = UUID.randomUUID();
        when(cuentaRepository.findById(idInexistente)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            cuentaService.obtenerCuentaPorId(idInexistente);
        });
        verify(cuentaRepository, times(1)).findById(idInexistente);
    }

    @Test
    @DisplayName("crearCuenta - debe crear cuenta exitosamente")
    void testCrearCuenta() {
        when(cuentaRepository.existsByNumeroCuenta(cuentaRequest.getNumeroCuenta())).thenReturn(false);
        when(cuentaRepository.existsByClienteId(cuentaRequest.getClienteId())).thenReturn(false);
        when(cuentaRepository.save(any(Cuenta.class))).thenReturn(cuenta);

        CuentaResponse result = cuentaService.crearCuenta(cuentaRequest);

        assertNotNull(result);
        assertEquals("1234567890", result.numeroCuenta());
        verify(cuentaRepository, times(1)).save(any(Cuenta.class));
    }

    @Test
    @DisplayName("crearCuenta - debe lanzar excepción cuando número de cuenta ya existe")
    void testCrearCuentaNumeroDuplicado() {
        when(cuentaRepository.existsByNumeroCuenta(cuentaRequest.getNumeroCuenta())).thenReturn(true);

        assertThrows(InvalidDataException.class, () -> {
            cuentaService.crearCuenta(cuentaRequest);
        });
        verify(cuentaRepository, never()).save(any(Cuenta.class));
    }

    @Test
    @DisplayName("crearCuenta - debe lanzar excepción cuando cliente ya tiene cuenta")
    void testCrearCuentaClienteDuplicado() {
        when(cuentaRepository.existsByNumeroCuenta(cuentaRequest.getNumeroCuenta())).thenReturn(false);
        when(cuentaRepository.existsByClienteId(cuentaRequest.getClienteId())).thenReturn(true);

        assertThrows(InvalidDataException.class, () -> {
            cuentaService.crearCuenta(cuentaRequest);
        });
        verify(cuentaRepository, never()).save(any(Cuenta.class));
    }

    @Test
    @DisplayName("crearCuenta - debe lanzar excepción cuando datos inválidos")
    void testCrearCuentaDatosInvalidos() {
        cuentaRequest.setNumeroCuenta(null);

        assertThrows(InvalidDataException.class, () -> {
            cuentaService.crearCuenta(cuentaRequest);
        });
        verify(cuentaRepository, never()).save(any(Cuenta.class));
    }

    @Test
    @DisplayName("actualizarCuenta - debe actualizar cuenta existente")
    void testActualizarCuenta() {
        when(cuentaRepository.findById(cuentaId)).thenReturn(Optional.of(cuenta));
        when(cuentaRepository.save(any(Cuenta.class))).thenReturn(cuenta);

        CuentaResponse result = cuentaService.actualizarCuenta(cuentaId, cuentaRequest);

        assertNotNull(result);
        verify(cuentaRepository, times(1)).findById(cuentaId);
        verify(cuentaRepository, times(1)).save(any(Cuenta.class));
    }

    @Test
    @DisplayName("actualizarCuenta - debe lanzar excepción cuando cuenta no existe")
    void testActualizarCuentaNoExistente() {
        UUID idInexistente = UUID.randomUUID();
        when(cuentaRepository.findById(idInexistente)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            cuentaService.actualizarCuenta(idInexistente, cuentaRequest);
        });
        verify(cuentaRepository, never()).save(any(Cuenta.class));
    }

    @Test
    @DisplayName("eliminarCuenta - debe eliminar cuenta existente")
    void testEliminarCuenta() {
        when(cuentaRepository.findById(cuentaId)).thenReturn(Optional.of(cuenta));
        doNothing().when(cuentaRepository).delete(cuenta);

        cuentaService.eliminarCuenta(cuentaId);

        verify(cuentaRepository, times(1)).findById(cuentaId);
        verify(cuentaRepository, times(1)).delete(cuenta);
    }

    @Test
    @DisplayName("eliminarCuenta - debe lanzar excepción cuando cuenta no existe")
    void testEliminarCuentaNoExistente() {
        UUID idInexistente = UUID.randomUUID();
        when(cuentaRepository.findById(idInexistente)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            cuentaService.eliminarCuenta(idInexistente);
        });
        verify(cuentaRepository, never()).delete(any(Cuenta.class));
    }
}