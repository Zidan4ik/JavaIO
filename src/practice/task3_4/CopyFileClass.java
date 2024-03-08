package practice.task3_4;

import java.io.*;

public class CopyFileClass {
    public static void main(String[] args) {
        try {
            File file1 = new File("src/practice/task3_4/txt1.txt");
            File file2 = new File("src/practice/task3_4/txt2.txt");

            String text1 = getTextByFile(file1);
            writeInFile(file2, text1);
            String text2 = getTextByFile(file2);

            if(text1.equals(text2)){
                System.out.println("Копіювання даних пройшло успішно");
            }else{
                System.out.println("Неправильно скопійовано дані!!!");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTextByFile(File file) throws IOException {
        FileReader fr = new FileReader(file);
        String line = "";
        int i = 0;
        while ((i = fr.read()) != -1) {
            line += (char) i;
        }
        fr.close();
        return line;
    }
    public static void writeInFile(File file, String text) throws IOException {
            FileWriter fw = new FileWriter(file);
            fw.write(text);
            fw.close();
    }
}
