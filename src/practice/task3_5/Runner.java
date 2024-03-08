package practice.task3_5;

import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть директорію, де будуть видалено всі текстові файли: ");
        String directory = scanner.next();

        Set<File> filesInDirectory = getFilesInDirectory(directory);
       if(filesInDirectory!=null){
           System.out.println("Отримані файли: ");
           for(File file:filesInDirectory){
               if(!isTxtFile(file))
                   System.out.println(file.getName());
           }
           while(true){
               System.out.println("Впевнені, що хочете видалити: 1 - Так, 2 - Ні");
               int i = scanner.nextInt();
               if(i==1){
                   for (File file : filesInDirectory) {
                       if (file.exists()) {
                           if (!isTxtFile(file)) {
                               System.out.println("Видалено файл: "+file.getName());
                               System.out.println("За шляхом: "+file.getPath());
                               System.out.println();
                               file.delete();
                           }
                       }
                   }
                   break;
               }
               else if(i==2){
                   break;
               }
               else{
                   System.out.println("Для подальшої дії потрібно ввести: 1 або 2");
               }
           }
       }
    }

    public static Set<File> getFilesInDirectory(String dir) {
        Set<File> files = Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .collect(Collectors.toSet());
        return files;
    }

    public static boolean isTxtFile(File file) {
        if (file != null && file.getName().contains(".java")) {
            return true;
        } else {
            return false;
        }
    }
}
