package Card;

public class Card {
    public int rank;
    public String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Card)) {
            return false;
        }
        Card c = (Card)o;
        return this.rank == c.rank
                && this.suit.equals(c.suit) ;
    }

    public static void main(String[] args) {
        Card card1 = new Card(5, "♦️");
        Card card2 = new Card(5, "♥️");
        Card c = card1;

        card1.equals(card2); // true
        card1.equals(c);   //true
    }
}


