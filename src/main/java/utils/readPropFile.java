package utils;

import java.io.*;
import java.util.Properties;

public class readPropFile {


    public static InputStreamReader isr;
    static BufferedReader buffReader;
    public static File rootPath = new File(System.getProperty("user.dir"));

    static FileInputStream fileInput = null;


    public static String readConfig(String param) {


        File file = new File(rootPath, "/src/main/resources/config.properties");

        try {
            fileInput = new FileInputStream(file);
            isr = new InputStreamReader(fileInput, "windows-1252");
            buffReader = new BufferedReader(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        // load properties file
        try {

            prop.load(buffReader);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop.getProperty(param);

    }

    public static String getText(String param) {


        File file = new File(rootPath, "/src/main/resources/TestText.properties");

        try {
            fileInput = new FileInputStream(file);
            isr = new InputStreamReader(fileInput, "windows-1252");
            buffReader = new BufferedReader(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        // load properties file
        try {

            prop.load(buffReader);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop.getProperty(param);

    }
}
