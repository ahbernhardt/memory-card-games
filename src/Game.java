public class Game {

    Table table;
    Deck deck;
    Card select1;
    Card select2;

    public Game() {
        deck = new Deck();
        select1 = null;
        select2 = null;
    }

    Table prepareTable(int pairs) {

        int total = pairs;
        int suit = 0;
        table = new Table( pairs );

        for (int value = 0; value < total; value++) {
            Card card = deck.getCard( suit, value + 1 );
            table.acceptThisCard( card );
            suit = (suit + 1) % 4;
            card = deck.getCard( suit, value + 1 );
            suit = (suit + 1) % 4;
            table.acceptThisCard( card );
        }
        table.shuffle();
        return table;

    }

    void selectCard(Card card) {
        if (select1 == null)
            select1 = card;
        else
            select2 = card;
        card.flip();
    }

    boolean checkMatch() {
        boolean retVal = false;
        if (select1 != null && select2 != null) {
            if (select1.getValue() == select2.getValue())
                retVal = true;
            select1 = null;
            select2 = null;
        }

        return retVal;
    }

    Table updateTable(Card _card) {
        return table;
    }
}
