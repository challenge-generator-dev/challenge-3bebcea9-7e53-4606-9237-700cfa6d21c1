# Desarrollo de API REST para gestión de cuentas bancarias

En el contexto de una institución financiera, se requiere desarrollar una API REST que gestione las operaciones de cuentas bancarias. La API debe permitir la creación, consulta, actualización y eliminación de cuentas, así como la validación de los datos ingresados. Además, se debe generar documentación OpenAPI para facilitar la comprensión y uso de la API por parte de los desarrolladores.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | desarrollo de API REST en entorno de banca |
| **Nivel** | junior-l1 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición de los endpoints y modelos de datos

**Objetivo:** Definir los endpoints y modelos de datos necesarios para la gestión de cuentas bancarias.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identificar los endpoints necesarios para crear, consultar, actualizar y eliminar cuentas bancarias.
- Definir los modelos de datos que representan una cuenta bancaria, incluyendo atributos como número de cuenta, titular, saldo y tipo de cuenta.
- Establecer las validaciones necesarias para los atributos de los modelos de datos.

**Entregable:** Documento que describa los endpoints y modelos de datos definidos.

<details>
<summary>Pistas de conocimiento</summary>

- Considerar los atributos y relaciones necesarios para representar una cuenta bancaria.
- Investigar las mejores prácticas para la validación de datos en el contexto de una API REST.

</details>

### Fase 2: Implementación de los endpoints y persistencia de datos

**Objetivo:** Implementar los endpoints definidos y persistir los datos en una base de datos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementar los endpoints definidos en la fase anterior utilizando Spring Boot y JPA.
- Configurar la persistencia de datos en una base de datos utilizando JPA.
- Realizar pruebas unitarias para verificar el funcionamiento correcto de los endpoints.

**Entregable:** Código fuente que implementa los endpoints y persistencia de datos.

<details>
<summary>Pistas de conocimiento</summary>

- Investigar las mejores prácticas para la implementación de endpoints en Spring Boot.
- Explorar las opciones de configuración de JPA para la persistencia de datos.

</details>

### Fase 3: Generación de documentación OpenAPI

**Objetivo:** Generar documentación OpenAPI para la API REST desarrollada.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Configurar la generación de documentación OpenAPI para la API REST.
- Verificar que la documentación generada sea completa y precisa.
- Realizar pruebas de integración para asegurar que la API funcione correctamente con la documentación generada.

**Entregable:** Documentación OpenAPI generada para la API REST.

<details>
<summary>Pistas de conocimiento</summary>

- Investigar las mejores prácticas para la generación de documentación OpenAPI.
- Explorar las opciones de configuración de Spring Boot para la generación de documentación OpenAPI.

</details>

### Fase 4: Revisión y optimización del código

**Objetivo:** Revisar y optimizar el código desarrollado.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Revisar el código desarrollado en busca de posibles mejoras y optimizaciones.
- Aplicar patrones de diseño y mejores prácticas para mejorar la calidad del código.
- Realizar pruebas de rendimiento para verificar la eficiencia del código desarrollado.

**Entregable:** Código fuente optimizado y mejorado.

<details>
<summary>Pistas de conocimiento</summary>

- Investigar patrones de diseño y mejores prácticas para la optimización del código.
- Explorar herramientas y técnicas para la medición del rendimiento del código.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es una API REST y cuáles son sus características?
- **paraQueSirve**: ¿Para qué sirve la API REST desarrollada en este reto?
- **comoSeUsa**: ¿Cómo se utilizan los endpoints definidos en la API REST?
- **erroresComunes**: ¿Cuáles son los errores comunes que se pueden encontrar al desarrollar una API REST?
- **queDecisionesImplica**: ¿Qué decisiones implica la generación de documentación OpenAPI para una API REST?

## Criterios de Evaluacion

- Definir correctamente los endpoints y modelos de datos necesarios para la gestión de cuentas bancarias.
- Implementar los endpoints y persistir los datos en una base de datos utilizando Spring Boot y JPA.
- Generar documentación OpenAPI completa y precisa para la API REST.
- Revisar y optimizar el código desarrollado para mejorar su calidad y eficiencia.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
