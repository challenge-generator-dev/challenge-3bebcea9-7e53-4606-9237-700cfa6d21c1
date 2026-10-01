# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/banca/cuentas/CuentasApplication.java` — `io.swagger.v3`: El import io.swagger.v3.oas.models.OpenAPI pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/banca/cuentas/dto/CuentaResponse.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/banca/cuentas/controller/CuentaController.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/banca/cuentas/config/OpenApiConfig.java` — `io.swagger.v3`: El import io.swagger.v3.oas.models.OpenAPI pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/banca/cuentas/controller/CuentaControllerTest.java` — `com.fasterxml.jackson`: El import com.fasterxml.jackson.databind.ObjectMapper pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/banca/cuentas/service/CuentaService.java` — `CuentaRepository.save`: Se invoca `save` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/cuentas/service/CuentaService.java` — `CuentaRepository.findAll`: Se invoca `findAll` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/cuentas/service/CuentaService.java` — `CuentaRepository.findById`: Se invoca `findById` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/cuentas/service/CuentaService.java` — `CuentaRepository.existsById`: Se invoca `existsById` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/cuentas/service/CuentaService.java` — `CuentaRepository.deleteById`: Se invoca `deleteById` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java` — `ErrorResponse.setStatus`: Se invoca `setStatus` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java` — `ErrorResponse.setError`: Se invoca `setError` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java` — `ErrorResponse.setMessage`: Se invoca `setMessage` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java` — `ErrorResponse.setPath`: Se invoca `setPath` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java` — `ErrorResponse.setTimestamp`: Se invoca `setTimestamp` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java` — `ErrorResponse.setValidationErrors`: Se invoca `setValidationErrors` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/cuentas/controller/CuentaControllerTest.java` — `CuentaService.obtenerTodasLasCuentas`: Se invoca `obtenerTodasLasCuentas` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/cuentas/controller/CuentaControllerTest.java` — `CuentaService.obtenerCuentaPorId`: Se invoca `obtenerCuentaPorId` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/cuentas/service/CuentaServiceTest.java` — `CuentaRepository.findAll`: Se invoca `findAll` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/cuentas/service/CuentaServiceTest.java` — `CuentaService.obtenerTodasLasCuentas`: Se invoca `obtenerTodasLasCuentas` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/cuentas/service/CuentaServiceTest.java` — `CuentaRepository.findById`: Se invoca `findById` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/cuentas/service/CuentaServiceTest.java` — `CuentaService.obtenerCuentaPorId`: Se invoca `obtenerCuentaPorId` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/cuentas/service/CuentaServiceTest.java` — `CuentaRepository.save`: Se invoca `save` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Contexto técnico original
Crear una API REST con Spring Boot, JPA, validación de entidades y documentación OpenAPI

### Reto
- Tema: desarrollo de API REST en entorno de banca
- Seniority: junior-l1
- Tipo: practical
- Título: Desarrollo de API REST para gestión de cuentas bancarias
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición de los endpoints y modelos de datos — objetivo: Definir los endpoints y modelos de datos necesarios para la gestión de cuentas bancarias. — entregable (NO resolver): Documento que describa los endpoints y modelos de datos definidos.
- Fase 2: Implementación de los endpoints y persistencia de datos — objetivo: Implementar los endpoints definidos y persistir los datos en una base de datos. — entregable (NO resolver): Código fuente que implementa los endpoints y persistencia de datos.
- Fase 3: Generación de documentación OpenAPI — objetivo: Generar documentación OpenAPI para la API REST desarrollada. — entregable (NO resolver): Documentación OpenAPI generada para la API REST.
- Fase 4: Revisión y optimización del código — objetivo: Revisar y optimizar el código desarrollado. — entregable (NO resolver): Código fuente optimizado y mejorado.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>
    <groupId>com.banca</groupId>
    <artifactId>cuentas</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>cuentas</name>
    <description>API REST para gestión de cuentas bancarias</description>
    
    <properties>
        <java.version>21</java.version>
    </properties>
    
    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        
        <!-- OpenAPI Documentation -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.6.0</version>
        </dependency>
        
        <!-- Database -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        
        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>
        
        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/banca/cuentas/CuentasApplication.java ===
