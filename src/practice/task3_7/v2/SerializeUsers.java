package practice.task3_7.v2;

import practice.task3_7.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeUsers {
    public static void main(String[] args) {
        File file = new File("src/practice/task3_7/v2/text.bin");
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream ois = new ObjectOutputStream(fos)){
            List<User> users = new ArrayList<>();
            users.add(new User("roma","pravnyk",20));
            users.add(new User("dima","krasnogor",19));
            users.add(new User("sasha","volodko",21));


            ois.writeObject(users);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
