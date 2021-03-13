import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Main implements ActionListener {
    Artist artist;
    Pitboss pitboss;

    public void myMain(String args[]) {
        artist = new Artist( this );
        pitboss = new Pitboss( artist );
        pitboss.start();
    }

    public static void main(String args[]) {
        Main main = new Main();
        main.myMain( args );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source.getClass() == CardButton.class) {

            CardButton cardButton = (CardButton) source;
            Card card = cardButton.getCard();
            pitboss.selectedCard( card );
        } else if (source.getClass() == JButton.class) {
            JButton button = (JButton) source;
            String name = button.getActionCommand();
            System.out.println( name );
            switch (name) {
                case "I would like to play":
                    pitboss.iWouldLikeToPlay();
                default:

            }
            artist.closeStartFrame();
        }
    }
}
