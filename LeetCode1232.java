public class LeetCode1232 {
    //给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ， [x, y] 表示横坐标为 x、纵坐标为 y 的点。
    //请你来判断，这些点是否在该坐标系中属于同一条直线上。
    public boolean checkStraightLine(int[][] coordinates) {
        for(int i=0;i<coordinates.length-2;i++) {
            if(!checkThreePoints(coordinates[i][0],coordinates[i+1][0],coordinates[i+2][0],coordinates[i][1],coordinates[i+1][1],coordinates[i+2][1])) {
                return false;
            }
        }
        return true;


    }

    public boolean checkThreePoints(double x1,double x2,double x3,double y1,double y2,double y3) {
        if((x1-x2==0)&&(x2-x3==0)) {
            return true;
        } else if((x2-x1==0 || x3-x2==0)) {
            return false;
        } else {
            return (y2-y1)/(x2-x1)==(y3-y2)/(x3-x2);
        }


    }
}
