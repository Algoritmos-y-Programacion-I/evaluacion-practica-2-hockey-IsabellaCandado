package ui;

import java.util.*;
import model.Controller;

public class Executable {

    private Scanner escaner;
    private Controller controladora;
    private static boolean flag;

    /**
     * Constructor de la clase Executable para inicializar el lector de entrada y el
     * controlador.
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Executable y se inicializan el lector de
     *       entrada y el controlador.
     */
    public Executable() {
        escaner = new Scanner(System.in);
        controladora = new Controller();
    }

    /**
     * Ejecuta el programa principal.
     *
     * @pre El método debe ser llamado dentro de un contexto válido.
     * @post El programa se ejecuta y permite al usuario interactuar con las
     *       opciones disponibles.
     * @return void Este método no retorna ningún valor.
     */

    public void run(boolean flag) {

        flag = false;

		while (!flag) {

			System.out.println("\n \n Bienvenido al menu:\n");
			System.out.println("Opciones:\n" + "1. Precargar informacion \n" 
					+ "2. Fixture \n" + "3. Realizar partido entre 2 equipos \n" + "4. Salir del programa \n");

			int option = escaner.nextInt();

			escaner.nextLine();

			switch (option) {
					case 1:
                        preload();
						break;
					case 2:
                        fixture();
						break;
					case 3:
                        partido();
						break;
					case 4:
                        System.out.println("Saliendo de la app...");
						flag = true;
						System.exit(0);
						break;
					default:
						System.out.print("Por favor ingrese una opcion valida");
						continue;
			}

		}

    }

    /**
     * Método principal (main) para iniciar la ejecución del programa.
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Executable y se ejecuta el programa principal.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este
     *             caso).
     */
    public static void main(String[] args) {

        Executable mainApp = new Executable();
        mainApp.run(flag);

    }

    public void preload() {
        controladora.preload();
        System.out.println("Informacion precargada exitosamente.");

        System.out.println(controladora.mostrarEquipos());
        System.out.println(controladora.mostrarArbitros());
    }

    public void fixture() {
        System.out.println(controladora.fixture());
    }

    public void partido() {
        System.out.println(controladora.jugada());
    }

}