package petsreestr;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileRec {
    private String fileName;
    private String fileContent;
    
    public FileRec(String fileName, String fileContent) {
        this.fileName = fileName;
        this.fileContent = fileContent;
    }
    
    public void writeToDisk(boolean append) throws InterruptedException {
        int i = 5; //пять попыток записи в файл
        while (i > 0){
            try { // пробуем записать в файл
                FileWriter writer = new FileWriter(this.fileName, append);
                BufferedWriter bufferWriter = new BufferedWriter(writer);
                bufferWriter.write(this.fileContent);
                bufferWriter.close();
                System.out.printf("\nATTENTION!\nУСПЕШНАЯ запись в файл: '%s'\n%s\n", fileName, fileContent);
                i = -1;
            }
            catch (IOException | NullPointerException e) { // даем пять попыток
                i--;
                Thread.sleep(2000);
                System.out.printf("ATTENTION!\nНЕУДАЧНАЯ попытка %d/5 записи в файл '%s'", 5 - i, fileName);
                e.printStackTrace();
                }
        }
        if (i == 0){ //(если после 5 неудачных попыток так и не получилось - пробрасываем исключение)
            throw new RuntimeException();
        }
    }
}
