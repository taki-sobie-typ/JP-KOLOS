package ui;

import javax.swing.*;
import java.awt.*;

public class Canva extends JPanel implements Runnable{
    Canva(){

    }
    @Override
    public void run(){

    }

    @Override
    public void paintComponent(Graphics gPlain){
        Graphics2D g2d = (Graphics2D) gPlain;
        g2d.fillRect(0,0,this.getWidth(),this.getHeight());

    }
}
