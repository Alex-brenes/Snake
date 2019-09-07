package logic;

public class Cuadrilatero {
    private int coordenada_x;
    private int coordenada_y;
    private int base;
    private int altura;

    public Cuadrilatero(int coordenada_x, int coordenada_y, int base, int altura) {
        this.coordenada_x = coordenada_x;
        this.coordenada_y = coordenada_y;
        this.base = base;
        this.altura = altura;
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

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
}
