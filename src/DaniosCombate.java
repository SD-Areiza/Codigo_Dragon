public class DaniosCombate {
    public static void main(String[] args) {
        int[] golpes = {12, 25, 8, 30, 15, 22};

        System.out.println("Longitud del array: " + golpes.length);
        System.out.println("Primer golpe: " + golpes[0]);
        System.out.println("Último golpe: " + golpes[golpes.length - 1]);

        int suma = 0;
        for (int i = 0; i < golpes.length; i++) {
            suma += golpes[i];
        }

        System.out.println("Daño total: " + suma);
    }
}