package com.banca.cuentas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@EnableConfigurationProperties
public class CuentasApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(CuentasApplication.class, args);
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Cuentas Bancarias")
                        .version("1.0")
                        .description("API REST para la gestión de cuentas bancarias en una institución financiera")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
    
    @Bean
    public String initDatabase() {
        return "Base de datos inicializada en memoria con H2";
    }
}

// === ARCHIVO: src/main/resources/application.properties ===
# Configuración del servidor
server.port=8080
server.servlet.context-path=/api/banca

# Configuración de Spring
spring.application.name=cuentas
spring.profiles.active=dev

# Configuración de la base de datos H2
spring.datasource.url=jdbc:h2:mem:bancadb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Configuración de JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Configuración de H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.web-allow-others=true

# Configuración de OpenAPI/Swagger
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.tagsSorter=alpha
springdoc.swagger-ui.operationsSorter=alpha

// === ARCHIVO: src/main/java/com/banca/cuentas/repository/CuentaRepository.java ===
package com.banca.cuentas.repository;

import com.banca.cuentas.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, UUID> {
    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);
    boolean existsByNumeroCuenta(String numeroCuenta);
    Optional<Cuenta> findByClienteId(UUID clienteId);
    boolean existsByClienteId(UUID clienteId);
}

// === ARCHIVO: src/main/java/com/banca/cuentas/model/Cuenta.java ===
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

// === ARCHIVO: src/main/java/com/banca/cuentas/dto/CuentaRequest.java ===
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

// === ARCHIVO: src/main/java/com/banca/cuentas/dto/CuentaResponse.java ===
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

// === ARCHIVO: src/main/java/com/banca/cuentas/controller/CuentaController.java ===
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

// === ARCHIVO: src/main/java/com/banca/cuentas/service/CuentaService.java ===
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

// === ARCHIVO: src/main/java/com/banca/cuentas/exception/ResourceNotFoundException.java ===
package com.banca.cuentas.exception;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;
    
    public ResourceNotFoundException(String message) {
        super(message);
        this.resourceName = null;
        this.fieldName = null;
        this.fieldValue = null;
    }
    
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("El recurso '%s' no fue encontrado con el campo '%s': '%s'", 
                resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
    
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.resourceName = null;
        this.fieldName = null;
        this.fieldValue = null;
    }
    
    public ResourceNotFoundException(String resourceName, UUID id) {
        super(String.format("El recurso '%s' con ID '%s' no fue encontrado", 
                resourceName, id != null ? id.toString() : "null"));
        this.resourceName = resourceName;
        this.fieldName = "id";
        this.fieldValue = id;
    }
    
    public String getResourceName() {
        return resourceName;
    }
    
    public String getFieldName() {
        return fieldName;
    }
    
    public Object getFieldValue() {
        return fieldValue;
    }
}

// === ARCHIVO: src/main/java/com/banca/cuentas/exception/InvalidDataException.java ===
package com.banca.cuentas.exception;

public class InvalidDataException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private final String field;
    private final Object rejectedValue;
    
    public InvalidDataException(String message) {
        super(message);
        this.field = null;
        this.rejectedValue = null;
    }
    
    public InvalidDataException(String message, String field, Object rejectedValue) {
        super(message);
        this.field = field;
        this.rejectedValue = rejectedValue;
    }
    
    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
        this.field = null;
        this.rejectedValue = null;
    }
    
    public InvalidDataException(String field, String message) {
        super(String.format("El campo '%s' tiene datos inválidos: %s", field, message));
        this.field = field;
        this.rejectedValue = null;
    }
    
    public String getField() {
        return field;
    }
    
    public Object getRejectedValue() {
        return rejectedValue;
    }
}

// === ARCHIVO: src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java ===
package com.banca.cuentas.exception;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@Tag(name = "Gestión de Excepciones", description = "Manejador global de excepciones para respuestas HTTP estandarizadas")
public class GlobalExceptionHandler {

