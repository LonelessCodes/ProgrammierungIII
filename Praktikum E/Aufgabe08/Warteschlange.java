package Aufgabe08;

public class Warteschlange {
    private int[] warteschlange;
    private int firstIndex = 0;
    private int lastIndex = 0;
    private boolean empty = true;

    public Warteschlange(int laenge) throws IllegalArgumentException {
        if (laenge <= 0) {
            throw new IllegalArgumentException("laenge darf weniger-gleich Null sein.");
        }

        this.warteschlange = new int[laenge];
    }

    private int loopAroundAndIncrease(int index) {
        index++;
        if (index == warteschlange.length) index = 0;
        return index;
    }

    public boolean isFull() {
        return !empty && firstIndex == lastIndex;
    }
    public boolean isEmpty() {
        return empty;
    }

    public boolean pushItem(int item) {
        if (isFull()) return false;

        warteschlange[lastIndex] = item;
        lastIndex = loopAroundAndIncrease(lastIndex);
        empty = false;

        return true;
    }

    public int popItem() {
        if (empty) return 0;

        int item = warteschlange[firstIndex];
        firstIndex = loopAroundAndIncrease(firstIndex);

        if (firstIndex == lastIndex) empty = true;

        return item;
    }

    public static void main(String[] args) {
        Warteschlange q = new Warteschlange(2);

        System.out.println(q.pushItem(1));
        System.out.println(q.pushItem(2));
        System.out.println(q.pushItem(3));
        System.out.println(q.popItem());
        System.out.println(q.pushItem(4));
        System.out.println(q.popItem());
        System.out.println(q.popItem());
        System.out.println(q.popItem());
    }
}
