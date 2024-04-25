package Paquete;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejecicio03 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        double sueldo = 1500;
        double ventas;
        int servicio;
        double comision;
        double total;


        System.out.println("Ingrese las ventas realizadas: ");
        ventas = entrada.nextDouble();

        System.out.println("Ingrese los años de servicio: ");
        try {
            servicio = entrada.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un número entero para los años de servicio.");
            entrada.next(); // Limpiar el buffer del scanner
            return;
        }

        if (servicio <= 0){
            System.out.println("Por favor, ingrese un número mayor a 0 para los años de servicio.");
            return;
        }
        comision = calcular_comision(ventas, servicio, sueldo);
        total = sueldo + comision;
        System.out.printf("\n total a percibir es %.2f habiendo obtenido %.2f de comision", total, comision);

    }

    private static double calcular_comision(double ventas, int servicio, double sueldo) {
        double comision = 0;

        if (servicio >= 1 && servicio <= 4) {
            if (ventas >= 1000 && ventas <= 2500)
                comision = sueldo * 0.02;
            else if (ventas >= 2501 && ventas <= 5000)
                comision = sueldo * 0.03;
            else if (ventas >= 5001 && ventas <= 10000)
                comision = sueldo * 0.04;
            else if (ventas > 10000)
                comision = sueldo * 0.05;
            else {
                comision = 0;
            }

        } else if (servicio >= 5 && servicio <= 10) {
            if (ventas >= 1000 && ventas <= 2500)
                comision = sueldo * 0.025;
            else if (ventas >= 2501 && ventas <= 5000)
                comision = sueldo * 0.035;
            else if (ventas >= 5001 && ventas <= 10000)
                comision = sueldo * 0.045;
            else if (ventas > 10000)
                comision = sueldo * 0.055;
            else {
                comision = 0;
            }

        } else if (servicio >= 11 && servicio <= 15) {
            if (ventas >= 1000 && ventas <= 2500)
                comision = sueldo * 0.03;
            else if (ventas >= 2501 && ventas <= 5000)
                comision = sueldo * 0.04;
            else if (ventas >= 5001 && ventas <= 10000)
                comision = sueldo * 0.05;
            else if (ventas > 10000)
                comision = sueldo * 0.06;
            else {
                comision = 0;
            }

        } else if (servicio >= 16) {
            if (ventas >= 1000 && ventas <= 2500)
                comision = sueldo * 0.05;
            else if (ventas >= 2501 && ventas <= 5000)
                comision = sueldo * 0.06;
            else if (ventas >= 5001 && ventas <= 10000)
                comision = sueldo * 0.07;
            else if (ventas > 10000)
                comision = sueldo * 0.08;
            else {
                comision = 0;
            }
        }

        return comision;

    }

}

