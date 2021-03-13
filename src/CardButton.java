import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CardButton extends JButton {
    String tag = "";
    Card card = null;

    public CardButton(ImageIcon imageIcon) {
        super( imageIcon );
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}
