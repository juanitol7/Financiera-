
package taxis;
import java.util.ArrayList;


public class EmpresaTaxi {
     private ArrayList<Asociado> listaDeAfiliados;
    private ArrayList<Taxi> listaDeTaxis;

    public EmpresaTaxi() {
        listaDeAfiliados = new ArrayList<>();
        listaDeTaxis = new ArrayList<>();
    }

    public boolean agregarAsociado(String nombre, String cedula) {
        // Validar que no exista otro asociado con la misma cédula
        for (Asociado asociado : listaDeAfiliados) {
            if (asociado.getCedula().equals(cedula)) {
                return false; // La cédula ya está registrada
            }
        }

        // Validar que no se superen los 5 asociados
        if (listaDeAfiliados.size() >= 5) {
            return false; // Se alcanzó el límite de afiliados
        }

        // Crear y agregar el nuevo asociado
        Asociado nuevoAsociado = new Asociado(nombre, cedula);
        listaDeAfiliados.add(nuevoAsociado);
        return true; // Éxito al agregar asociado
    }

    public boolean eliminarAsociado(String cedula) {
        for (Asociado asociado : listaDeAfiliados) {
            if (asociado.getCedula().equals(cedula)) {
                listaDeAfiliados.remove(asociado);
                return true; // Se eliminó el asociado
            }
        }
        return false; // No se encontró el asociado
    }

    public boolean afiliarTaxi(String placa, String modelo, String cedulaAsociado, String diaPicoYPlaca) {
        // Validar que la cédula del asociado exista
        for (Asociado asociado : listaDeAfiliados) {
            if (asociado.getCedula().equals(cedulaAsociado)) {
                // Crear y agregar el nuevo taxi
                Taxi nuevoTaxi = new Taxi(placa, modelo, cedulaAsociado, diaPicoYPlaca);
                listaDeTaxis.add(nuevoTaxi);
                return true; // Éxito al afiliar taxi
            }
        }
        return false; // La cédula del asociado no está registrada
    }

    // Métodos para calcular ingresos y servicios
    public double calcularIngresosTotales() {
        double total = 0;
        for (Taxi taxi : listaDeTaxis) {
            total += taxi.getIngresos();
        }
        return total;
    }

    public double calcularPromedioIngresos() {
        if (listaDeTaxis.isEmpty()) return 0;
        return calcularIngresosTotales() / listaDeTaxis.size();
    }

    public Taxi taxiMayorIngresos() {
        if (listaDeTaxis.isEmpty()) return null;
        Taxi taxiMayor = listaDeTaxis.get(0);
        for (Taxi taxi : listaDeTaxis) {
            if (taxi.getIngresos() > taxiMayor.getIngresos()) {
                taxiMayor = taxi;
            }
        }
        return taxiMayor;
    }

    public Taxi taxiMenorIngresos() {
        if (listaDeTaxis.isEmpty()) return null;
        Taxi taxiMenor = listaDeTaxis.get(0);
        for (Taxi taxi : listaDeTaxis) {
            if (taxi.getIngresos() < taxiMenor.getIngresos()) {
                taxiMenor = taxi;
            }
        }
        return taxiMenor;
    }

    public ArrayList<Asociado> getListaDeAfiliados() {
        return listaDeAfiliados;
    }

    public ArrayList<Taxi> getListaDeTaxis() {
        return listaDeTaxis;
    }
    
}
