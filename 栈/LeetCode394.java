public class LeetCode394 {

    public String decodeString(String ss) {
        char[] s = ss.toCharArray();
        int n = s.length;
        Stack<StringBuilder> strs = new Stack<>();
        strs.push(new StringBuilder());
        Stack<Integer> nums = new Stack<>();
        int i = 0;

        while (i < n) {
            char ch = s[i];
            if (ch >= '0' && ch <= '9') {
                int temp = 0;
                while (i < n && s[i] >= '0' && s[i] <= '9') {
                    temp = temp * 10 + (s[i] - '0');
                    i++;
                }
                nums.add(temp);
            } else if (ch == ']') {
                String str = strs.pop().toString();
                int num = nums.pop();
                while (num-- != 0) {
                    strs.peek().append(str);
                }
                i++;
            } else if (ch == '[') {
                i++;
                StringBuilder temp = new StringBuilder();
                while (i < n && s[i] >= 'a' && s[i] <= 'z') {
                    temp.append(s[i]);
                    i++;
                }
                strs.push(temp);
            } else {
                StringBuilder temp = new StringBuilder();
                while (i < n && s[i] >= 'a' && s[i] <= 'z') {
                    temp.append(s[i]);
                    i++;
                }
                strs.peek().append(temp.toString());

            }
        }

        return strs.peek().toString();
    }
}