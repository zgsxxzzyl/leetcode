package math;

class Solution61 {
    public static void main(String[] args) {
        int i = new Solution61().countPrimes(5);
        System.out.println(i);
    }

    public int countPrimes(int n) {
        int i = 0;
        for (int j = 1; j <= n; j++) {
            if (ifPrime(j)) {
                i++;
            }
        }
        return i;
    }

    private boolean ifPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}