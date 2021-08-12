package ProxyGoogleDrive;

import java.util.ArrayList;
import java.util.List;

public class Servicio implements IServicio{

    private List<Documento> documentoList;

    public Servicio() {
        this.documentoList = new ArrayList<>();
    }

    public void agregarDocumento(Documento documento){
        this.documentoList.add(documento);
    }

    @Override
    public void acceder(String url, String email) {
        //Debería acceder al listado de docuementos y buscar el que coincide
        // con la url, luego mostrar su contenido
        System.out.println("Accediendo al Documento: " + url);
    }
}
