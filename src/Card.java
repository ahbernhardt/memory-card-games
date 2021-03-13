import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Card {
    int suit;
    int value;
    Image frontImage;
    Image backImage;
    boolean flippedStatus;

    public enum suites {hearts, clubs, spades, diamonds}

    ;

    public String findValue(int value) {
        String textValue;

        switch (value) {
            case 1:
                textValue = "ace";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                textValue = "" + value;
                break;
            case 11:
                textValue = "jack";
                break;
            case 12:
                textValue = "queen";
                break;
            case 13:
                textValue = "king";
                break;
            default:
                textValue = "error";
        }
        ;
        return textValue;
    }

    public String findSuit(int suite) {
        String textValue;
        switch (suit) {
            case 0:
                textValue = "hearts";
                break;
            case 1:
                textValue = "clubs";
                break;
            case 2:
                textValue = "spades";
                break;
            case 3:
                textValue = "diamonds";
                break;
            default:
                textValue = "error";
        }
        ;
        return textValue;
    }

    public Card(int _suit, int _value) {
        value = _value + 1;
        String textValue;
        String textSuit;
        String filename;

        suit = _suit;

        textSuit = findSuit( suit );
        textValue = findValue( value );

        if (textSuit.matches( "error" ) || textValue.matches( "error" ))
            filename = "src/PNG-cards/blank.png";
        else
            filename = "src/PNG-cards/face_cards/" + textValue + "_of_" + textSuit + ".png";

        try {
            frontImage = ImageIO.read( new File( filename ) );
            frontImage = frontImage.getScaledInstance( 150, 150, java.awt.Image.SCALE_SMOOTH );
            backImage = ImageIO.read( new File( "src/PNG-cards/back_card.png" ) );
            backImage = backImage.getScaledInstance( 150, 150, java.awt.Image.SCALE_SMOOTH );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.out.println( "File not found " + filename );
        }


    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public Image getImage() {
        if (flippedStatus)
            return frontImage;
        else
            return backImage;
    }

    public boolean isFlippedStatus() {
        return flippedStatus;
    }

    Card(int _suit, int _value, Image _image) {
        frontImage = _image;
        try {
            backImage = ImageIO.read( new File( "src/PNG-cards/back_card.png" ) );
            backImage = frontImage.getScaledInstance( 150, 150, java.awt.Image.SCALE_SMOOTH );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        suit = _suit;
        value = _value;
    }

    void flip() {
        flippedStatus = !flippedStatus;
    }

    void faceUp() {
        flippedStatus = false;
    }

    void faceDown() {
        flippedStatus = true;
    }

}
