import java.io.Serializable;

public abstract class Vehiculo implements Serializable {
    private static int contadorID = 0;
    private int anio;

    private String nombre;
    private Boolean estadoMotor;
    private int id;

    private int km;
    private COLOR color;


    // Constructor por defecto
    public Vehiculo() {
        this.id = ++contadorID; // Incrementa el contador y asigna el ID único
    }

    // Constructor con parámetros
    public Vehiculo(int anio, int km, COLOR color, Boolean estadoMotor,String nombre) {
        this(); // Llama al constructor sin argumentos para asignar el ID único
        this.anio = anio;
        this.km = km;
        this.color = color;
        this.estadoMotor = estadoMotor;
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public Boolean getEstadoMotor() {
        return estadoMotor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstadoMotor(Boolean estadoMotor) {
        this.estadoMotor = estadoMotor;
    }

    // Método toString sobreescrito
    @Override
    public String toString() {
        String motorEstado = estadoMotor ? "El motor se encuentra en buen estado" : "El motor necesita mantenimiento";
        return "" +
                "\n  Nombre: " + nombre +
                "\n  Año: " + anio +
                "\n  Estado del Motor: " + motorEstado +
                "\n  ID: " + id +
                "\n  Kilometraje: " + km +
                "\n  Color: " + color +
                "\n";
    }

}
