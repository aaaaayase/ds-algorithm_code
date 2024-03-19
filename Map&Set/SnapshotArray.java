import java.util.Map;
import java.util.TreeMap;

class SnapshotArray {
    public int snap_id = 0;
    public Map<Integer, TreeMap<Integer, Integer>> map;

    public SnapshotArray(int length) {
        map = new TreeMap<>();
        for (int i = 0; i < length; i++) {
            TreeMap<Integer, Integer> mapTemp = new TreeMap<>();
            mapTemp.put(0, 0);
            map.put(i, mapTemp);
        }
    }

    public void set(int index, int val) {
        map.get(index).put(snap_id, val);
    }

    public int snap() {

        return snap_id++;
    }

    public int get(int index, int snap_id) {
        return map.get(index).floorEntry(snap_id).getValue();

    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */