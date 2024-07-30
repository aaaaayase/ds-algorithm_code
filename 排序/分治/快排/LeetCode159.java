import java.util.Random;

public class LeetCode159 {
    public int[] inventoryManagement(int[] stock, int cnt) {
        quickSort(stock, 0, stock.length - 1, cnt);
        int[] ret = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            ret[i] = stock[i];
        }

        return ret;
    }

    public void quickSort(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }

        int i = l;
        int left = l - 1;
        int right = r + 1;
        int key = arr[new Random().nextInt(r - l + 1) + l];
        while (i < right) {
            if (arr[i] < key) {
                swap(arr, ++left, i++);
            } else if (arr[i] == key) {
                i++;
            } else {
                swap(arr, --right, i);
            }
        }

        int a = left - l + 1;
        int b = right - left - 1;

        if (a >= k) {
            quickSort(arr, l, left, k);
        } else if (a + b >= k) {
            return;
        } else {
            quickSort(arr, right, r, k - a - b);
        }
    }

    public void swap(int[] arr, int n1, int n2) {
        int t = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = t;
    }
}
