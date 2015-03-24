import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyListenerTutorial extends Applet implements KeyListener{
	private Rectangle rect;
	private ArrayList<Integer> keyDown;
	
	public void init()
	{
		this.addKeyListener(this);
		
		keyDown = new ArrayList<Integer>();
		rect = new Rectangle(0, 0, 50, 50);
	}
	
	public void paint(Graphics g)
	{
		setSize(500,500);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.fill(rect);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!keyDown.contains(e.getKeyCode()))
			keyDown.add(new Integer(e.getKeyCode()));
		
		moveRect();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyDown.remove(new Integer(e.getKeyCode()));
	}
	
	public void moveRect()
	{
		int x = rect.x;
		int y = rect.y;
		
		if(keyDown.contains(KeyEvent.VK_UP))
			y -= 2;
		if(keyDown.contains(KeyEvent.VK_DOWN))
			y += 2;
		if(keyDown.contains(KeyEvent.VK_LEFT))
			x -= 2;
		if(keyDown.contains(KeyEvent.VK_RIGHT))
			x += 2;
		
		rect.setLocation(x,y);
		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
