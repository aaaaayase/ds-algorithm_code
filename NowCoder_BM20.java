/**
 * @author yun
 * @date 2024/12/9 11:30
 * @desciption: 数组中的逆序对
 */
public class NowCoder_BM20 {
    private int count;

    public void mergeSort(int[] arr) {
        mergeFunc(arr, 0, arr.length - 1);
    }

    public void mergeFunc(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeFunc(arr, start, mid);
        mergeFunc(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public void merge(int[] arr, int start, int mid, int end) {
        int s1 = start;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = end;
        int k = 0;
        int[] temp = new int[end - start + 1];
        while (s1 <= e1 && s2 <= e2) {
            if (arr[s1] <= arr[s2]) {
                temp[k++] = arr[s1++];
            } else {
                temp[k++] = arr[s2++];
                count = (count + (mid - s1 + 1)) % 1000000007;
            }
        }

        while (s1 <= e1) {
            temp[k++] = arr[s1++];
        }
        while (s2 <= e2) {
            temp[k++] = arr[s2++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[i + start] = temp[i];
        }
    }

    public int InversePairs(int[] nums) {
        // write code here
        mergeSort(nums);
        return count;
    }
}
