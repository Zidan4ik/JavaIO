package practice.task3_1.uploaded;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        String pathStart = "src/practice/task3_1/uploaded/docs/";
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть к-сть текстових файлів для створення: ");
            int amount = scanner.nextInt();

            int c = 0;
            while (c != amount) {
                System.out.println("Введіть назву для " + (c + 1) + " файлу: ");
                String res = scanner.next();

                boolean exist = isExist(pathStart, res);

                if (!exist) {
                    UUID uuid = UUID.randomUUID();
                    String newName = uuid + "_" + res;
                    String path = "src\\practice\\task3_1\\uploaded\\docs\\" + newName;
                    File file = new File(path);
                    if (file.exists()) file.delete();
                    file.createNewFile();

                }
                c++;
            }

            Set<String> namesFile = getFilesInDirectory(pathStart);
            showFileInDirectory(namesFile);

            System.out.println("Введіть назву файлу, в який би ви хотіли записати текст: ");
            String currentNameFile = scanner.next();
            boolean exist = isExist(pathStart, currentNameFile);
            if (exist) {
                scanner.nextLine(); // dangerous
                System.out.println("Введіть текст: ");
                String text = scanner.nextLine();
                for (String f : namesFile) {
                    String[] split = f.split("_");
                    if (currentNameFile.equals(split[1])) {
                        File file = new File(pathStart + split[0] + "_" + split[1]);
                        if (file.exists()) {
                            FileWriter fw = new FileWriter(file);
                            fw.write(text);
                            fw.close();
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Файла з такою назвою не існує в цьому каталозі");
            }
            System.out.println("Введіть слово для перевірки чи є він у файлах: ");
            String word = scanner.next();
            findFileByWord(word, pathStart);
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showFileInDirectory(Set<String> files) {
        System.out.println("Список файлів: ");
        int count = 1;
        for (String file : files) {
            String[] s = file.split("_");
            System.out.println(count++ + ". " + s[1]);
        }
    }

    public static void findFileByWord(String inputWord, String path) throws IOException {
        Set<String> files = getFilesInDirectory(path);
        Set<String> currentFiles = new HashSet<>();
        for (String file : files) {
            String fullPath = path + file;
            FileReader fr = new FileReader(fullPath);
            int s = 0;
            boolean isWord = false;
            String word = "";
            while ((s = fr.read()) != -1) {
                if ((char) s == ' ') {
                    if (word.equals(inputWord)) {
                        break;
                    } else {
                        word = "";
                        continue;
                    }
                }
                word += (char) s;
            }
            if (word.equals(inputWord)) isWord = true;
            if (isWord) currentFiles.add(file);
        }
        if (currentFiles.isEmpty()) {
            System.out.println("Такого слова не існує в жодному файлі");
        } else {
            showFileInDirectory(currentFiles);
        }
    }

    public static Set<String> getFilesInDirectory(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }

    public static String divideUUID(String fullName) {
        if (fullName == null) {
            return null;
        }
        String[] split = fullName.split("_");
        return split[1];
    }

    public static boolean isExist(String path, String futureFile) {
        Set<String> nameFileUUID = getFilesInDirectory(path);
        for (String name : nameFileUUID) {
            if (divideUUID(name).equals(futureFile)) {
                return true;
            }
        }
        return false;
    }
}

