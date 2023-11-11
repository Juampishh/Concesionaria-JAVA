import java.io.Serializable;

public class Automovil  extends Vehiculo implements Serializable,Mantenimiento {
    private AUTOMARCA marca;
    private CARROCERIA carroceria;

    // Constructor vacio para JavaBeans
    public Automovil(){}
    // Constructor con todos los atributos menos el id
    public Automovil(AUTOMARCA marca, CARROCERIA carroceria) {
        this.marca = marca;
        this.carroceria = carroceria;
    }

    // Constructor con todos los atributos

    public Automovil(int anio, int km, COLOR color,Boolean estadoMotor,String nombre ,AUTOMARCA marca, CARROCERIA carroceria) {
        super(anio, km, color,estadoMotor,nombre);
        this.marca = marca;
        this.carroceria = carroceria;
    }

    // Getters y setters
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
        return "Automovil {" +
                "\n  Marca: " + marca +
                "\n  Carrocería: " + carroceria +
                super.toString() + // Llama al toString de la superclase Vehiculo
                "\n}";
    }

    // Método para saber si necesita mantenimiento
    public Boolean necesitaMantenimiento(){
        if(this.getEstadoMotor() == true){
            return true ;
        }else{

            return false;
        }
    }
}
