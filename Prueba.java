import org.junit.Test;
import static org.junit.Assert.*;

public class Prueba {

    @Test
    public void test() {
        VectorHeap<Pacientes> cola = new VectorHeap<>();

        // Se crean los pacientes (voy a usar los del ejemplo)
        Pacientes pacienteA = new Pacientes("Juan Perez", "fractura de pierna", 'C');
        Pacientes pacienteB = new Pacientes("Maria Ramirez", "apendicitis", 'A');
        Pacientes pacienteC = new Pacientes("Lorenzo Toledo", "chikunguya", 'E');
        Pacientes pacienteD = new Pacientes("Carmen Sarmientos", "dolores de parto", 'B');

        // Se agrega al Vector
        cola.add(pacienteA);
        cola.add(pacienteB);
        cola.add(pacienteC);
        cola.add(pacienteD);

        // Se verifica si se representaron en orden
        assertEquals("Maria Ramirez, apendicitis, A", cola.remove().toString());
        assertEquals("Carmen Sarmientos, dolores de parto, B", cola.remove().toString());
        assertEquals("Juan Perez, fractura de pierna, C", cola.remove().toString());
        assertEquals("Lorenzo Toledo, chikunguya, E", cola.remove().toString());
    }
}