    @Operation(summary = "Manejar recurso no encontrado", 
               description = "Procesa las excepciones cuando un recurso solicitado no existe en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .error("Recurso No Encontrado")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Manejar datos inválidos", 
               description = "Procesa las excepciones cuando los datos proporcionados no son válidos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Datos inválidos",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidDataException(
            InvalidDataException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Datos Inválidos")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "Manejar errores de validación", 
               description = "Procesa las excepciones de validación de Spring cuando los datos no cumplen las restricciones")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Error de validación",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        error -> error.getField(),
                        error -> error.getDefaultMessage() != null ? 
                                error.getDefaultMessage() : "Valor inválido",
                        (existing, replacement) -> existing
                ));
        
        StringBuilder messageBuilder = new StringBuilder("Errores de validación: ");
        errors.forEach((field, error) -> 
                messageBuilder.append(String.format("[%s: %s] ", field, error)));
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Error de Validación")
                .message(messageBuilder.toString().trim())
                .path(request.getDescription(false).replace("uri=", ""))
                .timestamp(LocalDateTime.now())
                .validationErrors(errors)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "Manejar excepciones genéricas", 
               description = "Procesa cualquier excepción no manejada específicamente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(
            Exception ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Error Interno del Servidor")
                .message("Ha ocurrido un error inesperado. Por favor, contacte al administrador.")
                .path(request.getDescription(false).replace("uri=", ""))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Schema(description = "Estructura de respuesta de error estandarizada")
    public static class ErrorResponse {
        @Schema(description = "Código de estado HTTP", example = "404")
        private int status;
        
        @Schema(description = "Tipo de error", example = "Recurso No Encontrado")
        private String error;
        
        @Schema(description = "Mensaje descriptivo del error")
        private String message;
        
        @Schema(description = "Ruta de la solicitud que causó el error")
        private String path;
        
        @Schema(description = "Fecha y hora del error")
        private LocalDateTime timestamp;
        
        @Schema(description = "Errores de validación específicos por campo")
        private Map<String, String> validationErrors;

        public static ErrorResponseBuilder builder() {
            return new ErrorResponseBuilder();
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        public Map<String, String> getValidationErrors() {
            return validationErrors;
        }

        public void setValidationErrors(Map<String, String> validationErrors) {
            this.validationErrors = validationErrors;
        }

        public static class ErrorResponseBuilder {
            private int status;
            private String error;
            private String message;
            private String path;
            private LocalDateTime timestamp;
            private Map<String, String> validationErrors = new HashMap<>();

            public ErrorResponseBuilder status(int status) {
                this.status = status;
                return this;
            }

            public ErrorResponseBuilder error(String error) {
                this.error = error;
                return this;
            }

            public ErrorResponseBuilder message(String message) {
                this.message = message;
                return this;
            }

            public ErrorResponseBuilder path(String path) {
                this.path = path;
                return this;
            }

            public ErrorResponseBuilder timestamp(LocalDateTime timestamp) {
                this.timestamp = timestamp;
                return this;
            }

            public ErrorResponseBuilder validationErrors(Map<String, String> validationErrors) {
                this.validationErrors = validationErrors;
                return this;
            }

            public ErrorResponse build() {
                ErrorResponse response = new ErrorResponse();
                response.setStatus(this.status);
                response.setError(this.error);
                response.setMessage(this.message);
                response.setPath(this.path);
                response.setTimestamp(this.timestamp);
                response.setValidationErrors(this.validationErrors);
                return response;
            }
        }
    }
}

// === ARCHIVO: src/main/java/com/banca/cuentas/config/OpenApiConfig.java ===
package com.banca.cuentas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Cuentas Bancarias")
                        .version("1.0.0")
                        .description("""
                                API REST para la gestión de cuentas bancarias.
                                
                                Permite realizar operaciones CRUD sobre cuentas,
                                incluyendo creación, consulta, actualización y eliminación.
                                """)
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("desarrollo@banca.com")
                                .url("https://www.banca.com"))
                        .license(new License()
                                .name("Licencia Proprietaria")
                                .url("https://www.banca.com/licencia")))
                .addTagsItem(new io.swagger.v3.oas.models.tags.Tag()
                        .name("Cuentas")
                        .description("Operaciones sobre cuentas bancarias"));
    }
}

// === ARCHIVO: src/test/java/com/banca/cuentas/controller/CuentaControllerTest.java ===
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

// === ARCHIVO: src/test/java/com/banca/cuentas/service/CuentaServiceTest.java ===
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
```
