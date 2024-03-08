package practice.task3_2;

import java.io.FileWriter;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть строку імен, але щоб не було більше 1 пробілу!");
        String line = scanner.nextLine();
        int counter = 0;
        char[] chars = line.toCharArray();
        for (int j = 0; j <chars.length; j++) {
            if(counter>1){
                throw new Exception("Більше одного пробіла в рядку не може бути!");
            }
            if(chars[j]==' '){
                counter++;
            }else{
                counter=0;
            }
        }

        FileWriter fw = new FileWriter("src/practice/task3_2/text.txt",false);
        fw.write(line);
        System.out.println("Дані записали у файл!");
        fw.close();
        scanner.close();
    }
}
