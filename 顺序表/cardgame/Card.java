package cardgame;

public class Card {
    public int rank; //牌面值
    public String suit; //花色

    public Card(String suit, int rank) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return suit + " " + rank;
    }
}
