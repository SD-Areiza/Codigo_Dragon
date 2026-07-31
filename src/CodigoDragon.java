import java.util.Scanner;

public class CodigoDragon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Personaje[] equipo = null;
        int opcion;
        boolean juegoActivo = true;

        do {
            System.out.println("\n========================================");
            System.out.println("      CÓDIGO DRAGÓN v1.0 - RPG");
            System.out.println("========================================");
            System.out.println("1. Crear escuadrón");
            System.out.println("2. Ver escuadrón");
            System.out.println("3. Combate");
            System.out.println("4. Tienda");
            System.out.println("5. Estadísticas");
            System.out.println("6. Buscar héroe");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.print("\n¿Cuántos héroes deseas crear? ");
                int cantidadHeroes = sc.nextInt();
                sc.nextLine();

                if (cantidadHeroes <= 0) {
                    System.out.println("La cantidad debe ser mayor a 0.");
                    continue;
                }

                equipo = new Personaje[cantidadHeroes];

                for (int i = 0; i < equipo.length; i++) {
                    equipo[i] = new Personaje();

                    System.out.println("\n--- Héroe " + (i + 1) + " ---");
                    System.out.print("Nombre: ");
                    equipo[i].nombre = sc.nextLine();

                    System.out.print("Clase (Guerrero/Mago/Arquero): ");
                    equipo[i].clase = sc.nextLine();

                    System.out.print("Nivel: ");
                    equipo[i].nivel = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Vida Máxima: ");
                    equipo[i].vidaMaxima = sc.nextInt();
                    sc.nextLine();

                    equipo[i].vida = equipo[i].vidaMaxima;

                    System.out.print("Ataque: ");
                    equipo[i].ataque = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Defensa: ");
                    equipo[i].defensa = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Oro inicial: ");
                    equipo[i].oro = sc.nextDouble();
                    sc.nextLine();

                    equipo[i].estaVivo = true;
                }

                System.out.println("\n¡Escuadrón creado exitosamente!");

            } else if (opcion == 2) {
                if (equipo == null) {
                    System.out.println("\nError: Debes crear un escuadrón primero.");
                    continue;
                }

                System.out.println("\n========================================");
                System.out.println("             ESTADO DEL ESCUADRÓN");
                System.out.println("========================================");
                System.out.printf("%-15s %-12s %-8s %-10s %-8s %-8s %-10s %s\n",
                    "Nombre", "Clase", "Nivel", "Vida", "Ataque", "Defensa", "Oro", "Estado");
                System.out.println("----------------------------------------");

                for (int i = 0; i < equipo.length; i++) {
                    String estado = equipo[i].estaVivo ? "Vivo" : "MUERTO";
                    System.out.printf("%-15s %-12s %-8d %-10d %-8d %-8d %-10.2f %s\n",
                        equipo[i].nombre,
                        equipo[i].clase,
                        equipo[i].nivel,
                        equipo[i].vida,
                        equipo[i].ataque,
                        equipo[i].defensa,
                        equipo[i].oro,
                        estado);
                }
                System.out.println("========================================");

            } else if (opcion == 3) {
                if (equipo == null) {
                    System.out.println("\nError: Debes crear un escuadrón primero.");
                    continue;
                }

                System.out.println("\n--- Selecciona un héroe para combatir ---");
                for (int i = 0; i < equipo.length; i++) {
                    System.out.println((i + 1) + ". " + equipo[i].nombre + " (Vida: " + equipo[i].vida + "/" + equipo[i].vidaMaxima + ")");
                }
                System.out.print("Selecciona el índice del héroe (1-" + equipo.length + "): ");
                int indiceHeroe = sc.nextInt();
                sc.nextLine();

                if (indiceHeroe < 1 || indiceHeroe > equipo.length) {
                    System.out.println("Índice inválido.");
                    continue;
                }

                indiceHeroe = indiceHeroe - 1;

                if (!equipo[indiceHeroe].estaVivo) {
                    System.out.println("Este héroe está muerto y no puede combatir.");
                    continue;
                }

                Personaje heroe = equipo[indiceHeroe];

                Personaje enemigo = new Personaje();
                enemigo.nombre = "Dragón Oscuro";
                enemigo.clase = "Dragón";
                enemigo.nivel = 10;
                enemigo.vidaMaxima = 100;
                enemigo.vida = 100;
                enemigo.ataque = 25;
                enemigo.defensa = 10;
                enemigo.oro = 500;
                enemigo.estaVivo = true;

                System.out.println("\n========================================");
                System.out.println("        ¡COMIENZA EL COMBATE!");
                System.out.println("========================================");
                System.out.println(heroe.nombre + " vs " + enemigo.nombre);

                int turno = 1;
                while (heroe.estaVivo && enemigo.estaVivo) {
                    System.out.println("\n--- TURNO " + turno + " ---");
                    System.out.println(heroe.nombre + " (Vida: " + heroe.vida + ")");
                    System.out.println(enemigo.nombre + " (Vida: " + enemigo.vida + ")");

                    int danoHeroe = heroe.ataque - enemigo.defensa;
                    if (danoHeroe < 0) {
                        danoHeroe = 0;
                    }
                    enemigo.vida = enemigo.vida - danoHeroe;
                    System.out.println(heroe.nombre + " ataca y causa " + danoHeroe + " de daño.");

                    if (enemigo.vida <= 0) {
                        enemigo.vida = 0;
                        enemigo.estaVivo = false;
                        System.out.println("¡" + enemigo.nombre + " ha sido derrotado!");
                        heroe.oro = heroe.oro + enemigo.oro;
                        System.out.println("¡" + heroe.nombre + " gana " + enemigo.oro + " de oro!");
                        break;
                    }

                    int danoEnemigo = enemigo.ataque - heroe.defensa;
                    if (danoEnemigo < 0) {
                        danoEnemigo = 0;
                    }
                    heroe.vida = heroe.vida - danoEnemigo;
                    System.out.println(enemigo.nombre + " ataca y causa " + danoEnemigo + " de daño.");

                    if (heroe.vida <= 0) {
                        heroe.vida = 0;
                        heroe.estaVivo = false;
                        System.out.println("¡" + heroe.nombre + " ha sido derrotado!");
                        break;
                    }

                    turno = turno + 1;
                }

                System.out.println("\n========================================");
                System.out.println("        ¡COMBATE TERMINADO!");
                System.out.println("========================================");

            } else if (opcion == 4) {
                if (equipo == null) {
                    System.out.println("\nError: Debes crear un escuadrón primero.");
                    continue;
                }

                System.out.println("\n--- Tienda de Pociones ---");
                for (int i = 0; i < equipo.length; i++) {
                    System.out.println((i + 1) + ". " + equipo[i].nombre + " (Oro: " + equipo[i].oro + ", Vida: " + equipo[i].vida + "/" + equipo[i].vidaMaxima + ")");
                }
                System.out.print("Selecciona el índice del héroe (1-" + equipo.length + "): ");
                int indiceHeroe = sc.nextInt();
                sc.nextLine();

                if (indiceHeroe < 1 || indiceHeroe > equipo.length) {
                    System.out.println("Índice inválido.");
                    continue;
                }

                indiceHeroe = indiceHeroe - 1;
                Personaje heroe = equipo[indiceHeroe];

                System.out.println("\n--- Pociones Disponibles ---");
                System.out.println("1. Poción Pequeña (50 vida, 25 oro)");
                System.out.println("2. Poción Mediana (100 vida, 50 oro)");
                System.out.println("3. Poción Grande (200 vida, 100 oro)");
                System.out.println("0. Cancelar");
                System.out.print("Selecciona una poción: ");
                int opcionPocion = sc.nextInt();
                sc.nextLine();

                switch (opcionPocion) {
                    case 1:
                        if (heroe.oro >= 25) {
                            heroe.vida = heroe.vida + 50;
                            if (heroe.vida > heroe.vidaMaxima) {
                                heroe.vida = heroe.vidaMaxima;
                            }
                            heroe.oro = heroe.oro - 25;
                            System.out.println("¡Poción Pequeña comprada! Vida actual: " + heroe.vida + "/" + heroe.vidaMaxima);
                        } else {
                            System.out.println("Oro insuficiente. Necesitas 25 oro.");
                        }
                        break;
                    case 2:
                        if (heroe.oro >= 50) {
                            heroe.vida = heroe.vida + 100;
                            if (heroe.vida > heroe.vidaMaxima) {
                                heroe.vida = heroe.vidaMaxima;
                            }
                            heroe.oro = heroe.oro - 50;
                            System.out.println("¡Poción Mediana comprada! Vida actual: " + heroe.vida + "/" + heroe.vidaMaxima);
                        } else {
                            System.out.println("Oro insuficiente. Necesitas 50 oro.");
                        }
                        break;
                    case 3:
                        if (heroe.oro >= 100) {
                            heroe.vida = heroe.vida + 200;
                            if (heroe.vida > heroe.vidaMaxima) {
                                heroe.vida = heroe.vidaMaxima;
                            }
                            heroe.oro = heroe.oro - 100;
                            System.out.println("¡Poción Grande comprada! Vida actual: " + heroe.vida + "/" + heroe.vidaMaxima);
                        } else {
                            System.out.println("Oro insuficiente. Necesitas 100 oro.");
                        }
                        break;
                    case 0:
                        System.out.println("Compra cancelada.");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }

            } else if (opcion == 5) {
                if (equipo == null) {
                    System.out.println("\nError: Debes crear un escuadrón primero.");
                    continue;
                }

                System.out.println("\n========================================");
                System.out.println("         ESTADÍSTICAS DEL EQUIPO");
                System.out.println("========================================");

                double totalOro = 0;
                double sumaVida = 0;
                int contadorVivos = 0;
                int maxAtaque = -999999;
                String nombreMasFuerte = "";
                int minVida = 999999;
                String nombreMasDebil = "";

                for (int i = 0; i < equipo.length; i++) {
                    totalOro = totalOro + equipo[i].oro;
                    sumaVida = sumaVida + equipo[i].vida;

                    if (equipo[i].estaVivo) {
                        contadorVivos = contadorVivos + 1;
                    }

                    if (equipo[i].ataque > maxAtaque) {
                        maxAtaque = equipo[i].ataque;
                        nombreMasFuerte = equipo[i].nombre;
                    }

                    if (equipo[i].vida < minVida) {
                        minVida = equipo[i].vida;
                        nombreMasDebil = equipo[i].nombre;
                    }
                }

                double promedioVida = sumaVida / (double) equipo.length;

                System.out.println("Total de oro del equipo: " + totalOro);
                System.out.printf("Promedio de vida: %.2f\n", promedioVida);
                System.out.println("Héroe más fuerte (Mayor ataque): " + nombreMasFuerte + " (Ataque: " + maxAtaque + ")");
                System.out.println("Héroe más débil (Menor vida): " + nombreMasDebil + " (Vida: " + minVida + ")");
                System.out.println("Héroes vivos: " + contadorVivos + " de " + equipo.length);
                System.out.println("========================================");

            } else if (opcion == 6) {
                if (equipo == null) {
                    System.out.println("\nError: Debes crear un escuadrón primero.");
                    continue;
                }

                System.out.print("\nIngresa el nombre del héroe a buscar: ");
                String nombreBuscado = sc.nextLine();

                int indiceBuscado = -1;
                for (int i = 0; i < equipo.length; i++) {
                    if (equipo[i].nombre.equalsIgnoreCase(nombreBuscado)) {
                        indiceBuscado = i;
                        break;
                    }
                }

                if (indiceBuscado != -1) {
                    Personaje heroBuscado = equipo[indiceBuscado];
                    System.out.println("\n========================================");
                    System.out.println("      INFORMACIÓN DEL HÉROE");
                    System.out.println("========================================");
                    System.out.println("Nombre: " + heroBuscado.nombre);
                    System.out.println("Clase: " + heroBuscado.clase);
                    System.out.println("Nivel: " + heroBuscado.nivel);
                    System.out.println("Vida: " + heroBuscado.vida + "/" + heroBuscado.vidaMaxima);
                    System.out.println("Ataque: " + heroBuscado.ataque);
                    System.out.println("Defensa: " + heroBuscado.defensa);
                    System.out.println("Oro: " + heroBuscado.oro);
                    String estado = heroBuscado.estaVivo ? "Vivo" : "MUERTO";
                    System.out.println("Estado: " + estado);
                    System.out.println("========================================");
                } else {
                    System.out.println("El héroe '" + nombreBuscado + "' no fue encontrado en el escuadrón.");
                }

            } else if (opcion == 0) {
                juegoActivo = false;

            } else {
                System.out.println("Opción inválida. Intenta de nuevo.");
            }

        } while (juegoActivo);

        System.out.println("\n========================================");
        System.out.println("       ¡GRACIAS POR JUGAR!");
        System.out.println("   CÓDIGO DRAGÓN v1.0 - FIN DE PARTIDA");
        System.out.println("========================================");
        System.out.println("Fue una aventura épica. ¡Vuelve pronto!");
        System.out.println("========================================\n");

        sc.close();
    }
}

