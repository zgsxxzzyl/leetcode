package array;

import java.util.ArrayList;
import java.util.List;

class Solution30 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!check(board, i, 0, i, 8) || !check(board, 0, i, 8, i)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!check(board, 0 + j, i, 2 + j, 2 + i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(char[][] board, int x, int y, int xx, int yy) {
        List<Character> temp = new ArrayList<>();
        char val;
        for (int i = x; i <= xx; i++) {
            for (int j = y; j <= yy; j++) {
                val = board[i][j];
                if (val != '.') {
                    if (temp.contains(val)) {
                        return false;
                    } else {
                        temp.add(val);
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] nums = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean validSudoku = new Solution30().isValidSudokuBest(nums);
        System.out.println(validSudoku);
    }


    public boolean isValidSudokuBest(char[][] board) {
        for (int i = 0; i < 9; i++) {
            // hori, veti, sqre分别表示行、列、小宫
            int hori = 0, veti = 0, sqre = 0;
            for (int j = 0; j < 9; j++) {
                // 由于传入为char，需要转换为int，减48
                int h = board[i][j] - 48;
                int v = board[j][i] - 48;
                int s = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] - 48;
                // "."的ASCII码为46，故小于0代表着当前符号位"."，不用讨论
                if (h > 0) {
                    hori = sodokuer(h, hori);
                }
                if (v > 0) {
                    veti = sodokuer(v, veti);
                }
                if (s > 0) {
                    sqre = sodokuer(s, sqre);
                }
                if (hori == -1 || veti == -1 || sqre == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    private int sodokuer(int n, int val) {
        return ((val >> n) & 1) == 1 ? -1 : val ^ (1 << n);
    }

}