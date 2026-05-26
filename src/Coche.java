/**
 * Representa un vehículo terrestre de tipo coche dentro del sistema.
 * Almacena la información básica del automóvil, incluyendo combustible.
 *
 * @author Alan
 * @version 6.8
 */
public class Coche {

    public String matricula;
    public String modelo;
    public int km;
    /**
     * Nivel de combustible actual del vehículo.
     */
    public int combustible;

    /**
     * Constructor de la clase {@code Coche}.
     * Inicializa modelo, matrícula, km a 0 y combustible al máximo (50L).
     *
     * @param modelo Modelo del coche.
     * @param matricula Matrícula identificativa del coche.
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.km = 0;
        this.combustible = 50;
    }
}