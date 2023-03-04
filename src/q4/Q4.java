package q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Q4 {

    public static void main(String[] args) throws IOException {
        // tests
        // [1, 2, 3] + [3, 5, 7]            ->          [1, 2, 3, 5, 7]
        // [10, 9, 8, 7] * [2, 4, 6, 8]     ->          [8]
        // [5, 10, 15, 20] - [0, 10, 20]    ->          [5, 15]
        // [1, 2] + [3, 4] * [2, 3] - [2]   ->          [3]
        SetCalculator calculator = new SetCalculator();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter set expression (quit to stop): ");
        String input = br.readLine();
        while (!input.equalsIgnoreCase("quit")) {
            try {
                System.out.printf("Result: %s\n\n", calculator.compute(input));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Input\n");
            }
            System.out.print("Enter set expression (quit to stop): ");
            input = br.readLine();
        }
        br.close();
    }
}

class SetCalculator {
    private static final String VALID_OPERATORS = "+*-";
    private static final String VALID_CHARS = VALID_OPERATORS + " []";
    private final LinkedList<Character> operators = new LinkedList<>();
    private final LinkedList<Set<Integer>> sets = new LinkedList<>();   // operands

    // extracts sets and operators from input string
    public boolean processInput(String input) {
        if (input == null) return false;
        sets.clear();
        operators.clear();
        ArrayList<Integer> numbers = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // if character is a digit, or a '-' followed by a digit (for negative numbers)
            if ( Character.isDigit(c) || (c == '-' && Character.isDigit(input.charAt(i + 1))) ) {
                number.append(c);
            }

            // if end of number
            else if (c == ',') {
                try {
                    numbers.add(Integer.parseInt(number.toString()));
                } catch (NumberFormatException e) {
                    return false;
                }
                number = new StringBuilder();
            }

            // if character is a valid operator
            else if (VALID_OPERATORS.contains(c + "")) {
                operators.add(c);
            }

            // if end of set
            else if (c == ']') {
                try {
                    numbers.add(Integer.parseInt(number.toString()));
                } catch (NumberFormatException e) {
                    return false;
                }
                sets.add(new TreeSet<>(numbers));
                number = new StringBuilder();
                numbers.clear();
            }

            // if character is not valid
            else if (!VALID_CHARS.contains(c + "")) {
                return false;
            }
        }
        return true;
    }

    // returns the result of the set operation
    public Set<Integer> compute(String input) {
        if (processInput(input)) {
            // the number of operators must be one less than the number of operands
            if (sets.size() - operators.size() != 1) {
                throw new IllegalArgumentException("Invalid Input");
            }
            Set<Integer> result = sets.poll();
            for (Set<Integer> set: sets) {
                if (operators.peek() != null) {
                    switch (operators.poll()) {
                        case '+':
                            result.addAll(set);
                            break;
                        case '*':
                            result.retainAll(set);
                            break;
                        case '-':
                            result.removeAll(set);
                            break;
                    }
                }
            }
            return result;
        }
        throw new IllegalArgumentException("Invalid Input");
    }
}
