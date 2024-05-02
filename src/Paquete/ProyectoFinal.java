package Paquete;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProyectoFinal {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, Integer> productos = new HashMap<>();

    public static void main(String[] args) {
        // Bucle para gestionar vales de entrada y salida
        boolean continuar = true;
        while (continuar) {
            // Mostrar menú de opciones
            System.out.println("\nMenú:");
            System.out.println("1. Registrar vale de entrada");
            System.out.println("2. Registrar vale de salida");
            System.out.println("3. Mostrar stock actual");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            // Procesar la opción seleccionada
            switch (opcion) {
                case 1:
                    Resumen();
                    System.out.print("Ingrese el nombre del producto: ");
                    String productoEntrada = scanner.next();
                    Ingreso(productoEntrada);
                    break;
                case 2:
                    Resumen();
                    System.out.print("Ingrese el nombre del producto: ");
                    String productoSalida = scanner.next();
                    Salida(productoSalida);
                    break;
                case 3:
                    System.out.println("----- VISTA DEL STOCK ACTUAL -----");
                    Resumen();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        // Mostrar resumen al salir del bucle
        System.out.println("Vista de la tabla de productos actual");
        Resumen();

        scanner.close();
    }

    public static void Resumen() {
        int numcant = 0;
        // Mostrar los productos y sus cantidades en forma de tabla
        System.out.println("╔═════════════════════════════════╗");
        System.out.printf("║ %-18s | %-10s ║%n", "Nombre Producto", "Stock");
        System.out.println("╠═════════════════════════════════╣");
        for (Map.Entry<String, Integer> entry : productos.entrySet()) {
            numcant += entry.getValue();
            System.out.printf("║ %-18s | %-10d ║%n", entry.getKey(), entry.getValue());
        }
        if (numcant == 0) {
            System.out.println("║ Sin Productos :(                ║");
        }
        System.out.println("╚═════════════════════════════════╝");
    }

    public static void Ingreso(String productoEntrada) {
        if (!productos.containsKey(productoEntrada)) {
            productos.put(productoEntrada, 0); // Registrar el producto con cantidad inicial 0
        }
        System.out.print("Ingrese la cantidad recibida: ");
        int cantidadEntrada = scanner.nextInt();
        int stockActual = productos.get(productoEntrada);
        productos.put(productoEntrada, stockActual + cantidadEntrada);
        Resumen();
        System.out.println("Se ha registrado el vale de entrada. Stock actual de " + productoEntrada + ": " + productos.get(productoEntrada));

    }

    public static void Salida(String productoSalida) {
        if (productos.containsKey(productoSalida)) {
            System.out.print("Ingrese la cantidad entregada: ");
            int cantidadSalida = scanner.nextInt();
            int stockActuals = productos.get(productoSalida);
            if (cantidadSalida <= stockActuals) {
                productos.put(productoSalida, stockActuals - cantidadSalida);
                Resumen();
                System.out.println("Se ha registrado con exito el vale de salida :).");
            } else {
                Resumen();
                System.out.println("Alerta: No hay suficiente stock disponible :(.");
            }
        } else {
            Resumen();
            System.out.println("El producto no se encuentra registrado :(");
        }
    }
}