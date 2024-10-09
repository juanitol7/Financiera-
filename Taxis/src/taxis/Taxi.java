package taxis;

public class Taxi {
    private String placa;
    private String modelo;
    private String cedulaAsociado;
    private String diaPicoYPlaca;
    private double ingresos;

    public Taxi(String placa, String modelo, String cedulaAsociado, String diaPicoYPlaca) {
        if (placa == null || !placa.matches("[0-9]+")) {
            throw new IllegalArgumentException("La placa debe ser numérica y no negativa.");
        }
        this.placa = placa;
        this.modelo = modelo;
        this.cedulaAsociado = cedulaAsociado;
        
        int dia = Integer.parseInt(diaPicoYPlaca);
        if (dia < 0 || dia > 9) {
            throw new IllegalArgumentException("El día del pico y placa debe estar entre 0 y 9.");
        }
        this.diaPicoYPlaca = diaPicoYPlaca;
        this.ingresos = 0; // Inicializa los ingresos en 0
    }

    // Getters y Setters
    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCedulaAsociado() {
        return cedulaAsociado;
    }

    public String getDiaPicoYPlaca() {
        return diaPicoYPlaca;
    }

    public double getIngresos() {
        return ingresos;
    }

    public void agregarIngreso(double monto) {
        this.ingresos += monto;
    }
}
