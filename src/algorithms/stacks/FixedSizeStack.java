package algorithms.stacks;

public class FixedSizeStack {

    private String[] items;
    private int N = 0;

    public FixedSizeStack(int capacity) {
        items = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String str) {
        items[N++] = str;
    }

    public String pop() {
        String toReturn = items[--N];
        items[N] = null;
        return toReturn;
    }


}
