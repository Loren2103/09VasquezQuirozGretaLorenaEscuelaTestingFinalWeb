# Test Automatizado Web SauceDemo

Este proyecto contiene la automatización de pruebas End-to-End (E2E) para la plataforma de comercio electrónico pública [SauceDemo](https://www.saucedemo.com/).

## 1. Prerrequisitos

Antes de ejecutar las pruebas, asegúrate de tener instalado y configurado lo siguiente en tu sistema:
* **Java 17:** El proyecto está configurado para usar Java 17.
* **Apache Maven:** Se utiliza para la gestión de dependencias y la ejecución de las pruebas.
* **Variables de Entorno:**
    * `JAVA_HOME`: Debe apuntar al directorio de instalación de tu JDK 17.
    * `M2_HOME`: Debe apuntar al directorio de instalación de Maven. Asegúrate de que las carpetas `bin` de Java y Maven estén incluidas en la variable `Path` de tu sistema operativo.

## 2. Estructura del Proyecto
El framework utiliza un patrón Data-Driven para separar la lógica de prueba de los datos (payloads).

    src/test/
    ├── java/        
    │   ├── page/               # Mapeo de elementos web y selectores (UI)
    │   ├── runner/             # Clases principales para la ejecución por módulos
    │   ├── stepdefinitions/    # Puente entre los pasos Gherkin y el código Java
    │   └── steps/              # Lógica de negocio, interacciones y aserciones
    └── resources/
        └── features/           # Archivos Gherkin (.feature) organizados por módulo
            ├── Carrito.feature
            ├── CarritoExcepciones.feature
            ├── Checkout.feature
            ├── CheckoutExcepciones.feature
            ├── Login.feature
            ├── Productos.feature
            └── ProductosExcepciones.feature


## 3. Módulos Automatizados

La automatización cubre escenarios exitosos (`@HappyPath`) y escenarios de validación de errores de usuario o defectos del sistema (`@UnhappyPath`) en 4 módulos principales:

* **Login:** Acceso exitoso de usuarios estándar, bloqueo de credenciales inválidas y validación de alertas de seguridad.
* **Productos (Catálogo):** Funcionamiento de filtros de ordenamiento, navegación de detalle y manejo de errores visuales/alertas JS.
* **Carrito de Compras:** Adición/eliminación de ítems, actualización del *badge*, persistencia de sesión y bloqueo de accesos no autorizados.
* **Checkout (Flujo Compra):** Captura de datos de envío, validaciones matemáticas de la orden (Subtotal + Impuestos = Total) y restricciones de campos obligatorios.

## 4. Ejecución

### 4.1 Ejecutar desde IDE
1. Abre el proyecto en tu IDE (IntelliJ IDEA, Eclipse, etc.).
2. Navega hasta la carpeta `src/test/java/runner/`.
3. Haz clic derecho sobre cualquiera de los archivos (ej. `CheckoutRunner.java`) y selecciona **Run**. Esto ejecutará los escenarios de ese módulo y mostrará los resultados en la consola.

### 4.2 Ejecutar desde Terminal (Suite Completa)
Para ejecutar todos los escenarios de todos los módulos y compilar el reporte general, abre la terminal en la raíz del proyecto y ejecuta:
```bash
mvn clean verify
```

### 4.3 Ejecutar por Módulo o Tag específico
Para ejecutar únicamente un grupo de pruebas o un escenario en particular, se debe pasar el parámetro de *tags* de Cucumber a través de Maven.

Ejecutar solo los escenarios exitosos de toda la plataforma:
```bash
mvn clean verify -Dcucumber.filter.tags="@HappyPath"
```

Ejecutar solo los escenarios que validan excepciones o errores:
```bash
mvn clean verify -Dcucumber.filter.tags="@UnhappyPath"
```

Ejecutar un escenario específico (por ejemplo, el flujo de compra completo):
```bash
mvn clean verify -Dcucumber.filter.tags="@FlujoCompraCompleto"
```