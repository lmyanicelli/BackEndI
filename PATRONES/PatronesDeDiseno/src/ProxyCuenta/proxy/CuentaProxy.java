package ProxyCuenta.proxy;

import ProxyCuenta.inter.ICuenta;
import ProxyCuenta.inter.impl.CuentaBancoAImpl;
import ProxyCuenta.model.Cuenta;

public class CuentaProxy implements ICuenta {

    private ICuenta cuentaReal;

    public CuentaProxy(ICuenta cuentaReal) {
        this.cuentaReal = cuentaReal;
    }

    @Override
    public Cuenta retirarDinero(Cuenta cuenta, double monto) {
        if(cuentaReal == null){
            cuentaReal = new CuentaBancoAImpl();
            return cuentaReal.retirarDinero(cuenta, monto);
        }else {
            return cuentaReal.retirarDinero(cuenta, monto);
        }
    }

    @Override
    public Cuenta depositarDinero(Cuenta cuenta, double monto) {
        if(cuentaReal == null){
            cuentaReal = new CuentaBancoAImpl();
            return cuentaReal.depositarDinero(cuenta, monto);
        }else {
            return cuentaReal.depositarDinero(cuenta, monto);
        }
    }

    @Override
    public void mostrarSaldo(Cuenta cuenta) {
        if(cuentaReal == null){
            cuentaReal = new CuentaBancoAImpl();
            cuentaReal.mostrarSaldo(cuenta);
        }else {
            cuentaReal.mostrarSaldo(cuenta);
        }
    }
}
