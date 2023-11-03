package petsreestr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ViewInput {
    private Scanner scanner;

    public ViewInput() {
        this.scanner = new Scanner(System.in);
    }

    // метод для ввода свойств нового (создаваемого) объекта для реестра
    public String inputElement(String elemName){
        System.out.printf("Введите %s\n--> ", elemName);
        String inpData = scanner.nextLine();
        return inpData;
    }

    public String[] inputCommands(String[] commands, String[] aviableComm){
        String[] arrayCheckInput = new String [aviableComm.length];
        String [] splitedStr = null;
        boolean flag = true;
        Set<String> setCommand = new HashSet<>(); //множество введенных команд

        int commLen = 0;
        if (commands != null){
            commLen = commands.length;
            setCommand = new HashSet<>(Arrays.asList(commands));
        }
        while (flag){
            System.out.printf("У животного сейчас %d команд:\n%s\n", commLen, Arrays.toString(commands));
            System.out.println("Доступные команды:");
            //System.out.println(Arrays.toString(aviableComm));
            int i = 1;
            for (String comm : aviableComm){
                System.out.printf("%d:%s ", i, comm);
                arrayCheckInput[i-1] = Integer.toString(i);
                i++;
            }
            System.out.print("\nВведите через пробел номера команд:--> ");
            String inpData = scanner.nextLine();
            splitedStr = inpData.split(" ");
            
            // System.out.println(Arrays.toString(splitedStr));
            //System.out.println(Arrays.toString(arrayCheckInput));

            Set<String> setCommandNum = new HashSet<>(Arrays.asList(splitedStr)); //множество номеров введенных команд
            //System.out.println(setCommandNum);
            
            Set<String> setCheckNum = new HashSet<>(Arrays.asList(arrayCheckInput)); //множество номеров доступных команд
            //System.out.println(setCheckNum);

            splitedStr = setCommandNum.toArray(new String[setCommandNum.size()]); // переводим множество в массив
            //System.out.println(Arrays.toString(splitedStr));

            setCommandNum.removeAll(setCheckNum); // наложение множеств номеров доступных команд и введенных
            //System.out.println(setCommandNum);
            
            if (setCommandNum.size() != 0){ // если после пересечения ничего не осталось, то все команды введены корректно
                System.out.println("Вы ввели не корректное значение, повторите ввод");
            } else {
                //Set<String> setCommand = new HashSet<>(Arrays.asList(commands)); //множество введенных команд
                for (int j = 0; j < splitedStr.length; j++){
                    setCommand.add(aviableComm[Integer.parseInt(splitedStr[j])-1]);
                }
                commands = setCommand.toArray(new String[setCommand.size()]); // переводим множество в массив
                //System.out.println(Arrays.toString(commands));
                flag = false;
            }
        }
        return commands;
    }

    public String mainMenuChoice(){
        String[] arrayCheckInput = {"0", "1", "2", "3"};
        String mainChoice = "";
        boolean flag = true;
        while (flag){
            System.out.println("ГЛАВНОЕ МЕНЮ:");
            System.out.println("1. Добавить новое животное в реестр");
            System.out.println("2. Научить животное командам");
            System.out.println("3. Вывести РЕЕСТР животных");
            System.out.println("0. ВЫХОД");
            
            System.out.print("--> ");
            mainChoice = scanner.nextLine();
            if (!Arrays.asList(arrayCheckInput).contains(mainChoice)){
                System.out.println("Вы ввели не корреткное значение, повторите ввод");
            } else {
                flag = false;
            }
        }
        return mainChoice;
    }

    public String TypeAnimalChoice(){
        String[] arrayCheckInput = {"0", "1", "2", "3", "4", "5", "6"};
        String choice = "";
        boolean flag = true;
        System.out.println("подменю 1 - Добавить новое животное");
        while (flag){
            System.out.println("Укажите тип животного");
            System.out.println("1. Cat");
            System.out.println("2. Dog");
            System.out.println("3. Hamster");
            System.out.println("4. Horse");
            System.out.println("5. Camel");
            System.out.println("6. Donkey");

            System.out.println("0. ВЫХОД");
            
            System.out.print("--> ");
            choice = scanner.nextLine();
            if (!Arrays.asList(arrayCheckInput).contains(choice)){
                System.out.println("Вы ввели не корректное значение, повторите ввод");
            } else {
                flag = false;
            }
        }
        return choice;
    }


    public int subMenu2Choice(){
        //String[] arrayCheckInput = {"0", "1", "2", "3"};
        //int id = 0;
        //boolean flag = true;
        //while (flag){
            System.out.println("подменю 2 - Научить животное командам");
            System.out.println("Укажите id животного");
            System.out.println("или \n0. ВЫХОД");
            
            System.out.print("--> ");
            int id = Integer.parseInt(scanner.nextLine());
        //}
        return id;
    }


}
