public class Pacientes implements Comparable<Pacientes> {
    private String nombre;
    private String sintoma;
    private char codigo;

    //Constrctor
    public Pacientes(String nombre, String sintoma, char codigo) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigo = codigo;
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public int getCodigo() {
        return codigo;
    }

    // Compara por código
    @Override
    public int compareTo(Pacientes otroPaciente) {
        return this.codigo - otroPaciente.getCodigo();
    }

    // Escribir los datos del paciente
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigo;
    }

}