import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Artist implements ActionListener {
    final JPanel compsToExperiment = new JPanel();
    JFrame gameFrame = new JFrame( "Game Frame" );
    ActionListener listener;
    GridLayout grid;
    JFrame startFrame;
    CardButton[] arrayBtn;

    public void closeStartFrame() {
        startFrame.dispose();
    }

    private void updateImages() {
        for (CardButton cardbutton : arrayBtn) {
            Card card = cardbutton.getCard();
            cardbutton.setIcon( (Icon) new ImageIcon( card.getImage() ) );
        }
    }

    public Artist(ActionListener _listener) {
        gameFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        // set the size of the frame
        gameFrame.setSize( 750, 750 );
        grid = null;
        listener = _listener;
    }


    private Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance( resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH );
        return new ImageIcon( resizedImage );
    }

    void display() {
        updateImages();
    }

    void display(String text, String buttonText) {
        JButton[] arrayBtn;

        if (startFrame == null) {
            startFrame = new JFrame( "Concentration Game Directions" );
            startFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            // set the size of the frame
            startFrame.setSize( 350, 350 );

            // set the rows and cols of the grid, as well the distances between them
            GridLayout grid = new GridLayout( 0, 1, 10, 10 );
            // what layout we want to use for our frame
            startFrame.setLayout( grid );

            JLabel label = new JLabel( text );
            JButton button1 = new JButton( buttonText );
            JButton button2 = new JButton( "Exit" );

            //button2.addActionListener(listener);
            button1.addActionListener( listener );


            // add buttons to the frame
            startFrame.add( label );
            startFrame.add( button1 );
            //frame.add(button2);
            startFrame.setVisible( true );
        } else
            updateImages();

    }

    void display(Table table) {
        Image buttonIcon = null;
        int size = table.getNumberOfPairs();
        int columes = (int) Math.sqrt( size * 2 );
        arrayBtn = new CardButton[size * 2];
        if (grid == null) {
            grid = new GridLayout( 0, columes, 10, 10 );
            gameFrame.setLayout( grid );

            for (int i = 0; i < table.getNumberOfPairs() * 2; i++) {
                Card card = table.getCard( i );
                card.faceUp();
                buttonIcon = card.getImage();
                CardButton button = new CardButton( new ImageIcon( buttonIcon ) );
                button.setCard( card );
                button.setBorder( BorderFactory.createEmptyBorder() );
                button.setContentAreaFilled( false );
                gameFrame.add( button );
                arrayBtn[i] = button;
                button.addActionListener( listener );
            }
        }

        gameFrame.setVisible( true );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println( "Hey" );

    }
}
