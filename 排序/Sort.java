import java.util.Stack;

public class Sort {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 时间复杂度：
     * 最好情况：数据有序的情况下：O(N)
     * 最坏情况：数据逆序的时候-》O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定的
     * 一个本身就不稳定的排序，是不可能变成一个稳定的排序的
     * 但是一个本身就稳定的排序，是可以实现为不稳定的排序的
     * 特点：数据越趋于有序，直接插入排序越快
     *
     * @param array
     */
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];
            for (; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;

        }


    }

    //不稳定的排序
    public void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            gap /= 2;
            shell(arr, gap);
        }

    }

    private void shell(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (arr[i] < arr[j]) {
                    arr[j + gap] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + gap] = arr[temp];
        }


    }

    /**
     * 选择排序：
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param array
     */
    public void selectSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    public void selectSort2(int[] arr) {
        int right = arr.length - 1;
        int left = 0;
        int minIndex = 0;
        int maxIndex = 0;
        while (left < right) {

            minIndex = left;
            maxIndex = left;
            for (int i = left + 1; i < right; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            if (left == maxIndex) {
                maxIndex = minIndex;
            }

            swap(arr, left, minIndex);
            swap(arr, right, maxIndex);


            left++;
            right--;

        }
    }

    /**
     * 堆排序:
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(1)
     * 稳定性：不稳定的排序
     *
     * @param array
     */
    public void heapSort(int[] arr) {
        createHeap(arr);
        int end = arr.length - 1;
        while (end > 0) {
            swap(arr, 0, end);
            siftDown(arr, 0, end);
            end--;
        }
    }

    public void createHeap(int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }
    }

    public void siftDown(int[] arr, int parent, int end) {
        int child = parent * 2 + 1;
        while (child < end) {
            if (child + 1 < end && arr[child] < arr[child + 1]) {
                child++;
            }
            if (arr[child] > arr[parent]) {
                swap(arr, child, parent);
                parent = child;
                child = parent * 2 + 1;
            } else {
                break;
            }

        }
    }

    /**
     * 不带优化的情况下：
     * 时间复杂度：
     * 最好和最坏 都是O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定的
     *
     * @param array
     */
    public void bubbleSort(int[] arr) {


        for (int i = 0; i < arr.length - 1; i++) {
            boolean flg = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] >= arr[j + 1]) {
                    flg = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
            if (flg == false) {
                return;
            }
        }
    }

    /**
     * 时间复杂度：
     * 最好情况下：O(N*logN)
     * 最坏情况下：O(N^2)  有序 / 逆序
     * 空间复杂度：
     * 最好情况下：O(logN)
     * 最坏情况下：O(N)
     * 稳定性：
     * 不稳定的排序
     *
     * @param array
     */
    public void quickSort(int[] arr) {

        quick(arr, 0, arr.length - 1);
    }

    public void quick(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        if (end - start + 1 <= 10) {
            insertSort1(arr, start, end);
            return;
        }
        int index = getMidNum(arr, start, end);
        swap(arr, index, start);
        int pivot = partitionHoare(arr, start, end);
        quick(arr, start, pivot - 1);
        quick(arr, pivot + 1, end);


    }

    public void insertSort1(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= start; j--) {
                if (temp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }

    }

    /**
     * Hoare
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public int partitionHoare(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }

            while (left < right && arr[left] <= temp) {
                left++;
            }
            swap(arr, right, left);
        }
        swap(arr, 0, left);
        return left;
    }

    //挖坑法
    public int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {
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

    public int getMidNum(int[] arr, int left, int right) {
        int mid = left + ((right - left) >> 2);
        if (arr[left] > arr[right]) {
            if (arr[mid] > arr[left]) {
                return left;
            } else if (arr[mid] < arr[right]) {
                return right;
            } else {
                return mid;
            }
        } else {
            if (arr[mid] > arr[right]) {
                return right;
            } else if (arr[mid] < arr[left]) {
                return left;
            } else {
                return mid;
            }
        }
    }

    //非递归实现快排
    public void quickSortNor(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = arr.length - 1;
        int pivot = partition(arr, left, right);

        //判断分割后是否一边有多余两个元素，如果只有一个元素则直接不处理
        if (pivot - 1 > left) {
            stack.push(left);
            stack.push(pivot - 1);
        }
        if (right > pivot + 1) {
            stack.push(pivot + 1);
            stack.push(right);
        }

        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            pivot = partition(arr, left, right);
            if (pivot - 1 > left) {
                stack.push(left);
                stack.push(pivot - 1);
            }

            if (right > pivot + 1) {
                stack.push(pivot + 1);
                stack.push(right);
            }


        }


    }
    //归并排序

    /**
     * 时间复杂度：O(n*logN)
     * <p>
     * 空间复杂度：O(N)
     * <p>
     * 稳定性：稳定
     * <p>
     * 稳定排序：插入  冒泡  归并
     *
     * @param array
     */
    public void mergeSort(int[] arr) {
        merge(arr, 0, arr.length - 1);
    }

    public void merge(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + ((end - start) >> 1);
        merge(arr, start, mid);
        merge(arr, mid + 1, end);

        mergeFunc(arr, start, end, mid);
    }

    public void mergeFunc(int[] arr, int left, int right, int mid) {

        int s1 = left;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = right;
        int[] temp = new int[right - left + 1];
        int k = 0;
        while (s1 <= e1 && s2 <= e2) {
            if (arr[s1] < arr[s2]) {
                temp[k++] = arr[s1++];
            } else {

                temp[k++] = arr[s2++];
            }
        }

        while (s1 <= e1) {
            temp[k++] = arr[s1++];
        }

        while (s2 <= e2) {
            temp[k++] = arr[s2++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[i + left] = temp[i];
        }
    }

    //非递归实现归并排序
    public void mergeSortNor(int[] arr) {
        int gap = 1;
        while (gap < arr.length) {
            for (int i = 0; i < arr.length; i += 2 * gap) {
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

    /**
     * 计数排序
     * 时间复杂度：O(范围+n)
     * O(max(范围,n))
     * 范围 = max - min -> 最好集中一点
     * 稳定的排序
     * @param array
     */
    public void countSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        //求极值
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }

            if (max < arr[i]) {
                max = arr[i];
            }
        }


        int[] count = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        //排序
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                arr[index++] = i + min;
                count[i] -= 1;
            }
        }


    }

}
