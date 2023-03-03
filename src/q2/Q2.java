package q2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Q2 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7, 8, 9, 10));
        // remove numbers less than 3
        Predicates.remove(numbers, num -> num < 3);
        System.out.printf("Numbers greater than 3: %s\n", numbers);

        // retain even numbers
        Predicates.retain(numbers, num -> num % 2 == 0);
        System.out.printf("Even numbers greater than 3: %s\n", numbers);

        // get list of numbers greater than 5 in the collection
        System.out.printf("List of numbers greater than 5: %s\n", Predicates.collect(numbers, num -> num > 5));

        // get the index of a number that satisfies the predicate test
        System.out.printf("Index of first number greater than 3: %s\n", Predicates.find(numbers, num -> num > 3));
    }
}

class Predicates {
    // removes every object for which the predicate is true
    public static <T> void remove(Collection<T> coll, Predicate<T> pred) {
        coll.removeIf(pred);
    }

    // retains only objects for which the predicate is true
    public static <T> void retain(Collection<T> coll, Predicate<T> pred) {
        coll.removeIf(x -> !pred.test(x));
    }

    // returns a list of all objects for which the predicate is true
    public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred) {
        return coll.stream().filter(pred).collect(Collectors.toList());
    }

    // returns the index of the first object for which the predicate is true
    // returns -1 if predicate is false for all objects
    public static <T> int find(ArrayList<T> list, Predicate<T> pred) {
        for (int i = 0; i < list.size(); i++) {
            if ( pred.test(list.get(i)) ) return i;
        }
        return -1;
    }
}
