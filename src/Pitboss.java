public class Pitboss {

    Game game = new Game();
    Artist artist;
    Table table;
    TimerKeeper timerKeeper;

    public Pitboss(Artist _artist) {

        artist = _artist;
        timerKeeper = new TimerKeeper();

    }

    void start() {
        artist.display( "Welcome to Concentration!", "I would like to play" );

    }

    void iWouldLikeToPlay() {
        table = game.prepareTable( 8 );
        artist.display( table );
        timerKeeper.beginTiming();
    }

    void myNameIs() {

    }

    void iWouldLike(int _pairs) {

    }

    void selectedCard(Card card) {
        game.selectCard( card );
        artist.display();
    }

    void continueGame() {

    }


}
