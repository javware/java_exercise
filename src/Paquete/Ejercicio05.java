package Paquete;

import java.util.Scanner;

public class Ejercicio05 {
    // Método para calcular la última tasa recibida después de un cierto período de meses
    public static double calcularUltimaTasa(int meses) {
        double tasa = 0.02; // La tasa inicial es 2%
        int periodoIncrementoTasa = 3; // La tasa se incrementa cada 3 meses

        // Calcular cuántos incrementos han ocurrido
        int contadorIncremento = (meses - 1) / periodoIncrementoTasa;

        // Ajustar la tasa por cada incremento
        for (int i = 0; i < contadorIncremento; i++) {
            tasa += 0.01; // Incremento de 1% en la tasa
        }

        return tasa;
    }

    // Método para calcular el interés total después de un cierto período de meses
    public static double calcularInteresTotal(double capital, double tasa) {
        return capital * tasa;
    }

    // Método para calcular el importe total después de un cierto período de meses
    public static double calcularImporteTotal(double capital, double interesTotal) {
        return capital + interesTotal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*******************************************");
        System.out.println("*    Bienvenido al programa PrestaCash    *");
        System.out.println("*******************************************");
        System.out.println("Ingrese el capital inicial:");
        double capitalInicial = scanner.nextDouble();

        System.out.println("Ingrese el período en meses:");
        int periodoMeses = scanner.nextInt();

        // Calculamos la última tasa recibida
        double ultimaTasa = calcularUltimaTasa(periodoMeses);
        System.out.println("La última tasa recibida después de " + periodoMeses + " meses es: " + ultimaTasa * 100 + "%");

        // Calculamos el interés total recibido después de un cierto período de meses
        double interesTotal = calcularInteresTotal(capitalInicial, ultimaTasa);
        System.out.println("El interés total recibido después de " + periodoMeses + " meses es: S/ " + interesTotal);

        // Calculamos el importe total recibido después de un cierto período de meses
        double importeTotal = calcularImporteTotal(capitalInicial, interesTotal);
        System.out.println("El importe total recibido después de " + periodoMeses + " meses es: S/ " + importeTotal);

        scanner.close();
    }
}
