package petsreestr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead {
    private String fileName;
    //private String fileContent;

    public FileRead(String fileName) {
        this.fileName = fileName;
        //this.fileContent = fileContent;
    }

    public ArrayList<Animal> readLinesFromFile() {
        ArrayList <Animal> animalsList = new ArrayList<>();
        String [] lines = null;
        System.out.printf("Список животных класса %s:\n", this.fileName.substring(0, this.fileName.length()-4));
        try {
            FileReader fileReader = new FileReader(this.fileName);            
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines = line.split(" ");
                Animal animal = new Animal() {
                };
                switch (lines[2]) {
                    case "Cat":
                        animal = new Cat();
                        break;
                
                    case "Dog":
                    animal = new Dog();
                        break;

                    case "Hamster":
                    animal = new Hamster();
                        break;

                    case "Horse":
                    animal = new Horse();
                        break;

                    case "Camel":
                    animal = new Camel();
                        break;

                    case "Donkey":
                    animal = new Donkey();
                        break;
                }
                animal.setId(Integer.parseInt(lines[0]));
                animal.setName(lines[1]);
                animal.setBirthDate(lines[3]);
                String[] command = lines[4].split(",");
                animal.setCommand(command);
                
                animalsList.add(animal);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex){
            System.out.printf("Животные класса '%s' отсутствуют в реестре\n\n", this.fileName.substring(0, this.fileName.length()-4));
        }
        catch (IOException e) {
            e.printStackTrace();
        } 
        return animalsList;
    }

    public int countLines(){
        int count = 0;
        try {
            FileReader fileReader = new FileReader(this.fileName);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((bufferedReader.readLine()) != null) {
                    count++;
                }
            } 
        }    
        catch (IOException e) {
            e.printStackTrace();
        }
        return count;

    }
}
