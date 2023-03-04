package q4;

import java.util.HashSet;
import java.util.Set;

public class Q4 {
    // returns the sets as a string array
    private static String[] getSets(String input) {
        String[] sets = input.split("].*\\[");
        for (int i = 0; i < sets.length; i++) {
            // remove characters that are not numbers, comma.
            // also remove - that are not immediately followed by numbers.
            sets[i] = sets[i].replaceAll("[^\\d,-]|-(?!\\d)", "");
        }
        return sets;
    }

    // returns the set operator
    private static String getOperator(String input) {
        return input.replaceAll("[,\\d\\s\\[\\]]|-(?=\\d)", "");
    }

    // creates a set object from the input set string
    private static Set<Integer> createSet(String setString) {
        Set<Integer> set = new HashSet<>();
        String[] numbers = setString.split(",");
        for (String number: numbers) {
            set.add(Integer.parseInt(number));
        }
        return set;
    }

    // returns the result of the set operation
    private static Set<Integer> performOperation(Set<Integer> set1, Set<Integer> set2, String operator) {
        switch (operator) {
            case "+":
                set1.addAll(set2);
                break;
            case "*":
                set1.retainAll(set2);
                break;
            case "-":
                set1.removeAll(set2);
                break;
        }
        return set1;
    }

    // computes and returns the result of "set1 (op) set2"
    public static Set<Integer> compute(String input) {
        String[] setStrings = getSets(input);
        Set<Integer> set1 = createSet(setStrings[0]);
        Set<Integer> set2 = createSet(setStrings[1]);
        String operator = getOperator(input);
        return performOperation(set1, set2, operator);
    }

    public static void main(String[] args) {
        String input = "[1, 2, 3] + [3, 5, 7]";
        String input2 = "[10,9,8,7] * [2,4,6,8]";
        String input3 = "[5, 10, 15, 20] - [0, 10, 20]";
        System.out.println(compute(input));
        System.out.println(compute(input2));
        System.out.println(compute(input3));
    }
}
