import ucn.StdOut;

public class ListaUsuario {

    private Usuario[] usuarios;
    private int cantAct;
    private int cantMax;

    public ListaUsuario() {
        this.cantMax = 9999;
        this.cantAct = 0;
        this.usuarios = new Usuario[cantMax];
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public int getCantActual() {
        return cantAct;
    }

    public void setCantActual(int cantAct) {
        this.cantAct = cantAct;
    }

    public int getCantMax() {
        return cantMax;
    }

    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }

    public void agregarUsuario(Usuario usuario) {
        if (cantAct >= cantMax) {
            StdOut.println("No se puede agregar el usuario, la lista está llena.");
            return;
        }

        usuarios[cantAct] = usuario;
        cantAct++;
    }

    public Usuario obtenerUsuarioPorPosicion(int pos) {
        if (pos >= 0 && pos < cantAct) {
            return usuarios[pos];
        } else {
            return null;
        }
    }
}
