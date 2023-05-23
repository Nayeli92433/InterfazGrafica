public class Alumno {
    private String nombre;
    private String apellido;
    private String telefono;
    private String ine;
    private String genero;
    private String carrera;
    private String semestre;
    private String matricula;

    public Alumno(String nombre, String apellido, String telefono, String ine, String genero, String carrera, String semestre, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.ine = ine;
        this.genero = genero;
        this.carrera = carrera;
        this.semestre = semestre;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getIne() {
        return ine;
    }

    public String getGenero() {
        return genero;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getMatricula() {
        return matricula;
    }
}
