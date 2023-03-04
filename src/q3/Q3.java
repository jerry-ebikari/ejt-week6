package q3;

import java.util.TreeMap;

public class Q3 {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        // add entries to phone directory
        phoneDirectory.putNumber("jerry", "09045423281");
        phoneDirectory.putNumber("john", "09084934703");
        phoneDirectory.putNumber("george", "08103839834");
        System.out.println(phoneDirectory);
        // get a number from phone directory
        System.out.printf("Jerry's phone number: %s\n", phoneDirectory.getNumber("jerry"));
    }
}

class PhoneDirectory {
    private final TreeMap<String, String> data;

    // creates a new phone directory with case-insensitive ordering and keys
    public PhoneDirectory() {
        data = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    // adds to or modifies entries in phone directory
    public void putNumber(String name, String number) {
        if (name == null || number == null) {
            throw new IllegalArgumentException("name and number should both have non-null values");
        }
        data.put(titleCase(name), number);
    }

    // returns the number affiliated with the provided name from the phone directory
    // returns null if name is not in the directory
    public String getNumber(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name should not be null");
        }
        return data.get(name);
    }

    // converts name to title case
    private String titleCase(String name) {
        if (name == null) return null;
        final String DELIMITERS = " '-"; // characters following these should be capitalized
        name = name.trim().replaceAll("\\s+", " ");
        boolean capitalizeNext = true;
        StringBuilder sb = new StringBuilder();
        for (char c: name.toCharArray()) {
            c = capitalizeNext ? Character.toUpperCase(c) : Character.toLowerCase(c);
            sb.append(c);
            capitalizeNext = DELIMITERS.contains(c + "");
        }
        return new String(sb);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
