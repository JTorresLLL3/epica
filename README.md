# Practica: Épicas Spring Boot y Flujo Colaborativo Git / GitHub

> **Universidad Tecnológica de Chihuahua (UTCH)**  
> **Asignatura:** Desarrollo Web Integral  
> **Profesor:** Instructor de la Materia  
> **Proyecto:** Desarrollo de Épicas en Spring Boot y Gestión de Flujo Git Profesional  
> **Entregables:** Repositorio en GitHub con fusión remota de ramas, historias de usuario, `README.md` y capturas del proceso.

---

## 👥 Integrantes del Equipo (5 Personas)

| Integrante | Rol / Responsabilidad | Asignación Principales |
| :--- | :--- | :--- |
| **Integrante 1** | Developer | **Épica 1 - HU 1.1:** Registro de Avistamientos de Fauna Silvestre (`POST /api/avistamientos`) |
| **Integrante 2** | Developer | **Épica 1 - HU 1.2:** Consulta de Avistamientos Registrados (`GET /api/avistamientos`) |
| **Integrante 3** | Developer | **Épica 3 - HU 3.1:** Registro / Publicación de Reseñas de Libros (`POST /api/resenas`) |
| **Integrante 4** | Developer | **Épica 3 - HU 3.2:** Consulta de Reseñas por Libro / Título (`GET /api/resenas`) |
| **Integrante 5** | Lead / DevSecOps | Inicialización del proyecto Spring Boot, `.gitconfig`, README, Pruebas y Cherry-Pick Hotfix |

---

## 📋 Épicas Seleccionadas

Se analizaron las 7 épicas del documento de requerimientos y se seleccionaron las **dos épicas más sencillas y ágiles**:

### 1. Épica 1: Sistema de Registro y Consulta de Avistamientos de Fauna Silvestre
Plataforma para que investigadores y guardabosques registren avistamientos de animales en reservas naturales y consulten el historial de registros filtrados.
* **Tecnologías:** Java 21, Spring Boot 3, Spring Data JPA, H2 Database.

### 2. Épica 3: Plataforma de Inserción y Consulta de Reseñas de Libros
Servicio web donde los lectores pueden publicar reseñas y calificaciones de libros leídos, así como consultar las opiniones existentes por título o autor.
* **Tecnologías:** Java 21, Spring Boot 3, Spring Data JPA, H2 Database.

---

## 📖 Historias de Usuario (HU) y Criterios de Aceptación

### 🟢 Épica 1 - Fauna Silvestre

#### HU 1.1: Registrar Avistamiento de Fauna Silvestre
* **Como:** Guardabosques / Investigador
* **Quiero:** Registrar un nuevo avistamiento de fauna silvestre indicando especie, ubicación geográfica, fecha y observaciones.
* **Para:** Mantener un historial detallado de la fauna en la reserva natural.
* **Criterios de Aceptación:**
  1. El endpoint `POST /api/avistamientos` recibe especie, ubicación, fecha y observaciones.
  2. Los campos `especie`, `ubicacionGeografica` y `fechaAvistamiento` son obligatorios.
  3. Retorna un código HTTP `201 Created` con el DTO del avistamiento y su `id` generado.

#### HU 1.2: Consultar Avistamientos Registrados
* **Como:** Investigador
* **Quiero:** Consultar la lista completa de avistamientos o filtrados por especie.
* **Para:** Analizar patrones de avistamiento y distribución de especies.
* **Criterios de Aceptación:**
  1. El endpoint `GET /api/avistamientos` retorna la lista completa de avistamientos registrados.
  2. Permite filtrar mediante el parámetro opcional `GET /api/avistamientos?especie=Jaguar`.
  3. Retorna un código HTTP `200 OK` con un array JSON de avistamientos.

---

### 🔵 Épica 3 - Reseñas de Libros

#### HU 3.1: Publicar Reseña de Libro
* **Como:** Lector
* **Quiero:** Publicar una reseña indicando título del libro, autor, comentario y una puntuación de 1 a 5 estrellas.
* **Para:** Compartir mi opinión con la comunidad de lectores.
* **Criterios de Aceptación:**
  1. El endpoint `POST /api/resenas` valida que la puntuación esté en el rango de 1 a 5.
  2. Asigna automáticamente la fecha y hora de publicación (`fechaPublicacion`).
  3. Retorna un código HTTP `201 Created` con el objeto de la reseña creada.

#### HU 3.2: Consultar Reseñas asociadas a un Libro
* **Como:** Visitante
* **Quiero:** Consultar las reseñas existentes por título o autor del libro.
* **Para:** Tomar una decisión informada sobre qué libro leer a continuación.
* **Criterios de Aceptación:**
  1. El endpoint `GET /api/resenas` retorna todas las reseñas registradas.
  2. Permite filtrar por título mediante `GET /api/resenas?tituloLibro=Cien Años`.
  3. Retorna código HTTP `200 OK`.

---

## 🔀 Documentación del Flujo de Trabajo Git / GitHub

