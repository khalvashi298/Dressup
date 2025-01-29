//package utils;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Properties;
//
//      public class ConfigReader {
//
//
//
//    public static String read(String key) {
//        Properties properties = new Properties();
//        try {
//            InputStream inputStream = Files.newInputStream(Paths.get("config.properties"));
//            properties.load(inputStream);
//        } catch (Exception e) {
//            System.out.println("Exception: " + e);
//        }
//        return properties.getProperty(key);
//    }
//
//    public static String get(String key) {
//        return read(key);
//    }
//
//
//}
package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

//public class ConfigReader {
//
//    private static Properties properties;
//
//    static {
//        try (FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties")) {
//            properties = new Properties();
//            properties.load(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String read(String key) {
//        return properties.getProperty(key);
//    }
//}
public class ConfigReader {
    private static Properties properties;

    static {
        try {
            InputStream inputStream = Files.newInputStream(Paths.get("config.properties"));
            properties.load(inputStream);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

    }
    public static String get(String key) {
        return get(key);
    }


}



