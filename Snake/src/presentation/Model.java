package presentation;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import logic.Comida;
import logic.Cuadrilatero;
import logic.Serpiente;

public class Model extends Observable {

    private Cuadrilatero cuadrilatero;
    private Serpiente serpiente;
    private Comida comida;

    public Model() {
        Random random = new Random();

        this.cuadrilatero = new Cuadrilatero(50, 50, 400, 500);
        this.serpiente = new Serpiente(150, 150, 20, 20);
        this.comida = new Comida(random.nextInt((cuadrilatero.getBase() / serpiente.getDimension())) * serpiente.getDimension() + cuadrilatero.getCoordenada_x() , random.nextInt(cuadrilatero.getAltura() / serpiente.getDimension()) * serpiente.getDimension() + cuadrilatero.getCoordenada_y());
    }

    public Cuadrilatero getCuadrilatero() {
        return cuadrilatero;
    }

    public void setCuadrilatero(Cuadrilatero cuadrilatero) {
        this.cuadrilatero = cuadrilatero;
    }

    public Serpiente getSerpiente() {
        return serpiente;
    }

    public void setSerpiente(Serpiente serpiente) {
        this.serpiente = serpiente;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public void mover(int flecha) {
        switch (flecha) {
            case ARR: {
                if (serpiente.getCabeza().getDireccion_y() <= 0) {
                    serpiente.getCabeza().setDireccion_y(-20);
                    detenerHor();
                }
                break;
            }
            case ABA: {
                if (serpiente.getCabeza().getDireccion_y() >= 0) {
                    serpiente.getCabeza().setDireccion_y(20);
                    detenerHor();
                }
                break;
            }
            case IZQ: {
                if (serpiente.getCabeza().getDireccion_x() <= 0) {
                    serpiente.getCabeza().setDireccion_x(-20);
                    detenerVer();
                }
                break;
            }
            case DER: {
                if (serpiente.getCabeza().getDireccion_x() >= 0) {
                    serpiente.getCabeza().setDireccion_x(20);
                    detenerVer();
                }
                break;
            }
        }
    }

    public void detenerVer() {
        serpiente.getCabeza().setDireccion_y(0);
    }

    public void detenerHor() {
        serpiente.getCabeza().setDireccion_x(0);
    }

    public void iniciar() {
        final int mili_segundos = 42;
        Runnable code = new Runnable() {
            public void run() {
                while (true) {
                    mover();
                    setChanged();
                    notifyObservers();
                    try {
                        Thread.sleep(mili_segundos);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        Thread thread = new Thread(code);
        thread.start();
    }

    @Override
    public void addObserver(Observer observer) {
        super.addObserver(observer);
        this.setChanged();
        this.notifyObservers();
    }

    public void mover() {
        this.serpiente.movimiento(this);
        this.setChanged();
        this.notifyObservers();
    }

    static final int ARR = 0;
    static final int ABA = 1;
    static final int IZQ = 2;
    static final int DER = 3;

}
