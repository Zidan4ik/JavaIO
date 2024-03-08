package practice.task3_3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("src/practice/task3_2/text.txt");
            int s = 0;
            String word = "";
            List<String> names = new ArrayList<>();
            while ((s = reader.read()) != -1) {
                word += (char) s;
            }
            if (word != null) {
                String[] split = word.split(" ");
                names = new ArrayList<>(List.of(split));
            }

            for (String name : names) {
                System.out.print(name + " ");
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
