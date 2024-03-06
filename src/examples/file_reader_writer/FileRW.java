package examples.file_reader_writer;

import java.io.*;

public class FileRW {
    public static void main(String[] args) {
        File file1 = new File("C:\\Users\\Roma\\IdeaProjects\\JavaIO\\src\\examples\\file_reader_writer\\file1.txt");
        File file2 = new File("C:\\Users\\Roma\\IdeaProjects\\JavaIO\\src\\examples\\file_reader_writer\\file2.txt");

        try (FileReader fr = new FileReader(file1);
             FileWriter fw = new FileWriter(file2,true)) {
            String res = "";
            int i=0;
            while((i=fr.read())!=-1){
                System.out.print((char)i);
                res+=(char)i;
            }
            fw.write(res);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
