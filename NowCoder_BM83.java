/**
 * @author yun
 * @date 2024/12/21 20:52
 * @desciption: 字符串变形
 */
public class NowCoder_BM83 {
    public String trans(String _s, int n) {
        char[] s = _s.toCharArray();

        reverse(s);

        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (i < s.length) {
            if (s[i] == ' ') {
                ret.append(s[i]);
                i++;
            } else {
                StringBuilder temp = new StringBuilder();
                while (i < s.length && Character.isLetter(s[i])) {
                    if (Character.isUpperCase(s[i])) {
                        temp.insert(0, (char) (s[i] + 32));
                    } else {
                        temp.insert(0, (char) (s[i] - 32));

                    }
                    i++;
                }
                ret.append(temp.toString());

            }
        }
        return ret.toString();
    }

    public char[] reverse(char[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return arr;

    }


}
