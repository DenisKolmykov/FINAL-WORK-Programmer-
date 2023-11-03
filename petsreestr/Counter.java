package petsreestr;

public class Counter {
    
    public int getLastId(){
        String fileName1 = "Pets.txt";
        String fileName2 = "PackAnimals.txt";
        FileRead fileReader = new FileRead(fileName1);
        int petsCount = fileReader.countLines();
        fileReader = new FileRead(fileName2);
        int packAnimalsCount = fileReader.countLines();
        int lastCount = petsCount + packAnimalsCount;

        return lastCount;
    }
}
