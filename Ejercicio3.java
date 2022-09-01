
/*
    - Laboratorio Nro 16 - Ejercicio 3: Otra de Smartphones. Una persona que va de compras a la tienda “SODOMA S.A.”, decide llevar un
    control sobre lo que va comprando (cantidad y precio unitario), para saber la cantidad de dinero que
    tendrá que pagar al llegar a la caja. La tienda tiene una promoción del 20% de descuento sobre
    aquellos artículos cuya etiqueta sea roja y 10% para etiqueta verde. Indicar la cantidad que debe
    pagar al final. Presupuesto LIMITADO!!! y modo gráfico.
    - Autor: Fiorela Clariza Quispe Quispe
    - Colaboró: 
    - Tiempo: 20 min
*/
import javax.swing.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        double presupuesto = 0, costoUnitario, total = 0, costoProducto;
        int respuesta = 1, etiqueta, cantidad, valorEtiqueta = 0, colorEtiqueta, continuar;
        presupuesto = Double.parseDouble(
                JOptionPane.showInputDialog(null, "Bienvenido(a), ingrese su presupuesto para el día de hoy:"));
        for (int n = 1; respuesta == 1; n++) {
            costoUnitario = Double.parseDouble(
                    JOptionPane.showInputDialog(null, "Ingrese el costo unitario del producto N° " + n + ":"));
            cantidad = Integer
                    .parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de productos a comprar:"));
            costoProducto = costoUnitario * cantidad * 1.0;
            etiqueta = JOptionPane.showConfirmDialog(null,
                    "¿Este producto tiene etiqueta?", "Etiquetas...",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (etiqueta == JOptionPane.NO_OPTION) {
                valorEtiqueta = 1;
            }
            if (etiqueta == JOptionPane.YES_OPTION) {
                valorEtiqueta = 2;
            }
            if (valorEtiqueta == 2) {
                colorEtiqueta = JOptionPane.showConfirmDialog(null, "¿La etiqueta es de color rojo?",
                        "Color de etiqueta...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (colorEtiqueta == JOptionPane.YES_OPTION) {
                    valorEtiqueta = 2;
                }
                if (colorEtiqueta == JOptionPane.NO_OPTION) {
                    valorEtiqueta = 3;
                }
            }
            switch (valorEtiqueta) {
                case 1:
                    JOptionPane.showMessageDialog(null,
                            "No se aplicó ningún descuento al producto seleccionado.\nValor de la compra actual: S/. "
                                    + String.format("%.2f", costoProducto));
                    break;
                case 2:
                    costoProducto *= 0.80;
                    JOptionPane.showMessageDialog(null,
                            "ETIQUETA ROJA:\nSe aplicó el descuento del 20% al producto seleccionado.\nValor de la compra actual: S/. "
                                    + String.format("%.2f", costoProducto));
                    break;
                case 3:
                    costoProducto *= 0.90;
                    JOptionPane.showMessageDialog(null,
                            "ETIQUETA VERDE:\nSe aplicó el descuento del 10% al producto seleccionado.\nValor de la compra actual: S/. "
                                    + String.format("%.2f", costoProducto));
                    break;
            }
            presupuesto -= costoProducto;
            total = (double) Math.round((total + costoProducto) * 100) / 100;
            if (presupuesto >= 0) {
                continuar = JOptionPane.showConfirmDialog(null,
                        "El valor de sus compras hasta el momento es: S/." + String.format("%.2f", total)
                                + "\nSu saldo disponible es: S/. " + String.format("%.2f", presupuesto)+"\n¿Desea seguir comprando?",
                        "AGREGAR PRODUCTO...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (continuar == JOptionPane.YES_OPTION) {
                    respuesta = 1;
                }
                if (continuar == JOptionPane.NO_OPTION) {
                    respuesta = 2;
                }
            } else {
                continuar = JOptionPane.showConfirmDialog(null,
                        "El valor de sus compras han superado su presupuesto: S/." + String.format("%.2f", total)
                                + "\nSu saldo es NEGATIVO: S/. " + String.format("%.2f", presupuesto)
                                + "\n* Si no modifica la compra no se registrará el último producto.",
                        "¿DESEA MODIFICAR LA ÚLTIMA COMPRA?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                total = (double) Math.round((total - costoProducto) * 100) / 100;
                presupuesto += costoProducto;
                if (continuar == JOptionPane.YES_OPTION) {
                    respuesta = 1;
                    n--;
                }
                if (continuar == JOptionPane.NO_OPTION) {
                    respuesta = 2;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "TOTAL A PAGAR: S/. " + String.format("%.2f", total));
    }
}