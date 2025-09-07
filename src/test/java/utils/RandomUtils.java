package utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    public static String getRandomFromList(List<String> list){
        int ind= (int) (Math.random()*list.size());

        return list.get(ind);
    }

    public static List<String> getRandomList(List<String> list, int quantity){

        return list.subList(0, quantity);
    }

    public static String getRandomNumberString(int numbers){
        String digits = "0123456789";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers; i++)
            sb.append(digits.charAt(rnd.nextInt(digits.length())));

        return sb.toString();
    }

    public static String getRandomString(int numbers){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));

        return sb.toString();
    }
    public static String getRandomResourceFileName() throws IOException, URISyntaxException {
        String filename;

        Path resourceDirectory = Paths.get("src","test","resources");

        // Получить список всех файлов в папке
        List<Path> files = Files.list(resourceDirectory)
                .toList();

        if (files.isEmpty()) {
            throw new IOException("В папке ресурсов нет файлов.");
        }

        // Выбрать случайный файл
        Random random = new Random();
        Path randomFilePath = files.get(random.nextInt(files.size()));
        filename = String.valueOf(randomFilePath.getFileName());

        return filename;
    }
}
