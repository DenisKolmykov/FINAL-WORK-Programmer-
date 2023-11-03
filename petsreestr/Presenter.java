package petsreestr;

import java.util.ArrayList;

public class Presenter {
    ViewInput view = new ViewInput();
    Model model = new Model();

public Presenter (ViewInput view,  Model model){
    this.view = view;
    this.model = model;
}

    public void menu() throws InterruptedException{
        boolean flag = true;
        while (flag){
            String choice = view.mainMenuChoice();
            switch (choice) {
                case "1":
                    String choi = view.TypeAnimalChoice();
                    model.addNewAnimal(choi);
                    break;
                    
                case "2":
                    int cho = view.subMenu2Choice();
                    model.editAnimal(cho);
                    break;
                
                case "3":
                    String[] fileNames = {"Pets.txt","PackAnimals.txt"};
                    for (String f : fileNames){
                        ArrayList<Animal> reestr = model.getReestr(f);
                        for (Animal a : reestr){
                            System.out.println(a.objToString());
                        }
                    }
                    break;

                    
                case "0":
                    System.out.println("До свидания!");
                    return;
            }
    
        }
    }
}