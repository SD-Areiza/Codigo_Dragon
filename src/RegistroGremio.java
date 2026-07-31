import java.util.Scanner;

public class RegistroGremio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== REGISTRO DEL GREMIO ===");
        System.out.print("Nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();

        System.out.print("Vida base: ");
        int vida = sc.nextInt();

        System.out.print("Ataque base: ");
        int ataque = sc.nextInt();

        System.out.print("Defensa base: ");
        int defensa = sc.nextInt();

        System.out.print("Oro inicial: ");
        double oro = sc.nextDouble();

        sc.nextLine(); // Limpieza OBLIGATORIA del buffer antes de leer otro texto

        System.out.print("Clase 1. Guerrero, 2. Mago, 3. Arquero): ");
        int opcionClase = sc.nextInt();
        String clase = "";
        switch (opcionClase) {
            case 1:
                clase = "Guerrero";
                break;
            case 2:
                clase = "Mago";
                break;
            case 3:
                clase = "Arquero";
                break;
            default:
                clase = "Desconocida";
        }

        int poder = (ataque * 3) + (defensa * 2);
        int nivel = vida / 10;
        double oroRestante = oro - 50.0;

        System.out.println("\n========== FICHA ==========");
        System.out.println("Héroe: " + nombre + " (" + clase + ")");
        System.out.println("Poder: " + poder);
        System.out.println("Nivel: " + nivel);
        System.out.println("Oro restante: " + oroRestante);

        sc.close();
    }
}
