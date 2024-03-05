import java.util.*;
//给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
//
//返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
public class LeetCode692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word :
                words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().compareTo(o2.getValue())==0) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry :
                map.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(entry);
            } else {
                Map.Entry<String, Integer> top = priorityQueue.peek();
                if(top.getValue().compareTo(entry.getValue())<0) {
                    priorityQueue.poll();
                    priorityQueue.offer(entry);
                } else {
                    if(top.getValue().compareTo(entry.getValue())==0) {
                        if(top.getKey().compareTo(entry.getKey())>0) {
                            priorityQueue.poll();
                            priorityQueue.offer(entry);
                        }

                    }

                }
            }

        }

        List<String> retList=new ArrayList<>();

        for (int i = 0; i < k; i++) {
            retList.add(priorityQueue.poll().getKey());
        }

        Collections.reverse(retList);
        return retList;
    }
}
