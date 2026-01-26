import java.util.ArrayList;

class StockSpan{
    static ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> span = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            span.add(1);
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 
                  && arr[i] >= arr[j]; j--) {
                span.set(i, span.get(i) + 1);
            }
        }
        return span;
    }
    public static void main(String[] args) {
        int[] arr = {10, 4, 5, 90, 120, 80};
        ArrayList<Integer> span = calculateSpan(arr);
        for (int x : span) {
            System.out.print(x + " ");
        }
    }
}