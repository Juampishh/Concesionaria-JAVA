import java.io.Serializable;

public class Camionetas extends Vehiculo implements Serializable {
    private AUTOMARCA marca;
    private CARROCERIA carroceria;

    // Constructor por defecto
    public Camionetas(){}
    // Constructor con parámetros
    public Camionetas(AUTOMARCA marca, CARROCERIA carroceria) {
        this.marca = marca;
        this.carroceria = carroceria;
    }

    // Constructor con parámetros + herencia
    public Camionetas(int anio, int km, COLOR color,Boolean estadoMotor ,String nombre,AUTOMARCA marca, CARROCERIA carroceria) {
        super(anio, km, color,estadoMotor,nombre);
        this.marca = marca;
        this.carroceria = carroceria;
    }

    // Getters y Setters
    public AUTOMARCA getMarca() {
        return marca;
    }

    public void setMarca(AUTOMARCA marca) {
        this.marca = marca;
    }

    public CARROCERIA getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(CARROCERIA carroceria) {
        this.carroceria = carroceria;
    }

    // Método toString sobreescrito
    @Override
    public String toString() {
        return "Camionetas {" +
                "\n  Marca: " + marca +
                "\n  Carrocería: " + carroceria +
                super.toString() + // Llama al toString de la superclase Vehiculo
                "\n}";
    }

}
