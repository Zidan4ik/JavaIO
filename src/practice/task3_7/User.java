package practice.task3_7;

import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -4542198894642318343L;
    private String name;
    private String surname;
    private int age;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "name=" + name +
                ", surname=" + surname +
                ", age=" + age;
    }
}
