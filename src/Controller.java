import java.util.List;

/**
 * Capa Controlador: Orquesta la comunicación entre Vista y Modelo.
 * * @author Alan
 * @version 6.8
 */
public class Controller {

    static View miView = new View();
    Model database = new Model();

    public static void main(String[] args) {
        miView.menu();
    }

    public boolean guardarCoche(String modelo, String matricula) {
        Coche creado = database.addCoche(modelo, matricula);
        return creado != null;
    }

    public Coche moverCoche(String matricula) {
        return database.sumarKm(matricula);
    }

    /**
     * Gestiona la petición de poner gasolina a un coche.
     *
     * @param matricula Matrícula del vehículo.
     * @return Objeto {@code Coche} con el combustible actualizado.
     */
    public Coche ponerGasolina(String matricula) {
        return database.repostar(matricula);
    }

    public List<Coche> mostrarTodos() {
        return database.getLista();
    }
}