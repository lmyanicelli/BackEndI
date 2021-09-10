package CadenaResponsabilidadGobierno;

public class Ministro extends MiembroGubernamental{

    @Override
    public void leerDocumento(Documento documento) {
        if(documento.getTipoDocumento()<=Documento.SECRETO)
            System.out.println("El Ministro está leyendo el documento: " + documento.getTipoDocumento());
    }
}
