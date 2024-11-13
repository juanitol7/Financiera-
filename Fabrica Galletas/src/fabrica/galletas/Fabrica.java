
package fabrica.galletas;



import java.util.ArrayList;
import java.util.List;

public class Fabrica {
     private List<Empacador> empacadores;

    // Constructor
    public Fabrica() {
        empacadores = new ArrayList<>();
        // Inicializando los 8 empacadores con nombres ficticios
        for (int i = 1; i <= 8; i++) {
            empacadores.add(new Empacador("Empacador " + i));
        }
    }

    // Método para agregar un empacador a la lista
    public void agregarEmpacador(Empacador empacador) {
        empacadores.add(empacador);
    }

    // Obtener la lista de empacadores
    public List<Empacador> getEmpacadores() {
        return empacadores;
    }

    // Método para verificar si hay empaques registrados
    public boolean hayEmpaquesRegistrados() {
        for (Empacador empacador : empacadores) {
            if (empacador.getTotalEmpaques() > 0) {
                return true;
            }
        }
        return false;
    }

    // Obtener el mejor empacador (el que tenga más empaques)
    public Empacador getMejorEmpacador() {
        Empacador mejor = empacadores.get(0);
        for (Empacador empacador : empacadores) {
            if (empacador.getTotalEmpaques() > mejor.getTotalEmpaques()) {
                mejor = empacador;
            }
        }
        return mejor;
    }

    // Obtener el peor empacador (el que tenga menos empaques)
    public Empacador getPeorEmpacador() {
        Empacador peor = empacadores.get(0);
        for (Empacador empacador : empacadores) {
            if (empacador.getTotalEmpaques() < peor.getTotalEmpaques()) {
                peor = empacador;
            }
        }
        return peor;
    }

    // Obtener el promedio de empaques por jornada (mañana + tarde)
    public double getPromedioJornada() {
        int totalEmpaques = 0;
        int cantidadEmpacadores = empacadores.size();
        for (Empacador empacador : empacadores) {
            totalEmpaques += empacador.getEmpaquesManana() + empacador.getEmpaquesTarde();
        }
        return cantidadEmpacadores > 0 ? (double) totalEmpaques / cantidadEmpacadores : 0;
    }

    // Obtener el promedio total de empaques (considerando todo el tiempo)
    public double getPromedioTotal() {
        int totalEmpaques = 0;
        int cantidadEmpacadores = empacadores.size();
        for (Empacador empacador : empacadores) {
            totalEmpaques += empacador.getTotalEmpaques();
        }
        return cantidadEmpacadores > 0 ? (double) totalEmpaques / cantidadEmpacadores : 0;
    }

    // Método para obtener los empacadores que no continúan (menos de 100 empaques)
    public List<Empacador> obtenerEmpacadoresNoContinuan() {
        List<Empacador> noContinuan = new ArrayList<>();
        for (Empacador empacador : empacadores) {
            if (empacador.noContinua()) {
                noContinuan.add(empacador);
            }
        }
        return noContinuan;
    }
}
