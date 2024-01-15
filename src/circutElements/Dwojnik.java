package circutElements;

import java.awt.*;

public class Dwojnik implements Runnable{
    private int x, y, width, height;

    public Dwojnik(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void run(){

    }

    public void draw(Graphics2D g2d){
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x,y,width,height);
    }

}
