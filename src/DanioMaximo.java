public class DanioMaximo {
    public static void main(String[] args) {
        int[] golpes = {12, 25, 8, 30, 15, 22};

        int maximo = golpes[0];
        int posMax = 0;

        for (int i = 1; i < golpes.length; i++) {
            if (golpes[i] > maximo) {
                maximo = golpes[i];
                posMax = i;
            }
        }

        System.out.println("Golpe más fuerte: " + maximo);
        System.out.println("Turno del golpe más fuerte: " + (posMax + 1));
    }
}

