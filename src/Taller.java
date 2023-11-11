import java.util.LinkedList;
import java.util.Queue;
import java.io.Serializable;
public class Taller implements Serializable  {
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
        System.out.println("***************************************************************************************************************************************************|");
        System.out.println("----------------------------------------------------------|VEHICULOS EN TALLER|--------------------------------------------------------------------|");
        System.out.println("***************************************************************************************************************************************************|");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n", "Nombre", "Marca", "Carroceria", "Año", "Color",  "Kilometraje","Estado del motor");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------|");
        //Recorro la lista de vehiculos guardados y los muestro por pantalla
        for (Vehiculo vehiculo : colaTaller) {
            if (vehiculo instanceof Camionetas) {
                //Casteo el vehiculo de clase vehiculo a Camioneta
                Camionetas camioneta = (Camionetas) vehiculo;
                System.out.printf("| %-15s | %-15s | %-15s | %-15d | %-15s | %-15d | %-20s |\n",
                        camioneta.getNombre(), camioneta.getMarca(), camioneta.getCarroceria(), camioneta.getAnio(),
                        camioneta.getColor(), camioneta.getKm(), camioneta.getEstadoMotor() ? "El motor se encuentra en buen estado" : "El motor necesita mantenimiento");
            } else if (vehiculo instanceof Automovil) {
                //Casteo el vehiculo de clase vehiculo a Automovil
                Automovil automovil = (Automovil) vehiculo;
                System.out.printf("| %-15s | %-15s | %-15s | %-15d | %-15s | %-15d | %-20s |\n",
                        automovil.getNombre(), automovil.getMarca(), automovil.getCarroceria(), automovil.getAnio(),
                        automovil.getColor(), automovil.getKm(), automovil.getEstadoMotor()? "El motor se encuentra en buen estado" : "El motor necesita mantenimiento");
            } else if (vehiculo instanceof Motocicletas) {
                //Casteo el vehiculo de clase vehiculo a Motocicleta
                Motocicletas motocicleta = (Motocicletas) vehiculo;
                System.out.printf("| %-15s | %-15s | %-15s | %-15d | %-15s | %-15d | %-20s |\n",
                        motocicleta.getNombre(), motocicleta.getMarca(), "-----", motocicleta.getAnio(),
                        motocicleta.getColor(), motocicleta.getKm(), motocicleta.getEstadoMotor()? "El motor se encuentra en buen estado" : "El motor necesita mantenimiento");
            } else {
                System.out.println("Es de otra clase");
            }
        }
    }
    // Método para obtener todos los vehículos en el taller
    public LinkedList<Vehiculo> obtenerVehiculosEnTaller() {
        LinkedList<Vehiculo> vehiculos = new LinkedList<>();
        for (Vehiculo vehiculo : colaTaller) {
            vehiculos.add(vehiculo);
        }
        return vehiculos;
    }
    public LinkedList<Vehiculo> agregarListaVehiculosEnTaller(LinkedList<Vehiculo> vehiculos) {
        for (Vehiculo vehiculo : vehiculos) {
            colaTaller.add(vehiculo);
        }
        return vehiculos;
    }

}
