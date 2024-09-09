public class Candidato {

    private String partido;
    private String nombre;
    private int cantVotos;

    public Candidato(String partido, String nombre, int cantVotos) {
        this.partido = partido;
        this.nombre = nombre;
        this.cantVotos = cantVotos;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantVotos() {
        return cantVotos;
    }

    public void setCantVotos(int cantVotos) {
        this.cantVotos = cantVotos;
    }
}
