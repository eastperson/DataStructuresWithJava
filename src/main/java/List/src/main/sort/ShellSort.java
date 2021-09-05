package List.src.main.sort;

public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 4; // 3x+1 간격 : 1, 4, 13, 40, 121 중에서 4와 1만 사용
        while(h >= 1) {
            for(int i = h; i < N; i++) {
                for(int j = i; j >= h && isless(a[j],a[j-h]); j -= h){
                    swap(a,j,j-h);
                }
            }
            h /= 3;
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
