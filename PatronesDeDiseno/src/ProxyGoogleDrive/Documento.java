package ProxyGoogleDrive;

import java.util.ArrayList;
import java.util.List;

public class Documento {

    private String id;
    private String url;
    private String contenido;
    private List<String> emailAutorizados;

    public Documento(String id, String url, String contenido) {
        this.id = id;
        this.url = url;
        this.contenido = contenido;
        this.emailAutorizados = new ArrayList<>();
    }

    public List<String> getEmailAutorizados() {
        return emailAutorizados;
    }

    public void setEmailAutorizados(List<String> emailAutorizados) {
        this.emailAutorizados = emailAutorizados;
    }
}
