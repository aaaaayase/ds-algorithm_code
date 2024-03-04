import java.util.Stack;

//给你一个整数数组 nums，请你将该数组升序排列。
public class LeetCode912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums);
        return nums;
    }

    public void mergeSort(int[] arr) {
        merge(arr, 0, arr.length - 1);
    }

    public void merge(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + ((end - start) >>> 1);
        merge(arr, start, mid);
        merge(arr, mid + 1, end);
        mergeFunc(arr, start, end, mid);
    }

    public void mergeFunc(int[] arr, int left, int right, int mid) {
        int s1 = left;
        int s2 = mid + 1;
        int e1 = mid;
        int e2 = right;

        int[] temp = new int[right - left + 1];
        int index = 0;
        while (s1 <= e1 && s2 <= e2) {
            if (arr[s1] < arr[s2]) {
                temp[index++] = arr[s1++];
            } else {
                temp[index++] = arr[s2++];
            }
        }

        while (s1 <= e1) {
            temp[index++] = arr[s1++];
        }
        while (s2 <= e2) {
            temp[index++] = arr[s2++];
        }

        for (int i = 0; i < index; i++) {
            arr[i + left] = temp[i];
        }
    }

    public void mergeSortNor(int[] arr) {
        int gap = 1;
        while (gap < arr.length) {
            for (int i = 0; i < arr.length; i += gap * 2) {
                int left = i;
                int mid = left + gap - 1;
                if (mid >= arr.length) {
                    mid = arr.length - 1;
                }
                int right = mid + gap;
                if (right >= arr.length) {
                    right = arr.length - 1;
                }

                mergeFunc(arr, left, right, mid);
            }
            gap *= 2;
        }

    }

    public void quickSort(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    public void quick(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        if(end-start+1<=10) {
            insertSort(arr,start,end);
            return ;
        }
        int index=getMidNum(arr,start,end);
        swap(arr,index,start);
        int pivot = partition(arr, start, end);
        quick(arr, start, pivot - 1);
        quick(arr, pivot + 1, end);
    }

    public void quickSortNor(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int pivot = partition(arr, 0, arr.length - 1);
        if (pivot - 1 > 0) {
            stack.push(0);
            stack.push(pivot - 1);

        }
        if (pivot + 1 < arr.length - 1) {
            stack.push(pivot + 1);
            stack.push(arr.length - 1);
        }
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            pivot = partition(arr, left, right);
            if (pivot - 1 > left) {
                stack.push(left);
                stack.push(pivot - 1);

            }
            if (pivot + 1 < arr.length - 1) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }

    }

    public void insertSort(int[] arr,int start,int end) {
        for(int i=start+1;i<=end;i++) {
            int temp=arr[i];
            int j=i-1;
            for(;j>=start;j--) {
                if(arr[j]>temp) {
                    arr[j+1]=arr[j];
                } else {
                    break;
                }
            }
            arr[j+1]=temp;
        }
    }

    public int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (right > left && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left];

        }
        arr[left] = temp;
        return left;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int getMidNum(int[] arr,int left,int right) {
        int mid=left+((right-left)>>>2);
        if(arr[left]>arr[right]) {
            if(arr[mid]<arr[right]) {
                return right;
            } else if(arr[mid]>arr[left]) {
                return left;
            } else {
                return mid;
            }

        } else {
            if(arr[mid]>arr[right]) {
                return right;
            } else if(arr[mid]<arr[left]) {
                return left;
            } else {
                return mid;
            }
        }
    }
}
