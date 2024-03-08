package practice.task3_7.v2;

import practice.task3_7.User;

import java.io.*;
import java.util.List;

public class DeserializeUsers {
    public static void main(String[] args) {
        File file = new File("src/practice/task3_7/v2/text.bin");
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<User> object = (List<User>) ois.readObject();

            for (int i = 0; i < object.size(); i++) {
                System.out.println(object.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
