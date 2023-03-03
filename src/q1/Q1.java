package q1;

import java.util.List;
import java.util.Stack;

public class Q1 {

    // sorts the entries in a stack
    static <T extends Comparable<T>> Stack<T> sort(Stack<T> inputStack) {
        Stack<T> tempStack = new Stack<>();
        while (!inputStack.isEmpty()) {
            T temp = inputStack.pop();
            while (!tempStack.isEmpty() && tempStack.peek().compareTo(temp) > 0) {
                inputStack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        return tempStack;
    }

    public static void main(String[] args) {
        Stack<String> fruits = new Stack<>();
        fruits.addAll(List.of("grape", "banana", "apple", "strawberry"));
        System.out.println(sort(fruits));
    }
}
