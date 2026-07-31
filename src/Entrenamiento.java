public class Entrenamiento {
    public static void main(String[] args) {
        int experiencia = 0;
        int sesiones = 0;

        while (experiencia < 100) {
            experiencia += 5;
            sesiones++;
        }

        System.out.println("Número total de sesiones necesarias: " + sesiones);
    }
}

