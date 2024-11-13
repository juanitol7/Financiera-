
package fabrica.galletas;


public class Empacador {
   private String nombre;
    private int empaquesManana;
    private int empaquesTarde;

    // Constructor
    public Empacador(String nombre) {
        this.nombre = nombre;
        this.empaquesManana = 0;
        this.empaquesTarde = 0;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public int getEmpaquesManana() {
        return empaquesManana;
    }

    public void setEmpaquesManana(int empaquesManana) {
        this.empaquesManana = empaquesManana;
    }

    public int getEmpaquesTarde() {
        return empaquesTarde;
    }

    public void setEmpaquesTarde(int empaquesTarde) {
        this.empaquesTarde = empaquesTarde;
    }

    // Método para obtener el total de empaques (mañana + tarde)
    public int getTotalEmpaques() {
        return empaquesManana + empaquesTarde;
    }

    // Método que indica si el empacador no continuará (menos de 100 empaques)
    public boolean noContinua() {
        return getTotalEmpaques() < 100;
    }
}
