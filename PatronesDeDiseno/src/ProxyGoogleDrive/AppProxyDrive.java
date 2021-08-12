package ProxyGoogleDrive;

import java.util.ArrayList;
import java.util.List;

/*Pensemos en una aplicación al estilo Google Drive, un servicio que nos trae documentos.
Para acceder al mismo, debemos enviarle una url y un email.
Los documentos están compuestos por una id, una url, un contenido y
una lista de usuarios autorizados a verlo. Queremos registrar quiénes acceden a los documentos.
¿Cómo resolverías este problema aplicando el patrón proxy?*/
public class AppProxyDrive {
    public static void main(String[] args){
        Documento doc1 = new Documento("acd","www.doc1.com","Soy el doc1");
        List<String> autorizadosDoc1 = new ArrayList<>();
        autorizadosDoc1.add("email1");
        autorizadosDoc1.add("email2");
        doc1.setEmailAutorizados(autorizadosDoc1);

        Proxy proxy = new Proxy(new Servicio(),autorizadosDoc1);
        proxy.acceder("www.doc1.com", "email3"); //debería prohibir el acceso
        System.out.println("------------------------");
        proxy.acceder("www.doc1.com", "email1"); //debería permitir el acceso
    }
}
