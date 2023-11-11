import java.util.LinkedList;
import java.util.Queue;

public class Taller {
    Queue<Vehiculo> colaTaller = new LinkedList<>();

    // Método para agregar un vehículo al taller
    public void agregarVehiculo(Vehiculo vehiculo) {
        colaTaller.add(vehiculo);
    }

    // Método para quitar un vehículo del taller
    public Vehiculo quitarVehiculo() {
        return colaTaller.poll(); // Elimina y devuelve el primer vehículo en la cola
    }

    // Método para ver todos los vehículos en el taller
    public void verVehiculosEnTaller() {
        for (Vehiculo vehiculo : colaTaller) {
            System.out.println("En taller");
            System.out.println(vehiculo.toString());

        }
    }
}
