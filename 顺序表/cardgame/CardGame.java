package cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardGame {

    public static final String[] suits = {"♥", "♦", "♠", "♣"};

    /**
     * 生成一副牌
     * 生成52张牌 不包含大小王
     *
     * @return
     */
    public List<Card> buyCard() {
        List<Card> cardList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card card = new Card(suits[i], j + 1);
                cardList.add(card);
            }
        }

        return cardList;
    }


    /**
     * 洗牌
     */
    public void shuffle(List<Card> cardList) {
        Random random = new Random();
        for (int i = cardList.size() - 1; i > 0; i--) {
            int index = random.nextInt(i);
            swap(cardList, i, index);
        }

    }

    private static void swap(List<Card> cardList, int i, int j) {
        Card temp = cardList.get(i);
        cardList.set(i, cardList.get(j));
        cardList.set(j, temp);
    }

    /**
     * 发牌
     * 3个人轮流揭5张牌
     *
     * @param cardList
     */
    public List<List<Card>> getCard(List<Card> cardList) {
        List<List<Card>> gamerList = new ArrayList<>();
        List<Card> hand1 = new ArrayList<>();
        List<Card> hand2 = new ArrayList<>();
        List<Card> hand3 = new ArrayList<>();
        gamerList.add(hand1);
        gamerList.add(hand2);
        gamerList.add(hand3);

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 3; j++) {
                Card card = cardList.remove(0);
                gamerList.get(j).add(card);
            }

        }
        return gamerList;
    }
}
