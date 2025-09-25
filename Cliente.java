package co.edu.poli.actividad3.vista;

import co.edu.poli.actividad3.modelo.*;
import co.edu.poli.actividad3.servicios.ImplOperacionCRUD;
import co.edu.poli.actividad3.servicios.OperacionCRUD;

/**
 * Clase cliente para la ejecución del programa de manejo de monedas.
 * Contiene el método main que realiza pruebas de creación, impresión,
 * polimorfismo y operaciones CRUD sobre objetos Moneda y sus subclases.
 */
public class Cliente {

    /**
     * Método principal que ejecuta la lógica para crear objetos Moneda,
     * realizar impresiones, pruebas de polimorfismo y operaciones CRUD.
     *
     * @param args argumentos de línea de comandos (no usados)
     */
    public static void main(String[] args) {

        // Objetos comunes
        Pais pais = new Pais("España", "EUR", "Madrid");
        Conservacion conservacion = new Conservacion(false, true, true, "C-001");
        Propietario propietario = new Propietario("Juan Pérez", "123456789", "España", "2022-05-10");
        Certificado certificado = new Certificado(2020, "España", "CERT-98765", "Banco de España", "2020-11-15", 2, true, false);
        MetodoAdquisicion metodo = new MetodoAdquisicion(true, false, false, "M-123");

        // Moneda (superclase) -> cambiada a MonedaEuropea para evitar error de clase abstracta
        Moneda moneda = new MonedaEuropea(1950, 20, 20.0, "Alta", "Plata", "MON-001",
                                         2.5, 12.4, "Redonda", 28.5,
                                         pais, conservacion, propietario, certificado, metodo, false);

        // MonedaEuropea (subclase de Moneda)
        MonedaEuropea monedaEuropea = new MonedaEuropea(2002, 10, 1.0, "Media", "Níquel", "MON-002",
                                                        2.3, 7.5, "Redonda", 24.0,
                                                        pais, conservacion, propietario, certificado, metodo, true);

        // MonedaAsiatica (subclase de Moneda)
        MonedaAsiatica monedaAsiatica = new MonedaAsiatica(1990, 5, 0.5, "Baja", "Cobre", "MON-003",
                                                           2.0, 6.0, "Cuadrada", 22.0,
                                                           pais, conservacion, propietario, certificado, metodo, 3.8);

        // IMPRESIONES INDIVIDUALES COMO ANTES

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

        // ARREGLO DE MONEDAS Y POLIMORFISMO
        Moneda[] monedas = new Moneda[5];
        monedas[0] = moneda;
        monedas[1] = monedaEuropea;
        monedas[2] = monedaAsiatica;
        // monedas[3] y monedas[4] quedan vacías (null)

        System.out.println("\n===== DESCRIPCIONES DESDE ARREGLO (POLIMORFISMO) =====");
        for (int i = 0; i < monedas.length; i++) {
            if (monedas[i] != null) {
                System.out.println("Moneda " + (i + 1) + ": " + monedas[i].obtenerDescripcion());
            } else {
                System.out.println("Moneda " + (i + 1) + ": (posición vacía)");
            }
        }

        // ===== POLIMORFISMO CON MÉTODOS =====
        System.out.println("\n===== POLIMORFISMO CON MÉTODOS =====");

        // Método 1 - Retorna Moneda (pero es una subclase)
        Moneda monedaPolimorfica1 = crearMonedaAsiaticaEjemplo();
        Moneda monedaPolimorfica2 = crearMonedaEuropeaEjemplo(); // ← Nuevo

        // Método 2 - Recibe Moneda (polimorfismo por parámetro)
        imprimirDescripcion(monedaPolimorfica1);
        imprimirDescripcion(monedaPolimorfica2); // ← Nuevo

        // --------- AÑADIDO PARA CRUD ----------

        // Crear instancia del servicio CRUD
        OperacionCRUD servicioCRUD = new ImplOperacionCRUD();

        // Crear monedas usando el CRUD
        System.out.println("\n===== PRUEBAS CRUD =====");
        System.out.println("Creando monedas...");

        servicioCRUD.crear(moneda);
        servicioCRUD.crear(monedaEuropea);
        servicioCRUD.crear(monedaAsiatica);

        // Listar todas las monedas
        System.out.println("\nListado de monedas tras creación:");
        for (Moneda m : servicioCRUD.listar()) {
            System.out.println(m);
        }

        // Buscar una moneda
        String serialBuscar = "MON-002";
        System.out.println("\nBuscando moneda con serial " + serialBuscar + ":");
        Moneda encontrada = servicioCRUD.buscar(serialBuscar);
        if (encontrada != null) {
            System.out.println("Moneda encontrada: " + encontrada);
        } else {
            System.out.println("No se encontró moneda con ese serial.");
        }

        // Actualizar moneda (cambiar rareza)
        System.out.println("\nActualizando rareza de moneda con serial MON-002 a 'Muy Alta'");
        Moneda monedaActualizar = servicioCRUD.buscar("MON-002");
        if (monedaActualizar != null) {
            monedaActualizar.setRareza("Muy Alta");
            servicioCRUD.actualizar(monedaActualizar);
        }

        // Listar para confirmar actualización
        System.out.println("\nListado de monedas tras actualización:");
        for (Moneda m : servicioCRUD.listar()) {
            System.out.println(m);
        }

        // Eliminar una moneda
        System.out.println("\nEliminando moneda con serial MON-001");
        servicioCRUD.eliminar("MON-001");

        // Listar para confirmar eliminación
        System.out.println("\nListado de monedas tras eliminación:");
        for (Moneda m : servicioCRUD.listar()) {
            System.out.println(m);
        }

    }

    /**
     * Imprime la descripción de una moneda usando polimorfismo.
     *
     * @param moneda Objeto Moneda o cualquiera de sus subclases
     */
    public static void imprimirDescripcion(Moneda moneda) {
        System.out.println("Descripción polimórfica: " + moneda.obtenerDescripcion());
    }

    /**
     * Crea y retorna un objeto MonedaAsiatica de ejemplo.
     *
     * @return Objeto MonedaAsiatica con valores predefinidos
     */
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

    /**
     * Crea y retorna un objeto MonedaEuropea de ejemplo.
     *
     * @return Objeto MonedaEuropea con valores predefinidos
     */
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
}
