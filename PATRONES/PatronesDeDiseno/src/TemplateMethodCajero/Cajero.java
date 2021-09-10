package TemplateMethodCajero;

public class Cajero extends CuentaBancaria{

    public Cajero(String cuenta, Double dinero, int accion){
        procesar(cuenta, dinero, accion);
    }

    @Override
    public void saludar() {
        System.out.println("Hola, cómo está? ¿En qué puedo ayudarlo?");
    }

    @Override
    public void auditoria(){
        super.auditoria();
        System.out.println("Con mucho gusto, vuelva pronto...");
    }
}
