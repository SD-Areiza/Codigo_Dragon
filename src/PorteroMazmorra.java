import java.util.Scanner;

public class PorteroMazmorra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nivel del visitante (int): ");
        int nivel = sc.nextInt();

        System.out.print("Vida del visitante (int): ");
        int vida = sc.nextInt();

        // Limpiar buffer antes de leer texto
        sc.nextLine();

        System.out.print("¿Pertenece al gremio? (si/no): ");
        String pertenece = sc.nextLine();

        int nivelMinimo = pertenece.equalsIgnoreCase("si") ? 8 : 10;

        if (nivel >= nivelMinimo && vida > 0) {
            System.out.println("Entrada permitida. ¡Adelante!");
        } else {
            System.out.println("Entrada denegada por: ");
            if (nivel < nivelMinimo) {
                System.out.println("- Nivel insuficiente. Se requiere nivel mínimo de " + nivelMinimo + ".");
            }
            if (vida <= 0) {
                System.out.println("- Vida insuficiente (debe ser mayor que 0).");
            }
        }

        sc.close();
    }
}

