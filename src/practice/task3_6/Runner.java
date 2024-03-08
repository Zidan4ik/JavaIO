package practice.task3_6;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    private static boolean flag = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вкажіть директорію: ");
        String directory = scanner.next();
        System.out.println("Вкажіть розширення файлу для виведення на екран: ");
        String expanse = scanner.next();

        Set<File> filesInDirectory = getFilesInDirectory(directory);
        System.out.println("Список файлів з розширенням (" + expanse + "): ");
        for (File file : filesInDirectory) {
            if (file.isDirectory()) {
                getDirectories(file, expanse);
            } else {
                if ((getExpanse(file).equals(expanse))) {
                    System.out.println("Каталог " + file + " : ");
                    System.out.println(file.getName());
                }
            }
        }
        if(!flag){
            System.out.println("Файлів з подібним розширенням не існує в каталозі!");
        }
        scanner.close();
    }

    public static Set<File> getFilesInDirectory(String path) {
        return Stream.of(new File(path).listFiles())
                .collect(Collectors.toSet());
    }

    public static void getDirectories(File package_, String ex) {
        for (File file : package_.listFiles()) {
            if (!file.isDirectory()) {
                if (getExpanse(file).equals(ex)) {
                    System.out.println("Каталог " + package_ + " : ");
                    System.out.println(file.getName());
                    flag = true;
                }
            } else {
                getDirectories(file, ex);
            }
        }
    }

    public static String getExpanse(File file) {
        String[] split = null;
        if (file != null && !file.isDirectory()) {
            split = file.getName().split("\\.");
            return split[1];
        }
        return null;
    }
}
