package design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution58Ext {
    private int[] orign;
    private Random random = new Random();

    public Solution58Ext(int[] nums) {
        this.orign = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return orign;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        List<Integer> list = getArrayList();
        int[] array = new int[orign.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            index = random.nextInt(list.size());
            array[i] = list.get(index);
            list.remove(index);
        }
        return array;
    }

    private List getArrayList() {
        List<Integer> arrays = new ArrayList<>();
        for (int i = 0; i < orign.length; i++) {
            arrays.add(orign[i]);
        }
        return arrays;
    }
}
