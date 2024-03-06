package examples.serealize;

import java.io.*;

public class ReaderFileClass {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream(new File("animals.bin"));
            ObjectInputStream ois = new ObjectInputStream(fis);

            Pet pet1 = (Pet) ois.readObject();
            Pet pet2 = (Pet) ois.readObject();

            System.out.println(pet1);
            System.out.println(pet2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
