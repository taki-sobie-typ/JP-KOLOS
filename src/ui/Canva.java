package ui;

import circutElements.Dwojnik;
import circutElements.Wire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Canva extends JPanel implements Runnable{
    private ArrayList<Dwojnik> dwojnikArrayList = new ArrayList<>();
    private boolean once = false;
    private ArrayList<Wire> wireArrayList = new ArrayList<>();
    Canva(){
        addMouseListener(new MouseAdapter() {
            ArrayList<Point> pointsForWire = new ArrayList<>();

            @Override
            public void mouseClicked(MouseEvent e){
                pointsForWire.add(null);
                pointsForWire.add(null);
                for(Dwojnik dwojnik : dwojnikArrayList){
                    dwojnik.setFocus(dwojnik.contains(e.getPoint()));
                }
                if(pointsForWire.get(0)==null){
                    pointsForWire.set(0, e.getPoint());
                }else {
                    pointsForWire.set(1, e.getPoint());
                    addWire(pointsForWire);
                    pointsForWire.set(0, null);
                    pointsForWire.set(1, null);
                }
            }
        });

        // NEEDS MORE TIME HERE
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_LEFT){
                    //moveResObj(setFocusOn, -20, 0, 0);
                }
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_RIGHT){
                    //moveResObj(setFocusOn, 20, 0, 0);
                }
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_UP){
                    //moveResObj(setFocusOn, 0, -20, 0);
                }
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_DOWN){
                    //moveResObj(setFocusOn, 0, 20, 0);
                }
                return false;
            }
        });

    }
    @Override
    public void run(){
        Timer refreshTimer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        refreshTimer.start();
    }

    public void addDwojnik(){
        Dwojnik dwojnik = new Dwojnik(this.getWidth()/2,this.getHeight()/2,80,30);
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
            for(Wire wire : wireArrayList){
                if(dwojnik.contains(wire.getEndPoint())){
                    dwojnik.drawVoltage(g2d);
                }
                if(dwojnik.contains(wire.getStartPoint())){
                    dwojnik.drawVoltage(g2d);
                }
            }
        }

        for(Wire wire : wireArrayList){
            wire.draw(g2d);
        }
    }
}
