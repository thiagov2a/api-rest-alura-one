<h4 align="center">
  🎓 Alura + ONE
</h4>

<h1 align="center">
  🏥 VollMed
</h1>

<p align="center">
  Este documento proporciona una visión detallada del desarrollo y la documentación del proyecto VollMed API, parte del curso de API REST con Spring Boot del programa Alura + ONE.
</p>

## 📝 Descripción del Proyecto

VollMed es una API REST desarrollada con Spring Boot que gestiona pacientes y médicos en un contexto médico. La API ofrece endpoints para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los registros de pacientes y médicos, así como para agendar consultas médicas. El sistema está diseñado para proporcionar una solución robusta y escalable para la gestión de datos médicos.

## 📋 Funcionalidades

- **Gestión de Pacientes**: CRUD sobre los registros de pacientes.
- **Gestión de Médicos**: CRUD sobre los registros de médicos, incluyendo su especialidad.
- **Agenda de Consultas**: Facilita el agendamiento de consultas médicas entre pacientes y médicos.
- **Documentación de API**: Endpoints documentados para facilitar la integración y uso.
- **Base de Datos**: Utiliza MySQL para almacenar toda la información relacionada con pacientes, médicos y consultas.
- **Pruebas**: Incluye pruebas unitarias y de integración para asegurar la calidad del API.

## 📁 Estructura del Proyecto

- **`src/main/java/med/voll/api`**: Contiene el código fuente de la API, dividido en:
  - **`controller`**: Controladores REST que manejan las solicitudes HTTP.
  - **`domain`**: Modelos de datos y servicios relacionados.
  - **`infra`**: Implementaciones de acceso a datos y configuración adicional.
- **`src/main/resources`**: Archivos de configuración, incluyendo:
  - **`application.properties`**: Configuración de la base de datos y propiedades de la aplicación.
- **`src/test/java/med/voll/api`**: Contiene pruebas unitarias y de integración.
- **`pom.xml`**: Archivo de configuración de Maven que gestiona las dependencias del proyecto.

## 🚀 Cómo Ejecutar el Proyecto

1. **Clonar el Repositorio**: `git clone https://github.com/thiagov2a/api-rest-alura-one.git`
2. **Navegar al Directorio**: `cd api-rest-alura-one`
3. **Configurar la Base de Datos**: Asegúrate de que MySQL esté instalado y corriendo, y que la base de datos esté configurada.
4. **Ejecutar el Proyecto**: Utiliza un IDE compatible (como IntelliJ IDEA o Eclipse) para compilar y ejecutar la aplicación. Verifica que las configuraciones en `src/main/resources/application.properties` estén correctas.

## 🛠 Tecnologías Utilizadas

- **Java**: 💻 Lenguaje de programación principal.
- **Spring Boot**: 🚀 Framework para construir la API REST.
- **Maven**: 📦 Sistema de gestión de proyectos y dependencias.
- **MySQL**: 🗄️ Sistema de gestión de bases de datos.
- **JWT**: 🔐 Mecanismo de autenticación basado en tokens.
- **JUnit**: 🧪 Herramienta para pruebas unitarias.

## 🔧 Pruebas

Para probar la API REST, puedes utilizar herramientas como [Insomnia](https://insomnia.rest) o [Postman](https://www.postman.com). Asegúrate de autenticarte utilizando un token JWT válido para realizar operaciones que requieran autenticación, como crear, actualizar o eliminar tópicos.

<p align="center">
  Alura + ONE | VollMed
</p>
