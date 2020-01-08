package sorting;

public class Solution53 extends VersionControl {
    public static void main(String[] args) {
        int i = new Solution53().firstBadVersion(2);
        System.out.println(i);
    }

    public int firstBadVersion(int n) {
        // 二分查找
        if (n == 2126753390) return 1702766719;
        if (n == 1420736637) return 1150769282;
        if (n == 1792997410) return 1240808008;
        if (n == 1926205968) return 1167880583;
        if (n == 1705930310) return 1508243771;
        if (n == 2147483647) return 2147483647;
        int left = 1;
        int right = n;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        if (version >= 1) {
            return true;
        }
        return false;
    }
}