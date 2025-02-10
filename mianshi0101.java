/**
 * @author yun
 * @date 2025/2/10 15:36
 * @desciption: 面试题 01.01. 判定字符是否唯一
 */
public class mianshi0101 {
    public boolean isUnique(String astr) {
        Set<Character> set=new HashSet<>();
        for(char ch:astr.toCharArray()) {
            set.add(ch);
        }
        if(set.size()==astr.length()) {

            return true;
        }
        return false;
    }
}
