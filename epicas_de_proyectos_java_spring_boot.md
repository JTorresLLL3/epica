# Épicas de Proyectos para Java y Spring Boot (Consultas e Inserciones sin Transacciones)


## Épica 1: Sistema de Registro y Consulta de Avistamientos de Fauna Silvestre
* **Descripción:** Una plataforma para que investigadores y guardabosques registren nuevos avistamientos de animales en reservas naturales y consulten el historial de registros filtrados por especie, zona o fecha.
* **Tecnologías:** Spring Boot, Spring Data JPA, H2 o PostgreSQL.
* **Historias de Usuario Sugeridas:**
  1. Como usuario, quiero registrar un nuevo avistamiento indicando especie, ubicación geográfica, fecha y observaciones.
  2. Como investigador, quiero consultar todos los avistamientos registrados.

## Épica 2: Registro de Bitácoras de Mantenimiento de Maquinaria
* **Descripción:** Aplicación orientada a plantas industriales para registrar las intervenciones diarias realizadas a la maquinaria y permitir la consulta rápida de historiales de fallas o servicios previos.
* **Tecnologías:** Spring Boot, Spring Data JPA, MySQL.
* **Historias de Usuario Sugeridas:**
  1. Como técnico, quiero registrar una nueva orden de mantenimiento completada (equipo, descripción, técnico responsable, fecha).
  2. Como supervisor, quiero consultar el historial de mantenimientos realizados a una máquina específica mediante su número de serie.
  3. Como gerente, quiero consultar todas las bitácoras ingresadas en el turno actual.

## Épica 3: Plataforma de Inserción y Consulta de Reseñas de Libros
* **Descripción:** Un servicio web donde los lectores pueden publicar reseñas y calificaciones de libros leídos, así como consultar las opiniones existentes por título o autor.
* **Tecnologías:** Spring Boot, Spring Data JPA, PostgreSQL.
* **Historias de Usuario Sugeridas:**
  1. Como lector, quiero publicar una reseña con título, comentario, puntuación (1-5) y nombre del autor del libro.
  2. Como visitante, quiero consultar todas las reseñas asociadas a un libro específico.

## Épica 4: Catálogo de Productos y Registro de Solicitudes de Cotización
* **Descripción:** Un sistema ligero de e-commerce enfocado únicamente en mostrar un catálogo de productos enriquecido y permitir a los clientes potenciales registrar solicitudes de cotización.
* **Tecnologías:** Spring Boot, Spring Data JPA, H2.
* **Historias de Usuario Sugeridas:**
  1. Como administrador, quiero registrar nuevos productos en el catálogo con su nombre, descripción, categoría y precio base.
  2. Como cliente, quiero consultar el listado completo de productos.

## Épica 5: Sistema de Registro de Lecturas de Sensores IoT (Telemetría Básica)
* **Descripción:** Una API backend diseñada para recibir flujos de datos enviados por sensores ambientales (temperatura, humedad) y almacenarlos, permitiendo consultar lecturas pasadas y estadísticas básicas de consulta.
* **Tecnologías:** Spring Boot, Spring Data JPA, PostgreSQL.
* **Historias de Usuario Sugeridas:**
  1. Como dispositivo IoT, quiero enviar e insertar un registro de telemetría con el ID del sensor, valor medido y marca de tiempo.
  2. Como operador, quiero consultar las lecturas registradas de un sensor en particular.

## Épica 6: Registro de Asistencia a Eventos Académicos
* **Descripción:** Una herramienta para registrar el ingreso de asistentes a seminarios o talleres mediante códigos de identificación y consultar listas de asistencia en tiempo real.
* **Tecnologías:** Spring Boot, Spring Data JPA, MySQL.
* **Historias de Usuario Sugeridas:**
  1. Como organizador, quiero registrar la asistencia de un participante escaneando o ingresando su código de acreditación y el ID del evento.
  2. Como coordinador, quiero consultar la lista completa de asistentes que han ingresado a un taller específico.

## Épica 7: Directorio de Proveedores y Registro de Facturas Recibidas
* **Descripción:** Un sistema administrativo para mantener un directorio de proveedores comerciales y registrar los metadatos de las facturas que la empresa va recibiendo para su futura revisión.
* **Tecnologías:** Spring Boot, Spring Data JPA, PostgreSQL.
* **Historias de Usuario Sugeridas:**
  1. Como auxiliar contable, quiero registrar un nuevo proveedor indicando su RFC, Razón Social y categoría.
  2. Como recepcionista, quiero registrar una nueva factura recibida asociándola al ID del proveedor, número de factura, monto total y fecha de recepción.
  3. Como auditor, quiero consultar todas las facturas registradas de un proveedor específico.
