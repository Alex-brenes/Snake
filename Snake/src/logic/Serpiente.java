package logic;

import java.util.ArrayList;
import java.util.List;
import presentation.Model;

public class Serpiente {

    private List<Cuerpo> cuerpo;
    private Cuerpo cabeza;
    private boolean detener;

    public Serpiente(int coordenada_x, int coordenada_y, int direccion_x, int direccion_y) {
        detener = false;
        cuerpo = new ArrayList();
        cabeza = new Cuerpo(coordenada_x, coordenada_y, direccion_x, 0, 20);
    }

    public void movimiento(Model m) {
        Cuadrilatero c = m.getCuadrilatero();
        detener(c);
        if (!detener) {
            if (cuerpo.size() > 0) {
                //Se mueve el cuerpo
                int n = cuerpo.size() - 1;
                for (int i = n; i >= 1; i--) {
                    cuerpo.get(i).movimiento(cuerpo.get(i - 1));
                }
                //Se mueve el primer elemento del arreglo
                cuerpo.get(0).movimiento(cabeza);
            }

            //Mueve la cabeza
            this.cabeza.setCoordenada_x(this.getCoordenada_x() + this.getDireccion_x());
            this.cabeza.setCoordenada_y(this.getCoordenada_y() + this.getDireccion_y());
            if (come(m.getComida())) {
                m.getComida().cambiarPos(this, m.getCuadrilatero());
                crecer(m.getCuadrilatero());
            }
        }
    }

  
    public void detener(Cuadrilatero c) {
        if (this.cabeza.getCoordenada_x() <= c.getCoordenada_x() - cabeza.getLado() || (this.cabeza.getCoordenada_x() + this.cabeza.getLado() >= c.getCoordenada_x() + c.getBase() + cabeza.getLado())) {
            this.detener = true;
        } else if (this.cabeza.getCoordenada_y() <= c.getCoordenada_y() - cabeza.getLado() || this.cabeza.getCoordenada_y() + this.cabeza.getLado() >= c.getCoordenada_y() + c.getAltura() + cabeza.getLado()) {
            this.detener = true;
        } else {
            if (intersecta()) { //Si choca con alguno de sus segmentos
                this.detener = true;
            } else {
                this.detener = false;

            }
        }
    }

    public boolean intersecta() {
        for (Cuerpo c : cuerpo) {
            if (c.getCoordenada_x() == cabeza.getCoordenada_x()
                    && c.getCoordenada_y() == cabeza.getCoordenada_y()) {
                return true;
            }
        }
        return false;
    }

    public Cuerpo getCabeza() {
        return cabeza;
    }

    public List<Cuerpo> getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(List<Cuerpo> cuerpo) {
        this.cuerpo = cuerpo;
    }

    public int getCoordenada_x() {
        return this.cabeza.getCoordenada_x();
    }

    public int getDireccion_x() {
        return this.cabeza.getDireccion_x();
    }

    public int getDireccion_y() {
        return this.cabeza.getDireccion_y();
    }

    public int getCoordenada_y() {
        return this.cabeza.getCoordenada_y();
    }

    public void setCuerpo(Cuerpo cabeza) {
        this.cabeza = cabeza;
    }

    public boolean come(Comida c) {
        if (c.getCoordenada_x() + c.getLado() / 2 == this.cabeza.getCoordenada_x() + this.cabeza.getLado() / 2
                && c.getCoordenada_y() + c.getLado() / 2 == this.cabeza.getCoordenada_y() + this.cabeza.getLado() / 2) {
            return true;
////        }
////        if ((c.getCoordenada_y() > this.getCoordenada_y() && c.getCoordenada_y() < this.getCoordenada_y() + cabeza.getLado())
////                && (c.getCoordenada_x() > this.getCoordenada_x() && c.getCoordenada_x() < this.getCoordenada_x() + cabeza.getLado())) {
////            if ((c.getCoordenada_y()  + c.getLado() / 2> this.getCoordenada_y() && c.getCoordenada_y() < this.getCoordenada_y() + cabeza.getLado())
////                    && (c.getCoordenada_x() + c.getLado() / 2 > this.getCoordenada_x() && c.getCoordenada_x() + c.getLado() / 2 < this.getCoordenada_x() + cabeza.getLado())) {
////                return true;
////
////            }
////        }
        }
        return false;
    }

    public void crecer(Cuadrilatero c) {

        if (cuerpo.size() > 0) {
            Cuerpo ultimo = this.cuerpo.get(cuerpo.size() - 1);
            this.cuerpo.add(new Cuerpo(ultimo.getCoordenada_x() - ultimo.getDireccion_x(), ultimo.getCoordenada_y() - ultimo.getDireccion_y(), ultimo.getDireccion_x(), ultimo.getDireccion_y(), ultimo.getLado()));
        } else {
            this.cuerpo.add(new Cuerpo(cabeza.getCoordenada_x() - cabeza.getDireccion_x(), cabeza.getCoordenada_y() - cabeza.getDireccion_y(), cabeza.getDireccion_x(), cabeza.getDireccion_y(), cabeza.getLado()));
        }

    }

    public int getDimension() {
        return this.cabeza.getLado();
    }
}
