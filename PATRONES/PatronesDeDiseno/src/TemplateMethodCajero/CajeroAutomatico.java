package TemplateMethodCajero;

public class CajeroAutomatico extends CuentaBancaria{

    public CajeroAutomatico(String cuenta, Double dinero, int accion){
        procesar(cuenta, dinero, accion);
    }

    @Override
    public void saludar() {
        System.out.println("Por favor ingrese los datos...");
    }
}
