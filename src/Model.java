import java.util.ArrayList;
import java.util.List;

/**
 * Capa Modelo: Gestiona el almacenamiento y lógica de los vehículos.
 * * @author Alan
 * @version 6.8
 */
public class Model {

    static ArrayList<Coche> parking = new ArrayList<>();

    public Coche addCoche(String modelo, String matricula) {
        Coche auxiliar = new Coche(modelo, matricula);
        parking.add(auxiliar);
        return auxiliar;
    }

    public Coche buscarCoche(String matricula) {
        for (Coche e : parking) {
            if (e.matricula.equals(matricula)) {
                return e;
            }
        }
        return null;
    }

    public Coche sumarKm(String matricula) {
        Coche auxiliar = buscarCoche(matricula);
        if (auxiliar != null) {
            auxiliar.km++;
            auxiliar.combustible--;
        }
        return auxiliar;
    }

    /**
     * Restablece el nivel de combustible de un coche a 50 unidades.
     *
     * @param matricula Matrícula del coche a repostar.
     * @return Objeto {@code Coche} actualizado o {@code null} si no existe.
     */
    public Coche repostar(String matricula) {
        Coche auxiliar = buscarCoche(matricula);
        if (auxiliar != null) {
            auxiliar.combustible = 50;
        }
        return auxiliar;
    }

    public List<Coche> getLista() {
        return parking;
    }
}