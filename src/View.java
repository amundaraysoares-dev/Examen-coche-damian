import java.util.Scanner;
import java.util.List;

/**
 * Clase encargada de la interfaz de usuario del sistema (Vista).
 *Implementa un menú por consola que permite al usuario interactuar
 * con el sistema de gestión de parking.
 * A través de esta clase se capturan datos de los coches,
 * se solicitan operaciones al controlador y se muestran resultados.
 * @author Alan
 * @version 6.7

 */
public class View {

    public void menu() {
        Controller c = new Controller();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=== GESTIÓN DE PARKING ===");
            System.out.println("1. Agregar Coche");
            System.out.println("2. Avanzar Coche");
            System.out.println("3. Coches en el parking");
            System.out.println("4. Poner Gasolina");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Modelo: ");
                    String mod = teclado.nextLine();
                    System.out.print("Matrícula: ");
                    String mat = teclado.nextLine();
                    c.guardarCoche(mod, mat);
                    System.out.println("Coche registrado.");
                    break;

                case 2:
                    System.out.print("Matrícula para mover: ");
                    Coche movido = c.moverCoche(teclado.nextLine());
                    if (movido != null) System.out.println("Nuevo kilometraje: " + movido.km + " baja gasolina " + movido.combustible);
                    else System.out.println("No encontrado.");
                    break;

                case 3:
                    List<Coche> lista = c.mostrarTodos();
                    for (Coche ch : lista) {
                        System.out.println(ch.modelo + " [" + ch.matricula + "] - Km: " + ch.km + " - Gas: " + ch.combustible + "L");
                    }
                    break;

                case 4:
                    System.out.print("Matrícula para repostar: ");
                    Coche gas = c.ponerGasolina(teclado.nextLine());
                    if (gas != null) System.out.println("Tanque lleno");
                    else System.out.println("No encontrado.");
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 5);
        teclado.close();
    }
}