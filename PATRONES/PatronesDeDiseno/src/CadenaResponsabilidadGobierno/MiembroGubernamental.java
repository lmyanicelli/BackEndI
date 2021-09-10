package CadenaResponsabilidadGobierno;

public abstract class MiembroGubernamental {

    protected MiembroGubernamental sigJerarca;

    public void recibirDocumento(Documento documento){
        leerDocumento(documento);
        if(this.sigJerarca!= null)
            this.sigJerarca.recibirDocumento(documento);
    }

    public abstract void leerDocumento(Documento documento);

    public MiembroGubernamental getSigJerarca() {
        return sigJerarca;
    }

    //Hago que retorne el siguiente Jerarca para que en el main se pueda
    // crear la cadena de responsabilidades fácilmente
    public MiembroGubernamental setSigJerarca(MiembroGubernamental sigJerarca) {
        this.sigJerarca = sigJerarca;
        return this;
    }
}
