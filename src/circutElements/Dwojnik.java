package circutElements;

import java.awt.*;

public class Dwojnik extends Rectangle implements Runnable{
    private int x, y, width, height;
    private boolean focus = false;

    public Dwojnik(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move(int direction, int value){
        switch (direction){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }

    }

    @Override
    public void run(){
        electricyPassing();
    }

    public void electricyPassing(){

    }

    public void draw(Graphics2D g2d){
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x,y,width,height);
    }

    public void drawVoltage(Graphics2D g2d){
        g2d.setColor(Color.RED);
        g2d.drawString("1.2V", this.x + 4, this.y + 18);
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
    }
}
