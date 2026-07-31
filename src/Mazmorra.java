public class Mazmorra {
    public static void main(String[] args) {
        Enemigo goblin = new Enemigo();
        goblin.nombre = "Goblin";
        goblin.vida = 30;
        goblin.ataque = 6;
        goblin.recompensaOro = 5.0;
        goblin.esJefe = false;

        Enemigo dragon = new Enemigo();
        dragon.nombre = "Dragon";
        dragon.vida = 300;
        dragon.ataque = 40;
        dragon.recompensaOro = 500.0;
        dragon.esJefe = true;

        System.out.println("Enemigo 1: " + goblin.nombre + ", vida=" + goblin.vida + ", ataque=" + goblin.ataque + ", oro=" + goblin.recompensaOro + ", esJefe=" + goblin.esJefe);
        System.out.println("Enemigo 2: " + dragon.nombre + ", vida=" + dragon.vida + ", ataque=" + dragon.ataque + ", oro=" + dragon.recompensaOro + ", esJefe=" + dragon.esJefe);

        if (dragon.esJefe) {
            System.out.println(dragon.nombre + " es un jefe.");
        } else {
            System.out.println(dragon.nombre + " no es un jefe.");
        }
    }
}

