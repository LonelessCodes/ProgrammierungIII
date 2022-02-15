package Aufgabe08;

public class Stack {
    private int[] stack;
    private int lastIndex = 0;

    public Stack(int size) throws IllegalArgumentException {
        if (size <= 0) {
            throw new IllegalArgumentException("size darf weniger-gleich Null sein.");
        }

        this.stack = new int[size];
    }

    public boolean isFull() {
        return lastIndex == stack.length;
    }
    public boolean isEmpty() {
        return lastIndex == 0;
    }

    public boolean pushItem(int item) {
        if (isFull()) return false;

        stack[lastIndex++] = item;

        return true;
    }

    public int popItem() {
        if (isEmpty()) return 0;

        return stack[--lastIndex];
    }

    public static void main(String[] args) {
        Stack s = new Stack(2);

        System.out.println(s.pushItem(1));
        System.out.println(s.pushItem(2));
        System.out.println(s.pushItem(3));
        System.out.println(s.popItem());
        System.out.println(s.pushItem(4));
        System.out.println(s.popItem());
        System.out.println(s.popItem());
        System.out.println(s.popItem());
    }
}
