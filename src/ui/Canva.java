package ui;

import circutElements.Dwojnik;
import circutElements.Wire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Canva extends JPanel implements Runnable{
    private ArrayList<Dwojnik> dwojnikArrayList = new ArrayList<>();
    private ArrayList<Wire> wireArrayList = new ArrayList<>();
    Canva(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){


            }
        });

    }
    @Override
    public void run(){


    }

    public void addDwojnik(){
        Dwojnik dwojnik = new Dwojnik(0,0,80,30);
        dwojnikArrayList.add(dwojnik);
        new Thread(dwojnik).start();
    }


    public void addWire(ArrayList<Point> points){
        wireArrayList.add(new Wire(points.get(0), points.get(1)));
    }

    @Override
    public void paintComponent(Graphics gPlain){
        Graphics2D g2d = (Graphics2D) gPlain;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0,0,this.getWidth(),this.getHeight());

        g2d.setStroke(new BasicStroke(20));
        g2d.setColor(Color.GREEN);
        g2d.drawLine(0,0,0,this.getHeight());
        g2d.drawLine(this.getWidth(),0,this.getWidth(),this.getHeight());

        for(Dwojnik dwojnik : dwojnikArrayList){
            dwojnik.draw(g2d);
        }

        for(Wire wire : wireArrayList){
            wire.draw(g2d);
        }
    }
}
