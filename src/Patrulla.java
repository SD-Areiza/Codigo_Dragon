public class Patrulla {
    public static void main(String[] args) {
        Personaje[] patrulla = new Personaje[4];

        for (int i = 0; i < patrulla.length; i++) {
            // Obligatorio: instanciar antes de asignar atributos
            patrulla[i] = new Personaje();
            patrulla[i].nombre = "Guardia " + (i + 1);
            patrulla[i].vida = 50 + (i * 10);
        }

        System.out.println("Patrulla:");
        for (int i = 0; i < patrulla.length; i++) {
            System.out.println("- " + patrulla[i].nombre + ", vida=" + patrulla[i].vida);
        }
    }
}

