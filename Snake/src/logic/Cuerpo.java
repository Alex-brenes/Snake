package logic;

public class Cuerpo {

    private int coordenada_x;
    private int coordenada_y;
    private int direccion_x;
    private int direccion_y;
    private int lado;

    public Cuerpo(int coordenada_x, int coordenada_y, int direccion_x, int direccion_y, int lado) {
        this.coordenada_x = coordenada_x;
        this.coordenada_y = coordenada_y;
        this.direccion_x = direccion_x;
        this.direccion_y = direccion_y;
        this.lado = lado;
    }

    public int getDireccion_x() {
        return direccion_x;
    }

    public void setDireccion_x(int direccion_x) {
        this.direccion_x = direccion_x;
    }

    public int getDireccion_y() {
        return direccion_y;
    }

    public void setDireccion_y(int direccion_y) {
        this.direccion_y = direccion_y;
    }

    public int getCoordenada_x() {
        return coordenada_x;
    }

    public void setCoordenada_x(int coordenada_x) {
        this.coordenada_x = coordenada_x;
    }

    public int getCoordenada_y() {
        return coordenada_y;
    }

    public void setCoordenada_y(int coordenada_y) {
        this.coordenada_y = coordenada_y;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public void movimiento(Cuerpo c) {
        if (this.coordenada_x > c.coordenada_x) {
            this.setDireccion_x((-1) * lado);
            this.setDireccion_y(0);
        } else if (this.coordenada_x < c.coordenada_x) {
            this.setDireccion_x(lado);
            this.setDireccion_y(0);
        } else if (this.coordenada_y > c.coordenada_y) {
            this.setDireccion_y((-1) * lado);
            this.setDireccion_x(0);
        } else if (this.coordenada_y < c.coordenada_y) {
            this.setDireccion_y(lado);
            this.setDireccion_x(0);
        }
        this.coordenada_x = c.coordenada_x;
        this.coordenada_y = c.coordenada_y;
    }

}
