
/*
    - Laboratorio Nro 16 - Ejercicio 4: Programa iterativo sin control de repetición medio.
    Dado un rango [m..n] ingresado por el usuario. Comprobar que siempre m<=n. Sin usar max() ni min().
    Hacer un programa que permita generar números aleatorios en dicho rango, hasta que se le diga que ya no se desea generar más.
    Al salir mostrar cuantos números generados fueron pares y cuantos impares. Modo gráfico y usar clase Random.
    - Autor: Fiorela Clariza Quispe Quispe
    - Colaboró: 
    - Tiempo: 15 min
*/
import javax.swing.*;
import java.util.*;

public class Ejercicio4 {
    public static void main(String[] args) {
        Random numRandom = new Random();
        int m, n, num, respuesta = 1, numPar = 0, numImpar = 0;
        do {
            m = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de \"m\" (valor menor):\t"));
            n = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de \"n\"(valor mayor):\t"));
        } while (m > n);
        for (; respuesta == 1;) {
            num = (numRandom.nextInt(n - m + 1) + m);
            JOptionPane.showMessageDialog(null, "Número aleatorio: " + num);
            if (num % 2 == 0) {
                numPar++;
            } else {
                numImpar++;
            }
            if (JOptionPane.showConfirmDialog(null, "¿Desea que se genere otro número aleatorio?",
                    "GENERAR NUEVO NÚMERO",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                // OPCION SI
                respuesta = 1;
            } else {
                // OPCION NO
                respuesta = 2;
            }
        }
        JOptionPane.showMessageDialog(null,
                "Cantidad de números generados:\nNúmeros pares: " + numPar + "\nNúmeros impares: " + numImpar);
    }
}