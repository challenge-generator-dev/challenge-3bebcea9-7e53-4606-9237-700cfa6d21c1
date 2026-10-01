package com.banca.cuentas.controller;


import com.banca.cuentas.model.Cuenta;
import com.banca.cuentas.dto.CuentaRequest;
import com.banca.cuentas.dto.CuentaResponse;
import com.banca.cuentas.exception.InvalidDataException;
import com.banca.cuentas.exception.ResourceNotFoundException;
import com.banca.cuentas.service.CuentaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CuentaController.class)
class CuentaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CuentaService cuentaService;

    private UUID cuentaId;
    private CuentaResponse cuentaResponse;
    private CuentaRequest cuentaRequest;

    @BeforeEach
    void setUp() {
        cuentaId = UUID.randomUUID();
        cuentaResponse = new CuentaResponse(
                cuentaId,
                "1234567890",
                UUID.randomUUID(),
                "AHORROS",
                new BigDecimal("1000.00"),
                LocalDateTime.now(),
                "ACTIVA",
                "SUCURSAL_CENTRAL",
                0
        );
        cuentaRequest = new CuentaRequest();
        cuentaRequest.setNumeroCuenta("1234567890");
        cuentaRequest.setClienteId(UUID.randomUUID());
        cuentaRequest.setTipoCuenta("AHORROS");
        cuentaRequest.setSaldoInicial(new BigDecimal("1000.00"));
        cuentaRequest.setSucursal("SUCURSAL_CENTRAL");
        cuentaRequest.setEstado("ACTIVA");
    }

    @Test
    @DisplayName("GET /api/cuentas - debe retornar todas las cuentas")
    void testGetAllCuentas() throws Exception {
        List<CuentaResponse> cuentas = Arrays.asList(cuentaResponse);
        when(cuentaService.obtenerTodasLasCuentas()).thenReturn(cuentas);

        mockMvc.perform(get("/api/cuentas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].numeroCuenta").value("1234567890"));
    }

    @Test
    @DisplayName("GET /api/cuentas/{id} - debe retornar cuenta por ID")
    void testGetCuentaById() throws Exception {
        when(cuentaService.obtenerCuentaPorId(cuentaId)).thenReturn(cuentaResponse);

        mockMvc.perform(get("/api/cuentas/{id}", cuentaId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cuentaId.toString()))
                .andExpect(jsonPath("$.numeroCuenta").value("1234567890"));
    }

    @Test
    @DisplayName("GET /api/cuentas/{id} - debe retornar 404 cuando no existe")
    void testGetCuentaByIdNotFound() throws Exception {
        UUID idInexistente = UUID.randomUUID();
        when(cuentaService.obtenerCuentaPorId(idInexistente))
                .thenThrow(new ResourceNotFoundException("Cuenta no encontrada con ID: " + idInexistente));

        mockMvc.perform(get("/api/cuentas/{id}", idInexistente))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /api/cuentas - debe crear una cuenta exitosamente")
    void testCrearCuenta() throws Exception {
        when(cuentaService.crearCuenta(any(CuentaRequest.class))).thenReturn(cuentaResponse);

        mockMvc.perform(post("/api/cuentas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cuentaRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(cuentaId.toString()))
                .andExpect(jsonPath("$.numeroCuenta").value("1234567890"));
    }

    @Test
    @DisplayName("POST /api/cuentas - debe retornar 400 cuando datos inválidos")
    void testCrearCuentaInvalidData() throws Exception {
        when(cuentaService.crearCuenta(any(CuentaRequest.class)))
                .thenThrow(new InvalidDataException("El número de cuenta es obligatorio"));

        mockMvc.perform(post("/api/cuentas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cuentaRequest)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("PUT /api/cuentas/{id} - debe actualizar una cuenta")
    void testActualizarCuenta() throws Exception {
        when(cuentaService.actualizarCuenta(eq(cuentaId), any(CuentaRequest.class)))
                .thenReturn(cuentaResponse);

        mockMvc.perform(put("/api/cuentas/{id}", cuentaId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cuentaRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cuentaId.toString()));
    }

    @Test
    @DisplayName("DELETE /api/cuentas/{id} - debe eliminar una cuenta")
    void testEliminarCuenta() throws Exception {
        mockMvc.perform(delete("/api/cuentas/{id}", cuentaId))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("DELETE /api/cuentas/{id} - debe retornar 404 cuando no existe para eliminar")
    void testEliminarCuentaNotFound() throws Exception {
        UUID idInexistente = UUID.randomUUID();
        doThrow(new ResourceNotFoundException("Cuenta no encontrada con ID: " + idInexistente))
                .when(cuentaService).eliminarCuenta(idInexistente);

        mockMvc.perform(delete("/api/cuentas/{id}", idInexistente))
                .andExpect(status().isNotFound());
    }
}