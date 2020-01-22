package design;

public class MinStack {

    private int maxLength = 2000;
    private int[] a = new int[maxLength];
    private int[] min = new int[maxLength];
    private int length = 0;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (length >= maxLength) {
            maxLength = length * 2;

            int[] b = new int[maxLength];
            for (int i = 0; i < a.length; i++) {
                b[i] = a[i];
            }
            a = b;

            int[] c = new int[maxLength];
            for (int i = 0; i < min.length; i++) {
                c[i] = min[i];
            }
            min = c;
        }
        if (length == 0) {
            min[length] = x;
        } else {
            min[length] = Math.min(x, min[length - 1]);
        }
        a[length++] = x;
    }

    public void pop() {
        length--;
    }

    public int top() {
        return a[length - 1];
    }

    public int getMin() {
        return min[length - 1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */