import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Hospital {
    public static void main(String[] args) {

        // Crear una cola de prioridad de pacientes
        VectorHeap<Pacientes> cola = new VectorHeap<>();

        try (BufferedReader lector = new BufferedReader(new FileReader("pacientes.txt"))) {

            // Leer el archivo de pacientes
            String linea;
            while ((linea = lector.readLine()) != null) {

                // Dividir la línea en partes usando la coma como delimitador
                String[] partes = linea.split(",");

                //Verifica que existan 3 divisiones y las asigna a una variable
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String sintoma = partes[1].trim();
                    String codigoEmergencia = partes[2].trim();
                    // Verificar si el código de emergencia es un solo carácter y está entre A y E
                    if (codigoEmergencia.length() == 1 && codigoEmergencia.charAt(0) >= 'A' && codigoEmergencia.charAt(0) <= 'E') {
                        // Crear un nuevo paciente y agregarlo a la cola
                        Pacientes paciente = new Pacientes(nombre, sintoma, codigoEmergencia.charAt(0));
                        cola.add(paciente);

                    //Estos else son solo precauciones en caso que el archivo pacientes.txt se ingrese incorrectamente 
                    } else { 
                        // Mostrar advertencia si el código de emergencia no es válido
                        System.out.println("Advertencia: Código de emergencia inválido en la línea \"" + linea + "\".");
                    }
                } else {
                    // Mostrar advertencia si la línea no tiene el formato esperado
                    System.out.println("Advertencia: La línea \"" + linea + "\" no sigue el formato esperado.");
                }
            }
        } catch (FileNotFoundException e) {
            // Mensaje si no se encuentra el archivo
            System.out.println("\n¡¡¡Error!!!: No se pudo encontrar el archivo necesario para la operación.");
            System.out.println("Revisa si el nombre del archivo ingresado es \"pacientes.txt\"\n");
        } catch (Exception e) {
            // Mensaje de otros posibles errores
            System.out.println("\n¡¡¡Error!!!: Se ha producido un error inesperado.\n");
        }

        // Atender a los pacientes con respecto a su código de emergencia
        Pacientes siguiente;
        while ((siguiente = cola.remove()) != null) {
            System.out.println(siguiente);
        }
    }
}
