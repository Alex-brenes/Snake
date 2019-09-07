/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

/**
 *
 * @author pc
 */
public class Snake {

    public static void main(String[] args) {
        presentation.Model model = new presentation.Model();
        presentation.View view = new presentation.View();
        presentation.Controller controller = new presentation.Controller(model, view);
        view.setVisible(true);
        for (;;) {
            model.mover();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {

            }
        }
    }

}
