import java.util.LinkedList;
import java.util.Scanner;
import  java.io.*;



public class Main {
    public static void main(String[] args) {
        Concecionaria concecionaria = new Concecionaria();
        Taller taller = new Taller();
        Scanner scanner = new Scanner(System.in);
/*
        //Instanciamos Camioneta de muestra
        Camionetas Hilux = new Camionetas();
        Hilux.setNombre("Hilux");
        Hilux.setMarca(AUTOMARCA.TOYOTA);
        Hilux.setCarroceria(CARROCERIA.PICKUP);
        Hilux.setColor(COLOR.BLANCO);
        Hilux.setAnio(2023);
        Hilux.setKm(0);
        Hilux.setEstadoMotor(true);
        //Instanciamos Auto de muestra
        Automovil AudiTT = new Automovil();
        AudiTT.setNombre("Audi TT");
        AudiTT.setMarca(AUTOMARCA.AUDI);
        AudiTT.setCarroceria(CARROCERIA.COUPE);
        AudiTT.setColor(COLOR.AMARILLO);
        AudiTT.setAnio(2023);
        AudiTT.setKm(0);
        AudiTT.setEstadoMotor(true);
        //Instanciamos Motocicleta de muestra
        Motocicletas Wave = new Motocicletas();
        Wave.setNombre("Wave");
        Wave.setMarca(MOTOMARCA.HONDA);
        Wave.setKm(1000);
        Wave.setAnio(2021);
        Wave.setColor(COLOR.AZUL);
        Wave.setEstadoMotor(true);
        //Agregamos vehiculos de muestra para la concecionaria
        concecionaria.agregarVehiculo(Hilux);
        concecionaria.agregarVehiculo(AudiTT);
        concecionaria.agregarVehiculo(Wave);

*/
        // Carga la lista de vehículos al inicio del programa
        LinkedList<Vehiculo> vehiculosGuardados =  RecuperarVehiculos.recuperarVehiculos("lista_vehiculos.dat");
        if (vehiculosGuardados != null) {
            concecionaria.agregarListaDeVehiculos(vehiculosGuardados);
        }

        // Carga la lista de vehículos en el taller al inicio del programa
        LinkedList<Vehiculo> vehiculosEnTaller = RecuperarVehiculos.recuperarVehiculos("lista_vehiculos-en-taller.dat");
        if (vehiculosEnTaller != null) {
            taller.agregarListaVehiculosEnTaller(vehiculosEnTaller);
        }

        System.out.println("**********************************************************");
        System.out.println("**********||BIENVENIDO A CONCESIONARIA MERINO||*********++");
        System.out.println("**********************************************************");


        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1) Ver catálogo de vehículos");
            System.out.println("2) Agregar un vehículo al catálogo");
            System.out.println("3) Consultar taller");
            System.out.println("4) Eliminar un vehículo del stock");
            System.out.println("5) Salir");

            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Selecciono ver Catálogo de vehículos:");
                    System.out.println("***************************************************************************************************************************************************|");
                    System.out.println("-------------------------------------------------------|CATALOGO DE VEHICULOS|---------------------------------------------------------------------|");
                    System.out.println("***************************************************************************************************************************************************|");
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------|");
                    System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n", "Nombre", "Marca", "Carroceria", "Año", "Color",  "Kilometraje","Estado del motor");
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------|");
                    //Recorro la lista de vehiculos guardados y los muestro por pantalla
                    for (Vehiculo vehiculo : vehiculosGuardados) {
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
                        break;
                case 2:
                    System.out.println("Selecciono Agregar un vehículo al catálogo:");
                    System.out.println("********************************************");
                    try{
                        System.out.println("--Que tipo de vehiculo desea agregar al catalogo--");
                        System.out.println("1) Camioneta");
                        System.out.println("2) Automovil");
                        System.out.println("3) Motocicleta");
                        System.out.println("4) Salir");
                        System.out.print("Selecciona una opción: ");
                        int eleccion = scanner.nextInt();
                        switch (eleccion){
                            case 1 :
                                //Instancio la camioneta
                                Camionetas camioneta = new Camionetas();
                                System.out.println("Ingrese el nombre de la camioneta");
                                String nombre = scanner.next();
                                camioneta.setNombre(nombre);
                                System.out.println("Ingrese la marca de la camioneta");
                                //FORD,TOYOTA,BMW,AUDI,RENAULT;
                                System.out.println("1) FORD");
                                System.out.println("2) TOYOTA");
                                System.out.println("3) BMW");
                                System.out.println("4) AUDI");
                                System.out.println("5) RENAULT");
                                System.out.print("Selecciona una opción: ");
                                int marca = scanner.nextInt();
                                //Switch para seleccionar la marca de la camioneta
                                switch (marca){
                                    case 1:
                                        camioneta.setMarca(AUTOMARCA.FORD);
                                        break;
                                    case 2:
                                        camioneta.setMarca(AUTOMARCA.TOYOTA);
                                        break;
                                    case 3:
                                        camioneta.setMarca(AUTOMARCA.BMW);
                                        break;
                                    case 4:
                                        camioneta.setMarca(AUTOMARCA.AUDI);
                                        break;
                                    case 5:
                                        camioneta.setMarca(AUTOMARCA.RENAULT);
                                        break;
                                    default:
                                        System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                                        break;
                                }
                                System.out.println("Ingrese la carroceria de la camioneta");
                                //PICKUP, SUV, VAN;
                                System.out.println("1) PICKUP");
                                System.out.println("2) SUV");
                                System.out.println("3) MINIVAN");
                                System.out.print("Selecciona una opción: ");
                                int carroceria = scanner.nextInt();
                                //Switch para seleccionar la carroceria de la camioneta
                                switch (carroceria){
                                    case 1:
                                        camioneta.setCarroceria(CARROCERIA.PICKUP);
                                        break;
                                    case 2:
                                        camioneta.setCarroceria(CARROCERIA.SUV);
                                        break;
                                    case 3:
                                        camioneta.setCarroceria(CARROCERIA.MINIVAN);
                                        break;
                                    default:
                                        System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                                        break;
                                }
                                System.out.println("Ingrese el color de la camioneta");
                                //AZUL,NEGRO,BLANCO,ROJO,AMARILLO
                                System.out.println("1) AZUL");
                                System.out.println("2) NEGRO");
                                System.out.println("3) BLANCO");
                                System.out.println("4) ROJO");
                                System.out.println("5) AMARILLO");
                                System.out.println("Selecciona una opción: ");
                                int color = scanner.nextInt();
                                //Switch para seleccionar el color de la camioneta
                                switch (color){
                                    case 1 :
                                        camioneta.setColor(COLOR.AZUL);
                                        break;
                                    case 2 :
                                        camioneta.setColor(COLOR.NEGRO);
                                        break;
                                    case 3 :
                                        camioneta.setColor(COLOR.BLANCO);
                                        break;
                                    case 4 :
                                        camioneta.setColor(COLOR.ROJO);
                                        break;
                                    case 5 :
                                        camioneta.setColor(COLOR.AMARILLO);
                                        break;
                                    default:
                                        System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                                        break;
                                }
                                System.out.println("Ingrese los km de la camioneta");
                                int km = scanner.nextInt();
                                //Control de que los km no sean negativos
                                if(km >= 0){
                                    camioneta.setKm(km);
                                }else{
                                    //Lanzo una excepcion si los km son negativos
                                    throw new Exception("Los km no pueden ser negativos");
                                }
                                System.out.println("Ingrese el año de la camioneta");
                                int anio = scanner.nextInt();
                                //Control de que el año no sea menor a 2005
                                if(anio > 2005){
                                    camioneta.setAnio(anio);
                                }else{
                                    //Lanzo una excepcion si el año es menor a 2005
                                    throw new Exception("El año no puede ser menor a 2005");
                                }
                                System.out.println("Ingrese el estado del motor -- true(Si se encuenta en buen estado) o false(Si se encuentra en mal estado) --");
                                boolean estadoMotor = scanner.nextBoolean();
                                camioneta.setEstadoMotor(estadoMotor);
                                //Control de que el estado del motor sea true para poder agregar la camioneta al catalogo
                                if(estadoMotor){
                                    camioneta.setId(vehiculosGuardados.size()+1);
                                    concecionaria.agregarVehiculo(camioneta);
                                    vehiculosGuardados.add(camioneta);
                                //Si el estado del motor es false, la camioneta se envia al taller
                                }else{
                                    System.out.println("La camioneta no puede ser enviada al catalogo porque su motor se encuentra en mal estado");
                                    taller.agregarVehiculo(camioneta);
                                }
                                break;
                            case 2 :
                                //Instancio el automovil
                                Automovil automovil = new Automovil();
                                System.out.println("Ingrese el nombre del automovil");
                                String nombreAuto = scanner.next();
                                automovil.setNombre(nombreAuto);
                                System.out.println("Ingrese la marca de la automovil");
                                //FORD,TOYOTA,BMW,AUDI,RENAULT;
                                System.out.println("1) FORD");
                                System.out.println("2) TOYOTA");
                                System.out.println("3) BMW");
                                System.out.println("4) AUDI");
                                System.out.println("5) RENAULT");
                                System.out.print("Selecciona una opción: ");
                                int marcaAuto = scanner.nextInt();
                                //Switch para seleccionar la marca del automovil
                                switch (marcaAuto){
                                    case 1:
                                        automovil.setMarca(AUTOMARCA.FORD);
                                        break;
                                    case 2:
                                        automovil.setMarca(AUTOMARCA.TOYOTA);
                                        break;
                                    case 3:
                                        automovil.setMarca(AUTOMARCA.BMW);
                                        break;
                                    case 4:
                                        automovil.setMarca(AUTOMARCA.AUDI);
                                        break;
                                    case 5:
                                        automovil.setMarca(AUTOMARCA.RENAULT);
                                        break;
                                    default:
                                        System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                                        break;
                                }
                                System.out.println("Ingrese la carroceria del automovil");
                                //PICKUP, SUV, VAN;
                                System.out.println("1) SEDAN");
                                System.out.println("2) COUPE");
                                System.out.println("3) MINIVAN");
                                System.out.print("Selecciona una opción: ");
                                int carroceriaAuto = scanner.nextInt();
                                //Switch para seleccionar la carroceria del automovil
                                switch (carroceriaAuto){
                                    case 1:
                                        automovil.setCarroceria(CARROCERIA.SEDAN);
                                        break;
                                    case 2:
                                        automovil.setCarroceria(CARROCERIA.COUPE);
                                        break;
                                    case 3:
                                        automovil.setCarroceria(CARROCERIA.MINIVAN);
                                        break;
                                    default:
                                        System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                                        break;
                                }
                                System.out.println("Ingrese el color del automovil");
                                //AZUL,NEGRO,BLANCO,ROJO,AMARILLO
                                System.out.println("1) AZUL");
                                System.out.println("2) NEGRO");
                                System.out.println("3) BLANCO");
                                System.out.println("4) ROJO");
                                System.out.println("5) AMARILLO");
                                System.out.println("Selecciona una opción: ");
                                int colorAuto = scanner.nextInt();
                                //Switch para seleccionar el color del automovil
                                switch (colorAuto){
                                    case 1 :
                                        automovil.setColor(COLOR.AZUL);
                                        break;
                                    case 2 :
                                        automovil.setColor(COLOR.NEGRO);
                                        break;
                                    case 3 :
                                        automovil.setColor(COLOR.BLANCO);
                                        break;
                                    case 4 :
                                        automovil.setColor(COLOR.ROJO);
                                        break;
                                    case 5 :
                                        automovil.setColor(COLOR.AMARILLO);
                                        break;
                                    default:
                                        System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                                        break;
                                }
                                System.out.println("Ingrese los km del automovil");
                                int kmAuto = scanner.nextInt();
                                //Verifico que el km no sea menor a 0
                                if(kmAuto >= 0){
                                    automovil.setKm(kmAuto);
                                }else{
                                    //Lanzo una excepcion si los km son negativos
                                    throw new Exception("Los km no pueden ser negativos");
                                }
                                System.out.println("Ingrese el año del automovil");
                                int anioAuto = scanner.nextInt();
                                //Verifico que el año no sea menor a 2005
                                if(anioAuto > 2005){
                                    automovil.setAnio(anioAuto);
                                }else{
                                    //Lanzo una excepcion si el año es menor a 2005
                                    throw new Exception("El año no puede ser menor a 2005");
                                }
                                System.out.println("Ingrese el estado del motor -- true(Si se encuenta en buen estado) o false(Si se encuentra en mal estado) --");
                                boolean estadoMotorAuto = scanner.nextBoolean();
                                automovil.setEstadoMotor(estadoMotorAuto);
                                //Verifico que el estado del motor sea true para poder agregar el automovil al catalogo
                                if(estadoMotorAuto){
                                    automovil.setId(vehiculosGuardados.size()+1);
                                    vehiculosGuardados.add(automovil);
                                    concecionaria.agregarVehiculo(automovil);


                                }else{
                                    //Si el estado del motor es false, el automovil se envia al taller
                                    System.out.println("El automovil no puede ser enviada al catalogo porque su motor se encuentra en mal estado");
                                    taller.agregarVehiculo(automovil);
                                }
                                break;
                            case 3 :
                                //Instancio la motocicleta
                                Motocicletas motocicleta = new Motocicletas();
                                System.out.println("Ingrese el nombre de la motocicleta");
                                String nombreMoto = scanner.next();
                                motocicleta.setNombre(nombreMoto);
                                System.out.println("Ingrese la marca de la motocicleta");
                                //FORD,TOYOTA,BMW,AUDI,RENAULT;
                                System.out.println("1) HONDA");
                                System.out.println("2) YAMAHA");
                                System.out.println("3) BMW");
                                System.out.println("4) BENELLI");
                                System.out.print("Selecciona una opción: ");
                                int marcaMoto = scanner.nextInt();
                                //Switch para seleccionar la marca de la motocicleta
                                switch (marcaMoto){
                                    case 1:
                                        motocicleta.setMarca(MOTOMARCA.HONDA);
                                        break;
                                    case 2:
                                        motocicleta.setMarca(MOTOMARCA.YAMAHA);
                                        break;
                                    case 3:
                                        motocicleta.setMarca(MOTOMARCA.BWM);
                                        break;
                                    case 4:
                                        motocicleta.setMarca(MOTOMARCA.BENELLI);
                                        break;
                                    default:
                                        System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                                        break;
                                }
                                System.out.println("Ingrese el cilindraje de la motocicleta");
                                int ccMoto = scanner.nextInt();
                                //Verifico que el cilindraje no sea menor a 110
                                if(ccMoto >= 110){
                                    motocicleta.setCc(ccMoto);
                                }else{
                                    //Lanzo una excepcion si el cilindraje es menor a 110
                                    throw new Exception("El cilindraje no puede ser menor a 110");
                                }
                                System.out.println("Ingrese el color de la motocicleta");
                                //AZUL,NEGRO,BLANCO,ROJO,AMARILLO
                                System.out.println("1) AZUL");
                                System.out.println("2) NEGRO");
                                System.out.println("3) BLANCO");
                                System.out.println("4) ROJO");
                                System.out.println("5) AMARILLO");
                                System.out.println("Selecciona una opción: ");
                                int colorMoto = scanner.nextInt();
                                //Switch para seleccionar el color de la motocicleta
                                switch (colorMoto){
                                    case 1 :
                                        motocicleta.setColor(COLOR.AZUL);
                                        break;
                                    case 2 :
                                        motocicleta.setColor(COLOR.NEGRO);
                                        break;
                                    case 3 :
                                        motocicleta.setColor(COLOR.BLANCO);
                                        break;
                                    case 4 :
                                        motocicleta.setColor(COLOR.ROJO);
                                        break;
                                    case 5 :
                                        motocicleta.setColor(COLOR.AMARILLO);
                                        break;
                                    default:
                                        System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                                        break;
                                }
                                System.out.println("Ingrese los km de la motocicleta");
                                int kmMoto = scanner.nextInt();
                                //Verifico que los km no sean menor a 0
                                if(kmMoto >= 0){
                                    motocicleta.setKm(kmMoto);
                                }else{
                                    //Lanzo una excepcion si los km son negativos
                                    throw new Exception("Los km no pueden ser negativos");
                                }
                                System.out.println("Ingrese el año de la motocicleta");
                                int anioMoto = scanner.nextInt();
                                //Verifico que el año no sea menor a 2005
                                if(anioMoto > 2005){
                                    motocicleta.setAnio(anioMoto);
                                }else{
                                    //Lanzo una excepcion si el año es menor a 2005
                                    throw new Exception("El año no puede ser menor a 2005");
                                }
                                System.out.println("Ingrese el estado del motor -- true(Si se encuenta en buen estado) o false(Si se encuentra en mal estado) --");
                                boolean estadoMotorMoto = scanner.nextBoolean();
                                motocicleta.setEstadoMotor(estadoMotorMoto);
                                //Verifico que el estado del motor sea true para poder agregar la motocicleta al catalogo
                                if(estadoMotorMoto == true){
                                    motocicleta.setId(vehiculosGuardados.size()+1);
                                    concecionaria.agregarVehiculo(motocicleta);
                                    vehiculosGuardados.add(motocicleta);

                                }else{
                                    //Si el estado del motor es false, la motocicleta se envia al taller
                                    System.out.println("La motocicleta no puede ser enviada al catalogo porque su motor se encuentra en mal estado y necesita pasar por el taller para una revision");
                                    taller.agregarVehiculo(motocicleta);
                                }
                                break;


                        }
                    }catch (Exception e){
                        //Capturo la excepcion y muestro el mensaje de error
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Selecciono Consultar taller:");
                    //Muestro los vehiculos que se encuentran en el taller
                    taller.verVehiculosEnTaller();
                    System.out.println("***************************************************************************************************************************************************|");
                    GuardarVehiculos.guardarVehiculos(taller.obtenerVehiculosEnTaller() ,"lista_vehiculos-en-taller.dat");
                    break;
                case 4:
                    System.out.println("Eliminar un vehículo del stock:");
                    System.out.println("********************************************");
                    System.out.println("El ID del vehiculo que desea eliminar del catalogo");
                    int id = scanner.nextInt();
                    //Llamo a la funcion eliminarVehiculo de la clase concecionaria para eliminar el vehiculo del catalogo y lo guardo en el archivo
                    concecionaria.eliminarVehiculo(id);
                    vehiculosGuardados.remove(id-1);
                    System.out.println("El vehiculo con el ID "+id+" fue eliminado del catalogo");
                    System.out.println("***********************************************************");
                    GuardarVehiculos.guardarVehiculos(concecionaria.obtenerListaDeVehiculos() ,"lista_vehiculos.dat");
                    //Muestro los vehiculos que se encuentran en el catalogo
                    for(Vehiculo vehiculo : vehiculosGuardados){
                        System.out.println(vehiculo.toString());
                    }
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    //Guardo los vehiculos que se encuentran en el catalogo en el archivo lista_vehiculos.dat
                    GuardarVehiculos.guardarVehiculos(concecionaria.obtenerListaDeVehiculos() ,"lista_vehiculos.dat");
                    System.out.println("****************************************************************************");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }
        }


    }
}
class GuardarVehiculos implements Serializable {

