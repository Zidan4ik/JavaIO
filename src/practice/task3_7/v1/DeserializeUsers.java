package practice.task3_7.v1;

import practice.task3_7.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeserializeUsers {
    public static void main(String[] args) {
        File file = new File("src/practice/task3_7/v1/text.bin");
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            int userAmount = ois.readInt();
            User[] users = new User[userAmount];

            for (int i = 0; i < userAmount; i++) {
                users[i] = (User) ois.readObject();
            }

            System.out.println(Arrays.toString(users));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
