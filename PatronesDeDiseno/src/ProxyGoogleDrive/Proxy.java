package ProxyGoogleDrive;

import java.util.List;

public class Proxy implements IServicio{

    private Servicio servicio;
    private List<String> autorizados;

    public Proxy(Servicio servicio, List<String> autorizados) {
        this.servicio = servicio;
        this.autorizados = autorizados;
    }

    @Override
    public void acceder(String url, String email) {
        if(autorizados.contains(email)){
            servicio.acceder(url,email);
        }else{
            System.out.println("Acceso denegado al documento: " + url);
        }
    }
}
