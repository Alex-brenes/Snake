package presentation;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setModel(model);
        this.view.setController(this);
    }

    public Model getModel() {
        return model;
    }

    public void mover(int flecha) {
        model.mover(flecha);
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void detenerVer() {
        model.detenerVer();
    }

    public void detenerHor() {
        model.detenerHor();
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

}
