package ir.pegahtech.saas.client.shared.builder;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: moh
 * Date: 9/20/14
 * Time: 9:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringUtility {
    public static boolean isNullOrWhitespace(String input){
        return input == null || input.trim().equals("");
    }

    public static String getNullOrString(String input) {
        return isNullOrWhitespace(input) ? null : input;
    }

    public static String camelCaseToUnderline(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z' && i > 0)
                result.append('_');
            result.append((input.charAt(i) + "").toUpperCase());
        }
        return result.toString();
    }
    public static String upperToLowerCamelCase(String input) {
        if (input.charAt(0) >= 'A' && input.charAt(0) <= 'Z')
            return (char) (input.charAt(0) - 'A' + 'a') + input.substring(1);
        return input;
    }

    public static String lowerToUpperCamelCase(String input) {
        if (input.charAt(0) >= 'a' && input.charAt(0) <= 'z')
            return (char) (input.charAt(0) - 'a' + 'A') + input.substring(1);
        return input;
    }

    public static String getShortString(String input, int maxLength) {
        if (isNullOrWhitespace(input))
            return null;
        if (input.length() <= maxLength)
            return input;
        return input.substring(0, maxLength - 3) + "...";
    }

    public static byte[] toByteArray(String input) {
        if (input == null)
            return null;

        try {
            return input.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(byte[] bytes) {
        if (bytes == null)
            return null;
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isAlphanumberic(char ch) {
        if (ch >= 'A' && ch <= 'Z') return true;
        if (ch >= 'a' && ch <= 'z') return true;
        if (ch >= '0' && ch <= '9') return true;
        return false;
    }

    public static String toPureAlphabet(String input, char[] extraValidChars) {
        if (input == null)
            return null;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (isAlphanumberic(input.charAt(i)))
                builder.append(input.charAt(i));
            else {
                for(int j = 0; j < extraValidChars.length; j++)
                    if (input.charAt(i) == extraValidChars[j])
                        builder.append(input.charAt(i));
            }
        }
        return builder.toString();
    }

    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++)
            builder.append((char) ('a' + (char) random.nextInt(20)));
        return builder.toString();
    }

    public static String join(String[] objects, String separator) {
        List<String> list = new ArrayList<String>();
        for (String o: objects)
            list.add(o);
        return join(list, separator);
    }

    public static String join(List<String> objects, String separator) {
        if (objects == null)
            return null;
        StringBuilder builder = new StringBuilder();
        int length = objects.size();

        for (int i = 0; i < length; i++) {
            builder.append(objects.get(i) == null ? "" : objects.get(i).toString());
            if (i != length - 1)
                builder.append(separator);
        }

        return builder.toString();
    }

    public static String[] splitDot(String input){
        if(!input.contains(".")){
            String[] splittedString = new String[1];
            splittedString[0] = input;
            return splittedString;
        }
        return input.split(".");
    }

    public static List<String> convertToStringList(List<UUID> uuidList){
        List<String> uuidStrings = new ArrayList<String>();
        for(UUID uuid: uuidList)
            uuidStrings.add("'" + uuid.toString().replace("-", "").toUpperCase());
        return uuidStrings;
    }

    public static String toUUIDFormat(String uuidDbString){
        if(uuidDbString.length() != 32)
            throw new IllegalArgumentException();
        String digits = uuidDbString.toLowerCase();
        String uuid = digits.replaceAll(
                "(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})",
                "$1-$2-$3-$4-$5");
        System.out.println(uuidDbString + " =>> " + uuid);
        return uuid;
    }
}
