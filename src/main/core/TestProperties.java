package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

    public static String get(String property) {
        String out = "";
        InputStream file = null;
        Properties prop = new Properties();
        try {
            String propFileName = "src/main/resources/config.properties";
            file = new FileInputStream(new File(propFileName).getAbsolutePath());

            prop.load(file);
            out = prop.getProperty(property);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out;

    }
}
