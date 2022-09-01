
/*
    - Laboratorio Nro 16 - Ejercicio 2: Generar todos los puntos 3D posibles con valores enteros [0, 5] para cada eje (x, y, z).
    - Autor: Fiorela Clariza Quispe Quispe
    - Colaboró: 
    - Tiempo: 5 min
*/

public class Ejercicio2 {
    public static void main(String[] args) {
        int x, y, z;
        for (x = 0; x <= 5; x++)
            for (y = 0; y <= 5; y++)
                for (z = 0; z <= 5; z++)
                    System.out.println("Punto (" + x + ", " + y + ", " + z + ")");
    }
}