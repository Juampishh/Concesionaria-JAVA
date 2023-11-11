import java.io.Serializable;

public class Motocicletas extends Vehiculo implements Serializable {
    private MOTOMARCA marca;

    private int cc;
    // Constructor por defecto
    public Motocicletas(){}
    // Constructor con parámetros
    public Motocicletas(MOTOMARCA marca) {
        this.marca = marca;
    }

    // Constructor con parámetros + herencia
    public Motocicletas(int anio, int km, COLOR color,Boolean estadoMotor ,String nombre,MOTOMARCA marca) {
        super(anio, km, color,estadoMotor,nombre);
        this.marca = marca;
    }
    //Getters y Setters
    public MOTOMARCA getMarca() {
        return marca;
    }

    public void setMarca(MOTOMARCA marca) {
        this.marca = marca;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }
    // Método toString sobreescrito

    @Override
    public String toString() {
        return "Motocicletas {" +
                "\n  Marca: " + marca +
                super.toString() +
                "\n";
    }
}
