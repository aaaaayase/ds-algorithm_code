/**
 * @author yun
 * @date 2025/2/6 12:59
 * @desciption: 面试题 01.02. 判定是否互为字符重排
 */
public class mianshi0102 {
    public boolean CheckPermutation(String _s1, String _s2) {
        char[] s1=_s1.toCharArray();
        char[] s2=_s2.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(s2);

        return Arrays.equals(s1,s2);
    }
}
