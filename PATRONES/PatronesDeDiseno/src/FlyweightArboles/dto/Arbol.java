package FlyweightArboles.dto;

public class Arbol {

    private Double alto;
    private Double horizontal;
    private String color;
    private String tipoArbol;

    public Arbol(Double alto, Double horizontal, String color, String tipoArbol) {
        this.alto = alto;
        this.horizontal = horizontal;
        this.color = color;
        this.tipoArbol = tipoArbol;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(Double horizontal) {
        this.horizontal = horizontal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoArbol() {
        return tipoArbol;
    }

    public void setTipoArbol(String tipoArbol) {
        this.tipoArbol = tipoArbol;
    }

    @Override
    public String toString() {
        return "Arbol{" +
                "alto=" + alto +
                ", horizontal=" + horizontal +
                ", color='" + color + '\'' +
                ", tipoArbol='" + tipoArbol + '\'' +
                '}';
    }
}
