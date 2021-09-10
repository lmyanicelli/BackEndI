package CadenaResponsabilidadGobierno;

public class Presidente extends MiembroGubernamental{

    @Override
    public void leerDocumento(Documento documento) {
        if(documento.getTipoDocumento()<=Documento.MUY_SECRETO)
            System.out.println("El Presidente está leyendo el documento: " + documento.getTipoDocumento());
    }
}
