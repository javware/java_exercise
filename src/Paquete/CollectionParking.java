package Paquete;

import java.util.Scanner;

public class CollectionParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese las horas de estacionamiento: ");

        double horas = scanner.nextDouble();
        int horasCompletas = (int) Math.ceil(horas);
        double tarifaHora = 5.0; //  5 Soles por hora
        double importeTotal = horasCompletas * tarifaHora;

        System.out.println("El importe a cobrar es: S/" + importeTotal);

        scanner.close();


    }
}
