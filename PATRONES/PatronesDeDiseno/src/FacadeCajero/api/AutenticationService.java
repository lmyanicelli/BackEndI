package FacadeCajero.api;

public class AutenticationService {

    private CuentaService cuentaService;

    public Boolean validarUsuarioYContrasena(String dni, String contrasena){
        if(dni.equals(contrasena)){
            //si es true
            cuentaService.getCuenta(dni);
            return true;
        }else{
            return false;
        }
    }
}
