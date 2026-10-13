public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; ++i)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] >= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] a = {15, 42, 8, 23, 56, 4, 79, 31};

        System.out.println("=== MERGE SORT (Descending) ===");
        System.out.print("Sebelum diurutkan: ");
        cetakArray(a);

        mergeSort(a, 0, a.length - 1);

        System.out.print("Setelah diurutkan:  ");
        cetakArray(a);
    }

    public static void cetakArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("a" + (i + 1) + "=" + arr[i] + " ");
        }
        System.out.println();
    }
}