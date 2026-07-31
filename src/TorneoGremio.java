import java.util.Scanner;

public class TorneoGremio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inicializaciones ANTES del ciclo
        int vida = 100;
        int oro = 0;
        int peleasGanadas = 0;
        int opcion;

        do {
            System.out.println("\n=== MENÚ DEL TORNEO ===");
            System.out.println("1. Pelear");
            System.out.println("2. Descansar");
            System.out.println("3. Ver estado");
            System.out.println("4. Retirarse");
            System.out.print("Elige: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                vida -= 15;
                oro += 40;
                peleasGanadas++;
                System.out.println("vida restante: " + vida );
                System.out.println("¡Ganaste la pelea!");
            } else if (opcion == 2) {
                if (oro >= 10) {
                    oro -= 10;
                    vida += 20;
                    if (vida > 100) {
                        vida = 100;
                    }
                    System.out.println("Descansaste y recuperaste vida.");
                    System.out.println("ahora tienes " + vida + " de vida.");
                } else {
                    System.out.println("No tienes oro suficiente para descansar.");
                }
            } else if (opcion == 3) {
                System.out.println("Vida: " + vida + " | Oro: " + oro + " | Ganadas: " + peleasGanadas);
            }

            if (vida <= 0) {
                System.out.println("Has sido eliminado del torneo.");
            }

        } while (opcion != 4 && vida > 0);

        System.out.println("\n=== RESUMEN FINAL ===");
        System.out.println("Peleas ganadas: " + peleasGanadas);
        System.out.println("Oro final: " + oro);
        System.out.println("Vida final: " + vida);

        sc.close();
    }
}