import java.util.Scanner;

public class TiendaPociones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Oro actual: ");
        int oro = sc.nextInt();
        System.out.print("Vida actual: ");
        int vida = sc.nextInt();
        int ataque = 45;

        System.out.println("\n=== TIENDA ===");
        System.out.println("1. Poción pequeña (20 oro) -> +30 vida");
        System.out.println("2. Poción grande (50 oro) -> +80 vida");
        System.out.println("3. Elixir de fuerza (120 oro) -> +10 ataque");
        System.out.println("4. Salir");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();

        int precio = 0;
        int curaVida = 0;
        int subeAtaque = 0;

        switch (opcion) {
            case 1:
                precio = 20;
                curaVida = 30;
                break;
            case 2:
                precio = 50;
                curaVida = 80;
                break;
            case 3:
                precio = 120;
                subeAtaque = 10;
                break;
            case 4:
                System.out.println("Vuelve pronto.");
                break;
            default:
                System.out.println("Opción no válida.");
        }

        if (opcion >= 1 && opcion <= 3) {
            if (oro >= precio) {
                oro -= precio;
                vida += curaVida;
                ataque += subeAtaque;

                if (vida > 150) {
                    vida = 150;
                    System.out.println("¡Vida al máximo!");
                }
                System.out.println("Compra exitosa.");
            } else {
                System.out.println("Oro insuficiente. Te faltan " + (precio - oro) + " monedas.");
            }
        }

        System.out.println("\nEstado final -> Oro: " + oro + " | Vida: " + vida + " | Ataque: " + ataque);
        sc.close();
    }
}
