import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

  Handler handler;

  public KeyInput(Handler handler){
    this.handler = handler;
  }

  public void keyPressed(KeyEvent e){
    int key = e.getKeyCode();
    if(key == KeyEvent.VK_W) handler.setKey(0, Key.UP);
    if(key == KeyEvent.VK_A) handler.setKey(1, Key.UP);
    if(key == KeyEvent.VK_S) handler.setKey(2, Key.UP);
    if(key == KeyEvent.VK_D) handler.setKey(3, Key.UP);
  }

  public void keyReleased(KeyEvent e){
    int key = e.getKeyCode();
    if(key == KeyEvent.VK_W) handler.setKey(0, Key.DOWN);
    if(key == KeyEvent.VK_A) handler.setKey(1, Key.DOWN);
    if(key == KeyEvent.VK_S) handler.setKey(2, Key.DOWN);
    if(key == KeyEvent.VK_D) handler.setKey(3, Key.DOWN);
  }
}