    public static void guardarVehiculos(LinkedList<Vehiculo> vehiculos, String nombreArchivo) {
        try {
            // Filtrar vehículos con IDs duplicados antes de guardar
            LinkedList<Vehiculo> vehiculosFiltrados = filtrarDuplicados(vehiculos);
            //
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
                // Guardar la lista de vehículos en el archivo lista_vehiculos.dat
                oos.writeObject(vehiculosFiltrados);
                System.out.println("Lista de vehículos guardada exitosamente en " + nombreArchivo);
            }
        } catch (IOException e) {
            // Imprimir mensaje de error si ocurre un error al guardar la lista de vehículos
            System.out.println("Error al guardar la lista de vehículos en el archivo: " + e.getMessage());
        }
    }

    // Método para filtrar vehículos con IDs duplicados
    private static LinkedList<Vehiculo> filtrarDuplicados(LinkedList<Vehiculo> vehiculos) {
        LinkedList<Vehiculo> vehiculosFiltrados = new LinkedList<>();
        // Recorrer la lista de vehículos y agregar a la lista filtrada solo los vehículos que no tengan un ID duplicado
        for (Vehiculo vehiculo : vehiculos) {
            // Si la lista filtrada no contiene el ID del vehículo, agregarlo a la lista filtrada
            if (!contieneId(vehiculosFiltrados, vehiculo.getId() )) {
                // Agregar el vehículo a la lista filtrada
                vehiculosFiltrados.add(vehiculo);
            }
        }

        return vehiculosFiltrados;
    }

    // Método para verificar si la lista de vehículos contiene un ID específico
    private static boolean contieneId(LinkedList<Vehiculo> vehiculos, int id) {
        // Recorrer la lista de vehículos y verificar si el ID del vehículo es igual al ID especificado
        for (Vehiculo vehiculo : vehiculos) {
            // Si el ID del vehículo es igual al ID especificado, retornar true
            if (vehiculo.getId() == (id)) {
                return true;
            }
        }
        return false;
    }
}

class RecuperarVehiculos implements Serializable {

    public static LinkedList<Vehiculo> recuperarVehiculos(String nombreArchivo) {
        LinkedList<Vehiculo> vehiculos = null;
        // Recuperar la lista de vehículos desde el archivo lista_vehiculos.dat
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            // Guardar la lista de vehículos en la variable vehiculos
            // (casting de Object a LinkedList<Vehiculo>)
            vehiculos = (LinkedList<Vehiculo>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Imprimir mensaje de error si ocurre un error al recuperar la lista de vehículos
            System.out.println("Error al recuperar la lista de vehículos desde el archivo: " + e.getMessage());
        }
        // Retornar la lista de vehículos recuperada
        return vehiculos;
    }

}
