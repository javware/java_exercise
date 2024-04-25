package Paquete;

import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char opcion;
        do {
            System.out.println("*******************************************");
            System.out.println("*    Bienvenido al Programa de Pago       *");
            System.out.println("*******************************************");
            System.out.println("Ingrese el importe del producto:");
            double importeProducto = scanner.nextDouble();
            do {
                System.out.println("Seleccione una opción:");
                System.out.println("a. Calcular el importe a pagar en el primer mes (primera forma)");
                System.out.println("b. Calcular la cantidad de meses para pagar el producto (segunda forma)");
                System.out.println("c. Reiniciar");
                System.out.println("d. Salir");

                opcion = scanner.next().charAt(0);
                switch (opcion) {
                    case 'a':
                        System.out.println("Ingrese la cantidad de meses para pagar (primera forma):");
                        int mesesPrimeraForma = scanner.nextInt();

                        double importePrimerMesPrimeraForma = calcularImportePrimerMesPrimeraForma(importeProducto, mesesPrimeraForma);
                        System.out.println("El importe a pagar en el primer mes (primera forma) es: S/ " + importePrimerMesPrimeraForma);
                        break;
                    case 'b':
                        System.out.println("Ingrese la cuota del primer mes (segunda forma):");
                        double cuotaPrimerMes = scanner.nextDouble();
                        int cantidadMesesSegundaForma = calcularCantidadMesesSegundaForma(importeProducto, cuotaPrimerMes);
                        System.out.println("La cantidad de meses para pagar el producto (segunda forma) es: " + cantidadMesesSegundaForma);
                        break;
                    case 'c':
                        break; // Reiniciar el proceso desde el principio
                    case 'd':
                        System.out.println("Saliendo del programa...");
                        return; // Salir del programa
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione 'a', 'b', 'c' o 'd'.");
                        break;
                }
            } while (opcion != 'c');
        } while (true);
    }

    public static double calcularImportePrimerMesPrimeraForma(double importeProducto, int meses) {
        double importePrimerMes = importeProducto;
        int mesActual = 1;

        while (mesActual < meses) {
            importePrimerMes *= 2;
            mesActual++;
        }

        return importePrimerMes;
    }

    public static int calcularCantidadMesesSegundaForma(double importeProducto, double cuotaPrimerMes) {
        int meses = 1;
        double saldoPendiente = importeProducto;

        while (saldoPendiente > 0) {
            saldoPendiente -= cuotaPrimerMes;
            meses++;
        }

        return meses - 1;
    }


}
