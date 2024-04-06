import org.w3c.dom.css.Counter;

import java.util.HashMap;
import java.util.Map;

public class LeetCode673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] count = new int[n]; //以i结尾的最长序列的个数
        int[] len = new int[n];//以i结尾的最长序列的长度

        for (int i = 0; i < n; i++) {
            len[i] = 1;
            count[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    } else if (len[i] == len[j] + 1) {
                        count[i] += count[j];
                    }
                }


            }

        }

        int max = len[0];
        int ret = count[0];
        for (int i = 1; i < n; i++) {
            if (len[i] > max) {
                max = len[i];
                ret = count[i];
            } else if (len[i] == max) {
                ret += count[i];
            }
        }

        return ret;
    }
}
