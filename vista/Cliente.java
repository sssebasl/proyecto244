package co.edu.poli.actividad3.vista;

import co.edu.poli.actividad3.modelo.*;
import co.edu.poli.actividad3.servicios.ImplOperacionCRUD;
import co.edu.poli.actividad3.servicios.OperacionArchivo;
import co.edu.poli.actividad3.servicios.OperacionCRUD;
import java.util.Scanner;

/**
 * Clase cliente para la ejecución del programa de manejo de monedas.
 * Contiene el método main que realiza pruebas de creación, impresión,
 * polimorfismo y operaciones CRUD con menú para máximo 5 monedas.
 */
public class Cliente {

    static OperacionCRUD servicioCRUD = new ImplOperacionCRUD();
    static Scanner sc = new Scanner(System.in);
    // Array para máximo 5 monedas
    static Moneda[] monedasCRUD = new Moneda[5];

    public static void main(String[] args) {

        // ==== Código original con herencias, sobrecarga, polimorfismo ====

        Pais pais = new Pais("España", "EUR", "Madrid");
        Conservacion conservacion = new Conservacion(false, true, true, "C-001");
        Propietario propietario = new Propietario("Juan Pérez", "123456789", "España", "2022-05-10");
        Certificado certificado = new Certificado(2020, "España", "CERT-98765", "Banco de España", "2020-11-15", 2, true, false);
        MetodoAdquisicion metodo = new MetodoAdquisicion(true, false, false, "M-123");

        Moneda moneda = new MonedaEuropea(1950, 20, 20.0, "Alta", "Plata", "MON-001",
                                         2.5, 12.4, "Redonda", 28.5,
                                         pais, conservacion, propietario, certificado, metodo, false);

        MonedaEuropea monedaEuropea = new MonedaEuropea(2002, 10, 1.0, "Media", "Níquel", "MON-002",
                                                        2.3, 7.5, "Redonda", 24.0,
                                                        pais, conservacion, propietario, certificado, metodo, true);

        MonedaAsiatica monedaAsiatica = new MonedaAsiatica(1990, 5, 0.5, "Baja", "Cobre", "MON-003",
                                                           2.0, 6.0, "Cuadrada", 22.0,
                                                           pais, conservacion, propietario, certificado, metodo, 3.8);

        System.out.println("===== MONEDA (SUPERCLASE) =====");
        System.out.println(moneda);
        System.out.println("Edad de la moneda: " + moneda.getEdadActual() + " años");
        System.out.println("SOBREESCRITURA");
        System.out.println("Descripción simple: " + moneda.obtenerDescripcion());

        System.out.println("\n===== MONEDA EUROPEA (SUBCLASE) =====");
        System.out.println(monedaEuropea);
        System.out.println("Edad de la moneda europea: " + monedaEuropea.getEdadActual() + " años");
        System.out.println("¿Es moneda de la zona Euro? " + monedaEuropea.isEsZonaEuro());
        System.out.println("SOBREESCRITURA");
        System.out.println("Descripción (Europea): " + monedaEuropea.obtenerDescripcion());
        System.out.println("SOBRECARGA");
        System.out.println("Descripción detallada (Europea): " + monedaEuropea.obtenerDescripcion("Pertenece a Europa."));

        Moneda[] monedas = new Moneda[5];
        monedas[0] = moneda;
        monedas[1] = monedaEuropea;
        monedas[2] = monedaAsiatica;

        System.out.println("\n===== DESCRIPCIONES DESDE ARREGLO (POLIMORFISMO) =====");
        for (int i = 0; i < monedas.length; i++) {
            if (monedas[i] != null) {
                System.out.println("Moneda " + (i + 1) + ": " + monedas[i].obtenerDescripcion());
            } else {
                System.out.println("Moneda " + (i + 1) + ": (posición vacía)");
            }
        }

        System.out.println("\n===== POLIMORFISMO CON MÉTODOS =====");

        Moneda monedaPolimorfica1 = crearMonedaAsiaticaEjemplo();
        Moneda monedaPolimorfica2 = crearMonedaEuropeaEjemplo();

        imprimirDescripcion(monedaPolimorfica1);
        imprimirDescripcion(monedaPolimorfica2);

        // Insertamos esas monedas en el CRUD para probar
        servicioCRUD.crear(moneda);
        servicioCRUD.crear(monedaEuropea);
        servicioCRUD.crear(monedaAsiatica);

        // ---- Iniciamos menú CRUD con arreglo y hasta 5 monedas ----
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    crearMonedaMenu();
                    break;
                case 2:
                    readIdMenu();
                    break;
                case 3:
                    readAllMenu();
                    break;
                case 4:
                    actualizarMenu();
                    break;
                case 5:
                    eliminarMenu();
                    break;
                case 6:
                    serializarMenu();
                    break;
                case 7:
                    deserializarMenu();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        sc.close();
    }

