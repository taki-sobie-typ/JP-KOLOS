package ui;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(int width, int height){
        this.setSize(width, height);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        Canva canva = new Canva();
        this.add(canva, BorderLayout.CENTER);
        new Thread(canva).start();

        MyPanel myPanel = new MyPanel(canva);
        this.add(myPanel, BorderLayout.SOUTH);
    }
}
