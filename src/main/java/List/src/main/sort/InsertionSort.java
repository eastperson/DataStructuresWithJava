package List.src.main.sort;

public class InsertionSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for(int i = 1; i< N; i++) {
            for(int j = i; j > 0; j--) {
                if(isless(a[j],a[j-1])) swap(a,j,j-1);
                else break;
            }
        }
    }
    private static boolean isless(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
