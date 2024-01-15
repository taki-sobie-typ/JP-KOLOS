package circutElements;

import java.awt.*;

public class Wire implements Runnable{
    private Point startPoint, endPoint;

    public Wire(Point startPoint, Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public void run(){
        electricyPassing();
    }

    public void electricyPassing(){

    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void draw(Graphics2D g2d){
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.BLUE);

        g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }
}
