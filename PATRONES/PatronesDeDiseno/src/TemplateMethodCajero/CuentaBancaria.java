package TemplateMethodCajero;

public abstract class CuentaBancaria {

    private String cuenta;
    private Double saldo = 0.0;

    private void setCuenta(String cuenta){
        this.cuenta = cuenta;
    }

    private void depositar(Double dinero){
        System.out.println("Depositando...");
        this.saldo += dinero;
    }

    private void retirar(Double monto){
        System.out.println("Retirando...");
        if(monto <= this.saldo - 100){
            this.saldo -= monto;
        }else{
            System.out.println("No se puede retirar ese monto");
        }
    }

    private void consultarSaldo(){
        System.out.println("El saldo es: " + this.saldo);
    }

    protected void auditoria(){
        System.out.println("Se está procesando la cuenta " + this.cuenta);
    }

    public abstract void saludar();

    public void procesar(String cuenta, Double dinero, int t){
        //t variable para dilucidar si deposita o retira dinero
        saludar();
        setCuenta(cuenta);
        switch (t){
            case 1:
                depositar(dinero);
                break;
            case 2:
                retirar(dinero);
                break;
            default:
                System.out.println("Opción inválida");
        }
        consultarSaldo();
        auditoria();
    }
}