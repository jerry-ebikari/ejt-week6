package q1;

import java.util.LinkedList;
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

        // test stack sort method
        Stack<Integer> numbers = new Stack<>();
        numbers.addAll(List.of(4, 13, 1, 5, 9));
        System.out.printf("Sorted Stack: %s\n", sort(numbers));

        // test custom stack
        CustomStack<String> customStack = new CustomStack<>();
        customStack.push("first");
        customStack.push("second");
        customStack.push("third");
        customStack.pop();
        System.out.println(customStack);

    }
}

// implements stack with 2 queues
class CustomStack<T> {
    // linked lists to act as queues
    private LinkedList<T> q1 = new LinkedList<>();
    private LinkedList<T> q2 = new LinkedList<>();

    // adds an element to the top of the stack
    public void push(T element) {
        q1.add(element);
    }

    // removes and returns the top of the stack
    public T pop() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        T result = q1.poll();
        LinkedList<T> temp = q2;
        q2 = q1;
        q1 = temp;
        return result;
    }

    // checks if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    @Override
    public String toString() {
        return q1.toString();
    }
}