    // ========== MENÚ CRUD con arreglos (máximo 5 monedas) ===========

    private static void mostrarMenu() {
        System.out.println("\n==== MENÚ CRUD MONEDAS ====");
        System.out.println("1. Crear moneda");
        System.out.println("2. Leer moneda por ID (serial)");
        System.out.println("3. Leer todas las monedas");
        System.out.println("4. Actualizar moneda");
        System.out.println("5. Eliminar moneda");
        System.out.println("6. Serializar monedas");
        System.out.println("7. Deserializar monedas");
        System.out.println("8. Salir");
    }

    private static void crearMonedaMenu() {
        if (servicioCRUD.count() >= 5) {
            System.out.println("Máximo número de monedas alcanzado (5). No se pueden agregar más.");
            return;
        }
        System.out.println("=== Crear nueva moneda ===");
        String serial = leerCadena("Serial (ej: MON-XXX): ");

        if (servicioCRUD.buscar(serial) != null) {
            System.out.println("Ya existe una moneda con ese serial.");
            return;
        }

        int año = leerEntero("Año de acuñación: ");
        int cantidad = leerEntero("Cantidad: ");
        double diametro = leerDouble("Diámetro: ");
        String rareza = leerCadena("Rareza: ");

        // Para simplificar, creamos moneda europea básica con valores por defecto para atributos complejos
        Pais paisDefault = new Pais("Desconocido", "N/A", "N/A");
        Conservacion conservacionDefault = new Conservacion(false, false, false, "C-000");
        Propietario propietarioDefault = new Propietario("Desconocido", "000000", "N/A", "0000-00-00");
        Certificado certificadoDefault = new Certificado(0, "N/A", "CERT-00000", "N/A", "0000-00-00", 0, false, false);
        MetodoAdquisicion metodoDefault = new MetodoAdquisicion(false, false, false, "M-000");

        Moneda nuevaMoneda = new MonedaEuropea(año, cantidad, diametro, rareza, "Material Desconocido", serial,
                0, 0, "Forma Desconocida", 0,
                paisDefault, conservacionDefault, propietarioDefault, certificadoDefault, metodoDefault, false);

        servicioCRUD.crear(nuevaMoneda);
        System.out.println("Moneda creada exitosamente.");
    }

    private static void readIdMenu() {
        System.out.println("=== Buscar moneda por serial ===");
        String serial = leerCadena("Ingrese serial: ");
        Moneda moneda = servicioCRUD.buscar(serial);
        if (moneda != null) {
            System.out.println("Moneda encontrada:");
            System.out.println(moneda);
        } else {
            System.out.println("No se encontró moneda con ese serial.");
        }
    }

    private static void readAllMenu() {
        System.out.println("=== Listado de todas las monedas ===");
        Moneda[] todas = servicioCRUD.listar();
        if (todas.length == 0) {
            System.out.println("No hay monedas almacenadas.");
            return;
        }
        for (Moneda m : todas) {
            System.out.println(m);
        }
    }

