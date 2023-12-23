package com.java.reflexion;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Class for performing dependency injection into objects.
 */
public class Injector {

    private final Properties properties;

    /**
     * Creates an instance of the Injector class with the specified path to the properties file.
     *
     * @param pathToFile the path to the properties file
     */
    public Injector(String pathToFile) {
        properties = new Properties();
        try {
            properties.load(new FileReader(pathToFile));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Injects dependencies into the specified object.
     *
     * @param obj the object into which the injections will be performed
     * @return the object with the injections performed
     */
    public Object inject(Object obj) {
        try {
            String string, prop;
            Class<?> object_class = obj.getClass();
            for (Field field : object_class.getDeclaredFields()) {
                if (field.getAnnotation(AutoInjectable.class) != null) {
                    string = field.toString();
                    prop = string.split(" ")[1];
                    Class<?> property = Class.forName(properties.getProperty(prop));
                    Object instance = property.getDeclaredConstructor().newInstance();
                    field.setAccessible(true);
                    field.set(obj, instance);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
