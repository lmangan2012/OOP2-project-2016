import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dvd extends JFrame {

    public static void main (String [] args) {
       	dvd mine = new dvd();
        mine.setVisible(true);
    }

    public dvd () {
        this.setTitle ("DVD Main Menu");
        this.setSize (500, 500);

        setDefaultCloseOperation( EXIT_ON_CLOSE );
        Container contentPane = getContentPane();
    }
}