package petsreestr;

public abstract class Animal {
    int id;
    String name;
    String birthDate;

    String[] commands;
    String [] aviableCommands;


    public String[] getAviableCommands(){
        return aviableCommands;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }
    public void setCommand (String[] commands){
        this.commands = commands;
    }

    public String[] getCommands(){
        return commands;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String objToString(){
        String comman = String.join(",", this.commands);
        return String.format("%s %s %s %s %s\n", this.id, this.name, this.getClass().getSimpleName(), this.birthDate, comman);
    }

}