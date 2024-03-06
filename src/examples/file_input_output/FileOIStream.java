package examples.file_input_output;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOIStream {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Roma\\IdeaProjects\\JavaIO\\src\\examples\\file_input_output\\text.txt");
        try (FileInputStream inputStream = new FileInputStream(file);
             FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Roma\\IdeaProjects\\JavaIO\\src\\examples\\file_input_output\\txtByte.txt", false)) {
           
            System.out.printf("File size: %d bytes \n", inputStream.available());
            byte[] b = new byte[inputStream.available()];

            while ((inputStream.read(b)) != -1) {
                System.out.print("Bytes: ");
                for (int j = 0; j < b.length; j++) {
                    System.out.print(b[j] + " ");
                }
            }

            System.out.printf("\nFile size: %d bytes", inputStream.available());

            String enter = System.getProperty("line.separator");
            byte[] enterByte = enter.getBytes();

            fileOutputStream.write(b);
            fileOutputStream.write(enterByte);
            fileOutputStream.write(b);

        } catch (IOException exception) {
            exception.getStackTrace();
        }

    }
}
