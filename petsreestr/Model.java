package petsreestr;

import java.util.ArrayList;

public class Model {
    ViewInput view = new ViewInput();

    public void addNewAnimal(String choi) throws InterruptedException{
        Animal animal = new Animal() {
        };
        switch (choi) {
            case "1":
                animal = new Cat();
                break;
            case "2":
                animal = new Dog();
                break;
            case "3":
                animal = new Hamster();
                break;
            case "4":
                animal = new Horse();
                break;
            case "5":
                animal = new Camel();
                break;
            case "6":
                animal = new Donkey();
                break;
            case "0":
                return;
        }

        String name = view.inputElement("Имя: ");

        boolean f = true;
        String birthDate = "";
        while (f){
            birthDate = view.inputElement("Дату рождения: ");
            CheckDateFormat chechDate = new CheckDateFormat();
            if (chechDate.isBirthDate(birthDate) != 0){
                f = false;
            }
        }

        String[] commands = view.inputCommands(animal.getCommands(), animal.getAviableCommands());

        Counter counter = new Counter();
        int id = counter.getLastId() + 1;

        animal.setName(name);
        animal.setBirthDate(birthDate);
        animal.setCommand(commands);
        animal.setId(id);

        String fileName = String.format(animal.getClass().getSuperclass().getSimpleName() + ".txt");        
        String fileContent = animal.objToString();

        FileRec fileRecord = new FileRec(fileName, fileContent);
        try{ // попытка записи в файл 
            fileRecord.writeToDisk(true); //дозапись в файл
        }catch(RuntimeException e){ //(если после 5 неудачных попыток так и не получилось - заканчиваем сеанс)
            System.out.printf("ATTENTION!\nПосле 5 НЕУДАЧНЫХ попыток запись в файл '%s' прервана!\nСтрока: %s не сохранена!\n",fileName, fileContent);
        }
    }

    public ArrayList<Animal> getReestr(String fileName){
        FileRead fileReader = new FileRead(fileName);
        ArrayList<Animal> reestr = new ArrayList<>();
        reestr = fileReader.readLinesFromFile();
        return reestr;
    }

    public void editAnimal(int id) throws InterruptedException{
        System.out.println("id = " + id);
        if (id == 0){
            return;
        }
        String [] fileNames = {"Pets.txt", "PackAnimals.txt"};
        boolean flag = false;
        for (String n : fileNames){
            FileRead fileReader = new FileRead(n);
            ArrayList<Animal> reestr = fileReader.readLinesFromFile();
            
            for (Animal animal : reestr){
                if (animal.getId() == id){
                    flag = true;
                    System.out.println(animal.objToString());
                    reestr.remove(animal);
                    String[] newCommands = view.inputCommands(animal.getCommands(), animal.getAviableCommands());
                    animal.setCommand (newCommands);
                    System.out.println("Список команд животного обновлен:");
                    System.out.println(animal.objToString());
                    reestr.add(animal);
                    
                    String fileContent = "";
                    FileRec fileRecord = new FileRec(n, fileContent); //очистка файла
                    try{ // попытка записи в файл 
                        fileRecord.writeToDisk(false); //полная перезапись файла
                    }catch(RuntimeException e){ //(если после 5 неудачных попыток так и не получилось - заканчиваем сеанс)
                        System.out.printf("ATTENTION!\nПосле 5 НЕУДАЧНЫХ попыток запись в файл '%s' прервана!\nСтрока: %s не сохранена!\n",n, fileContent);
                    }

                    for (Animal a: reestr){
                        fileContent = a.objToString();
                        fileRecord = new FileRec(n, fileContent);
                        try{ // попытка записи в файл 
                            fileRecord.writeToDisk(true); //полная перезапись файла
                        }catch(RuntimeException e){ //(если после 5 неудачных попыток так и не получилось - заканчиваем сеанс)
                            System.out.printf("ATTENTION!\nПосле 5 НЕУДАЧНЫХ попыток запись в файл '%s' прервана!\nСтрока: %s не сохранена!\n",n, fileContent);
                        }
                    }
                    return;
                }
            }
        }
        if (!flag){
            System.out.printf ("Животное с id = %d отсутствует в реестре\n", id);
        }
    }
}
