import java.util.Scanner;

public class TiendaHerrero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu oro disponible (double): ");
        double oro = sc.nextDouble();

        System.out.print("Introduce el precio de una espada (double): ");
        double precio = sc.nextDouble();

        System.out.print("¿Cuántas espadas quieres? (int): ");
        int cantidad = sc.nextInt();

        // Limpiar buffer antes de leer texto
        sc.nextLine();

        System.out.print("Nombre personalizado del arma: ");
        String nombreArma = sc.nextLine();

        double costoTotal = precio * cantidad;
        double oroRestante = oro - costoTotal;

        System.out.println("\nResumen de compra:");
        System.out.println("Arma: " + nombreArma);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Costo total: " + costoTotal);
        System.out.println("Oro restante: " + oroRestante);

        sc.close();
    }
}

