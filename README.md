# NovaCenter App 🩺📲

Una aplicación Android nativa para gestión de turnos médicos, diseñada para brindar una experiencia intuitiva, segura y fluida tanto para pacientes como para el personal del centro de salud.

---

## 🚀 Instrucciones de funcionamiento

### ▶️ Requisitos previos
- Android Studio Electric Eel o superior
- Kotlin 1.8+
- Emulador o dispositivo físico con Android API 26+
- Acceso a internet

### 🔧 Cómo ejecutar la app

1. Clonar el proyecto:  
   `git clone https://github.com/tu_usuario/novacenter.git`

2. Abrir el proyecto con Android Studio

3. Configurar el archivo `baseUrl` en `RetrofitInstance.kt` si tu endpoint está hosteado localmente o remotamente

4. Ejecutar en un emulador o dispositivo físico

---

## 🧪 Funcionalidades implementadas

- ✅ Login con usuario y contraseña
- ✅ Almacenamiento seguro de token con `SharedPreferences`
- ✅ Listado de usuarios (o pacientes) desde API
- ✅ Detalle de información individual
- ✅ Alta de turnos a través de formulario
- ✅ Validación de campos de entrada
- ✅ Manejo de errores en red con feedback visual
- ✅ UI adaptable a múltiples pantallas (`ConstraintLayout`)
- ✅ Patrón MVVM aplicado correctamente

---

## 🛠️ Herramientas y tecnologías

| Tecnología | Descripción |
|------------|-------------|
| **Kotlin** | Lenguaje principal |
| **MVVM** | Patrón de arquitectura |
| **Retrofit** | Cliente HTTP para consumir API REST |
| **Coroutines + viewModelScope** | Ejecución asincrónica sin bloquear UI |
| **SharedPreferences** | Almacenamiento local del token de autenticación |
| **StateFlow** | Manejo reactivo de estado |
| **Material Components** | Diseño limpio y consistente |
| **ViewBinding** | Acceso seguro a vistas en XML |

---

## 📱 Escenario funcional

La app representa un sistema móvil de turnos médicos para un centro llamado **NovaCenter**. El flujo principal es el siguiente:

1. El usuario se loguea con su usuario y contraseña.
2. Si es autenticado, se guarda un token en el dispositivo.
3. Desde allí puede:
   - Ver el listado de usuarios o turnos disponibles.
   - Solicitar un nuevo turno seleccionando especialidad, médico, fecha y horario.
   - Visualizar detalles personales o de otro recurso.
4. La navegación es simple y clara, adaptada al uso desde dispositivos móviles.

---

## ⭐ Bonus implementado

- ✔️ Validaciones de formularios con mensajes visuales
- ✔️ Manejo de errores en ViewModel y presentación en pantalla
- ✔️ Diseño responsive (`ConstraintLayout`, márgenes en dp, textos en sp)
- ✔️ Código modular, con separación de responsabilidades clara

---

## 👩‍💻 Autoras

- **Delfina Avalos**
- **Juana Martínez**
- **Tatiana Medina**


