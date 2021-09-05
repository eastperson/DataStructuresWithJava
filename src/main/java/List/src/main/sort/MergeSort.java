package List.src.main.sort;

public class MergeSort {
    private static void merge(Comparable[] a, Comparable[] b, int low, int mid, int high) {
        int i = low, j = mid + 1;
        for(int k = low; k <= high; k++) {
            if (i > mid) b[k] = a[j++]; // 앞부분이 먼저 소진된 경우
            else if (i > high) b[k] = a[i++]; // 뒷부분이 먼저 소진된 경우
            else if (j > high) b[k] = a[j++]; // a[j]가 승자
            else b[k] = a[i++]; // a[i] 승자
        }
        for(int k = low; k <= high; k++) a[k] = b[k];
    }
    private static void sort(Comparable[] a, Comparable[] b, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low)/2;
        sort(a,b,low,mid);
        sort(a,b,mid+1,high);
        merge(a,b,low,mid,high);
    }
    public static void sort(Comparable[] a) {
        Comparable[] b = new Comparable[a.length];
        sort(a,b,0,a.length-1);
    }

    private static boolean isless(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
