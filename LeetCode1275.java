public class LeetCode1275 {

    //A 和 B 在一个 3 x 3 的网格上玩井字棋。
    //
    //井字棋游戏的规则如下：
    //
    //玩家轮流将棋子放在空方格 (" ") 上。
    //第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
    //"X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
    //只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
    //如果所有方块都放满棋子（不为空），游戏也会结束。
    //游戏结束后，棋子无法再进行任何移动。
    //给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。
    //
    //如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
    //
    //你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。
    public String tictactoe(int[][] moves) {
        String[][] board = new String[3][3];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                board[moves[i][0]][moves[i][1]] = "A";
            } else {
                board[moves[i][0]][moves[i][1]] = "B";
            }


        }

        if (board[0][0] != null && board[1][1] == board[0][0] & board[0][0] == board[2][2]) {
            return board[0][0];
        }

        if (board[1][1] != null && board[2][0] == board[1][1] & board[1][1] == board[0][2]) {
            return board[1][1];
        }
        for (int j = 0; j < 3; j++) {
            if (board[j][1] != null && board[j][0] == board[j][1] && board[j][1] == board[j][2]) {
                return board[j][0];
            } else if (board[1][j] != null && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return board[0][j];
            }
        }
        if (moves.length == 9) {
            return "Draw";
        }

        return "Pending";


    }
}
