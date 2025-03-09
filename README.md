## JAVA PROJECT / jdbc connector

Tener instalado JAVA Extension Pack

##### Creación del proyecto

Icono de configuración de VSCode > Paleta de Comandos > Create Java Project > Java: Create Java Project > No build Tools > seleccionar ubicacion y nombre

##### Importando conector jdbc

Pestaña Java Projects del panel izquierdo > opcion añadir en References Libraries > seleccionar conectos MySQL descargado anteriormente (mysql-connector-java-8.0.13.jar) que ahora aparece en las Libraries.

En el metodo main se configura la conexion a la db (App.java).



### Patrón de Diseño DAO (Data  Access Object)

Es una herramienta clave para organizar y separar la lógica de acceso a datos de la lógica de negocio en tus proyectos.

El patrón DAO te permite encapsular la interacción con la base de datos dentro de objetos especializados. Esto no solo simplifica el mantenimiento del código, sino que también mejora la escalabilidad y la claridad de tus aplicaciones.

**Creación de las entidades**
El patrón DAO es un enfoque de diseño que separa la lógica de acceso a datos (como consultas a una base de datos) de la lógica de negocio de la aplicación. Su objetivo principal es encapsular todas las operaciones relacionadas con la base de datos (inserciones, consultas, actualizaciones y eliminaciones) en una clase o conjunto de clases dedicadas, llamadas DAO.

**Beneficios del patrón DAO:**

_Mantenibilidad:_ Al separar la lógica de acceso a datos, los cambios en la base de datos o en las consultas no afectan el resto de la aplicación.

_Reutilización:_ Las operaciones de acceso a datos se centralizan, evitando la duplicación de código.

_Escalabilidad:_ Facilita la adaptación a diferentes fuentes de datos (por ejemplo, cambiar de MySQL a PostgreSQL) sin modificar la lógica de negocio.

**Clases Entidades**
Las clases entidades representan los objetos del mundo real que se almacenan en la base de datos. Cada clase entidad suele mapearse a una tabla en la base de datos, y sus atributos corresponden a las columnas de la tabla.

Características de las clases entidades:

_Atributos:_ Representan las columnas de la tabla (por ejemplo, id, nombre, email).

_Métodos:_ Incluyen getters y setters para acceder y modificar los datos, así como métodos adicionales para lógica específica de la entidad.

_Relaciones:_ Pueden reflejar relaciones entre tablas (como uno a uno, uno a muchos o muchos a muchos).

**Relación entre DAO y Clases Entidades**

El DAO se encarga de interactuar con la base de datos: insertar, consultar, actualizar o eliminar registros.

Las clases entidades son los objetos que el DAO manipula. Por ejemplo, un UsuarioDAO trabajará con objetos de la clase Usuario para guardar o recuperar datos de la tabla usuarios.

#### Folder Structure

- `src`: the folder to maintain sources
    
    1. `entidades`: Aquí irán las clases que representan las tablas de la base de datos.
    2. `servicios`: En esta carpeta se ubicará la lógica de negocio de la aplicación.
    3. `persistencia`: Aquí se almacenarán las clases relacionadas con el acceso a la base de datos (por ejemplo, el DAO).

- `lib`: the folder to maintain dependencies
- `bin`: the compiled output files will be generated here by default

#### Aplicación Java para un Vivero

Desarrollo de una aplicación Java para gestionar los productos de un vivero. El objetivo es permitir consultas como:

- Ver el stock disponible de ciertos productos.

- Listar todos los productos registrados.

- Realizar otras operaciones útiles para la gestión del inventario.

##### Tecnologías y herramientas que usarás:

_Java:_ Como lenguaje principal para la lógica de la aplicación.

_MySQL:_ Como sistema de gestión de bases de datos para almacenar la información.

_JDBC:_ Para conectar tu aplicación Java con la base de datos y ejecutar operaciones como consultas, inserciones, actualizaciones y eliminaciones.

_Patrón DAO:_ Para organizar y separar la lógica de acceso a datos de la lógica de negocio, asegurando un código limpio y mantenible.

#### Creación del proyecto

- Creacion de proyecto Java seleccionando la paleta de comandos desde el icono de configuracion de VSCode:
    Command Palette > Java: Create Java Project > No Build Tools

- Organizar la estructura de carpetas

- Agregar la librería MySQL JDBC Driver:
    Java Projects >  Referenced Libraries > + > mysql_connector_java(JAR)

- Definir entidades segun tablas de mysql:
![Tablas vivero](/vivero.png)



