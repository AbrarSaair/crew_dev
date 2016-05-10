package test.com.lexin.dewcrew.utils;

/**
 * Created by Sair on 5/3/2016.
 */
public class CommonUtility {
    public static String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }
}
