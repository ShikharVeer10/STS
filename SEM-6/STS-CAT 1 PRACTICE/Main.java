import java.util.*;
class CelebrityProblem {
    static int celebrity(int[][] m) {
        int n = m.length;
        for (int i = 0; i < n; i++) {
            int in = 0, out = 0;
            for (int j = 0; j < n; j++) {
                out += m[i][j];
                in += m[j][i];
            }
            if (in == n - 1 && out == 0) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                m[i][j] = sc.nextInt();
        System.out.print(celebrity(m));
    }
}
