public class LeetCode38 {
    public String countAndSay(int n) {
        String ret = "1";
        int i = 1;
        while (i < n) {
            int temp = ret.length();
            char[] tempArr = ret.toCharArray();
            int left = 0, right = 0;
            StringBuilder sb = new StringBuilder();
            while (right < temp) {
                while (right < temp && tempArr[left] == tempArr[right]) {
                    right++;
                }
                sb.append(right - left);
                sb.append(tempArr[left]);
                left = right;

            }
            // 每次更新开始的字符串
            ret = sb.toString();
            i++;
        }
        return ret;
    }
}
