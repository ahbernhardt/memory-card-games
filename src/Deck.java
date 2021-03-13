import java.util.Random;
import java.util.Vector;

public class Deck {
    Vector<Card> cards;
    public static final int standardSize = 52;

    public Deck() {
        cards = new Vector( standardSize );

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 13; j++) {
                Card card = new Card( i, j );
                addCard( card );
            }
    }

    public Card getCard() {
        Random objGenerator = new Random();
        int suite = objGenerator.nextInt() % 4;
        int value = objGenerator.nextInt() % 13;
        return getCard( suite, value );
    }

    public Card getCard(int suit, int value) {
        for (Card card : cards) {
            if (card.getSuit() == suit && card.getValue() == value)
                return card;
        }
        return null;
    }

    void addCard(Card _card) {
        cards.add( _card );
    }

    void shuffle() {

    }
}
