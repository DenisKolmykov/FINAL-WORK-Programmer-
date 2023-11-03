package petsreestr;

public class start{
    public static void main(String[] args) throws InterruptedException {

        ViewInput view = new ViewInput();
        Model model = new Model();
        Presenter presenter = new Presenter(view, model);
        presenter.menu();

    }
}