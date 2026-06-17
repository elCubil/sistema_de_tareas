✅ Sistema de Gestión de Tareas

Aplicación backend desarrollada con Spring Boot para administrar tareas mediante una API REST.

El proyecto implementa operaciones CRUD, persistencia en base de datos y una arquitectura por capas utilizada comúnmente en aplicaciones empresariales.

********************************************************************************
📌 Objetivo

Construir una API REST profesional para gestionar tareas y demostrar conocimientos de:

Desarrollo Backend
APIs REST
Spring Boot
Persistencia de datos
Arquitectura en capas
Buenas prácticas de desarrollo
********************************************************************************

Arquitectura
Cliente
   │
   ▼
REST Controller
   │
   ▼
Service Layer
   │
   ▼
Repository Layer
   │
   ▼
Database

La separación por capas permite mantener el código desacoplado, escalable y fácil de mantener.

********************************************************************************

🛠 Tecnologías
Java
Spring Boot
Spring Data JPA
Hibernate
Maven
SQL
Git/GitHub

********************************************************************************
Estructura del Proyecto
src
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 └── config
Controller

Expone los endpoints REST.

Service

Contiene la lógica de negocio.

Repository

Gestiona el acceso a datos mediante Spring Data JPA.

Entity

Representa las tablas de la base de datos.

********************************************************************************

Funcionalidades
Crear tarea
POST /tasks
Obtener tareas
GET /tasks
Obtener tarea por ID
GET /tasks/{id}
Actualizar tarea
PUT /tasks/{id}
Eliminar tarea
DELETE /tasks/{id}
********************************************************************************
🗄 Modelo de Datos

Ejemplo de entidad Task:

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    private String status;
}

🧪 Ejecución Local
Clonar repositorio
git clone https://github.com/elCubil/sistema_de_tareas.git
Compilar
mvn clean install
Ejecutar
mvn spring-boot:run

La API quedará disponible en:

http://localhost:8080
********************************************************************************

📖 Ejemplo de Flujo
Crear una tarea.
Consultar tareas existentes.
Actualizar estado de una tarea.
Eliminar una tarea completada.

********************************************************************************

Habilidades Demostradas

Este proyecto demuestra experiencia en:

Java Backend
Spring Boot
APIs REST
Arquitectura en Capas
Spring Data JPA
Hibernate
Diseño CRUD
SQL
Maven
Git
