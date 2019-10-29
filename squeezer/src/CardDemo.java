import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card {
    public String suit;
    public String rank;

    @Override
    public String toString() {
        return "[" + suit + " " + rank + "]";
    }
}

public class CardDemo {

    public static String[] SUITS = {"♥️", "♦️", "♣️", "♠️"};
    public static String[] RANKS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                                    "J", "Q", "K"};
    public static List<Card> buyCard() {
        List<Card> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                String suit = SUITS[i];
                String rank = RANKS[j];
                Card card = new Card();
                card.suit = suit;
                card.rank = rank;
                list.add(card);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Card> list = buyCard();
        System.out.println("刚买回来的牌:");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println("洗过之后的牌:");
        System.out.println(list);

        //三人轮流抽牌,每人一共抽5张
        List<List<Card>> player = new ArrayList<>();
        player.add(new ArrayList<>());
        player.add(new ArrayList<>());
        player.add(new ArrayList<>());

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                player.get(j).add(list.remove(0));
            }
        }

        System.out.println("玩家1的手牌:");
        System.out.println(player.get(0));
        System.out.println("玩家2的手牌:");
        System.out.println(player.get(1));
        System.out.println("玩家3的手牌:");
        System.out.println(player.get(2));
        System.out.println("剩余的牌:");
        System.out.println(list);
    }
}