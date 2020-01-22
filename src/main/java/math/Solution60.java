package math;

import java.util.ArrayList;
import java.util.List;

class Solution60 {
    public static void main(String[] args) {
        List<String> list = new Solution60().fizzBuzz(3);
        System.out.println(list);
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}