package examples.serealize;

import java.io.*;

public class WriteClass {
    public static void main(String[] args) {

        Pet dog = new Pet("Jacky",Type.dog);
        Pet cat = new Pet("Dipi",Type.cat);

        try {
            FileOutputStream fos = new FileOutputStream(new File("animals.bin"));
            ObjectOutputStream ois = new ObjectOutputStream(fos);

            ois.writeObject(dog);
            ois.writeObject(cat);

            ois.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
