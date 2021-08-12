package CadenaResponsabilidadGobierno;

public class Documento {

    static final Integer RESERVADO = 1;
    static final Integer SECRETO = 2;
    static final Integer MUY_SECRETO = 3;

    private String contenido;
    private Integer tipoDocumento;

    public Documento(String contenido, Integer tipoDocumento) {
        this.contenido = contenido;
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
