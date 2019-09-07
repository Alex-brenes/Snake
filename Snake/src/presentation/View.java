package presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import logic.Comida;
import logic.Cuadrilatero;
import logic.Cuerpo;
import logic.Serpiente;

public class View extends javax.swing.JFrame implements Observer {

    private Model model;
    private Controller controller;
    java.awt.image.BufferedImage bf;

    public View() {
        super("Snake");
        this.getContentPane().setBackground(new Color(68, 102, 0));
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        bf = new java.awt.image.BufferedImage(WIDTH, HEIGHT, java.awt.image.BufferedImage.TYPE_INT_RGB);

        this.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
        this.model.addObserver(this);
    }

    @Override
    public void paint(Graphics graphics) {
        java.awt.Graphics g = bf.getGraphics();
        super.paint(g);
        this.dibujarComponentes(model, g);
        graphics.drawImage(bf, 0, 0, null);
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        this.repaint();
    }

    public void dibujarComponentes(Model model, Graphics g) {
        dibujarCuadrilatero(g, model.getCuadrilatero());
        dibujarSerpiente(g, model.getSerpiente());
        dibujarComida(g, model.getComida());
    }

    public void dibujarSerpiente(Graphics g, Serpiente s) {

        g.setColor(new Color(255, 80, 80));
        int r = 255;
        int gr = 1;
        int b = 179;
        g.fillRect(s.getCoordenada_x(), s.getCoordenada_y(), 20, 20);
        if (s.getCuerpo() != null) {
            for (Cuerpo c : s.getCuerpo()) {
                g.setColor(new Color(r, gr, b));
                gr += 10;
                b += 10;
                if (gr > 255) {
                    gr = 1;
                    r = 95;
                }
                if (b > 255) {
                    b = 179;
                }
                g.fillRect(c.getCoordenada_x(), c.getCoordenada_y(), 20, 20);
            }
        }
    }

    public void dibujarComida(Graphics g, Comida c) {
        g.setColor(new Color(26, 163, 255));
        g.fillRect(c.getCoordenada_x(), c.getCoordenada_y(), c.getLado(), c.getLado());
    }

    private void formKeyPressed(java.awt.event.KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP: {
                controller.mover(Model.ARR);
                break;
            }
            case KeyEvent.VK_DOWN: {
                controller.mover(Model.ABA);
                break;
            }
            case KeyEvent.VK_LEFT: {
                controller.mover(Model.IZQ);
                break;
            }
            case KeyEvent.VK_RIGHT: {
                controller.mover(Model.DER);
                break;
            }
        }
    }

    public void dibujarCuadrilatero(Graphics g, Cuadrilatero c) {
        g.setColor(Color.black);
        g.drawRect(c.getCoordenada_x(), c.getCoordenada_y(), c.getBase(), c.getAltura());
    }
    private final int WIDTH = 500;
    private final int HEIGHT = 600;
}
