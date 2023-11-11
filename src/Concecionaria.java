import java.util.LinkedList;
import java.io.Serializable;

public class Concecionaria implements Serializable {
    LinkedList<Vehiculo> listaDeVehiculos = new LinkedList<>();

    // Método para agregar un vehículo a la lista
    public void agregarVehiculo(Vehiculo vehiculo) {
        // Agrega el vehículo a la lista
        listaDeVehiculos.add(vehiculo);
    }

    // Método para ver la lista de vehículos
    public void verVehiculos() {
        System.out.println("Lista de vehículos en la concesionaria:");
        // Recorre la lista de vehículos y los imprime
        for (Vehiculo vehiculo : listaDeVehiculos) {
            System.out.println(vehiculo.toString());
        }
    }

    // Método para eliminar un vehículo de la lista
    public void eliminarVehiculo(int id) {
        // Recorre la lista de vehículos
        for (Vehiculo vehiculo : listaDeVehiculos) {
            // Si el id del vehículo es igual al id ingresado, lo elimina
            if (vehiculo.getId() == id) {
                // Elimina el vehículo de la lista
                listaDeVehiculos.remove(vehiculo);
                System.out.println("Vehículo eliminado");
                return;
            }

        }
        System.out.println("Vehículo no encontrado");

    }
    public LinkedList<Vehiculo> obtenerListaDeVehiculos() {
        return listaDeVehiculos;
    }
    public void agregarListaDeVehiculos(LinkedList<Vehiculo> listaNueva) {
        // Agrega el vehículo a la lista
        listaDeVehiculos.addAll(listaNueva);

    }
}
