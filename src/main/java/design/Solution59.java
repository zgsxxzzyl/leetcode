package design;

public class Solution59 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();      // 返回 -3.
        System.out.println(min);
        minStack.pop();
        int top = minStack.top();         // 返回 0.
        System.out.println(top);
        min = minStack.getMin();      // 返回 -2.
        System.out.println(min);
    }
}
