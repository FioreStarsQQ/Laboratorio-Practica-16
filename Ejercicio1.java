
/*
    - Laboratorio Nro 16 - Ejercicio 1: Dados dos enteros m, n. Encontrar el múltiplo de 5 mayor o igual a m y mostrar a partir de él todos
    los múltiplos de 5 entre [m, n]. Forzar al usuario que ingrese m<=n.
    - Autor: Fiorela Clariza Quispe Quispe
    - Colaboró: 
    - Tiempo: 6 min
*/
import java.util.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m, n;
        do {
            System.out.print("Ingrese el valor de \"m\" (valor menor):\t");
            m = scan.nextInt();
            System.out.print("Ingrese el valor de \"n\"(valor mayor):\t");
            n = scan.nextInt();
        } while (m > n);
        for (int i = m; i <= n; i++) {
            if (i % 5 == 0) {
                System.out.println(i);
            }
        }
        scan.close();
    }
}