A continuación se ilustra y documenta el proceso seguido por el equipo de 5 integrantes.

### Paso 1: Configuración Global/Local de Git (`.gitconfig`)
Cada integrante del equipo configuró su identidad local en `.gitconfig` antes de realizar commits.

```bash
git config --global user.name "Nombre Integrante"
git config --global user.email "integrante@utch.edu.mx"
git config --list
```

> **Evidencia:**  
> ![Captura 1: Configuración de .gitconfig](screenshots/01_git_config.png)

---

### Paso 2: Inicialización del Repositorio y Commit Inicial
Se inicializó el repositorio local con la estructura base Spring Boot y la rama `main`.

```bash
git init
git add .
git commit -m "feat: estructura base del proyecto Spring Boot y configuracion inicial"
git branch -M main
git remote add origin https://github.com/usuario/epica-utch.git
git push -u origin main
```

> **Evidencia:**  
> ![Captura 2: Inicialización del Repositorio](screenshots/02_git_init.png)

---

### Paso 3: Creación de Ramas por Feature para cada Integrante
Cada integrante creó su rama de trabajo siguiendo la nomenclatura `feature/hu-X.Y-descripcion`:

* **Integrante 1:** `git checkout -b feature/hu-1.1-registro-avistamiento`
* **Integrante 2:** `git checkout -b feature/hu-1.2-consulta-avistamiento`
* **Integrante 3:** `git checkout -b feature/hu-3.1-publicar-resena`
* **Integrante 4:** `git checkout -b feature/hu-3.2-consultar-resenas`
* **Integrante 5:** `git checkout -b feature/hotfix-validacion-dto`

```bash
git checkout -b feature/hu-1.1-registro-avistamiento
git branch -a
```

> **Evidencia:**  
> ![Captura 3: Creación de Ramas](screenshots/03_git_branches.png)

---

### Paso 4: Despliegue de Código y Commits Específicos
Cada integrante desarrolló su módulo correspondiente y realizó commits descriptivos:

```bash
git add .
git commit -m "feat(avistamiento): implementar modelo, repository y DTO para HU 1.1"
git push origin feature/hu-1.1-registro-avistamiento
```

> **Evidencia:**  
> ![Captura 4: Commits Locales y Push](screenshots/04_git_commits.png)

---

### Paso 5: Apertura de Pull Requests (PR) en GitHub
En la plataforma remota GitHub se abrieron las Pull Requests asociadas a cada historia de usuario solicitando la revisión de código por parte del equipo.

> **Evidencia:**  
> ![Captura 5: Pull Requests Creados en GitHub](screenshots/05_pull_requests.png)

---

### Paso 6: Revisión de Código y Fusión Remota (Merge Remote)
Siguiendo las buenas prácticas, la fusión de ramas se realizó **exclusivamente en remoto** mediante la interfaz de GitHub (`Merge Pull Request`), garantizando la integridad de la rama `main`.

> **Evidencia:**  
> ![Captura 6: Fusión Remota de Pull Requests](screenshots/06_remote_merge.png)

---

### Paso 7: Fusión Selectiva de Commits (`git cherry-pick`)
Para demostrar la capacidad de seleccionar y fusionar commits específicos entre ramas sin integrar toda la rama de desarrollo, se realizó un `git cherry-pick`:

1. Se creó un commit de corrección urgente en la rama `feature/hotfix-validacion-dto` (Hash: `a1b2c3d` por ejemplo).
2. Se extrajo únicamente dicho commit hacia `main`:

```bash
git checkout main
git pull origin main
git cherry-pick <hash_del_commit_especifico>
git push origin main
```

> **Evidencia:**  
> ![Captura 7: Aplicación de Cherry-Pick](screenshots/07_cherry_pick.png)

---

### Paso 8: Verificación Final y Ejecución de Pruebas Automatizadas
Se ejecutó la suite de pruebas unitarias e integración en Spring Boot para validar que los endpoints de ambas épicas funcionan correctamente.

```bash
mvn clean test
```

> **Evidencia:**  
> ![Captura 8: Pruebas Automatizadas Exitosas](screenshots/08_maven_tests.png)

---

## 🛠️ Cómo Ejecutar el Proyecto Localmente

### Requisitos Previos
* Java JDK 21+ instalado.
* Apache Maven 3.9+ instalado.
* Git.

### Instrucciones
1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/usuario/epica-utch.git
   cd epica-utch
   ```
2. **Compilar y probar el proyecto:**
   ```bash
   mvn clean test
   ```
3. **Iniciar la aplicación:**
   ```bash
   mvn spring-boot:run
   ```
4. **Acceso a la Consola H2 Database:**
   * URL: `http://localhost:8080/h2-console`
   * JDBC URL: `jdbc:h2:mem:epicadb`
   * Usuario: `sa`
   * Contraseña: *(Vacío)*

---

## 📌 Enlaces del Entregable

* **URL del Repositorio Remoto en GitHub:** `https://github.com/usuario/epica-utch`
