import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;



// *** Puntos clave de la sección: Componentes de una Conexión JDBC
// *** Controlador JDBC: El controlador JDBC es necesario para permitir la comunicación entre tu aplicación Java y la base de datos. 
// Cada tipo de base de datos tiene su propio controlador (por ejemplo, com.mysql.cj.jdbc.Driver para MySQL). Este controlador 
// debe estar presente en el proyecto, ya sea como una dependencia o como un archivo JAR incluido en el proyecto.

public class App {
    public static void main(String[] args) throws Exception {
        Connection conexion = getConnection();
        buscarClientes(conexion);
        buscarClientesPorCodigo(conexion);
        cerrarConexion(conexion);
    }

    public static Connection getConnection() {
        // *** Credenciales de acceso: Para establecer una conexión, se requieren credenciales como el usuario y la contraseña 
        // que permiten la autenticación en la base de datos. Estas credenciales aseguran que solo los usuarios
        // autorizados puedan acceder y realizar operaciones sobre los datos.
        String host = "127.0.0.1"; // localhost
        String port = "3306"; // por defecto
        String name = "root"; // usuario de la base de datos
        String password = "12345"; // pasword database
        String database = "vivero"; // nombre base de datos

        // *** Configuración de la zona horaria (opcional): Algunas bases de datos pueden necesitar configuraciones adicionales, 
        // como la zona horaria, para evitar problemas con las fechas y horas.
        String zona = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        // *** esto indica la ruta de conexion, que es la combinacion de host,usuario,puerto, nombre de la base de datos 
        // a la cual queremos conectarnos y la zona horaria (si se precisara).
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + zona;

        Connection conexion = null;
        
        // *** Manejo de errores y excepciones: Al establecer la conexión, pueden surgir errores como credenciales incorrectas, 
        // puerto bloqueado o base de datos no existente. Es importante manejar estos errores adecuadamente utilizando
        // bloques try-catch para capturar excepciones como SQLException.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(url, name, password);
            System.out.println("Conexion exitosa a la base de datos");

        } catch (ClassNotFoundException e) {
            System.out.println("error al cargar el conector JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
        return conexion;
    }

    //metodo buscarCliente (ya venia de ejemplo)
    public static void buscarClientes(Connection conexion) {
        String sql = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente ";
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            while (rs.next()) {
                String nombre = rs.getString("nombre_contacto");
                String apellido = rs.getString("apellido_contacto");
                String telefono = rs.getString("telefono");
                count++;
                System.out.println(count + " - " + nombre + " " + apellido + " - " + telefono);
            }
            // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }
    
    // Realiza un método llamado buscarClientePorCodigo(codigo) que reciba como parámetro el código del cliente y muestre por pantalla 
    // los datos que tiene el cliente guardado en la base de datos. 
    public static void buscarClientesPorCodigo(Connection conexion) {
        System.out.println("Busca un cliente por codigo");
        //String sql = "SELECT id_cliente, codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, ciudad, region, pais, codigo_postal, id_empleado, limite_credito FROM cliente ";
        Scanner miScanner = new Scanner(System.in);
        System.out.println("Ingrese código del cliente que desea buscar ");
        int codigoCliente = miScanner.nextInt();
        miScanner.close();
        System.out.println("Buscando cliente de código " + codigoCliente);
        String sql = "SELECT * FROM cliente WHERE codigo_cliente = " + codigoCliente; 
        boolean encontrado = false;

        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                //Int id_cliente = rs.getInt("id_cliente");
                String nombreCliente = rs.getString("nombre_cliente");
                String nombreContacto = rs.getString("nombre_contacto");
                String apellidoContacto = rs.getString("apellido_contacto");
                String telefono = rs.getString("telefono");
                String fax = rs.getString("fax");
                String ciudad = rs.getString("ciudad");
                String region = rs.getString("region");
                String pais = rs.getString("pais");
                String codigo_postal = rs.getString("codigo_postal");
                //Int id_empleado = rs.getInt("id_empleado");
                Double limite_credito = rs.getDouble("limite_credito");

                System.out.println(/*" ID de cliente: ", id_cliente + */
                                "\nNombre Cliente: " + nombreCliente +
                                "\nNombre y Apellido de contacto: " + nombreContacto + " " + apellidoContacto +
                                "\nTeléfono: " + telefono + " Fax: " + fax +
                                "\n" + ciudad + ", " + region + ", " + pais + ". CP: " + codigo_postal + 
                               /* "\nEmpleado asignado: " + id_empleado + */
                                "\nLimite crediticio: " + limite_credito
                );
                encontrado = true;
            }

            if(!encontrado) {
                System.out.println("No se encontro cliente con el codigo " + codigoCliente);
            }

            // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    // Realiza un método llamado buscarClientesPorEmpleado(codigo) que reciba el código del empleado como parámetro y muestre todos 
    // los clientes asociados a un empleado en particular. Puedes elegir qué campos mostrar en tu método.
    public static void buscarClientesPorEmpleado(Connection conexion) {
        System.out.println("Este metodo busca el cliente segun el codigo de empleado al que fue asignado");
    }

    //✏️ Actividad: Consultas en la tabla “Producto”
    // Objetivo: Crear métodos parametrizados que permitan recuperar y mostrar información específica de la tabla producto en la
    // base de datos, utilizando consultas SQL eficientes.

    // Realiza una función getProductosParaReponer(puntoReposicion) que dado un número de punto de reposición que se pasa como parámetro,
    // liste todos los productos que están por debajo de su punto de reposición, esto quiere decir, que tienen menos stock que el punto 
    // establecido.

    // Realiza un método llamado getProductosGama() que dado como parámetro el nombre de la gama, retorne una lista con la siguiente 
    // información: códigos del producto, nombre del producto,  código y nombre de la gama.
    
    
    // *** Cierre de la conexión: Una vez que la conexión se haya utilizado, es fundamental cerrarla para liberar los recursos. 
    // Esto se hace utilizando el método close() de la conexión, lo que evita fugas de memoria y asegura un uso
    // eficiente de los recursos del sistema.
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("La conexion a la base de datos fue cerrada de manera exitosa");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }
}

// ***funcionamiento de buscarClientes:
// ***Definición de la Consulta SQL:
// Se define una variable del tipo String para almacenar la consulta SQL.
// Esta consulta selecciona nombre_contacto, apellido_contacto y telefono de la tabla cliente.
// Es importante respetar el nombre exacto de las columnas declaradas en las tablas de tu base de datos para evitar errores en la ejecución de la consulta.
// ***Manejo de Excepciones: Se declara un bloque try para manejar posibles excepciones de tipo SQLException.
// ***Creación y Ejecución de la Consulta:
// Statement stmt = conexion.createStatement();: Se crea un objeto Statement para enviar la consulta a la base de datos.
// ResultSet rs = stmt.executeQuery(sql);: Se ejecuta la consulta SQL y se almacena el resultado en un ResultSet llamado rs.
// ***Iteración sobre los Resultados:
// Dentro de un bucle while, se itera sobre cada registro en el ResultSet.
// Mientras haya registros disponibles, se obtiene el valor de cada columna utilizando el método correspondiente al tipo de dato.
// Por ejemplo, dado que nombre_contacto es de tipo varchar en MySQL, se usa el método getString, almacenando el valor en una variable de tipo String.
// ***Impresión de los Datos:
// Imprimimos los datos obtenidos en la consola.
// Se utiliza un contador para llevar un registro ordenado de los datos mostrados.
// ***Cierre de Recursos:
// Se cierran los recursos utilizados, tanto el ResultSet como el Statement.
// La conexión a la base de datos no se cierra en este método, ya que se crea un método independiente para realizar dicha tarea, el cual será invocado posteriormente desde nuestra clase Main.