    private static void actualizarMenu() {
        System.out.println("=== Actualizar rareza de moneda ===");
        String serial = leerCadena("Ingrese serial: ");
        Moneda moneda = servicioCRUD.buscar(serial);
        if (moneda == null) {
            System.out.println("No se encontró moneda con ese serial.");
            return;
        }
        String nuevaRareza = leerCadena("Nueva rareza: ");
        moneda.setRareza(nuevaRareza);
servicioCRUD.actualizar(moneda.getSerial(), moneda);
System.out.println("Moneda actualizada.");

    }

 private static void eliminarMenu() {
    System.out.println("=== Eliminar moneda ===");
    String serial = leerCadena("Ingrese serial: ");
    boolean eliminado = servicioCRUD.eliminar(serial);  // <-- línea con error
    if (eliminado) {
        System.out.println("Moneda eliminada.");
    } else {
        System.out.println("No se encontró moneda con ese serial.");
    }
}


    private static void serializarMenu() {
        System.out.println("=== Serializar monedas ===");
        OperacionArchivo operArchivo = new OperacionArchivo();
        Moneda[] todas = servicioCRUD.listar();
        if (todas.length == 0) {
            System.out.println("No hay monedas para serializar.");
            return;
        }
        operArchivo.serializar(todas);
        System.out.println("Monedas serializadas exitosamente.");
    }

    private static void deserializarMenu() {
        System.out.println("=== Deserializar monedas ===");
        OperacionArchivo operArchivo = new OperacionArchivo();
        Moneda[] monedasDes = operArchivo.deserializar();
        if (monedasDes == null || monedasDes.length == 0) {
            System.out.println("No se encontraron monedas deserializadas.");
            return;
        }
        // Limpiamos el CRUD actual y agregamos las deserializadas
        servicioCRUD.clear();
        for (Moneda m : monedasDes) {
            if (m != null) {
                servicioCRUD.crear(m);
            }
        }
        System.out.println("Monedas deserializadas y cargadas al sistema.");
    }

    // ========== Métodos auxiliares ==========

    public static void imprimirDescripcion(Moneda moneda) {
        System.out.println("Descripción polimórfica: " + moneda.obtenerDescripcion());
    }

    public static Moneda crearMonedaAsiaticaEjemplo() {
        Pais pais = new Pais("Japón", "JPY", "Tokio");
        Conservacion conservacion = new Conservacion(true, false, true, "C-002");
        Propietario propietario = new Propietario("Kenji Tanaka", "987654321", "Japón", "2021-03-15");
        Certificado certificado = new Certificado(2021, "Japón", "CERT-55555", "Banco de Japón", "2021-03-20", 1, true, true);
        MetodoAdquisicion metodo = new MetodoAdquisicion(false, true, false, "M-789");

        return new MonedaAsiatica(2010, 100, 100.0, "Media", "Bronce", "MON-004",
                                  2.2, 8.5, "Redonda", 26.0,
                                  pais, conservacion, propietario, certificado, metodo, 2.5);
    }

    public static Moneda crearMonedaEuropeaEjemplo() {
        Pais pais = new Pais("Francia", "EUR", "París");
        Conservacion conservacion = new Conservacion(true, true, false, "C-003");
        Propietario propietario = new Propietario("Claire Dubois", "456789123", "Francia", "2020-12-01");
        Certificado certificado = new Certificado(2018, "Francia", "CERT-33333", "Banco de Francia", "2018-06-10", 1, false, true);
        MetodoAdquisicion metodo = new MetodoAdquisicion(true, false, true, "M-321");

        return new MonedaEuropea(2015, 50, 2.0, "Alta", "Oro", "MON-005",
                                 2.4, 9.1, "Redonda", 27.0,
                                 pais, conservacion, propietario, certificado, metodo, true);
    }

    private static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero válido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número decimal válido.");
            }
        }
    }
}
