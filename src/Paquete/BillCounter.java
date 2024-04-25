package Paquete;

import java.util.Scanner;

public class BillCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de dinero en soles: ");
        int cantidadSoles = scanner.nextInt();
        int cantidadBilletes20 = cantidadSoles / 20;
        System.out.println("Se necesitan " + cantidadBilletes20 + " billetes de 20 soles.");
        scanner.close();
    }
}
