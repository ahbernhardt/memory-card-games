import java.util.Vector;
import java.util.Collections;

public class Table {
    Vector<Card> cards;
    int numberOfPairs;

    Table() {
        cards = new Vector<Card>( 16 );
    }

    Table(int _numberOfPairs) {
        numberOfPairs = _numberOfPairs;
        cards = new Vector<Card>( numberOfPairs * 2 );
    }

    int getNumberOfPairs() {
        return numberOfPairs;
    }

    Card getCard(int card) {
        return cards.get( card );
    }

    void shuffle() {
        Collections.shuffle( cards );
    }

    void acceptThisCard(Card card) {
        cards.add( card );
        shuffle();
    }

    void selectCard(Card _card) {
        for (Card card : cards)
            if (card.equals( card )) {
                card.flip();
                break;
            }
    }

    void removeCard(Card card) {
        cards.remove( card );
    }
}
