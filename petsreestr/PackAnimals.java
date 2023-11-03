package petsreestr;

//import java.util.ArrayList;

public abstract class PackAnimals extends Animal {

    String [] aviableCommands = {"Sit", "Stay", "Fetch", "Pounce", "Roll", "Hide", "Paw", "Bark", "Scratch", "Spin", "Jump"};

    public String[] getAviableCommands (){
        return aviableCommands;
    }
}
