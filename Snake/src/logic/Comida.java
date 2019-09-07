package logic;

import java.util.Random;

public class Comida {

    private int coordenada_x;
    private int coordenada_y;
    private static final int lado = 20;

    public Comida(int coordenada_x, int coordenada_y) {
        this.coordenada_x = coordenada_x;
        this.coordenada_y = coordenada_y;
    }

    public void cambiarPos(Serpiente s, Cuadrilatero c) {
        Random random = new Random();
        this.coordenada_x = random.nextInt((c.getBase() / lado)) * lado + c.getCoordenada_x();
        this.coordenada_y = random.nextInt((c.getAltura() / lado)) * lado + c.getCoordenada_y();
        
        System.out.println(coordenada_x);
        System.out.println(coordenada_y);
        
    }

    public int getLado() {
        return lado;
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

}
