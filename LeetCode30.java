class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        Map<String, Integer> total = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            total.put(words[i], total.getOrDefault(words[i], 0)+1);
        }

        int m = words.length;
        int w = words[0].length();
        // 0 w 2w ......
        // 1 w+1 2w+1 ......
        // ......
        // w-1 2w-1 3w-1 ......
        int n = s.length();
        for (int i = 0; i < w; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            int count = 0;
            for (int left = i, right = i; right+w <= n; right += w) {
                String in = s.substring(right, right + w);
                tmp.put(in, tmp.getOrDefault(in, 0) + 1);
                if (tmp.get(in) <= total.getOrDefault(in,0)) {
                    count++;
                }
                while ((right - left + w) / w > m) {
                    String out = s.substring(left, left + w);
                    tmp.put(out,tmp.get(out) - 1);
                    if (tmp.get(out) < total.getOrDefault(out,0)) {
                        count--;
                    }
                    left+=w;
                }

                if (count == m) {
                    ret.add(left);
                }
            }
        }
        return ret;
    }
}