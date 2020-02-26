import java.awt.*;
import java.awt.geom.*;

public class Square extends GameObject {

  public int w,h;
  public double angle = -Math.PI/3;
  public int m = 100;
  public int cx,cy;

  public Square(int x, int y){
    super(x, y);
    w = 50;
    h = 50;
  }

  public void tick(){
    cx = (int)(x+w/2);
    cy = (int)(y+h/2);

    if(Handler.getKey(0)==Key.UP && m<200){
      m+=2;
    } else if(Handler.getKey(2)==Key.UP && m>50){
      m-=2;
    }

    if(Handler.getKey(1)==Key.UP){
      angle+=-Math.PI/90;
    } else if(Handler.getKey(3)==Key.UP){
      angle+=Math.PI/90;
    }
  }

  public void render(Graphics g){
    Graphics2D g2d = (Graphics2D)g;
    Path2D s = new Path2D.Double();
    s.moveTo(cx, cy);
    s.curveTo(cx, cy, cx+(Math.cos(angle)*m)/2, cy+Math.sin(angle)*m, cx+(Math.cos(angle)*m), cy);
    g.setColor(new Color(50, 50, 50));
    g.fillRect(getX(), getY(), w, h);
    g.setColor(Color.RED);
    g.drawLine((int)(cx), (int)(cy), (int)(cx+Math.cos(angle)*m), (int)(cy+Math.sin(angle)*m));
    g.setColor(Color.GRAY);
    g.drawLine(cx, cy, (int)(cx+Math.cos(angle)*m), cy);
    g.drawLine(cx, cy, cx, (int)(cy+Math.sin(angle)*m));
    g2d.setColor(Color.PINK);
    g2d.draw(s);
  }

  public Rectangle getBounds(){
    return new Rectangle(getX(), getY(), w, h);
  }

}
