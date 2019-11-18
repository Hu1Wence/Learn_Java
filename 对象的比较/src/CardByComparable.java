public class CardByComparable implements Comparable<CardByComparable>{
    public int rank;
    public String suit;

    public CardByComparable(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    //我们人为 null 是最小的
    @Override
    public int compareTo(CardByComparable o) {
        if (o == null) {
            return 1;
        }
        return this.rank - o.rank;
    }




    public static void main(String[] args) {
        CardByComparable card1 = new CardByComparable(1, "♦️");
        CardByComparable card2 = new CardByComparable(2, "♥️");
        CardByComparable card3 = new CardByComparable(1, "♦️");

        card1.compareTo(card2); // < 0 表示 card1 比较小
        card1.compareTo(card3); // == 0 表示 相等
        card2.compareTo(card3); // > 0 表示 card2 比较大
    }
}
