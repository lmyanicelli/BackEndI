package ProxyCuenta;

import ProxyCuenta.inter.ICuenta;
import ProxyCuenta.inter.impl.CuentaBancoAImpl;
import ProxyCuenta.inter.impl.CuentaBancoBImpl;
import ProxyCuenta.model.Cuenta;
import ProxyCuenta.proxy.CuentaProxy;

public class App {
    public static void main(String[] args){
        Cuenta cuenta = new Cuenta(6080, "Agustín", 3000);

        ICuenta cuentaProxy = new CuentaProxy(new CuentaBancoBImpl());

        cuentaProxy.mostrarSaldo(cuenta);
        System.out.println("_________________");
        cuenta = cuentaProxy.depositarDinero(cuenta, 500);
        System.out.println("______________________");
        cuenta = cuentaProxy.retirarDinero(cuenta, 200);
        System.out.println("____________________");
        cuentaProxy.mostrarSaldo(cuenta);
    }
}
