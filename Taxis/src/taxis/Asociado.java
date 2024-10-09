
package taxis;


public class Asociado {
    private String nombre;
    private String cedula;
    private Taxi taxiAfiliado;

    public Asociado(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.taxiAfiliado = null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public Taxi getTaxiAfiliado() {
        return taxiAfiliado;
    }

    public void setTaxiAfiliado(Taxi taxiAfiliado) {
        this.taxiAfiliado = taxiAfiliado;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Cédula: " + cedula;
    }

}
