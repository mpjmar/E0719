public class App {
    public static void main(String[] args) throws Exception {

        int array[] = generaAleatorios(12, 0, 200);
        muestraArray(array);
        int num = 0, pos = -1;
        boolean correcto = false;
        try {
            System.out.print("Introduzca el número que quere insertar: ");
            num = Integer.parseInt(System.console().readLine());
            do {
                System.out.print("Introduzca la posición donde lo quiere insertar (0 - 11): ");
                pos = Integer.parseInt(System.console().readLine());
                correcto = pos >= 0 && pos < 12;
            } while (!correcto);
        }
        catch (NumberFormatException e) {
            System.out.println("El número debe ser un entero.");
        }
        catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado.");
        }
        int resultado[] = insertaNum(array, num, pos);
        muestraArray(resultado);
    }

    public static void muestraArray(int array[]) {
        System.out.print("┌────────");
        for (int i = 0; i < array.length; i++)
            System.out.print("┬─────");
        System.out.println("┐");

        System.out.print("│ Indice ");
        for (int i = 0; i < array.length; i++)
            System.out.printf("│%4s ", i);
        System.out.println("│");

        System.out.print("├────────");
        for (int i = 0; i < array.length; i++)
            System.out.print("┼─────");
        System.out.println("┤");

        System.out.print("│ Valor  ");
        for (int i = 0; i < array.length; i++)
            System.out.printf("│%4s ", array[i]);
        System.out.println("│");

        System.out.print("└────────");
        for (int i = 0; i < array.length; i++)
            System.out.print("┴─────");
        System.out.println("┘");
        System.out.println();
    }

    public static int[] insertaNum(int array[], int num, int pos) {
        int resultado[] = new int[array.length];
        resultado = array;
        for (int i = array.length - 1; i > pos; i--) {
            resultado[i] = resultado[i - 1]; 
        }
        resultado[pos] = num;
        return resultado;
    }

    public static int[] generaAleatorios(int cantidad, int min, int max) {
        int aleatorios[] = new int[cantidad];
        for (int i = 0; i < aleatorios.length; i++)
            aleatorios[i] = (int)(Math.random() * (max - min + 1)) + min;
        return aleatorios;
    }
}
