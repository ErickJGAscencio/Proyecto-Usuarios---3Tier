markdown
# 🧩 Proyecto Usuarios — Arquitectura 3-Tier con Spring Boot

Este proyecto implementa una arquitectura de tres capas (3-Tier) utilizando **Spring Boot**, **Spring Data JPA**, y **Oracle Database**, con una API RESTful para la gestión de usuarios y sus mascotas.

---

## 🏗️ Arquitectura

[ Cliente (Postman / Frontend React) ] 
   ↓ 
[ Controlador REST (Spring Boot) ]
   ↓
[ Servicio (Lógica de negocio) ] 
   ↓ 
[ Repositorio (Spring Data JPA) ]
   ↓ 
[ Oracle DB ]


---

## 📦 Tecnologías utilizadas

- ⚙️ Spring Boot 3.x
- 🗃️ Spring Data JPA
- 🐘 Oracle Database
- ☕ Java 17+
- 🧪 Postman (para pruebas)
- 🌐 RESTful API
- 🛠️ Maven o Gradle

---

## 📁 Estructura del proyecto

src/ 
├── controller/ 
│ └── UsuarioController.java 
├── service/ 
│ └── UsuarioService.java 
├── repository/ 
│ └── UsuarioRepository.java 
├── entity/ 
│ ├── Usuario.java 
│ └── Mascota.java 
├── dto/ 
│ └── UsuarioDto.java 
└── ProyectoUsuariosApplication.java


---

## 🚀 Endpoints principales

| Método | Endpoint               | Descripción                        |
|--------|------------------------|------------------------------------|
| GET    | `/usuarios`            | Listar todos los usuarios          |
| POST   | `/usuarios`            | Crear un nuevo usuario             |
| GET    | `/mascotas`            | Listar todas las mascotas          |
| POST   | `/mascotas`            | Crear una nueva mascota            |
| GET    | `/usuarios/{id}/mascotas` | Obtener mascotas por usuario     |

---

## 🧪 Cómo probar

1. Asegúrate de tener Oracle corriendo y configurado.
2. Ejecuta la aplicación con `mvn spring-boot:run` o desde tu IDE.
3. Usa Postman para probar los endpoints.
4. Ejemplo de `POST /mascotas`:

```json
{
  "nombre": "Firulais",
  "edad": 3,
  "usuarioId": 1
}
