import ucn.StdOut;

public class ListaCandidato {

    private Candidato[] candidatos;
    private int cantAct;
    private int cantMax;

    public ListaCandidato() {
        this.cantMax = 9999;
        this.cantAct = 0;
        this.candidatos = new Candidato[cantMax];
    }

    public Candidato[] getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(Candidato[] candidatos) {
        this.candidatos = candidatos;
    }

    public int getCantAct() {
        return cantAct;
    }

    public void setCantAct(int cantAct) {
        this.cantAct = cantAct;
    }

    public int getCantMax() {
        return cantMax;
    }

    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }

    public void agregarCandidato(Candidato candidato) {
        if (cantAct >= cantMax) {
            StdOut.println("No se puede agregar el candidato, la lista está llena.");
            return;
        }

        candidatos[cantAct] = candidato;
        cantAct++;
    }

    public Candidato getCandidatoPorPosicion(int pos) {
        if (pos >= 0 && pos < cantAct) {
            return candidatos[pos];
        } else {
            return null;
        }
    }
}
