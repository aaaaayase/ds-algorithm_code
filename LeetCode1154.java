public class LeetCode1154 {
    //给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。返回该日期是当年的第几天。
    public int dayOfYear(String date) {
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7));
        int day = Integer.valueOf(date.substring(8));
        // 1、3、5、7、8、10、12 每月31天，4、6、9、11为30天
        int[] month1 = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] month2 = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int sum = 0;
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            for (int i = 0; i < month - 1; i++) {
                sum += month2[i];
            }
        } else {
            for (int i = 0; i < month - 1; i++) {
                sum += month1[i];
            }
        }
        return sum + day;
    }


}
