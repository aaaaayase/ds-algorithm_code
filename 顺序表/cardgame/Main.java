package cardgame;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        List<Card> ret = cardGame.buyCard();
        System.out.println("买牌");
        System.out.println(ret);

        System.out.println("洗牌");
        cardGame.shuffle(ret);
        System.out.println(ret);

        System.out.println("揭牌");
        List<List<Card>> gamers = cardGame.getCard(ret);
        for (int i = 0; i < gamers.size(); i++) {
            List<Card> hand=gamers.get(i);
            System.out.println("第"+(i+1)+"位牌友：");
            System.out.println(hand);
        }

        System.out.println("剩下的牌：");
        System.out.println(ret);
    }
}
