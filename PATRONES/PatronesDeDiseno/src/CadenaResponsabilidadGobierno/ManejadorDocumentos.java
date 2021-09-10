package CadenaResponsabilidadGobierno;

public class ManejadorDocumentos {

    private MiembroGubernamental manejador;

    public ManejadorDocumentos() {
    }

    public void manejarDocumento (Documento documento){
        //Asigna la cadena de responsabilidad e inicia el ciruito
        if(manejador==null)
            manejador =
                    new Diputado().setSigJerarca(new Ministro().setSigJerarca(new Presidente()));

        manejador.recibirDocumento(documento);
    }
}
