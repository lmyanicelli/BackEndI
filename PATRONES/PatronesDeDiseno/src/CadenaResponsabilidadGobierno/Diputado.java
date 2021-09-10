package CadenaResponsabilidadGobierno;

public class Diputado extends MiembroGubernamental{

    @Override
    public void leerDocumento(Documento documento) {
        if(documento.getTipoDocumento()<=Documento.RESERVADO)
            System.out.println("El diputado está leyendo el documento: " + documento.getTipoDocumento());
    }
}
