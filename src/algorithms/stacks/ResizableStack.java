package algorithms.stacks;

public class ResizableStack {

    private String[] items;
    private int N = 0;

    public ResizableStack(int capacity) {
        items = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String str) {
        if (N >= items.length) {
            resize(2 * items.length);
        }
        items[N++] = str;
    }

    private void resize(int max) {
        String[] temp = new String[max];
        for (int i = 0; i < items.length; ++i) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public String pop() {
        String toReturn = items[--N];
        items[N] = null;
        if (N > 0 && N == items.length / 4) {
            resize(items.length / 2);
        }
        return toReturn;
    }


}
