package q5;

import java.util.*;

public class Q5 {

    // reverses a linked list
    public static <T> void reverse(LinkedList<T> linkedList) {
        Stack<T> stack = new Stack<>();
        while (!linkedList.isEmpty()) {
            stack.push(linkedList.pop());
        }
        while (!stack.isEmpty()) {
            linkedList.add(stack.pop());
        }
    }

    // reverses a linked hash map
    public static <K, V> void reverse(LinkedHashMap<K, V> map) {
        LinkedList<K> keys = new LinkedList<>();
        map.forEach((key, value) -> keys.add(key));
        reverse(keys);
        LinkedHashMap<K, V> result = new LinkedHashMap<>();
        keys.forEach(key -> result.put(key, map.get(key)));
        map.clear();
        map.putAll(result);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        System.out.printf("Linked list before reversal: %s\n", linkedList);
        reverse(linkedList);
        System.out.printf("Linked list after reversal: %s\n", linkedList);

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(){{
            put(1, 1);
            put(2, 1);
            put(3, 1);
            put(4, 1);
            put(5, 1);
        }};
        System.out.printf("Linked hash map before reversal: %s\n", map);
        reverse(map);
        System.out.printf("Linked hash map after reversal: %s\n", map);
    }
}

