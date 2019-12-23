package utilities;

import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

public class LoadProperties {

    private static String key;
    private static String value;
    private static String fileName;

    public static String getValueFromPropertyFile(String test_data, String search) {
        String value = "";
        try {
            String path = System.getProperty("user.dir") + "\\src\\test\\resources\\propertiesFiles\\" + fileName + ".properties";
            FileInputStream fin = new FileInputStream(path);
            Properties properties = new Properties();
            properties.load(fin);
            value = properties.getProperty(key);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return value;
    }

    public static void storeValueInPropetyFile(String key, String value,String fileName) throws org.apache.commons.configuration.ConfigurationException {
        LoadProperties.key = key;
        LoadProperties.value = value;
        LoadProperties.fileName = fileName;
        String saveQueryfile = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "propertiesFiles" + File.separator + fileName+".properties";
        PropertiesConfiguration properties = new PropertiesConfiguration(saveQueryfile);
        properties.setProperty(key, value);
        properties.save();
    }
    public static void setRuntimeDataInPropertyFile(String fileName, Map<String, String> map) {
        try {
            String path = new File(".").getCanonicalPath()+ File.separator+"src"+File.separator+"test\\resources\\propertiesFiles\\" + fileName + ".properties";
            FileOutputStream fout = new FileOutputStream(path);
            Properties properties = new Properties();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                properties.setProperty(entry.getKey(), entry.getValue());
            }
            properties.store(fout, "Adding runtime date in file");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


}
