package model;

import model.Equipo;
import model.Arbitro;
import java.util.Random;

public class Controller {

    private Equipo[] equipos;
    private Arbitro[] arbitros;

    private final int CANTIDAD_EQUIPOS = 4;
    private final int CANTIDAD_ARBITROS = 4;

    private int contadorEquipos = 0;

    /**
     * Constructor de la clase Controller para inicializar variables globales.
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controller con un arreglo de personas vacío.
     */
    public Controller() {
        equipos = new Equipo[CANTIDAD_EQUIPOS];
        arbitros = new Arbitro[CANTIDAD_ARBITROS];
    }

    public String fixture() {
        String fixture = "";
        Random random = new Random();
        int equipo1 = random.nextInt(4);
        int equipo2;
        do {
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 1: Equipo " + equipo1 + " vs Equipo " + equipo2;
        fixture += "\n";

        do {
            equipo1 = random.nextInt(4);
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 2: Equipo " + equipo1 + " vs Equipo " + equipo2;
        return fixture;
    }

    public Equipo[] getEquipos() {
        return equipos;
    }

    public Arbitro[] getArbitros() {
        return arbitros;
    }

    public Equipo buscarEquipo(int indice) {
        Equipo equipoBuscado = getEquipos()[indice-1];

        return equipoBuscado;
    }

    //Crea un jugador y agrega un jugador a un equipo
    public void crearPersona(int indice, String nombre, int edad, int opPosicion, int numero) {
        buscarEquipo(indice).crearJugador(nombre, edad, opPosicion, numero);
    }

    public void crearEquipo(String nombre) {
        Equipo equipo = new Equipo(nombre);

        agregarEquipo(equipo);
        contadorEquipos++;
    }

    public void agregarEquipo(Equipo equipo) {
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] == null) {
                equipos[i] = equipo;
                break;
            }
        }
    }

    public String mostrarEquipos() {
        String msg = "";
        for (int i = 0; i<equipos.length; i++) {
            if (equipos[i] != null) {
                msg += (i+1) + ". " + equipos[i].getNombre() + "\n";
            }
        }

        return msg;
    }

    public String mostrarArbitros() {
        String msg = "";
        for (int i = 0; i<arbitros.length; i++) {
            if (arbitros[i] != null) {
                msg += (i+1) + ". " + arbitros[i].presentarse() + "\n\n";
            }
        }

        return msg;
    }

    //crea un arbitro
    public void crearPersona(String nombre, int edad, int opTipoArbitro) {
        Arbitro arbitro = null;

        if (opTipoArbitro == 1) {
            arbitro = new ArbitroPrincipal(nombre, edad);

        } else if (opTipoArbitro == 2) {
            arbitro = new JuezDeLinea(nombre, edad);
        }

        if (arbitro != null) {
            agregarArbitro(arbitro);
        }
    }

    public void agregarArbitro(Arbitro arbitro) {
        for (int i = 0; i < arbitros.length; i++) {
            if (arbitros[i] == null) {
                arbitros[i] = arbitro;
                break;
            }
        }
    }

    public void preload() {
        crearEquipo("Equipo1");
        crearEquipo("Equipo2");
        crearEquipo("Equipo3");
        crearEquipo("Equipo4");

        crearPersona(1, "Jugador1", 20 , 1, 1);
        crearPersona(1, "Jugador2", 20 , 2, 2);
        crearPersona(1, "Jugador3", 20 , 2, 3);
        crearPersona(1, "Jugador4", 20 , 3, 4);
        crearPersona(1, "Jugador5", 20 , 3, 5);
        crearPersona(1, "Jugador6", 20 , 4, 6);

        crearPersona(2, "Jugador1", 20 , 1, 1);
        crearPersona(2, "Jugador2", 20 , 2, 2);
        crearPersona(2, "Jugador3", 20 , 2, 3);
        crearPersona(2, "Jugador4", 20 , 3, 4);
        crearPersona(2, "Jugador5", 20 , 3, 5);
        crearPersona(2, "Jugador6", 20 , 4, 6);

        crearPersona(3, "Jugador1", 20 , 1, 1);
        crearPersona(3, "Jugador2", 20 , 2, 2);
        crearPersona(3, "Jugador3", 20 , 2, 3);
        crearPersona(3, "Jugador4", 20 , 3, 4);
        crearPersona(3, "Jugador5", 20 , 3, 5);
        crearPersona(3, "Jugador6", 20 , 4, 6);
        
        crearPersona(4, "Jugador1", 20 , 1, 1);
        crearPersona(4, "Jugador2", 20 , 2, 2);
        crearPersona(4, "Jugador3", 20 , 2, 3);
        crearPersona(4, "Jugador4", 20 , 3, 4);
        crearPersona(4, "Jugador5", 20 , 3, 5);
        crearPersona(4, "Jugador6", 20 , 4, 6);

        crearPersona("ArbitroP1", 50 ,1);
        crearPersona("ArbitroP2", 50, 1);
        crearPersona("ArbitroP3", 50, 2);
        crearPersona("ArbitroP4", 50, 2);
    }

    public String jugada() {
        String msg = "";
        final int numPases = 5;
        int numJugador = 0;
        int numArbitro = 0;
        
        for (int i = 0; i < numPases; i++) {
            msg += equipos[0].getJugadores()[numJugador].getNombre() + equipos[0].getJugadores()[numJugador].pasar() + equipos[0].getJugadores()[numJugador+1].getNombre() + "\n";

            msg += arbitros[numArbitro].desplazarse() + "\n\n";

            numJugador++;

            if (numArbitro != 3) {
                numArbitro++;
            }
        }
        
        msg += equipos[0].getJugadores()[numJugador].hacerGol();
        return msg;
    }
}