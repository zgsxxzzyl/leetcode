package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MinStackExt {
    private List<Integer> integers;

    /**
     * initialize your data structure here.
     */
    public MinStackExt() {
        this.integers = new ArrayList<>();
    }

    public void push(int x) {
        integers.add(x);
    }

    public void pop() {
        int index = integers.size() - 1;
        integers.remove(index);
    }

    public int top() {
        int index = integers.size() - 1;
        return integers.get(index);
    }

    public int getMin() {
        return Collections.min(integers);
    }
}