# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Desarrollo de API REST para gestión de cuentas bancarias**.

| | |
|---|---|
| Tema | desarrollo de API REST en entorno de banca |
| Nivel | junior-l1 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.4 |
| Patron arquitectonico | capas estándar |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web 3.4.0
- org.springframework.boot:spring-boot-starter-data-jpa 3.4.0
- org.springframework.boot:spring-boot-starter-validation 3.4.0
- org.springdoc:springdoc-openapi-starter-webmvc-ui 2.6.0
- com.h2database:h2 2.3.230
- org.projectlombok:lombok 1.18.34
- org.springframework.boot:spring-boot-starter-test 3.4.0

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Definición de los endpoints y modelos de datos**: Documento que describa los endpoints y modelos de datos definidos.
- **Fase 2 — Implementación de los endpoints y persistencia de datos**: Código fuente que implementa los endpoints y persistencia de datos.
- **Fase 3 — Generación de documentación OpenAPI**: Documentación OpenAPI generada para la API REST.
- **Fase 4 — Revisión y optimización del código**: Código fuente optimizado y mejorado.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Referencias colgando (24)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/banca/cuentas/CuentasApplication.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.models.OpenAPI pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/banca/cuentas/dto/CuentaResponse.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/banca/cuentas/controller/CuentaController.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/banca/cuentas/config/OpenApiConfig.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.models.OpenAPI pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/banca/cuentas/controller/CuentaControllerTest.java` — `com.fasterxml.jackson`
      El import com.fasterxml.jackson.databind.ObjectMapper pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/banca/cuentas/service/CuentaService.java` — `CuentaRepository.save`
      Se invoca `save` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/cuentas/service/CuentaService.java` — `CuentaRepository.findAll`
      Se invoca `findAll` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/cuentas/service/CuentaService.java` — `CuentaRepository.findById`
      Se invoca `findById` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/cuentas/service/CuentaService.java` — `CuentaRepository.existsById`
      Se invoca `existsById` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/cuentas/service/CuentaService.java` — `CuentaRepository.deleteById`
      Se invoca `deleteById` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java` — `ErrorResponse.setStatus`
      Se invoca `setStatus` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java` — `ErrorResponse.setError`
      Se invoca `setError` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java` — `ErrorResponse.setMessage`
      Se invoca `setMessage` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java` — `ErrorResponse.setPath`
      Se invoca `setPath` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java` — `ErrorResponse.setTimestamp`
      Se invoca `setTimestamp` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java` — `ErrorResponse.setValidationErrors`
      Se invoca `setValidationErrors` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/cuentas/controller/CuentaControllerTest.java` — `CuentaService.obtenerTodasLasCuentas`
      Se invoca `obtenerTodasLasCuentas` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/cuentas/controller/CuentaControllerTest.java` — `CuentaService.obtenerCuentaPorId`
      Se invoca `obtenerCuentaPorId` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/cuentas/service/CuentaServiceTest.java` — `CuentaRepository.findAll`
      Se invoca `findAll` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/cuentas/service/CuentaServiceTest.java` — `CuentaService.obtenerTodasLasCuentas`
      Se invoca `obtenerTodasLasCuentas` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/cuentas/service/CuentaServiceTest.java` — `CuentaRepository.findById`
      Se invoca `findById` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/cuentas/service/CuentaServiceTest.java` — `CuentaService.obtenerCuentaPorId`
      Se invoca `obtenerCuentaPorId` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/cuentas/service/CuentaServiceTest.java` — `CuentaRepository.save`
      Se invoca `save` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (15)

- `pom.xml`
- `src/main/java/com/banca/cuentas/CuentasApplication.java`
- `src/main/resources/application.properties`
- `src/main/java/com/banca/cuentas/repository/CuentaRepository.java`
- `src/main/java/com/banca/cuentas/model/Cuenta.java`
- `src/main/java/com/banca/cuentas/dto/CuentaRequest.java`
- `src/main/java/com/banca/cuentas/dto/CuentaResponse.java`
- `src/main/java/com/banca/cuentas/controller/CuentaController.java`
- `src/main/java/com/banca/cuentas/service/CuentaService.java`
- `src/main/java/com/banca/cuentas/exception/ResourceNotFoundException.java`
- `src/main/java/com/banca/cuentas/exception/InvalidDataException.java`
- `src/main/java/com/banca/cuentas/exception/GlobalExceptionHandler.java`
- `src/main/java/com/banca/cuentas/config/OpenApiConfig.java`
- `src/test/java/com/banca/cuentas/controller/CuentaControllerTest.java`
- `src/test/java/com/banca/cuentas/service/CuentaServiceTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/banca/cuentas`
- `src/main/java/com/banca/cuentas/controller`
- `src/main/java/com/banca/cuentas/service`
- `src/main/java/com/banca/cuentas/repository`
- `src/main/java/com/banca/cuentas/dto`
- `src/main/java/com/banca/cuentas/model`
- `src/main/java/com/banca/cuentas/exception`
- `src/main/java/com/banca/cuentas/config`
- `src/main/resources`
- `src/test/java/com/banca/cuentas`

## Verificacion

```bash
mvn clean compile
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Brecha que el reto ataca: Crear una API REST con Spring Boot, JPA, validación de entidades y documentación OpenAPI

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
