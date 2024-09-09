public class Usuario {

    private String nombre;
    private String rut;
    private int edad;
    private boolean haVotado;

    public Usuario(String nombre, String rut, int edad) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.haVotado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isHaVotado() {
        return haVotado;
    }

    public void setHaVotado(boolean haVotado) {
        this.haVotado = haVotado;
    }
}
