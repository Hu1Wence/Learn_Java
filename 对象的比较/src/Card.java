import java.util.Comparator;

public class Card implements Comparable<Card>{
    public int rank;
    public String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    //我们人为 null 是最小的
    @Override
    public int compareTo(Card o) {
        if (o == null) {
            return 1;
        }
        return this.rank - o.rank;
    }




    public static void main(String[] args) {
        Card card1 = new Card(1, "♦️");
        Card card2 = new Card(2, "♥️");
        Card card3 = new Card(1, "♦️");

        Comparator<Card> comparator = new CardComparator();
        comparator.compare(card1, card2); // = 0，表示 牌大小相等
        comparator.compare(card1, card3); // < 0，表示 card1 比较小
        comparator.compare(card2, card3); // > 0，表示 card1 比较大

    }
}
class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            // o2 一定不是 null
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.rank - o2.rank;
    }
}
