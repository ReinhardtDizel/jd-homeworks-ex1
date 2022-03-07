package main.java;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        final String root = "F://Games";

        Map<String, File> gameDirectories = new LinkedHashMap<>();
        gameDirectories.put("sources", new File(root + "//src"));
        gameDirectories.put("resources", new File(root + "//res"));
        gameDirectories.put("saves", new File(root + "//savegames"));
        gameDirectories.put("temp", new File(root + "//temp"));
        gameDirectories.put("main", new File(root + "//src//main"));
        gameDirectories.put("test", new File(root + "//src//test"));
        gameDirectories.put("drawables", new File(root + "//res//drawables"));
        gameDirectories.put("vectors", new File(root + "//res//vectors"));
        gameDirectories.put("icons", new File(root + "//res//icons"));

        gameDirectories.forEach((k, v) -> {
                    if (v.mkdir()) {
                        System.out.printf("Directory %s is created!\n", k);
                    } else {
                        System.out.printf("Failed to create %s directory!\n", k);
                    }
                }
        );

        Map<String, File> gameFiles = new HashMap<>();
        gameFiles.put("Main",
                new File(gameDirectories.get("main").getAbsolutePath() + "Main.java")
        );
        gameFiles.put("Utils",
                new File(gameDirectories.get("main").getAbsolutePath() + "Utils.java")
        );
        gameFiles.put("temp",
                new File(gameDirectories.get("temp").getAbsolutePath() + "temp.txt")
        );

        gameFiles.forEach((k, v) -> {
            try {
                if (v.createNewFile()) {
                    System.out.printf("File %s is created!\n", k);
                } else {
                    System.out.printf("Failed to create %s File!\n", k);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}