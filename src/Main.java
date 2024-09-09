import ucn.*;
import java.io.IOException;

public class Main {

    private static ListaUsuario usuarios = new ListaUsuario();
    private static ListaCandidato lista = new ListaCandidato();

    public static void main(String[] args) throws IOException {

        ArchivoEntrada archivo = new ArchivoEntrada("Candidatos.txt");

        while(!archivo.isEndFile()){
            Registro registro = archivo.getRegistro();

            String partido = registro.getString();
            String nombre = registro.getString();
            int votos = registro.getInt();

            Candidato candidato = new Candidato(partido, nombre, votos);
            lista.agregarCandidato(candidato);
        }

        boolean continuar = true;

        while (continuar) {
            StdOut.println("*********");
            StdOut.println("* Bienvenido al sistema *");
            StdOut.println("*    De Votación 2026  *");
            StdOut.println("*********");
            StdOut.println("*    Menú principal    *");
            StdOut.println("*********");
            StdOut.println("[1] Iniciar sesión");
            StdOut.println("[2] Registrarse");
            StdOut.println("[3] Estadísticas");
            StdOut.println("[4] Cerrar programa");

            int opcion = StdIn.readInt();

            switch (opcion) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    registrarse();
                    break;
                case 3:
                    mostrarEstadisticas();
                    break;
                case 4:
                    StdOut.println("Finalizando el programa.");
                    continuar = false;
                    break;
                default:
                    StdOut.println("Opción incorrecta. Intente de nuevo, por favor.");
                    break;
            }
        }
    }

    private static void iniciarSesion() {
        StdOut.println("Ingrese su RUT:");
        String rut = StdIn.readString();

        boolean encontrado = false;
        for (int i = 0; i < usuarios.getCantActual(); i++){
            Usuario aux = usuarios.obtenerUsuarioPorPosicion(i);

            if (rut.equalsIgnoreCase(aux.getRut())){
                StdOut.println("Bienvenido, " + aux.getNombre());
                encontrado = true;
                if (aux.isHaVotado()) {
                    StdOut.println("Usted ya votó anteriormente.");
                } else {
                    votar(aux);
                }
                break;
            }
        }

        if (!encontrado) {
            StdOut.println("Usuario no encontrado. Regístrese.");
        }
    }

    private static void votar(Usuario usuario) {
        StdOut.println("Lista de los candidatos:");
        for (int i = 0; i < lista.getCantAct(); i++) {
            Candidato c = lista.getCandidatoPorPosicion(i);
            StdOut.println((i+1) + ". " + c.getNombre() + " (" + c.getPartido() + ")");
        }

        StdOut.println("Seleccione un candidato: ");
        int opcion = StdIn.readInt();

        if (opcion < 1 || opcion > lista.getCantAct()) {
            StdOut.println("Opción inválida.");
            return;
        }

        Candidato candidato = lista.getCandidatoPorPosicion(opcion - 1);
        candidato.setCantVotos(candidato.getCantVotos() + 1);
        usuario.setHaVotado(true);

        StdOut.println("Gracias por votar por: " + candidato.getNombre());
    }

    private static void registrarse() {
        StdOut.println("Ingrese su nombre:");
        String nombre = StdIn.readString();
        StdOut.println("Ingrese su RUT:");
        String rut = StdIn.readString();
        StdOut.println("Ingrese su edad:");
        int edad = StdIn.readInt();

        Usuario usuario = new Usuario(nombre, rut, edad);
        usuarios.agregarUsuario(usuario);
        StdOut.println("Registro exitoso. Ahora puede iniciar sesión.");
    }

    private static void mostrarEstadisticas() {
        StdOut.println("Estadísticas de votación:");
        for (int i = 0; i < lista.getCantAct(); i++) {
            Candidato c = lista.getCandidatoPorPosicion(i);
            StdOut.println(c.getNombre() + " (" + c.getPartido() + "): " + c.getCantVotos() + " votos");
        }
    }
}
