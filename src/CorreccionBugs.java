public class CorreccionBugs {
    public static void main(String[] args) {
        // 1) Declarar un arreglo y no pasarse de su límite
        // Correcto:
        // int[] arr = new int[3];
        // arr[0] = 1; arr[1] = 2; arr[2] = 3; // índices válidos: 0..arr.length-1
        // Evitar acceder a arr[3] porque producirá ArrayIndexOutOfBoundsException

        // 2) Evitar bucle infinito sumando i++ en un while
        // Correcto:
        // int i = 0;
        // while (i < 5) {
        //     System.out.println(i);
        //     i++; // importante: avanzar el contador
        // }

        // 3) Poner break en un switch para evitar fall-through
        // Correcto:
        // int x = 2;
        // switch (x) {
        //     case 1:
        //         System.out.println("uno");
        //         break;
        //     case 2:
        //         System.out.println("dos");
        //         break;
        //     default:
        //         System.out.println("otro");
        // }

        // 4) Evitar poner ';' inmediatamente después de un if (...)
        // Incorrecto: if (condicion); { // el ';' termina el if
        // Correcto:
        // if (true) {
        //     System.out.println("Se ejecuta correctamente sin ';' después del if");
        // }

        // Nota: Los ejemplos anteriores están comentados para mostrar la forma correcta.
        // Si desea probarlos, descomente cada bloque y ejecútelos por separado dentro de main.
    }
}

